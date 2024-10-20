/*
            You are given an array of integers arr[] of size n where arr[i] represents the number 
            of pages in the i-th book. There are m students, and the task is to allocate all the 
            books to the students such that:

                    Each student gets at least one book.
                    The maximum number of pages assigned to a student is minimized.
            You need to find the minimum possible value of the maximum number of pages assigned to 
            any student.
 */

#include <iostream>
#include <vector>
#include <climits>
using namespace std;

// Helper function to check if a given maximum number of pages can be allocated to m students
bool isPossible(const vector<int>& books, int n, int m, int maxPages) {
    int studentCount = 1;
    int pagesSum = 0;
    
    for (int i = 0; i < n; i++) {
        if (pagesSum + books[i] > maxPages) {
            studentCount++;
            pagesSum = books[i]; // Assign this book to a new student
            if (studentCount > m) {
                return false;
            }
        } else {
            pagesSum += books[i];
        }
    }
    return true;
}

// Function to find the minimum possible maximum number of pages
int findPages(const vector<int>& books, int n, int m) {
    if (m > n) {
        return -1; // More students than books is not possible
    }

    int low = *max_element(books.begin(), books.end()); // Minimum possible value for maxPages
    int high = accumulate(books.begin(), books.end(), 0); // Maximum possible value for maxPages
    int result = INT_MAX;

    // Perform binary search
    while (low <= high) {
        int mid = low + (high - low) / 2;

        if (isPossible(books, n, m, mid)) {
            // If it's possible to allocate books with the current mid as the maxPages limit
            result = mid;
            high = mid - 1; // Try for a better (smaller) solution
        } else {
            low = mid + 1; // Try for a larger solution
        }
    }
    
    return result;
}

int main() {
    int n, m;
    cout << "Enter the number of books: ";
    cin >> n;
    cout << "Enter the number of students: ";
    cin >> m;

    vector<int> books(n);
    cout << "Enter the number of pages in each book: ";
    for (int i = 0; i < n; i++) {
        cin >> books[i];
    }

    int result = findPages(books, n, m);
    if (result != -1) {
        cout << "The minimum possible maximum number of pages is: " << result << endl;
    } else {
        cout << "Not possible to allocate books to students." << endl;
    }

    return 0;
}
