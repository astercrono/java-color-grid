package net.astercrono.colorgrid;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class ColorGrid extends JPanel {
	private static final long serialVersionUID = -5733113685225730181L;
	private static final int DEFAULT_WIDTH = 400;
	private static final int DEFAULT_HEIGHT = 400;
	private static final int DEFAULT_ROWS = 4;
	private static final int DEFAULT_COLUMNS = 4;
	private static final Color DEFAULT_COLOR_FILL = Color.CYAN;

	private ColorGridDimensions dimensions;
	private ColorBlock[][] blocks;
	private int blockWidth;
	private int extraBlockWidth; // Divisions may not be whole numbers. Use
									// 'extra' fields to store the extra pixels.
	private int blockHeight;
	private int extraBlockHeight; // Same concept as extraBlockWidth.

	public ColorGrid() {
		final ColorGridDimensions dimensions = new ColorGridDimensions();
		dimensions.setWidth(getDefaultWidth());
		dimensions.setHeight(getDefaultHeight());
		dimensions.setRows(getDefaultRows());
		dimensions.setColumns(getDefaultColumns());
		setDimensions(dimensions);
	}

	public ColorGrid(final ColorGridDimensions dimensions) {
		setDimensions(dimensions);
		initializeBlocks();
	}

	@Override
	protected void paintComponent(Graphics g) {
		System.out.println("painting grid");
		super.paintComponent(g);

		final int rows = dimensions.getRows();
		final int cols = dimensions.getColumns();

		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				final ColorBlock block = blocks[row][col];
				final PixelPoint point = block.getPoint();

				g.setColor(block.getColor());
				g.fillRect(point.getX(), point.getY(), block.getWidth(), block.getHeight());
			}
		}
	}

	public ColorGridDimensions getDimensions() {
		return dimensions;
	}

	public void setDimensions(ColorGridDimensions dimensions) {
		this.dimensions = dimensions;
	}

	public int getDefaultWidth() {
		return DEFAULT_WIDTH;
	}

	public int getDefaultHeight() {
		return DEFAULT_HEIGHT;
	}

	public int getDefaultRows() {
		return DEFAULT_ROWS;
	}

	public int getDefaultColumns() {
		return DEFAULT_COLUMNS;
	}

	public Color getDefaultColorFill() {
		return DEFAULT_COLOR_FILL;
	}

	public ColorBlock[][] getBlocks() {
		return blocks;
	}

	public void setBlocks(ColorBlock[][] blocks) {
		this.blocks = blocks;
	}

	public int getBlockWidth() {
		return blockWidth;
	}

	public void setBlockWidth(int blockWidth) {
		this.blockWidth = blockWidth;
	}

	public int getExtraBlockWidth() {
		return extraBlockWidth;
	}

	public void setExtraBlockWidth(int extraBlockWidth) {
		this.extraBlockWidth = extraBlockWidth;
	}

	public int getBlockHeight() {
		return blockHeight;
	}

	public void setBlockHeight(int blockHeight) {
		this.blockHeight = blockHeight;
	}

	public int getExtraBlockHeight() {
		return extraBlockHeight;
	}

	public void setExtraBlockHeight(int extraBlockHeight) {
		this.extraBlockHeight = extraBlockHeight;
	}

	private void initializeBlocks() {
		final ColorGridDimensions dimensions = getDimensions();
		final int rows = dimensions.getRows();
		final int cols = dimensions.getColumns();

		blocks = new ColorBlock[rows][cols];

		blockWidth = calculateBlockWidth();
		extraBlockWidth = calculateExtraBlockWidth();
		blockHeight = calculateBlockHeight();
		extraBlockHeight = calculateExtraBlockHeight();

		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				final ColorBlock block = buildBlock(row, col);
				blocks[row][col] = block;
			}
		}
	}

	private ColorBlock buildBlock(final int row, final int col) {
		final int rows = dimensions.getRows();
		final int cols = dimensions.getColumns();

		int blockWidth = getBlockWidth();
		int blockHeight = getBlockHeight();

		if (row + 1 > rows) {
			blockWidth += extraBlockWidth;
		}

		if (col + 1 > cols) {
			blockHeight += extraBlockHeight;
		}

		final ColorBlock block = new ColorBlock();
		final PixelPoint point = transformCoordToPoint(row, col, blockWidth, blockHeight);

		block.setPoint(point);
		block.setColor(getDefaultColorFill());
		block.setWidth(blockWidth);
		block.setHeight(blockHeight);

		return block;
	}

	private PixelPoint transformCoordToPoint(final int row, final int col, final int width, final int height) {
		final int x = col * width;
		final int y = row * height;

		final PixelPoint point = new PixelPoint();
		point.setX(x);
		point.setY(y);

		return point;
	}

	private int calculateBlockWidth() {
		final ColorGridDimensions dimensions = getDimensions();
		final int blockWidth = dimensions.getWidth() / dimensions.getColumns();
		return blockWidth;
	}

	private int calculateExtraBlockWidth() {
		final ColorGridDimensions dimensions = getDimensions();
		final int blockWidth = dimensions.getWidth() % dimensions.getColumns();
		return blockWidth;
	}

	private int calculateBlockHeight() {
		final ColorGridDimensions dimensions = getDimensions();
		final int blockHeight = dimensions.getHeight() / dimensions.getRows();
		return blockHeight;
	}

	private int calculateExtraBlockHeight() {
		final ColorGridDimensions dimensions = getDimensions();
		final int blockHeight = dimensions.getHeight() % dimensions.getRows();
		return blockHeight;
	}
}
