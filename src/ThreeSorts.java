//Java Code for Laboratory 6 � Week 6 Sorting Algorithms
//Brunel University London, Computer Science Module CS2004, 2020-2021

import java.util.*;

public class ThreeSorts {
    private static ArrayList<Integer> CopyArray(ArrayList<Integer> a) {
        ArrayList<Integer> result = new ArrayList<Integer>(a.size());
		result.addAll(a);
        return (result);
    }

    // Bubble sort
    public static ArrayList<Integer> SortA(ArrayList<Integer> a) {
        ArrayList<Integer> array = CopyArray(a);
        int n = a.size(), i;
        boolean noswaps = false;

        while (!noswaps) {
            noswaps = true;
            for (i = 0; i < n - 1; ++i) {
                if (array.get(i) < array.get(i + 1)) {
                    Integer temp = array.get(i);
                    array.set(i, array.get(i + 1));
                    array.set(i + 1, temp);
                    noswaps = false;
                }
            }
        }
        return (array);
    }

    // Radix sort
    public static ArrayList<Integer> SortB(ArrayList<Integer> a) {
        ArrayList<Integer> array = CopyArray(a);
        Integer[] zero = new Integer[a.size()];
        Integer[] one = new Integer[a.size()];
        int i, b;
        Integer x, p;

        // Change from 8 to 32 for whole integers - will run 4 times slower
        for (b = 0; b < 8; ++b) {
            int zc = 0;
            int oc = 0;
            for (i = 0; i < array.size(); ++i) {
                x = array.get(i);
                p = 1 << b;
                if ((x & p) == 0) {
                    zero[zc++] = array.get(i);
                } else {
                    one[oc++] = array.get(i);
                }
            }
            for (i = 0; i < oc; ++i) array.set(i, one[i]);
            for (i = 0; i < zc; ++i) array.set(i + oc, zero[i]);
        }
        return (array);
    }

    // Quick sort
    public static ArrayList<Integer> SortC(ArrayList<Integer> a) {
        ArrayList<Integer> array = CopyArray(a);
        SortC(array, 0, array.size() - 1);
        return (array);
    }

    public static void SortC(ArrayList<Integer> array, int first, int last) {
        if (first < last) {
            int pivot = PivotList(array, first, last);
            SortC(array, first, pivot - 1);
            SortC(array, pivot + 1, last);
        }
    }

    private static void Swap(ArrayList<Integer> array, int a, int b) {
        Integer temp = array.get(a);
        array.set(a, array.get(b));
        array.set(b, temp);
    }

    private static int PivotList(ArrayList<Integer> array, int first, int last) {
        Integer PivotValue = array.get(first);
        int PivotPoint = first;

        for (int index = first + 1; index <= last; ++index) {
            if (array.get(index) > PivotValue) {
                PivotPoint = PivotPoint + 1;
                Swap(array, PivotPoint, index);
            }
        }

        Swap(array, first, PivotPoint);
        return (PivotPoint);
    }
}