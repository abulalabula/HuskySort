package edu.neu.coe.generalBenchmarks;

import edu.neu.coe.huskySort.sort.ComparisonSortHelper;
import edu.neu.coe.huskySort.sort.GenericSort;
import edu.neu.coe.huskySort.sort.HelperFactory;
import edu.neu.coe.huskySort.sort.SortWithHelper;
import edu.neu.coe.huskySort.sort.simple.*;
import edu.neu.coe.huskySort.util.*;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Random;
import java.util.function.Supplier;


public class InsertionSortBenchmarks {



    @Test
    public void testInsertionSortBenchmark1() {
    	final Config config = ConfigTest.setupConfig("true", "0", "1", "", "");
        String description = "Insertion sort";
        final int N = 10;
        ComparisonSortHelper<Integer> helper = HelperFactory.create("InsertionSort", N, config);
        final SortWithHelper<Integer> sorter = new InsertionSort<Integer>(helper);
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
    public void testInsertionSortBenchmark2() {
    	final Config config = ConfigTest.setupConfig("true", "0", "1", "", "");
        String description = "Insertion sort";
        final int N = 50;
        ComparisonSortHelper<Integer> helper = HelperFactory.create("InsertionSort", N, config);
        final SortWithHelper<Integer> sorter = new InsertionSort<Integer>(helper);
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
    public void testInsertionSortBenchmark3() {
    	final Config config = ConfigTest.setupConfig("true", "0", "1", "", "");
        String description = "Insertion sort";
        final int N = 100;
        ComparisonSortHelper<Integer> helper = HelperFactory.create("InsertionSort", N, config);
        final SortWithHelper<Integer> sorter = new InsertionSort<Integer>(helper);
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
    public void testInsertionSortBenchmark4() {
    	final Config config = ConfigTest.setupConfig("true", "0", "1", "", "");
        String description = "Insertion sort";
        final int N = 150;
        ComparisonSortHelper<Integer> helper = HelperFactory.create("InsertionSort", N, config);
        final SortWithHelper<Integer> sorter = new InsertionSort<Integer>(helper);
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
    public void testInsertionSortBenchmark5() {
    	final Config config = ConfigTest.setupConfig("true", "0", "1", "", "");
        String description = "Insertion sort";
        final int N = 200;
        ComparisonSortHelper<Integer> helper = HelperFactory.create("InsertionSort", N, config);
        final SortWithHelper<Integer> sorter = new InsertionSort<Integer>(helper);
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
    public void testInsertionSortBenchmark6() {
    	final Config config = ConfigTest.setupConfig("true", "0", "1", "", "");
        String description = "Insertion sort";
        final int N = 400;
        ComparisonSortHelper<Integer> helper = HelperFactory.create("InsertionSort", N, config);
        final SortWithHelper<Integer> sorter = new InsertionSort<Integer>(helper);
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
    public void testInsertionSortBenchmark7() {
    	final Config config = ConfigTest.setupConfig("true", "1", "1", "", "");
        String description = "Insertion sort";
        final int N = 800;
        ComparisonSortHelper<Integer> helper = HelperFactory.create("InsertionSort", N, config);
        final SortWithHelper<Integer> sorter = new InsertionSort<Integer>(helper);
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
    public void testInsertionSortBenchmark8() {
    	final Config config = ConfigTest.setupConfig("true", "1", "1", "", "");
        String description = "Insertion sort";
        final int N = 1500;
        ComparisonSortHelper<Integer> helper = HelperFactory.create("InsertionSort", N, config);
        final SortWithHelper<Integer> sorter = new InsertionSort<Integer>(helper);
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
    public void testInsertionSortBenchmark9() {
    	final Config config = ConfigTest.setupConfig("true", "1", "1", "", "");
        String description = "Insertion sort";
        final int N = 3000;
        ComparisonSortHelper<Integer> helper = HelperFactory.create("InsertionSort", N, config);
        final SortWithHelper<Integer> sorter = new InsertionSort<Integer>(helper);
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
