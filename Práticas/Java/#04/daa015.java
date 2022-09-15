public class daa015{
    public static void main(String[] args){
	FastScanner in = new FastScanner(System.in);
	int N = in.nextInt();
	int height[] = new int[N];

	for(int i=0; i<N; i++)
	    height[i] = in.nextInt();

	int end = 0, arrows = 0, i = 0, j = 1, k = 0;

	while(end != height.length){
	    if(j == height.length){
		height[i] = 0;
		end++;
		i = k;
		j = i+1;
		arrows++;
		
		continue;
	    }

	    if(height[i] == 0 && i < height.length - 2){
		i++;
		j = i+1;
		k = i+1;
	    }

	    if(height[i]-1 == height[j] && height[j] != 0){
		height[i] = 0;
		end++;

		if(k >= i && i < height.length)
		    k = i+1;

		i = j;
		j = i+1;
	    }

	    else
		j++;
	}

	System.out.println(arrows);
    }
}
