package cst8284.generics;

public class Square extends BasicShape {

	public Square(){
		this(1.0);
	}
	
	public Square(double width) {
		this.setWidth(width);
	}
	
	public Square(Square square) {
		this(square.getWidth());
		
	}
	
		
	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return (this.getWidth() * this.getWidth());
	}

	@Override
	public double getPerimeter() {
		// TODO Auto-generated method stub
		return (2*(this.getWidth() + this.getWidth() ));
	}

	@Override
	public String toString() {
		return ("Square Overrides " + super.toString());
	}

//	public boolean equals(Object obj) {
//		if (obj instanceof Square) {
//			Square square=(Square)obj;
//
//			if (this.getWidth() == square.getWidth()) {
//				return true;
//			}
//		}
//		return false;
//	}
	
	
}
