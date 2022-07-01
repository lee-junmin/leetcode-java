package _notes.trees;

import java.util.Stack;

public class Note {

  void printPreorder(TreeNode node)
  {
    if (node == null)  return;
    System.out.print(node.val + " ");
    printPreorder(node.left);
    printPreorder(node.right);
  }
 
  void printInorder(TreeNode node)
  {
    if (node == null) return;
    printInorder(node.left);
    System.out.print(node.val + " ");
    printInorder(node.right);
  }
  
  void printInorder_stk(TreeNode node){
    if (node == null) return;
    Stack<TreeNode> s = new Stack<TreeNode>();
    TreeNode curr = node;
    while (!s.isEmpty() || curr != null) {
      while(curr != null) {
        s.push(curr);
        curr = curr.left;
      }
      curr = s.pop();
      System.out.print(curr.val + " "); // do the main task right after the pop
      curr = curr.right;
    }
  }
  
  void printPostorder(TreeNode node)
  {
    if (node == null) return;
    printPostorder(node.left);
    printPostorder(node.right);
    System.out.print(node.val + " ");
  }
 
  public static void main(String[] args)
  {
    Note note = new Note();
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    
    System.out.println("Preorder traversal: ");
    note.printPreorder(root);
    
    System.out.println("\nInorder traversal: ");
    note.printInorder(root);
  
    System.out.println("\nInorder traversal (stack): ");
    note.printInorder_stk(root);
    
    System.out.println("\nPostorder traversal: ");
    note.printPostorder(root);
  }
  
}

