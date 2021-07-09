antlr4 -visitor src/BDEX/READ.g4 
antlr4 -visitor src/BDEX/BDEX.g4 
javac src/BDEX/Types.java src/BDEX/Pair.java src/BDEX/Column.java src/BDEX/Table.java src/BDEX/READ*.java  src/BDEX/csv*.java src/BDEX/BDEX*.java 

