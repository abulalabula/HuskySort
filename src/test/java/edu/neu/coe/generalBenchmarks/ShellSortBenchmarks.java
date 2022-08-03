package edu.neu.coe.generalBenchmarks;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Random;
import java.util.function.Supplier;

import org.junit.Test;

import edu.neu.coe.huskySort.sort.ComparableSortHelper;
import edu.neu.coe.huskySort.sort.ComparisonSortHelper;
import edu.neu.coe.huskySort.sort.GenericSort;
import edu.neu.coe.huskySort.sort.HelperFactory;
import edu.neu.coe.huskySort.sort.SortWithHelper;
import edu.neu.coe.huskySort.sort.simple.ShellSort;
import edu.neu.coe.huskySort.util.Benchmark;
import edu.neu.coe.huskySort.util.Config;
import edu.neu.coe.huskySort.util.ConfigTest;
import edu.neu.coe.huskySort.util.Instrumenter;
import edu.neu.coe.huskySort.util.LazyLogger;
import edu.neu.coe.huskySort.util.PrivateMethodInvoker;
import edu.neu.coe.huskySort.util.StatPack;
import edu.neu.coe.huskySort.util.Utilities;

public class ShellSortBenchmarks {
	
    @Test
    public void testShellSortBenchmark1() {
    	final Config config = ConfigTest.setupConfig("true", "1", "1", "", "");
        String description = "Shell sort";
        final int N = 10;
        ComparisonSortHelper<Integer> helper = HelperFactory.create("ShellSort", N, config);
        final SortWithHelper<Integer> sorter = new ShellSort<Integer>(1, (ComparableSortHelper<Integer>)helper);
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
    public void testShellSortBenchmark2() {
    	final Config config = ConfigTest.setupConfig("true", "1", "1", "", "");
        String description = "Shell sort";
        final int N = 50;
        ComparisonSortHelper<Integer> helper = HelperFactory.create("ShellSort", N, config);
        final SortWithHelper<Integer> sorter = new ShellSort<Integer>(1, (ComparableSortHelper<Integer>)helper);
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
    public void testShellSortBenchmark3() {
    	final Config config = ConfigTest.setupConfig("true", "1", "1", "", "");
        String description = "Shell sort";
        final int N = 100;
        ComparisonSortHelper<Integer> helper = HelperFactory.create("ShellSort", N, config);
        final SortWithHelper<Integer> sorter = new ShellSort<Integer>(1, (ComparableSortHelper<Integer>)helper);
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
    public void testShellSortBenchmark4() {
    	final Config config = ConfigTest.setupConfig("true", "1", "1", "", "");
        String description = "Shell sort";
        final int N = 150;
        ComparisonSortHelper<Integer> helper = HelperFactory.create("ShellSort", N, config);
        final SortWithHelper<Integer> sorter = new ShellSort<Integer>(1, (ComparableSortHelper<Integer>)helper);
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
    public void testShellSortBenchmark5() {
    	final Config config = ConfigTest.setupConfig("true", "1", "1", "", "");
        String description = "Shell sort";
        final int N = 200;
        ComparisonSortHelper<Integer> helper = HelperFactory.create("ShellSort", N, config);
        final SortWithHelper<Integer> sorter = new ShellSort<Integer>(1, (ComparableSortHelper<Integer>)helper);
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
    public void testShellSortBenchmark6() {
    	final Config config = ConfigTest.setupConfig("true", "1", "1", "", "");
        String description = "Shell sort";
        final int N = 300;
        ComparisonSortHelper<Integer> helper = HelperFactory.create("ShellSort", N, config);
        final SortWithHelper<Integer> sorter = new ShellSort<Integer>(1, (ComparableSortHelper<Integer>)helper);
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
    public void testShellSortBenchmark7() {
    	final Config config = ConfigTest.setupConfig("true", "1", "1", "", "");
        String description = "Shell sort";
        final int N = 500;
        ComparisonSortHelper<Integer> helper = HelperFactory.create("ShellSort", N, config);
        final SortWithHelper<Integer> sorter = new ShellSort<Integer>(1, (ComparableSortHelper<Integer>)helper);
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
    public void testShellSortBenchmark8() {
    	final Config config = ConfigTest.setupConfig("true", "1", "1", "", "");
        String description = "Shell sort";
        final int N = 800;
        ComparisonSortHelper<Integer> helper = HelperFactory.create("ShellSort", N, config);
        final SortWithHelper<Integer> sorter = new ShellSort<Integer>(1, (ComparableSortHelper<Integer>)helper);
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
    public void testShellSortBenchmark9() {
    	final Config config = ConfigTest.setupConfig("true", "1", "1", "", "");
        String description = "Shell sort";
        final int N = 1000;
        ComparisonSortHelper<Integer> helper = HelperFactory.create("ShellSort", N, config);
        final SortWithHelper<Integer> sorter = new ShellSort<Integer>(1, (ComparableSortHelper<Integer>)helper);
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
    public void testShellSortBenchmark10() {
    	final Config config = ConfigTest.setupConfig("true", "1", "1", "", "");
        String description = "Shell sort";
        final int N = 1500;
        ComparisonSortHelper<Integer> helper = HelperFactory.create("ShellSort", N, config);
        final SortWithHelper<Integer> sorter = new ShellSort<Integer>(1, (ComparableSortHelper<Integer>)helper);
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
