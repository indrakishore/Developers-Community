public class Quicksort {
    // Function to print the final array
    public static void printarray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void sort(int arr[], int si, int ei) {
        // base case
        if (si >= ei) {
            return;
        }
        // last element
        int pivot_index = partition(arr, si, ei);
        // left part
        sort(arr, si, pivot_index - 1);
        // right part
        sort(arr, pivot_index + 1, ei);

    }

    public static int partition(int arr[], int si, int ei) {
        int pivot = arr[ei];
        int i = si - 1; // to make place for elements smaller than pivot

        for (int j = si; j < ei; j++) {
            if (arr[j] <= pivot) {
                i++;
                // swap
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }

        }
        i++;
        // swap
        int temp = pivot;
        arr[ei] = arr[i];
        arr[i] = temp;
        return i;
    }

    public static void main(String args[]) {
        int arr[] = { 6, 3, 9, 8, 2, 5 };
        sort(arr, 0, arr.length - 1);
        printarray(arr);
    }
}
