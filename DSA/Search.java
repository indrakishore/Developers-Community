package DSA;

public class Search {
    /*
     * ----------------------------BINARY SEARCH-------------------------------------
     * 
     * In this searching technique, we should have our Array sorted.
     * We declare our zeroth index as "start" and last index as "end"
     * Now we'll run a while loop untill start is less than equal to end
     * Inside which we calculate the midpoint and compare the key with it.
     * if the element at mid is equal to key, we return mid
     * else if element is smaller than key then we declare our start as "mid+1"
     * else we declare our end as "mid-1"
     * 
     * It is one of the best Searching technique.
     */
    public static int BinarySearch(int numbers[], int key){
        int start = 0, end = numbers.length - 1;

        while(start<=end){
            int mid = (start + end)/2;

            if (numbers[mid] == key){
                return mid;
            }else if (numbers[mid] < key){
                start = mid+1;
            }else{
                end = mid-1;
            }  
        }
        return -1;
    }

    /*
     * ----------------------------LINEAR SEARCH-------------------------------------
     * 
     * In this searching technique, we do not need to sort the array.
     * We just traverse on the whole array and compare it with the key given.
     * 
     * It is best for smaller arrays but worst or even a nightmare for large size arrays.
     */
    public static int LinearSearch(int numbers[], int key){
        for (int i=1; i<numbers.length; i++){
            if(numbers[i] == key){
                return i;
            }
        }
        return -1;
    }
    public static void main (String args[]){
        int numbers[] = {1, 3, 5, 7, 10, 15, 19};
        int key = 10;

        System.out.println("Index for key is : "+BinarySearch(numbers, key));
        System.out.println("Index for key is : "+LinearSearch(numbers, key));
    }
}