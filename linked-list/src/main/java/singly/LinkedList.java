package singly;

/**
 * Singly Linked List Implementation
 */
public class LinkedList {

  Node head;

  class Node {

    int data;
    Node next;

    Node(int data) {
      this.data = data;
      this.next = null;
    }
  }

  private void insertAtFirst(int value) {
    Node node = new Node(value);
    node.next = head;
    head = node;
  }

  private void insertAfter(Node prevNode, int value) {
    if (prevNode == null) {
      return;
    }

    Node node = new Node(value);
    node.next = prevNode.next;
    prevNode.next = node;
  }

  private void insertAtEnd(int value) {
    if (head == null) {
      head = new Node(value);
      return;
    }

    Node last = head;
    while (last.next != null) {
      last = last.next;
    }
    last.next = new Node(value);
  }

  private void printList() {
    Node temp = head;
    while (temp != null) {
      System.out.print(temp.data + "->");
      temp = temp.next;
    }
    System.out.print("null");
  }

  public static void main(String[] args) {
    LinkedList linkedList = new LinkedList();
    linkedList.insertAtFirst(1);
    linkedList.insertAtEnd(3);
    linkedList.insertAfter(linkedList.head, 2);

    System.out.println("Linked list after insertion :");
    linkedList.printList();

  }
}
