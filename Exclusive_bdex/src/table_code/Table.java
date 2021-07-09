import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Vector;
import java.util.Arrays;
import java.util.Iterator;

public class Table {
	private Vector <Column> cols;
    private String name;
    private boolean isTemplate = false;
    private int length;

    public Table(String name){
        this.cols = new Vector<Column>();
        this.name = name;
        this.length = 0;
    }
   
    public Table(String name, boolean isTemplate, String... columns){
        this.cols = new Vector<Column>();
        this.name = name;
        this.isTemplate = isTemplate;
        // Create cols and add them to the table Vector of columns
        for(int i = 0; i < columns.length; i+=2){
            Column col = new Column(columns[i+1],columns[i]);
            this.cols.add(col); 
        }
        this.length = 0;
    }

    public boolean addCol(Column newCol){
        // Check if we are trying to add information to a template
        if(this.isTemplate && newCol.getVector().size() !=0){
            System.err.println("ERROR: Cannot add data to Template.");
            return false;
        }
        // Check if number of elements between new column and number of lines are compatible, if the table is empty we ignore this check
        if(this.cols.size() == 0 || (newCol.getVector().size() == (this.cols.get(0)).getVector().size())){
            // Check if we already have a column with the same name
            for (Column col : this.cols)
                if(col.getName() == newCol.getName()){
                    System.err.println("ERROR: Repeated column name.");
                    return false; 
                }

            // If we dont have the previous column then we add the new one
            this.cols.add(newCol);
            return true;
        }
        System.err.println("ERROR: Mismatch of number of elements between table and new column.");
        return false;
    }

    public boolean addLin(Object[] line){
        // Check if we are trying to add information to a template
        if(this.isTemplate){
            System.err.println("ERROR: Cannot add data to Template.");
            return false;
        }
        // Check if number of elements between new line and number of columns are compatible, if the table is empty we ignore this check
        if(line.length == this.cols.size()){
            int index = 0;
            // Set new values
            for (Column col : this.cols){
                Object data = line[index];
                Types type = Types.UNKNOWN;
                // Get type of the data being added
                if(data instanceof Integer || data instanceof Short || data instanceof Byte || data instanceof Long){
                    type = Types.NUMERIC_INT;
                }else if(data instanceof Float || data instanceof Double){
                    type = Types.NUMERIC_REAL;
                }else if(data instanceof String || data instanceof Character){
                    type = Types.TEXT;
                }

                // Verify type of the data being added
                if(col.getType() != type){
                    // Remove the previous values we setted
                    for(int i = index - 1 ; i >= 0 ; i--){
                        col = this.cols.get(i);
                        int last = col.getVector().size() - 1;
                        col.getVector().remove(last);
                    } 
                    System.err.println("ERROR: Mismatch between type of data and type of column.");
                    return false; 
                }
                
                col.getVector().add(data);
                index++;
            }
            this.length++;
            return true;
        }
        System.err.println("ERROR: Mismatch of number of elements between table and new line.");
        return false;
    }

    public Column getCol(String name){
        // Check if we are trying to get information of a template
        if(this.isTemplate){
            System.err.println("ERROR: templates have no data.");
            return null;
        }
        // Iteration through the cols vector to get the column with the specific name, if not we return Null
        for (Column col : this.cols){
            if(col.getName().equals(name))
                return col;
        }
        return null; 
    }

    public Object[] getLin(Integer index){ 
        // Check if we are trying to get information of a template
        if(this.isTemplate){
            System.err.println("ERROR: templates have no data.");
            return null;
        }
        // Create Object array that represents the line we want
        Object[] line = new Object[this.cols.size()];

        //Copy that line for the array we are going to give back
        for (int i = 0 ; i < this.cols.size() ; i++){
            line[i] = (this.cols.get(i)).getVector().get(index);
        }
        return line;
    }

    public boolean rmCol(String name){
        // Get the column with the same name and removes it
        for (Column col : this.cols)
            if(col.getName() == name){ 
                this.cols.remove(col);
                break;
            }
        return false;
    }

    public boolean rmLin(int index){
        // Check if we are trying remove a line from a template
        if(this.isTemplate){
            System.err.println("ERROR: templates have no data.");
            return false;
        }

        // Get the line with the same index and removes it
        for (Column col : this.cols)
            col.getVector().remove(index);
        this.length--;
        return true;
    }

