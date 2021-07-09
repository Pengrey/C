import java.util.Vector;

public class Column {
	private Vector <Object> col;
    private String name;
    private Types type;

    public Column(String name){
        col = new Vector<Object>();
        this.name = name;
    }
    public Column(String name, Types type){
        col = new Vector<Object>();
        this.name = name;
        this.type = type;
    }

    public Column(String name, String type){
        col = new Vector<Object>();
        this.name = name;
        if(type.toUpperCase().equals("TEXT")){
            this.type = Types.TEXT;
        }else 
        if(type.toUpperCase().equals("NUMERIC")){
            this.type = Types.NUMERIC;
        }else
        if(type.toUpperCase().equals("NUMERIC_INT")){
            this.type = Types.NUMERIC_INT;
        }else
        if(type.toUpperCase().equals("NUMERIC_REAL")){
            this.type = Types.NUMERIC_REAL;
        }else{
            System.err.println("Type undefinned.");
        }
    }

    public boolean addObj(Object obj){
        if(obj instanceof  Column) return false;
        col.add(obj);
        return true;
    }

    public String getName(){
        return this.name;
    }

    public Types getType(){
        return this.type;
    }

    public Vector<Object> getVector(){
        return this.col;
    }
}
