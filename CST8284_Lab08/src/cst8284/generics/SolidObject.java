package cst8284.generics;

public class SolidObject<T extends BasicShape> {

	private double depth;
	private T shape;

	protected SolidObject(T shape, double depth) {
		setShape(shape);
		setDepth(depth);
	}

	protected SolidObject(T shape) {
		this(shape, shape.getWidth());
	}

	public double getDepth() {
		return depth;
	}

	public void setDepth(double depth) {
		this.depth = depth;
	}

	public T getShape() {
		return shape;
	}

	public void setShape(T bs) {
		shape = bs;
	}

	public String toString() {
		String solidTypeEquivalent = "unknown   ";
		String className = getShape().getClass().toString();
		className = className.substring(className.lastIndexOf('.') + 1);
		switch (className) {
		case "Circle":
			solidTypeEquivalent = "cylinder ";
			break;
		case "Square":
			solidTypeEquivalent = "cube     ";
			break;
		case "Rectangle":
			solidTypeEquivalent = "block    ";
			break;
		case "Triangle":
			solidTypeEquivalent = "prism    ";
			break;
		}
		return solidTypeEquivalent;
	}

	public double getVolume() {
		return this.shape.getArea() * getDepth();
	}

	public double getSurFaceArea() {

		return shape.getPerimeter() * this.depth + shape.getArea() * 2;
	}
	@Override
	public boolean equals(Object o){
	 return (this.getVolume() ==((SolidObject<?>) o).getVolume());
	}

}
