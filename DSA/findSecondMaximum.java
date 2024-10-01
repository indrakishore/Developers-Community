public class findSecondMaximum {

	public static void main(String[] args) {
    
		int[] arr = {13, 34, 14, 56, 34, 70};
		int max = Integer.MAX_VALUE+1;
		int secMax = Integer.MIN_VALUE;
		for(int ele: arr) {
			if(ele>max) {
				secMax = max;
				max = ele;
			}else if(ele!=max && ele > secMax) {
				secMax = ele;
			}
		}System.out.print(secMax);

	}

}
