package edu.neu.coe.huskySort.sort.huskySort;

import edu.neu.coe.huskySort.sort.ComparisonSortHelper;
import edu.neu.coe.huskySort.sort.GenericSort;
import edu.neu.coe.huskySort.sort.InstrumentedComparisonSortHelper;
import edu.neu.coe.huskySort.sort.huskySortUtils.HuskyCoderFactory;
import edu.neu.coe.huskySort.sort.huskySortUtils.HuskyHelper;
import edu.neu.coe.huskySort.util.*;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

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


public class QuickSortBenchmark {

        @Test
        public void benchmarkQuickSort1() {
            System.out.println("N = 1000" );
            for (int k = 0; k < 1000; k++){
                final Config config = ConfigTest.setupConfig("true", "0", "1", "", "");
                final QuickSort<String> sorter = new QuickSort<>(HuskyCoderFactory.asciiCoder, config);
                final HuskyHelper<String> helper = sorter.getHelper();
                int N = 1000;
                helper.init(N);
                final String[] xs = helper.random(String.class, r -> {
                    final int x = r.nextInt(1000000000);
                    final BigInteger b = BigInteger.valueOf(x).multiply(BigInteger.valueOf(100000000));
                    return b.toString();
                });
                List<String> strList = Arrays.asList(xs);
                Collections.shuffle(strList);
                String[] xs1 = strList.toArray(new String[xs.length]);
                sorter.preProcess(xs1);
                final String[] ys = sorter.sort(xs1);
                sorter.postProcess(ys);
                assertTrue("sorted", helper.sorted(ys));
                final ComparisonSortHelper<String> delegateHelper = InstrumentedComparisonSortHelper.getInstrumentedHelper(helper, (InstrumentedComparisonSortHelper<String>) helper.getHelper());
                final PrivateMethodInvoker privateMethodInvoker = new PrivateMethodInvoker(delegateHelper);
                final StatPack statPack = (StatPack) privateMethodInvoker.invokePrivate("getStatPack");
                final int compares = (int) statPack.getStatistics(Instrumenter.COMPARES).mean();
                final int swaps = (int) statPack.getStatistics(Instrumenter.SWAPS).mean();
                System.out.println("compares " + compares + " swaps " + swaps);

            }
        }
        @Test
        public void benchmarkQuickSort2() {
            System.out.println("N = 2000");
            for (int k = 0; k < 1000; k++) {
                final Config config = ConfigTest.setupConfig("true", "0", "1", "", "");
                final QuickSort<String> sorter = new QuickSort<>(HuskyCoderFactory.asciiCoder, config);
                final HuskyHelper<String> helper = sorter.getHelper();
                int N = 2000;
                helper.init(N);
                final String[] xs = helper.random(String.class, r -> {
                    final int x = r.nextInt(1000000000);
                    final BigInteger b = BigInteger.valueOf(x).multiply(BigInteger.valueOf(100000000));
                    return b.toString();
                });
                List<String> strList = Arrays.asList(xs);
                Collections.shuffle(strList);
                String[] xs1 = strList.toArray(new String[xs.length]);
                sorter.preProcess(xs1);
                final String[] ys = sorter.sort(xs1);
                sorter.postProcess(ys);
                assertTrue("sorted", helper.sorted(ys));
                final ComparisonSortHelper<String> delegateHelper = InstrumentedComparisonSortHelper.getInstrumentedHelper(helper, (InstrumentedComparisonSortHelper<String>) helper.getHelper());
                final PrivateMethodInvoker privateMethodInvoker = new PrivateMethodInvoker(delegateHelper);
                final StatPack statPack = (StatPack) privateMethodInvoker.invokePrivate("getStatPack");
                final int compares = (int) statPack.getStatistics(Instrumenter.COMPARES).mean();
                final int swaps = (int) statPack.getStatistics(Instrumenter.SWAPS).mean();
                System.out.println("compares " + compares + " swaps " + swaps);

            }
        }

