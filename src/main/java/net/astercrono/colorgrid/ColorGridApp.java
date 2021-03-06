package net.astercrono.colorgrid;

import java.awt.Color;

import javax.swing.JFrame;

public class ColorGridApp {
	public static void main(final String[] args) throws InterruptedException {
		final int width = 720;
		final int height = 720;
		final int rows = 10;
		final int cols = 10;

		final ColorGridDimensions dimensions = new ColorGridDimensions();
		dimensions.setRows(rows);
		dimensions.setColumns(cols);
		dimensions.setWidth(width);
		dimensions.setHeight(height);

		final ColorGrid grid = new ColorGrid(dimensions);

		final JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(width, height);
		window.add(grid);
		window.setVisible(true);

		colorIndividualCells(grid);
		colorSmallRow(grid);
		colorOversizedRow(grid);
		grid.repaint();
	}

	private static void colorIndividualCells(final ColorGrid grid) {
		grid.setCellColor(3, 0, Color.BLACK);
		grid.setCellColor(3, 1, Color.DARK_GRAY);
		grid.setCellColor(3, 2, Color.BLUE);
		grid.setCellColor(3, 3, Color.ORANGE);
		grid.setCellColor(3, 4, Color.GREEN);
		grid.setCellColor(3, 5, Color.PINK);
		grid.repaint();
	}
	
	private static void colorSmallRow(final ColorGrid grid) {
		grid.setRowColors(7, new Color[] { Color.MAGENTA, Color.GRAY, Color.BLUE, Color.YELLOW, Color.RED,
				Color.DARK_GRAY, Color.GRAY, Color.ORANGE });
		grid.repaint();
	}
	
	private static void colorOversizedRow(final ColorGrid grid) {
		grid.setRowColors(9, new Color[] { Color.MAGENTA, Color.GRAY, Color.BLUE, Color.YELLOW, Color.RED,
				Color.DARK_GRAY, Color.GRAY, Color.ORANGE, Color.YELLOW, Color.RED, Color.YELLOW, Color.RED });
		grid.repaint();
	}
}
