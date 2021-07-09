import static java.lang.System.*;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileInputStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.stringtemplate.v4.*;

public class BDEXMain {
   public static void main(String[] args) {
      boolean compile = false;
      int i;
      for(i = 0; i < args.length && args[i].startsWith("-"); i++)
      {
         switch(args[i].toLowerCase())
         {
            case "-interpreter":
               compile = false;
               break;
            case "-compiler":
               compile = true;
               break;
            default:
               err.println("ERROR: invalid program argument \""+args[i]+"\"");
               exit(1);
               break;
         }
      }

      if (i+1 != args.length)
      {
         out.println("Usage: antlr4-java -ea CalcMain [-compiler | -interpreter] <source-file>");
         exit(0);
      }
      if (compile)
         System.out.println("Geração de código não implementado");
      else
         runInterpreter(args[i]);
   }
   public static void runCompiler(String sourceFile){
      assert sourceFile != null && !sourceFile.isEmpty();

      try {
         Scanner sc = new Scanner(sourceFile);
         String lineText = null;
         int numLine = 1;
         if (sc.hasNextLine())
            lineText = sc.nextLine();
         BDEXParser parser = new BDEXParser(null);
         // replace error listener:
         //parser.removeErrorListeners(); // remove ConsoleErrorListener
         //parser.addErrorListener(new ErrorHandlingListener());
         BDEXCompiler compiler = new BDEXCompiler();
         while(lineText != null) {
            // create a CharStream that reads from standard input:
            CharStream input = CharStreams.fromString(lineText + "\n");
            // create a lexer that feeds off of input CharStream:
            BDEXLexer lexer = new BDEXLexer(input);
            lexer.setLine(numLine);
            lexer.setCharPositionInLine(0);
            // create a buffer of tokens pulled from the lexer:
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            // create a parser that feeds off the tokens buffer:
            parser.setInputStream(tokens);
            // begin parsing at program rule:
            ParseTree tree = parser.program();
            if (parser.getNumberOfSyntaxErrors() == 0) {
               // print LISP-style tree:
               // System.out.println(tree.toStringTree(parser));
               compiler.visit(tree);
            }
            if (sc.hasNextLine())
               lineText = sc.nextLine();
            else
               lineText = null;
            numLine++;
         }
      }
      catch(RecognitionException e) {
         e.printStackTrace();
         System.exit(1);
      }
   }
   public static void runInterpreter(String sourceFile){
      assert sourceFile != null && !sourceFile.isEmpty();
      try {
         // create a CharStream that reads from standard input:
         CharStream input = CharStreams.fromStream(new FileInputStream(sourceFile));
         // create a lexer that feeds off of input CharStream:
         BDEXLexer lexer = new BDEXLexer(input);
         // create a buffer of tokens pulled from the lexer:
         CommonTokenStream tokens = new CommonTokenStream(lexer);
         // create a parser that feeds off the tokens buffer:
         BDEXParser parser = new BDEXParser(tokens);
         // replace error listener:
         //parser.removeErrorListeners(); // remove ConsoleErrorListener
         //parser.addErrorListener(new ErrorHandlingListener());
         // begin parsing at program rule:
         ParseTree tree = parser.program();
         if (parser.getNumberOfSyntaxErrors() == 0) {
            // print LISP-style tree:
            // System.out.println(tree.toStringTree(parser));
            BDEXvis visitor0 = new BDEXvis();
            visitor0.visit(tree);
         }
      }
      catch(IOException e) {
         e.printStackTrace();
         System.exit(1);
      }
      catch(RecognitionException e) {
         e.printStackTrace();
         System.exit(1);
      }
   }
}
