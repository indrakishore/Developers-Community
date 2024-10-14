#include <iostream>
#include <stack>
#include <unordered_map>
#include <vector>
using namespace std;

class BrowserHistory {
private:
    vector<string> history;
    int currentIndex;
    unordered_map<string, string> bookmarks;

public:
    // Initializes the object with the homepage of the browser.
    BrowserHistory(string homepage) {
        history.push_back(homepage);
        currentIndex = 0;
    }

    // Visits a new URL from the current page and clears the forward history.
    void visit(string url) {
        if (currentIndex + 1 < history.size()) {
            history.erase(history.begin() + currentIndex + 1, history.end());
        }
        history.push_back(url);
        currentIndex++;
    }

    // Moves steps back in history and returns the current URL.
    string back(int steps) {
        currentIndex = max(0, currentIndex - steps);
        return history[currentIndex];
    }

    // Moves steps forward in history and returns the current URL.
    string forward(int steps) {
        currentIndex = min((int)history.size() - 1, currentIndex + steps);
        return history[currentIndex];
    }

    // Adds a bookmark with the specified title and URL.
    void addBookmark(string title, string url) {
        bookmarks[title] = url;
        cout << "Bookmark added: [" << title << "] -> " << url << endl;
    }

    // Displays the list of bookmarks.
    void viewBookmarks() {
        if (bookmarks.empty()) {
            cout << "No bookmarks available." << endl;
            return;
        }

        cout << "Bookmarks List:" << endl;
        for (const auto &pair : bookmarks) {
            cout << "  [" << pair.first << "] -> " << pair.second << endl;
        }
    }
};

int main() {
    BrowserHistory browser("homepage.com");
    string command, url, title;

    while (true) {
        cout << "Enter command (visit, bookmark, view, back, forward, exit): ";
        cin >> command;

        if (command == "visit") {
            cout << "Enter URL: ";
            cin >> url;
            browser.visit(url);
        } else if (command == "bookmark") {
            cout << "Enter bookmark title: ";
            cin >> title;
            cout << "Enter URL for bookmark: ";
            cin >> url;
            browser.addBookmark(title, url);
        } else if (command == "view") {
            browser.viewBookmarks();
        } else if (command == "back") {
            int steps;
            cout << "Enter steps to go back: ";
            cin >> steps;
            cout << "Current URL: " << browser.back(steps) << endl;
        } else if (command == "forward") {
            int steps;
            cout << "Enter steps to go forward: ";
            cin >> steps;
            cout << "Current URL: " << browser.forward(steps) << endl;
        } else if (command == "exit") {
            break;
        } else {
            cout << "Invalid command. Try again." << endl;
        }
    }

    return 0;
}
