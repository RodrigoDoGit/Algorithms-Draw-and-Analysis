#include <stdio.h>

int main(){
  int n, s;
  int contador = 0;

  scanf("%d", &n);

  for(int i=0; i<n; i++){
    scanf("%d", &s);

    if(s == 42)
      contador++;
  }

  printf("%d\n", contador);

  return 0;
}
