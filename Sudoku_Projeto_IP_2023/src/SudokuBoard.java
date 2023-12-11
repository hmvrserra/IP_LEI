class SudokuBoard {
	
	public int[][] matrixboard;
	public final int[][] initialmatrixboard;
	public int[][][] undoMatrix;
	public int undoIndex;
	public int numOfPlays;
	
	//Useful Functions
	
	public static int[][]copy(int[][]matrix){
		int[][]copy=new int[matrix.length][matrix[0].length];
		for(int i=0; i!=matrix.length; i++){
			for(int j=0; j!=matrix[i].length; j++){
				copy[i][j]=matrix[i][j];
			}
		}
		return copy;
	}
	
	//Constructor
	
	SudokuBoard(int[][] validMatrix, double difficulty){
		this.matrixboard=SudokuAux.difficultyMatrix(validMatrix,difficulty);	
		this.initialmatrixboard=copy(validMatrix);
		this.undoMatrix=new int[81][9][9];
		this.undoIndex=0;
		this.numOfPlays=0;
		saveState();
	}
	
	
	
	
	//Methods
	
	int getCoordValue(int x,int y){
		return matrixboard[y][x];
	}
	
	void makeMove(int x, int y, int num){
		undoIndex++;
		numOfPlays++;
		if(num>0&&num<10){
			if(matrixboard[y][x]==0){
				matrixboard[y][x]=num;
			}
		}
		saveState();
		if(isTheGameConcluded()==true){
			System.out.println("Congratulations, you've finished the game.");
		}
	} 
	
	void makeRandomSegmentValidMove() {
	    while (true) {
	        int rx=(int)(Math.random()*9);
	        int ry=(int)(Math.random()*9);
	        int r=(int)(Math.random()*9)+1;
	        if (matrixboard[rx][ry]==0) {
	        	int segmentNumber = (rx / 3) * 3 + ry / 3;
	            matrixboard[rx][ry]=r;
	            if (SudokuAux.isSegmentValid(matrixboard,segmentNumber)) {
	                undoIndex++;
	                numOfPlays++;
	                saveState();
	                break;
	            } else {
	            matrixboard[rx][ry]=0;
	            }
	        }	
	    }
	    if (isTheGameConcluded()==true) {
	        System.out.println("Congratulations, you've finished the game");
	    }
	}
	
	void resetBoard(){
		matrixboard=copy(initialmatrixboard);
		undoMatrix=new int[81][9][9];
		undoMatrix[0]=matrixboard;
		undoIndex=0;
		numOfPlays=0;
	}
	
	
	boolean[] getInvalidSegments(){
		boolean[] a=new boolean[9];
		for(int i=0;i<=8;i++){
			if(SudokuAux.isSegmentValid(matrixboard,i)==false){
				a[i]=true;
			}
		}
		return a;
	}
	
	boolean[][] getInvalidLinesAndColumns(){
		boolean[][] a=new boolean[2][9];
		for(int i=0;i<=8;i++){
			if(SudokuAux.isLineValid(matrixboard,i)==false){
				a[0][i]=true;
			}
			if(SudokuAux.isColumnValid(matrixboard,i)==false){
				a[1][i]=true;
			}
		}
		return a;
	}
	
	boolean isTheGameConcluded(){
		for(int i=0;i!=matrixboard.length;i++){
			for(int j=0;j!=matrixboard[i].length;j++){
				if(matrixboard[i][j]==0||SudokuAux.isMatrixValid(matrixboard)==false){
					return false;
				}
			}
		}
		return true;
	}
	
	private void saveState() {
        for (int i = 0; i < 9; i++) {
        	for (int j = 0; j < 9; j++) {
        		undoMatrix[undoIndex][i][j] = matrixboard[i][j];
            }
        }
    }

	void undoMove() {
        if (undoIndex>0) {
            undoIndex--;
            for(int i=0; i<matrixboard.length;i++){
            	for(int j=0; j<matrixboard[i].length;j++){
            		matrixboard[i][j]=undoMatrix[undoIndex][i][j];
            	}
            }
        }else{
            System.out.println("Unable to use Undo_Move() as the board is in its initial state.");
        }
    }
	
	void redoMove(){
		if(undoIndex<numOfPlays){
			undoIndex++;
			for(int i=0; i<matrixboard.length;i++){
            	for(int j=0; j<matrixboard[i].length;j++){
            		matrixboard[i][j]=undoMatrix[undoIndex][i][j];
            	}
            }
		}else{
            System.out.println("Unable to use Redo_Move() as the board is in its most recent state.");
		}
	}
}