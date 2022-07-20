import java.util.Scanner;

public class daa018{
    public static void main(String[] args){
	Scanner in = new Scanner(System.in);
	int N = in.nextInt();
	int values[] = new int[N];

	for(int i=0; i<N; i++){
	    values[i] = in.nextInt();
	}
	
	int P = in.nextInt();
	int max = 0;
	int k[] = new int[P];

	for(int i=0; i<P; i++){
	    k[i] = in.nextInt();

	    if(k[i] > max)
		max = k[i];
	}

	max++;
	int coins[] = new int[max+1];
	int use[] = new int[max+1];
	coins[0] = 0;
	
	for(int i=1; i<=max; i++){
	    coins[i] = Integer.MAX_VALUE;

	    for(int j=0; j<N; j++){
		if(values[j] <= i && (1 + coins[i-values[j]] < coins[i])){
		    coins[i] = 1 + coins[i-values[j]];
		    use[i] = values[j];
		}
	    }
	}

       
	for(int i=0; i<P; i++){
	    System.out.print(k[i] + ":" + " " + "[" + coins[k[i]] + "]");
	    
	    while(k[i] > 0){
		System.out.print(" " + use[k[i]]);
		k[i] -= use[k[i]];
	    }

	    System.out.println();
	    
	    
	}
    }
}
