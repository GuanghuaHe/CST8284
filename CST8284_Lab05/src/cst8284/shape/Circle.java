package cst8284.shape;

public class Circle extends BasicShape {

	public Circle(){
		this(1.0);
	}
	
	public Circle(double width){
		this.setWidth(width);
	}
	
	public Circle(Circle circle){
		this(circle.getWidth());
	}
	
	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return (this.getWidth()/2)*(this.getWidth()/2)*Math.PI;
	}

	@Override
	public double getPerimeter() {
		// TODO Auto-generated method stub
		return this.getWidth() * Math.PI;
	}

	@Override
	public String toString() {
		return ("Circle Overrides " + super.toString());
	}

	
	public boolean equals(Object obj) {

		if (obj instanceof Circle) {
			Circle circle=(Circle)obj;

			if (this.getWidth() == circle.getWidth()) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}
	
}
