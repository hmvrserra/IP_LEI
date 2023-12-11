public class IntMatrices {
	
	/*funções necessárias:
	 *
	random index command)*/
	static int randomIndex(int max){    
	    double r=(Math.random()*max)+0.5;
	    return (int) r;
	}
	
	
	
	//prev.a)
	static int[][] createRandomMatrix(int lines, int columns){
		int[][] m=new int[lines][columns];
		for(int i=0; i!=m.length; i++){
			for(int j=0; j!=m[i].length; j++){
				m[i][j]=randomIndex(9);
			}
		}
		return m;
	}
	
	//prev.b)
	static int[][] createRandomSquareMatrix(int linesAndColumns){
		int[][] m=new int[linesAndColumns][linesAndColumns];
		for(int i=0; i!=m.length; i++){
			for(int j=0; j!=m[i].length; j++){
				m[i][j]=randomIndex(9);
			}
		}
		return m;
	}
	
	//prev.c)
	static int sumOfAllValues(int[][] m){
		int sum=0;
		for(int i=0; i!=m.length; i++){
			for(int j=0; j!=m[i].length; j++){
				sum+=m[i][j];
			}
		}
		return sum;
	}
	
	//prev.d)
	static int amountOfValues(int[][] m){
		int value=m.length*m[0].length;
		return value;
	}
	
	//e)
	static int[] unroll(int[][] m){
		int k=0;
		int[] v=new int[m.length*m[0].length];
		for(int i=0; i!=m.length; i++){
			for(int j=0; j!=m[i].length; j++){
				v[k]=m[i][j];
				k++;
			}
		}
		return v;
	}
	
	
	//f)
	static int[][] createMatrix(int[] values, int lines, int columns){
		int k=0;
	    int[][]m=new int[lines][columns];
	    for(int i=0; i!=m.length; i++){
			for(int j=0; j!=m[i].length; j++){
				if(k<values.length){
					m[i][j]=values[k];
					k++;
				}else{
					m[i][j]=0;
				}
			}
	    }
	    return m;
	}
}