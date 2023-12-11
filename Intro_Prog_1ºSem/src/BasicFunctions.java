public class BasicFunctions{
	//a)
	static int doubleOf(int x){
		return 2*x;
	}
	
	//b)
	static int squareOf(int x){
		return x*x;
	}
	
	//c)
	static int differenceOf(int a, int b){
		return a-b;
	}
	
	//d)
	static double percentage(double n, double total){
		return (n/total)*100;
	}
	
	//e)
	static double averageOf(double a, double b){
		return (a+b)/2;
	}
	
	//f)
	static int round(double a){
		double result=a+0.5;
		return (int)result;
	}
	
	//g)
	static boolean isNegative(int x){
		return x<0;
	}
	
	//h)
	static boolean isOdd(int x){
		return x%2==1;
	}
	
	//i)
	static boolean isEven(int x){
		return x%2==0;
	}
	
	//j)
	static boolean isSmallerThan(int a,int b){
		return a<b;
	}
	
	//k)
	static boolean isOneDigit(int x){
		return x>-10&&x<10;
	}
	
	//l)
	static boolean isIncluded(int a,int x,int b){
		return x>a&&x<b;
	}
	
	//m)
	static boolean isExcluded(int a,int x,int b){
		return x<a||x>b;
	}
	
	//n)
	static boolean isMultipleAndEven(int a, int b){
		return a%2==0&&a%b==0;
	}
	
	//o)
	static boolean isEvenOrNegative(int x){
		return x%2==0||x<0;
	}
	
	//p)
	static boolean xor(boolean a, boolean b){
		return a!=b;
	}
	
	//q)
	static boolean isVowel(char x){
		return x=='a'||x=='e'||x=='i'||x=='o'||x=='u';
	}
}