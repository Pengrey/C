import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Vector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Table {
	private Vector<Column> cols;
	private String name;
	private boolean isTemplate = false;
	private int length;
	private String tempName;

	public Table(String name) {
		this.cols = new Vector<Column>();
		this.name = name;
		this.tempName = name;
		this.length = 0;
	}

	public Table(String name, boolean isTemplate, String... columns) {
		this.cols = new Vector<Column>();
		this.name = name;
		this.isTemplate = isTemplate;
		// Create cols and add them to the table Vector of columns
		for (int i = 0; i < columns.length; i += 2) {
			Column col = new Column(columns[i + 1], columns[i]);
			this.cols.add(col);
		}
		this.length = 0;
	}

	public boolean addCol(Column newCol) {
		// Check if we are trying to add information to a template
		if (this.isTemplate && newCol.getVector().size() != 0) {
			System.err.println("ERROR: Cannot add data to Template.");
			return false;
		}
		// Check if number of elements between new column and number of lines are
		// compatible, if the table is empty we ignore this check
		if (this.cols.size() == 0 || (newCol.getVector().size() == (this.cols.get(0)).getVector().size())) {
			// Check if we already have a column with the same name
			for (Column col : this.cols)
				if (col.getName() == newCol.getName()) {
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

	public boolean addLin(Object[] line) {
		// Check if we are trying to add information to a template
		if (this.isTemplate) {
			System.err.println("ERROR: Cannot add data to Template.");
			return false;
		}
		// Check if number of elements between new line and number of columns are
		// compatible, if the table is empty we ignore this check
		if (line.length == this.cols.size()) {
			int index = 0;
			// Set new values
			for (Column col : this.cols) {
				Object data = line[index];
				Types type = Types.UNKNOWN;
				// Get type of the data being added
				if (data instanceof Integer || data instanceof Short || data instanceof Byte || data instanceof Long) {
					type = Types.NUMERIC_INT;
				} else if (data instanceof Float || data instanceof Double) {
					type = Types.NUMERIC_REAL;
				} else if (data instanceof String || data instanceof Character) {
					type = Types.TEXT;
				}

				// Verify type of the data being added
				if (col.getType() != type) {
					// Remove the previous values we setted
					for (int i = index - 1; i >= 0; i--) {
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

	public Column getCol(String name) {
		// Check if we are trying to get information of a template
		if (this.isTemplate) {
			System.err.println("ERROR: templates have no data.");
			return null;
		}
		// Iteration through the cols vector to get the column with the specific name,
		// if not we return Null
		for (Column col : this.cols) {
			if (col.getName().equals(name))
				return col;
		}
		return null;
	}

	public Object[] getLin(Integer index) {
		// Check if we are trying to get information of a template
		if (this.isTemplate) {
			System.err.println("ERROR: templates have no data.");
			return null;
		}
		// Create Object array that represents the line we want
		Object[] line = new Object[this.cols.size()];

		// Copy that line for the array we are going to give back
		for (int i = 0; i < this.cols.size(); i++) {
			line[i] = (this.cols.get(i)).getVector().get(index);
		}
		return line;
	}

	public boolean rmCol(String name) {
		// Get the column with the same name and removes it
		for (Column col : this.cols)
			if (col.getName() == name) {
				this.cols.remove(col);
				break;
			}
		return false;
	}

	public boolean rmLin(int index) {
		// Check if we are trying remove a line from a template
		if (this.isTemplate) {
			System.err.println("ERROR: templates have no data.");
			return false;
		}

		// Get the line with the same index and removes it
		for (Column col : this.cols)
			col.getVector().remove(index);
		this.length--;
		return true;
	}

	public boolean rmData(String columnName, int lineIndex) {
		// Check if we are trying remove a line from a template
		if (this.isTemplate) {
			System.err.println("ERROR: templates have no data.");
			return false;
		}

		// Get the line with the same index and removes it
		for (Column col : this.cols)
			if (col.getName().equals(columnName)) {
				if (col.getVector().size() < lineIndex + 1) {
					System.err.println("ERROR: Index out of bounds.");
					return false;
				}
				Types type = col.getType();
				if (type == Types.NUMERIC_INT) {
					col.getVector().remove(lineIndex);
					col.getVector().add(0);
					return true;
				} else if (type == Types.NUMERIC_REAL) {
					col.getVector().remove(lineIndex);
					col.getVector().add(0.0);
					return true;
				} else if (type == Types.TEXT) {
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

	public boolean applyTemplate(Table table) {
		// Check if we are trying remove a line from a template
		if (!this.isTemplate) {
			System.err.println("ERROR: Cannot create templates from non template types.");
			return false;
		}

		// Add columns from the template to the new table
		for (Column col : this.cols) {
			// Create new column with the same specs
			Column newCol = new Column(col.getName(), col.getType());
			table.cols.add(newCol);
		}
		table.setTemp(this.name);
		return true;
	}

	@Override
	public String toString() {
		String result = "";
		// Get number of colums
		int numCol = this.cols.size();

		// Get number of lines
		int numLin = 0;
		if (numCol != 0) {
			numLin = ((Column) this.cols.get(0)).getVector().size();
		}

		// Print column names
		result += this.name + "\n";
		for (Column col : this.cols)
			result += String.format("%-30s", col.getName());
		result += "\n";

		// For each line we print the values of each column
		for (int i = 0; i < numLin; i++) {
			for (Column col : this.cols) {
				result += String.format("%-30s", col.getVector().get(i));
			}
			result += "\n"; // Line break
		}
		result += "\n"; // Line break to seperate tables from the rest
		return result;
	}

	public Vector<Column> getCols() {
		return this.cols;
	}

	// returns two tables joined
	public Table join(Table t2) {// para utilizar: Table t3=t1.join(t2);
		Table res = new Table("res");
		Vector<Column> cols1 = this.cols;
		Vector<Column> cols2 = t2.getCols();
		if (this.getTemp().equals(t2.getTemp())) {
			res.setTemp(this.getTemp()); 
			for (int i = 0; i < cols1.size(); i++) {
				if (cols1.get(i).getName().equals(cols2.get(i).getName())) {
					Column temp = new Column(cols1.get(i).getName(), cols1.get(i).getType());
					Vector<Object> temp1 = temp.getVector(); // vect de destino
					temp1.addAll(cols1.get(i).getVector());
					temp1.addAll(cols2.get(i).getVector());
					res.addCol(temp);
				}
			}
		} else {// procurar tabelas com msm nome
			boolean hasEqualCols = false;
			for (int i = 0; i < cols1.size(); i++) {
				for (int j = 0; j < cols2.size(); j++) {
					if (cols1.get(i).getName().equals(cols2.get(j).getName())) {
						hasEqualCols = true;
						break;
					}
				}
			}
			if (hasEqualCols) {
				System.err.println("ERROR: Cannot join tables, they have at least an equal column.");
				System.exit(1);
			} else {
				res = joinDifferentTables(this, t2);
			}
		}
		return res;
	}

	// returs two completely different tables joined
	public Table joinDifferentTables(Table t1, Table t2) {
		Table res = new Table("res");
		Vector<Column> cols1 = t1.getCols();
		Vector<Column> cols2 = t2.getCols();
		for (int i = 0; i < cols1.size(); i++) {
			res.addCol(new Column(cols1.get(i).getName(), cols1.get(i).getType()));
		}
		for (int i = 0; i < cols2.size(); i++) {
			res.addCol(new Column(cols2.get(i).getName(), cols2.get(i).getType()));
		}
		int numcols = res.getCols().size();
		int lencols1 = cols1.get(0).getVector().size();
		int lencols2 = cols2.get(0).getVector().size();
		for (int i = 0; i < lencols1; i++) {
			Object[] temp = new Object[numcols];
			Object[] a = t1.getLin(i);
			for (int j = 0; j < a.length; j++) {
				temp[j] = a[j];
			}
			for (int j = a.length; j < numcols; j++) {
				temp[j] = getDefault(res.getCols().get(j).getType());
			}
			res.addLin(temp);
		}
		for (int i = 0; i < lencols2; i++) {
			Object[] temp = new Object[numcols];
			Object[] a = t2.getLin(i);
			for (int j = 0; j < numcols - a.length; j++) {
				temp[j] = getDefault(res.getCols().get(j).getType());

			}
			for (int j = numcols - a.length; j < numcols; j++) {
				temp[j] = a[(j - (numcols - a.length))];
			}
			res.addLin(temp);
		}
		return res;
		// TODO
	}

	// returns the default value of a type
	public Object getDefault(Types type) {
		Object ret;
		if (type == Types.NUMERIC_INT || type == Types.NUMERIC_REAL) {
			ret = 0;
		} else {
			ret = "";
		}
		return ret;
	}

	// join 2 tables by one column
	public Table joinOn(Table t2, String col1, String col2) {
		Table res = new Table("res");
		Vector<Column> cols1 = this.cols;
		Vector<Column> cols2 = t2.getCols();
		int colt1 = 0;
		int colt2 = 0;
		Types type1 = null;
		Types type2 = null;
		for (int i = 0; i < cols1.size(); i++) { // encontrar idx da coluna correspondente � que procuramos
			if (cols1.get(i).getName().equals(col1)) {
				colt1 = i;
				type1 = cols1.get(i).getType();
			} else {
				res.addCol(new Column(cols1.get(i).getName(), cols1.get(i).getType()));
			}
		}
		for (int j = 0; j < cols2.size(); j++) {// encontrar idx da coluna correspondente � que procuramos
			if (cols2.get(j).getName().equals(col2)) {
				colt2 = j;
				type2 = cols2.get(j).getType();
			}
			res.addCol(new Column(cols2.get(j).getName(), cols2.get(j).getType()));
		}
		if (type1 == null || type2 == null) {
			System.err.println("ERROR: Cannot find collumn.");
		}

		if (!type1.equals(type2)) {
			System.err.println("ERROR: Cannot join columns of different types.");
		}
		Vector<Object> temp1 = cols1.get(colt1).getVector();
		Vector<Object> temp2 = cols2.get(colt2).getVector();
		ArrayList<Pair> idxs = new ArrayList<Pair>();
		for (int i = 0; i < temp1.size(); i++) {
			for (int j = 0; j < temp2.size(); j++) {
				if (temp1.get(i).equals(temp2.get(j))) {
					idxs.add(new Pair(i, j));
				}
			}
		}
		for (int i = 0; i < idxs.size(); i++) {
			int idx1 = idxs.get(i).getX();
			int idx2 = idxs.get(i).getY();
			ArrayList<Object> temp = new ArrayList<Object>();
			for (int cols = 0; cols < cols1.size(); cols++) {
				if (cols != colt1) {
					Object t = cols1.get(cols).getVector().get(idx1);
					temp.add(t);
				}
			}
			for (int cols = 0; cols < cols2.size(); cols++) {
				Object t = cols2.get(cols).getVector().get(idx2);
				temp.add(t);
			}
			Object[] line = temp.toArray();
			res.addLin(line);
		}
		return res;
	}

	// getTable without where condition
	public Table getNewTable(ArrayList<String> cols) {
		Table res = new Table("res");
		ArrayList<Types> types=new ArrayList<Types>();
		ArrayList<Integer> idxs=new ArrayList<Integer>();
		for(String col:cols) {
			int colidx = 0;
			for (Column column : this.cols) {
				if (column.getName().equals(col)) {
					types.add(column.getType());
					idxs.add(colidx);
					break;
				}
				colidx++;
			}
		}
		if(cols.size()!=idxs.size()) {
			System.err.println("We couldn't find the columns you were looking for.");
			System.exit(0);
		}
		for(int i=0;i<cols.size();i++) {
			Column temp = new Column(cols.get(i), types.get(i));
			Vector<Object> t = this.cols.get(idxs.get(i)).getVector();
			for (int j = 0; j < t.size(); j++) {
					temp.addObj(t.get(j));
			}
			res.addCol(temp);
		}
		return res;
	}

	// getTable with where condition
	public Table getNewTableWhere(ArrayList<String> cols, String whereexpr) {
		ArrayList<Integer> lines=this.checkWhereCondition(whereexpr);
		Table res = new Table("res");
		ArrayList<Types> types=new ArrayList<Types>();
		ArrayList<Integer> idxs=new ArrayList<Integer>();
		for(String col:cols) {
			int colidx = 0;
			for (Column column : this.cols) {
				if (column.getName().equals(col)) {
					types.add(column.getType());
					idxs.add(colidx);
					break;
				}
				colidx++;
			}
		}
		if(cols.size()!=idxs.size()) {
			System.err.println("We couldn't find the columns you were looking for.");
			System.exit(0);
		}
		for(int i=0;i<cols.size();i++) {
			Column temp = new Column(cols.get(i), types.get(i));
			Vector<Object> t = this.cols.get(idxs.get(i)).getVector();
			for (int j = 0; j < t.size(); j++) {
				if (lines.contains(j)) {
					temp.addObj(t.get(j));
				}
			}
			res.addCol(temp);
		}
		return res;
	}

	//Converts Table to CSV file
	public void toCvsFile(String filename) throws IOException {
		BufferedWriter writer = Files.newBufferedWriter(Paths.get(filename));
		//put Column Names
		for (Column col : this.cols)
			if (filename.endsWith(".csv"))
				writer.write(col.getName() + ",");
			else if (filename.endsWith(".txt"))
				writer.write(col.getName() + "\t");
			else
				System.out.println("Could not create file! Usage <"+filename+">.csv or <"+filename+">.txt");
		writer.newLine();
		// put Lines
		for (int i = 0; i < this.cols.get(0).getVector().size(); i++) {
			for (Column col : this.cols)
				if (filename.endsWith("csv"))
					writer.write(col.getVector().get(i) + ",");
				else if (filename.endsWith("txt"))
					writer.write(col.getVector().get(i) + "\t");
			writer.newLine();
		}
		writer.close();
	}




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

        if(condition.length == 3){
			var = condition[0];
			val = condition[2].replace("\"","").trim();
			col = getCol(var);

			String realRegex = "[0-9.]+";
			String intRegex = "[0-9]+";
			String textRegex = "[a-zA-Z_]+";


			// Verificação se a coluna e o valor passado é do mesmo tipo
			if(col.getType() == Types.NUMERIC_INT && !val.matches(intRegex)){
				System.err.println("ERROR: This column is int type.");
				return null;
			} else if(col.getType() == Types.NUMERIC_REAL && !val.matches(realRegex)){
				System.err.println("ERROR: This column is real type.");
				return null;

			} else if(col.getType() == Types.TEXT && !val.matches(textRegex)) {
				System.err.println("ERROR: This column is text type.");
				return null;
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
                }
            } else {
                System.err.println("ERROR: Column doesn't exist.");
				return null;
            }
            return result;
        } else {
            ArrayList<Integer> result1 = new ArrayList<>();
            String expression1 = condition[0] + " " + condition[1] + " " + condition[2];
            result1.addAll(result1.size(), this.checkWhereCondition(expression1));
            boolean isTrue = !this.checkWhereCondition(expression1).isEmpty();

            for (int i = 3; i < condition.length; i += 4) {
                String op1 = condition[i];
                if (op1 != null) {
                    expression1 = condition[i+1]+ " " + condition[i+2] + " " +condition[i+3];
                    if(op1.equals("&&")) {
						ArrayList<Integer> intersection = new ArrayList<>();
						for(int k = 0; k<result1.size(); k++ ) {
							for(int j = 0; j<this.checkWhereCondition(expression1).size(); j++) {
								if(result1.get(k)==this.checkWhereCondition(expression1).get(j)) {
									intersection.add(result1.get(k));
								}
							}
						}
						result1 = intersection;
                        isTrue = isTrue && !result1.isEmpty();
                    } else if (op1.equals("||")){
						result1.addAll(result1.size(), this.checkWhereCondition(expression1));
                        isTrue = isTrue || !this.checkWhereCondition(expression1).isEmpty();
                    }
                } else {
                    System.err.println("ERROR: Error in the expression!");
                    System.exit(1);
                }
            }
            return isTrue ? result1 : new ArrayList<Integer>();
        }
	}

	public ArrayList<Integer> equalOption(Column col, String val) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < col.getVector().size(); i++) {
			if (col.getVector().get(i).toString().equals(val)) {
				result.add(i);
			}
		}
		return result;
	}

	public ArrayList<Integer> notEqualOption(Column col, String val) {
		ArrayList<Integer> result = new ArrayList<Integer>();

		for (int i = 0; i < col.getVector().size(); i++) {
			if (!col.getVector().get(i).toString().equals(val)) {
				result.add(i);
			}
		}
		return result;
	}

	public ArrayList<Integer> biggerEqualOption(Column col, String val) {
		ArrayList<Integer> result = new ArrayList<Integer>();

		if (col.getType() == Types.NUMERIC_REAL || col.getType() == Types.NUMERIC_INT) {
			for (int i = 0; i < col.getVector().size(); i++) {
				if (Double.parseDouble(col.getVector().get(i).toString()) >= Double.parseDouble(val)) {
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

		if (col.getType() == Types.NUMERIC_INT || col.getType() == Types.NUMERIC_REAL) {
			for (int i = 0; i < col.getVector().size(); i++) {
				if (Double.parseDouble(col.getVector().get(i).toString()) <= Double.parseDouble(val)) {
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

		if (col.getType() == Types.NUMERIC_INT || col.getType() == Types.NUMERIC_REAL) {
			for (int i = 0; i < col.getVector().size(); i++) {
				if (Double.parseDouble(col.getVector().get(i).toString()) > Double.parseDouble(val)) {
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

		if (col.getType() == Types.NUMERIC_INT || col.getType() == Types.NUMERIC_REAL) {
			for (int i = 0; i < col.getVector().size(); i++) {
				if (Double.parseDouble(col.getVector().get(i).toString()) < Double.parseDouble(val)) {
					result.add(i);
				}
			}
		} else {
			System.err.println("ERROR: Cannot compare this operation with strings.");
		}
		return result;
	}

	
	// name == "dfghj" || name == "fghjkl" && age > 2

	// Acrescentei aqui umas cenas para mim
	public void setName(String name) {
		this.name = name;
	}

	public void isTemplate(boolean val) {
		this.isTemplate = val;
	}

	public String getTemp() {
		return this.tempName;
	}

	public void setTemp(String tempName) {
		this.tempName = tempName;
	}

    public int getLength() {
		return  this.length;
	}
}
