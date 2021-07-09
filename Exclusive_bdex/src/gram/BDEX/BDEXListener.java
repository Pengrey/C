// Generated from BDEX.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link BDEXParser}.
 */
public interface BDEXListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link BDEXParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(BDEXParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link BDEXParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(BDEXParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link BDEXParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(BDEXParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link BDEXParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(BDEXParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code progVar}
	 * labeled alternative in {@link BDEXParser#line}.
	 * @param ctx the parse tree
	 */
	void enterProgVar(BDEXParser.ProgVarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code progVar}
	 * labeled alternative in {@link BDEXParser#line}.
	 * @param ctx the parse tree
	 */
	void exitProgVar(BDEXParser.ProgVarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code progDef}
	 * labeled alternative in {@link BDEXParser#line}.
	 * @param ctx the parse tree
	 */
	void enterProgDef(BDEXParser.ProgDefContext ctx);
	/**
	 * Exit a parse tree produced by the {@code progDef}
	 * labeled alternative in {@link BDEXParser#line}.
	 * @param ctx the parse tree
	 */
	void exitProgDef(BDEXParser.ProgDefContext ctx);
	/**
	 * Enter a parse tree produced by the {@code prognoRetFunc}
	 * labeled alternative in {@link BDEXParser#line}.
	 * @param ctx the parse tree
	 */
	void enterPrognoRetFunc(BDEXParser.PrognoRetFuncContext ctx);
	/**
	 * Exit a parse tree produced by the {@code prognoRetFunc}
	 * labeled alternative in {@link BDEXParser#line}.
	 * @param ctx the parse tree
	 */
	void exitPrognoRetFunc(BDEXParser.PrognoRetFuncContext ctx);
	/**
	 * Enter a parse tree produced by the {@code statLoop}
	 * labeled alternative in {@link BDEXParser#line}.
	 * @param ctx the parse tree
	 */
	void enterStatLoop(BDEXParser.StatLoopContext ctx);
	/**
	 * Exit a parse tree produced by the {@code statLoop}
	 * labeled alternative in {@link BDEXParser#line}.
	 * @param ctx the parse tree
	 */
	void exitStatLoop(BDEXParser.StatLoopContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprCreate}
	 * labeled alternative in {@link BDEXParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprCreate(BDEXParser.ExprCreateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprCreate}
	 * labeled alternative in {@link BDEXParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprCreate(BDEXParser.ExprCreateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprGetLine}
	 * labeled alternative in {@link BDEXParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprGetLine(BDEXParser.ExprGetLineContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprGetLine}
	 * labeled alternative in {@link BDEXParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprGetLine(BDEXParser.ExprGetLineContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprGet}
	 * labeled alternative in {@link BDEXParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprGet(BDEXParser.ExprGetContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprGet}
	 * labeled alternative in {@link BDEXParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprGet(BDEXParser.ExprGetContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprPrint}
	 * labeled alternative in {@link BDEXParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprPrint(BDEXParser.ExprPrintContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprPrint}
	 * labeled alternative in {@link BDEXParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprPrint(BDEXParser.ExprPrintContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprRead}
	 * labeled alternative in {@link BDEXParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprRead(BDEXParser.ExprReadContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprRead}
	 * labeled alternative in {@link BDEXParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprRead(BDEXParser.ExprReadContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprSave}
	 * labeled alternative in {@link BDEXParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprSave(BDEXParser.ExprSaveContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprSave}
	 * labeled alternative in {@link BDEXParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprSave(BDEXParser.ExprSaveContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprJoinOn}
	 * labeled alternative in {@link BDEXParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprJoinOn(BDEXParser.ExprJoinOnContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprJoinOn}
	 * labeled alternative in {@link BDEXParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprJoinOn(BDEXParser.ExprJoinOnContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprJoin}
	 * labeled alternative in {@link BDEXParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprJoin(BDEXParser.ExprJoinContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprJoin}
	 * labeled alternative in {@link BDEXParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprJoin(BDEXParser.ExprJoinContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprWhere}
	 * labeled alternative in {@link BDEXParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprWhere(BDEXParser.ExprWhereContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprWhere}
	 * labeled alternative in {@link BDEXParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprWhere(BDEXParser.ExprWhereContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprLine}
	 * labeled alternative in {@link BDEXParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprLine(BDEXParser.ExprLineContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprLine}
	 * labeled alternative in {@link BDEXParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprLine(BDEXParser.ExprLineContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprVal}
	 * labeled alternative in {@link BDEXParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExprVal(BDEXParser.ExprValContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprVal}
	 * labeled alternative in {@link BDEXParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExprVal(BDEXParser.ExprValContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varStr}
	 * labeled alternative in {@link BDEXParser#var}.
	 * @param ctx the parse tree
	 */
	void enterVarStr(BDEXParser.VarStrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varStr}
	 * labeled alternative in {@link BDEXParser#var}.
	 * @param ctx the parse tree
	 */
	void exitVarStr(BDEXParser.VarStrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varBool}
	 * labeled alternative in {@link BDEXParser#var}.
	 * @param ctx the parse tree
	 */
	void enterVarBool(BDEXParser.VarBoolContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varBool}
	 * labeled alternative in {@link BDEXParser#var}.
	 * @param ctx the parse tree
	 */
	void exitVarBool(BDEXParser.VarBoolContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varInt}
	 * labeled alternative in {@link BDEXParser#var}.
	 * @param ctx the parse tree
	 */
	void enterVarInt(BDEXParser.VarIntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varInt}
	 * labeled alternative in {@link BDEXParser#var}.
	 * @param ctx the parse tree
	 */
	void exitVarInt(BDEXParser.VarIntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varReal}
	 * labeled alternative in {@link BDEXParser#var}.
	 * @param ctx the parse tree
	 */
	void enterVarReal(BDEXParser.VarRealContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varReal}
	 * labeled alternative in {@link BDEXParser#var}.
	 * @param ctx the parse tree
	 */
	void exitVarReal(BDEXParser.VarRealContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varLine}
	 * labeled alternative in {@link BDEXParser#var}.
	 * @param ctx the parse tree
	 */
	void enterVarLine(BDEXParser.VarLineContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varLine}
	 * labeled alternative in {@link BDEXParser#var}.
	 * @param ctx the parse tree
	 */
	void exitVarLine(BDEXParser.VarLineContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varTable}
	 * labeled alternative in {@link BDEXParser#var}.
	 * @param ctx the parse tree
	 */
	void enterVarTable(BDEXParser.VarTableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varTable}
	 * labeled alternative in {@link BDEXParser#var}.
	 * @param ctx the parse tree
	 */
	void exitVarTable(BDEXParser.VarTableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varTableCat}
	 * labeled alternative in {@link BDEXParser#var}.
	 * @param ctx the parse tree
	 */
	void enterVarTableCat(BDEXParser.VarTableCatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varTableCat}
	 * labeled alternative in {@link BDEXParser#var}.
	 * @param ctx the parse tree
	 */
	void exitVarTableCat(BDEXParser.VarTableCatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varCol}
	 * labeled alternative in {@link BDEXParser#var}.
	 * @param ctx the parse tree
	 */
	void enterVarCol(BDEXParser.VarColContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varCol}
	 * labeled alternative in {@link BDEXParser#var}.
	 * @param ctx the parse tree
	 */
	void exitVarCol(BDEXParser.VarColContext ctx);
	/**
	 * Enter a parse tree produced by the {@code noRetPrint}
	 * labeled alternative in {@link BDEXParser#noRetFunc}.
	 * @param ctx the parse tree
	 */
	void enterNoRetPrint(BDEXParser.NoRetPrintContext ctx);
	/**
	 * Exit a parse tree produced by the {@code noRetPrint}
	 * labeled alternative in {@link BDEXParser#noRetFunc}.
	 * @param ctx the parse tree
	 */
	void exitNoRetPrint(BDEXParser.NoRetPrintContext ctx);
	/**
	 * Enter a parse tree produced by the {@code noRetDel}
	 * labeled alternative in {@link BDEXParser#noRetFunc}.
	 * @param ctx the parse tree
	 */
	void enterNoRetDel(BDEXParser.NoRetDelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code noRetDel}
	 * labeled alternative in {@link BDEXParser#noRetFunc}.
	 * @param ctx the parse tree
	 */
	void exitNoRetDel(BDEXParser.NoRetDelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code noRetAddLineCostum}
	 * labeled alternative in {@link BDEXParser#noRetFunc}.
	 * @param ctx the parse tree
	 */
	void enterNoRetAddLineCostum(BDEXParser.NoRetAddLineCostumContext ctx);
	/**
	 * Exit a parse tree produced by the {@code noRetAddLineCostum}
	 * labeled alternative in {@link BDEXParser#noRetFunc}.
	 * @param ctx the parse tree
	 */
	void exitNoRetAddLineCostum(BDEXParser.NoRetAddLineCostumContext ctx);
	/**
	 * Enter a parse tree produced by the {@code noRetAddCol}
	 * labeled alternative in {@link BDEXParser#noRetFunc}.
	 * @param ctx the parse tree
	 */
	void enterNoRetAddCol(BDEXParser.NoRetAddColContext ctx);
	/**
	 * Exit a parse tree produced by the {@code noRetAddCol}
	 * labeled alternative in {@link BDEXParser#noRetFunc}.
	 * @param ctx the parse tree
	 */
	void exitNoRetAddCol(BDEXParser.NoRetAddColContext ctx);
	/**
	 * Enter a parse tree produced by the {@code noRetAlter}
	 * labeled alternative in {@link BDEXParser#noRetFunc}.
	 * @param ctx the parse tree
	 */
	void enterNoRetAlter(BDEXParser.NoRetAlterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code noRetAlter}
	 * labeled alternative in {@link BDEXParser#noRetFunc}.
	 * @param ctx the parse tree
	 */
	void exitNoRetAlter(BDEXParser.NoRetAlterContext ctx);
	/**
	 * Enter a parse tree produced by {@link BDEXParser#func}.
	 * @param ctx the parse tree
	 */
	void enterFunc(BDEXParser.FuncContext ctx);
	/**
	 * Exit a parse tree produced by {@link BDEXParser#func}.
	 * @param ctx the parse tree
	 */
	void exitFunc(BDEXParser.FuncContext ctx);
	/**
	 * Enter a parse tree produced by {@link BDEXParser#forloop}.
	 * @param ctx the parse tree
	 */
	void enterForloop(BDEXParser.ForloopContext ctx);
	/**
	 * Exit a parse tree produced by {@link BDEXParser#forloop}.
	 * @param ctx the parse tree
	 */
	void exitForloop(BDEXParser.ForloopContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolTrue}
	 * labeled alternative in {@link BDEXParser#bool}.
	 * @param ctx the parse tree
	 */
	void enterBoolTrue(BDEXParser.BoolTrueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolTrue}
	 * labeled alternative in {@link BDEXParser#bool}.
	 * @param ctx the parse tree
	 */
	void exitBoolTrue(BDEXParser.BoolTrueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolFalse}
	 * labeled alternative in {@link BDEXParser#bool}.
	 * @param ctx the parse tree
	 */
	void enterBoolFalse(BDEXParser.BoolFalseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolFalse}
	 * labeled alternative in {@link BDEXParser#bool}.
	 * @param ctx the parse tree
	 */
	void exitBoolFalse(BDEXParser.BoolFalseContext ctx);
	/**
	 * Enter a parse tree produced by {@link BDEXParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(BDEXParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link BDEXParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(BDEXParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link BDEXParser#opBool}.
	 * @param ctx the parse tree
	 */
	void enterOpBool(BDEXParser.OpBoolContext ctx);
	/**
	 * Exit a parse tree produced by {@link BDEXParser#opBool}.
	 * @param ctx the parse tree
	 */
	void exitOpBool(BDEXParser.OpBoolContext ctx);
	/**
	 * Enter a parse tree produced by {@link BDEXParser#opArit}.
	 * @param ctx the parse tree
	 */
	void enterOpArit(BDEXParser.OpAritContext ctx);
	/**
	 * Exit a parse tree produced by {@link BDEXParser#opArit}.
	 * @param ctx the parse tree
	 */
	void exitOpArit(BDEXParser.OpAritContext ctx);
	/**
	 * Enter a parse tree produced by the {@code opBoolean}
	 * labeled alternative in {@link BDEXParser#op}.
	 * @param ctx the parse tree
	 */
	void enterOpBoolean(BDEXParser.OpBooleanContext ctx);
	/**
	 * Exit a parse tree produced by the {@code opBoolean}
	 * labeled alternative in {@link BDEXParser#op}.
	 * @param ctx the parse tree
	 */
	void exitOpBoolean(BDEXParser.OpBooleanContext ctx);
	/**
	 * Enter a parse tree produced by the {@code opAritmetica}
	 * labeled alternative in {@link BDEXParser#op}.
	 * @param ctx the parse tree
	 */
	void enterOpAritmetica(BDEXParser.OpAritmeticaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code opAritmetica}
	 * labeled alternative in {@link BDEXParser#op}.
	 * @param ctx the parse tree
	 */
	void exitOpAritmetica(BDEXParser.OpAritmeticaContext ctx);
	/**
	 * Enter a parse tree produced by {@link BDEXParser#define}.
	 * @param ctx the parse tree
	 */
	void enterDefine(BDEXParser.DefineContext ctx);
	/**
	 * Exit a parse tree produced by {@link BDEXParser#define}.
	 * @param ctx the parse tree
	 */
	void exitDefine(BDEXParser.DefineContext ctx);
	/**
	 * Enter a parse tree produced by the {@code valNum}
	 * labeled alternative in {@link BDEXParser#val}.
	 * @param ctx the parse tree
	 */
	void enterValNum(BDEXParser.ValNumContext ctx);
	/**
	 * Exit a parse tree produced by the {@code valNum}
	 * labeled alternative in {@link BDEXParser#val}.
	 * @param ctx the parse tree
	 */
	void exitValNum(BDEXParser.ValNumContext ctx);
	/**
	 * Enter a parse tree produced by the {@code valReal}
	 * labeled alternative in {@link BDEXParser#val}.
	 * @param ctx the parse tree
	 */
	void enterValReal(BDEXParser.ValRealContext ctx);
	/**
	 * Exit a parse tree produced by the {@code valReal}
	 * labeled alternative in {@link BDEXParser#val}.
	 * @param ctx the parse tree
	 */
	void exitValReal(BDEXParser.ValRealContext ctx);
	/**
	 * Enter a parse tree produced by the {@code valWord}
	 * labeled alternative in {@link BDEXParser#val}.
	 * @param ctx the parse tree
	 */
	void enterValWord(BDEXParser.ValWordContext ctx);
	/**
	 * Exit a parse tree produced by the {@code valWord}
	 * labeled alternative in {@link BDEXParser#val}.
	 * @param ctx the parse tree
	 */
	void exitValWord(BDEXParser.ValWordContext ctx);
	/**
	 * Enter a parse tree produced by the {@code valTableColumn}
	 * labeled alternative in {@link BDEXParser#val}.
	 * @param ctx the parse tree
	 */
	void enterValTableColumn(BDEXParser.ValTableColumnContext ctx);
	/**
	 * Exit a parse tree produced by the {@code valTableColumn}
	 * labeled alternative in {@link BDEXParser#val}.
	 * @param ctx the parse tree
	 */
	void exitValTableColumn(BDEXParser.ValTableColumnContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprWord}
	 * labeled alternative in {@link BDEXParser#val}.
	 * @param ctx the parse tree
	 */
	void enterExprWord(BDEXParser.ExprWordContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprWord}
	 * labeled alternative in {@link BDEXParser#val}.
	 * @param ctx the parse tree
	 */
	void exitExprWord(BDEXParser.ExprWordContext ctx);
	/**
	 * Enter a parse tree produced by the {@code valBool}
	 * labeled alternative in {@link BDEXParser#val}.
	 * @param ctx the parse tree
	 */
	void enterValBool(BDEXParser.ValBoolContext ctx);
	/**
	 * Exit a parse tree produced by the {@code valBool}
	 * labeled alternative in {@link BDEXParser#val}.
	 * @param ctx the parse tree
	 */
	void exitValBool(BDEXParser.ValBoolContext ctx);
	/**
	 * Enter a parse tree produced by the {@code valFunc}
	 * labeled alternative in {@link BDEXParser#val}.
	 * @param ctx the parse tree
	 */
	void enterValFunc(BDEXParser.ValFuncContext ctx);
	/**
	 * Exit a parse tree produced by the {@code valFunc}
	 * labeled alternative in {@link BDEXParser#val}.
	 * @param ctx the parse tree
	 */
	void exitValFunc(BDEXParser.ValFuncContext ctx);
}