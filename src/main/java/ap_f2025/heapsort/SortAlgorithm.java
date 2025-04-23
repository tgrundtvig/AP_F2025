package ap_f2025.heapsort;

import java.util.Comparator;

public interface SortAlgorithm
{
    public <T> void sort(T[] arr, Comparator<T> c);
}
