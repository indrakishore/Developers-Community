public class Insertionsort {
    public static void sorting(int numbers[]) {
        for (int i = 1; i < numbers.length - 1; i++) {
            int current = numbers[i];
            int previous = i - 1;
            // finding out the correct position to insert
            while (previous >= 0 && numbers[previous] > numbers[current]) {
                numbers[previous + 1] = numbers[previous];
                previous--;
            }
            // insertion
            numbers[previous + 1] = current;
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
        sorting(numbers);
        printnumbers(numbers);

    }
}
