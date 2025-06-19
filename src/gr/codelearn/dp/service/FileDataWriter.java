package gr.codelearn.dp.service;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class FileDataWriter {
    public static void saveToFile(final String fileName, List<String> lines) throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter(fileName));
        for (String line : lines)
            writer.write(line + "\n");
        writer.close();
    }
}
