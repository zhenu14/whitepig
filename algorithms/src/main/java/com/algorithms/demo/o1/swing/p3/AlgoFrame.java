package com.algorithms.demo.o1.swing.p3;

import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import javax.swing.*;

@Setter
@Getter
public class AlgoFrame extends JFrame{

    private int canvasWidth;
    private int canvasHeight;

    public AlgoFrame(String title, int canvasWidth, int canvasHeight){

        super(title);

        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;

        //setSize(canvasWidth, canvasHeight);
        AlgoCanvas canvas = new AlgoCanvas();
        // canvas.setPreferredSize(new Dimension(canvasWidth,canvasHeight));
        setContentPane(canvas);
        pack();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        setVisible(true);

        // System.out.println(getContentPane().getBounds());
    }

    public AlgoFrame(String title){

        this(title, 1024, 768);
    }


    private class AlgoCanvas extends JPanel{

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.drawOval(50, 50, 300, 300);
        }

        @Override
        public Dimension getPreferredSize(){
            return new Dimension(canvasWidth, canvasHeight);
        }
    }
}


