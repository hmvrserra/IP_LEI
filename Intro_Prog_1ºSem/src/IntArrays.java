public class IntArrays{
	//prev.a)
	static int[] naturals(int n){
		int v[]=new int[n];
		int i=0;
		while (i<n){
			v[i]=i+1;
			i++;
		}
		return v;
	}
	
	//prev.b)
	static int sum(int[] v){
		int sum=0;
		int i=0;
		while (i!=v.length){
			sum+=v[i];
			i++;
		}
		return sum;
	}
	
	//prev.c)
	static int[] randomDigits(int n){
		int v[]=new int[n];
		int i=0;
		while (i<n){
			double r=Math.random();
			v[i]=(int)(r*10);
			i++;
		}
		return v;
	}
	
	//d)
	static double mean(int[] v){
		double mean=0;
		int i=0;
		while (i!=v.length){
			mean+=v[i];
			i++;
		}
		mean/=i;
		return mean;
	}
	
	//e)
	static int[] copy(int[] v,int length){
		int i=0;
		int vn[]=new int[length];
		while (i!=v.length){
			vn[i]=v[i];
			i++;
		}
		return vn;
	}
	
	//f)
	static int[] copy(int[] v){
		int i=0;
		int vn[]=new int[v.length];
		while (i!=v.length){
			vn[i]=v[i];
			i++;
		}
		return vn;
	}
	
	//g)
	static boolean exists(int n,int[] v){
	    int i=0;
	    while (i!=v.length){
	    	if (v[i]==n){
	    		return true;
	    	}
	    	i++;
	    }
	    return false;
	}
	
	//h)
	static int count(int n,int[] v){
		int i=0;
		int counter=0;
		while (i!=v.length){
			if (v[i]==n){
				counter++;
			}
			i++;
		}
		return counter;
	}
	
	//i)
	static int max(int[] v){
		int i=0;
		int max=0;
		while (i!=v.length){
			if (v[i]>max){
				max=v[i];
			}
			i++;
		}
		return max;
	}
	
	//j)
	static int[] subArray(int min,int max,int[] v){
		int i=0;
		int j=0;
		int vn[]=new int[max-min+1];
		while (i!=v.length){
			if (i>=min&&i<=max){
				vn[j]=v[i];
				j++;
			}
			i++;
		}
		return vn;
	}
	
	//k)
	static int[] firstHalf(int[] v,boolean includeMiddle){
	    int i=0;
	    int v1[]=new int[v.length/2];
		if (includeMiddle==true){
    		int v2[]=new int[(v.length+1)/2];
    		while (i!=(v.length+1)/2){
    			v2[i]=v[i];
    	    	i++;
    		}
    		return v2;
		}
	    while (i!=v.length/2){
	    	v1[i]=v[i];
	    	i++;
	    }
	    return v1;
	}
	
	//l)
	static int[] secondHalf(int[] v,boolean includeMiddle){
	    int i=(v.length/2)+1;
	    int j=0;
	    int v1[]=new int[(v.length/2)];
		if (includeMiddle==true){
    		int v2[]=new int[(v.length+1)/2];
    		while (i!=v.length+1){
    			v2[j]=v[i-1];
    			j++;
    	    	i++;
    		}
    		return v2;
		}
	    while (i!=v.length){
	    	v1[j]=v[i];
	    	j++;
	    	i++;
	    }
	    return v1;
	}
	
	//m)
	static int[] merge(int[] left, int[] right){
	     int i=0; 
	     int j=0;
	     int v[]=new int[left.length+right.length];
	     while (i!=left.length){
	    	 v[i]=left[i];
	    	 i++;
	     }
	     while (i!=left.length+right.length){
	    	 v[i]=right[j];
	    	 j++;
	    	 i++;
	     }
	     return v;
	}
	
	//n)
	static int[] invert(int[] v){
		int i=0;
		int j=v.length-1;
		int v1[]=new int[v.length];
		while (i!=v.length){
			v1[i]=v[j];
			i++;
			j--;
		}
		return v1;
	}
	
	//o)
	static int random(int[] v){
		double r=(Math.random()*v.length);
		double sortedNum=v[(int) r];
		return (int) sortedNum;
	}
	
	//ee.p)
	static int[] duplicateEveryElement(int[] v){
		int v1[]=new int[v.length*2];
		int i=0;
		int j=0;
		while (j!=v.length*2){
			v1[j]=v[i];
			v1[j+1]=v[i];
			j+=2;
			i++;
		}
		return v1;
	}
	
	//ee.q)
	static int[] duplicateInverted(int[] v){
		int v1[]=new int[v.length*2];
		int i=0;
		int j=0;
		while (j!=v.length){
			v1[j]=v[i];
			j++;
			i++;
		}
		while (i!=0){
			v1[j]=v[i-1];
			j++;
			i--;
		}
		return v1;
	}
	
	//ee.r)
	static int[] copyWithoutMiddleElement(int[] v){
		int v1[]=new int[v.length];
		int v2[]=new int[v.length-1];
		int i=0;
		if (v.length%2==1){
			while (i!=(v.length/2)){
				v2[i]=v[i];
				i++;
			}
			while ((i+1)!=(v.length)){
				v2[i]=v[i+1];
				i++;
			}
			return v2;
		}
		while (i!=v.length){
			v1[i]=v[i];
			i++;
		}
		return v1;
	}
	
	//ee.s)
	static int[] fibonacciSequence(int n){
		int v[]=new int[n];
		int i=2;
		v[0]=0;
		v[1]=1;
		while (i!=v.length){
			v[i]=v[i-1]+v[i-2];
			i++;
		}
		return v;
	}
}