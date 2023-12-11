class ColorsBinaryImages {
	
	
	/*Trabalho Prévio
	*
	Sortear um número inteiro entre 0 e um valor máximo (parâmetro).*/

	static int randomSort(int max){
		double r=((Math.random()*max)+0.5);
		return (int) r;
	}
	
	//Limitar um número a uma dado intervalo [min, max].
	
	static int constrain(int n,int min,int max){
		if(min>n)
			return min;
		if (n>max)
			return max;
		return n;
	}
	
	//Sortear um valor booleano, sendo a probabilidade de sair true igual à de sair false.
	
	static boolean randomSortBoolean(){
		int result=randomSort(1);
		if(result==1)
			return true;
		return false;
	}
	
	//Criar uma matriz de booleanos com valores aleatórios, dados o número de linhas e colunas.
	
	static boolean[][] createRandomBooleanMatrix(int lines,int columns){
		boolean m[][]=new boolean[lines][columns];
		for(int i=0; i!=m.length; i++){
			for(int j=0; j!=m[i].length; j++){
				int r=randomSort(1);
				if(r==0)
					m[i][j]=false;
				else
					m[i][j]=true;
			}
		}
		return m;
	}
	
	/*Criar uma matriz de booleanos que corresponda às casas de um tabuleiro de xadrez (8x8), sendo as
	casas brancas representadas por true e as casas pretas por false.*/
	
	static boolean[][] booleanChessBoard(){
		boolean board[][]=new boolean [8][8];
		for(int i=0; i!=board.length; i++){
			if(i%2==0){
				for(int j=0; j!=board[i].length; j+=2){
					board[i][j]=true;
				}
			}
			if(i%2==1){
				for(int k=1; k<board[i].length; k+=2){
					board[i][k]=true;
				}
			}
		}
		return board;
	}
	
	//Calcular a distância entre dois pontos.
	
	static double distance(int xA,int yA,int xB,int yB){
		double d=Math.sqrt((Math.pow(xB-xA,2))+(Math.pow(yB-yA,2)));
		return d;
	}
	
	
	/* Visualizações no PandionJ
	 * 
	 Testar a representação binária da função booleanChessBoard*/
	
	static BinaryImage testBooleanChessBoard(){
		BinaryImage img=new BinaryImage(8,8);
		boolean[][] board=booleanChessBoard();
		for(int i=0; i!=board.length; i++){
			for(int j=0; j!=board[i].length; j++){
				if(board[i][j]==true){
				img.setWhite(i,j);
				}
			}
		}
		return img;
	}
	
	
	
	
	/* Cores
	 *
	 Criar um tom de cinzento dada uma luminosidade*/
	
	static Color gray(int lum){
		int RGB=lum;
		Color c=new Color(RGB,RGB,RGB);
		return c;
	}
	
	//Criar um tom de cinzento aleatório
	
	static Color randomGray(){
		int RGB=randomSort(255);
		Color c=new Color(RGB,RGB,RGB);
		return c;
	}
	
	//Criar uma cor aleatória
	
	static Color randomColor(){
		int Red=randomSort(255);
		int Green=randomSort(255);
		int Blue=randomSort(255);
		Color c=new Color(Red,Green,Blue);
		return c;
	}
	
	//Criar um vetor de cores aleatórias dado um comprimento
	
	static Color[] randomColorArray(int length){
		Color c[]=new Color[length];
		for(int i=0; i!=c.length; i++){
			c[i]=randomColor();
		}
		return c;
		
	}
	
	//Dada uma cor, obter a cor inversa
	
	static Color inverted(Color color){
		int Red=color.getR();
		int Green=color.getG();
		int Blue=color.getB();
		Color i=new Color(255-Red, 255-Green, 255-Blue);
		return i;
	}
	
	
	/*Dada uma cor, ciar uma cor mais clara/escura, dependendo de um acréscimo 
	(delta)(positivo - mais clara; negativo mais escura)*/
	
	static Color changeBrightness(Color color,int delta){   //Mal feito
		int Red=color.getR();
		int Green=color.getG();
		int Blue=color.getB();
		if(Red>255||Green>255||Blue>255)
			System.out.println("Valor de RGB excede a paleta de cores");
		else{
			Red+=delta;
			Green+=delta;
			Blue+=delta;
			Color newColor=new Color(Red,Green,Blue);
			if(Red>255||Green>255||Blue>255)
				System.out.println("Valor de RGB excede a paleta de cores");
			else
				return newColor;
		}
		return color;
	}
	
	
	
	
	/* Imagens Binárias
	 * 
	 Criar uma imagem aleatória dada uma dimensão. A probabilidade de um pixel ser branco ou preto deverá
	 ser equivalente.*/
	
	static BinaryImage randomBinaryImage(int width, int height){
		BinaryImage img=new BinaryImage(width, height);
		for(int i=0;i!=width;i++){
			for(int j=0;j!=height;j++){
				boolean b=randomSortBoolean();
				if(b==true)
					img.setWhite(i,j);
				else
					img.setBlack(i,j);
			}
		}
		return img;
	}
	
	/*Preencher um quadrado branco fornecendo o ponto do canto superior esquerdo(x, y) e o comprimento 
	do lado(side) do quadrado*/
	
	static void drawSquare(BinaryImage img, int x, int y, int side){
		for(int i=x;i!=x+side;i++){
			for(int j=y;j!=y+side;j++){
				if(img.validPosition(i,j)){
					img.setWhite(j,i);
				}
			}
		}
	}
	
	static void drawSquareTest(){
		BinaryImage img=randomBinaryImage(300,300);
		drawSquare(img, 30, 30, 100);
		return;
	}
	
	//Inverter uma imagem binária, de forma a que cada pixel branco passe a preto, e vice-versa.
	
	static void invert(BinaryImage img){
		for(int i=0;i!=img.getWidth();i++){
			for(int j=0;j!=img.getHeight();j++){
				if(img.isBlack(i, j)==true)
					img.setWhite(i,j);
				else
					img.setBlack(i,j);
			}
		}
	}
	
	static void testInvert(){
		BinaryImage img=new BinaryImage(300,300);
		invert(img);
		return;
	}
	
	static BinaryImage invertFunc(){
		BinaryImage img=randomBinaryImage(300,300);
		BinaryImage newimg=new BinaryImage(300,300);
		drawSquare(img,30,30,100);
		for(int i=0;i!=img.getWidth();i++){
			for(int j=0;j!=img.getHeight();j++){
				if(img.isBlack(i,j)==true)
					newimg.setWhite(i,j);
				else
					newimg.setBlack(i,j);
			}
		}
		return newimg;
	}
	
	//Desenhar um contorno a preto nos píxeis limite de uma imagem.
	
	static void outline(BinaryImage img){
		for(int i=0;i!=img.getWidth();i++){
			img.setBlack(i,0);
			img.setBlack(i,img.getWidth()-1);
		}
		for(int j=0;j!=img.getHeight();j++){
			img.setBlack(0,j);
			img.setBlack(img.getHeight()-1,j);
		}
	}
	
	static void testOutline(){
		BinaryImage img=new BinaryImage(300,300);
		invert(img);
		outline(img);
		return;
	}
	
	/*Criar uma imagem binária a partir de uma matriz de booleanos, tendo as mesmas dimensões 
	da matriz, fazendo corresponder os valores true a branco e os false a preto. 
	O resultado desta função, quando utilizada uma matriz aleatória, será equivalente ao da alínea (a).*/
	
	static BinaryImage convert(boolean[][] data) {
		BinaryImage img=new BinaryImage(data.length,data[0].length);
		for(int i=0; i!=data.length; i++){
			for(int j=0; j!=data[i].length; j++){
				if(data[i][j]==true)
					img.setWhite(i,j);
				else
					img.setBlack(i,j);
			}
		}
		return img;
	}
	
	static void testConvert(){
		boolean[][]m=createRandomBooleanMatrix(100,300);
		BinaryImage img=convert(m);
		outline(img);
		return;
	}
	
	/*Torne a função anterior mais flexível, permitindo fornecer o tamanho de cada “pixel” na imagem (n). 
	Ao passo que na função anterior cada valor booleano é mapeado para um único pixel, 
	nesta será para um quadrado com dimensão variável (n x n).*/
	
	static BinaryImage convert(boolean[][]data,int pixelsize){
		BinaryImage img=new BinaryImage(data.length*pixelsize,data[0].length*pixelsize);
		for(int i=0; i!=data.length; i++){
			for(int j=0; j!=data[i].length; j++){
				for(int k=0;k!=pixelsize;k++){
					for(int l=0;l!=pixelsize;l++){
						if(data[i][j]==true)
							img.setWhite(i*pixelsize+k,j*pixelsize+l);
						else
							img.setBlack(i*pixelsize+k,j*pixelsize+l);
					}
				}
			}
		}
		return img;
	}
	
	/*Criar uma imagem binária que forme um tabuleiro de xadrez, indicando o número de pixeis de cada posição.
	Note que há uma linha de um pixel em torno do tabuleiro.*/
	
	static BinaryImage createChessBoard(int pixelsize){
		boolean[][]m=booleanChessBoard();
		BinaryImage chess=convert(m, pixelsize);
		outline(chess);
		return chess;
	}
	
	//Criar uma imagem escalada por um fator (p.e., fator 2 duplica o tamanho da imagem).
	
	static BinaryImage scale(BinaryImage img,int scale){
		BinaryImage scaledimg=new BinaryImage(img.getWidth()*scale,img.getHeight()*scale);
		for(int i=0; i!=img.getWidth(); i++){
			for(int j=0; j!=img.getHeight(); j++){
				for(int k=0;k!=scale;k++){
					for(int l=0;l!=scale;l++){
						if(img.isBlack(i,j)==true)
							scaledimg.setBlack(i*scale+k,j*scale+l);
						else
							scaledimg.setWhite(i*scale+k,j*scale+l);
					}
				}
			}
		}
		return scaledimg;
	}
	
	static BinaryImage testChessScale(){
		BinaryImage chess=createChessBoard(10);
		BinaryImage chessScale=scale(chess, 2);
		return chessScale;
	}
	
	/*Exercícios Extra
	 * 
	 Criar uma imagem binária através da sobreposição de duas imagens binárias, sendo que: 
	 se um pixel é branco em ambas as imagens, será branco na nova imagem; se um pixel é 
	 preto numa das imagens, será preto na nova imagem.*/
	
	static BinaryImage merge(BinaryImage img, BinaryImage img2){
		int height=Math.max(img.getHeight(),img2.getHeight());
		int width=Math.max(img.getWidth(),img2.getWidth());
		BinaryImage img3=new BinaryImage(width,height);
		invert(img3);
		for(int i=0;i!=img.getWidth();i++){
			for(int j=0;j!=img.getHeight();j++){
				if(img.isBlack(i,j)==true)
					img3.setBlack(i,j);
			}
		}
		for(int k=0;k!=img2.getWidth();k++){
			for(int l=0;l!=img2.getHeight();l++){
				if(img2.isBlack(k,l)==true)
					img3.setBlack(k,l);
			}
		}
		return img3;
	}
	
	static BinaryImage testMerge(){
		BinaryImage img=randomBinaryImage(60,60);
		BinaryImage img2=testChessScale();
		BinaryImage img3=merge(img,img2);
		return img3;
		
	}
	
	//Desenhar um círculo branco fornecendo o centro, sendo o raio igual a 5.
	
	static void drawCircleBasic(BinaryImage img, int x, int y) {
	    int radius = 49;
	    for (int i = x - radius; i <= x + radius; i++) {
	        for (int j = y - radius; j <= y + radius; j++) {
	            if (distance(x, y, i, j) <= radius) {
	                img.setWhite(i, j);
	            }
	        }
	    }
	}
	
	static BinaryImage testDrawCircleBasic(){
		BinaryImage img=new BinaryImage(100,100);
		drawCircleBasic(img,50,50);
		return img;
	}
	
	/*Torne o procedimento anterior mais flexível, permitindo:
		i) raio do círculo variável
		ii) preencher a branco ou preto*/
	
	static void drawCircle(BinaryImage img, int x, int y,int radius,boolean White) {
	    for (int i=x-radius;i<=x+radius;i++) {
	        for (int j=y-radius;j<=y+radius;j++) {
	            if (distance(x,y,i,j)<=radius&&White==true) {
	                img.setWhite(i,j);
	            }else if(distance(x,y,i,j)<=radius&&White==false)
	            	img.setBlack(i,j);
	        }
	    }
	}
	
	static BinaryImage testDrawCircle(){
		BinaryImage img=new BinaryImage(100,100);
		invert(img);
		drawCircle(img,50,50,49,false);
		return img;
	}
	
	//Criar uma imagem binária com o seguinte aspecto.
	
	static BinaryImage target(){
		BinaryImage img =new BinaryImage(200,200);	
		drawCircle(img,100,100,99,true);
		drawCircle(img,100,100,79,false);
		drawCircle(img,100,100,59,true);
		drawCircle(img,100,100,39,false);
		drawCircle(img,100,100,19,true);
		return img;
	}

}