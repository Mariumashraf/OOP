/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paintbrush;

/**
 *
 * @author lenovo
 */
public class B {
   try {
    Float f1 = new Float("3.0");
    int x = f1.intValue();
    byte b = f1.byteValue();
    double d = f1.doubleValue();
            System.out.println(x+b+d);
    
}catch(NumberFormatException e){
            System.out.println("bad number");
    
}
    
}
