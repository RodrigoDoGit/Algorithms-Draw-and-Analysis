import java.util.Scanner;
import java.lang.Math;

public class daa017{
    public static void main(String[] args){
	Scanner in = new Scanner(System.in);
	int N = in.nextInt();
	int D = in.nextInt();
	long p[][] = new long[N+1][N+1];
	
	for(int i=1; i<p.length; i++)
	    for(int j=1; j<p.length; j++)
		p[i][j] = 1;

	for(int i=0; i<D; i++)
	    p[in.nextInt()][in.nextInt()] = 0;

	for(int i=2; i<p.length; i++){
	    for(int j=1; j<=p.length-i; j++)
		if(p[i][j] == 1)
		    p[i][j] = p[i-1][j] + p[i-1][j+1];
	}

	long M = p[p.length-1][1];

	System.out.println(M);
    }
}
