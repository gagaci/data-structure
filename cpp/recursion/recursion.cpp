#include <iostream>
using namespace std;

// Returns n! (n factorial) using recursion: n * (n - 1)!
int factorial(int num){
    if(num == 0){
        return 1;
    }
    return num * factorial(num - 1);
}

// Returns the n-th Fibonacci number using recursion
int fibonacci(int num){
    if(num <= 1){
        return num;
    }
    return fibonacci(num - 1) + fibonacci(num - 2);
}

// Solves Tower of Hanoi: move n disks from source to dest using aux as helper
void hanoi(int n, char source, char aux, char dest){
    if(n == 1){
        cout << "Move disk 1 from " << source << " to " << dest << endl;
        return;
    }
    hanoi(n - 1, source, dest, aux);
    cout << "Move disk " << n << " from " << source << " to " << dest << endl;
    hanoi(n - 1, aux, source, dest);
}

// Reverses arr in place by recursively swapping the outer pair of elements
void reverseArray(int arr[], int start, int end){
    if(start >= end){
        return;
    }
    swap(arr[start], arr[end]);
    reverseArray(arr, start + 1, end - 1);
}

int main(){
    // Factorial
    int factorialResult = factorial(4);
    cout << "Factorial of 4: " << factorialResult << "\n\n";

    // Fibonacci
    int fibonacciResult = fibonacci(6);
    cout << "Fibonacci of 6: " << fibonacciResult << "\n\n";

    // Tower of Hanoi
    cout << "Tower of Hanoi moves for 3 disks:\n";
    int n = 3;
    hanoi(n, 'A', 'B', 'C');
    cout << "\n";

    // Array insertion by shifting: insert value 7 at index 1
    int arr1[6] = {1, 2, 3, 4};
    int count = 4;            // number of meaningful elements currently stored
    int targetIndex = 1;
    int value = 7;

    // Shift elements to the right to open a slot at targetIndex
    for(int i = count; i > targetIndex; i--){
        arr1[i] = arr1[i - 1];
    }
    arr1[targetIndex] = value;
    count++;                  // one more meaningful element now

    cout << "Array insertion, adding '7' at index 1: ";
    for(int i = 0; i < count; i++){
        cout << arr1[i] << " ";
    }
    cout << "\n";

    // Recursive array reversal
    int arr[] = {1, 2, 3, 4, 5};
    int n1 = sizeof(arr) / sizeof(arr[0]);
    reverseArray(arr, 0, n1 - 1);
    cout << "Reversed array: ";
    for(int i = 0; i < n1; i++){
        cout << arr[i] << " ";
    }
    cout << "\n";

    return 0;
}
