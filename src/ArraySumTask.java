import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ForkJoinPool;

public class ArraySumTask extends RecursiveTask<Integer> {

    public static final int THRESHOLD = 5;
    final int end;
    final int start;
    final int[] array;

    public ArraySumTask(int end, int start, int[] array) {
        this.end = end;
        this.start = start;
        this.array = array;
    }

    @Override
    protected Integer compute() {
        final int diff = end - start;
        switch (diff) {
            case 0:
                return 0;
            case 1:
                return array[start];
            case 2:
                return array[start] + array[start + 1];
            default:
                return forkTasksAndGetResult();
        }
    }

    protected int forkTasksAndGetResult() {

        final int middle = (end - start) / 2 + start;

        // Создаем задачу для левой части диапазона
        ArraySumTask task1 = new ArraySumTask(start, middle, array);

        // Создаем задачу для правой части диапазона
        ArraySumTask task2 = new ArraySumTask(middle , end, array);


        // Запускаем обе задачи в пуле
        invokeAll(task1, task2);

        // Суммируем результаты выполнения обоих задач
        return task1.join() + task2.join();

    }
}