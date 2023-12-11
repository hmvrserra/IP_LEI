/**
 * Represents RGB colors.
 * RGB values are stored in a 3-position array, with values in the interval [0, 255].
 * rgb[0] - Red
 * rgb[1] - Green
 * rgb[2] - Blue
 */
class Color {

	private final int[] rgb; // @color

	/**
	 * Creates an RGB color. Provided values have to 
	 * be in the interval [0, 255]
	 */
	Color(int r, int g, int b) {
		if(!valid(r) || !valid(g) || !valid(b))
			throw new IllegalArgumentException("invalid RGB values: " + r + ", " + g + ", " + b);
		
		this.rgb = new int[] {r, g, b};
	}
	/**
	 * Constrain Function
	 */
	static int constrain(int n,int min,int max){
		if(min>n)
			return min;
		if (n>max)
			return max;
		return n;
	}
	/**
	 * Red value [0, 255]
	 */
	int getR() {
		return rgb[0];
	}

	/**
	 * Green value [0, 255]
	 */
	int getG() {
		return rgb[1];
	}

	/**
	 * Blue value [0, 255]
	 */
	int getB() {
		return rgb[2];
	}

	/**
	 * Obtains the luminance in the interval [0, 255].
	 */
	int getLuminance() {
		return (int) Math.round(rgb[0]*.21 + rgb[1]*.71 + rgb[2]*.08);
	}

	static boolean valid(int value) {
		return value >= 0 && value <= 255;
	}
	
	static final Color RED = new Color (255,0,0);
	static final Color GREEN = new Color (0,255,0);
	static final Color BLUE = new Color (0,0,255);
	static final Color BLACK = new Color (255,255,255);
	static final Color WHITE = new Color (0,0,0);
	
	
	//Color procedures
	Color getInvertedColor(){
		Color c = new Color(255-rgb[0], 255-rgb[1], 255-rgb[2]);
		return c;
	}
	
	Color getBrighter(int value){
		Color c=new Color(constrain(rgb[0]+value,0,255),constrain(rgb[1]+value,0,255),constrain(rgb[2]+value,0,255));
		return c;
	}
	
	Color getGrayScale(){
		Color c = new Color(getLuminance(),getLuminance(),getLuminance());
		return c;
	}
	
	boolean isEqualTo(Color c){
		Color c2 =new Color(rgb[0],rgb[1],rgb[2]);
		return c==c2;
	}
	
	boolean isInVector(Color[] v, Color c){
		for(int i=0; i!=v.length; i++){
			if (v[i]==c)
				return true;
		}
		return false;
	}
}
