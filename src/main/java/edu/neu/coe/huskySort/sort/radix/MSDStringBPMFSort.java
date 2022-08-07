package edu.neu.coe.huskySort.sort.radix;

import java.util.HashMap;

/**
 * Class to implement Most significant digit string sort (a radix sort).
 */
public final class MSDStringBPMFSort {


    /**
     * Sort an array of Strings using MSDStringSort.
     *
     * @param a the array to be sorted.
     */
    public void sort(final String[] a) {
    	String[] bpmfI = {"b","p","m","f","d","t","n","l","g","k","h","j","q","x","zh","ch","sh","r","z","c" ,"s","y","w",""};
		for(int i = 0; i < bpmfI.length; i++) {
			BPMFInitials.put(bpmfI[i], i);
		}
		String[] bpmfM = {"y","i","w","u","ü","yu","yü",""};
		for(int i = 0; i < bpmfM.length; i++) {
			BPMFMedials.put(bpmfM[i], i);
		}
		String[] bpmfF = {"ong","eng","ang","ei","ai","ou","ao","en","an","in","un","ng","n" ,"er","e","o","a","i","u",""};
		for(int i = 0; i < bpmfF.length; i++) {
			BPMFFinals.put(bpmfF[i], i);
		}
		String[] bpmfT = {"1","2","3","4","5"};
		for(int i = 0; i < bpmfT.length; i++) {
			BPMFTone.put(bpmfT[i], i);
		}
        final int n = a.length;
        aux = new String[n];
        sort(a, 0, n, 0);
    }


    public static void setCutoff(final int cutoff) {
        MSDStringBPMFSort.cutoff = cutoff;
    }

    /**
     * Sort from a[lo] to a[hi] (exclusive), ignoring the first d characters of each String.
     * This method is recursive.
     *
     * @param a  the array to be sorted.
     * @param lo the low index.
     * @param hi the high index (one above the highest actually processed).
     * @param d  the number of characters in each String to be skipped.
     */
    private void sort(final String[] a, final int lo, final int hi, final int d) {
        assert lo >= 0 : "lo " + lo + " is negative";
        assert hi <= a.length : "hi " + hi + " is out of bounds: " + a.length;
        if (hi < lo + cutoff) insertionSort(a, lo, hi, d);
        else {
            final int countLength = R+2;
            final int[] count = new int[countLength];
            for (int i = lo; i < hi; i++) {
            	final int x = intAt(a[i], d);
                count[x + 2]++;
            }
            for (int r = 0; r < R + 1; r++)      // Transform counts to indices.
                count[r + 1] += count[r];
            for (int i = lo; i < hi; i++)
                aux[count[intAt(a[i], d) + 1]++] = a[i];
            // Copy back.
            if (hi - lo >= 0) System.arraycopy(aux, 0, a, lo, hi - lo);
            // Recursively sort for each character value.
            for (int r = 0; r < R; r++)
                sort(a, lo + count[r], lo + count[r + 1], d + 1);
        }
    }

    private static int intAt(final String s, final int d) {
        if (d < s.length()) {
        	String[] temp = s.split("-");
        	int x = 0;
        	if(d==0) {
        		x = BPMFInitials.get(temp[d]);
        	}else if(d==1) {
        		x = BPMFMedials.get(temp[d]);
        	}else if(d==2) {
        		x = BPMFFinals.get(temp[d]);
        	}else {
        		x = BPMFTone.get(temp[d]);
        	}
        	return x;
        }
        else return 0;
    }

    private static void insertionSort(final String[] a, final int lo, final int hi, final int d) {
        for (int i = lo; i < hi; i++)
            for (int j = i; j > lo && less(a[j], a[j - 1], d); j--)
                swap(a, j, j - 1);
        if(d<3)
        	insertionSort(a, lo, hi, d+1);
    }

    private static boolean less(final String v, final String w, final int d) {
    	String[] temp1 = v.split("-");
    	String[] temp2 = w.split("-");
    	if(d==0) {
    		return BPMFInitials.get(temp1[d]).compareTo(BPMFInitials.get(temp2[d])) < 0;
    	}else if(d==1) {
    		return BPMFMedials.get(temp1[d]).compareTo(BPMFMedials.get(temp2[d])) < 0;
    	}else if(d==2) {
    		return BPMFFinals.get(temp1[d]).compareTo(BPMFFinals.get(temp2[d])) < 0;
    	}else {
    		if(BPMFTone.get(temp1[d])!=null && BPMFTone.get(temp2[d])!=null) {
    			return BPMFTone.get(temp1[d]).compareTo(BPMFTone.get(temp2[d])) < 0;
    		}
    		return false;
    	}
    }

    private static void swap(final Object[] a, final int j, final int i) {
        final Object temp = a[j];
        a[j] = a[i];
        a[i] = temp;
    }
    
    private static HashMap<String, Integer> BPMFInitials = new HashMap<String, Integer>();
    private static HashMap<String, Integer> BPMFMedials = new HashMap<String, Integer>();
    private static HashMap<String, Integer> BPMFFinals = new HashMap<String, Integer>();
    private static HashMap<String, Integer> BPMFTone = new HashMap<String, Integer>();
    private static int cutoff = 15;
    private static String[] aux;       // auxiliary array for distribution
    private static int R = 43;

}