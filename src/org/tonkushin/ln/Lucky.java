package org.tonkushin.ln;

public class Lucky implements Task {
    long counter = 0;

    @Override
    public String run(String[] data) {
        counter = 0;

        int n = Integer.parseInt(data[0]);

//        countLuckyNumbers(n, 0, 0);
        countLuckyNumbers(n);

        return String.valueOf(counter);
    }

    private void countLuckyNumbers(int n, int sumA, int sumB) {
        if (n == 0) {
            if (sumA == sumB) {
                counter++;
            }

            return;
        }

        for (int a = 0; a < 10; a++) {
            for (int b = 0; b < 10; b++) {
                countLuckyNumbers(n - 1, sumA + a, sumB + b);
            }
        }
    }

    private int[] getNextArray(int[] prevArray) {
        int newLen = prevArray.length + 9;
        int[] array = new int[newLen];

        for (int i = 0; i < newLen; i++) {
            int q = 0;
            for (int j = 0; j < 10; j++) {
                if (i - j >= 0 && i - j < prevArray.length) {
                    q += prevArray[i - j];
                }
            }

            array[i] = q;
        }

        return array;
    }

    private void countLuckyNumbers(int n) {
        int[] array = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};

        for (int i = 1; i < n; i++) {
            array = getNextArray(array);
        }

        for (int j : array) {
            counter += powerN(j, 2);
        }
    }

    long powerN(long number, int power){
        long res = 1;
        long sq = number;
        while(power > 0){
            if(power % 2 == 1){
                res *= sq;
            }
            sq = sq * sq;
            power /= 2;
        }
        return res;
    }
}
