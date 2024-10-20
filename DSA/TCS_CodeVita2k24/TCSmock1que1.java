package TCS_CodeVita2k24;/*
Problem Description

Ankitha enjoys finding new games. One day, she found a grid with dimensions M*N and decided to make up a special game to play on it. When Ankitha came up with the idea for the new game, her friend Akhil joined her. She then decided to share and explain the game to him.

Akhil is given a grid with dimensions M*N, where each cell contains either 0 or 1. Additionally, he is provided with the coordinates of source and destination cells.You can only move to places whose value is 0. Furthermore, he is given the move rule (x, y) which helps in finding the location for the next move. From the given cell, you can move in four directions (forward, back,right ,left), unless they are out of grid. The rules for finding the next move from a current cell are given below.

    For moving forward, add the move rule to the current cell.
    For moving right, from current position add the move rule, rotate the path 90 degree clockwise,
    For moving left, from current position add the move rule, rotate the path 90 degree anticlockwise direction,
    For moving backward, from current position add the move rule, rotate the path 180 degree in clock or anti clockwise.

The rules can be understood better from the following example. Let the current cell be (1,1) and the move rule as (1,2)

com.tcs.cv.automata.ei.middleware.DocxToHtmlConverter@65ae095c:image1.png

on forward the next cell would be (2,3) ,
on right the next cell would be (3,0),
left (-1,2) and back (0,-1) are out of grid.

Obeying the given move rule, find out minimum how many cells he need to travel in order to reach the destination.

Constraints

4 <= M, N <= 50

Input

First line consist of two space separated integers M and N denoting the number of rows and columns in the grid.

Next M lines consists of N space separated integers representing the grid.

Next line consists of two space separeted integers denoting source cell.

Next line consists of two space separated integers denoting destination cell.

Last line consists of two space separated integer representing move rule.

Output

Print a single integer denoting the minimum moves required to reach the destination.

Time Limit (secs)

1

Examples

Example 1

Input

6 6

0 1 0 0 0 0

0 0 0 0 0 1

0 1 0 0 0 0

1 1 0 0 0 1

0 0 0 0 0 0

1 1 0 0 1 0

1 0

5 3

1 2

Output

3

Explanation

Akhil needs to move from (1, 0) to (5, 3) and the given step for next move is (1, 2).

In order to minimise the number of moves, he follows the path (1,0) -> (2,2) -> (3,4) ->(5,3) where in total he made 3 moves. No other paths will give moves less than 3. Hence print 3 as the output.

Example 2

input

6 6

0 0 0 0 1 0

0 0 1 0 0 1

0 1 0 1 0 0

1 1 1 0 0 0

1 0 0 0 0 1

1 0 0 1 1 0

0 0

4 4

0 2

Output

4

Explanation

Akhil needs to move from (0, 0) to (4, 4) and the given step for next move is (0, 2).

In order to minimise the number of moves, he follows the path (0,0) -> (0,2) -> (2,2) -> (2,4) -> (4,4) where in total he made 4 moves. No other paths will give moves less than 4. Hence print 4 as th output.

*/

import java.util.Scanner;
public class TCSmock1que1 {

    static int minMoves = Integer.MAX_VALUE;
    public static void main(String[] args) {

//       Input code

            Scanner sc = new Scanner(System.in);
            int M = sc.nextInt();
            int N = sc.nextInt();
            int[][] board = new int[M][N];
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    board[i][j] = sc.nextInt();
                }
            }
            int srcRow = sc.nextInt();
            int srcCol = sc.nextInt();
            int destRow = sc.nextInt();
            int destCol = sc.nextInt();
            int movRow = sc.nextInt();
            int movCol = sc.nextInt();

/*
        for(int i = 0; i<M; i++){
            for(int j = 0; j<N; j++){
                System.out.print(arr[i][j]) ;
            }
            System.out.println(" ");
        }
*/



        boolean[][] visitedArr = new boolean[M][N];
        dfs(board, srcRow, srcCol, destRow, destCol, movRow, movCol, visitedArr, 0, M, N);

        System.out.println(minMoves == Integer.MAX_VALUE ? -1: minMoves);


    }
    public static void dfs(int[][] board, int x, int y, int destRow, int destCol, int movRow, int movCol, boolean[][] visitedArr, int currMoves, int M, int N) {
        {
            if(x < 0 || y < 0 || y >=N || x >=M || visitedArr[x][y] || board[x][y] == 1){
                return;
            }
            if(x == destRow && y == destCol){
                minMoves = Math.min(minMoves, currMoves);
                return;
            }

            visitedArr[x][y] = true;   // mark current cell as visited

            int[][] direction = {
                    {movCol, -movRow}, // move right
                    {movRow, movCol}, // move forward
                    {-movRow, movCol},  // move left
                    {-movRow, -movCol}  //move backward
            };


            for(int[] direc: direction){
                int nextRow = x + direc[0];
                int nextCol = y + direc[1];
                dfs(board, nextRow, nextCol, destRow, destCol, movRow, movCol, visitedArr, currMoves +1, M, N);
            }

            visitedArr[x][y] = false;   // unmark surrent cell as visited







        }



    }
}
