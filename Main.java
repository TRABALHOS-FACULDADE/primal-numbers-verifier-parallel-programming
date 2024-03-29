import utils.ImportantFunctions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static final String input = "./assets/input_data.txt";
    static final String output = "./assets/output_data_one_thread.txt";
    static final String outputTemp = "./assets/output_data_one_thread_temp.txt";

    public static void main(String[] args) {
        long startTimeProgram = System.currentTimeMillis();
        ArrayList<Integer> primals = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(new File(input));
            PrintWriter writer = new PrintWriter(output);
            PrintWriter tempWriter = new PrintWriter(outputTemp);

            while (scanner.hasNextLine()) {

                String line = scanner.nextLine();
                int formattedLineNumber = Integer.parseInt(line);

                Thread task = new Thread(() -> {
                    long startTime = System.currentTimeMillis();
                    if (ImportantFunctions.primalVerifier(formattedLineNumber)) {
                        primals.add(formattedLineNumber);
                        writer.println(formattedLineNumber);
                        long endTime = System.currentTimeMillis();
                        long tempoExecucao = endTime - startTime;
                        tempWriter.println(tempoExecucao);
                    }
                });
                task.start();
            }
            scanner.close();
            writer.close();
            tempWriter.close();
            long endTimeProgram = System.currentTimeMillis();
            System.out.println("Tempo de execução do programa: " + (endTimeProgram - startTimeProgram) + " ms");
        } catch (FileNotFoundException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}
