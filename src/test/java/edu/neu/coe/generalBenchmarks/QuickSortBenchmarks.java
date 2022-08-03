package edu.neu.coe.generalBenchmarks;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Random;
import java.util.function.Supplier;

import org.junit.Test;

import edu.neu.coe.huskySort.sort.ComparisonSortHelper;
import edu.neu.coe.huskySort.sort.GenericSort;
import edu.neu.coe.huskySort.sort.HelperFactory;
import edu.neu.coe.huskySort.sort.SortWithHelper;
import edu.neu.coe.huskySort.sort.simple.QuickSort_3way;
import edu.neu.coe.huskySort.util.Benchmark;
import edu.neu.coe.huskySort.util.Config;
import edu.neu.coe.huskySort.util.ConfigTest;
import edu.neu.coe.huskySort.util.Instrumenter;
import edu.neu.coe.huskySort.util.LazyLogger;
import edu.neu.coe.huskySort.util.PrivateMethodInvoker;
import edu.neu.coe.huskySort.util.StatPack;
import edu.neu.coe.huskySort.util.Utilities;

public class QuickSortBenchmarks {

	@Test
    public void testQuickSortBenchmark1() {
    	final Config config = ConfigTest.setupConfig("true", "0", "1", "", "");
        String description = "Qucik sort";
        final int N = 10;
        ComparisonSortHelper<Integer> helper = HelperFactory.create("QuickSort", N, config);
        final SortWithHelper<Integer> sorter = new QuickSort_3way<>(helper);
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
        assertTrue(inversions<=fixes);
    }
	
	@Test
    public void testQuickSortBenchmark2() {
    	final Config config = ConfigTest.setupConfig("true", "0", "1", "", "");
        String description = "Qucik sort";
        final int N = 100;
        ComparisonSortHelper<Integer> helper = HelperFactory.create("QuickSort", N, config);
        final SortWithHelper<Integer> sorter = new QuickSort_3way<>(helper);
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
        assertTrue(inversions<=fixes);
    }
	
	@Test
    public void testQuickSortBenchmark3() {
    	final Config config = ConfigTest.setupConfig("true", "0", "1", "", "");
        String description = "Qucik sort";
        final int N = 200;
        ComparisonSortHelper<Integer> helper = HelperFactory.create("QuickSort", N, config);
        final SortWithHelper<Integer> sorter = new QuickSort_3way<>(helper);
        helper.init(N);
        
        final PrivateMethodInvoker privateMethodInvoker = new PrivateMethodInvoker(helper);
        final StatPack statPack = (StatPack) privateMethodInvoker.invokePrivate("getStatPack");
        Integer[] xs = helper.random(Integer.class, r -> r.nextInt());
        sorter.preProcess(xs);
        Integer[] ys = sorter.sort(xs);
        sorter.postProcess(ys);
        assertTrue(helper.sorted(ys));
        final int hits = (int) statPack.getStatistics(Instrumenter.HITS).mean();
        runBenchmark(description, sorter, helper, N, hits);
        final int inversions = (int) statPack.getStatistics(Instrumenter.INVERSIONS).mean();
        final int fixes = (int) statPack.getStatistics(Instrumenter.FIXES).mean();
        assertTrue(inversions<=fixes);
    }
	
	@Test
    public void testQuickSortBenchmark4() {
    	final Config config = ConfigTest.setupConfig("true", "0", "1", "", "");
        String description = "Qucik sort";
        final int N = 500;
        ComparisonSortHelper<Integer> helper = HelperFactory.create("QuickSort", N, config);
        final SortWithHelper<Integer> sorter = new QuickSort_3way<>(helper);
        helper.init(N);
        
        final PrivateMethodInvoker privateMethodInvoker = new PrivateMethodInvoker(helper);
        final StatPack statPack = (StatPack) privateMethodInvoker.invokePrivate("getStatPack");
        Integer[] xs = helper.random(Integer.class, r -> r.nextInt());
        sorter.preProcess(xs);
        Integer[] ys = sorter.sort(xs);
        sorter.postProcess(ys);
        assertTrue(helper.sorted(ys));
        final int hits = (int) statPack.getStatistics(Instrumenter.HITS).mean();
        runBenchmark(description, sorter, helper, N, hits);
        final int inversions = (int) statPack.getStatistics(Instrumenter.INVERSIONS).mean();
        final int fixes = (int) statPack.getStatistics(Instrumenter.FIXES).mean();
        assertTrue(inversions<=fixes);
    }
	
	@Test
    public void testQuickSortBenchmark5() {
    	final Config config = ConfigTest.setupConfig("true", "0", "1", "", "");
        String description = "Qucik sort";
        final int N = 1000;
        ComparisonSortHelper<Integer> helper = HelperFactory.create("QuickSort", N, config);
        final SortWithHelper<Integer> sorter = new QuickSort_3way<>(helper);
        helper.init(N);
        
        final PrivateMethodInvoker privateMethodInvoker = new PrivateMethodInvoker(helper);
        final StatPack statPack = (StatPack) privateMethodInvoker.invokePrivate("getStatPack");
        Integer[] xs = helper.random(Integer.class, r -> r.nextInt());
        sorter.preProcess(xs);
        Integer[] ys = sorter.sort(xs);
        sorter.postProcess(ys);
        assertTrue(helper.sorted(ys));
        final int hits = (int) statPack.getStatistics(Instrumenter.HITS).mean();
        runBenchmark(description, sorter, helper, N, hits);
        final int inversions = (int) statPack.getStatistics(Instrumenter.INVERSIONS).mean();
        final int fixes = (int) statPack.getStatistics(Instrumenter.FIXES).mean();
        assertTrue(inversions<=fixes);
    }
	
