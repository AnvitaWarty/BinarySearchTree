/* 
* The BST class is a class that uses methods to perform 
* operations on Binary Search Trees. It only has one private 
* data variable called treeRoot which will be the root node
* of the Binary Tree. This class also extensively uses the TreeNode<T> 
* clas. 
*/

class BST<T>
{
 private TreeNode<T> treeRoot;
 
 BST()
 {
  treeRoot = null; 
 }
 
 BST(T data)
 {
  treeRoot.setData(data); 
 }
 
 void setTreeRoot(TreeNode<T> root) 
 {
  treeRoot = root; 	 
 }
 
 TreeNode<T> getTreeRoot()
 {
   return treeRoot; 
 }

 /* 
 * method: insert 
 * This method takes in a root node, and a generic type variable called value.
 * First we take the difference between the value and the root node value 
 * If the difference is 0. The user has entered an existing value and the method will throw an exception that needs
 * to be handled in the driver program (BinarySearchTreeProgram.java)
 * If the difference is <0 or >0, the method will use recursion to find the correct placement of the new value 
 * as right child or left child of a parent in the tree.
 */ 
 T insert(TreeNode<T> root, T value)
 {
   T finalTree = null;
   assert root!=null; 
   int difference = (int)value - (int)root.getData();
   if(difference == 0) 
	throw new IllegalArgumentException(); 
   if(difference < 0) 
   {
	 if(root.hasLeft())
		 finalTree = insert(root.getLeftChild(), value);
     else
        root.setLeftChild(new TreeNode<T>(value)); 		 
   }
   if(difference > 0) 
   {
	 if(root.hasRight())
		 finalTree = insert(root.getRightChild(), value);
     else
        root.setRightChild(new TreeNode<T>(value)); 		 
   }
   return finalTree;
 }
 
  /* 
 * method: removal 
 * This method takes in a root node, and a generic type variable called value.
 * First we take the difference between the value and the root node value 
 * The base case is if the difference is 0, then we will use the removeTreeRoot method
 * Otherwise, if the difference is <0 or >0, the method will use recursion and pass the 
 * the root's left child or right child as the new root value (respectively). 
 * We have an else statement that throws an exception in the case that the user enters a nonexistent value.
 * This exception will have to be handled in the driver program (BinarySearchTreeProgram.java)
 */ 
 TreeNode<T> removal(TreeNode<T> root, T valRemove)
 {
   if(root!=null)    
   {
	 int difference = (int)valRemove - (int)root.getData();
   
    if(difference == 0) 
	 root = removeTreeRoot(root); 
    if(difference < 0) 
    {
     root.setLeftChild(removal(root.getLeftChild(), valRemove)); 	   
    }
    if(difference > 0) 
    {
	 root.setRightChild(removal(root.getRightChild(), valRemove)); 		 
    } 
   }
   else
	throw new IllegalArgumentException();
   return root;  
 }
 
  /* 
 * method: removeTreeRoot 
 * This method takes in a root node
 * If the root has both children, then the first if statement will perform. 
     *The root node will be replaced by the node holding the largest value. 
	 *Then the node holding the largest value will be removed. 
 *If the node only has a right child, the root will now equal its right child. 
 *Similary, if the node only has a left child, the root will now equal its left child.
 */ 
 TreeNode<T> removeTreeRoot(TreeNode<T> root) 
 {
	if(root.hasLeft() && root.hasRight())
	{
	  TreeNode<T> largestNode = root.getLeftChild().maxNode(); 
      root.setData(largestNode.getData()); 
      root.setLeftChild(removeMaxNode(root.getLeftChild())); 	  
	}
	else if(root.hasRight())
	{
	  root = root.getRightChild(); 
	}
	else
	{
	  root = root.getLeftChild();
	}
	
	return root;
 }
 
  /* 
 * method: removeMaxNode 
 * This method will remove the right most node in the tree.
 */ 
 TreeNode<T> removeMaxNode(TreeNode<T> root)
 {
	if(root.hasRight())
	{
	  TreeNode<T> newRight = removeMaxNode(root.getRightChild()); 
	  root.setRightChild(newRight); 
	}
	else 
      root = root.getLeftChild();
  
    return root; 
 }
 
   /* 
 * method: predecessor
 * This method takes in a root node, a predecessor node, and a generic type value.
 * First we will take the difference of the root node's value and the generic type value.
 * If the difference is 0, we will return the rightmost node in the root's left subtree
 * If the difference is < 0, we will use recursion and update the root variable using the root's left child.
 * If the difference is > 0, we will not only use recursion and update the root variable using the root's right child but we will 
 * update the predecessor value to hold the current root because in an in-order traversal, the root comes before the right child.
 */ 
 TreeNode<T> predecessor(TreeNode<T> root, TreeNode<T> predecessor, T value)
 {
   int difference = (int)value - (int)root.getData(); 
   if(root == null) 
    return predecessor; 
   if(difference==0 && root.hasLeft())
	return root.getLeftChild().maxNode();
   if(difference < 0) 
	return predecessor(root.getLeftChild(), predecessor, value); 
   if(difference > 0) 
   {
	predecessor = root; 
	return predecessor(root.getRightChild(), predecessor, value);
   }
   
   return predecessor; 
 }
 
   /* 
 * method: successor
 * This method takes in a root node, a successor node, and a generic type value.
 * First we will take the difference of the root node's value and the generic type value.
 * If the difference is 0, we will return the leftmost node in the root's right subtree
 * If the difference is > 0, we will use recursion and update the root variable using the root's right child.
 * If the difference is < 0, we will not only use recursion and update the root variable using the root's left child but we will 
 * update the successor value to hold the current root because in an in-order traversal, the root comes after the left child.
 */ 
 TreeNode<T> successor(TreeNode<T> root, TreeNode<T> successor, T value) 
 {
   int difference = (int)value - (int)root.getData(); 
   if(root == null) 
    return successor; 
   if(difference==0 && root.hasRight())
	return root.getRightChild().minNode();
   if(difference < 0)
   {
	successor = root;
	return successor(root.getLeftChild(), successor, value);
   }	
   if(difference > 0) 
   { 
	return successor(root.getRightChild(), successor, value);
   }
  return successor; 
 }

}