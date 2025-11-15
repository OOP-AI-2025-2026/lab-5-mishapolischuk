package ua.opnu.view;

import javax.swing.*;
import java.awt.*;

public class DrawFrame extends JFrame {

    private PaintSurface paintSurface;

    public DrawFrame() {
        super("Додаток для малювання");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel();

        JButton rectButton = new BigTextButton("Rectangle");
        JButton roundedRectButton = new BigTextButton("Rounded Rectangle");
        JButton ellipseButton = new BigTextButton("Ellipse");
        JButton clearButton = new BigTextButton("Clear");

        buttonPanel.add(rectButton);
        buttonPanel.add(roundedRectButton);
        buttonPanel.add(ellipseButton);
        buttonPanel.add(clearButton);

        paintSurface = new PaintSurface();

        add(paintSurface, BorderLayout.CENTER);

        rectButton.addActionListener(e -> paintSurface.setCurrentShapeType("Rectangle"));
        roundedRectButton.addActionListener(e -> paintSurface.setCurrentShapeType("RoundedRectangle"));
        ellipseButton.addActionListener(e -> paintSurface.setCurrentShapeType("Ellipse"));
        clearButton.addActionListener(e -> paintSurface.clearDrawing());

        add(buttonPanel, BorderLayout.NORTH);
    }
}