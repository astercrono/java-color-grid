package net.astercrono.colorgrid;

import java.awt.Color;

public class ColorBlock {
	private PixelPoint point;
	private Color color;
	private int width;
	private int height;

	public PixelPoint getPoint() {
		return point;
	}

	public void setPoint(PixelPoint point) {
		this.point = point;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
}
