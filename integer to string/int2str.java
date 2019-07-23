
public class int2str {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


	}
	public static String INT2STR (int number) {
	if (number == 0)
		return "0" ;
    StringBuilder tmp = new StringBuilder();
    while (number > 0) { 
        int value = number % 10;
        number = number/10;
        tmp.append(value);
    }
    String s = tmp.substring(0);
    tmp = new StringBuilder();
    for (int i = s.length() -1; i >= 0; i--) { 
        tmp.append(s.charAt(i));
    }
    return tmp.substring(0);
		
	}
	// other solution
	public static String intToString3 (int n) { 
		 int eachDigit = n;
		 int afterDivide = n;
		 String myString = "";
		 while(afterDivide >0)
		    {
		        eachDigit = afterDivide % 10;
		        afterDivide = afterDivide / 10;
		        myString += (char)(eachDigit+'0');
		        }
		 String myString1 = "";
		    for(int i =  myString.length() -1 ; i >= 0 ; i--)
		    {
		    	myString1 += myString.charAt(i);
		    }
		   
		   return myString1;
		    
		
	}
		
		
		
	}
	


