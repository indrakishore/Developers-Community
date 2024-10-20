import java.util.Stack;

/**
 * Problem Statement:
 * Design a simplified browser history system that allows a user to:
 * - Visit a URL and update the current page.
 * - Go back a specified number of steps in the browser history.
 * - Go forward a specified number of steps in the browser history.
 * 
 * The system maintain two stacks: one for the back history and one for the forward history,
 * mimicking how a typical browser works. When navigating back, the current page should be moved 
 * to the forward stack, and when navigating forward, the current page should be moved back to the 
 * back stack.
 *
 * Approach:
 * - Use two stacks: backStack and forwardStack.
 * - The backStack holds pages that the user has previously visited.
 * - The forwardStack holds pages the user has navigated back from.
 * - When visiting a new URL, push the current page to the backStack and clear the forwardStack 
 *   (since the forward history is reset on a new visit).
 * - The `back` method pops pages from the backStack and pushes them to the forwardStack until 
 *   either the number of steps is reached or there are no more pages to go back.
 * - The `forward` method pops pages from the forwardStack and pushes them to the backStack until 
 *   either the number of steps is reached or there are no more pages to go forward.
 */

class BrowserHistory {
    private Stack<String> backStack;
    private Stack<String> forwardStack;
    private String currentPage;

    public BrowserHistory(String homepage) {
        backStack = new Stack<>();
        forwardStack = new Stack<>();
        currentPage = homepage; 
    }

    public void visit(String url) {
        backStack.push(currentPage); 
        currentPage = url; 
        forwardStack.clear(); 
    }

    public String back(int steps) {
        while (steps > 0 && !backStack.isEmpty()) {
            forwardStack.push(currentPage);
            currentPage = backStack.pop(); 
            steps--;
        }
        return currentPage;
    }

    public String forward(int steps) {
        while (steps > 0 && !forwardStack.isEmpty()) {
            backStack.push(currentPage); 
            currentPage = forwardStack.pop(); 
            steps--;
        }
        return currentPage;
    }
}
