import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class Main {
    public static int ARRAY_SIZE = 1000;
    public static int BIG_ARRAY_SIZE = 1000000;

    public static void main(String[] args) {

        System.out.println("Подсчет суммы элементов массива на 1000 элементов");
        int[] array = new int[ARRAY_SIZE];
        generationArray(array);

        //Однопоточный подсчет суммы элементов массива
        long timeStart = System.currentTimeMillis();
        int sum = arraySum(array);
        int average = sum/array.length;
        long timeFinish = System.currentTimeMillis();
        System.out.println("Время потраченное на задачу в однопоточном подсчете " + (timeFinish - timeStart));
        System.out.println("Сумма элементов массива: " + sum);
        System.out.println("Среднее арифметическое: " + average);

        //Многопоточный подсчет суммы элементов массива.
        long timeStartMult = System.currentTimeMillis();
        int sumMultiThreadArray = sumArray(array);
        int averageMult = sumMultiThreadArray / array.length;
        long timeFinishMult = System.currentTimeMillis();
        System.out.println("Время потраченное на задачу в многопоточном подсчете " + (timeFinishMult - timeStartMult));
        System.out.println("Сумма элементов массива: " + sumMultiThreadArray);;
        System.out.println("Среднее арифметическое: " + averageMult);

        // пример 2 - массив на 1000000 элементов
        System.out.println("Подсчет суммы элементов массива на 1_000_000 элементов");
        int[] bigArray = new int[BIG_ARRAY_SIZE];
        generationArray(bigArray);

        //Однопоточный подсчет суммы элементов массива
        long timeStart1 = System.currentTimeMillis();
        int sum1 = arraySum(bigArray);
        long timeFinish1 = System.currentTimeMillis();
        int average1 = sum1/bigArray.length;
        System.out.println("Время потраченное на задачу в однопоточном подсчете " + (timeFinish1 - timeStart1));
        System.out.println("Сумма элементов массива: " + sum1);
        System.out.println("Среднее арифметическое: " + average1);

        //Многопоточный подсчет суммы элементов массива.
        long timeStartMult1 = System.currentTimeMillis();
        int sumMultiThreadArray1 = sumArray(bigArray);
        long timeFinishMult1 = System.currentTimeMillis();
        int averageMult1 = sumMultiThreadArray1 / bigArray.length;
        System.out.println("Время потраченное на задачу в многопоточном подсчете " + (timeFinishMult1 - timeStartMult1));
        System.out.println("Сумма элементов массива: " + sumMultiThreadArray1);;
        System.out.println("Среднее арифметическое: " + averageMult1);

    }

    public static void generationArray(int[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(50);
        }
    }

    public static int arraySum(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum = sum + array[i];
        }

        return sum;
    }

    public static int sumArray(int[] array) {
        return ForkJoinPool.commonPool().invoke(new ArraySumTask(array.length, 0, array));
    }
}
