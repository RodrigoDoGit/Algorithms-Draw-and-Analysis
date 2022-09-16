#include <stdio.h>

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

  scanf("%d", &n);

  for(int i=0; i<n; i++){
    int N, K;

    scanf("%d", &N);
    scanf("%d", &K);
    int j = N+1;

    while(soma(j) != K)
      j++;

    printf("%d\n", j);
  }

  return 0; 
}

