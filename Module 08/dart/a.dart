void main() {
  int n = 10; 
  printFibonacci(n);
}

void printFibonacci(int n) {
  int first = 0, second = 1;
  print(first); 
  print(second); 

  for (int i = 2; i < n; i++) {
    int next = first + second;
    print(next); 
    first = second;
    second = next;
  }
}
