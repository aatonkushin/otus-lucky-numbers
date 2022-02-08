package org.tonkushin.ln;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Tester {
    String path;
    Task task;
    Stopwatch stopwatch = new Stopwatch();

    public Tester(Task task, String path) {
        this.task = task;
        this.path = path;
    }

    public void runTests() {
        int nr = 0;
        while (true) {
            Path inFile = Paths.get(path + "test." + nr + ".in");
            Path outFile = Paths.get(path + "test." + nr + ".out");

            if (!Files.exists(inFile) || !Files.exists(outFile)) {
                break;
            }

            stopwatch.start();
            boolean result = runTest(inFile, outFile);
            stopwatch.stop();

            System.out.printf("Test #%d - %b, %d ms%n", nr, result, stopwatch.getElapsedTime());

            nr++;
        }
    }

    private boolean runTest(Path inFile, Path outFile) {
        boolean retVal = false;
        try {
            String[] data = Files.readAllLines(inFile).toArray(new String[0]);
            String expectedResult = Files.readString(outFile).trim();
            String actual = task.run(data).trim();

            retVal = expectedResult.equals(actual);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return retVal;
    }
}