    public boolean rmData(String columnName, int lineIndex){
        // Check if we are trying remove a line from a template
        if(this.isTemplate){
            System.err.println("ERROR: templates have no data.");
            return false;
        }

        // Get the line with the same index and removes it
        for (Column col : this.cols)
            if(col.getName().equals(columnName)){
                if(col.getVector().size() < lineIndex + 1){
                    System.err.println("ERROR: Index out of bounds.");
                    return false;  
                }
                Types type = col.getType();
                if(type == Types.NUMERIC_INT){
                    col.getVector().remove(lineIndex);
                    col.getVector().add(0);
                    return true;
                }else if(type == Types.NUMERIC_REAL){
                    col.getVector().remove(lineIndex);
                    col.getVector().add(0.0);
                    return true;
                }else if(type == Types.TEXT){
                    col.getVector().remove(lineIndex);
                    col.getVector().add("");
                    return true;
                }
                System.err.println("ERROR: Something went wrong.");
                return false;
            }
        System.err.println("ERROR: Column name isnt in the table.");
        return false;
    }

    public boolean applyTemplate(Table table){
        // Check if we are trying remove a line from a template
        if(!this.isTemplate){
            System.err.println("ERROR: Cannot create templates from non template types.");
            return false;
        }

        // Add columns from the template to the new table
        for (Column col : this.cols){
            // Create new column with the same specs
            Column newCol = new Column(col.getName(), col.getType());
            table.cols.add(newCol);
        }
        return true;
    }

    public String toString(){
        String result = "";
        // Get number of colums
        int numCol = this.cols.size();

        // Get number of lines
        int numLin = 0;
        if(numCol != 0){
            numLin = ((Column) this.cols.get(0)).getVector().size();
        }

        // Print column names
        result += this.name + "\n";
        for (Column col : this.cols)
            result += String.format("%-15s", col.getName());
        result += "\n";

        // For each line we print the values of each column
        for(int i = 0 ; i < numLin ; i++){
            for (Column col : this.cols){
                result += String.format("%-15s", col.getVector().get(i));
            }
            result += "\n"; // Line break
        }
        result += "\n"; // Line break to seperate tables from the rest
        return result;
    }
    
    public Vector <Column> getCols(){
    	return this.cols;
    }

    public Table join(Table t2) {// para utilizar: Table t3=t1.join(t2);
    	Table res=new Table("res");
    	Vector <Column> cols1=this.cols;
    	Vector <Column> cols2=t2.getCols();
    	if(cols1.size()!=cols2.size()) {
    		System.err.println("ERROR: Cannot join tables with different lenghts.");
    		return null;
    	}
    	for (int i=0;i<cols1.size();i++) {
    		if(cols1.get(i).getName().equals(cols2.get(i).getName())) {
    			Column temp=new Column(cols1.get(i).getName(),cols1.get(i).getType());
    			Vector<Object> temp1 =temp.getVector(); //vect de destino
    			temp1.addAll(cols1.get(i).getVector());
    			temp1.addAll(cols2.get(i).getVector());
    			res.addCol(temp);
    		}
    	}
    	return res;
    }
    
    //Converts Table to CSV file
    public void toCvsFile() throws IOException {
		BufferedWriter writer = Files.newBufferedWriter(Paths.get(this.name+".csv"));
		//put Column Names
		for (Column col : this.cols)
			writer.write(col.getName()+",");
		writer.newLine();
		//put Lines
		for (int i = 0; i<this.length; i++) {
			for (Column col : this.cols)
				writer.write(col.getVector().get(i) + ",");
			writer.newLine();
		}
		writer.close();
	}
	
/*FROM CSV TO TABLE*/
    //Returns Template and Table created after reading CSV file in an Table array
    public static Table[] fromCsvFile(String file) throws IOException {
		ArrayList<String[]> table = new ArrayList<>();
		table = readCSVfile(file);
		String[] columnNames = getColumnNames(table);
		try {
			String[] columnTypes = getColumnTypes(table);
			String[] columns = getColumns(columnNames, columnTypes);
			Table template = new Table("Template", true,  columns);	//create template of the table
			Table t = new Table("Table");
			template.applyTemplate(t);
			addLines(t, table, columnTypes);
			Table[] output = {template, t};
			return output;
		}catch(Exception e) {
			System.err.println("Table of file needs at least of 1 line");
			System.exit(0);
		}
		return null;
	}

