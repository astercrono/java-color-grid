package net.astercrono.colorgrid;

import javax.swing.*;
import java.awt.*;

public class App {
    public static void main(String[] args) {
        int width = 800;
        int height = 800;
        int rows = 10;
        int cols = 10;

        ColorGridDimensions dimensions = new ColorGridDimensions();
        dimensions.setWidth(width);
        dimensions.setHeight(height);
        dimensions.setRows(rows);
        dimensions.setColumns(cols);

        ColorGrid grid = new ColorGrid(dimensions);

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(width, height);
        window.add(grid);
        window.setVisible(true);

        Color[] colors1 = new Color[] {
                Color.CYAN, Color.BLACK, Color.GREEN, Color.ORANGE, Color.RED,
                Color.GRAY, Color.YELLOW, Color.BLUE, Color.PINK, Color.WHITE
        };

        Color[] colors2 = new Color[] {
                Color.GRAY, Color.YELLOW, Color.BLUE, Color.PINK, Color.WHITE,
                Color.CYAN, Color.BLACK, Color.GREEN, Color.ORANGE, Color.RED
        };

        for (int i = 0; i < rows; i++) {
            if (i % 2 == 0) {
                grid.setRowColors(i, colors1);
            }
            else {
                grid.setRowColors(i, colors2);
            }
        }

        grid.repaint();
    }
}
