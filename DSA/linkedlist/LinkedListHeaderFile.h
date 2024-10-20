// Filename: myheader.h

#ifndef MYHEADER_H  // Include guard
#define MYHEADER_H

#include <iostream>
using namespace std;
#include<bits/stdc++.h>
class Node
{
public:
    int data;
    Node *next;

    Node()
    {
        this->data = 0;
        this->next = NULL;
    }
    Node(int data)
    {
        this->data = data;
        this->next = NULL;
    }
};
// DECLARATION OF FUNCTIONS :
// print Linked List using head node
void print(Node *head);
// find length of Linked List using head node 
int findLength(Node *head);

// reverse using for Loop:
void reverseLL(Node *&head);
// reverse using Recursion :
void reverseLLUsingREC(Node *&head, Node *prev, Node *curr);

// insert a node at head :
void insertAtHead(Node *&head, Node *&tail, int data);
// insert a node at tail : 
void insertAtTail(Node *&head, Node *&tail, int data);
#endif

// All Functions 

void print(Node *head)
{

    if (head == NULL)
    {
        return;
    }

    Node *temp = head;

    while (temp != NULL)
    {
        cout << temp->data << "->";
        temp = temp->next;
    }
    cout << endl;
}
int findLength(Node *head)
{
    {
        if (head == NULL)
        {
            return 0;
        }
        int count = 0;
        Node *temp = head;
        while (temp != NULL)
        {
            count++;
            temp = temp->next;
        }

        return count;
    }
}
void reverseLL(Node *&head)
{
    Node *prev = NULL;
    Node *curr = head;
    while (curr != NULL)
    {
        Node *nextNode = curr->next;
        curr->next = prev;
        prev = curr;
        curr = nextNode;
    }
    head = prev;
}
void reverseLLUsingREC(Node *&head, Node *prev, Node *curr)
{
    if (curr == NULL)
    {
        head = prev;
        return;
    }
    Node *nextNode = curr->next;
    curr->next = prev;
    reverseLLUsingREC(head, curr, nextNode);
}
void insertAtHead(Node *&head, Node *&tail, int data) // why pass by reference
{

    if (head == NULL)
    {
        Node *newNode = new Node(data);

        head = newNode;
        tail = newNode;
    }
    else
    {
        Node *newNode = new Node(data);

        newNode->next = head;

        head = newNode;
    }
}
void insertAtTail(Node *&head, Node *&tail, int data)
{
    if (head == NULL)
    {
        Node *newNode = new Node(data);

        head = newNode;
        tail = newNode;
    }
    else
    {
        Node *newNode = new Node(data);

        tail->next = newNode;
        tail = newNode;
    }
}