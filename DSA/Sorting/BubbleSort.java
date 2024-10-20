public class Bubblesort {
    public static void sortinginbubble(int numbers[]) {
        for (int turns = 0; turns < numbers.length - 1; turns++) {
            for (int j = 0; j < numbers.length - 1 - turns; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    // swap
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
    }

    public static void printnumbers(int numbers[]) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        int numbers[] = { 5, 4, 1, 3, 2 };
        sortinginbubble(numbers);
        printnumbers(numbers);
    }
}
// Time complexity will be O(n^2)