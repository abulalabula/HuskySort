package edu.neu.coe.huskySort.sort.huskySort;

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
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

import static edu.neu.coe.huskySort.sort.huskySortUtils.HuskySortHelper.generateRandomAlphaBetaArray;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@SuppressWarnings("MagicConstant")
public class QuickSortTest {


    @Test
    public void testSortTryBySab() {
            final Config config = ConfigTest.setupConfig("true", "0", "1", "", "");
            final QuickSort<String> sorter = new QuickSort<>(HuskyCoderFactory.asciiCoder, config);
            final HuskyHelper<String> helper = sorter.getHelper();
            int N = 1000;
            helper.init(N);
            final String[] xs = helper.random(String.class, r -> r.nextLong() + "");
            final int inversionsOriginal = helper.inversions(xs);
            System.out.println("inversions: " + inversionsOriginal);
            sorter.preProcess(xs);
            final String[] ys = sorter.sort(xs);
            sorter.postProcess(ys);
            final ComparisonSortHelper<String> delegateHelper = InstrumentedComparisonSortHelper.getInstrumentedHelper(helper, (InstrumentedComparisonSortHelper<String>) helper.getHelper());
            final PrivateMethodInvoker privateMethodInvoker = new PrivateMethodInvoker(delegateHelper);
            final StatPack statPack = (StatPack) privateMethodInvoker.invokePrivate("getStatPack");
            System.out.println(statPack);

    }
    @Test
    public void testQuickSort() {
        for (int i = 100; i <= 1000; i= i*10) {
            final Config config = ConfigTest.setupConfig("true", "0", "1", "", "");
            final QuickSort<String> sorter = new QuickSort<>(HuskyCoderFactory.asciiCoder, config);
            final HuskyHelper<String> helper = sorter.getHelper();
            int N = i;
            helper.init(N);
            final String[] xs = helper.random(String.class, r -> r.nextLong() + "");
            final int inversionsOriginal = helper.inversions(xs);
            System.out.println("N: " + N);
            System.out.println("inversions: " + inversionsOriginal);
            sorter.preProcess(xs);
            final String[] ys = sorter.sort(xs);
            sorter.postProcess(ys);
            final ComparisonSortHelper<String> delegateHelper = InstrumentedComparisonSortHelper.getInstrumentedHelper(helper, (InstrumentedComparisonSortHelper<String>) helper.getHelper());
            final PrivateMethodInvoker privateMethodInvoker = new PrivateMethodInvoker(delegateHelper);
            final StatPack statPack = (StatPack) privateMethodInvoker.invokePrivate("getStatPack");
            System.out.println(statPack);
        }
    }
    @Test
    public void testSortString2() {
        final Config config = ConfigTest.setupConfig("true", "0", "1", "", "");
        final QuickSort<String> sorter = new QuickSort<>(HuskyCoderFactory.asciiCoder, config);
        final HuskyHelper<String> helper = sorter.getHelper();
        final int N = 1000;
        helper.init(N);
        final String[] xs = helper.random(String.class, r -> r.nextLong() + "");
        System.out.println("N: " + N);
        sorter.preProcess(xs);
        final String[] ys = sorter.sort(xs);
        sorter.postProcess(ys);
        final ComparisonSortHelper<String> delegateHelper = InstrumentedComparisonSortHelper.getInstrumentedHelper(helper, (InstrumentedComparisonSortHelper<String>) helper.getHelper());
        final PrivateMethodInvoker privateMethodInvoker = new PrivateMethodInvoker(delegateHelper);
        final StatPack statPack = (StatPack) privateMethodInvoker.invokePrivate("getStatPack");
        System.out.println(statPack);
    }

    @Test
    public void testSortString3() {
        final Config config = ConfigTest.setupConfig("true", "0", "1", "", "true");
        final QuickSort<String> sorter = new QuickSort<>(HuskyCoderFactory.asciiCoder, config);
        final HuskyHelper<String> helper = sorter.getHelper();
        final int N = 1000;
        helper.init(N);
        final String[] xs = helper.random(String.class, r -> {
            final int x = r.nextInt(1000000000);
            final BigInteger b = BigInteger.valueOf(x).multiply(BigInteger.valueOf(1000000));
            return b.toString();
        });
        final int inversionsOriginal = helper.inversions(xs);
        System.out.println("inversions: " + inversionsOriginal);
        sorter.preProcess(xs);
        final String[] ys = sorter.sort(xs);
        sorter.postProcess(ys);
        final ComparisonSortHelper<String> delegateHelper = InstrumentedComparisonSortHelper.getInstrumentedHelper(helper, (InstrumentedComparisonSortHelper<String>) helper.getHelper());
        final PrivateMethodInvoker privateMethodInvoker = new PrivateMethodInvoker(delegateHelper);
        final StatPack statPack = (StatPack) privateMethodInvoker.invokePrivate("getStatPack");
        System.out.println(statPack);
    }



    @BeforeClass
    public static void before() throws IOException {
        config = Config.load(HuskySortTest.class);
    }

    private static Config config;


    public void testSort() {
    }
}

