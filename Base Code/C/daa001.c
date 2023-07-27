// Exemplo de codigo em C
// [DAA 001] O sentido da vida
// -------------------------------------
// Pedro Ribeiro (DCC/FCUP) - 27/09/2020
// -------------------------------------

#include <stdio.h>

int main() {
  int n, s;
  
  scanf("%d", &n);
  int count = 0;
  for (int i=0; i<n; i++) {
    scanf("%d", &s);
    if (s == 42) count++;
  }

  printf("%d\n", count);
  
  return 0;
}
