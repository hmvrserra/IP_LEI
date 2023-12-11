import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;

public class Sudoku {
	
	private int[][] readMatrixBoard;
	private SudokuBoard sudokuBoard;
	public ColorImage Sudoku_Board;
	
	
	// .sud Scanner
	static int[][] sudToMatrix(String filename,boolean FirstMatrix){
		int value = 0;
		int[][]first = new int[9][9];
		int[][]second = new int[9][9];
		try {
			Scanner scanner = new Scanner(new File(filename));{
				if(scanner.hasNextInt()==true){
					for(int i=0; i!=first.length; i++){
						for(int j=0; j!=first[i].length; j++){
							value = scanner.nextInt();
							first[i][j]=value;
						}
					}
				}
				while(scanner.hasNextInt()){
					for(int i=0; i!=second.length; i++){
						for(int j=0; j!=second[i].length; j++){
							value = scanner.nextInt();
							second[i][j]=value;
						}
					}
				}
			}
			scanner.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("File "+filename+" was not found");
		}
		if(FirstMatrix==true)
			return first;
		else
			return second;
	}
	
	
	// .sudgame Writer
	private void writeFileBoard(int[][] m){
		try {
			PrintWriter writer = new PrintWriter(new File("jogo1.sudgame"));
			writer.println(SudokuAux.convertMatrixToString(sudokuBoard.initialmatrixboard));
			writer.println(SudokuAux.convertMatrixToString(m));
			writer.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("File jogo1.sudgame was not found.");
		}
	}
	
	//Useful Functions 
	
	private void updateBoardImage(){
		SudokuAux.paintWhite(Sudoku_Board);
		SudokuAux.grid(Sudoku_Board);
		SudokuAux.colorNumberBoard(Sudoku_Board,sudokuBoard.matrixboard);
	}
	
	private void drawInvalidParts(){
		for(int i=0;i!=9;i++){
			if(SudokuAux.isLineValid(sudokuBoard.matrixboard,i)==false){
				SudokuAux.drawInvalidLine(Sudoku_Board,i);
			}
			if(SudokuAux.isColumnValid(sudokuBoard.matrixboard,i)==false){
				SudokuAux.drawInvalidColumn(Sudoku_Board,i);
			}
			if(SudokuAux.isSegmentValid(sudokuBoard.matrixboard,i)==false){
				SudokuAux.drawInvalidSegment(Sudoku_Board,i);
			}
		}
	}
	
	//Constructor
	
	Sudoku(String filename, double difficulty){
		readMatrixBoard=sudToMatrix(filename,true);
		this.sudokuBoard=new SudokuBoard(readMatrixBoard,difficulty);
		this.Sudoku_Board=SudokuAux.colorImageBoard(sudokuBoard.matrixboard);
		writeFileBoard(sudokuBoard.matrixboard);
	}
	
	//Methods
	
	void Make_Move(int x, int y, int num){	
		if(sudokuBoard.matrixboard[y][x]==0&&num>0&&num<10){
			sudokuBoard.matrixboard[y][x]=num;
			sudokuBoard.makeMove(x,y,num);
			SudokuAux.colorNumberBoard(Sudoku_Board,sudokuBoard.matrixboard);
			drawInvalidParts();
		}else{
			System.out.println("Unable to use Make_Move() as the square chosen is invalid or number inputed is not in the interval [1,9].");
		}
	}
	
	void Make_Random_Move(){
		sudokuBoard.makeRandomSegmentValidMove();
		SudokuAux.colorNumberBoard(Sudoku_Board,sudokuBoard.matrixboard);
		drawInvalidParts();
	}
	
	void Undo_Move(){
	    sudokuBoard.undoMove();
		updateBoardImage();
		drawInvalidParts();
	}
	
	void Redo_Move(){
		sudokuBoard.redoMove();		
		updateBoardImage();
		drawInvalidParts();
	}
	
	void Save_Board(){
		writeFileBoard(sudokuBoard.matrixboard);
	}
	
	void Load_Save(String filename){
		sudokuBoard.matrixboard=sudToMatrix(filename,false);
		updateBoardImage();
		drawInvalidParts();
		sudokuBoard.undoMatrix=new int[81][9][9];
		sudokuBoard.undoMatrix[0]=sudToMatrix("jogo1.sudgame",false);
		sudokuBoard.undoIndex=0;
		sudokuBoard.numOfPlays=0;
	}	
	
	void Reset_Game(){
		sudokuBoard.resetBoard();
		updateBoardImage();
	}
}