	//Reads CSV file and returns an ArrayList of arrays of String (each represents one line of the CSV table)
	private static ArrayList<String[]> readCSVfile(String file) throws IOException {
		BufferedReader br = Files.newBufferedReader(Paths.get(file));
		String DELIMITER = ",[\\s]*";
		ArrayList<String[]> table = new ArrayList<>();
	    String line;
	    
	    while ((line = br.readLine()) != null) {
	        // convert line into columns
	            String[] columns = line.split(DELIMITER);
	            table.add(columns);
	        }
	        return table;
	    }
	
	//Returns line of CSV file
	private static Object[] getLine(Table t, String[] inpLine, String[] columnTypes) {
		Object[] line = new Object[inpLine.length];	//every line but header line
		for (int col = 0; col<columnTypes.length; col++) {
			if(columnTypes[col]=="Numeric")
					line[col] = Double.parseDouble(inpLine[col]);
				else
					line[col] = inpLine[col];
			}
		return line;
	}
	
	//Adds lines from CSV file to Table
	private static void addLines(Table t, ArrayList<String[]> table, String[] columnTypes) {
		for(int i = 1; i<table.size(); i++) {
			Object[] line = getLine(t,table.get(i), columnTypes);
			t.addLin(line);
		}
	}
	
    //Returns names of columns on an array of Strings
	private static String[] getColumnNames(ArrayList<String[]> table) {
		return table.get(0);		//get columns names
	}
	
	//Returns column types
	private static String[] getColumnTypes(ArrayList<String[]> table) {
		String[] fLine = table.get(1);
		String[] types = new String[fLine.length];
		for (int i=0; i<fLine.length; i++) {
			if(Character.isAlphabetic(fLine[i].charAt(0)))
				types[i] = fLine[i].equalsIgnoreCase("true")||fLine[i].equalsIgnoreCase("false") ? "boolean" : "text";	//Pode não haver boolean
			else if (!Character.isDigit(fLine[i].charAt(0))) 
				types[i] = fLine[i].contains(".") ? "numeric_real" : "numeric_int";
			else
				types[i] = "unknown";
		}
		return types;
		
	}
	
	//Returns all columns of Table
	private static String[] getColumns(String[] columnNames, String[] columnTypes) {
    	int tableSize = columnNames.length;
		String[] str = new String[tableSize*2];
		
		for(int i=0; i<tableSize*2; i++) 
			str[i] = i%2==0 ? columnTypes[(int) Math.floor(i / 2)] : columnNames[(int) Math.floor( i / 2)];
		
		return str;
	}
/*END*/
  
    public ArrayList<Integer> checkWhereCondition(String expression) {
        // WHERE name == 'GHJK'
        // WHERE age > 20
        // WHERE name == 'GHJK' && age < 10
        // WHERE name == 'GHJK' || age < 10
        // WHERE 'ASDFV' IN line
        // ==, !=, >, <, >=, <=, in
        // ||, &&
        // x && y || z
  
        ArrayList<Integer> result = new ArrayList<>();
        String[] condition = expression.split(" ");

        String op = condition[1];
        String var = "";
        String val = "";
        Column col = new Column("");

        if(!op.equals("in")) {
            var = condition[0];
            val = condition[2].replace("\"","");
            col = getCol(var);

            String realRegex = "[0-9.]+";
            String intRegex = "[0-9]+";
            String textRegex = "[a-zA-Z_]+";

            // Verificação se a coluna e o valor passado é do mesmo tipo
            if(col.getType() == Types.NUMERIC_INT && !val.matches(intRegex)){
                System.err.println("ERROR: This column is int type.");
            } else if(col.getType() == Types.NUMERIC_REAL && !val.matches(realRegex)){
                System.err.println("ERROR: This column is real type.");
            // TODO: Verificar se é para manter os valores boolean
            } else if(col.getType() == Types.BOOLEAN && !(val.toLowerCase().equals("true") || val.toLowerCase().equals("false"))) {
                System.err.println("ERROR: This column is boolean type.");
            } else if(col.getType() == Types.TEXT && !val.matches(textRegex)) {
                System.err.println("ERROR: This column is text type.");
            }
        }

        if (col != null) {
            switch(op) {
                case "==":
                    result = equalOption(col, val);
                    break;
                case "!=":
                    result = notEqualOption(col, val);
                    break;
                case ">=":
                    result = biggerEqualOption(col, val);
                    break; 
                case "<=":
                    result = lessEqualOption(col, val);
                    break;
                case ">":
                    result = biggerOption(col, val);
                    break;
                case "<":
                    result = lessOption(col, val);
                    break;
                case "in":
                    result = inOption(expression);
                    // se a lista for vazia é pq não existe
                    break;
            }
        } else {
            System.err.println("ERROR: Column doesn't exist.");
        }
        return result;
    }

