package edu.neu.coe.generalBenchmarks;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Random;
import java.util.function.Supplier;

import org.junit.Test;

import edu.neu.coe.huskySort.sort.ComparisonSortHelper;
import edu.neu.coe.huskySort.sort.GenericSort;
import edu.neu.coe.huskySort.sort.HelperFactory;
import edu.neu.coe.huskySort.sort.SortWithHelper;
import edu.neu.coe.huskySort.sort.simple.MergeSortBasic;
import edu.neu.coe.huskySort.util.Benchmark;
import edu.neu.coe.huskySort.util.Config;
import edu.neu.coe.huskySort.util.ConfigTest;
import edu.neu.coe.huskySort.util.Instrumenter;
import edu.neu.coe.huskySort.util.LazyLogger;
import edu.neu.coe.huskySort.util.PrivateMethodInvoker;
import edu.neu.coe.huskySort.util.StatPack;
import edu.neu.coe.huskySort.util.Utilities;

public class MergeSortBenchmarks {

	@Test
    public void testMergeSortBenchmark1() {
    	final Config config = ConfigTest.setupConfig("true", "1", "1", "", "");
        String description = "Merge sort";
        final int N = 50;
        ComparisonSortHelper<Integer> helper = HelperFactory.create("MergeSort", N, config);
        final SortWithHelper<Integer> sorter = new MergeSortBasic<Integer>(helper);
        helper.init(N);
        
        final PrivateMethodInvoker privateMethodInvoker = new PrivateMethodInvoker(helper);
        final StatPack statPack = (StatPack) privateMethodInvoker.invokePrivate("getStatPack");
        Integer[] xs = helper.random(Integer.class, r -> r.nextInt());
        sorter.preProcess(xs);
        Integer[] ys = sorter.sort(xs);
        sorter.postProcess(ys);
        final int hits = (int) statPack.getStatistics(Instrumenter.HITS).mean();
        runBenchmark(description, sorter, helper, N, hits);
        final int inversions = (int) statPack.getStatistics(Instrumenter.INVERSIONS).mean();
        final int fixes = (int) statPack.getStatistics(Instrumenter.FIXES).mean();
        assertTrue(helper.sorted(ys));
        assertEquals(inversions, fixes);
    }
	
	@Test
    public void testMergeSortBenchmark2() {
    	final Config config = ConfigTest.setupConfig("true", "1", "1", "", "");
        String description = "Merge sort";
        final int N = 100;
        ComparisonSortHelper<Integer> helper = HelperFactory.create("MergeSort", N, config);
        final SortWithHelper<Integer> sorter = new MergeSortBasic<Integer>(helper);
        helper.init(N);
        
        final PrivateMethodInvoker privateMethodInvoker = new PrivateMethodInvoker(helper);
        final StatPack statPack = (StatPack) privateMethodInvoker.invokePrivate("getStatPack");
        Integer[] xs = helper.random(Integer.class, r -> r.nextInt());
        sorter.preProcess(xs);
        Integer[] ys = sorter.sort(xs);
        sorter.postProcess(ys);
        final int hits = (int) statPack.getStatistics(Instrumenter.HITS).mean();
        runBenchmark(description, sorter, helper, N, hits);
        final int inversions = (int) statPack.getStatistics(Instrumenter.INVERSIONS).mean();
        final int fixes = (int) statPack.getStatistics(Instrumenter.FIXES).mean();
        assertTrue(helper.sorted(ys));
        assertEquals(inversions, fixes);
    }
	
	@Test
    public void testMergeSortBenchmark3() {
    	final Config config = ConfigTest.setupConfig("true", "1", "1", "", "");
        String description = "Merge sort";
        final int N = 200;
        ComparisonSortHelper<Integer> helper = HelperFactory.create("MergeSort", N, config);
        final SortWithHelper<Integer> sorter = new MergeSortBasic<Integer>(helper);
        helper.init(N);
        
        final PrivateMethodInvoker privateMethodInvoker = new PrivateMethodInvoker(helper);
        final StatPack statPack = (StatPack) privateMethodInvoker.invokePrivate("getStatPack");
        Integer[] xs = helper.random(Integer.class, r -> r.nextInt());
        sorter.preProcess(xs);
        Integer[] ys = sorter.sort(xs);
        sorter.postProcess(ys);
        final int hits = (int) statPack.getStatistics(Instrumenter.HITS).mean();
        runBenchmark(description, sorter, helper, N, hits);
        final int inversions = (int) statPack.getStatistics(Instrumenter.INVERSIONS).mean();
        final int fixes = (int) statPack.getStatistics(Instrumenter.FIXES).mean();
        assertTrue(helper.sorted(ys));
        assertEquals(inversions, fixes);
    }
	
