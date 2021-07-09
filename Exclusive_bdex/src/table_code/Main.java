import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
        // Create table
        System.out.println("Create table");
        Table tabela_1 = new Table("tabela_1", false);

        // Print table
        System.out.print(tabela_1.toString());

        // Create table with types
        System.out.println("Create table with types");
        Table tabela_2 = new Table("tabela_2", false, "Text", "coluna_1", "Text", "coluna_2", "Text", "coluna_3");

        // Print table
        System.out.print(tabela_2.toString());

        // Create Lines
        Object[] line_1 = {"element_1", "element_2", "element_3"};

        Object[] line_2 = {"element_1", "element_2", "element_3"};

        Object[] line_3 = {"element_1", "element_2"};

        // Create table with types
        System.out.println("Create table with types");
        Table tabela_3 = new Table("tabela_3", false, "Text", "coluna_1");

        // Print table
        System.out.print(tabela_3.toString());


        // Create columns
        Column coluna_1 = new Column("coluna_1");

        Column coluna_2 = new Column("coluna_2");

        Column coluna_3 = new Column("coluna_3");

        Column coluna_4 = new Column("coluna_4");

        // Add values to itable

        /* Rules for manipulating values values:
            -> if we trying to add a column wiht the number of elements in that column different from the number of elements from the others from the table then we dont add it [TESTED]
            -> if we trying to add a line wiht the number of elements in that line different from the number of columns from the the table then we dont add it [TESTED]
            -> if we dont have lines then we can add whatever column we want [TESTED]
            -> if we dont have columns then we cant add whatever line we want [TESTED]
            -> if we try to add a column with the same name of one column in the table we dont add the column [TESTED]
            -> if we remove a specific value then it goes back to its default [TESTED]
            -> if we try to add a line with missmatch data we dont add it [TESTED]
        */

        // Add a line to an empty table
        System.out.println("Add a line to an empty table");
        tabela_1.addLin(line_1);

        // Print table
        System.out.print(tabela_1.toString());

        // Add lines with the right ammount of elements
        System.out.println("Add lines with the right ammount of elements");
        tabela_2.addLin(line_1);
        tabela_2.addLin(line_2);

        // Print table
        System.out.print(tabela_2.toString());

        // Add line with the wrong ammount of elements
        System.out.println("Add line with the wrong ammount of elements");
        tabela_2.addLin(line_3);

        // Print table
        System.out.print(tabela_2.toString());

        // Add a columns to an empty table
        System.out.println("Add columns to an empty table");
        tabela_1.addCol(coluna_1);
        tabela_1.addCol(coluna_2);
        tabela_1.addCol(coluna_3);

        // Print table
        System.out.print(tabela_1.toString());
        
        // Add column with repeated column name 
        System.out.println("Add column with repeated column name");
        tabela_3.addCol(coluna_1);

        // Print table
        System.out.print(tabela_3.toString());

        // Add column with the wrong ammount of elements
        System.out.println("Add column with the wrong ammount of elements");
        tabela_2.addCol(coluna_4);

        // Print table
        System.out.print(tabela_2.toString());

        // Create Template departamentos
        System.out.println("Create Template departamentos");
        Table departamento = new Table("Temp_Departamento", true, "Text", "Nome", "Numeric_int", "Nmecs", "Text", "Projeto");
        System.out.print(departamento.toString());

        // Add line to template
        System.out.println("Add line to template");
        departamento.addLin(line_3);
        System.out.println();

        // Create column without data
        Column exames = new Column("exames", "TEXT");

        // Add column without data to template
        System.out.println("Add column without data to template");
        departamento.addCol(exames);
        System.out.print(departamento.toString());

        // Add column with data to template
        System.out.println("Add column with data to template");
        coluna_2.addObj("Hey");
        departamento.addCol(coluna_2);
        System.out.println();

        // Create table to apply template
        System.out.println("Create table to apply template");
        Table DETI = new Table("Deti");

        // Print table
        System.out.print(DETI.toString());
        
        // Apply template to new table
        System.out.println("Apply template new table");
        departamento.applyTemplate(DETI);

        // Print table
        System.out.print(DETI.toString());

        // Join tables with same template
        Table DMAT = new Table("Dmat");
        departamento.applyTemplate(DMAT);
        Object[] st1 = {"Jose", 98865, "p1","e1"};
        Object[] st2 = {"Maria", 98455, "p2","e2"};
        Object[] st3 = {"Ana", 98615, "p2","e2"};
        DMAT.addLin(st1);
        DMAT.addLin(st2);
        DETI.addLin(st3);
        System.out.print(DMAT.toString());
        System.out.print(DETI.toString());
        System.out.println("Join tables with same template");
        Table deps=DMAT.join(DETI);
        System.out.print(deps.toString());

        // Create table to test where
        Table tabela_4 = new Table("tabela_4", false, "Text", "name", "Numeric_int", "age");

        // Create lines
        Object[] line_4 = {"ana", 2};
        Object[] line_5 = {"joão", 40};
        Object[] line_6 = {"pedro", 12};
        Object[] line_7 = {"joana", 27};

        // Add lines to new table
        tabela_4.addLin(line_4);
        tabela_4.addLin(line_5);
        tabela_4.addLin(line_6);
        tabela_4.addLin(line_7);
        
        // Print table
        System.out.print(tabela_4.toString());

        // Check a possible WHERE condition
        System.out.println(tabela_4.checkWhereCondition("age > 20"));
        System.out.println(tabela_4.checkWhereCondition("name > 10"));  // erro
        System.out.println(tabela_4.checkWhereCondition("name == \"ana\""));
        System.out.println(tabela_4.checkWhereCondition("age <= 2"));
        System.out.println(tabela_4.checkWhereCondition("age >= 39"));
        System.out.println(tabela_4.checkWhereCondition("age != 0"));
        // TODO: Adaptar isto concoante o que for defenido no visitor
        System.out.println(tabela_4.checkWhereCondition("\"ana\" in (\"ana\" , 2)"));

        // Add a line with missmatch data
        System.out.println("Add a line with missmatch data");
        Table tabela_5 = new Table("tabela_5", false, "Text", "coluna_1", "Numeric_real", "coluna_2", "Text", "coluna_3");
        Object[] line_9 = {"Type_text", 1.0, 1};
        tabela_5.addLin(line_9);
        System.out.println();

        // Print table
        System.out.print(tabela_5.toString());

        // Add a line with matched data
        System.out.println("Add a line with match data");
        Table tabela_6 = new Table("tabela_6", false, "Text", "coluna_1", "Numeric_real", "coluna_2", "Numeric_int", "coluna_3");
        Object[] line_10 = {"Type_text", 1.1, 1};
        tabela_6.addLin(line_10);

        // Print table
        System.out.print(tabela_6.toString());

        // Remove wrong column from table
        System.out.println("Remove wrong column from table");
        tabela_6.rmData("coluna_4",0);
        System.out.println();

        // Remove wrong index from table
        System.out.println("Remove wrong index from table");
        tabela_6.rmData("coluna_1",8);
        System.out.println();

        // Remove data from table
        System.out.println("Remove data from table");
        tabela_6.rmData("coluna_1",0);
        tabela_6.rmData("coluna_2",0);
        tabela_6.rmData("coluna_3",0);

        // Print table
        System.out.print(tabela_6.toString());
        
        //Read file + create Template and Table
        Table[] tableANDtemplate = Table.fromCsvFile("sample1.csv");
        //Get Template
        Table template = tableANDtemplate[0];
        System.out.print(template.toString());
        //Get Table
        Table t = tableANDtemplate[1];
        System.out.println("Table created from CSV file");
        System.out.print(t.toString());
        
        //Create file from Table
        t.toCvsFile();
    }
}
