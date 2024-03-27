import utils.ImportantFunctions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static final int TOTAL_THREADS = 1;
    static final String input = "./assets/input_data.txt";
    static final String output = "./assets/output_data_one_thread.txt";

    public static void main(String[] args) {
        ArrayList<Integer> primals = new ArrayList<>();
        ArrayList<Thread> tasks = new ArrayList<>();
        long tempoExecucao = 0;

        try {
            Scanner scanner = new Scanner(new File(input));

            long startTime = System.currentTimeMillis();
            int linesReaded = 0;
            while (scanner.hasNextLine()) {

                String line = scanner.nextLine();

                Thread task = new Thread(() -> {
                    int formattedLineNumber = Integer.parseInt(line);
                    if (ImportantFunctions.primalVerifier(formattedLineNumber)) {
                        primals.add(formattedLineNumber);
                    }
                });

                tasks.add(linesReaded % TOTAL_THREADS, task);
                linesReaded++;

                if (linesReaded % TOTAL_THREADS == 0 || !scanner.hasNextLine()) {
                    tasks.get(linesReaded % TOTAL_THREADS).start();

                    for (int i = 0; i < linesReaded % TOTAL_THREADS; i++) {
                        try {
                            tasks.get(i).join();
                        } catch (InterruptedException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                }
            }
            long endTime = System.currentTimeMillis();
            tempoExecucao = endTime - startTime;
            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        ImportantFunctions.printPrimalsList(primals);
        System.out.println("Tempo de execução: " + tempoExecucao + " ms");
    }

}
