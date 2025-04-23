package ap_f2025.heapsort;

public class TestHeapSort
{
    public static void main(String[] args)
    {
        int n = 100;
        HeapSort heapSort = new HeapSortImpl();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
        {
            arr[i] = (int) (Math.random() * n);
        }
        System.out.println("Unsorted array is");
        printArray(arr);
        heapSort.sort(arr);
        System.out.println("Sorted array is");
        printArray(arr);
    }

    private static void printArray(int[] arr)
    {
        for (int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
