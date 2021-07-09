import java.util.HashMap;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;
import java.lang.Math;
import java.io.IOException;

/*
   TODO: Arranjar maneira de colar valor inteiros em variaveis reais                            DONE
   TODO: Expr arit para inteiros, string e colunas (criar tabela nova com essa diferença)       DONE
   TODO: predicados (String que pode ser usado no where)                                        DONE
   TODO: TABLE = TABLE + somenthing                                                             DONE
*/

public class BDEXvis extends BDEXBaseVisitor<Object> {

	HashMap<String, String> varType = new HashMap<String, String>();
	HashMap<String, Object> varValue = new HashMap<String, Object>();
	HashMap<String, ArrayList<Object>> varLine = new HashMap<String, ArrayList<Object>>();
	HashMap<String, Table> varTable = new HashMap<String, Table>();
	// HashMap<String, ArrayList<Object>> varLine = new HashMap<String,
	// ArrayList<Object>>();

	@Override
	public Object visitExprCreate(BDEXParser.ExprCreateContext ctx) {
		String tempName = ctx.WORD().getText();
		if (varType.containsKey(tempName) && varType.get(tempName).equals("TEMPLATE")) {
			Table t = new Table(tempName);
			Table template = varTable.get(tempName);

			if (template.applyTemplate(t)) {
				t.setTemp(tempName);
				return t;
			} else
				System.exit(1);
		} else {
			System.err.println("O template \"" + tempName + "\" não existe");
			System.exit(1);
		}
		return null;
	}

	@Override
	public Object visitExprWhere(BDEXParser.ExprWhereContext ctx) {
		String tName = ctx.WORD().getText();
		if (varType.containsKey(tName) && varType.get(tName).equals("TABLE")) {
			Table t = varTable.get(tName);
			Table newT = new Table(tName);

			if (varTable.get(t.getTemp()).applyTemplate(newT)) {
				String expression = String.valueOf(visit(ctx.where()));
				for (int idx : t.checkWhereCondition(expression)) {
					newT.addLin(t.getLin(idx));
				}
				return newT;
			} else
				System.exit(1);
		} else {
			System.err.println("O template \"" + tName + "\" não existe");
			System.exit(1);
		}
		return null;
	}

	

	@Override
	public Object visitExprGet(BDEXParser.ExprGetContext ctx) {
		String t_name = ctx.WORD(0).getText();
		Table source=null;
		Table res=null;
		if (varTable.containsKey(t_name)) {
			source = varTable.get(t_name);
		} else {
			System.err.println("Nao existe tabela com o nome "+ t_name);
			System.exit(1);
		}
		ArrayList<String> cols=new ArrayList<String>();
		int idx=1;
		while(ctx.WORD(idx) != null) {
			cols.add(ctx.WORD(idx).getText());
			idx++;
		}
		if (ctx.where() != null) {
			String whereexpr = (String) visit(ctx.where());
			res = source.getNewTableWhere(cols, whereexpr); // TODO
		} else
			res = source.getNewTable(cols); // TODO
		return res;
	}

  @Override public Object visitExprJoinOn(BDEXParser.ExprJoinOnContext ctx) {
		   String t1=ctx.WORD(0).getText();
		   String t2=ctx.WORD(1).getText();
		   Table table1=varTable.get(t1);
		   Table table2=varTable.get(t2);
		   String col1=ctx.WORD(2).getText();
		   String col2=ctx.WORD(3).getText();
		   Table temp=table1.joinOn(table2,col1,col2); //tenho que voltar a fazer o codigo do joinOn
	      return temp;
  }

  @Override public Object visitExprJoin(BDEXParser.ExprJoinContext ctx) {
		   String t1=ctx.WORD(0).getText();
		   String t2=ctx.WORD(1).getText();
		   Table table1=varTable.get(t1);
		   Table table2=varTable.get(t2);
		   Table temp=table1.join(table2);
	      return temp;
  }

