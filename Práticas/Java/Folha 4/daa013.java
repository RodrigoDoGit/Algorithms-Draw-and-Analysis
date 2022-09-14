import java.util.Scanner;
import java.util.Arrays;

class Segmento implements Comparable<Segmento>{
    public int li;
    public int ri;
    public int size;

    Segmento(int l, int r){
	li = l;
	ri = r;
	size = ri-li;
    }

    
    public int compareTo(Segmento c){
	if(li < c.li)
	    return -1;
	
        if(li > c.li)
	    return 1;

	if(size < c.size)
	    return 1;

	if(size > c.size)
	    return -1;

	return 0;
    }
}

public class daa013{
    public static void main(String[] args){
	Scanner in = new Scanner(System.in);
        int M = in.nextInt();
	int N = in.nextInt();
        Segmento segmentos[] = new Segmento[N];
   
	for(int i=0; i<N; i++){
	    segmentos[i] = new Segmento(in.nextInt(), in.nextInt());
	}

	Arrays.sort(segmentos);

	int end = 0, bigger = 0, count = 0;

	while(end < M){
	    for(int i=0; segmentos[i].li <= end; i++){
		if(segmentos[i].ri > bigger)
		    bigger = segmentos[i].ri;

		if(i == segmentos.length - 1)
		    break;
	    }

	    end = bigger;
	    count++;
	}

	System.out.println(count);
    }
}
