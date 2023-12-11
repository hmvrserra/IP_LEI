public class Integers{
	//prev.a)
	static int max(int a, int b){
		if (a>=b){
			return a;
		}else{
			return b;
		}
	}
	
	//prev.b)
	static boolean isMultiple(int a,int b){
		return a%b==0;
	}
	
	//c)
	static int abs(int a){
		if (a<0) {
			return a*(-1);
		} else {
			return a;
		}
	}
	
	//d)
	static int escalaoIRS(int a){
		int level=0;
		if (a<=9999){
			level=1;
		}
		if (10000<=a&&a<=25499){
			level=2;
		}
		if (25500<=a&&a<=48499){
			level=3;
		}
		if (48500<=a){
			level=4;
		}
		return level;
	}
	
	//e)
	static char next(char a){
		char result=0;
		char letter=a;
		if (a=='z'){
			return result='a';
		}else{
			result=(char)(letter+1);
		}
		return result;
	}
	
	//f)
	static int firstDigit(int n){
		int d=10;
		int result=n;
		while(result>=10){
			result/=d;
		}
		return result;
	}
	
	//g)
	static int divide(int a,int b){
		int result=0;
		while (a>=b){
			result++;
			a-=b;
		}
		return result;
	}
	
	//h)
	static int powerOfTwo(int n){
		int result=2;
		int power=n;
		if (n==0){
			return result=1;
		}
		while (power!=1){
			result*=2;
			power--;
		}
		return result;
	}
	
	//i)
	static int sumNaturalsUpTo(int n){
		int result=0;
		while (n>=0){
			result+=n;
			n--;
		}
		return result;	
	}
	
	//j)
	static int sumEvenNumbersBetween(int n, int p){
		int max = p;
		int min = n;
		int result = 0;
		while (max>=min){
			if (max%2==0){
				result+=max;
				max-=2;
			}else{
				max--;
				if(max%2==0)
					result+=max;
					max-=2;
			}
		}
		return result;	
	}
	
	//ee.k)
	static int nFibonacci(int n){
		int secondToLast=0;
		int last=1;
		int result=1;
		if (n==0){
			result=0;
			return result;
		}
		if (n<=2){
			return result;
		}else{
			while (n!=1){
				result=last+secondToLast;
				secondToLast=last;
				last=result;
				n--;
			}
		}	
		return result;
	}
	
	//ee.l)
	static int gcd(int m,int n){
		int rest;
		while (n!=0){
		       rest=m%n;
		       m=n;
		       n=rest;
		}
		return m;
	}
}