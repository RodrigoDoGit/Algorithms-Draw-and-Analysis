import java.util.Scanner;
import java.util.Arrays;

class Encomenda implements Comparable<Encomenda>{
    public double racio;
    public int numero;

    Encomenda(double r, int n){
	racio = r;
	numero = n;
    }

    @Override
    public int compareTo(Encomenda e){
	if(e.racio > racio)
	    return +1;

	if(e.racio < racio)
	    return -1;

        return numero - e.numero;
    }
}

public class daa014{
    public static void main(String[] args){
	Scanner in = new Scanner(System.in);
	int N = in.nextInt();
	Encomenda encomendas[] = new Encomenda[N];
	
	for(int i=0; i<N; i++){
	    int D = in.nextInt();
	    int M = in.nextInt();
	    double rac = (double) M/D;
	    
	    encomendas[i] = new Encomenda(rac, i+1);

	    //System.out.println("Encomenda nº: " + encomendas[i].numero + ", com rácio: " + encomendas[i].racio);
	}

	Arrays.sort(encomendas);

	/*for(int i=0; i<N; i++)
	  System.out.println("Encomenda nº: " + encomendas[i].numero + ", com rácio: " + encomendas[i].racio); */

	for(int i=0; i<N-1; i++)
	    System.out.print(encomendas[i].numero + " ");

	System.out.println(encomendas[N-1].numero);
    }
}
