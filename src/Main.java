import java.util.Arrays;
import java.util.Random;

public class Main {


    public static int[] generateRandomArray(int size) {
        Random random = new Random();
        return random.ints(size, 1, 1000).toArray();
    }


    public static int[] generateAlmostSortedArray(int size) {
        int[] array = generateRandomArray(size);
        Arrays.sort(array);
        Random random = new Random();
        for (int i = 0; i < size / 10; i++) {
            int index1 = random.nextInt(size);
            int index2 = random.nextInt(size);
            int temp = array[index1];
            array[index1] = array[index2];
            array[index2] = temp;
        }
        return array;
    }


    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }


    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }


    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }


    private static void merge(int[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];
        System.arraycopy(array, left, L, 0, n1);
        System.arraycopy(array, mid + 1, R, 0, n2);
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                array[k++] = L[i++];
            } else {
                array[k++] = R[j++];
            }
        }
        while (i < n1) {
            array[k++] = L[i++];
        }
        while (j < n2) {
            array[k++] = R[j++];
        }
    }


    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int p = partition(array, low, high);
            quickSort(array, low, p - 1);
            quickSort(array, p + 1, high);
        }
    }


    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }


    public static void benchmarkSorts(int size) {
        System.out.println("Benchmarking fully randomized array with size: " + size);
        System.out.println("===============================================================");
        int[] randomArray = generateRandomArray(size);
        int[] almostSortedArray = generateAlmostSortedArray(size);

        // Random Array
        int[] copy = Arrays.copyOf(randomArray, randomArray.length);
        long startTime = System.nanoTime();
        insertionSort(copy);
        System.out.println("Insertion Sort on random array: " + (System.nanoTime() - startTime) / 1e9 + " seconds");

        copy = Arrays.copyOf(randomArray, randomArray.length);
        startTime = System.nanoTime();
        selectionSort(copy);
        System.out.println("Selection Sort on random array: " + (System.nanoTime() - startTime) / 1e9 + " seconds");

        copy = Arrays.copyOf(randomArray, randomArray.length);
        startTime = System.nanoTime();
        mergeSort(copy, 0, copy.length - 1);
        System.out.println("Merge Sort on random array: " + (System.nanoTime() - startTime) / 1e9 + " seconds");

        copy = Arrays.copyOf(randomArray, randomArray.length);
        startTime = System.nanoTime();
        quickSort(copy, 0, copy.length - 1);
        System.out.println("Quick Sort on random array: " + (System.nanoTime() - startTime) / 1e9 + " seconds");


        System.out.println();
        System.out.println("Benchmarking almost sorted array with size: " + size);
        System.out.println("===============================================================");


        copy = Arrays.copyOf(almostSortedArray, almostSortedArray.length);
        startTime = System.nanoTime();
        insertionSort(copy);
        System.out.println("Insertion Sort on almost sorted array: " + (System.nanoTime() - startTime) / 1e9 + " seconds");

        copy = Arrays.copyOf(almostSortedArray, almostSortedArray.length);
        startTime = System.nanoTime();
        selectionSort(copy);
        System.out.println("Selection Sort on almost sorted array: " + (System.nanoTime() - startTime) / 1e9 + " seconds");

        copy = Arrays.copyOf(almostSortedArray, almostSortedArray.length);
        startTime = System.nanoTime();
        mergeSort(copy, 0, copy.length - 1);
        System.out.println("Merge Sort on almost sorted array: " + (System.nanoTime() - startTime) / 1e9 + " seconds");

        copy = Arrays.copyOf(almostSortedArray, almostSortedArray.length);
        startTime = System.nanoTime();
        quickSort(copy, 0, copy.length - 1);
        System.out.println("Quick Sort on almost sorted array: " + (System.nanoTime() - startTime) / 1e9 + " seconds");
    }


    public static void main(String[] args) {
        benchmarkSorts(1000);
    }
}
