/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paintbrush;

import java.applet.Applet;
import java.awt.BasicStroke;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import static java.lang.Math.abs;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author lenovo
 */
public class PaintBrush extends Applet {

    //Define actions variables
    private final int FREEHANDACTION = 1;
    private final int LINEACTION = 2;
    private final int RECTACTION = 3;
    private final int FILLRECTACTIION = 4;
    private final int OVALACTION = 5;
    private final int FILLOVALACTION = 6;
    private final int ERASERACTION = 7;
    private final int CLEARALLACTION = 8;
    private final int UNDOACTION = 9;
    private final int SAVEACTION = 10;
    private final int OPENACTION = 11;

    //Define coordinates for drawing
    private int xStartD = 0;
    private int yStartD = 0;
    private int xEndD = 0;
    private int yEndD = 0;

    private int shapeWidth;
    private int shapeHeight;
    //Set Default status
    private int actionStatus = FREEHANDACTION;
    private int colorStatus = 1;
    private Color c = new Color(0, 0, 0);

    //checkboxes flags
    private int fillFlag = 0;
    private int dotFlag = 0;

    //Define lables
    private Label programL, colorL, shapeL, toolsL;

    //Define actions buttons
    private Button btnFreeHand, btnLine, btnRect, btnOval, btnEraser, btnClearAll;
    private Button btnUndo, btnSave, btnOpen;

    //Define colors buttons
    private Button btnRed, btnGreen, btnBlue, btnPurple, btnOrange, btnPink, btnGray, btnYellow;
    
    //Define checkboxes
    private Checkbox filledCheckBox, dottedCheckBox;

    //SAVE IMAGE and create 2dgraphics to hold image drawings
    BufferedImage bufferedImage = new BufferedImage(2000, 1000, BufferedImage.TYPE_INT_RGB);
    Graphics2D g2dI = bufferedImage.createGraphics();

    //open Image
    BufferedImage image2;
    URL base;


