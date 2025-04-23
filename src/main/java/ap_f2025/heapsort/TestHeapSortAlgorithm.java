package ap_f2025.heapsort;

import java.util.Comparator;

public class TestHeapSortAlgorithm
{
    public static void main(String[] args)
    {
        int n = 100;
        SortAlgorithm heapSort = new HeapSortAlgorithmImpl();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++)
        {
            arr[i] = "S" + (int) (Math.random() * n);
        }
        System.out.println("Unsorted array is");
        printArray(arr);
        heapSort.sort(arr, Comparator.naturalOrder());
        System.out.println("Sorted array is");
        printArray(arr);
    }

    private static <T> void printArray(T[] arr)
    {
        for (int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