        @Test
        public void benchmarkQuickSort3() {
            System.out.println("N = 3000");
            for (int k = 0; k < 1000; k++) {
                final Config config = ConfigTest.setupConfig("true", "0", "1", "", "");
                final QuickSort<String> sorter = new QuickSort<>(HuskyCoderFactory.asciiCoder, config);
                final HuskyHelper<String> helper = sorter.getHelper();
                int N = 3000;
                helper.init(N);
                final String[] xs = helper.random(String.class, r -> {
                    final int x = r.nextInt(1000000000);
                    final BigInteger b = BigInteger.valueOf(x).multiply(BigInteger.valueOf(100000000));
                    return b.toString();
                });
                List<String> strList = Arrays.asList(xs);
                Collections.shuffle(strList);
                String[] xs1 = strList.toArray(new String[xs.length]);
                sorter.preProcess(xs1);
                final String[] ys = sorter.sort(xs1);
                sorter.postProcess(ys);
                assertTrue("sorted", helper.sorted(ys));
                final ComparisonSortHelper<String> delegateHelper = InstrumentedComparisonSortHelper.getInstrumentedHelper(helper, (InstrumentedComparisonSortHelper<String>) helper.getHelper());
                final PrivateMethodInvoker privateMethodInvoker = new PrivateMethodInvoker(delegateHelper);
                final StatPack statPack = (StatPack) privateMethodInvoker.invokePrivate("getStatPack");
                final int compares = (int) statPack.getStatistics(Instrumenter.COMPARES).mean();
                final int swaps = (int) statPack.getStatistics(Instrumenter.SWAPS).mean();
                System.out.println("compares " + compares + " swaps " + swaps);

            }
        }

        @Test
        public void benchmarkQuickSort4() {
            System.out.println("N = 4000");
            for (int k = 0; k < 1000; k++) {
                final Config config = ConfigTest.setupConfig("true", "0", "1", "", "");
                final QuickSort<String> sorter = new QuickSort<>(HuskyCoderFactory.asciiCoder, config);
                final HuskyHelper<String> helper = sorter.getHelper();
                int N = 4000;
                helper.init(N);
                final String[] xs = helper.random(String.class, r -> {
                    final int x = r.nextInt(1000000000);
                    final BigInteger b = BigInteger.valueOf(x).multiply(BigInteger.valueOf(100000000));
                    return b.toString();
                });
                List<String> strList = Arrays.asList(xs);
                Collections.shuffle(strList);
                String[] xs1 = strList.toArray(new String[xs.length]);
                sorter.preProcess(xs1);
                final String[] ys = sorter.sort(xs1);
                sorter.postProcess(ys);
                assertTrue("sorted", helper.sorted(ys));
                final ComparisonSortHelper<String> delegateHelper = InstrumentedComparisonSortHelper.getInstrumentedHelper(helper, (InstrumentedComparisonSortHelper<String>) helper.getHelper());
                final PrivateMethodInvoker privateMethodInvoker = new PrivateMethodInvoker(delegateHelper);
                final StatPack statPack = (StatPack) privateMethodInvoker.invokePrivate("getStatPack");
                final int compares = (int) statPack.getStatistics(Instrumenter.COMPARES).mean();
                final int swaps = (int) statPack.getStatistics(Instrumenter.SWAPS).mean();
                System.out.println("compares " + compares + " swaps " + swaps);

            }
        }

        @Test
        public void benchmarkQuickSort5() {
            System.out.println("N = 5000");
            for (int k = 0; k < 1000; k++) {
                final Config config = ConfigTest.setupConfig("true", "0", "1", "", "");
                final QuickSort<String> sorter = new QuickSort<>(HuskyCoderFactory.asciiCoder, config);
                final HuskyHelper<String> helper = sorter.getHelper();
                int N = 5000;
                helper.init(N);
                final String[] xs = helper.random(String.class, r -> {
                    final int x = r.nextInt(1000000000);
                    final BigInteger b = BigInteger.valueOf(x).multiply(BigInteger.valueOf(100000000));
                    return b.toString();
                });
                List<String> strList = Arrays.asList(xs);
                Collections.shuffle(strList);
                String[] xs1 = strList.toArray(new String[xs.length]);
                sorter.preProcess(xs1);
                final String[] ys = sorter.sort(xs1);
                sorter.postProcess(ys);
                assertTrue("sorted", helper.sorted(ys));
                final ComparisonSortHelper<String> delegateHelper = InstrumentedComparisonSortHelper.getInstrumentedHelper(helper, (InstrumentedComparisonSortHelper<String>) helper.getHelper());
                final PrivateMethodInvoker privateMethodInvoker = new PrivateMethodInvoker(delegateHelper);
                final StatPack statPack = (StatPack) privateMethodInvoker.invokePrivate("getStatPack");
                final int compares = (int) statPack.getStatistics(Instrumenter.COMPARES).mean();
                final int swaps = (int) statPack.getStatistics(Instrumenter.SWAPS).mean();
                System.out.println("compares " + compares + " swaps " + swaps);

            }
        }
        @Test
        public void benchmarkQuickSort6() {
            System.out.println("N = 6000" );
            for (int k = 0; k < 1000; k++){
                final Config config = ConfigTest.setupConfig("true", "0", "1", "", "");
                final QuickSort<String> sorter = new QuickSort<>(HuskyCoderFactory.asciiCoder, config);
                final HuskyHelper<String> helper = sorter.getHelper();
                int N = 6000;
                helper.init(N);
                final String[] xs = helper.random(String.class, r -> {
                    final int x = r.nextInt(1000000000);
                    final BigInteger b = BigInteger.valueOf(x).multiply(BigInteger.valueOf(100000000));
                    return b.toString();
                });
                List<String> strList = Arrays.asList(xs);
                Collections.shuffle(strList);
                String[] xs1 = strList.toArray(new String[xs.length]);
                sorter.preProcess(xs1);
                final String[] ys = sorter.sort(xs1);
                sorter.postProcess(ys);
                assertTrue("sorted", helper.sorted(ys));
                final ComparisonSortHelper<String> delegateHelper = InstrumentedComparisonSortHelper.getInstrumentedHelper(helper, (InstrumentedComparisonSortHelper<String>) helper.getHelper());
                final PrivateMethodInvoker privateMethodInvoker = new PrivateMethodInvoker(delegateHelper);
                final StatPack statPack = (StatPack) privateMethodInvoker.invokePrivate("getStatPack");
                final int compares = (int) statPack.getStatistics(Instrumenter.COMPARES).mean();
                final int swaps = (int) statPack.getStatistics(Instrumenter.SWAPS).mean();
                System.out.println("compares " + compares + " swaps " + swaps);

            }
        }