    /* BounsUndo Not working
     UndoManager manager = new UndoManager();
     protected UndoManager undoManager = new UndoManager();
    private UndoAction undoAction = null;
     ;*/
    
    
    public void init() {
        resize(2000, 1000);
        programL = new Label("                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 PAINT  BRUSH  PROGRAM                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             ");
        colorL = new Label(" Choose Color :");
        shapeL = new Label(" Choose Shape :");
        toolsL = new Label(" Tools :");

        btnFreeHand = new Button("Free Hand");
        btnLine = new Button("Line");
        btnRect = new Button("Rectangle");
        btnOval = new Button("Oval");
        btnEraser = new Button("Eraser");
        btnClearAll = new Button("Clear All");

        btnRed = new Button("Red");
        btnRed.setBackground(Color.RED);
        btnGreen = new Button("Green");
        btnGreen.setBackground(Color.green);
        btnBlue = new Button("Blue");
        btnBlue.setBackground(Color.blue);
        btnPurple = new Button("Purple");
        btnPurple.setBackground(Color.MAGENTA);
        btnOrange = new Button("Orange");
        btnOrange.setBackground(Color.orange);
        btnPink = new Button("Pink");
        btnPink.setBackground(Color.PINK);
        btnGray = new Button("Gray");
        btnGray.setBackground(Color.GRAY);
        btnYellow = new Button("Yellow");
        btnYellow.setBackground(Color.YELLOW);

        btnUndo = new Button("Undo");
        btnSave = new Button("Save Image");
        btnOpen = new Button("Open Image");

        filledCheckBox = new Checkbox("Filled");
        dottedCheckBox = new Checkbox("Dotted");

        //Add buttons/labels/checkboxes
        add(programL);
        add(colorL);

        add(btnRed);
        add(btnGreen);
        add(btnBlue);
        add(btnPurple);
        add(btnOrange);
        add(btnPink);
        add(btnGray);
        add(btnYellow);

        add(shapeL);

        add(btnFreeHand);
        add(btnLine);
        add(btnRect);
        add(btnOval);

        add(toolsL);
        add(btnEraser);
        add(btnClearAll);

        add(btnUndo);
        add(btnSave);
        add(btnOpen);

        add(filledCheckBox);
        add(dottedCheckBox);

        /*
        Add ItemListener for checkboxes
         */
        filledCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == 1) {
                    fillFlag = 1;
                } else {
                    fillFlag = 0;

                }
            }

        });

        dottedCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == 1) {
                    dotFlag = 1;
                } else {
                    dotFlag = 0;

                }
            }
        });

        //Set Listeners
        btnRed.addActionListener(new MyButtonsListener());
        btnGreen.addActionListener(new MyButtonsListener());
        btnBlue.addActionListener(new MyButtonsListener());
        btnPurple.addActionListener(new MyButtonsListener());
        btnOrange.addActionListener(new MyButtonsListener());
        btnPink.addActionListener(new MyButtonsListener());
        btnGray.addActionListener(new MyButtonsListener());
        btnYellow.addActionListener(new MyButtonsListener());
        btnFreeHand.addActionListener(new MyButtonsListener());
        btnLine.addActionListener(new MyButtonsListener());
        btnRect.addActionListener(new MyButtonsListener());
        btnOval.addActionListener(new MyButtonsListener());
        btnEraser.addActionListener(new MyButtonsListener());
        btnClearAll.addActionListener(new MyButtonsListener());
        btnUndo.addActionListener(new MyButtonsListener());
        btnSave.addActionListener(new MyButtonsListener());
        btnOpen.addActionListener(new MyButtonsListener());

        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                requestFocusInWindow();
                xStartD = e.getX();
                yStartD = e.getY();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                switch (actionStatus) {

                    case LINEACTION: {
                        drawLine(e);
                        break;

                    }
                    case RECTACTION: {
                        drawRetcangle(e);
                        break;

                    }

                    case OVALACTION: {
                        drawOval(e);
                        break;
                    }

                    case ERASERACTION: {
                        eraser();
                        break;
                    }
                    case SAVEACTION: {
                        try {

                            g2dI.dispose();
                            RenderedImage rendImage = bufferedImage;

                            File file = new File("AppletImageNN.jpg");
                            ImageIO.write(rendImage, "jpg", file);

                        } catch (IOException ex) {
                            Logger.getLogger(PaintBrush.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        break;

                    }
                    case UNDOACTION: {
                        /* if (manager.canUndo()) {
                            manager.undo();
                        }*/

                        break;
                    }
                    case OPENACTION: {
                        Graphics g = getGraphics();
                        DisplayImage disImage = new DisplayImage();
                        disImage.displayImage(g);
                        break;
                    }

                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }

        });

        this.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                switch (actionStatus) {
                    case FREEHANDACTION: {
                        drawFreeHand(e);
                        break;

                    }

                }
            }

            @Override
            public void mouseMoved(MouseEvent e) {
            }

        });

    }


    public void setDrawArea() {
        if (xStartD > xEndD && yStartD > yEndD) {
            shapeWidth = abs(xEndD - xStartD);
            shapeHeight = abs(yEndD - yStartD);
            xStartD = xEndD;
            yStartD = yEndD;

        } else if (xStartD < xEndD && yStartD < yEndD) {
            shapeWidth = abs(xEndD - xStartD);
            shapeHeight = abs(yEndD - yStartD);
            xStartD = xStartD;
            yStartD = yStartD;

        } else if (xStartD < xEndD && yStartD > yEndD) {
            shapeWidth = abs(xEndD - xStartD);
            shapeHeight = abs(yEndD - yStartD);
            xStartD = xStartD;
            yStartD = yEndD;

        } else if (xStartD > xEndD && yStartD < yEndD) {
            shapeWidth = abs(xEndD - xStartD);
            shapeHeight = abs(yEndD - yStartD);
            xStartD = xEndD;
            yStartD = yStartD;

        }
    }

    public void drawFreeHand(MouseEvent e) {
        Graphics g = getGraphics();
        g2dI.setColor(Color.white);
        g2dI.fillRect(0, 0, 2000, 1000);
        g.setColor(c);
        g2dI.setColor(c);
        xEndD = e.getX();
        yEndD = e.getY();
        if (dotFlag == 1) {
            Graphics2D g2d = (Graphics2D) g;
            float[] d1 = {40, 30, 40, 30};
            // Width, End cap, Join style, Miter limit, Dash pattern, Dash phase
            BasicStroke BasicS = new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.CAP_SQUARE, 10, d1, 0);
            g2d.setStroke(BasicS);
            g2d.drawLine(xStartD, yStartD, xEndD, yEndD);
            g2dI.drawLine(xStartD, yStartD, xEndD, yEndD);
            g2d.dispose();
            xStartD = xEndD;
            yStartD = yEndD;
            repaint();
        } else {
            g.drawLine(xStartD, yStartD, xEndD, yEndD);
            g2dI.drawLine(xStartD, yStartD, xEndD, yEndD);
            xStartD = xEndD;
            yStartD = yEndD;
            repaint();
        }
    }

 
    public void drawLine(MouseEvent e) {
        Graphics g = getGraphics();
        g.setColor(c);
        g2dI.setColor(c);
        xEndD = e.getX();
        yEndD = e.getY();
        if (dotFlag == 1) {
            Graphics2D g2d = (Graphics2D) g;
            float[] d1 = {40, 10, 40, 10};
            // Width, End cap, Join style, Miter limit, Dash pattern, Dash phase
            BasicStroke BasicS = new BasicStroke(2, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 10, d1, 0);
            g2d.setStroke(BasicS);
            g2d.drawLine(xStartD, yStartD, xEndD, yEndD);
            g2dI.drawLine(xStartD, yStartD, xEndD, yEndD);
            g2d.dispose();
            repaint();
        } else {

            g.drawLine(xStartD, yStartD, xEndD, yEndD);
            g2dI.drawLine(xStartD, yStartD, xEndD, yEndD);
            repaint();
        }

    }

    public void drawRetcangle(MouseEvent e) {
        Graphics g = getGraphics();
        g.setColor(c);
        g2dI.setColor(c);
        xEndD = e.getX();
        yEndD = e.getY();
        setDrawArea();
        if (fillFlag == 1) {
            g.fillRect(xStartD, yStartD, shapeWidth, shapeHeight);
            g2dI.fillRect(xStartD, yStartD, shapeWidth, shapeHeight);
            repaint();

        } else if (dotFlag == 1) {
            Graphics2D g2d = (Graphics2D) g;
            float[] d1 = {40, 10, 40, 10};
            // Width, End cap, Join style, Miter limit, Dash pattern, Dash phase
            BasicStroke BasicS = new BasicStroke(2, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 10, d1, 0);
            g2d.setStroke(BasicS);
            g2d.drawRect(xStartD, yStartD, shapeWidth, shapeHeight);
            g2dI.drawRect(xStartD, yStartD, shapeWidth, shapeHeight);
            g2d.dispose();
            repaint();

        } else {
            g.drawRect(xStartD, yStartD, shapeWidth, shapeHeight);
            g2dI.drawRect(xStartD, yStartD, shapeWidth, shapeHeight);
            repaint();
        }

    }

    public void drawOval(MouseEvent e) {
        Graphics g = getGraphics();
        g.setColor(c);
        g2dI.setColor(c);
        xEndD = e.getX();
        yEndD = e.getY();
        setDrawArea();
        if (fillFlag == 1) {
            g.fillOval(xStartD, yStartD, shapeWidth, shapeHeight);
            g2dI.fillOval(xStartD, yStartD, shapeWidth, shapeHeight);
            repaint();

        } else if (dotFlag == 1) {
            Graphics2D g2d = (Graphics2D) g;
            float[] d1 = {40, 10, 40, 10};
            // Width, End cap, Join style, Miter limit, Dash pattern, Dash phase
            BasicStroke BasicS = new BasicStroke(2, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 10, d1, 0);
            g2d.setStroke(BasicS);
            g2d.drawOval(xStartD, yStartD, shapeWidth, shapeHeight);
            g2dI.drawOval(xStartD, yStartD, shapeWidth, shapeHeight);
            g2d.dispose();
            repaint();

        } else {
            g.drawOval(xStartD, yStartD, shapeWidth, shapeHeight);
            g2dI.drawOval(xStartD, yStartD, shapeWidth, shapeHeight);
            repaint();
        }

    }

    public void eraser() {
        Graphics g = getGraphics();
        g.clearRect(xStartD, yStartD, 10, 10);
        g2dI.clearRect(xStartD, yStartD, 10, 10);

    }

    @Override
    public void update(Graphics g) {
        paint(g);

    }

    @Override
    public void paint(Graphics g) {

       //update(g);
    }

    class MyButtonsListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getActionCommand().equals("Red")) {
                colorStatus = 2;
            }

            if (e.getActionCommand().equals("Green")) {
                colorStatus = 3;
            }

            if (e.getActionCommand().equals("Blue")) {
                colorStatus = 4;
            }
            if (e.getActionCommand().equals("Purple")) {
                colorStatus = 5;
            }
            if (e.getActionCommand().equals("Orange")) {
                colorStatus = 6;
            }

            if (e.getActionCommand().equals("Pink")) {
                colorStatus = 7;
            }

            if (e.getActionCommand().equals("Gray")) {
                colorStatus = 8;
            }

            if (e.getActionCommand().equals("Yellow")) {
                colorStatus = 9;
            }
            if (e.getActionCommand().equals("Free Hand")) {
                actionStatus = FREEHANDACTION;
            }
            if (e.getActionCommand().equals("Line")) {
                actionStatus = LINEACTION;

            }
            if (e.getActionCommand().equals("Rectangle")) {
                actionStatus = RECTACTION;

            }
            if (e.getActionCommand().equals("Fill Rectangle")) {
                actionStatus = FILLRECTACTIION;
            }
            if (e.getActionCommand().equals("Oval")) {
                actionStatus = OVALACTION;

            }
            if (e.getActionCommand().equals("Fill Oval")) {
                actionStatus = FILLOVALACTION;

            }
            if (e.getActionCommand().equals("Eraser")) {
                actionStatus = ERASERACTION;

            }
            if (e.getActionCommand().equals("Clear All")) {
                actionStatus = CLEARALLACTION;

            }

            if (e.getActionCommand().equals("Undo")) {
                actionStatus = UNDOACTION;

            }

            if (e.getActionCommand().equals("Save Image")) {
                actionStatus = SAVEACTION;

            }

            if (e.getActionCommand().equals("Open Image")) {
                actionStatus = OPENACTION;

            }

            if (actionStatus == CLEARALLACTION) {
                clearAll();
            }
            chooseMainColor();
        }

        public void chooseMainColor() {
            switch (colorStatus) {
                case 1: {
                    c = Color.BLACK;
                    break;
                }
                case 2: {
                    c = Color.red;
                    break;
                }
                case 3: {
                    c = Color.green;
                    break;
                }
                case 4: {
                    c = Color.blue;
                    break;
                }
                case 5: {
                    c = Color.MAGENTA;
                    break;
                }
                case 6: {
                    c = Color.ORANGE;
                    break;
                }
                case 7: {
                    c = Color.pink;
                    break;
                }
                case 8: {
                    c = Color.GRAY;
                    break;
                }
                case 9: {
                    c = Color.yellow;
                    break;
                }
            }

        }

        //Method to clear Applet Screen
        public void clearAll() {
            Graphics g = getGraphics();
            Dimension d = getSize();
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, d.width, d.height);
        }

    }

}
