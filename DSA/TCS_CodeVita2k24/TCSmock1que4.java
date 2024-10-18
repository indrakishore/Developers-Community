package TCS_CodeVita2k24;/*
ConflictFreeTeamMarks: 100
Problem Description

You are a project manager in a large IT company. You need to select a team of employees to work on a project. You have a list of employees who are eligible for the selection. Employees are indexed from 1 to N.

However, there is a certain rule that must be followed in order to select the team. There are some employees who have some personal conflicts and they can't be in a team together. Also, each employee has a skill value assigned to them, representing their level of expertise. As a project manager, your task is to select a team of employees such that the total expertise of the team should be maximum, keeping the employees incompatibility in mind. Two employees are said to be incompatible if they have any conflicts among them.

Given the employees, their level of expertise value and employee pairs with conflicts, find the maximum possible expertise of the team.

Note: The selected team can contain one employee also.

Constraints

1 <= n <= 1000

0 <= c <= 100

1 <= expertise[i] <=10^4

Input

First line consists of two integers n,c separated by space, representing the number of employees and number of pairs having conflicts.

Next c lines, each consists of two integers separated by space. These represents the id of the employees having conflicts between them.

Last line consists of n integers separated by space, where ith integer represents the expertise level of ith employee.

Output

Print a single integer denoting the maximum possible expertise of the team.

Time Limit (secs)

1

Examples

Example 1

Input

8 6

1 2

2 5

3 6

6 8

1 4

7 8

7 5 4 3 1 6 2 9

Output

21

Explanation

You can form a team with employees [3, 1, 5, 8] who don't have any conflicts among themselves and the total expertise of the team is the sum of skill values of all employees i.e., 4+7+1+9 = 21. No other combination of employees will give an expertise which is greater than 21.

Example 2

Input

10 4

1 5

3 9

2 5

7 10

2 6 3 8 12 9 7 14 1 10

Output

56

Explanation

You can form a team with employees [5, 10, 3, 4, 6, 8] who don't have any conflicts among themselves and the total expertise of the team is the sum of skill values of all employees i.e., 12+10+3+8+9+14 = 56. No other combination of employees will give an expertise which is greater than 56.
*/


public class TCSmock1que4 {
}
