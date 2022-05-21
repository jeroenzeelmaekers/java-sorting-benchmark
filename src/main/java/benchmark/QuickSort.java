package benchmark;

import org.openjdk.jmh.annotations.*;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class QuickSort {


    public static <T extends Comparable<T>> void quickSort( T[] array, int a, int b ) {

        if ( a < b ) {

            int i = a, j = b;

            T x = array[ ( i + j ) / 2 ];

            do {

                while ( array[ i ].compareTo( x ) < 0 ) i++;
                while ( x.compareTo( array[ j ] ) < 0 ) j--;

                if ( i <= j ) {
                    T tmp = array[ i ];
                    array[ i ] = array[ j ];
                    array[ j ] = tmp;
                    i++;
                    j--;
                }

            } while ( i <= j );

            quickSort( array, a, j );
            quickSort( array, i, b );
        }
    }

    @Benchmark
    @OutputTimeUnit( TimeUnit.NANOSECONDS )
    @BenchmarkMode( Mode.AverageTime )
    public void run( ArrayContainer a ) {
        quickSort( a.getArrayToSort(), 0, a.getArrayToSort().length - 1 );
    }

    @State( Scope.Benchmark )
    public static class ArrayContainer {

        @Param( { "10", "20", "30", "40", "50" } )
        private Integer arraySize;

        private Integer[] shuffledArray;

        private Integer[] arrayToSort;

        @Setup( Level.Trial )
        public void initArray() {
            shuffledArray = new Integer[ arraySize ];

            for ( int i = 0; i < arraySize; i++ ) {
                shuffledArray[ i ] = new Random().nextInt( 1000 );
            }
        }

        @Setup( Level.Invocation )
        public void makeArrayCopy() {
            arrayToSort = shuffledArray.clone();
        }

        public Integer[] getArrayToSort() {
            return arrayToSort;
        }
    }
}