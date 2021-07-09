import java.util.ArrayList;

public class csvVisitor extends READBaseVisitor<String> {

   boolean isFirstLine = true;
   boolean isSecondLine = false;
   ArrayList<String> columnsName = new ArrayList<>();
   ArrayList<String> columnsType = new ArrayList<>();
   Object[] line;
   int nColumns = 0;
   Table table;


   @Override public String visitLine(READParser.LineContext ctx) {
      // get columns name in first line
      if(isFirstLine){
         for(int i = 0; i < ctx.field().size(); i++){
            if(ctx.field(i) != null){
               visit(ctx.field(i));
            }
         }
         isFirstLine = false;
         isSecondLine = true;
         return "isFirstLine";
      // get columns types in first line
      } else if(isSecondLine){
         for(int i = 0; i < ctx.field().size(); i++){
            if(ctx.field(i) != null){
               visit(ctx.field(i));
            }
         }
         if(table == null){
            String[] c = new String[columnsName.size()*2];
            for(int i = 0; i < columnsName.size(); i++){
               c[2*i] = columnsType.get(i);
               c[(2*i)+1] = columnsName.get(i);
            }
            table = new Table("table", false, c);
         }
         line = new Object[columnsName.size()];
         isSecondLine = false;
         return "isSecondLine";
      // get the column values
      } else {
         if(ctx.field().size() == columnsName.size()){
            return visitChildren(ctx);
         } else {
            System.err.println("ERROR: Size of line diferent of table");
            System.exit(-1);
         }
         
      }
      return visitChildren(ctx);
   }

   @Override public String visitFieldText(READParser.FieldTextContext ctx) {
      if(isFirstLine){
         columnsName.add(ctx.TEXT().getText().trim());
      } else if(isSecondLine){
         columnsType.add("TEXT");
      } else {
         if(columnsType.get(nColumns) == "TEXT"){
            line[nColumns] = ctx.TEXT().getText().trim();
            if(nColumns == columnsName.size() - 1){
               table.addLin(line);
            }
            nColumns = nColumns == columnsName.size() - 1 ? 0 : nColumns+1;
         } else {
            System.err.println("ERROR: Type mismatch");
         }
      }
      return ctx.TEXT().getText();
   }

   @Override public String visitFieldString(READParser.FieldStringContext ctx) {
      if(isFirstLine){
         columnsName.add(ctx.STRING().getText().trim());
      } else if(isSecondLine){
            columnsType.add("TEXT");
      } else {
         if(columnsType.get(nColumns) == "TEXT"){
            line[nColumns] = ctx.STRING().getText().trim();
            if(nColumns == columnsName.size() - 1){
               table.addLin(line);
            }
            nColumns = nColumns == columnsName.size() - 1 ? 0 : nColumns+1;
         } else {
            System.err.println("ERROR: Type mismatch");
         }
      }
      return visitChildren(ctx);
   }

   @Override public String visitFieldInt(READParser.FieldIntContext ctx) {
      if(isFirstLine){
         columnsName.add(ctx.INT().getText().trim());
      } else if(isSecondLine){
         columnsType.add("NUMERIC_INT");
      } else {
         if(columnsType.get(nColumns) == "NUMERIC_INT"){
            line[nColumns] = Integer.parseInt(ctx.INT().getText().trim());
            if(nColumns == columnsName.size() - 1){
               table.addLin(line);
            }
            nColumns = nColumns == columnsName.size() - 1 ? 0 : nColumns+1;
         } else {
            System.err.println("ERROR: Type mismatch");
         }
      }
      return visitChildren(ctx);
   }

   @Override public String visitFieldReal(READParser.FieldRealContext ctx) {
      if(isFirstLine){
         columnsName.add(ctx.REAL().getText().trim());
      } else if(isSecondLine){
         columnsType.add("NUMERIC_REAL");
      } else {
         if(columnsType.get(nColumns) == "NUMERIC_REAL"){
            line[nColumns] = Double.parseDouble(ctx.REAL().getText().trim());
            if(nColumns == columnsName.size() - 1){
               table.addLin(line);
            }
            nColumns = nColumns == columnsName.size() - 1 ? 0 : nColumns+1;
         } else {
            System.err.println("ERROR: Type mismatch");
         }
      }
      return visitChildren(ctx);
   }

   @Override public String visitFieldEmpty(READParser.FieldEmptyContext ctx) {
      System.err.println("ERROR: Name of column is empty");
      System.exit(-1);
      return visitChildren(ctx);
   }
}

