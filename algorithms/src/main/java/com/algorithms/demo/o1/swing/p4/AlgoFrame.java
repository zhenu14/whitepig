package com.algorithms.demo.o1.swing.p4;
import java.awt.*;
import javax.swing.*;
import java.awt.geom.Ellipse2D;

public class AlgoFrame extends JFrame{

    private int canvasWidth;
    private int canvasHeight;

    public AlgoFrame(String title, int canvasWidth, int canvasHeight){

        super(title);

        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;

        AlgoCanvas canvas = new AlgoCanvas();
        setContentPane(canvas);
        pack();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        setVisible(true);
    }

    public AlgoFrame(String title){

        this(title, 1024, 768);
    }

    public int getCanvasWidth(){return canvasWidth;}
    public int getCanvasHeight(){return canvasHeight;}


    private class AlgoCanvas extends JPanel{

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D)g;

            int strokeWidth = 5;
            g2d.setStroke(new BasicStroke(strokeWidth, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));

            g2d.setColor(Color.RED);
            Ellipse2D circle = new Ellipse2D.Double(50, 50, 300, 300);
            g2d.draw(circle);

            g2d.setColor(Color.BLUE);
            Ellipse2D circle2 = new Ellipse2D.Double(50, 50, 300, 300);
            g2d.fill(circle2);
        }

        @Override
        public Dimension getPreferredSize(){
            return new Dimension(canvasWidth, canvasHeight);
        }
    }
}

