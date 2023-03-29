import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import bucket.BucketSort;
import bucket.Sorting;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class TimeTest {

    public static HashMap<Integer, int[]> allData() throws IOException {
        HashMap<Integer, int[]> data = new HashMap<>();
        int V = 1;
        for (int i = 1; i < 22; i++) {
            File file = new File("src/test/java/filesForTests/FILE" + i + ".txt");
            Scanner scanner = new Scanner(file);
            int[] G = new int[V];
            for (int j = 0; j < V; j++) {
                int val = scanner.nextInt();
                G[j] = val;
            }
            data.put(V, G);
            V *= 2;
        }
        return data;
    }


    public static List<Long> getResult(HashMap<Integer, int[]> allData){
        List<Long> result = new ArrayList<>();
        Sorting bucketSort = new BucketSort();
        int V = 1;
        for (int i = 0; i < allData.size(); i ++) {
            int[] mass = allData.get(V);
            long start = System.nanoTime();
            bucketSort.sort(mass, V);
            long t = (System.nanoTime() - start)/1000;
            result.add(t);
            V *= 2;
        }
        return result;
    }

    public static void creatSheet(List<Long> list){
        String FILE_NAME = "src/test/java/filesForTests/RadixSortResult.xlsx";
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Лютая оценка скорости работы сортировОчки");
        int rowNum = 1;
        int colNum1 = 0;
        int colNum2 = 1;
        int k = 1;
        Row row1 = sheet.createRow(0);
        row1.createCell(0).setCellValue("Time");
        row1.createCell(1).setCellValue("Size");

        System.out.println("Creating excelList");
        for (int i = 0; i < list.size(); i++) {
            Row row = sheet.createRow(rowNum++);
            Cell cell1 = row.createCell(colNum1);
            Cell cell2 = row.createCell(colNum2);

            cell1.setCellValue(list.get(i));
            cell2.setCellValue(k);
            k *= 2;
        }
        try {
            FileOutputStream outputStream = new FileOutputStream(FILE_NAME);
            workbook.write(outputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Done");
    }

    public static void main(String[] args) throws IOException {
        creatSheet(getResult(allData()));

    }
}
