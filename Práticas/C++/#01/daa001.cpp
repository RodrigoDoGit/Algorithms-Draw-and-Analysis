#include <iostream>

using namespace std;

int main(){
  int n, s;
  int contador = 0;

  cin >> n;

  for(int i=0; i<n; i++){
    cin >> s;

    if(s == 42)
      contador++;
    
  }

  cout << contador << endl;

  return 0;
}
