import java.util.Scanner;
import java.lang.Math;

public class daa003{
    static int id_geracao(String s){	
        int cases = 5290000;

	if(Character.isLetter(s.charAt(0))){
	    if(Character.isLetter(s.charAt(7)))
		return cases*3;

	    else
		return 0;
	}

	else{
	    if(Character.isLetter(s.charAt(3)))
		return cases*2;

	    else
		return cases;
	}
    }

    static int number(String s){
	int num = id_geracao(s);
	int base = 1;

	for(int i=7; i>=0; i--){
	    if(Character.isDigit(s.charAt(i))){
		num += (s.charAt(i) - '0') * base;
		base *= 10;
	    }
	}

	for(int i=7; i>=0; i--){
	    if(Character.isLetter(s.charAt(i))){
		int value = s.charAt(i) - 'A';

		if(s.charAt(i) > 'K')
		    value--;

		if(s.charAt(i) > 'W')
		    value--;

		if(s.charAt(i) > 'Y')
		    value--;

		num += value * base;
		base *= 23;
	    }
	}

	return num;
    }
    
    static int diferenca(String s, String s1){
	int diff = Math.abs(number(s) - number(s1));
	
	return diff;
    }
   

    public static void main(String[] args){
	Scanner in = new Scanner(System.in);
	int n = in.nextInt();
	

	for(int i=0; i<n; i++){
	    String str1 = in.next();
	    String str2 = in.next();

	    //System.out.println("Número da primeira matrícula: " + number(str1));
	    //System.out.println("Número da segunda matrícula: " + number(str2));
	    System.out.println(diferenca(str1, str2));
	    //System.out.println();
	}    
    }
}
