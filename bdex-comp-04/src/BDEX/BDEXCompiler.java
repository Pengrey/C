import java.io.File;
import org.stringtemplate.v4.*;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.ParserRuleContext;

public class BDEXCompiler extends BDEXBaseVisitor<ST> {
    /*
   protected int varCount = 0;
   protected String target = "java"; // default
   protected STGroup stg = null;

   @Override public ST visitProgram(BDEXParser.ProgramContext ctx) {
      stg = new STGroupFile(target+".stg");
      ST res = stg.getInstanceOf("module");
      if(ctx.stat()!= null){
         Iterator<CalcParser.StatContext> list = ctx.stat().iterator();
         while(list.hasNext()) {
            res.add("stat", visit(list.next()).render());
         }
         return res;

   }

   @Override public ST visitStat(BDEXParser.StatContext ctx) {
      ST res = templates.getInstanceOf("stats");
      if(ctx.var()!= null)
         res.add("stat", visit(ctx.var()).render());
      else if(ctx.define()!= null)
         res.add("stat", visit(ctx.define()).render());
      else if(ctx.noRetFunc()!= null)
         res.add("stat", visit(ctx.noRetFunc()).render());
      else if(ctx.forloop()!= null)
         res.add("stat", visit(ctx.forloop()).render());
      return res;
   }

   @Override public ST visitExprCreate(BDEXParser.ExprCreateContext ctx) {
      return visitChildren(ctx);
   }

   @Override public ST visitExprGet(BDEXParser.ExprGetContext ctx) {
      return visitChildren(ctx);
   }

   @Override public ST visitExprRead(BDEXParser.ExprReadContext ctx) {
      return visitChildren(ctx);
   }

   @Override public ST visitExprSave(BDEXParser.ExprSaveContext ctx) {
      return visitChildren(ctx);
   }

   @Override public ST visitExprJoinOn(BDEXParser.ExprJoinOnContext ctx) {
      return visitChildren(ctx);
   }

   @Override public ST visitExprJoin(BDEXParser.ExprJoinContext ctx) {
      return visitChildren(ctx);
   }

   @Override public ST visitExprWhere(BDEXParser.ExprWhereContext ctx) {
      return visitChildren(ctx);
   }

   @Override public ST visitExprVal(BDEXParser.ExprValContext ctx) {
      return visitChildren(ctx);
   }

   @Override public ST visitVarTemplate(BDEXParser.VarTemplateContext ctx) {
      return visitChildren(ctx);
   }

   @Override public ST visitVarType(BDEXParser.VarTypeContext ctx) {
      ST res = stg.getInstanceOf("stats");
      ST decl = stg.getInstanceOf("decl");
      decl.add("type", visit(ctx.type()));
      decl.add("var",ctx.WORD().getText());
      res.add("stat", decl.render());
      if(ctx.expr() != null){
         ST res = stg.getInstanceOf("assign");
         res.add("stat", visit(ctx.expr()).render());
         res.add("var", ctx.WORD().getText());
         res.add("value", visit(ctx.expr()));
         return res;
      }
      return res;
   }

   @Override public ST visitVarBool(BDEXParser.VarBoolContext ctx) {
      return visitChildren(ctx);
   }

   @Override public ST visitVarLine(BDEXParser.VarLineContext ctx) {
      return visitChildren(ctx);
   }

   @Override public ST visitNoRetPrint(BDEXParser.NoRetPrintContext ctx) {
      ST res = stg.getInstanceOf("show");
      res.add("stat", visit(ctx.val()));
      res.add("expr",ctx.expr().varName);
      return res;
   }

   @Override public ST visitNoRetDel(BDEXParser.NoRetDelContext ctx) {
      return visitChildren(ctx);
   }

   @Override public ST visitNoRetAddLineCostum(BDEXParser.NoRetAddLineCostumContext ctx) {
      return visitChildren(ctx);
   }

   @Override public ST visitNoRetAddCol(BDEXParser.NoRetAddColContext ctx) {
      return visitChildren(ctx);
   }

   @Override public ST visitWhere(BDEXParser.WhereContext ctx) {
      return visitChildren(ctx);
   }

   @Override public ST visitForLine(BDEXParser.ForLineContext ctx) {
      return visitChildren(ctx);
   }

   @Override public ST visitForVal(BDEXParser.ForValContext ctx) {
      return visitChildren(ctx);
   }

   @Override public ST visitBool(BDEXParser.BoolContext ctx) {
      return visitChildren(ctx);
   }

   @Override public ST visitTStr(BDEXParser.TStrContext ctx) {
      return visitChildren(ctx);
   }

   @Override public ST visitTInt(BDEXParser.TIntContext ctx) {
      return visitChildren(ctx);
   }

   @Override public ST visitTReal(BDEXParser.TRealContext ctx) {
      return visitChildren(ctx);
   }

   @Override public ST visitTTable(BDEXParser.TTableContext ctx) {
      return visitChildren(ctx);
   }

   @Override public ST visitAndOr(BDEXParser.AndOrContext ctx) {
      return visitChildren(ctx);
   }

   @Override public ST visitDefine(BDEXParser.DefineContext ctx) {
      ST res = stg.getInstanceOf("assign");
      res.add("stat", visit(ctx.expr()).render());
      res.add("var", ctx.WORD().getText());
      res.add("value", visit(ctx.expr()));
      return res;
   }

   @Override public ST visitOperation(BDEXParser.OperationContext ctx) {
      return visitChildren(ctx);
   }

   @Override public ST visitValNum(BDEXParser.ValNumContext ctx) {
      return visitChildren(ctx);
   }

   @Override public ST visitValReal(BDEXParser.ValRealContext ctx) {
      return visitChildren(ctx);
   }

   @Override public ST visitValPar(BDEXParser.ValParContext ctx) {
      return visitChildren(ctx);
   }

   @Override public ST visitValAritMul(BDEXParser.ValAritMulContext ctx) {
      return visitChildren(ctx);
   }

   @Override public ST visitValTableColumn(BDEXParser.ValTableColumnContext ctx) {
      return visitChildren(ctx);
   }

   @Override public ST visitValString(BDEXParser.ValStringContext ctx) {
      return visitChildren(ctx);
   }

   @Override public ST visitValWord(BDEXParser.ValWordContext ctx) {
      return visitChildren(ctx);
   }

   @Override public ST visitValAritSum(BDEXParser.ValAritSumContext ctx) {
      ST res = templates.getInstanceOf("stats");
      ctx.var= newVar();
      res.add("stat", visit(ctx.val(0)).render());
      res.add("stat", visit(ctx.val(1)).render());
      ST bop = templates.getInstanceOf("binaryOperation");
      bop.add("type", "double");
      bop.add("var", ctx.var);
      bop.add("e1", ctx.val(0).var);
      bop.add("op", ctx.op.getText());
      bop.add("e2", ctx.val(1).var);
      res.add("stat", bop.render());
      return res;
   }

   @Override public ST visitValBool(BDEXParser.ValBoolContext ctx) {
      return visitChildren(ctx);
   }*/
}
