/*
Problem Statement:
You are given a string consisting of various parentheses types: {}, [], and (). Your task is to determine if the parentheses in the string are balanced. A string is considered 
balanced if every opening bracket has a corresponding closing bracket of the same type, and the brackets close in the correct order.

For example, the string {[()]} is balanced, while {[(])} is not balanced, and [{()}] is balanced as well.

You are required to write a program to check whether a given string containing parentheses is balanced or not.

Complete Approach:
1. The most efficient way to solve this problem is by using a stack data structure. A stack operates on a Last-In-First-Out (LIFO) principle, where the most recent item added is the 
first to be removed.

2. The algorithm begins by traversing the input string one character at a time. If an opening bracket ({, [, () is encountered, it is pushed onto the stack. When a closing bracket 
(}, ], )) is encountered, we first check if the stack is empty. If the stack is empty, it means there is no corresponding opening bracket for the closing bracket, and the function 
should return false. Otherwise, the top element of the stack is popped and compared with the current closing bracket. If the popped element does not match the corresponding opening 
bracket for the current closing bracket, the function returns false.

3. After processing the entire string, if the stack is empty, it indicates that all the brackets were matched correctly, and the function returns true. If the stack is not empty, 
there are unmatched opening brackets, and the function returns false.

4. The time complexity of the solution is O(n), where n is the length of the input string. This is because the string is traversed once, and each push and pop operation on the stack 
takes constant time, O(1). The space complexity is O(n), where n is the length of the input string, as the worst case may require storing all the opening brackets in the stack.

5. Edge cases include an empty string, which is considered balanced, a string with only opening or only closing brackets, which is not balanced, and a string with mismatched opening 
and closing brackets, such as ({[)]}, which is also not balanced.
*/

// import required classes and package, if any   
   
import java.util.*;   
   
// create class BalancedParenthesesExample1 for implementing Balanced Parentheses using stack   
public class BalancedParenthesesExample1 {   
      
    // create method balancedParenthesis() to check whether the input string is balanced or not   
    @SuppressWarnings({ "rawtypes", "unchecked" })   
    public static boolean balancedParenthesis(String inputStr) {   
          
        // create an empty stack   
        Stack stack = new Stack();   
          
        // convert inputStr to char array   
        char[] charArray = inputStr.toCharArray();   
          
        // iterate charArray   
        for (int i = 0; i < charArray.length; i++) {   
              
            // get char   
            char current = charArray[i];   
              
            //check whether current is '(', '[' or '{'   
            if (current == '{' || current == '[' || current == '(') {   
                // push current to stack   
                stack.push(current);   
                continue;   
            }   
            // if stack is empty, return false   
            if (stack.isEmpty()) {    
                return false;   
            }   
              
            // use switch statement to pop element from stack and if it is '(', '[' or '{', return false   
            char popChar;   
            switch (current) {   
                case ')':   
                popChar = (char) stack.pop();   
                if (popChar == '{' || popChar == '[')   
                    return false;   
                break;   
                case '}':   
                popChar = (char) stack.pop();   
                if (popChar == '(' || popChar == '[')   
                    return false;   
                break;   
                case ']':   
                popChar = (char) stack.pop();   
                if (popChar == '(' || popChar == '{')   
                    return false;   
                break;   
            }   
        }   
        return (stack.isEmpty());   
    }   
    // main() method start   
    public static void main(String[] args) {   
          
        String inputStr;   
          
        // create an instance of Scanner class   
        Scanner sc = new Scanner(System.in);   
          
        System.out.println("Enter input string to check:");   
        // take input sring from user   
        inputStr = sc.nextLine();   
          
        // call balancedParenthesis() method to check whether input string is balanced of not   
        if (balancedParenthesis(inputStr))   
            System.out.println("Input string "+inputStr+" is balanced.");   
        else   
            System.out.println("Input string "+inputStr+" is not balanced.");   
    }   
}  
