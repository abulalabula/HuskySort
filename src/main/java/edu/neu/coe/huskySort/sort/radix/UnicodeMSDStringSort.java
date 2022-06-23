package edu.neu.coe.huskySort.sort.radix;

import edu.neu.coe.huskySort.sort.Sort;
import edu.neu.coe.huskySort.sort.huskySortUtils.UnicodeCharacter;
import edu.neu.coe.huskySort.util.LazyLogger;

import java.util.Random;
import java.util.function.Function;

/**
 * Class to implement Most significant digit string sort (a radix sort) for UnicodeCharacters with custom collation mechanisms.
 * The custom collation is defined by the instance of CharacterMap passed in to the constructor.
 */
public final class UnicodeMSDStringSort extends BaseCountingSort<UnicodeString, UnicodeCharacter> implements Sort<String> {
    /**
     * Generic, non-mutating sort method.
     *
     * @param xs sort the array xs, returning the sorted result, leaving xs unchanged.
     */
    public String[] sort(final String[] xs) {
        return sort(xs, false);
    }

    /**
     * Generic, mutating sort method which operates on a sub-array.
     *
     * @param xs   sort the array xs from "from" until "to" (exclusive of to).
     * @param from the index of the first element to sort.
     * @param to   the index of the first element not to sort.
     */
    public void sort(final String[] xs, final int from, final int to) {
        final int n = to - from;
        aux = new UnicodeString[n];
        final Function<String, UnicodeString> stringUnicodeStringFunction = x -> new UnicodeString(characterMap, x);
        final UnicodeString[] us = getStringComparableStrings(UnicodeString.class, xs, from, n, stringUnicodeStringFunction);
        doRecursiveSort(us, 0, n, 0);
        recoverStrings(xs, from, n, us);
    }

    /**
     * Perform initializing step for this Sort.
     * Invoked by default implementation of preSort(X[], boolean)
     * <p>
     * CONSIDER merging this with preProcess logic.
     *
     * @param n the number of elements to be sorted.
     */
    public void init(final int n) {

    }

    /**
     * Post-process the given array, i.e. after sorting has been completed.
     * WHen benchmarking, this step is typically not timed.
     *
     * @param xs an array of Xs.
     * @return an indication of the success of the postProcess operation.
     */
    public boolean postProcess(final String[] xs) {
        return false;
    }

    /**
     * Close this sorter, performing any appropriate cleanup.
     */
    public void close() {

    }

    /**
     * Constructor of UnicodeMSDStringSort, which requires a CharacterMap.
     *
     * @param characterMap the appropriate character map for the type of unicode strings to be sorted.
     */
    public UnicodeMSDStringSort(final CharacterMap characterMap, final CountingSortHelper<UnicodeString, UnicodeCharacter> helper) {
        super(characterMap, helper);
        this.characterMap = characterMap;
        this.helper = helper;
    }

    /**
     * Constructor of UnicodeMSDStringSort, which requires a CharacterMap.
     *
     * @param characterMap the appropriate character map for the type of unicode strings to be sorted.
     */
    public UnicodeMSDStringSort(final CharacterMap characterMap) {
        this(characterMap, new BasicCountingSortHelper<>("UnicodeMSDStringSort", 0, new Random()));
    }

    /**
     * Sort from xs[from] to xs[to] (exclusive), ignoring the first d characters of each String.
     * This method is recursive.
     *
     * @param xs   the array to be sorted.
     * @param from the low index.
     * @param to   the high index (one above the highest actually processed).
     * @param d    the number of characters in each UnicodeString to be skipped.
     */
    private void doRecursiveSort(final UnicodeString[] xs, final int from, final int to, final int d) {
        assert from >= 0 : "from " + from + " is negative";
        assert to <= xs.length : "to " + to + " is out of bounds: " + xs.length;
        final int n = to - from;
        //        logger.debug("UnicodeMSDStringSort.doRecursiveSort: on " +(d > 0 ? xs[from].charAt(d-1) : "root")+ " from="+from+", to="+to+", d="+d);
        // XXX if there are fewer than two elements, we return immediately because xs is already sorted.
        if (n < 2) return;
        // XXX if there is a small number of elements, we switch to insertion sort.
        if (n < helper.getCutoff()) insertionSort(xs, from, to, d);
        else {
            final Counts counts = new Counts();
            counts.countCharacters(xs, from, to, d);
            final UnicodeCharacter[] keys = counts.accumulateCounts();
            for (int i = from; i < to; i++) {
                final UnicodeString xsi = xs[i];
                // CONSIDER aux should be newly constructed here, otherwise we are re-using aux.
                counts.copyAndIncrementCount(xsi, aux, d);
            }
            if (helper.instrumented())
                helper.getInstrumenter().incrementHits(3 * n); // count, copy and copy back
            // XXX Copy back.
            System.arraycopy(aux, 0, xs, from, n);
            int offset = 0;
            // XXX For each key, recursively sort the appropriate sub-array on the next character position (p).
            final int p = d + 1;
            for (final UnicodeCharacter key : keys) {
                if (key == UnicodeCharacter.NullChar)
                    continue;
                final int index = counts.get(key);
                doRecursiveSort(xs, from + offset, from + index, p);
                offset = index;
            }
        }
    }

    /**
     * Execute insertion sort on the given sub-array, but skipping the first d characters when determining the order.
     *
     * @param xs   an array.
     * @param from the first element of the array to be considered.
     * @param to   the first element following the sub-array NOT to be considered.
     * @param d    the number of characters to be ignored.
     */
    private void insertionSort(final UnicodeString[] xs, final int from, final int to, final int d) {
//        logger.debug("UnicodeMSDStringSort.insertionSort: on " +(d > 0 ? xs[from].charAt(d-1) : "root")+ " from="+from+", to="+to+", d="+d);
        for (int i = from; i < to; i++)
            for (int j = i; j > from && helper.less(xs, j, j - 1, d); j--)
                helper.swap(xs, j, j - 1);
    }

    final static LazyLogger logger = new LazyLogger(UnicodeMSDStringSort.class);

    private static final int cutoff = 15; // XXX default value for the insertion sort cutoff.

    private static UnicodeString[] aux; // XXX auxiliary array for distribution.

    private final CharacterMap characterMap; // NOTE this is used, despite IDEA's analysis.
    private final CountingSortHelper<UnicodeString, UnicodeCharacter> helper;
}