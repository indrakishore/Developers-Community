
/*
Problem statement: Find middle element of the given Linked Linked List (Singly Linked List)



Approach: we will create two pointers namely fastptr and slowptr, where fastptr will move two steps forward and slowptr will move one step forward bot at same time,
once the fastptr.next == null or fastptr == null the loop will exit and return the slowptr

for example:

initial condition both fstptr and slowptr will be pointing to head

                  head, fstptr, slowptr
                   |
                   2 --> 3 --> 7 --> null  


iteration 1 
here after first iteration, slowptr will move one step forward and fstptr will move 2 steps forward,
and as we can see fastptr.next == null so loop will exit and return slowptr, which is middle of our linked list i.e. 3

                  head slowptr fastptr
                   |     |     |
                   2 --> 3 --> 7 --> null  



you can also try with even number of elements

*/

public class FindMiddleElementInLinkedListByAnurag0git{

  public static int findmid() {
  	ListNode slowptr = head;
  	ListNode fastptr = head;
  	while(fastptr != null && fastptr.next!=null) {
  		slowptr = slowptr.next;
  		fastptr = fastptr.next.next;
  	}return slowptr.data;
  	
}
}
