public class CharArrays {

	//prev.a)
	static char[] create(char c,int n){
		char[] v=new char[n];
		for(int i=0; i!=n; i++){
			v[i]=c;
		}
		return v;
	}
	
	//prev.b)
	static void fill(char c,char[] v){
		for(int i=0; i!=v.length; i++){
			v[i]=c;
		}
	}
	
	//prev.c)
	static void replace(char a,char b,char[] v){
		for(int i=0; i!=v.length; i++){
			if(v[i]==a)
				v[i]=b;
		}
	}
	
	//d)
	static void replaceFirstOccurence(char a,char b,char[] v){
		for(int i=0; i<v.length; i++){
			if(v[i]==a){
				v[i]=b;
				return;
			}
		}
	}
	
	//e)
	static void replaceLastOccurence(char a,char b,char[] v){
		for(int i=(v.length-1); i!=(-1); i--){
			if(v[i]==a){
				v[i]=b;
				return;
			}
		}
	}
	
	//f)
	static void shiftLeft(char[] v){
		char first=v[0];
		for(int i=0; i!=v.length-1; i++){
			v[i]=v[i+1];
		}
		v[v.length-1]=first;
	}
	
	//g)
	static void shiftRight(char[] v){
		char last=v[v.length-1];
		for(int i=v.length-1; i!=0; i--){
			v[i]=v[i-1];
		}
		v[0]=last;
	}
	
	//h)
	static void swap(int i,int j, char[] v){
		char swap=v[i];
		v[i]=v[j];
		v[j]=swap;
	}
	
	//i)
	static void invert(char[] v){
		for (int i=0; i!=v.length/2; i++){
			swap(i,(v.length-1-i),v);
		}
	}
	
	//j)
	static char[] copy(char[] array){
		char[] copyOf=new char[array.length];
		for(int i=0; i!=array.length; i++){
				copyOf[i]=array[i];
		}
		return copyOf;
	}
	
	//k)
	static char[] subarray(char[] array,int firstSub,int lastSub){
		int ii=0;
		char[] subarray=new char[(lastSub-firstSub)+1];
		for(int i=firstSub; i<=lastSub; i++){
			subarray[ii]=array[i];
			ii++;
		}
		return subarray;
	}
	
	//l)
	static int randomIndex(int max){
	    double r=(Math.random()*max)+0.5;
	    return (int) r;
	}
	
	//m)
	static void replaceRandomChar(char c,char[] v){
		v[randomIndex(v.length-1)]=c;
	}
	
	//n)
	static void shuffleArray(char[] v){
		for(int i=v.length-1; i!=0; i--){
			int j=randomIndex(i+1);
			swap(i,j,v);
		}
	}
	
	//o)
	static void bubbleSort(char[] v) {
        for(int i=0;i!=v.length-1;i++) {
            for (int j=0;j!=v.length-1-i;j++) {
                if (v[j]>v[j+1]) {
                	swap(j,j+1,v);
                }
            }
        }
    }
	
	//ee.p)
	static char[] concat(char[] v,char c){
		char[] array=new char[v.length+1];
		for(int i=0; i!=v.length; i++){
			array[i]=v[i];
			array[v.length]=c;
		}
		return array;
	}
	
	//ee.q)
	static char[] merge(char[] left, char[] right){
	    int j=0;
	    int i=0;
	    char v[]=new char[left.length+right.length];
	    for (i=0; i!=left.length; i++){
	    	 v[i]=left[i];
	    }
	    for (i=left.length; i!=left.length+right.length; i++){
   		 v[i]=right[j];
   		 j++;
	    }
	    return v;
	}
	
	//ee.r)
	static void replaceRandom(char c,char[] v){
		v[randomIndex(v.length-1)]=c;
	}
	
	//ee.s)
	static void swapHalves(char[] v){
		int j=v.length/2;
		if(v.length%2!=0){
			return;
		}
		for(int i=0; i!=v.length/2; i++){
			swap(i,j, v);
			j++;
		}
	}
}