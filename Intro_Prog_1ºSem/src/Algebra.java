public class Algebra {
	
	//a)
	static int[][] createIdentity(int order){
		int[][]m=new int[order][order];
		for (int i=0; i!=m.length; i++){
			m[i][i]=1;
		}
		return m;
	}
	
	//b)
	static void scalarMultiplication(int[][]m, int c){
		for(int i=0; i!=m.length; i++){
			for(int j=0; j!=m[i].length; j++){
				m[i][j]*=c;
			}
		}
	}
	
	//c)
	static boolean isIdentity(int[][]m){
		if(m.length!=m[0].length){
			return false;
		}
		for(int i=0; i!=m.length; i++){
			for(int j=0; j!=m[i].length; j++){
				if(i==j&&m[i][j]!=1){
					return false;
				}else if (i!=j&&m[i][j]!=0){
					return false;
				}
			}
		}
		return true;
	}
	
	//d)
	static void addition(int[][]a, int[][]b){
		if (a.length!=b.length||a[0].length!=b[0].length){
			return;
		}else{
			for(int i=0; i!=a.length; i++){
				for(int j=0; j!=a[i].length; j++){
					a[i][j]+=b[i][j];
				}
			}
		}
		
	}
	//e)
	static boolean isValid(int[][]m){
		for(int i=1; i!=m.length; i++){
			if(m[0].length!=m[i].length)
				return false;
		}
		return true;
	}
	
	//f)
	static boolean isSquareValid(int[][]m){
		for(int i=1; i!=m.length; i++){
			if(m[0].length!=m[i].length||m[i].length!=m.length)
				return false;
		}
		return true;
		
	}
	
	//g)
	static boolean isSame(int[][]m, int[][]n){
		for(int i=0; i<m.length; i++){
			for(int j=0; j<m[i].length; j++){
				if(m[i][j]!=n[i][j])
					return false;
			}
		}
		return true;
	}
	
	//h)
	static int[] arrayColumn(int[][]m, int column){
		int[] a=new int[m[0].length];
		int j=column-1;
		for(int i=0; i<m.length; i++){
			a[i]=m[i][j];
		}
		return a;
	}
	
	//i)
	static int[][] transpose(int[][]m){
		int[][] t=new int[m[0].length][m.length];
		for(int i=0; i<m.length; i++){
			for(int j=0; j<m[i].length; j++){
				t[j][i]=m[i][j];
			}
		}
		return t;
	}
	
	//j)
	static boolean isSimetric(int[][]m){
		for(int i=0; i<m.length; i++){
			for(int j=0; j<m[i].length; j++){
				if(m[i][j]!=m[j][i])
					return false;
			}
		}
		return true;
	}
	
	//ee.k)
	static int[][] multiplication(int[][]m,int[][]n){
		int[][]a=new int[m.length][n[0].length];
		if(m[0].length!=n.length){
			return null;
		}else{
			for(int i=0; i<m.length; i++){
				for(int j=0; j<m[i].length; j++){
					//Não finalizada
				}	
			}
			return a;
		}
	}
}