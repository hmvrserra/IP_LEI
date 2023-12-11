class Rectangle {
	
	final int[][] rectangle;
	
	//Constructors
	
	Rectangle(int width, int height){
		rectangle = new int[height][width];
	}
	
	
	//Methods
	
	int area(){
		return rectangle[0].length*rectangle.length;
	}
	
	int perimeter(){
		return (rectangle[0].length*2)+(rectangle.length*2);
	}
	
	int diagonal(){
		return (rectangle[0].length*rectangle.length)/2;
	}
	
	boolean isSquare(){
		return rectangle[0].length==rectangle.length;
	}
	
	
	//Rectangle Procedures
	
	Rectangle scale(int factor){
		return new Rectangle(rectangle[0].length*factor,rectangle.length*factor);
	}
	
	Rectangle sum(int width,int height){
		return new Rectangle(rectangle[0].length+height,rectangle.length+width);
	}
	
	Rectangle sum(Rectangle r){
		return new Rectangle (rectangle[0].length+r.rectangle[0].length,rectangle.length+r.rectangle.length);
	}
	
	boolean fit(int width,int height){
		return height<=rectangle[0].length&&width<=rectangle.length;
	}
	
	boolean fit(Rectangle r){
		return r.rectangle[0].length<=rectangle[0].length&&r.rectangle.length<=rectangle.length;
	}
	
	//Static Functions
	
	static Rectangle square(int side){
		Rectangle square = new Rectangle(side,side);
		return square;
	}
	
	
}