	@Override public Object visitExprRead(BDEXParser.ExprReadContext ctx) {
		String[] file = {ctx.STRING().getText().replaceAll("\"","")};
		READMain rm = new READMain();
		rm.main(file);
		Table t = rm.getTable();
		return t;
	}
	  @Override public Object visitExprSave(BDEXParser.ExprSaveContext ctx) {
		 String tableName = ctx.WORD().getText();
	     String file = ctx.STRING().getText().replaceAll("\"","");
	     Table table = varTable.get(tableName);
	     if(table==null) {
	       System.out.println("ERROR: Could not find table: "+tableName+"!");
	       System.exit(0);
	     }
	     try {
	       table.toCvsFile(file);
	     }catch(IOException e) {
	       System.err.println("ERROR: Couldn't reach the file!");
	       System.exit(0);
	     }
	     return visitChildren(ctx);
	  }


   @Override public Object visitForLine(BDEXParser.ForLineContext ctx) {
		String var = ctx.WORD(0).getText();
		String tableName = ctx.WORD(1).getText();

		if (varType.containsKey(tableName) && varType.get(tableName).equals("TABLE")){
			Table t = varTable.get(tableName);
			for(int i = 0; i < t.getLength() ; i++) {
				ArrayList<Object> line = new ArrayList<>();
				for(Object obj : t.getLin(i))
					line.add(obj);
				varLine.put(var, line);
				varType.put(var, "LINE");
				for(int j = 0; j < ctx.stat().size(); j++)
					visit(ctx.stat(j));
			} 
		}	
		return null;
	}

   //For '(' type WORD ')' WORD'.'WORD '{' stat* '}'           #forVal
   @Override public Object visitForVal(BDEXParser.ForValContext ctx) {  
		String var = ctx.WORD(0).getText();
		String tableName = ctx.WORD(1).getText();
		String colName = ctx.WORD(2).getText();
		Vector<Object> colVector = null;
		String type = (String) visit(ctx.type());

		if (varType.containsKey(tableName) && varType.get(tableName).equals("TABLE")){
			Table t = varTable.get(tableName);
			for (Column col : t.getCols()){
				if(col.getName().equals(colName)){
					colVector = col.getVector();
               break;
				}
			}
			for(Object obj: colVector){
				varValue.put(var, obj);
				varType.put(var, type);
				for(int j = 0; j < ctx.stat().size(); j++){
					visit(ctx.stat(j));
				} 
			}
		}
				
      return null;
	}

	@Override
	public Object visitVarTemplate(BDEXParser.VarTemplateContext ctx) {
		String varName = ctx.WORD(0).getText();
		if (varType.containsKey(varName)) {
			if (varType.get(varName).equals("TEMPLATE")) {
				System.err.println("Esse template ja existe!");
				System.exit(1);
			} else {
				System.err.println("Essa variavel ja existe!");
				System.exit(1);
			}
		}
		Table t = new Table(varName, false);
		for (int i = 1; i < ctx.WORD().size(); i++) {
			String colName = ctx.WORD(i).getText();
			String tipo = (String) visit(ctx.type(i - 1));
			tipo = tipo.toUpperCase();
			if (tipo.equals("TEXT") || tipo.equals("NUMERIC_INT") || tipo.equals("NUMERIC_REAL")) {
				Column col = new Column(colName, tipo);
				t.addCol(col);
			} else {
				System.err.println("[Template]Tipo inválido: " + tipo);
				System.exit(1);
			}

		}
		t.isTemplate(true);
		varTable.put(varName, t);
		varType.put(varName, "TEMPLATE");
		return null;
	}

	@Override
	public Object visitVarType(BDEXParser.VarTypeContext ctx) {
		String type = (String) visit(ctx.type());
		String varName = ctx.WORD().getText();
		if (varType.containsKey(varName)) {
			System.err.println("Essa Variavel ja existe!");
			System.exit(1);
		}
		if (ctx.expr() != null) {
			Object value = visit(ctx.expr());
			if (type.equals("TEXT"))
				value = String.valueOf(value);
			else if (type.equals("NUMERIC_INT"))
				value = Integer.valueOf(String.valueOf(value));
			else if (type.equals("NUMERIC_REAL"))
				value = Double.valueOf(String.valueOf(value));
			else if (type.equals("TABLE")) {
				Table t = (Table) value;
				t.setName(varName);
				varTable.put(varName, t);
				varType.put(varName, type);
				return null;
			} else {
				System.err.println("[expr Var]Tipo inválido: " + type);
				System.exit(1);
			}
			varValue.put(varName, value);
			varType.put(varName, type);
			return null;

		} else if (ctx.STRING() != null) {
			Scanner sc = new Scanner(System.in);
			Object value = null;
			if (type.equals("TEXT")) {
				value = sc.nextLine().trim();
			} else if (type.equals("NUMERIC_INT"))
				value = sc.nextInt();
			else if (type.equals("NUMERIC_REAL"))
				value = sc.nextDouble();
			else {
				System.err.println("[input var]Tipo inválido: " + type);
				System.exit(1);
			}
			varValue.put(varName, value);
			varType.put(varName, type);
			return null;
		}

		varValue.put(varName, null);
		varType.put(varName, type);
		return null;
	}

