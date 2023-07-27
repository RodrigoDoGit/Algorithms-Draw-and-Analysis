import java.util.Scanner;

public class daa005{
    public static void main(String[] args){
	FastScanner in = new FastScanner(System.in);
	int N = in.nextInt();
	int soma = 0;
	int energia[] = new int[N+1];
	int ac[] = new int[N+1];
	
	for(int i=1; i<N+1; i++){
	    energia[i] = in.nextInt();
	    ac[i] = ac[i-1] + energia[i];
	}

	int F = in.nextInt();
	
	for(int j=0; j<F; j++){
	    int A = in.nextInt();
	    int B = in.nextInt();

	    for(int k=A; k<=B; k+=soma){
		soma = ac[B] - ac[A-1];
	    }

	    if(A == B)
		soma = energia[A];
	       
	    FastPrint.out.println(soma);
	    soma = 0;
	}

	FastPrint.out.close();
    }
}
