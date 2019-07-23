import java.util.Arrays;
import java.util.HashSet;

public class GETFRUITS {

	private static boolean b;
	public static void PRINTKILOS(int array[],int k) {
		int i , j ;
		for(i = 0 ; i < array.length ; i++) {
			for(j = i+1 ; j < array.length ; j++) {
				if (array[i] + array[j] == k) {
					System.out.println("Element1 : " + array[i] +" , "+ "Element2 : " + array[j]);
				}
				
				
			}
			
		}
	} // T.C = n^2.
      public static void PrintKilos(int array1[] , int k1) {
      	int n  ;
      	if(array1 == null)
      		return ;
      	Arrays.sort(array1);
      	for (n = 0 ; n < array1.length ; n++) {
      	    if(array1[n] + array1[n+1] == k1)
					System.out.println("Element1 : " + array1[n] +" , "+ "Element2 : " + array1[n+1]);

      	}
      	
      		
      } //T.C = n log n .
      public static void printkilos(int array2[] , int k3) {
    	  HashSet<Integer> tmp  = new HashSet<Integer>();
    	  int p ;
        	for ( p = 0 ; p < array2.length ; p++) {
        		int y = k3 - array2[p] ;
        		if (tmp.contains(y))
        			System.out.println("Element1 : " + array2[p] +" , "+ "Element2 : " + y);
        		else
        			tmp.add(array2[p]);
    	  
      
        	}
      } // T.C = n.
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//GETFRUITS repeat = new GETFRUITS(); 
		    int array[] = {2, 5, 4, 7, 1,3}; 
		    PRINTKILOS(array,9); 
			int array1[] = {5, 5, 3, 7, 1,6}; 
			PRINTKILOS(array1,10); 
			int array2[] = {5, 2,9,4,1,3}; 
			PRINTKILOS(array2,7); 
	}

}