	@Override
	public Object visitVarBool(BDEXParser.VarBoolContext ctx) {
		String varName = ctx.WORD(0).getText();
		if (ctx.bool() != null){
			varValue.put(varName, Boolean.parseBoolean(ctx.bool().getText()));
			varType.put(varName, "BOOL");
		}
		else if (ctx.WORD(1) != null){
			String tname= ctx.WORD(1).getText();
			String val= String.valueOf(visit(ctx.val()));

			if( varType.containsKey(tname) && varType.get(tname).equals("TABLE")){
				String realRegex = "[0-9.]+";
				String intRegex = "[0-9]+";
				String textRegex = "[a-zA-Z_]+";

				for(Column col : varTable.get(tname).getCols()){
					if(col.getType() == Types.NUMERIC_INT && !val.matches(intRegex))
						continue;
					else if(col.getType() == Types.NUMERIC_REAL && !val.matches(realRegex))
						continue;
					else if(col.getType() == Types.TEXT && !val.matches(textRegex)) 
						continue;
					
					for(Object obj : col.getVector()){
						if(col.getType() == Types.NUMERIC_INT){
							if(Integer.parseInt(val) == (int) obj){
								varValue.put(varName, true);
								varType.put(varName, "BOOL");
								return null;
							}

						}
						else if(col.getType() == Types.NUMERIC_REAL){
							if(Double.parseDouble(val) == (Double) obj){
								varValue.put(varName, true);
								varType.put(varName, "BOOL");
								return null;
							}

						}
						else if(col.getType() == Types.TEXT){
							if(val.equals((String) obj)){
								varValue.put(varName, true);
								varType.put(varName, "BOOL");
								return null;
							}
						}
					}
				}
					varValue.put(varName, false);
			}
			else{
				System.err.println("Nao existe tabela com o nome "+ tname);
				System.exit(1);
			}

		}
		else
			varValue.put(varName, null);
			varType.put(varName, "BOOL");
		return null;

	}

	@Override
	public Object visitVarExpr(BDEXParser.VarExprContext ctx) {
		String varName = ctx.WORD().getText();
		if (ctx.where() != null)
			varValue.put(varName, String.valueOf(visit(ctx.where())));
		else
			varValue.put(varName, null);
		varType.put(varName, "EXPR");
		return null;

	}



	@Override
	public Object visitNoRetPrint(BDEXParser.NoRetPrintContext ctx) {
		if(ctx.val()!=null)
		System.out.println(visit(ctx.val()));
		else
			System.out.println();
		return null;
	}

	@Override
	public Object visitNoRetDel(BDEXParser.NoRetDelContext ctx) {
		String tableName = ctx.WORD().getText();
		if (varType.containsKey(tableName)
				&& (varType.get(tableName).equals("TABLE") || varType.get(tableName).equals("TEMPLATE"))) {
			if (ctx.where() != null) {
				String expression = String.valueOf(visit(ctx.where()));
				for (int idx : varTable.get(tableName).checkWhereCondition(expression))
					varTable.get(tableName).rmLin(idx);
			} else {
				varType.remove(tableName);
				varTable.remove(tableName);
			}
		} else {
			System.err.println("Não existe nenhuma tabela com o nome: " + tableName);
			System.exit(1);
		}

		return null;
	}

