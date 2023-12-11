class Calculator {
	
	int value;
	
	//Methods
	
	void plus(int n){
		value+=n;
		if(value<=0)
			value=0;
	}
	
	void subtract(int n){
		value=-n;
		if(value<=0)
			value=0;
	}
	
	void reset(){
		value=0;
	}
	
	void multiply(int n){
		if(n==0)
			value=0;
		for(int i=0;i!=n;i++){
			value=+value;
			if(value<=0)
				value=0;
		}
	}
	
	void power(int n){
		if(n==0)
			value=1;
		for(int i=0;i!=n;i++){
			for(int j=0;j!=value;j++){
				value=+value;
				if(value<=0)
					value=0;
				
			}
		}
	}
	
	void divide(int n){
		int quociente=0;
		while (value>=n){
            value-=n;
            quociente++;
        }
		value=quociente;
	}
	
	void restOfDivision(int n){
		int result=value/n;
		int end=result*n;
		value=-end;
	}
	
	
	static void posterize(ColorImage img, Color light, Color dark) {
        for(int x = 0; x != img.getWidth(); x++) {
            for(int y = 0; y != img.getHeight(); y++) {
                if(img.getColor(x, y).getLuminance() < 128) {
                    img.setColor(x, y, dark);
                } else {
                    img.setColor(x, y, light);
                }
            }
        }
    }
	
	static ColorImage test(){
		ColorImage img = new ColorImage(100,200);
		posterize(img, Color.WHITE, Color.BLUE);
		return img;
	}
}