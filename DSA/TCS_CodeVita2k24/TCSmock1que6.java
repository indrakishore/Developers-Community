package TCS_CodeVita2k24;

/*
9X9
Problem Description

We have a classic number-placement puzzle for you! This puzzle is played on a 9x9 matrix, divided into nine 3x3 sub matrices.

In this matrix some cells are pre-filled, some cells are provided with hints, while the other cells are empty. You have to fill these empty cells. Rules for filling the puzzle are given below.

    Every row should have 1-9 numbers without repetition.
    Every column should have 1-9 numbers without repetition.
    Every 3*3 sub matrix should have 1-9 numbers without repetition. The sub matrices are highlighted with thick boarders in the given figures in example section.
    There are some cells which are provided with hints i.e., those cells should be filled with one of the numbers from the given list in the input.

Tina is participating in this puzzle competition, and due to time constraints, in the last minutes, she quickly filled in the puzzle but might have made some mistakes. But the organizers felt none of them might have solved correctly and decided to rank the participants based on the number of cells that require replacements with other numbers to make the grid correct. The fewer the count of such cells, the better their rank will be. Fortunately, if Tina filled the whole thing correctly, then she will win the puzzle. If the count of cells that need modifications is <= given K, then Tina will get a rank and has the chance of winning. Judge will compare the closest solution based on individual answer to minimize the number of cells need to be changed. Its impossible for her to win, if count of cells that need modifications is greater than given K, because she won't get into the ranking list.

Given puzzle filled by Tina, a list of numbers, and an integer 'K', determine whether Tina has a chance of winning the competition or not.

Note : You can only change the hinted and empty cell values but not pre-filled cells in order to make the grid correct.

Constraints

Grid size remains same i.e., 9x9.

Grid values will be basically from 1-9. But we use leading 0s to represent empty cells and trailing 0s to represent hinted cells.

1 <= K <= 10

1 <= len(list) <= 5

Input

First 9 lines consists of 9 space separated numbers denoting the matrix, filled by Tina where,

    If a number has a leading zero, it means the cell was filled by Tina.
    If a number has a trailing zero, it indicates that it's a hinted cell, and it should be filled with one of the numbers from the given input list.
    If no zero at all, its a pre-filled cell whose value can't be changed.

10th line consists of a list of numbers which are allowed to be placed into the hinted cells.

The 11th line of input contains an integer 'K,' which represents the maximum number of cells that are allowed to have incorrect values while still being eligible for a ranking in the competition.

Output

    Print "Won" if Tina placed everything correctly else,
    Print "Impossible" if it's impossible for Tina to win the competition based on the given criteria else,
    If she didn't win but has a chance of winning, print the indices of the cells that are wrongly placed, arranged from top to bottom and left to right, each on a single line (0 based indexing).

Time Limit (secs)

1

Examples

Example1

Input

06 1 09 7 4 02 03 5 08

4 50 7 08 03 01 6 09 2

8 2 04 6 09 05 01 7 4

20 03 06 04 1 09 5 08 07

5 09 01 2 07 08 04 06 3

07 08 4 03 5 06 20 01 9

9 6 02 01 08 3 07 4 5

3 04 05 09 06 07 8 20 1

01 7 08 50 2 4 01 3 6

5 7 2

3

Output

2 2
8 6

Explanation

Given grid is visualized below with the following color codes.

Green - Pre-filled cells

White - Filled by Tina

Orange - Hinted cells

com.tcs.cv.automata.ei.middleware.DocxToHtmlConverter@5eefa415:image1.png

The above grid which is filled by Tina is incorrect because of the following reasons.

        4 is present twice in the first 3*3 sub grid, 3rd column and also in 3rd row (1-based indexing, from top left)
        1 is present twice in the last 3*3 sub grid (9th), 7th column and also in 9th row (1-based indexing, from top left)

In order to make this grid correct in minimum replacements, we will place 3 in the position (2,2) and 9 in the position (8,6). Since the number of cells that are needed to be modified is less than K, she holds the chance of winning and hence we print the cells indices which require modifications, in left to right, top to bottom order.

Example 2

Input

5 3 04 60 7 08 09 01 01

6 07 02 1 9 5 03 04 08

01 9 8 03 04 02 05 6 07

8 05 09 70 6 01 04 02 3

4 02 60 8 05 3 07 09 1

7 01 03 09 2 04 08 05 6

09 6 10 05 01 07 2 8 04

02 08 07 4 1 9 06 03 5

07 04 05 02 8 06 10 7 9

6 7 1 2

2

Output

Impossible

Explanation

Given grid is visualized below with the following color codes.

Green - Pre-filled cells

White - Filled by Tina

Orange - Hinted cells

com.tcs.cv.automata.ei.middleware.DocxToHtmlConverter@5eefa415:image2.png

1 is present twice in the 1st row, 3rd 3*3 submatrix and 9th column. Again 1 is repeated in the 7th row, 8th 3*3 submatrix and 5th column. Also 7 is repeated in the 1st column,9th row as well as in the 7th 3*3 sub grid (1-based indexing). Thus it can't be corrected using 2 replacements. Hence print "Impossible".

*/
public class TCSmock1que6 {
}
