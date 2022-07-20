// Exemplo de codigo em C++
// [DAA 001] O sentido da vida
// -------------------------------------
// Pedro Ribeiro (DCC/FCUP) - 27/09/2020
// -------------------------------------

// Nota: em C++ tambem se poderia ter lido usando scanf e escrito usando printf
//       para isso bastaria ter #include <cstdio> no cabecalho do programa

#include <iostream>

using namespace std; // nao me importo que usem isto no contexto de DAA

int main() {
  int n, s;

  cin >> n;
  int count = 0;
  for (int i=0; i<n; i++) {
    cin >> s;
    if (s == 42) count++;
  }

  cout << count << endl;
  
  return 0;
}
