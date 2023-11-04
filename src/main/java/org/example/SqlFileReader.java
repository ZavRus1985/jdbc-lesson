package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class SqlFileReader {

    static String sqlQuerry() {

        String sql = "";
        try {
            List<String> lines = Files.readAllLines(Path.of("C:\\Users\\Professional\\IdeaProjects\\JDBCLesson1\\sqlQuerry.txt"));
            sql = lines.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            return sql;
        }
    }
}
