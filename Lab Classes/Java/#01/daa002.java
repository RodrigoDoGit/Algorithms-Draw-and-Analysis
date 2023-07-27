import java.util.Scanner;

public class daa002{
    public static void main(String[] args){
	Scanner in = new Scanner(System.in);

	int n = in.nextInt();
	
        for(int i=0; i<n; i++){
	    int N = in.nextInt();
	    int K = in.nextInt();
	    int j = N+1;

	    while(soma(j) != K)
		j++;

	    System.out.println(j);
	}
    }

    public static int digit(int numero){
	int contador = 0;

	while(numero != 0){
	    numero /= 10;
	    contador+=1;
	}

	return contador;
    }
    
    public static int soma(int num){
	int soma = 0;
	int ndigit = digit(num);

	for(int i=0; i<ndigit; i++){
	    int resto = num%10;
	    num = (num-resto)/10;
	    soma+=resto;
	}
	
	return soma;
    }
}
