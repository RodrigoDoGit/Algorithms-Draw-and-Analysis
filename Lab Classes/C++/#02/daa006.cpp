#include <iostream>
#include <math.h>

using namespace std;

bool pointInsideCircle(double x, double y, double cx, double cy, double cr){
  if(((cx-x)*(cx-x) + (cy-y)*(cy-y)) <= cr*cr)
    return true;

  return false;
}

bool pointInsideSquare(double x, double y, double qx, double qy, double ql){
  if((x >= qx && y >= qy) && (x <= qx+ql && y <= qy+ql) && (x >= qx && y <= qy+ql) && (x <= qx+ql && y >= qy))
    return true;

  return false;
}

bool out(double cx, double cy, double cr, double qx, double qy, double ql){
  if(!pointInsideSquare(cx, cy+cr, qx, qy, ql) && !pointInsideSquare(cx, cy-cr, qx, qy, ql) && !pointInsideSquare(cx-cr, cy, qx, qy, ql) && !pointInsideSquare(cx+cr, cy, qx, qy, ql) && !pointInsideCircle(qx, qy, cx, cy, cr) && !pointInsideCircle(qx, qy+ql, cx, cy, cr) && !pointInsideCircle(qx+ql, qy+ql, cx, cy, cr) && !pointInsideCircle(qx+ql, qy, cx, cy, cr))
    return true;

  return false;
}

bool squareInsideCircle(double qx, double qy, double ql, double cx, double cy, double cr){
  if(pointInsideCircle(qx, qy, cx, cy, cr) && pointInsideCircle(qx+ql, qy, cx, cy, cr) && pointInsideCircle(qx, qy+ql, cx, cy, cr) && pointInsideCircle(qx+ql, qy+ql, cx, cy, cr))
    return true;

  return false;
}

bool circleInsideSquare(double cx, double cy, double cr, double qx, double qy, double ql){
  if(pointInsideSquare(cx, cy-cr, qx, qy, ql) && pointInsideSquare(cx, cy+cr, qx, qy, ql) && pointInsideSquare(cx-cr, cy, qx, qy, ql) && pointInsideSquare(cx+cr, cy, qx, qy, ql))
    return true;

  return false;
}

double intersecao(double qx, double qy, double ql, double cx, double cy, double cr){
  if(out(cx, cy, cr, qx, qy, ql) && !squareInsideCircle(qx, qy, ql, cx, cy, cr) && !circleInsideSquare(cx, cy, cr, qx, qy, ql))
    return 0;

  else if(squareInsideCircle(qx, qy, ql, cx, cy, cr))
    return ql*ql;

  else if(circleInsideSquare(cx, cy, cr, qx, qy, ql))
    return M_PI * cr*cr;

  double area = 0;

  if(ql >= 0.0001){
    area += intersecao(qx, qy+ql/2, ql/2, cx, cy, cr);
    area += intersecao(qx+ql/2, qy+ql/2, ql/2, cx, cy, cr);
    area += intersecao(qx, qy, ql/2, cx, cy, cr);
    area += intersecao(qx+ql/2, qy, ql/2, cx, cy, cr);
  }

  return area; 
}

int main(){
  int N;

  cin >> N;

  for(int i=0; i<N; i++){
    double qx, qy, ql, cx, cy, cr;

    cin >> qx;
    cin >> qy;
    cin >> ql;
    cin >> cx;
    cin >> cy;
    cin >> cr;

    cout << intersecao(qx, qy, ql, cx, cy, cr) << endl;
  }
  
  return 0;
}
