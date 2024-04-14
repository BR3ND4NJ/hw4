import java.io.*;
import java.util.Random;

public class Main {
    public static void randomNumGenerator() throws IOException {
        Random rand = new Random();
        PrintWriter pw = new PrintWriter("nums.txt");

        for (int i = 0; i < 1000; i++) {
            if (i == 999) {
                pw.print(rand.nextInt(100));
            } else {
                pw.println(rand.nextInt(100));
            }
        }

        pw.close();
    }


    public static void insertionSort(int arr[]) {
        for (int i = 1; i < arr.length; ++i) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }


    public static void selectionSort(int arr[]) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++)
                if (arr[j] < arr[minIdx])
                    minIdx = j;

            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }


    void merge(int arr[], int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    void sort(int arr[], int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;

            sort(arr, l, m);
            sort(arr, m + 1, r);

            merge(arr, l, m, r);
        }
    }


    public static int[] quickSort(int arr[]) {
        return arr[];
    }


    public static void main(String[] args) throws IOException{
        randomNumGenerator();

        System.out.println("----------INSERTION SORT---------");
        System.out.println();
        System.out.println();

        System.out.println("----------SELECTION SORT---------");
        System.out.println();
        System.out.println();

        System.out.println("----------MERGE SORT---------");
        System.out.println();
        System.out.println();

        System.out.println("----------QUICK SORT---------");
        System.out.println();
        System.out.println();
        //test 4
    }
}