package traversals;

/**
 * Given a binary tree, print boundary nodes of the binary tree Anti-Clockwise starting from the
 * root.
 */

class Node {

  int data;
  Node left;
  Node right;

  Node(int data) {
    this.data = data;
    this.left = null;
    this.right = null;
  }

}

public class BoundaryTraversal {

  Node root;

  void printLeftBoundaryTopBottom(Node node) {

    if (node == null) {
      return;
    }

    if (node.left != null) {
      System.out.print(node.data + " ");
      printLeftBoundaryTopBottom(node.left);
    } else if (node.right != null) {
      System.out.print(node.data + " ");
      printLeftBoundaryTopBottom(node.right);
    }
  }

  void printLeaves(Node node) {

    if (node == null) {
      return;
    }
    printLeaves(node.left);
    if (node.left == null && node.right == null) {
      System.out.print(node.data + " ");
    }
    printLeaves(node.right);
  }

  void printRightBoundaryBottomTop(Node node) {

    if (node == null) {
      return;
    }

    if (node.right != null) {
      printRightBoundaryBottomTop(node.right);
      System.out.print(node.data + " ");
    } else if (node.left != null) {
      printRightBoundaryBottomTop(node.left);
      System.out.print(node.data + " ");
    }
  }

  void printBoundaryTraversal(Node node) {

    if (node == null) {
      return;
    }
    System.out.print(node.data + " ");

    printLeftBoundaryTopBottom(node.left);

    printLeaves(node.left);
    printLeaves(node.right);

    printRightBoundaryBottomTop(node.right);

  }

  public static void main(String[] args) {

    BoundaryTraversal tree = new BoundaryTraversal();
    tree.root = new Node(20);
    tree.root.left = new Node(8);
    tree.root.left.left = new Node(4);
    tree.root.left.right = new Node(12);
    tree.root.left.right.left = new Node(10);
    tree.root.left.right.right = new Node(14);
    tree.root.right = new Node(22);
    tree.root.right.right = new Node(25);
    tree.printBoundaryTraversal(tree.root);
  }
}
