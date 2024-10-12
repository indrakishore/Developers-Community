import java.util.*;

public class PeakElementFinder {

    public static int findPeakElement(List<Integer> arr) {
        int n = arr.size();
        for (int i = 0; i < n; i++) {
            // Checking for the peak element
            if ((i == 0 || arr.get(i - 1) < arr.get(i)) && 
                (i == n - 1 || arr.get(i) > arr.get(i + 1))) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 5, 1);
        int peakIndex = findPeakElement(arr);
        System.out.println("The peak is at index: " + peakIndex);
    }
}
