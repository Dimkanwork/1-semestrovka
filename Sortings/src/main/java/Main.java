import bucket.BucketSort;
import bucket.Sorting;

public class Main {

    static void printArray(int[] array) {
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            System.out.print(" ");
        }
        System.out.println();
    }


    public static void main(String[] args) {

        Sorting bucket = new BucketSort();
        int[] mass = {3553, -535, 324, 0, -353534, 55};
        bucket.sort(mass, mass.length);
        printArray(mass);
    }
}