	@Override
	public Object visitNoRetAddLineCostum(BDEXParser.NoRetAddLineCostumContext ctx) {
		String tableName = ctx.WORD(0).getText();
		if (varType.containsKey(tableName) && varType.get(tableName).equals("TABLE")) {
			Table t = varTable.get(tableName);
			Vector<Column> colName = t.getCols();
			Object[] lineValue = new Object[colName.size()];
			if (ctx.WORD(1) != null) {
				for (int i = 0; i < ctx.val().size(); i++) {
					String inputName = ctx.WORD(i + 1).getText();
					for (int j = 0; j < colName.size(); j++) {
						String name = colName.get(j).getName();
						if (name.equals(inputName)) {
							lineValue[j] = visit(ctx.val(i));
							break;
						}
					}
				}
			} else {
				for (int i = 0; i < ctx.val().size(); i++) {
					lineValue[i] = visit(ctx.val(i));
				}
			}
			t.addLin(lineValue);

		} else {
			System.err.println("Não existe nenhuma tabela com o nome: " + tableName);
			System.exit(1);
		}
		return null;
	}

	// Falta testar
	@Override
	public Object visitNoRetAddCol(BDEXParser.NoRetAddColContext ctx) {
		String tableName = ctx.WORD(0).getText();
		if (varType.containsKey(tableName)
				&& (varType.get(tableName).equals("TEMPLATE") || varType.get(tableName).equals("TABLE"))) {
			String type = String.valueOf(visit(ctx.type()));
			String varName = ctx.WORD(1).getText();
			Column col = null;
			if (type.equals("TEXT") || type.equals("NUMERIC_INT") || type.equals("NUMERIC_REAL")) {
				col = new Column(varName, type);
				for (int i = 0; i < ctx.val().size(); i++) {
					Object obj = visit(ctx.val(i));
					if (!col.addObj(obj)) {
						System.err.println("Mismatch type of value with the type of the column");
						System.exit(1);
					}
				}
			}

			else {
				System.err.println("[addCol]Tipo inválido: " + type);
				System.exit(1);
			}
			if (!varTable.get(tableName).addCol(col))
				System.exit(1);

		} else {
			System.err.println("Não existe nenhuma tabela com o nome: " + tableName);
			System.exit(1);
		}
		return null;
	}

	@Override
	public Object visitValAritMul(BDEXParser.ValAritMulContext ctx) {
		Object obj1 = visit(ctx.val(0));
		Object obj2 = visit(ctx.val(1));
		String op = ctx.op.getText();
		if (obj1 instanceof String || obj2 instanceof String) {
			String tableName = obj1 instanceof String ? String.valueOf(obj1).split("\t")[0]
					: String.valueOf(obj2).split("\t")[0];
			String colName = obj1 instanceof String ? String.valueOf(obj1).split("\t")[1]
					: String.valueOf(obj2).split("\t")[1];
			String str = obj1 instanceof String ? String.valueOf(obj2) : String.valueOf(obj1);
			Double num = Double.valueOf(str);
			if (varType.containsKey(tableName) && varType.get(tableName).equals("TABLE")
					&& varTable.get(tableName).getCol(colName) != null
					&& !varTable.get(tableName).getCol(colName).getType().toString().equals("TEXT")) {
				Table t = new Table("temp", false);
				for (Column col : varTable.get(tableName).getCols()) {
					Column newCol = new Column(col.getName(), col.getType().toString());
					if (col.getName().equals(colName)) {
						for (Object obj : col.getVector()) {
							switch (op) {
							case "%":
								if (num != 0) {
									if (obj instanceof Integer)
										newCol.addObj((int) ((int) obj % num));
									else
										newCol.addObj((Double) obj % num);
									break;
								}
								System.err.println("Divisão por zero");
								System.exit(1);
							case "/":
								if (num != 0) {
									if (obj instanceof Integer)
										newCol.addObj((int) ((int) obj / num));
									else
										newCol.addObj((Double) obj / num);
									break;
								}
								System.err.println("Divisão por zero");
								System.exit(1);
							case "*":
								if (obj instanceof Integer)
									newCol.addObj((int) ((int) obj * num));
								else
									newCol.addObj((Double) obj * num);
							}
						}
					} else {
						for (Object obj : col.getVector())
							newCol.addObj(obj);
					}
					t.addCol(newCol);
				}
				return t;
			} else {
				System.err.println("Não existe nenhuma tabela com o nome: " + tableName
						+ " ou a tabela não possui uma coluna numérica chamada: " + colName);
				System.exit(1);
			}
		}
		
		String str1 = String.valueOf(obj1);
		String str2 = String.valueOf(obj2);
		Double e1 = Double.valueOf(str1);
		Double e2 = Double.valueOf(str2);
		Double res = null;
		switch (op) {
		case "%":
			if (e2 != 0) {
				res = e1 % e2;
				break;
			}
			System.err.println("Divisão por zero");
			System.exit(1);
		case "/":
			if (e2 != 0) {
				res = e1 / e2;
				break;
			}
			System.err.println("Divisão por zero");
			System.exit(1);
		case "*":
			res = e1 * e2;
		}
		if (!str1.contains(".") && !str2.contains(".")) {
			return (int) Math.floor(res);
		}
		return res;
	}

