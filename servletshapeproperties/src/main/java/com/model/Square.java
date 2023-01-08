package com.model;

public class Square implements Shape{
	private float side;
	public Square(int side){
		this.side=side;
	}
	@Override
	public float area() {
		// TODO Auto-generated method stub
		return side*side;
	}

	@Override
	public float perimeter() {
		// TODO Auto-generated method stub
		return 4*side;
	}

	@Override
	public String uniqueProperty() {
		// TODO Auto-generated method stub
		return "1.All sides are equal "
				+ "\n2.All angles are 90 degress"
				+ "\n3.Diagonals are perpendicular bisector of each other ";
	}
	@Override
	public String toString() {
		return "Square [side=" + side + ", area()=" + area() + ", perimeter()=" + perimeter() + ", uniqueProperty()="
				+ uniqueProperty()  +"]";
	}
	
	
}
