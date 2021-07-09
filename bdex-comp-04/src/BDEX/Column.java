import java.util.Vector;

public class Column {
	private Vector <Object> col;
    private String name;
    private Types type;
    private String tableName;

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
        if(type==Types.TEXT && !(obj instanceof String) || type==Types.NUMERIC_INT && !(obj instanceof Integer) || type==Types.NUMERIC_REAL && !(obj instanceof Double)) return false;
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

    public String getTName(){
        return this.tableName;
    }
    public void setTName(String name){
        this.tableName=name;
    }

    @Override
    public String toString(){
        return this.col.toString();
    }
}
