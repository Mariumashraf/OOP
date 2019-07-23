import java.util.Arrays;

public class MergeUniqueArrays {
	public static int[] mergeArrays(int [] firstArr, int [] secondArr) {
		if(firstArr == null || firstArr.length == 0) {
			if(secondArr != null) {
				return Arrays.copyOf(secondArr, secondArr.length);	
			} else {
				return null;
			}
		}
		
		if(secondArr == null || secondArr.length == 0) {
			return Arrays.copyOf(firstArr, firstArr.length);
		}

		int []output = new int[firstArr.length + secondArr.length];
		int firstArrIndex = 0;
		int secondArrIndex = 0;
		int outputIndex = 0;
		

		
		Arrays.sort(firstArr);
		Arrays.sort(secondArr);

		
		while(firstArrIndex < firstArr.length && secondArrIndex < secondArr.length) {
			if(firstArr[firstArrIndex] < secondArr[secondArrIndex]) {
				output[outputIndex] = firstArr[firstArrIndex];
				firstArrIndex++;
			} else {
				output[outputIndex] = secondArr[secondArrIndex];
				secondArrIndex++;
			}
		   outputIndex++;
		}
		
		while(firstArrIndex < firstArr.length ) {
			output[outputIndex] = firstArr[firstArrIndex];
		     firstArrIndex++;
		     outputIndex++;
		
		}
		
		while(secondArrIndex < secondArr.length ) {
			output[outputIndex] = secondArr[secondArrIndex];
			secondArrIndex++;
			outputIndex++;
		}
				
		return output;		
	}

}
