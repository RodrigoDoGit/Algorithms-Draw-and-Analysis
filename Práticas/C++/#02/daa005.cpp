#include <iostream>
#include <cstdio>
using namespace std;

int main(){
  int N, soma = 0, F;
  cin >> N;
  
  int energia[N+1];
  int ac[N+1];

  for(int i=1; i<N+1; i++){
    cin >> energia[i];
    ac[i] = ac[i-1] + energia[i];
  }

  cin >> F;

  for(int j=0; j<F; j++){
    int A, B;

    cin >> A;
    cin >> B;

    for(int k=A; k<=B; k+=soma){
      soma = ac[B] - ac[A-1];
    }

    if(A == B)
      soma = energia[A];

    cout << soma << '\n';
    soma = 0;
  }
  
  return 0;
}
