package ap_f2025.heapsort;

import java.util.Comparator;

public class HeapSortAlgorithmImpl implements SortAlgorithm
{

    @Override
    public <T> void sort(T[] arr, Comparator<T> c)
    {
        buildHeap(arr, c);
        int n = arr.length;
        for (int i = n - 1; i >= 0; i--)
        {
            swap(arr, 0, i);
            heapify(arr, i, 0, c);
        }
    }

    private <T> void heapify(T[] arr, int n, int i, Comparator<T> c)
    {
        int largest = i;
        int l = leftChild(i);
        int r = rightChild(i);

        if (l < n && c.compare(arr[l], arr[largest]) > 0)
        {
            largest = l;
        }

        if (r < n && c.compare(arr[r], arr[largest]) > 0)
        {
            largest = r;
        }

        if (largest != i)
        {
            swap(arr, i, largest);
            heapify(arr, n, largest, c);
        }
    }

    private <T> void buildHeap(T[] arr, Comparator<T> c)
    {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--)
        {
            heapify(arr, n, i, c);
        }
    }

    private int leftChild(int i)
    {
        return 2 * i + 1;
    }

    private int rightChild(int i)
    {
        return 2 * i + 2;
    }

    private <T> void swap(T[] arr, int i, int j)
    {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
