//	JAVA 1, HOMEWORK 2a
//
//  HOI WAN JOHN LOUIS
//
//	a)	Write a class Dimension that has the following:
//		1)	private double fields length, height, width
//		2)	One and only one pubic constructor that takes all three dimesion attributes to create Dimension Object.
//		3)	Public Getters and Setters for all three fields.
//
public class Dimension {
	private double length, height, width;

	/**
	 * @param length
	 * @param height
	 * @param width
	 */
	public Dimension(double length, double height, double width) {
		super();
		setLength(length);
		setHeight(height);
		setWidth(width);
	}

	/**
	 * @return the height
	 */
	public double getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(double height) {
		this.height = height;
	}

	/**
	 * @return the length
	 */
	public double getLength() {
		return length;
	}

	/**
	 * @param length the length to set
	 */
	public void setLength(double length) {
		this.length = length;
	}

	/**
	 * @return the width
	 */
	public double getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(double width) {
		this.width = width;
	}

}
