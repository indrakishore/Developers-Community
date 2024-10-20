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
