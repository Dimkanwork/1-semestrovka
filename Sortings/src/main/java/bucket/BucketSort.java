package bucket;


import java.util.ArrayList;
import java.util.Collections;

public class BucketSort implements Sorting {

    @Override
    public void sort(int[] arr, int n) {

        if (n <= 0)
            return;

        /**
         * Эта штука нужна, чтобы отключать предупреждения компилятора,
         * связанные с непроверенными операциями
         */
        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] bucket = new ArrayList[n];

        /**
         *  Создаем пустые ведерки(корзины)
         */
        for (int i = 0; i < n; i++)
            bucket[i] = new ArrayList<>();

        /**
         * Отыщем минимум и максимум
         */
        int maxVal = arr[0];
        int minVal =  arr[0];

        for(int i = 1; i < n; i++){
            if(arr[i] > maxVal){
                maxVal = arr[i];
            }
            if(arr[i] < minVal){
                minVal = arr[i];
            }
        }

        double range = maxVal - minVal;
        /**
         * Аккуратно добавляем элементы в корзину.
         */
        for (int i = 0; i < n; i++) {
            int bucketIndex = (int) Math.floor((arr[i] - minVal) / range * (n - 1));
            bucket[bucketIndex].add(arr[i]);
        }

        /**
         * Используем быструю сортировку для каждой корзины.
         * Так же можно было бы использовать нашу сортировку рекурсивно,
         * но тогда просаживаемся по памяти
         */
        for (int i = 0; i < n; i++) {
            Collections.sort((bucket[i]));
        }

        /**
         * Собираем массивчик🤗🤗🤗
         */
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0, size = bucket[i].size(); j < size; j++) {
                arr[index++] = bucket[i].get(j);
            }
        }
    }
}
