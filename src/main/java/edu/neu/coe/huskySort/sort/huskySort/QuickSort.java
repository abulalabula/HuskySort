package edu.neu.coe.huskySort.sort.huskySort;

import edu.neu.coe.huskySort.sort.huskySortUtils.HuskyCoder;
import edu.neu.coe.huskySort.sort.huskySortUtils.HuskyHelper;
import edu.neu.coe.huskySort.util.Config;

import java.util.Arrays;
import java.util.function.Consumer;

public class QuickSort<X extends Comparable<X>> extends AbstractHuskySort<X>  {

    private HuskyHelper<Integer> helper;

    /**
     * Primary constructor to create an implementation of HuskySort which primarily uses Quicksort.
     *
     * @param name       the name of the sorter (used for the helper).
     * @param n          the number of elements to be sorted (may be 0 if unknown).
     * @param huskyCoder the Husky coder.
     * @param postSorter the post-sorter (i.e. the sort method which will fix any remaining inversions).
     * @param config     the configuration.
     */
    public QuickSort(final String name, final int n, final HuskyCoder<X> huskyCoder, final Consumer<X[]> postSorter, final Config config) {
        super(name, n, huskyCoder, postSorter, config);
    }

    /**
     * Secondary constructor to create an implementation of HuskySort which primarily uses Quicksort.
     * The number of elements to be sorted is unknown.
     *
     * @param name       the name of the sorter (used for the helper).
     * @param huskyCoder the Husky coder.
     * @param postSorter the post-sorter (i.e. the sort method which will fix any remaining inversions).
     * @param config     the configuration.
     */
    public QuickSort(final String name, final HuskyCoder<X> huskyCoder, final Consumer<X[]> postSorter, final Config config) {
        this(name, 0, huskyCoder, postSorter, config);
    }

    /**
     * Secondary constructor to create an implementation of HuskySort which primarily uses Quicksort.
     * The name will be QuickHuskySort/System.
     * The post-sorter will be the System sort.
     *
     * @param huskyCoder the Husky coder.
     * @param config     the configuration.
     */
    public QuickSort(final HuskyCoder<X> huskyCoder, final Config config) {
        this("QuickHuskySort/System", huskyCoder, Arrays::sort, config);
    }
    /**
     * Primary sort method, defined in Sort.
     *
     * @param xs   sort the array xs from "from" to "to".
     * @param from the index of the first element to sort.
     * @param to   the index of the first element not to sort.
     */
    public void sort(final X[] xs, final int from, final int to) {
        quickSort(xs, from, to - 1);
    }

    // CONSIDER inlining this private method
    // CONSIDER redefining to to be one higher.
    @SuppressWarnings({"UnnecessaryLocalVariable"})
    private void quickSort(final X[] objects,  final int from, final int to) {


        final int lo = from;
        final int hi = to;
        if (hi <= lo) return;
        int j = partition(objects, lo, hi);
        sort(objects, lo, j-1);
        sort(objects, j+1, hi);

         /*
        if (from < to)
        {

            // pi is partitioning index, arr[p]
            // is now at right place
            int pi = partition(objects, from, to);

            // Separately sort elements before
            // partition and after partition
            quickSort(objects, from, pi - 1);
            quickSort(objects, pi + 1, to);
        }

          */
    }

    private int partition(final X[] objects,  final int lo, final int hi) {

        int i = lo;
        int j = hi;
        int pivot = lo;
        while (true) {

            //lo id the pivot
            // swap item on lo
            while (compare(objects, ++i, pivot) < 0) {
                if (i == hi - 1) break;
            }

            // find item to swap
            while (compare(objects, pivot, --j) < 0) {
                if (j == lo) break;
            }

            // check if i and j cross
            if (i >= j) break;

            swap(objects, i, j);
        }

        // partitioning item lo at j
        swap(objects, lo, j);

        return j;
        /*
        int pivot = hi;

        // Index of smaller element and
        // indicates the right position
        // of pivot found so far
        int i = (lo - 1);

        for(int j = lo; j <= hi - 1; j++)
        {

            // If current element is smaller
            // than the pivot
            if (compare(objects, j,  pivot)< 0)
            {

                // Increment index of
                // smaller element
                i++;
                swap(objects, i, j);
            }
        }
        swap(objects, i + 1, hi);
        return (i + 1);
    }
*/


    }
}
