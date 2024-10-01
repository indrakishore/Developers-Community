/*
    Problem: Design Browser History using C++

    Description: You have a browser of one tab where you start on the homepage and you can visit another url, get back in the history number of steps or move forward in the history number of steps.

    Implementation:
    
    * BrowserHistory(string homepage) Initializes the object with the homepage of the browser.
    * void visit(string url) Visits url from the current page. It clears up all the forward history.
    * string back(int steps) Move steps back in history. If you can only return x steps in the history and steps > x, you will return only x steps. Return the current url after moving back in history at most steps.
    * string forward(int steps) Move steps forward in history. If you can only forward x steps in the history and steps > x, you will forward only x steps. Return the current url after forwarding in history at most steps.

    Example:

    Input:
    ["BrowserHistory","visit","visit","visit","back","back","forward","visit","forward","back","back"]
    [["leetcode.com"],["google.com"],["facebook.com"],["youtube.com"],[1],[1],[1],["linkedin.com"],[2],[2],[7]]

    Output:
    [null,null,null,null,"facebook.com","google.com","facebook.com",null,"linkedin.com","google.com","leetcode.com"]

*/

class Node{
    public:
        string url;
        Node* next;
        Node* prev;

        // Constructor: Initializes a node with the given URL, setting the next and previous pointers to NULL.
        Node(string url){
            this->url = url;
            this->next = NULL;
            this->prev = NULL;
        }
};

class BrowserHistory {
public:
    Node* homepage = NULL;
    Node* currentPage = NULL;

    // Constructor: Initializes browser history with the homepage and sets it as the current page.
    BrowserHistory(string homepage) {
        this->homepage = new Node(homepage);
        currentPage = this->homepage;
    }
    
    // visit: Adds a new page (URL) to the browser history, updates the current page to this new page, and clears forward history.
    void visit(string url) {
        Node* newPage = new Node(url);

        currentPage->next = newPage;
        newPage->prev = currentPage;

        currentPage = currentPage->next;
    }
    
    // back: Moves back a specified number of steps in the browser history and returns the URL of the current page.
    string back(int steps) {
        while(steps>0 && currentPage->prev!=NULL){
            currentPage = currentPage->prev;
            steps--;
        }
        return currentPage->url;
    }
    
    // forward: Moves forward a specified number of steps in the browser history and returns the URL of the current page.
    string forward(int steps) {
        while(steps>0 && currentPage->next!=NULL){
            currentPage = currentPage->next;
            steps--;
        }
        return currentPage->url;
    }
};
