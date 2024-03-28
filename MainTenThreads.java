import utils.ImportantFunctions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class MainTenThreads {
    static final int TOTAL_THREADS = 10;
    static final String input = "./assets/input_data.txt";
    static final String output = "./assets/output_data_ten_threads.txt";
    static final String outputTemp = "./assets/output_data_ten_threads_temp.txt";

    public static void main(String[] args) {
        ArrayList<Integer> primals = new ArrayList<>();
        ArrayList<Thread> tasks = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(new File(input));
            PrintWriter writer = new PrintWriter(output);
            PrintWriter tempWriter = new PrintWriter(outputTemp);

            int linesReaded = 0;
            while (scanner.hasNextLine()) {

                String line = scanner.nextLine();

                Thread task = new Thread(() -> {
                    long startTime = System.currentTimeMillis();
                    int formattedLineNumber = Integer.parseInt(line);
                    if (ImportantFunctions.primalVerifier(formattedLineNumber)) {
                        primals.add(formattedLineNumber);
                        writer.println(formattedLineNumber);
                        long endTime = System.currentTimeMillis();
                        long tempoExecucao = endTime - startTime;
                        tempWriter.println(tempoExecucao);
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
            scanner.close();
            writer.close();
            tempWriter.close();
        } catch (FileNotFoundException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}
