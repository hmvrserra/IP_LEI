
/**
 * Represents color images.
 * Image data is represented as a matrix:
 * - the number of lines corresponds to the image height (data.length)
 * - the length of the lines corresponds to the image width (data[*].length)
 * - pixel color is encoded as integers (ARGB)
 */

class ColorImage {

	private int[][] data; // @colorimage


	// Construtors

	ColorImage(int width, int height) {
		data = new int[height][width];
	}

	ColorImage(String file) {
		this.data = ImageUtil.readColorImage(file);
	}

	ColorImage(int[][] data) {
		this.data = data;
	}

	ColorImage(int width, int height, Color color) {
		data = new int[height][width];

		for (int x = 0; x < this.getWidth(); x++) {
			for (int y = 0; y < this.getHeight(); y++) {
				this.setColor(x, y, color);
			}
		}
	}

	// Metods

	int getWidth() {
		return data[0].length;
	}

	int getHeight() {
		return data.length;
	}

	void setColor(int x, int y, Color c) {
		data[y][x] = ImageUtil.encodeRgb(c.getR(), c.getG(), c.getB());
	}

	Color getColor(int x, int y) {
		int[] rgb = ImageUtil.decodeRgb(data[y][x]);
		return new Color(rgb[0], rgb[1], rgb[2]);
	}

	// Text functions

	void drawText(int textX, int textY, String text, int textSize, Color textColor) {
		drawText(textX, textY, text, textSize, textColor, false);
	}


	void drawCenteredText(int textX, int textY, String text, int textSize, Color textColor) {
		drawText(textX, textY, text, textSize, textColor, true);
	}
	

	private void drawText(int textX, int textY, String text, int textSize, Color textColor, boolean isCentered) {
		int r = 255 - textColor.getR();
		int g = 255 - textColor.getG();
		int b = 255 - textColor.getB();

		Color maskColor = new Color(r, g, b);

		int encodedMaskRGB = ImageUtil.encodeRgb(r, g, b);

		int[][] aux = ImageUtil.createColorImageWithText(getWidth(), getHeight(), maskColor, textX, textY, text, textSize, textColor, isCentered);

		for (int i = 0; i < aux.length; i++) {
			for (int j = 0; j < aux[i].length; j++) {
				int value = aux[i][j];
				if(value != encodedMaskRGB) {
					data[i][j] = aux[i][j];
				}
			}
		}
	}
	

	//ColorImage procedures
	
	ColorImage copy() {
	    ColorImage newImage = new ColorImage(this.getWidth(), this.getHeight());
	    for (int i=0; i!=newImage.getHeight(); i++) {
	      for (int j=0; j!=newImage.getWidth(); j++) {
	        newImage.setColor(j, i, this.getColor(j, i));
	      }
	    }

	    return newImage;
	  }
	
	void invertColors(){
		for (int i=0; i!=this.getHeight(); i++) {
		      for (int j=0; j!=this.getWidth(); j++) {
		        this.setColor(j, i, this.getColor(j, i).getInvertedColor());
		      }
		    }
		return;
	}
	
	void grayScale(){
		for (int i=0; i!=this.getHeight(); i++) {
		      for (int j=0; j!=this.getWidth(); j++) {
		        this.setColor(j, i, this.getColor(j, i).getGrayScale());
		      }
		    }
		return;
	}
	
	void brightness(int value){
		for (int i=0; i!=this.getHeight(); i++) {
		      for (int j=0; j!=this.getWidth(); j++) {
		        this.setColor(j, i, this.getColor(j, i).getBrighter(value));
		      }
		    }
		return;
	}
	
	void mirror(){
		ColorImage copied = this.copy();
		for (int i=0; i!=this.getHeight(); i++) {
		      for (int j=0; j!=this.getWidth(); j++) {
		        this.setColor(j, i, copied.getColor(this.getWidth()-j-1,i));
		      }
		    }
		 return;
	}
	
	void extraProcedure(){
		for (int i=0; i!=this.getHeight(); i++) {
		      for (int j=0; j!=this.getWidth()/2; j++) {
		    	  this.setColor(j, i,this.getColor(this.getWidth()-j-1,i));
		      }
		    }
		 return;
	}
	
	void paste(ColorImage img, int x, int y){
		for (int i=0; i!=img.getHeight(); i++) {
		      for (int j=0; j!=img.getWidth(); j++) {
		    	  this.setColor(x+j,y+i, img.getColor(j, i));
		      }
		}
		return;
	}
	
	ColorImage selection(int startx, int starty, int endx, int endy){
		int x=endx-startx;
		int y=endy-starty;
		ColorImage newImage = new ColorImage(x,y);
		for (int i=0; i!=newImage.getHeight(); i++) {
		      for (int j=0; j!=newImage.getWidth(); j++) {
		        newImage.setColor(j, i, this.getColor(startx+j,starty+i));
		      }
		    }

		    return newImage;
	}
	
}