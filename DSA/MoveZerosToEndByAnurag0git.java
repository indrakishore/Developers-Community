import java.util.Arrays;

public class moveZerosToEnd {

	public static void main(String[] args) {

		int j = 0;
		int arr[] = {8, 1, 0, 2, 1, 0, 3};
		int n = arr.length;
		for(int i = 0; i<n; i++) {
			if(arr[i]!=0 && arr[j]==0) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}if(arr[j]!=0)j++;
		}System.out.print(Arrays.toString(arr));
	}

}
