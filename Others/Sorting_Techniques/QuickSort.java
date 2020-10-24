package Sorting_Techniques;

class QuickSort {

    public static void quickSort(int ar[], int p, int r) {
        if (p < r) {
            int q = partition(ar, p, r);
            quickSort(ar, p, q - 1);
            quickSort(ar, q + 1, r);
        }
    }

    public static int partition(int ar[], int p, int r) {
        int x = ar[r];
        int i = p - 1;
        for (int j = p; j < r; j++) {
            if (ar[j] <= x) {
                i++;
                int temp = ar[i];
                ar[i] = ar[j];
                ar[j] = temp;
            }
        }
        int temp = ar[i + 1];
        ar[i + 1] = ar[r];
        ar[r] = temp;
        return i + 1;
    }

    public static void main(String args[]) {
        int ar[] = { 3, 45, 23, 11, 1 };
        int p = 0;
        int r = 4;
        quickSort(ar, p, r);
        for (int i = 0; i < 5; i++) {
            System.out.println(ar[i]);
        }
    }
}