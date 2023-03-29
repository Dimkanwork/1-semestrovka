package tests;


import bucket.BucketSort;
import bucket.Sorting;

public class SortingTest {
    static final int ARRAY_SIZE = 1000000;
    static final boolean PRINT_ARRAY = false;

    static void fillArray(RandomElementGenerator generator, int[] array) {
        for(int i = 0; i < array.length; i++) {
            array[i] = generator.generate(i);
        }
    }

    static void printArray(int[] array) {
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            System.out.print(" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = new int[ARRAY_SIZE];
        fillArray(index -> (int) (Math.random() * 100), array);
        if(PRINT_ARRAY) {
            printArray(array);
        }

        long startTime = System.nanoTime();
        Sorting sorting = new BucketSort();
        sorting.sort(array, array.length);
        long endTime = System.nanoTime();

        if(PRINT_ARRAY) {
            printArray(array);
        }

        System.out.println((endTime - startTime) / 1000);
    }
}
