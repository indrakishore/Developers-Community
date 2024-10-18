package TCS_CodeVita2k24;

import static java.lang.Integer.parseInt;

/*Problem Description

Prabhu excels at typing letters but struggles with symbols and numbers. To simplify, he decided to represent mathematical expressions using words. For numbers, he mentions each digit individually with the character 'c' to signify the entire word representing the number. Prabhu exclusively uses lowercase letters as he's not proficient with shift keys or caps lock.

For instance

111 is written as oneconecone

120 is written as onectwoczero

For a single operation: Operation Operand1 Operand2

Example: "add one two" represents 1+2.

For two functions: Operation1 Operation2 Operand1 Operand2 Operand3

Example: "add mul twoctwo threecone two" equals (22*31)+2.

For another variation: Operation1 Operand1 Operation2 Operand2 Operand3

Example: "add oneconecone div onectwoczeroczero twoctwo" equals 111+(1200/22).

Prabhu uses the following operations:

    add for addition (e.g., 2+2=4).
    sub for subtraction (e.g., 2-2=0).
    mul for multiplication (e.g., 2*2=4).
    rem for remainder (e.g., 2%2=0).
    pow for power (e.g., 2^2=4).

To convert and evaluate Prabhu's mathematical expression, output the result in numbers. If any word cannot be resolved as an operation or operand during evaluation, print "expression evaluation stopped invalid words present" If all words are recognized but the expression cannot be solved, print "expression is not complete or invalid"

Note:

    The input does not contain float or negative numbers.
    Verify the correctness of words first, followed by correctness of expression.

Constraints

0 < Characters in the first line including space < 100

0 < Operands in the expression < 20

Input

Single line denoting the expression.

Output

Single integer repersenting the result of the expression evalutated in numbers not in words.

Time Limit (secs)

1

Examples

Input

add one sub twochundered one

Output

expression evaluation stopped invalid words present

Explanation

In word twochundred, hundred is not a valid word only zero to nine can be used

Example 2

Input

five mul six six fourcninecnine zero

Ouput

expression is not complete or invalid

Explanation

Everywords in the expression is valid but the expression cannot be evaluated only mul operation is found there. After executing, there are still other words are left so the expression is not complete or invalid

Example 3

Input

mul add sub six five oneczero two

Ouput

22

Explanation

The above prabhu expression represents ((6-5)+10)*2

*/
public class TCSmock1que3 {

    }
