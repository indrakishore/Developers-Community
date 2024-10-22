/*
   A rat is placed at the starting position of a N x N maze (a 2D grid).
    The maze contains blocked and open cells. The rat must start from the top-left corner 
    of the maze (cell 0, 0) and find a path to the bottom-right corner (cell N-1, N-1).

The maze is represented as a 2D grid where:

1 represents an open cell that the rat can move into.
0 represents a blocked cell that the rat cannot move into.
The rat can move in four directions:

'U' (Up)
'D' (Down)
'L' (Left)
'R' (Right)
The task is to find and print all possible paths from the start (top-left) to the 
destination (bottom-right), following the given movement constraints.

Constraints:
The rat can only move to open cells (1).
The rat cannot visit the same cell more than once in a path.
The rat cannot move out of the maze's boundaries.
If no path is found, return -1.
Input Format:
The first line contains a single integer N (the size of the maze).
The next N lines each contain N integers, either 1 (open) or 0 (blocked), 
representing the maze grid.
Output Format:
Print all possible paths as strings, where each string contains a sequence of 
moves ('U', 'D', 'L', 'R').
Each string should represent a valid path from the start to the destination.
If no path exists, output -1.
solution approach: 

We can solve this problem using backtracking. The idea is to try all possible paths
from the starting cell (0, 0) to the destination cell (N-1, N-1). If we reach the 
destination, we store the path. Otherwise, we backtrack and try other possible 
directions.
*/ 












#include <iostream>
#include <vector>
#include <string>
using namespace std;

// Function to check if the cell (x, y) is a valid cell
bool isSafe(int x, int y, vector<vector<int>>& maze, vector<vector<bool>>& visited, int N) {
    return (x >= 0 && x < N && y >= 0 && y < N && maze[x][y] == 1 && !visited[x][y]);
}

// Backtracking function to find all paths
void findPaths(int x, int y, vector<vector<int>>& maze, vector<vector<bool>>& visited, string path, vector<string>& result, int N) {
    // If destination is reached, store the path
    if (x == N - 1 && y == N - 1) {
        result.push_back(path);
        return;
    }

    // Mark the current cell as visited
    visited[x][y] = true;

    // Explore the four possible directions: Down, Left, Right, Up
    // Move Down
    if (isSafe(x + 1, y, maze, visited, N)) {
        findPaths(x + 1, y, maze, visited, path + 'D', result, N);
    }
    
    // Move Left
    if (isSafe(x, y - 1, maze, visited, N)) {
        findPaths(x, y - 1, maze, visited, path + 'L', result, N);
    }

    // Move Right
    if (isSafe(x, y + 1, maze, visited, N)) {
        findPaths(x, y + 1, maze, visited, path + 'R', result, N);
    }

    // Move Up
    if (isSafe(x - 1, y, maze, visited, N)) {
        findPaths(x - 1, y, maze, visited, path + 'U', result, N);
    }

    // Unmark the current cell (backtrack)
    visited[x][y] = false;
}

// Function to solve the maze problem
vector<string> solveMaze(vector<vector<int>>& maze, int N) {
    vector<string> result;
    
    // If the start or end is blocked, return no solution
    if (maze[0][0] == 0 || maze[N-1][N-1] == 0) {
        return result;
    }

    // Create a visited matrix to keep track of visited cells
    vector<vector<bool>> visited(N, vector<bool>(N, false));

    // Start the backtracking from (0, 0) with an empty path
    findPaths(0, 0, maze, visited, "", result, N);

    return result;
}

int main() {
    int N;
    cout << "Enter the size of the maze (N x N): ";
    cin >> N;

    vector<vector<int>> maze(N, vector<int>(N));
    cout << "Enter the maze matrix (1 for open, 0 for blocked): " << endl;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            cin >> maze[i][j];
        }
    }

    // Find and print all paths
    vector<string> result = solveMaze(maze, N);
    if (result.empty()) {
        cout << "-1" << endl; // No path found
    } else {
        for (const string& path : result) {
            cout << path << endl;
        }
    }

    return 0;
}
