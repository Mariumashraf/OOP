// Mariam Ashraf Hassan , sec : 2 , B.N : 14.
import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
public class FINDREPEATEDELEMENTS {
	
	public static void main(String[] args) {
		    int[] array = {2, 5, 2, 12, 1, 9, 12,3};
		 //   int[] array1 = {10, 5, 2, 20, 10, 9, 20,3};
		    

		    int[] elements =REPEATEDELEMENTS(array);
		   // int[] elements2 =repeatedelements(array1);
		    
            ArrayList<Integer> list = new ArrayList<>();
           for(int x = 0 ; x < elements.length ; x++) {
              list.add(elements[x]);
            }
            System.out.println(list);

	}
	static int[] REPEATEDELEMENTS(int[] array) {
		int [] arrresult = new int[2];
		 
			int i , j ;
			int counter=0;
			for(i = 0 ; i < array.length ; i++) {
				for(j = i+1 ; j < array.length ; j++) {
					if (array[i] == array[j]) {
						System.out.println("Repeated Elements Are : " + array[i]);
					   arrresult[counter]=array[i];
					   counter ++;
					   
					}
			}
		}
			return arrresult;
		
	} // T.C = n^2.
	/*static int[] repeatedelements(int []array1) {
		int [] arrresult1 = new int[2];

    	int k ;
		int counter1=0;
    	Arrays.sort(array1);
    	for (k = 0 ; k < array1.length ; k++) {
    	
    			if(array1[k] == array1[k+1]) {
    				System.out.println("Repeated Elements Are : " + array1[k]);
    				 arrresult1[counter1]=array1[k];
					   counter1 ++;
    			}
    	
    		}
		return arrresult1;
    		
    } //T.C = n log n*/
	}
	
	
	


