#include <iostream>

using namespace std;

int digit(int numero){
  int contador = 0;

  while(numero != 0){
    numero /= 10;
    contador += 1;
  }

  return contador;
}

int soma(int num){
  int soma = 0;
  int ndigit = digit(num);

  for(int i=0; i<ndigit; i++){
    int resto = num%10;
    num = (num-resto)/10;
    soma += resto;
  }

  return soma;
}

int main(){
  int n;

  cin >> n;

  for(int i=0; i<n; i++){
    int N, K;

    cin >> N;
    cin >> K;

    int j = N+1;
    
    while(soma(j) != K)
      j++;

    cout << j << endl;
  }

  return 0;
}

