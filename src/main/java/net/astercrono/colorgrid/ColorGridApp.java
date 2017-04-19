package net.astercrono.colorgrid;

import javax.swing.JFrame;

public class ColorGridApp {
	public static void main(final String[] args) {
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
	}
}