	@Test
    public void testQuickSortBenchmark6() {
    	final Config config = ConfigTest.setupConfig("true", "0", "1", "", "");
        String description = "Qucik sort";
        final int N = 1500;
        ComparisonSortHelper<Integer> helper = HelperFactory.create("QuickSort", N, config);
        final SortWithHelper<Integer> sorter = new QuickSort_3way<>(helper);
        helper.init(N);
        
        final PrivateMethodInvoker privateMethodInvoker = new PrivateMethodInvoker(helper);
        final StatPack statPack = (StatPack) privateMethodInvoker.invokePrivate("getStatPack");
        Integer[] xs = helper.random(Integer.class, r -> r.nextInt());
        sorter.preProcess(xs);
        Integer[] ys = sorter.sort(xs);
        sorter.postProcess(ys);
        assertTrue(helper.sorted(ys));
        final int hits = (int) statPack.getStatistics(Instrumenter.HITS).mean();
        runBenchmark(description, sorter, helper, N, hits);
        final int inversions = (int) statPack.getStatistics(Instrumenter.INVERSIONS).mean();
        final int fixes = (int) statPack.getStatistics(Instrumenter.FIXES).mean();
        assertTrue(inversions<=fixes);
    }
	
	@Test
    public void testQuickSortBenchmark7() {
    	final Config config = ConfigTest.setupConfig("true", "0", "1", "", "");
        String description = "Qucik sort";
        final int N = 2000;
        ComparisonSortHelper<Integer> helper = HelperFactory.create("QuickSort", N, config);
        final SortWithHelper<Integer> sorter = new QuickSort_3way<>(helper);
        helper.init(N);
        
        final PrivateMethodInvoker privateMethodInvoker = new PrivateMethodInvoker(helper);
        final StatPack statPack = (StatPack) privateMethodInvoker.invokePrivate("getStatPack");
        Integer[] xs = helper.random(Integer.class, r -> r.nextInt());
        sorter.preProcess(xs);
        Integer[] ys = sorter.sort(xs);
        sorter.postProcess(ys);
        assertTrue(helper.sorted(ys));
        final int hits = (int) statPack.getStatistics(Instrumenter.HITS).mean();
        runBenchmark(description, sorter, helper, N, hits);
        final int inversions = (int) statPack.getStatistics(Instrumenter.INVERSIONS).mean();
        final int fixes = (int) statPack.getStatistics(Instrumenter.FIXES).mean();
        assertTrue(inversions<=fixes);
    }
	
	@Test
    public void testQuickSortBenchmark8() {
    	final Config config = ConfigTest.setupConfig("true", "0", "1", "", "");
        String description = "Qucik sort";
        final int N = 2500;
        ComparisonSortHelper<Integer> helper = HelperFactory.create("QuickSort", N, config);
        final SortWithHelper<Integer> sorter = new QuickSort_3way<>(helper);
        helper.init(N);
        
        final PrivateMethodInvoker privateMethodInvoker = new PrivateMethodInvoker(helper);
        final StatPack statPack = (StatPack) privateMethodInvoker.invokePrivate("getStatPack");
        Integer[] xs = helper.random(Integer.class, r -> r.nextInt());
        sorter.preProcess(xs);
        Integer[] ys = sorter.sort(xs);
        sorter.postProcess(ys);
        assertTrue(helper.sorted(ys));
        final int hits = (int) statPack.getStatistics(Instrumenter.HITS).mean();
        runBenchmark(description, sorter, helper, N, hits);
        final int inversions = (int) statPack.getStatistics(Instrumenter.INVERSIONS).mean();
        final int fixes = (int) statPack.getStatistics(Instrumenter.FIXES).mean();
        assertTrue(inversions<=fixes);
    }
	
	@Test
    public void testQuickSortBenchmark9() {
    	final Config config = ConfigTest.setupConfig("true", "0", "1", "", "");
        String description = "Qucik sort";
        final int N = 3000;
        ComparisonSortHelper<Integer> helper = HelperFactory.create("QuickSort", N, config);
        final SortWithHelper<Integer> sorter = new QuickSort_3way<>(helper);
        helper.init(N);
        
        final PrivateMethodInvoker privateMethodInvoker = new PrivateMethodInvoker(helper);
        final StatPack statPack = (StatPack) privateMethodInvoker.invokePrivate("getStatPack");
        Integer[] xs = helper.random(Integer.class, r -> r.nextInt());
        sorter.preProcess(xs);
        Integer[] ys = sorter.sort(xs);
        sorter.postProcess(ys);
        assertTrue(helper.sorted(ys));
        final int hits = (int) statPack.getStatistics(Instrumenter.HITS).mean();
        runBenchmark(description, sorter, helper, N, hits);
        final int inversions = (int) statPack.getStatistics(Instrumenter.INVERSIONS).mean();
        final int fixes = (int) statPack.getStatistics(Instrumenter.FIXES).mean();
        assertTrue(inversions<=fixes);
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
