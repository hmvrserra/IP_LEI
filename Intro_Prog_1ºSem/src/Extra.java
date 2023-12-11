class Extra {
	
	//A. Defina uma função ​static boolean isLower(char c)​ que indica se o carácter c​​ é ou não uma letra minúscula.
	
	static boolean isLower(char c){
		return c>=97;
	}
	
	//B. Defina uma função que dado um vetor de caracteres, devolva quantas letras minúsculas o vetor contém.
	
	static int numCharArray(char[] c){
		int result=0;
		for(int i=0; i!=c.length; i++){
			if(c[i]>=97)
				result++;
		}
		return result;
	}
	
	//C. Defina uma função que dado um vetor de caracteres, devolva um novo vetor apenas com as letras minúsculas.
	
	static char[] lowerCaseArray(char[] c){
		char[] c2=new char[c.length];
		for(int i=0; i!=c.length; i++){
			if(c[i]<97)
				c2[i]=(char) (c[i]+32);
			else
				c2[i]=c[i];
		}
		return c2;
	}
	
	/*D. Defina uma função que dada uma matriz de caracteres, devolva quantas letras minúsculas a matriz contém. 
	De preferência use a função da alínea B.*/
	
	static int numCharMatrix(char[][] c){
		int result=0;
		for(int i=0; i!=c.length; i++){
			for(int j=0; j!=c[i].length; j++){
				if(c[i][j]>=97)
					result++;
			}
		}
		return result;
	}
}