    public ArrayList<Integer> equalOption(Column col, String val) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        if (col.getVector().contains(val)) {
            for(int i = 0; i < col.getVector().size(); i++) {
                if(col.getVector().get(i).toString().equals(val)) {
                    result.add(i);
                }
            }
        } else {
            System.err.println("ERROR: Column doesn't have that value.");
        }
        return result;
    }

    public ArrayList<Integer> notEqualOption(Column col, String val) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        for(int i = 0; i < col.getVector().size(); i++) {
            if(!col.getVector().get(i).toString().equals(val)) {
                result.add(i);
            }
        }
        return result;
    }

    public ArrayList<Integer> biggerEqualOption(Column col, String val) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        if(col.getType() == Types.NUMERIC_REAL || col.getType() == Types.NUMERIC_INT){
            for(int i = 0; i < col.getVector().size(); i++) {
                if(Double.parseDouble(col.getVector().get(i).toString()) >= Double.parseDouble(val)) {
                    result.add(i);
                }
            }
        } else {
            System.err.println("ERROR: Cannot compare this operation with strings.");
        }
        return result;
    }

    public ArrayList<Integer> lessEqualOption(Column col, String val) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        if(col.getType() == Types.NUMERIC_INT || col.getType() == Types.NUMERIC_REAL){
            for(int i = 0; i < col.getVector().size(); i++) {
                if(Double.parseDouble(col.getVector().get(i).toString()) <= Double.parseDouble(val)) {
                    result.add(i);
                }
            }
        } else {
            System.err.println("ERROR: Cannot compare this operation with strings.");
        }
        return result;
    }

    public ArrayList<Integer> biggerOption(Column col, String val) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        if(col.getType() == Types.NUMERIC_INT || col.getType() == Types.NUMERIC_REAL){
            for(int i = 0; i < col.getVector().size(); i++) {
                if(Double.parseDouble(col.getVector().get(i).toString()) > Double.parseDouble(val)) {
                    result.add(i);
                }
            }
        } else {
            System.err.println("ERROR: Cannot compare this operation with strings.");
        }
        return result;
    }

    public ArrayList<Integer> lessOption(Column col, String val) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        if(col.getType() == Types.NUMERIC_INT || col.getType() == Types.NUMERIC_REAL){
            for(int i = 0; i < col.getVector().size(); i++) {
                if(Double.parseDouble(col.getVector().get(i).toString()) < Double.parseDouble(val)) {
                    result.add(i);
                }
            }
        } else {
            System.err.println("ERROR: Cannot compare this operation with strings.");
        }
        return result;
    }

    public ArrayList<Integer> inOption(String expression) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        String[] s = expression.replace("\"","").split(" in ");
        String[] lineValues = s[1].substring(1,s[1].length()-1).replace(" ", "").split(",");
        // percorrer colunas 
        // verificar se alguma linha contem valor correspondente, guardar indices das linhas
        // verificar para esses indices se os valores seguintes correspondem
        for(int j = 0; j < this.cols.size(); j++){
            if(j == 0){     // se for a primeira vez
                for(int i = 0; i < this.cols.get(j).getVector().size(); i ++){
                    if(this.cols.get(j).getVector().get(i).equals(lineValues[j])){
                        result.add(i);
                    }
                }
            } else {        
                Iterator itr = result.iterator();
                while (itr.hasNext())
                {
                    int x = (Integer)itr.next();
                    if (!this.cols.get(j).getVector().get(x).toString().equals(lineValues[j]))
                        itr.remove();
                }
            }
        }
        // se result tiver algum indice, linha existe e podemos verificar se o valor esta contido na linha
        if(!Arrays.asList(lineValues).contains(s[0])){
            return new ArrayList<Integer>();
        }
        return result;
    }

    // name  == "dfghj" || name == "fghjkl" && age > 2
}
