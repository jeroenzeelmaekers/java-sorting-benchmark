package benchmark;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class BubbleSortTest {

    @Test
    public void bubbleSort_ShouldCorrectlySortIntegerArray() {

        Integer[] integerArray = { 5, 4, 10, 50, 128, 45 };
        Integer[] sortedIntegerArray = { 4, 5, 10, 45, 50, 128 };

        BubbleSort.bubbleSort( integerArray );

        assertArrayEquals( sortedIntegerArray, integerArray );
    }

    @Test
    public void bubbleSort_ShouldCorrectlySortDoubleArray() {

        Double[] doubleArray = { 5.2, 10.4, 7.3, 18.45, 4.8, 10.2, 18.44 };
        Double[] sortedDoubleArray = { 4.8, 5.2, 7.3, 10.2, 10.4, 18.44, 18.45 };

        BubbleSort.bubbleSort( doubleArray );

        assertArrayEquals( sortedDoubleArray, doubleArray );
    }
}
