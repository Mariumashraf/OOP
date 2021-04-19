/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paintbrush;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;

/**
 *
 * @author lenovo
 */
public class DisplayImage extends Applet {  
  
   Image image;
    BufferedImage image2;
    URL base;
 
    public void init ()
    {

    }
 
 
    public void paint (Graphics g)
    {
     displayImage(g); 
    }
    
    public void displayImage(Graphics g){
                  JFileChooser chooser = new JFileChooser ();
        try
        {
            int result = chooser.showOpenDialog (this);
            File im1 = chooser.getSelectedFile ();
            image2 = ImageIO.read (im1);
        }
        catch (Exception e)
        {
            System.out.println ("null");
        }
        g.drawImage (image2, 10, 100, this);
    }
    
}
