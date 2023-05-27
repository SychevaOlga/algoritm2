public class HeapSort {
    public void sort(int[] arr) {
        int n = arr.length;
 
        // Построение кучи (перегруппировка массива)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);
 
        // Извлечение элементов из кучи по одному
        for (int i=n-1; i>0; i--) {
            // Перемещение текущего корня в конец
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
 
            // Перегруппировка кучи для измененного корня
            heapify(arr, i, 0);
        }
    }
 
    // Перегруппировка поддерева с корнем i, который является
    // индексом в arr[]. n - размер кучи
    void heapify(int[] arr, int n, int i) {
        int largest = i; // Инициализация наибольшего значения как корня
        int l = 2*i + 1; // левый = 2*i + 1
        int r = 2*i + 2; // правый = 2*i + 2
 
        // Если левый дочерний элемент больше корня
        if (l < n && arr[l] > arr[largest])
            largest = l;
 
        // Если правый дочерний элемент больше, чем самый большой элемент на данный момент
        if (r < n && arr[r] > arr[largest])
            largest = r;
 
        // Если самый большой элемент не корень
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
 
            // Перегруппировка затронутой под-кучи
            heapify(arr, n, largest);
        }
    }
}

// Чтобы запустить сортировку, используйте следующий код:

HeapSort heapSort = new HeapSort();
int arr[] = {12, 11, 13, 5, 6, 7};
heapSort.sort(arr);
System.out.println("Отсортированный массив: ");
for (int i=0; i<arr.length; ++i)
 System.out.print(arr[i] + " ");