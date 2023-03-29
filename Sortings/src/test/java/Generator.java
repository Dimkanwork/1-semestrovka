import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Generator {

    public  void generate() throws IOException {
        int count = 1;
        int size = 1;

        while (count != 30){
            List<Integer> list = getData(size);
            FileWriter fileWriter = new FileWriter("src/test/java/filesForTests/FILE" + count + ".txt");
            for (int i = 0; i < size; i++) {
                fileWriter.write("" + list.get(i));
                fileWriter.write("\n");
            }
            size  *= 2;
            count++;
            fileWriter.close();
        }

    }


    public static int[] randomG(int V) {
        int[] mass = new int[V];
        Random random = new Random();

        for (int i = 0; i < V; i++) {
            mass[i] = random.nextInt(1000000);
        }
        return mass;
    }


    public  List<Integer> getData(int V){
        List<Integer> list;
        int[] array;

        list = new ArrayList<>();
        array = randomG(V);
        for (int i = 0; i < V; i++) {
            list.add(array[i]);
        }
        return list;
    }
}

