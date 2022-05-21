package benchmark;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class QuickSortTest {

    @Test
    public void quickSort_ShouldCorrectlySortIntegerArray() {

        Integer[] integerArray = { 5, 4, 10, 50, 128, 45 };
        Integer[] sortedIntegerArray = { 4, 5, 10, 45, 50, 128 };

        QuickSort.quickSort( integerArray, 0, integerArray.length - 1 );

        assertArrayEquals( sortedIntegerArray, integerArray );
    }

    @Test
    public void quickSort_ShouldCorrectlySortDoubleArray() {

        Double[] doubleArray = { 5.2, 10.4, 7.3, 18.45, 4.8, 10.2, 18.44 };
        Double[] sortedDoubleArray = { 4.8, 5.2, 7.3, 10.2, 10.4, 18.44, 18.45 };

        QuickSort.quickSort( doubleArray, 0, doubleArray.length - 1 );

        assertArrayEquals( sortedDoubleArray, doubleArray );
    }
}