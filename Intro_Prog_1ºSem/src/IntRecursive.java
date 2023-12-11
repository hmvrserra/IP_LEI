public class IntRecursive{
	//prev.a)
	static int divisors(int n){
		int numOfDivisors=0;
		int i=n;
		while (i!=0){
			if (n%i==0){
				numOfDivisors++;
			}
			i--;
		}
		return numOfDivisors;
	}
	
	//prev.b)
	static int sumDivisors(int n){
		int sumOfDivisors=0;
		int i=n-1;
		while (i!=0){
			if (n%i==0){
				sumOfDivisors+=i;
			}
			i--;
		}
		return sumOfDivisors;
	}
	
	//c)
	static int perfectNumbersUpToo(int n){
		int numOfPerfectNumbers=0;
		int i=n;
		while (i!=0){
			if (sumDivisors(i)==i){
				numOfPerfectNumbers++;
			}
			i--;
		}
		return numOfPerfectNumbers;
	}
	
	//d)
	static boolean isPrime(int n){
		return divisors(n)==2;
	}
	
	//e)
	static int sumPrimesSmallerThan(int n){
		int sumPrimes=0;
		int i=n-1;
		while (i!=0){
			if (isPrime(i)){
				sumPrimes+=i;
			}
			i--;
		}
		return sumPrimes;
	}
	
	//f)
	static int countPrimesUpTo(int n){
		int numOfPrimes=0;
		int i=n;
		while (i!=0){
			if (isPrime(i)){
			numOfPrimes++;
			}
			i--;
		}
		return numOfPrimes;
	}
	
	//g)
	static boolean existsPrimeBetween(int n,int p){
		int i = p-1;
		int numOfPrimes = 0;
		while (i!=n+1){
			if (isPrime(i)){
				numOfPrimes++;
			}
			i--;
		}
		return numOfPrimes>0;
	}
	
	//h)
	static int fibonacci(int n){
		if (n<=1){
			return n;
		}else{
			return fibonacci(n-1)+fibonacci(n-2);
		}
	}
	
	//i)
	static int factorial(int n){
		if (n==0){
			return 1;
		}else{
			return n*factorial(n-1);
		}
	}
	
	//j)
	static int gcd(int m,int n){
		if (n==0){
		      return m;
		}else{
		      return gcd(n, m%n);
		}
	}
	
	//ee.k)
	static int largerDifferenceBetweenPrimes(int n){
		int i=3;
		int lastPrime=2;
		int maxDiff=0;
		int diff=0;
		while (i<=n){
			if (isPrime(i)==true){
				diff=i-lastPrime;
				if (diff>maxDiff){
					maxDiff=diff;
				}
				lastPrime=i; 
			}
			i++;
		}
		return maxDiff;
	}
}