	@Test
    public void testMergeSortBenchmark4() {
    	final Config config = ConfigTest.setupConfig("true", "1", "1", "", "");
        String description = "Merge sort";
        final int N = 400;
        ComparisonSortHelper<Integer> helper = HelperFactory.create("MergeSort", N, config);
        final SortWithHelper<Integer> sorter = new MergeSortBasic<Integer>(helper);
        helper.init(N);
        
        final PrivateMethodInvoker privateMethodInvoker = new PrivateMethodInvoker(helper);
        final StatPack statPack = (StatPack) privateMethodInvoker.invokePrivate("getStatPack");
        Integer[] xs = helper.random(Integer.class, r -> r.nextInt());
        sorter.preProcess(xs);
        Integer[] ys = sorter.sort(xs);
        sorter.postProcess(ys);
        final int hits = (int) statPack.getStatistics(Instrumenter.HITS).mean();
        runBenchmark(description, sorter, helper, N, hits);
        final int inversions = (int) statPack.getStatistics(Instrumenter.INVERSIONS).mean();
        final int fixes = (int) statPack.getStatistics(Instrumenter.FIXES).mean();
        assertTrue(helper.sorted(ys));
        assertEquals(inversions, fixes);
    }
	
	@Test
    public void testMergeSortBenchmark5() {
    	final Config config = ConfigTest.setupConfig("true", "1", "1", "", "");
        String description = "Merge sort";
        final int N = 800;
        ComparisonSortHelper<Integer> helper = HelperFactory.create("MergeSort", N, config);
        final SortWithHelper<Integer> sorter = new MergeSortBasic<Integer>(helper);
        helper.init(N);
        
        final PrivateMethodInvoker privateMethodInvoker = new PrivateMethodInvoker(helper);
        final StatPack statPack = (StatPack) privateMethodInvoker.invokePrivate("getStatPack");
        Integer[] xs = helper.random(Integer.class, r -> r.nextInt());
        sorter.preProcess(xs);
        Integer[] ys = sorter.sort(xs);
        sorter.postProcess(ys);
        final int hits = (int) statPack.getStatistics(Instrumenter.HITS).mean();
        runBenchmark(description, sorter, helper, N, hits);
        final int inversions = (int) statPack.getStatistics(Instrumenter.INVERSIONS).mean();
        final int fixes = (int) statPack.getStatistics(Instrumenter.FIXES).mean();
        assertTrue(helper.sorted(ys));
        assertEquals(inversions, fixes);
    }
	
	@Test
    public void testMergeSortBenchmark6() {
    	final Config config = ConfigTest.setupConfig("true", "1", "1", "", "");
        String description = "Merge sort";
        final int N = 1600;
        ComparisonSortHelper<Integer> helper = HelperFactory.create("MergeSort", N, config);
        final SortWithHelper<Integer> sorter = new MergeSortBasic<Integer>(helper);
        helper.init(N);
        
        final PrivateMethodInvoker privateMethodInvoker = new PrivateMethodInvoker(helper);
        final StatPack statPack = (StatPack) privateMethodInvoker.invokePrivate("getStatPack");
        Integer[] xs = helper.random(Integer.class, r -> r.nextInt());
        sorter.preProcess(xs);
        Integer[] ys = sorter.sort(xs);
        sorter.postProcess(ys);
        final int hits = (int) statPack.getStatistics(Instrumenter.HITS).mean();
        runBenchmark(description, sorter, helper, N, hits);
        final int inversions = (int) statPack.getStatistics(Instrumenter.INVERSIONS).mean();
        final int fixes = (int) statPack.getStatistics(Instrumenter.FIXES).mean();
        assertTrue(helper.sorted(ys));
        assertEquals(inversions, fixes);
    }
	
