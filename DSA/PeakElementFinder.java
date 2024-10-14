import java.util.Scanner;

public class PeakElementFinder {

    public static int findPeakElement(int[] arr) {
        return findPeakUtil(arr, 0, arr.length - 1);
    }

    private static int findPeakUtil(int[] arr, int left, int right) {
        int mid = left + (right - left) / 2;

        // Check if mid is a peak
        if ((mid == 0 || arr[mid - 1] < arr[mid]) && (mid == arr.length - 1 || arr[mid] > arr[mid + 1])) {
            return mid;
        }

        // If the left neighbor is greater, then the peak lies on the left side
        if (mid > 0 && arr[mid - 1] > arr[mid]) {
            return findPeakUtil(arr, left, mid - 1);
        }

        // If the right neighbor is greater, then the peak lies on the right side
        return findPeakUtil(arr, mid + 1, right);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the length of the array: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int peakIndex = findPeakElement(arr);
        
        System.out.println("Index of a peak element: " + peakIndex);
        System.out.println("Peak element: " + arr[peakIndex]);

        scanner.close(); // Close the scanner
    }
}