	@Override
	public Object visitValAritSum(BDEXParser.ValAritSumContext ctx) {
		Object obj1 = visit(ctx.val(0));
		Object obj2 = visit(ctx.val(1));
		String op = ctx.op.getText();
		if (obj1 instanceof String || obj2 instanceof String) {
			String tableName = obj1 instanceof String ? String.valueOf(obj1).split("\t")[0]
					: String.valueOf(obj2).split("\t")[0];
			String colName = obj1 instanceof String ? String.valueOf(obj1).split("\t")[1]
					: String.valueOf(obj2).split("\t")[1];
			String str = obj1 instanceof String ? String.valueOf(obj2) : String.valueOf(obj1);
			Double num = Double.valueOf(str);
			if (varType.containsKey(tableName) && varType.get(tableName).equals("TABLE")
					&& varTable.get(tableName).getCol(colName) != null
					&& !varTable.get(tableName).getCol(colName).getType().toString().equals("TEXT")) {
				Table t = new Table("temp", false);
				for (Column col : varTable.get(tableName).getCols()) {
					Column newCol = new Column(col.getName(), col.getType().toString());
					if (col.getName().equals(colName)) {
						for (Object obj : col.getVector()) {
							switch (op) {
							case "+":
								if (obj instanceof Integer)
									newCol.addObj((int) ((int) obj + num));
								else
									newCol.addObj((Double) obj + num);
								break;
							case "-":
								if (obj instanceof Integer)
									newCol.addObj((int) ((int) obj - num));
								else
									newCol.addObj((Double) obj - num);
							}
						}
					} else {
						for (Object obj : col.getVector())
							newCol.addObj(obj);
					}
					t.addCol(newCol);
				}
				return t;
			} else {
				System.err.println("Não existe nenhuma tabela com o nome: " + tableName
						+ " ou a tabela não possui uma coluna numérica chamada: " + colName);
				System.exit(1);
			}
		}
		String str1 = String.valueOf(obj1);
		String str2 = String.valueOf(obj2);
		Double e1 = Double.valueOf(str1);
		Double e2 = Double.valueOf(str2);

		Double res = null;
		switch (op) {
		case "+":
			res = e1 + e2;
			break;
		case "-":
			res = e1 - e2;
		}
		if (!str1.contains(".") && !str2.contains(".")) {
			return (int) Math.floor(res);
		}
		return res;
	}

