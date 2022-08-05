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
        final int N = 30;
        helper.init(N);
        final String[] xs = helper.random(String.class, r -> {
            final int x = r.nextInt(1000000000);
            final BigInteger b = BigInteger.valueOf(x).multiply(BigInteger.valueOf(1000000));
            return b.toString();
        });
        //shuffle again
        List<String> strList = Arrays.asList(xs);
        Collections.shuffle(strList);
        String xs1[] = strList.toArray(new String[strList.size()]);
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
        String test1 = ys[i];
        String test2 = ys[i+1];
        assertTrue(test1.charAt(0) <= test2.charAt(0));
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
    }


    @Test
    public void benchmarkQuickSort() {

        for (int i = 1000; i < 50000; i = i * 2) {
            for (int k = 0; k < 5; k++){
                final Config config = ConfigTest.setupConfig("true", "0", "1", "", "");
                final QuickSort<String> sorter = new QuickSort<>(HuskyCoderFactory.asciiCoder, config);
                final HuskyHelper<String> helper = sorter.getHelper();
                int N = i;
                helper.init(N);
                final String[] xs = helper.random(String.class, r -> {
                    final int x = r.nextInt(1000000000);
                    final BigInteger b = BigInteger.valueOf(x).multiply(BigInteger.valueOf(100000000));
                    return b.toString();
                });
                List<String> strList = Arrays.asList(xs);
                Collections.shuffle(strList);
                String[] xs1 = strList.toArray(new String[N]);
                System.out.println("N: " + N );
                sorter.preProcess(xs1);
                final String[] ys = sorter.sort(xs1);
                sorter.postProcess(ys);
                final ComparisonSortHelper<String> delegateHelper = InstrumentedComparisonSortHelper.getInstrumentedHelper(helper, (InstrumentedComparisonSortHelper<String>) helper.getHelper());
                final PrivateMethodInvoker privateMethodInvoker = new PrivateMethodInvoker(delegateHelper);
                final StatPack statPack = (StatPack) privateMethodInvoker.invokePrivate("getStatPack");
                final int compares = (int) statPack.getStatistics(Instrumenter.COMPARES).mean();
                final int swaps = (int) statPack.getStatistics(Instrumenter.SWAPS).mean();
                System.out.println("compares: " + compares + " swaps: " + swaps);

            }
        }
    }
    @BeforeClass
    public static void before() throws IOException {
        config = Config.load(HuskySortTest.class);
    }

    private static Config config;


    public void testSort() {
    }
}

