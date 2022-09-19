#include <iostream>
#include <cstdlib>
#include <cstring>

using namespace std;

int id_geracao(char s[]){
  int cases = 5290000;

  if(isalpha(s[0])){
    if(isalpha(s[7]))
      return cases * 3;

    else
      return 0;
  }

  else{
    if(isalpha(s[3]))
      return cases * 2;

    else
      return cases;
  }
}

int number(char s[]){
  int num = id_geracao(s);
  int base = 1;

  for(int i=7; i>=0; i--){
    if(isdigit(s[i])){
      num += (s[i] - '0') * base;
      base *= 10;
    }
  }

  for(int i=7; i>=0; i--){
    if(isalpha(s[i])){
      int value = s[i] - 'A';

      if(s[i] > 'K')
	value--;

      if(s[i] > 'W')
	value--;

      if(s[i] > 'Y')
	value--;

      num += value * base;
      base *= 23;
    }
  }

  return num;
}

int main(){
  int n;

  cin >> n;

  char str[20];

  fgets(str, 20, stdin);
  
  for(int i=0; i<n; i++){
    fgets(str, 20, stdin);
    
    char *str1;
    char *str2;

    str1 = strtok(str, " ");
    str2 = strtok(NULL, "\n");

    cout << abs(number(str1) - number(str2)) << endl;
  }

  return 0;
}
