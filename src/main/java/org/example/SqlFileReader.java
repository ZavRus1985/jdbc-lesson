package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class SqlFileReader {

   public static String sqlQuerry() {

        String sql = "";
        try {
            List<String> lines = Files.readAllLines(Path.of("sqlQuerry.txt"));
            sql = lines.toString();
        } catch (IOException e) {
            throw new RuntimeException("Error reading sql-file: " + "sqlQuerry.txt",  e);
        }
        finally {
            return sql;
        }
    }
}
