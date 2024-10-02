/*


Start with a homepage: When you open the browser, you start on a homepage.

Visiting a new page: When you visit a new website, it should be added to your history, and if you had moved back before, any forward history (pages that came after the current one) will be deleted.

Going back: You can go back to previously visited websites. If you try to go back more steps than you've visited, you go back as far as possible.

Going forward: If you've gone back in history, you can move forward again to revisit those pages. If you try to move forward more steps than available, you go forward as far as possible.
now we have to implement 
Starting at the homepage,
Visiting new URLs,
Moving back in history by a certain number of steps,
Moving forward by a certain number of steps.
for Example:
Let the input eb:
["BrowserHistory","visit","visit","visit","back","back","forward","visit","forward","back","back"]
[["leetcode.com"],["google.com"],["facebook.com"],["youtube.com"],[1],[1],[1],["linkedin.com"],[2],[2],[7]]

It means

Start at "leetcode.com" (homepage)
Visit "google.com"
Visit "facebook.com"
Visit "youtube.com"
Go back 1 step to "facebook.com"
Go back 1 more step to "google.com"
Move forward 1 step to "facebook.com"
Visit "linkedin.com" (this clears the forward history)
Try to move forward 2 steps (but you can't since you just visited a new page)
Go back 2 steps to "google.com"
Go back 7 steps (as far as you can) to "leetcode.com"


Explanation:

ArrayList to store visited URLs --- history
currentIndex --- Keeps track of the current index in the history list.

Constructor (BrowserHistory(String homepage)):   Initializes the history list with the homepage and sets currentIndex to 0.

visit(String url):  Adds the new url to the history list & Clears all forward history by removing elements after currentIndex.


back(int steps):  Moves 'steps' steps back in history from the current index (currentIndex). Updates currentIndex to the new position. Handles the case where moving back more steps than available in history by clamping to the start of the list.


forward(int steps): Moves 'steps' steps forward in history from the current index (currentIndex). Updates currentIndex to the new position. Handles the case where moving forward more steps than available in history by clamping to the end of the list (history.size() - 1).



*/
import java.util.ArrayList;
import java.util.List;

class BrowserHistory {
    private List<String> history;  // this will store url of the website already visited or currently poresent at
    private int currentIndex; 

    public BrowserHistory(String homepage) {  // this will create object of class browserhistory, in which input parameter will be homepage by default and at index 0 
        history = new ArrayList<>();
        history.add(homepage);
        currentIndex = 0;
    }

    public void visit(String url) {
      // when you visit new url, clear forward history
        while (history.size() > currentIndex + 1) {
            history.remove(history.size() - 1);
        }
        history.add(url);
        currentIndex++;
    }

    public String back(int steps) {
        int newIndex = Math.max(0, currentIndex - steps);
        currentIndex = newIndex;
        return history.get(currentIndex);
    }

    public String forward(int steps) {
        int newIndex = Math.min(history.size() - 1, currentIndex + steps);
        currentIndex = newIndex;
        return history.get(currentIndex);
    }

    public static void main(String[] args) {
        BrowserHistory browserHistory = new BrowserHistory("leetcode.com"); // homepage leetcode.com
        browserHistory.visit("google.com"); // currentindex 1 - google.com
        browserHistory.visit("facebook.com"); //currentindex 2 -- facebook.com
        browserHistory.visit("youtube.com"); //currentindex 3 -- youtube.com

        System.out.println(browserHistory.back(1)); //currentindex 2 -- facebook.com
        System.out.println(browserHistory.back(1));  //currentindex 1 -- google.com
        System.out.println(browserHistory.forward(1)); //currentindex 2 -- facebook.com

        browserHistory.visit("linkedin.com"); //new page -- currentindex 2 -- linked.com

        System.out.println(browserHistory.forward(2)); // since new page is created there is no forward page therfore output will be linked.com only
        System.out.println(browserHistory.back(2)); //this will take 2 pages back i.e. at index 0 -- leetcode.com
        System.out.println(browserHistory.back(7));  //since there are no pages back as this is home page --this will print leetcode.com only
    }
}
