import java.util.Stack;

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
