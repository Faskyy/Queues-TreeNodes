import java.util.LinkedList;

import org.w3c.dom.Node;

// class TreeNode definition
class TreeNode  <T extends Comparable<T>> {
   // package access members
   TreeNode<T> leftNode;
   T data; // node value
   TreeNode<T> rightNode;

   // constructor initializes data and makes this a leaf node
   public TreeNode(T nodeData) {
      data = nodeData;
      leftNode = rightNode = null; // node has no children
   }

   // locate insertion point and insert new node; ignore duplicate values
   public void insert(T insertValue) {
      // insert in left subtree
      if (insertValue.compareTo(data) < 0) {
         // insert new TreeNode
         if (leftNode == null)
            leftNode = new TreeNode<T>(insertValue);
         else // continue traversing left subtree recursively
            leftNode.insert(insertValue);
      }
      // insert in right subtree
      else if (insertValue.compareTo(data) > 0) {
         // insert new TreeNode
         if (rightNode == null)
            rightNode = new TreeNode<T>(insertValue);
         else // continue traversing right subtree recursively
            rightNode.insert(insertValue);
      }
   }
} // end class TreeNode

// class Tree definition
public class Tree<T extends Comparable<T>> {
   private TreeNode<T> root;

   // constructor initializes an empty Tree
   public Tree() { root = null; }

   // insert a new node in the binary search tree
   public void insertNode(T insertValue) {
      if (root == null)
         root = new TreeNode<T>(insertValue); // create root node
      else
         root.insert(insertValue); // call the insert method
   }

   // begin preorder traversal
   public void preorderTraversal() {
      preorderHelper(root);
   }

   // recursive method to perform preorder traversal
   private void preorderHelper(TreeNode<T> node) {
      if (node == null) return;

      System.out.printf("%s ", node.data); // output node data
      preorderHelper(node.leftNode); // traverse left subtree
      preorderHelper(node.rightNode); // traverse right subtree
   }

   // begin inorder traversal
   public void inorderTraversal() {
      inorderHelper(root);
   }

   // recursive method to perform inorder traversal
   private void inorderHelper(TreeNode<T> node) {
      if (node == null)  return;

      // DELETE THE FOLLOWING LINE AND INSERT YOUR CODE HERE
      inorderHelper(node.leftNode);//nodes from the left
      System.out.printf("%s ", node.data); // output node data
      inorderHelper(node.rightNode);// nodes from the right

      
   }

   // begin postorder traversal
   public void postorderTraversal() {
      postorderHelper(root);
   }

   // recursive method to perform postorder traversal
   private void postorderHelper(TreeNode<T> node) {
      if (node == null) return;

      postorderHelper(node.leftNode); // traverse left subtree
      postorderHelper(node.rightNode); // traverse right subtree
      System.out.printf("%s ", node.data); // output node data

      
   }

   ///////////////////////////////////////////////////////////////////
   //////////////////// ADD YOUR OWN METHODS BELOW ///////////////////
   ///////////////////////////////////////////////////////////////////

   // return a reference to the root of this tree
   public TreeNode<T> getRoot() { return this.root;}

   // get the depth of this node
   private int depth(TreeNode<T> node) {
      // YOUR CODE HERE
	   if (node == null) { //if the node is null return 0
		   return 0;
	   } else {
	   int leftDepth = depth(node.leftNode); //run recursively
	   int rightDepth = depth(node.rightNode); // run recursively
	   
	   if (leftDepth > rightDepth) { //if leftdepth > right depth
		   return (leftDepth + 1);} //add one to left depth
	   else {
		   return (rightDepth + 1); //add one to right depth
	   }
	   }
	   }
	

   // get depth of this tree
   public int depth() {
	  System.out.println(); 
	  System.out.println("The depth of this tree is");
      return depth(this.root);
   }
   

  
   
   public void inorder() {
	   LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
	   if (root == null) {
		   System.out.println("Empty Tree");
		
	   }
	   queue.add(root); //add queue to the root
	   while(!queue.isEmpty()) { //while not empty
		   TreeNode node = queue.remove(); //remove
		   System.out.print(node.data + " "); //print data
		   
		   
		   if(node.leftNode != null) //if it is not null
			   queue.add(node.leftNode); //add
		   if(node.rightNode != null) //if it is not null
			    queue.add(node.rightNode); // add
		   
	   }
	   
	 
	   }
	   
   }


    // end class Tree
