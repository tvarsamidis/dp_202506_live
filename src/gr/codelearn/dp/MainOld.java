package gr.codelearn.dp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class MainOld {
    private static final String ROOT = "data\\";

    public static void main(String[] args) {
        System.out.println("Processing started");
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(ROOT + "input.txt")));
            List<String> lines = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            reader.close();
            if (!lines.get(0).toLowerCase().contains("e") &&
                    !lines.get(0).toLowerCase().contains("t") &&
                    !lines.get(0).toLowerCase().contains("a") &&
                    !lines.get(0).toLowerCase().contains("o")) {
                System.out.println("No english text, no processing done");
                System.exit(1);
            }
            PrintWriter writer = new PrintWriter(new FileWriter(new File(ROOT + "output.txt")));
            for (String s : lines)
                writer.write(s.toUpperCase() + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Processing completed");
    }
}
