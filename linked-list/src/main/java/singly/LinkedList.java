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

  /**
   * Insert at start
   *
   * @param value
   */
  private void insertAtFirst(int value) {
    Node node = new Node(value);
    node.next = head;
    head = node;
  }

  /**
   * Insert after the given node
   *
   * @param prevNode
   * @param value
   */
  private void insertAfter(Node prevNode, int value) {
    if (prevNode == null) {
      return;
    }

    Node node = new Node(value);
    node.next = prevNode.next;
    prevNode.next = node;
  }

  /**
   * Insert at the end
   *
   * @param value
   */
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

  /**
   * Deletes the node with the given key
   *
   * @param key
   */
  private void deleteNode(int key) {
    if (head.data == key) {
      head = head.next;
      return;
    }

    Node prev = head;
    Node temp = head;
    while (temp != null && temp.data != key) {
      prev = temp;
      temp = temp.next;
    }

    if (temp == null) {
      System.out.printf("Key %d is not present in the linked list", key);
      return;
    }

    prev.next = temp.next;
  }

  /**
   * Delete node at the given position
   *
   * @param position
   */
  private void deleteNodeAtGivenPosition(int position) {
    if (head == null) {
      return;
    }

    if (position == 0) {
      head = null;
      return;
    }

    Node temp = head;
    for (int i = 0; temp != null && i < position - 1; i++) {
      temp = temp.next;
    }

    temp.next = temp.next.next;
  }

  /**
   * Deletes the linked list
   */
  private void deleteLinkedList() {
    head = null;
  }

  /**
   * Calculates length of LinkedList Iteratively
   *
   * @return length of LinkedList
   */
  private int lengthOfLinkedListIteratively() {
    int count = 0;
    Node temp = head;
    while (temp != null) {
      count++;
      temp = temp.next;
    }
    return count;
  }

  /**
   * Calculates length of LinkedList Recursively
   *
   * @return length of LinkedList
   */
  private int lengthOfLinkedListRecursively() {
    return lengthOfLinkedList(head);
  }

  private int lengthOfLinkedList(Node node) {
    if (node == null) {
      return 0;
    }

    return 1 + lengthOfLinkedList(node.next);
  }

  /**
   * Prints the list
   */
  private void printList() {
    Node temp = head;
    while (temp != null) {
      System.out.print(temp.data + "->");
      temp = temp.next;
    }
    System.out.print("null");
    System.out.println();
  }

  public static void main(String[] args) {
    LinkedList linkedList = new LinkedList();
    linkedList.insertAtFirst(1);
    linkedList.insertAtEnd(3);
    linkedList.insertAfter(linkedList.head, 2);
    System.out.println("Linked list after insertion :");
    linkedList.printList();

    linkedList.deleteNode(4);

    linkedList.insertAtEnd(4);
    System.out.println("Linked list before deletion :");
    linkedList.printList();
    linkedList.deleteNode(4);
    System.out.println("Linked list after deletion :");
    linkedList.printList();

    linkedList.insertAtEnd(4);
    System.out.println("Linked list before deletion :");
    linkedList.printList();
    linkedList.deleteNodeAtGivenPosition(3);
    System.out.println("Linked list after deletion :");
    linkedList.printList();

    System.out.println("Length of Linked list Iteratively :");
    System.out.println(linkedList.lengthOfLinkedListIteratively());

    System.out.println("Length of Linked list Recursively :");
    System.out.println(linkedList.lengthOfLinkedListRecursively());

    System.out.println("Deleting entire Linked list :");
    linkedList.deleteLinkedList();
    linkedList.printList();

  }
}
