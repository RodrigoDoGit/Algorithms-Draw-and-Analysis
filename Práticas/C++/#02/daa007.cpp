#include <iostream>

using namespace std;

int sms(int v[], int a, int b){
  if(a == b)
    return v[a];

  int middle = (a+b)/2;
  int best1 = sms(v, a, middle);
  int best2 = sms(v, middle+1, b);
  int bestFirst = 0;
  int tmpFirst = v[middle];

  if(tmpFirst > bestFirst)
    bestFirst = tmpFirst;

  for(int i=middle-1; i>=a; i--){
    tmpFirst += v[i];

    if(tmpFirst > bestFirst)
      bestFirst = tmpFirst;
  }

  int bestSecond = 0;
  int tmpSecond = v[middle+1];

  if(tmpSecond > bestSecond)
    bestSecond = tmpSecond;

  for(int i=middle+2; i<=b; i++){
    tmpSecond += v[i];

    if(tmpSecond > bestSecond)
      bestSecond = tmpSecond;
  }

  int best3 = bestFirst + bestSecond;

  return max(best1, max(best2, best3));
}

int main(){
  int N;

  cin >> N;
  
  int v[N];

  for(int i=0; i<N; i++)
    cin >> v[i];
    
  cout << sms(v, 0, N-1) << endl;
  
  return 0;
}
