#include <stack>
#include <string>
#include <vector>
using namespace std;

class Solution {
public:
    bool parseBoolExpr(string expression) {
        stack<char> stk;

        for (char c : expression) {
            if (c == ',' || c == '(') continue;
            
            if (c == 't' || c == 'f' || c == '!' || c == '&' || c == '|') {
                stk.push(c);
            } else if (c == ')') {
                // Process the subexpression
                vector<char> subExpr;
                while (!stk.empty() && stk.top() != '!' && stk.top() != '&' && stk.top() != '|') {
                    subExpr.push_back(stk.top());
                    stk.pop();
                }

                char operatorChar = stk.top();
                stk.pop();
                char result = evaluateSubExpression(operatorChar, subExpr);
                stk.push(result);
            }
        }

        return stk.top() == 't';
    }

private:
    // Helper function to evaluate sub-expressions based on the operator
    char evaluateSubExpression(char op, vector<char>& subExpr) {
        if (op == '!') {
            // Negate the only subexpression
            return subExpr[0] == 't' ? 'f' : 't';
        } else if (op == '&') {
            // AND all the subexpressions
            for (char ch : subExpr) {
                if (ch == 'f') return 'f';
            }
            return 't';
        } else if (op == '|') {
            // OR all the subexpressions
            for (char ch : subExpr) {
                if (ch == 't') return 't';
            }
            return 'f';
        }
        return 'f'; // This line should never be reached
    }
};
