package ap_f2025.heapsort;

public class HeapSortImpl implements HeapSort
{

    @Override
    public void sort(int[] arr)
    {
        buildHeap(arr);
        int n = arr.length;
        for (int i = n - 1; i >= 0; i--)
        {
            swap(arr, 0, i);
            heapify(arr, i, 0);
        }
    }

    private void heapify(int[] arr, int n, int i)
    {
        int largest = i;
        int l = leftChild(i);
        int r = rightChild(i);

        if (l < n && arr[l] > arr[largest])
        {
            largest = l;
        }

        if (r < n && arr[r] > arr[largest])
        {
            largest = r;
        }

        if (largest != i)
        {
            swap(arr, i, largest);
            heapify(arr, n, largest);
        }
    }

    private void buildHeap(int[] arr)
    {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--)
        {
            heapify(arr, n, i);
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

    private void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
