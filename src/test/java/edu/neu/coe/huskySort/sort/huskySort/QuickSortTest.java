package edu.neu.coe.huskySort.sort.huskySort;

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
import edu.neu.coe.huskySort.sort.ComparisonSortHelper;
import edu.neu.coe.huskySort.sort.InstrumentedComparisonSortHelper;
import edu.neu.coe.huskySort.sort.SortWithHelper;
import edu.neu.coe.huskySort.sort.huskySortUtils.HuskyCoderFactory;
import edu.neu.coe.huskySort.sort.huskySortUtils.HuskyHelper;
import edu.neu.coe.huskySort.sort.huskySortUtils.HuskySortable;
import edu.neu.coe.huskySort.util.*;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;
import java.util.*;
import java.util.regex.Pattern;

import static edu.neu.coe.huskySort.sort.huskySortUtils.HuskySortHelper.generateRandomAlphaBetaArray;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@SuppressWarnings("MagicConstant")
public class QuickSortTest {

    @Test
    public void testSortString() {

        final Config config = ConfigTest.setupConfig("true", "0", "1", "", "true");
        final QuickSort<String> sorter = new QuickSort<>(HuskyCoderFactory.asciiCoder, config);
        final HuskyHelper<String> helper = sorter.getHelper();
        final int N = 1000;
        helper.init(N);
        final String[] xs = helper.random(String.class, r -> {
            final int x = r.nextInt(1000000000);
            final BigInteger b = BigInteger.valueOf(x).multiply(BigInteger.valueOf(100000000));
            return b.toString();
        });
        //shuffle again
        List<String> strList = Arrays.asList(xs);
        Collections.shuffle(strList);
        String[] xs1 = strList.toArray(new String[strList.size()]);
        final int inversionsOriginal = helper.inversions(xs1);
        System.out.println("inversions: " + inversionsOriginal);
        sorter.preProcess(xs1);
        final String[] ys = sorter.sort(xs1);
        assertTrue("sorted", helper.sorted(xs1));
        sorter.postProcess(ys);
        final ComparisonSortHelper<String> delegateHelper = InstrumentedComparisonSortHelper.getInstrumentedHelper(helper, (InstrumentedComparisonSortHelper<String>) helper.getHelper());
        final PrivateMethodInvoker privateMethodInvoker = new PrivateMethodInvoker(delegateHelper);
        final StatPack statPack = (StatPack) privateMethodInvoker.invokePrivate("getStatPack");
        System.out.println(statPack);
        //test if the string sorted
        int i = (int) (Math.random() * N) % N;
        //The number is bigger than 100000000, thus %7 to check to the digit
        int j = (int) (Math.random() * 100) % 7;
        String test1 = ys[i];
        String test2 = ys[i+1];
        assertTrue(test1.charAt(0) <= test2.charAt(0));
        assertTrue(test1.charAt(j) <= test2.charAt(j));
    }

    @Test
    public void testSortString1() {
        final Config config = ConfigTest.setupConfig("true", "0", "1", "", "");
        final QuickSort<String> sorter = new QuickSort<>(HuskyCoderFactory.asciiCoder, config);
        final HuskyHelper<String> helper = sorter.getHelper();
        final int N = 1001;
        helper.init(N);
        final String[] xs = helper.random(String.class, r -> r.nextLong() + "");
        final int inversionsOriginal = helper.inversions(xs);
        System.out.println("inversions: " + inversionsOriginal);
        sorter.preProcess(xs);
        final String[] ys = sorter.sort(xs);
        assertTrue("sorted", helper.sorted(ys));
        sorter.postProcess(ys);
        final ComparisonSortHelper<String> delegateHelper = InstrumentedComparisonSortHelper.getInstrumentedHelper(helper, (InstrumentedComparisonSortHelper<String>) helper.getHelper());
        final PrivateMethodInvoker privateMethodInvoker = new PrivateMethodInvoker(delegateHelper);
        final StatPack statPack = (StatPack) privateMethodInvoker.invokePrivate("getStatPack");
        System.out.println(statPack);
        //test if the string sorted
        int i = (int) (Math.random() * N) % N;
        String test1 = ys[i];
        String test2 = ys[i + 1];
        assertTrue(test1.charAt(0) <= test2.charAt(0));
        assertTrue(test1.charAt(1) <= test2.charAt(1));
    }


    @BeforeClass
    public static void before() throws IOException {
        config = Config.load(HuskySortTest.class);
    }

    private static Config config;


    public void testSort() {
    }
/*
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

    final static LazyLogger logger = new LazyLogger(QuickSortTest.class);*/
}

