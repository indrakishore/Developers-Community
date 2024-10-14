#include <iostream>
using namespace std;

bool isPrime(int n) {
    // 0 and 1 are not prime numbers
    if (n <= 1) 
        return false;

    // Check for factors from 2 to sqrt(n)
    for (int i = 2; i * i <= n; i++) {
        if (n % i == 0)
            return false;  // Not a prime number if divisible by any number in the loop
    }

    return true;  // If no factors were found, it's prime
}

int main() {
    int num;
    cout << "Enter a number: ";
    cin >> num;

    if (isPrime(num))
        cout << num << " is a prime number." << endl;
    else
        cout << num << " is not a prime number." << endl;

    return 0;
}
