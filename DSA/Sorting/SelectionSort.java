public class Selectionsort {
    public static void sorting(int numbers[]) {
        for (int i = 0; i < numbers.length - 1; i++) {
            int n = i;
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[n] > numbers[j]) {
                    n = j;
                }
            }
            // swap
            int temp = numbers[n];
            numbers[n] = numbers[i];
            numbers[i] = temp;
        }
    }

    public static void printarray(int numbers[]) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        int numbers[] = { 5, 4, 1, 3, 2 };
        sorting(numbers);
        printarray(numbers);
    }
}
// Time complexity is O(n^2);