	@Override
	public Object visitDefine(BDEXParser.DefineContext ctx) {
		String varName = ctx.WORD().getText();
		if (varType.containsKey(varName)) {
			Object value = null;
			String tipo = varType.get(varName);
			if (tipo.equals("LINE")) {
				ArrayList<Object> line = new ArrayList<>();
				for(Object obj : (Object[]) visit(ctx.expr()))
					line.add(obj);
				varLine.put(varName, line);
				return null;
			} else if (tipo.equals("TEXT"))
				value = String.valueOf(visit(ctx.expr()));
			else if (tipo.equals("EXPR"))
				value = String.valueOf(visit(ctx.expr()));
			else if (tipo.equals("BOOL"))
				value = (boolean)visit(ctx.expr());
			else if (tipo.equals("NUMERIC_INT"))
				value = Integer.valueOf(String.valueOf(visit(ctx.expr())));
			else if (tipo.equals("NUMERIC_REAL"))
				value = Double.valueOf(String.valueOf(visit(ctx.expr())));
			else if (tipo.equals("TABLE")) {
				value = (Table) visit(ctx.expr());
				if (!(value instanceof Table)) {
					System.err.println("Erro ao inicializar a variável tabela");
					System.exit(1);
				}
				varTable.put(varName, (Table) value);
				return null;
			}
			/*
			 * else if(tipo.contains("COL")){ value = (Column) visit(ctx.expr()); if
			 * (!(value instanceof Column)){
			 * System.err.println("Erro ao inicializar a variável coluna"); System.exit(1);
			 * } }
			 */
			else {
				System.err.println("Variável de tipo indefenido " + tipo);
				System.exit(1);
			}
			varValue.put(varName, value);
		} else {
			System.err.println("Não existe nenhuma variável " + varName);
			System.exit(1);
		}
		return null;
	}

	@Override
	public Object visitValNum(BDEXParser.ValNumContext ctx) {
		return Integer.parseInt(ctx.NUM().getText());
	}

	@Override
	public Object visitValReal(BDEXParser.ValRealContext ctx) {
		return Double.parseDouble(ctx.REAL().getText());
	}

	@Override
	public Object visitValWord(BDEXParser.ValWordContext ctx) {
		String value = ctx.WORD().getText();
		if (varType.containsKey(value)) {
			if (varType.get(value).equals("TABLE") || varType.get(value).equals("TEMPLATE"))
				return varTable.get(value);
			else if (varType.get(value).equals("LINE"))
				return varLine.get(value);
			else
				return varValue.get(value);
		} else {
			System.err.println("Não existe nenhuma variável " + value);
			System.exit(1);
		}
		return null;
	}
	
	@Override public Object visitValTableColumn(BDEXParser.ValTableColumnContext ctx) {
		String table = ctx.WORD(0).getText();
		String col = ctx.WORD(1).getText();
		return ctx.WORD(0).getText() + "\t" + ctx.WORD(1).getText();
	 }


	@Override
	public Object visitValString(BDEXParser.ValStringContext ctx) {
		return ctx.STRING().getText().replace("\"", "");
	}

	@Override
	public Object visitValBool(BDEXParser.ValBoolContext ctx) {
		return String.valueOf(visit(ctx.where()));
	}

	@Override
	public Object visitValPar(BDEXParser.ValParContext ctx) {
		return visit(ctx.val());
	}

	@Override
	public Object visitTStr(BDEXParser.TStrContext ctx) {
		return "TEXT";
	}

	@Override
	public Object visitTInt(BDEXParser.TIntContext ctx) {
		return "NUMERIC_INT";
	}

	@Override
	public Object visitTReal(BDEXParser.TRealContext ctx) {
		return "NUMERIC_REAL";
	}

	@Override
	public Object visitTTable(BDEXParser.TTableContext ctx) {
		return "TABLE";
	}


// Where val operation val (andOr val operation val)*
	@Override
	public Object visitNormalWhere(BDEXParser.NormalWhereContext ctx) {
		String expression = ctx.val(0).getText() + " " + ctx.operation(0).getText() + " " + ctx.val(1).getText()+ " ";

		for (int i = 2; i < ctx.val().size(); i += 2) {
			String val = ctx.val(i).getText();
			String val2 = ctx.val(i + 1).getText();
			if (val != null && val2 != null) {
				expression += ctx.andOr(i / 2 - 1).getText() + " " + val + " " + ctx.operation(i / 2).getText() + " "
						+ val2 + " ";
			} else {
				System.err.println("Erro na expressão!");
				System.exit(1);
			}
		}
		return expression;
	}
	

	@Override
	public Object visitSavedWhere(BDEXParser.SavedWhereContext ctx) {
		String varName = ctx.WORD().getText();
		if( varType.containsKey(varName) && varType.get(varName).equals("EXPR")){
			return varValue.get(varName);
		}
		else{
			System.err.println("Nao existe expressão com o nome "+ varName);
			System.exit(1);
		}
		return null;
	}
}
