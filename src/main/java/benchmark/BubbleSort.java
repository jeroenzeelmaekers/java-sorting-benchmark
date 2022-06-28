package benchmark;

import org.openjdk.jmh.annotations.*;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class BubbleSort {

    public static <T extends Comparable<T>> void bubbleSort(T[] array) {
        int n = array.length;

        while (n > 0) {
            int lastModifiedIndex = 0;

            for (int currentIndex = 1; currentIndex < n; currentIndex++) {
                if (array[currentIndex - 1].compareTo(array[currentIndex]) > 0) {
                    T temp = array[currentIndex - 1];

                    array[currentIndex - 1] = array[currentIndex];
                    array[currentIndex] = temp;

                    lastModifiedIndex = currentIndex;
                }
            }

            n = lastModifiedIndex;
        }

    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @BenchmarkMode(Mode.AverageTime)
    public void run(ArrayContainer a) {
        bubbleSort(a.getArrayToSort());
    }

    @State(Scope.Benchmark)
    public static class ArrayContainer {

        @Param({ "10", "20", "30", "40", "50" })
        private Integer arraySize;

        private Integer[] shuffledArray;

        private Integer[] arrayToSort;

        @Setup(Level.Trial)
        public void initArray() {
            shuffledArray = new Integer[arraySize];

            for (int i = 0; i < arraySize; i++) {
                shuffledArray[i] = new Random().nextInt(1000);
            }
        }

        @Setup(Level.Invocation)
        public void makeArrayCopy() {
            arrayToSort = shuffledArray.clone();
        }

        public Integer[] getArrayToSort() {
            return arrayToSort;
        }
    }

}