	@Test
    public void testMergeSortBenchmark7() {
    	final Config config = ConfigTest.setupConfig("true", "1", "1", "", "");
        String description = "Merge sort";
        final int N = 3200;
        ComparisonSortHelper<Integer> helper = HelperFactory.create("MergeSort", N, config);
        final SortWithHelper<Integer> sorter = new MergeSortBasic<Integer>(helper);
        helper.init(N);
        
        final PrivateMethodInvoker privateMethodInvoker = new PrivateMethodInvoker(helper);
        final StatPack statPack = (StatPack) privateMethodInvoker.invokePrivate("getStatPack");
        Integer[] xs = helper.random(Integer.class, r -> r.nextInt());
        sorter.preProcess(xs);
        Integer[] ys = sorter.sort(xs);
        sorter.postProcess(ys);
        final int hits = (int) statPack.getStatistics(Instrumenter.HITS).mean();
        runBenchmark(description, sorter, helper, N, hits);
        final int inversions = (int) statPack.getStatistics(Instrumenter.INVERSIONS).mean();
        final int fixes = (int) statPack.getStatistics(Instrumenter.FIXES).mean();
        assertTrue(helper.sorted(ys));
        assertEquals(inversions, fixes);
    }
	
	@Test
    public void testMergeSortBenchmark8() {
    	final Config config = ConfigTest.setupConfig("true", "1", "1", "", "");
        String description = "Merge sort";
        final int N = 6400;
        ComparisonSortHelper<Integer> helper = HelperFactory.create("MergeSort", N, config);
        final SortWithHelper<Integer> sorter = new MergeSortBasic<Integer>(helper);
        helper.init(N);
        
        final PrivateMethodInvoker privateMethodInvoker = new PrivateMethodInvoker(helper);
        final StatPack statPack = (StatPack) privateMethodInvoker.invokePrivate("getStatPack");
        Integer[] xs = helper.random(Integer.class, r -> r.nextInt());
        sorter.preProcess(xs);
        Integer[] ys = sorter.sort(xs);
        sorter.postProcess(ys);
        final int hits = (int) statPack.getStatistics(Instrumenter.HITS).mean();
        runBenchmark(description, sorter, helper, N, hits);
        final int inversions = (int) statPack.getStatistics(Instrumenter.INVERSIONS).mean();
        final int fixes = (int) statPack.getStatistics(Instrumenter.FIXES).mean();
        assertTrue(helper.sorted(ys));
        assertEquals(inversions, fixes);
    }
	
	@Test
    public void testMergeSortBenchmark9() {
    	final Config config = ConfigTest.setupConfig("true", "1", "1", "", "");
        String description = "Merge sort";
        final int N = 12800;
        ComparisonSortHelper<Integer> helper = HelperFactory.create("MergeSort", N, config);
        final SortWithHelper<Integer> sorter = new MergeSortBasic<Integer>(helper);
        helper.init(N);
        
        final PrivateMethodInvoker privateMethodInvoker = new PrivateMethodInvoker(helper);
        final StatPack statPack = (StatPack) privateMethodInvoker.invokePrivate("getStatPack");
        Integer[] xs = helper.random(Integer.class, r -> r.nextInt());
        sorter.preProcess(xs);
        Integer[] ys = sorter.sort(xs);
        sorter.postProcess(ys);
        final int hits = (int) statPack.getStatistics(Instrumenter.HITS).mean();
        runBenchmark(description, sorter, helper, N, hits);
        final int inversions = (int) statPack.getStatistics(Instrumenter.INVERSIONS).mean();
        final int fixes = (int) statPack.getStatistics(Instrumenter.FIXES).mean();
        assertTrue(helper.sorted(ys));
        assertEquals(inversions, fixes);
    }
    

    public void runBenchmark(String description, GenericSort<Integer> sort, ComparisonSortHelper<Integer> helper, int N, int hits) {
        helper.init(N);
        Supplier<Integer[]> supplier = () -> helper.random(Integer.class, Random::nextInt);
        final Benchmark<Integer[]> benchmark = new Benchmark<>(
                description + " has " + hits +" hits for " + N + " Integers",
                (xs) -> Arrays.copyOf(xs, xs.length),
                sort::mutatingSort,
                null
        );
        logger.info(Utilities.formatDecimal3Places(benchmark.run(supplier, 1000)) + " ms");
    }

    final static LazyLogger logger = new LazyLogger(InsertionSortBenchmarks.class);
}
