package TCS_CodeVita2k24;/*XFromYMarks: 30
Problem Description

Malaika is very fond of strings so whenever she gets some free time, she will keep herself engaged in string based activities.

One day, she came across a question where she will be given two strings X & Y and asked to form X from Y. The rules for forming the string are given below.

    The string X should be formed with the concatenation of the sub strings of Y. You can also select the sub strings from Y in reversed order.
    The length of the sub strings selected from Y should be greater than or equal to one.
    Aim is to minimize the number of sub strings that are selected from Y and concatenated to form X.
    A term String Factor is defined which is calculated as (number of sub strings selected from Y) * S + (number of sub strings selected from reversed Y) * R, where S and R are given in the input.
    You also have to minimize the String Factor while maintaining the minimum number of sub strings.

Given two strings X and Y and two integers S and R, find the minimum String Factor of the string X following above rules.

Constraints

1 <= lengths of X,Y <= 10^4

0 <= S, R <= 10^3

X, Y consists of lower case alphabets only.

Input

First line consists of string X.

Second line consists of string Y.

Third line consists of two integers S and R separated by space.

Output

Form the string X from string Y following the above rules and print the String Factor of X. Print "Impossible" if X can't be formed from Y.

Time Limit (secs)

1

Examples

Example 1

Input

niveditha

lavekdahnita

3 5

Output

17

Explanation

For forming the string niveditha from lavekdahnita, select sub strings ni from Y, ve from Y, d from Y, it from Y, ha from reversed Y. No other selections can give less than five sub strings.

String Factor = (number of sub strings selected from Y) * S + (number of sub strings selected from reversed Y) * R = (4*3) + (1*5) = 17

Example 2

Input

abcdef

pafedexycbc

4 2

Output

6

Explanation

For forming the string abcdef from pafedexycbc, select the sub string 'a' from reversed Y, bc from reversed Y, def from reversed Y. No other selections can give less than three sub strings.

String Factor = (number of sub strings selected from Y) * S + (number of sub strings selected from reversed Y) * R = (0*4) + (3*2) = 6

*/



public class TCSmock1que2 {
}
