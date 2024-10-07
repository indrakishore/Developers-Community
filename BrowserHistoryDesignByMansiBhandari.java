/*Explanation of Code Flow:
Constructor: Initializes with a homepage.
Visit Method: Adds a new URL and removes forward history if necessary.
Back Method: Moves back by the requested steps without going past the beginning.
Forward Method: Moves forward by the requested steps without exceeding the last visited page.
Main Method: Tests the browser history functionality as per the example you provided. */
import java.util.ArrayList;
import java.util.List;

class BrowserHistoryDesign {
    private List<String> history;  // List to store URLs of websites visited
    private int currentIndex;      // Current index in history

    // Constructor to initialize the browser with a homepage
    public BrowserHistoryDesgin(String homepage) {
        history = new ArrayList<>();
        history.add(homepage);  // Add homepage to history
        currentIndex = 0;       // Set the current page to the homepage
    }

    // Method to visit a new URL
    public void visit(String url) {
        // Remove forward history if any (clear anything beyond currentIndex)
        while (history.size() > currentIndex + 1) {
            history.remove(history.size() - 1);
        }
        history.add(url);       // Add the new URL to history
        currentIndex++;         // Move to the new URL in history
    }

    // Method to go back in history by 'steps' number of steps
    public String back(int steps) {
        // Ensure we don't move past the beginning of the history
        currentIndex = Math.max(0, currentIndex - steps);
        return history.get(currentIndex);
    }

    // Method to go forward in history by 'steps' number of steps
    public String forward(int steps) {
        // Ensure we don't move past the last visited page in history
        currentIndex = Math.min(history.size() - 1, currentIndex + steps);
        return history.get(currentIndex);
    }

    // Main method to test the functionality
    public static void main(String[] args) {
        BrowserHistory browserHistory = new BrowserHistory("leetcode.com"); // Start at homepage "leetcode.com"
        
        // Visit new websites
        browserHistory.visit("google.com"); // Visit google.com
        browserHistory.visit("facebook.com"); // Visit facebook.com
        browserHistory.visit("youtube.com"); // Visit youtube.com

        // Move back and forward in history
        System.out.println(browserHistory.back(1)); // Go back 1 step to facebook.com
        System.out.println(browserHistory.back(1)); // Go back 1 more step to google.com
        System.out.println(browserHistory.forward(1)); // Move forward 1 step to facebook.com

        // Visit a new website, which clears forward history
        browserHistory.visit("linkedin.com"); // Visit linkedin.com (clears forward history)

        // Attempt to move forward, but it won't work as forward history is cleared
        System.out.println(browserHistory.forward(2)); // No forward pages, stay on linkedin.com
        System.out.println(browserHistory.back(2)); // Go back 2 steps to google.com
        System.out.println(browserHistory.back(7)); // Go back as far as possible to leetcode.com
    }
}

