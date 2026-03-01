#include <iostream>
using namespace std;

int factorial(int num){
    if(num == 0){
        return 1;
    }
        return num * factorial(num - 1); 
}

int fibonacci(int num){
    if(num <= 1){
        return num;
    } 
    return fibonacci(num - 1) + fibonacci(num - 2); 
}
//      disk num      A.          B.         C
void hanoi(int n, char source, char aux, char dest) {
    if (n == 1) {
    std::cout << "Move disk 1 from " << source << " to " << dest << std::endl;
        return;
    }
   //              A.     C.    B
    hanoi(n - 1, source, dest, aux);
    std::cout << "Move disk " << n << " from " << source << " to " <<
    dest << std::endl;
   //             B     A      C       
    hanoi(n - 1, aux, source, dest);
}

void reverseArray(int arr[], int start, int end) {
    if(start >= end){
        return;
    } 
    swap(arr[start], arr[end]);
    reverseArray(arr, start + 1, end - 1);
}


int main() {
   int factorialResult = factorial(4);
    cout << "factorialResult: ";
    cout << factorialResult;

    cout << "\n";
    cout << "\n";

    int fibonacciResult = fibonacci(6);
    cout << "fibonacciResult: ";
    cout << fibonacciResult;

    cout << "\n";

     cout << "\n";

    int n = 3;
    hanoi(n, 'A', 'B', 'C');

    cout << "\n";

    cout << "Array addition, adding '7' to second index: ";
    int arr1[6] = {1,2,3,4};
    int length = sizeof(arr1) / sizeof(arr1[0]);
    int targetIndex = 1;
    int value = 7;

    for(int i = length - 1; i > targetIndex; i--){
        // 4            3 -> {1,2,?,3,4}
        arr1[i] = arr1[i - 1];
    }

    arr1[targetIndex] = value;

    for(int i = 0; i < length - 1; i++){
        cout << arr1[i] << " ";
    }

    cout<< "\n";

    int arr[] = {1, 2, 3, 4, 5};
    int n1 = sizeof(arr) / sizeof(arr[0]);
    reverseArray(arr, 0, n1 - 1);
    for (int i = 0; i < n1; i++) {
        cout << arr[i] << " ";
    }
    

    // Deletion
    // int array_size = 4;
    // int arr[array_size] = {1,2,3,4,5};
    // int position = 2;
    // for(int i = position; i < array_size; i++){
    //     arr[i] = arr[i + 1];
    // }
    // arr[array_size];


    // // Left rotate by one
    // int array_size = 5;
    // int arr[array_size] = {1,2,3,4,5};
    // int temp = arr[0];
    // for(int i = 0; i < array_size-1;i++){
    //     arr[i] = arr[i + 1];
    // }
    // arr[array_size-1] = temp;
    
    //  std::cout << "Rotation array elements: ";
    //  for (int i = 0; i < array_size; i++) {
    //     std::cout << arr[i] << " "; // Print each element
    // }
    
    // Addition wit vector
    // std::vector<int> vector = {1,2,3,4};
    // int numberToAdd = 5;
    // vector.push_back(numberToAdd);
    
    // for (int num : vector) {
    //     std::cout << num << " "; // Output: 10 20 30 40
    // }
    // std::cout << std::endl;
    
    // Addition & deletion & rotation with vector
    // std::vector<int> vector = {1,2,3,4};
    // int numberToAdd = 5;
    // vector.push_back(numberToAdd);
    // vector.erase(vector.begin() + 1);
    // std::rotate(std::begin(vector), std::next(std::begin(vector)), std::end(vector));
    
    // for (int num : vector) {
    //     std::cout << num << " "; // Output: 10 20 30 40
    // }
    // std::cout << std::endl;

    // return 0; 
// }


    return 0;
}