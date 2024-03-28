import utils.ImportantFunctions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static final String input = "./assets/input_data.txt";
    static final String output = "./assets/output_data_one_thread.txt";

    public static void main(String[] args) {
        ArrayList<Integer> primals = new ArrayList<>();
        long tempoExecucao = 0;

        try {
            Scanner scanner = new Scanner(new File(input));
            PrintWriter writer = new PrintWriter(output);

            long startTime = System.currentTimeMillis();
            while (scanner.hasNextLine()) {

                String line = scanner.nextLine();

                Thread task = new Thread(() -> {
                    int formattedLineNumber = Integer.parseInt(line);
                    if (ImportantFunctions.primalVerifier(formattedLineNumber)) {
                        primals.add(formattedLineNumber);
                        writer.println(formattedLineNumber);
                    }
                });
                task.start();
            }
            long endTime = System.currentTimeMillis();
            tempoExecucao = endTime - startTime;
            scanner.close();
            writer.close();
        } catch (FileNotFoundException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        ImportantFunctions.printPrimalsList(primals);
        System.out.println("Tempo de execução: " + tempoExecucao + " ms");
    }
}
