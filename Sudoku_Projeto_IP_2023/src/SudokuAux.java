class SudokuAux {
	
	static final Color BLACK = new Color(0,0,0);
	static final Color WHITE = new Color(255,255,255);
	static final Color GRAY = new Color(200,200,200);
	static final Color RED = new Color(255,0,0);

	/*
	1. Validar se uma matriz de inteiros 9x9 representa um Sudoku válido, sendo que o valor zero representa uma posição não jogada.*/
	
	//Linha Válida
	public static boolean isLineValid(int[][] m, int numLine){
	    int[] count=new int[10];
	    for(int i=0;i!=m[numLine].length;i++){
	        int num=m[numLine][i];
	        if(num!=0){
	            if(count[num]>0){
	                return false;
	            }
	            count[num]++;
	        }
	    }
	    return true;
	}
	
	//Coluna Válida
	public static boolean isColumnValid(int[][] m, int numLine){
	    int[] count=new int[10];
	    for(int i=0;i!=m[numLine].length;i++){
	        int num=m[i][numLine];
	        if(num!=0){
	            if(count[num]>0){
	            	return false;
	            }
	            count[num]++;
	        }
	    }
	    return true;
	}
	
	//Segmento Válido
	public static boolean isSegmentValid(int[][] m, int numSegment){
	    int x=numSegment%3;
	    int y=numSegment/3;
	    int startX=x*3;
	    int startY=y*3;
	    int[] count=new int[10];
	    for(int i=startY;i<startY+3;i++){
	        for(int j=startX;j<startX+3;j++){
	            int num=m[i][j];
	            if(num!=0){
	                if(count[num]>0){
	                    return false;
	                }
	                count[num]++;
	            }
	        }
	    }
	    return true;
	}
	
	//Matrix de Sudoku Válida
	public static boolean isMatrixValid(int[][]m){
			for(int i=0; i<=8; i++){
				if(isLineValid(m,i)==false||isColumnValid(m,i)==false||isSegmentValid(m,i)==false||m.length!=9||m[0].length!=9){
					return false;	
				}
			}
		return true;
	}

	/* 
	2. Gerar uma matriz de jogo dada uma solução completa válida (sem zeros), alterando-a de forma
	a que parte dos números da mesma sejam substituídos por zero.
	Deverá ser fornecida uma percentagem que determina qual a proporção de posições a zerar.*/
	
	public static int[][] difficultyMatrix(int[][] m, double percentage){
		int[][]board=m;
		double p=percentage*81;
		int p2=(int) p;
		int l=0;
		while(l!=p2){
			double rx=Math.random()*9;
			double ry=Math.random()*9;
			if(board[(int)rx][(int)ry]!=0){
				board[(int)rx][(int)ry]=0;
				l++;
			}	
		}
		return board;
	}
	
	/*
	3. Produzir uma String com o conteúdo de uma matriz de inteiros.*/
	
	public static String convertMatrixToString(int[][]matrix){
		String s = "";
	    for (int i = 0; i < matrix.length; i++) {
	        for (int j = 0; j < matrix[i].length; j++) {
	            s+=matrix[i][j];
	            s+=" ";
	        }
	        s+="\n";
	    }
	    return s;
	}
	
	/*
	 4. Produzir uma imagem a cores com o desenho do tabuleiro Sudoku a partir de uma matrix de inteiros 9x9. 
	 Poderá ser útil desenvolver procedimentos auxiliares para abordar partes do objetivo 
	 (p.e. desenho de grelha, desenho de números).*/
	
	//Desenhar uma Grelha 
	public static void grid(ColorImage img){
		
		//Linhas Verticais
		for(int i=0;i!=img.getWidth();i++){
			for(int j=0; j<=img.getHeight()/9*8;j+=img.getWidth()/9){
			img.setColor(i,j,GRAY);
			}
		}
		for(int i=0;i<=img.getWidth()/9*8;i+=img.getWidth()/9){
			for(int j=0; j!=img.getHeight();j++){
			img.setColor(i,j,GRAY);
			}
		}
		for(int i=0;i!=img.getWidth();i++){
			for(int j=0; j<=img.getHeight()/3*2;j+=img.getWidth()/3){
			img.setColor(i,j,BLACK);
			}
		}
		for(int i=0;i<=img.getWidth()/3*2;i+=img.getWidth()/3){
			for(int j=0; j!=img.getHeight();j++){
			img.setColor(i,j,BLACK);
			}
		}
	
		//Bordas
		for(int i=0;i!=img.getWidth();i++){
			img.setColor(i,0,BLACK);
			img.setColor(i,img.getWidth()-1,BLACK);
		}
		for(int j=0;j!=img.getHeight();j++){
			img.setColor(0,j,BLACK);
			img.setColor(img.getHeight()-1,j,BLACK);
		}
		
	}
			
	//Tornar o fundo de uma nova ColorImage em branco
	public static void paintWhite(ColorImage img){
		for(int i=0; i!=img.getWidth(); i++){
			for(int j=0; j!=img.getHeight(); j++){
				img.setColor(i,j,WHITE);
			}
		}
	}
	
	//Preencher o tabuleiro com números dado uma matriz válida
	public static void colorNumberBoard(ColorImage img, int[][]board){
		int cellWidth = img.getWidth()/9;
	    int cellHeight = img.getHeight()/9;
		
		for(int i=0; i!=board.length; i++){
		    for(int j=0; j!=board[i].length; j++){
		    	int x =(j*cellWidth)+(cellWidth/2);
	            int y =(i*cellHeight)+(cellHeight/2);
		    	if(board[i][j]!=0){
		    		String s = Integer.toString(board[i][j]);
			    	img.drawCenteredText(x,y,s,35,BLACK);
		    	}
			}
		}
	}
	
	// Criar uma imagem a cores com o desenho do tabuleiro Sudoku a partir de uma matrix de inteiros 9x9.
	public static ColorImage colorImageBoard(int[][]matrix){
		ColorImage colorBoard = new ColorImage(460,460);
		paintWhite(colorBoard);
		grid(colorBoard);
		colorNumberBoard(colorBoard,matrix);
		return colorBoard;
	}
	
	public static void resetColorImageBoard(){
		
	}
	
	/*
	5. Dada uma imagem resultante de (4), alterar uma posição da imagem do tabuleiro, 
	fornecendo uma coordenada e o número a colocar.*/
	
	public static void placeNumber(ColorImage img, int[][]board, int xCell, int yCell, int num){
		int cellWidth = img.getWidth()/9;
	    int cellHeight = img.getHeight()/9;
		int x =(xCell*cellWidth)+(cellWidth/2);
	    int y =(yCell*cellHeight)+(cellHeight/2);
	    if(xCell>=0&&xCell<=8&&yCell>=0&&yCell<=8&&board[xCell][yCell]==0){
	    	board[xCell][yCell]=num;
			String s = Integer.toString(num);
			img.drawCenteredText(y,x,s,35,BLACK);
	    }
	}
	
	/*
	6. Dada uma imagem resultante de (4), marcar uma linha do tabuleiro com contorno 
	vermelho (para sinalizar que está inválida), fornecendo o índice da linha.*/
	
	public static void drawInvalidLine(ColorImage img,int index){
		if(index>=0&&index<=8){
			for(int i=0;i!=img.getWidth();i++){
				img.setColor(i,index*img.getHeight()/9,RED);
				img.setColor(i,index*img.getHeight()/9+1,RED);
				img.setColor(i,(index*img.getHeight()/9)+img.getHeight()/9-1,RED);
				img.setColor(i,(index*img.getHeight()/9)+img.getHeight()/9,RED);
			}
			for(int j=index*img.getHeight()/9;j!=(index*img.getHeight()/9)+img.getHeight()/9;j++){
				img.setColor(0,j,RED);
				img.setColor(1,j,RED);
				img.setColor(img.getHeight()-2,j,RED);
				img.setColor(img.getHeight()-1,j,RED);
			}
		}
	}
	
	/*
	7. Dada uma imagem resultante de (4), marcar uma coluna do tabuleiro com contorno 
	vermelho (para sinalizar que está inválida), fornecendo o índice da coluna.*/
	
	public static void drawInvalidColumn(ColorImage img,int index){
		if(index>=0&&index<=8){
			for(int i=0;i!=img.getWidth();i++){
				img.setColor(index*img.getHeight()/9,i,RED);
				img.setColor(index*img.getHeight()/9+1,i,RED);
				img.setColor((index*img.getHeight()/9)+img.getHeight()/9-1,i,RED);
				img.setColor((index*img.getHeight()/9)+img.getHeight()/9,i,RED);
			}
			for(int j=index*img.getHeight()/9;j!=(index*img.getHeight()/9)+img.getHeight()/9;j++){
				img.setColor(j,0,RED);
				img.setColor(j,1,RED);
				img.setColor(j,img.getHeight()-2,RED);
				img.setColor(j,img.getHeight()-1,RED);
			}
		}
	}
	
	/*
	8. Dada uma imagem resultante de (4), marcar um segmento do tabuleiro com contorno 
	vermelho (para sinalizar que está inválida), fornecendo o índice do segmento.*/
	
	public static void drawInvalidSegment(ColorImage img,int index){
		int x=index%3;
		int y=index/3;
		if (x>=0&&x<=2&&y>=0&&y<= 2){
			int startX=(x*img.getWidth())/3;
			int startY=(y*img.getHeight())/3;
		    for (int i=0;i<=(img.getHeight()/3);i++){
		    	img.setColor(startX+i,startY,RED);
		        img.setColor(startX+i,startY+img.getHeight()/3, RED);
		        img.setColor(startX,startY+i,RED);
		        img.setColor(startX + img.getWidth()/3, startY + i, RED);
		        img.setColor(startX+i,startY+1,RED);
		        img.setColor(startX+i,startY+img.getHeight()/3-1, RED);
		        img.setColor(startX+1,startY+i,RED);
		        img.setColor(startX + img.getWidth()/3-1, startY + i, RED);
		    }
		}
	}
	
}