        @Test
        public void benchmarkQuickSort7() {
            System.out.println("N = 7000");
            for (int k = 0; k < 1000; k++) {
                final Config config = ConfigTest.setupConfig("true", "0", "1", "", "");
                final QuickSort<String> sorter = new QuickSort<>(HuskyCoderFactory.asciiCoder, config);
                final HuskyHelper<String> helper = sorter.getHelper();
                int N = 7000;
                helper.init(N);
                final String[] xs = helper.random(String.class, r -> {
                    final int x = r.nextInt(1000000000);
                    final BigInteger b = BigInteger.valueOf(x).multiply(BigInteger.valueOf(100000000));
                    return b.toString();
                });
                List<String> strList = Arrays.asList(xs);
                Collections.shuffle(strList);
                String[] xs1 = strList.toArray(new String[xs.length]);
                sorter.preProcess(xs1);
                final String[] ys = sorter.sort(xs1);
                sorter.postProcess(ys);
                assertTrue("sorted", helper.sorted(ys));
                final ComparisonSortHelper<String> delegateHelper = InstrumentedComparisonSortHelper.getInstrumentedHelper(helper, (InstrumentedComparisonSortHelper<String>) helper.getHelper());
                final PrivateMethodInvoker privateMethodInvoker = new PrivateMethodInvoker(delegateHelper);
                final StatPack statPack = (StatPack) privateMethodInvoker.invokePrivate("getStatPack");
                final int compares = (int) statPack.getStatistics(Instrumenter.COMPARES).mean();
                final int swaps = (int) statPack.getStatistics(Instrumenter.SWAPS).mean();
                System.out.println("compares " + compares + " swaps " + swaps);

            }
        }
        @Test
        public void benchmarkQuickSort8() {
            System.out.println("N = 8000");
            for (int k = 0; k < 1000; k++) {
                final Config config = ConfigTest.setupConfig("true", "0", "1", "", "");
                final QuickSort<String> sorter = new QuickSort<>(HuskyCoderFactory.asciiCoder, config);
                final HuskyHelper<String> helper = sorter.getHelper();
                int N = 8000;
                helper.init(N);
                final String[] xs = helper.random(String.class, r -> {
                    final int x = r.nextInt(1000000000);
                    final BigInteger b = BigInteger.valueOf(x).multiply(BigInteger.valueOf(100000000));
                    return b.toString();
                });
                List<String> strList = Arrays.asList(xs);
                Collections.shuffle(strList);
                String[] xs1 = strList.toArray(new String[xs.length]);
                sorter.preProcess(xs1);
                final String[] ys = sorter.sort(xs1);
                sorter.postProcess(ys);
                assertTrue("sorted", helper.sorted(ys));
                final ComparisonSortHelper<String> delegateHelper = InstrumentedComparisonSortHelper.getInstrumentedHelper(helper, (InstrumentedComparisonSortHelper<String>) helper.getHelper());
                final PrivateMethodInvoker privateMethodInvoker = new PrivateMethodInvoker(delegateHelper);
                final StatPack statPack = (StatPack) privateMethodInvoker.invokePrivate("getStatPack");
                final int compares = (int) statPack.getStatistics(Instrumenter.COMPARES).mean();
                final int swaps = (int) statPack.getStatistics(Instrumenter.SWAPS).mean();
                System.out.println("compares " + compares + " swaps " + swaps);

            }
        }
        @Test
        public void benchmarkQuickSort9() {
            System.out.println("N = 9000" );
            for (int k = 0; k < 1000; k++){
                final Config config = ConfigTest.setupConfig("true", "0", "1", "", "");
                final QuickSort<String> sorter = new QuickSort<>(HuskyCoderFactory.asciiCoder, config);
                final HuskyHelper<String> helper = sorter.getHelper();
                int N = 9000;
                helper.init(N);
                final String[] xs = helper.random(String.class, r -> {
                    final int x = r.nextInt(1000000000);
                    final BigInteger b = BigInteger.valueOf(x).multiply(BigInteger.valueOf(100000000));
                    return b.toString();
                });
                List<String> strList = Arrays.asList(xs);
                Collections.shuffle(strList);
                String[] xs1 = strList.toArray(new String[xs.length]);
                sorter.preProcess(xs1);
                final String[] ys = sorter.sort(xs1);
                sorter.postProcess(ys);
                assertTrue("sorted", helper.sorted(ys));
                final ComparisonSortHelper<String> delegateHelper = InstrumentedComparisonSortHelper.getInstrumentedHelper(helper, (InstrumentedComparisonSortHelper<String>) helper.getHelper());
                final PrivateMethodInvoker privateMethodInvoker = new PrivateMethodInvoker(delegateHelper);
                final StatPack statPack = (StatPack) privateMethodInvoker.invokePrivate("getStatPack");
                final int compares = (int) statPack.getStatistics(Instrumenter.COMPARES).mean();
                final int swaps = (int) statPack.getStatistics(Instrumenter.SWAPS).mean();
                System.out.println("compares " + compares + " swaps " + swaps);

            }
        }
        @Test
        public void benchmarkQuickSort10() {
            System.out.println("N = 10000" );
            for (int k = 0; k < 1000; k++){
                final Config config = ConfigTest.setupConfig("true", "0", "1", "", "");
                final QuickSort<String> sorter = new QuickSort<>(HuskyCoderFactory.asciiCoder, config);
                final HuskyHelper<String> helper = sorter.getHelper();
                int N = 10000;
                helper.init(N);
                final String[] xs = helper.random(String.class, r -> {
                    final int x = r.nextInt(1000000000);
                    final BigInteger b = BigInteger.valueOf(x).multiply(BigInteger.valueOf(100000000));
                    return b.toString();
                });
                List<String> strList = Arrays.asList(xs);
                Collections.shuffle(strList);
                String[] xs1 = strList.toArray(new String[xs.length]);
                sorter.preProcess(xs1);
                final String[] ys = sorter.sort(xs1);
                sorter.postProcess(ys);
                assertTrue("sorted", helper.sorted(ys));
                final ComparisonSortHelper<String> delegateHelper = InstrumentedComparisonSortHelper.getInstrumentedHelper(helper, (InstrumentedComparisonSortHelper<String>) helper.getHelper());
                final PrivateMethodInvoker privateMethodInvoker = new PrivateMethodInvoker(delegateHelper);
                final StatPack statPack = (StatPack) privateMethodInvoker.invokePrivate("getStatPack");
                final int compares = (int) statPack.getStatistics(Instrumenter.COMPARES).mean();
                final int swaps = (int) statPack.getStatistics(Instrumenter.SWAPS).mean();
                System.out.println("compares " + compares + " swaps " + swaps);

            }


        }
        /*
        @Test
        public void testQuickSortBenchmark2() {
            final Config config = ConfigTest.setupConfig("true", "0", "1", "", "");
            String description = "Qucik sort";
            final int N = 100;
            ComparisonSortHelper<Integer> helper = HelperFactory.create("QuickSort", N, config);
            final SortWithHelper<Integer> sorter = new QuickSort<>(HuskyCoderFactory.asciiCoder.helper);
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

        }*/
        @BeforeClass
        public static void before() throws IOException {
            config = Config.load(HuskySortTest.class);
        }

        private static Config config;


        public void testSort() {
        }



}
