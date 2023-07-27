import java.util.Scanner;
import java.lang.Math;

public class daa006{
    public static void main(String[] args){
	Scanner in = new Scanner(System.in);
	int N = in.nextInt();

	for(int i=0; i<N; i++){
	    double qx = in.nextInt();
	    double qy = in.nextInt();
	    double ql = in.nextInt();
	    double cx = in.nextInt();
	    double cy = in.nextInt();
	    double cr = in.nextInt(); 

	    System.out.println(intersecao(qx, qy, ql, cx, cy, cr));
	}
    }

    static boolean pointInsideCircle(double x, double y, double cx, double cy, double cr){
	if(((cx-x)*(cx-x) + (cy-y)*(cy-y)) <= cr*cr)
	    return true;

	return false;
    }

    static boolean pointInsideSquare(double x, double y, double qx, double qy, double ql){
	if((x>=qx && y>=qy) && (x<=qx+ql && y<=qy+ql) && (x>=qx && y<=qy+ql) && (x<=qx+ql && y>=qy))
	    return true;

	return false;
    }

    static boolean out(double cx, double cy, double cr, double qx, double qy, double ql){
	if(!pointInsideSquare(cx, cy+cr, qx, qy, ql) && !pointInsideSquare(cx, cy-cr, qx, qy, ql) && !pointInsideSquare(cx-cr, cy, qx, qy, ql) && !pointInsideSquare(cx+cr, cy, qx, qy, ql) && !pointInsideCircle(qx, qy, cx, cy, cr) && !pointInsideCircle(qx, qy+ql, cx, cy, cr) && !pointInsideCircle(qx+ql, qy+ql, cx, cy, cr) && !pointInsideCircle(qx+ql, qy, cx, cy, cr))
	    return true;

	else
	    return false;
    }

    static boolean squareInsideCircle(double qx, double qy, double ql, double cx, double cy, double cr){
	if(pointInsideCircle(qx, qy, cx, cy, cr) && pointInsideCircle(qx+ql, qy, cx, cy, cr) && pointInsideCircle(qx, qy+ql, cx, cy, cr) && pointInsideCircle(qx+ql, qy+ql, cx, cy, cr))
	    return true;

	else
	    return false;
    }

    static boolean circleInsideSquare(double cx, double cy, double cr, double qx, double qy, double ql){
	if(pointInsideSquare(cx, cy-cr, qx, qy, ql) && pointInsideSquare(cx, cy+cr, qx, qy, ql) && pointInsideSquare(cx-cr, cy, qx, qy, ql) && pointInsideSquare(cx+cr, cy, qx, qy, ql))
	    return true;

	else
	    return false;
    }
    
    static double intersecao(double qx, double qy, double ql, double cx, double cy, double cr){
	if(out(cx, cy, cr, qx, qy, ql) && !squareInsideCircle(qx, qy, ql, cx, cy, cr) && !circleInsideSquare(cx, cy, cr, qx, qy, ql))
 	    return 0;

	else if(squareInsideCircle(qx, qy, ql, cx, cy, cr))
	    return ql*ql;

	else if(circleInsideSquare(cx, cy, cr, qx, qy, ql))
	    return Math.PI * cr*cr; 

	double area = 0;

	if(ql >= 0.0001){
		area = area + intersecao(qx, qy+ql/2, ql/2, cx, cy, cr);
		area = area + intersecao(qx+ql/2, qy+ql/2, ql/2, cx, cy, cr);
		area = area + intersecao(qx, qy, ql/2, cx, cy, cr);
		area = area + intersecao(qx+ql/2, qy, ql/2, cx, cy, cr);
	}

	return area;
    }
}
