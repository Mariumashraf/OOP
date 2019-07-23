// Mariam Ashraf Hassan , sec : 2 , B.N : 14.

import java.lang.reflect.Array;
import java.util.Arrays;
public class FindRepratedElements {
	void REPEATEDELEMENTS(int array[]) {
		int i , j ;
		if (array == null)
			return ;
		for(i = 0 ; i < array.length ; i++) {
			for(j = i+1 ; j < array.length ; j++) {
				if (array[i] == array[j])
					System.out.println("Repeated Elements Are : " + array[i]);
				
				
			}
			
		}
	} // T.C = n^2.
    void repeatedelements(int array1[]) {
    	int k , m ;
    	if(array1 == null)
    		return ;
    	Arrays.sort(array1);
    	for (k = 0 ; k < array1.length ; k++) {
    		for (m = k+1 ; m < array1.length ; m++) {
    			if(array1[k] == array1[m])
    				System.out.println("Repeated Elements Are : " + array1[k]);
    			
    			
    		}
    	}
    	
    		
    } //T.C = n log n .

	public static void main(String[] args) {
		  FindRepratedElements repeat = new FindRepratedElements(); 
		    int array[] = {2, 5, 2, 7, 1, 9, 7,3}; 
		    repeat.REPEATEDELEMENTS(array); 
		    int array1[] = {10,3,6,9,5,10,9,6 };
		    repeat.repeatedelements(array1);
		

	}

}
