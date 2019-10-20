/* 
* The TreeNode class is a special class that creates nodes specifically for Trees
* This class has the appropriate getters and setters and additional methods like 
* the traversal methods (pre, post, and in), hasRight and hasLeft (which returns boolean values 
* based on the existence of the respective child), and a min and maxNode method which returns the 
* leftmost child and rightmost child (respectively) of the root argument.
*/

class TreeNode<T>
{
 TreeNode<T> leftChild; 
 TreeNode<T> rightChild; 
 T data; 
 
 TreeNode(T data)
 {
  this(data, null, null);
 }
 
 TreeNode(T data, TreeNode<T> leftChild, TreeNode<T> rightChild) 
 {
  this.data = data; 
  this.leftChild = leftChild; 
  this.rightChild = rightChild; 
 }
 
 T getData()
 {
  return data;
 }
 
 TreeNode<T> getLeftChild()
 {
  return leftChild;
 }
 
 TreeNode<T> getRightChild()
 {
  return rightChild;
 }
 
 void setData(T data)
 {
  this.data = data;
 }
 
 void setLeftChild(TreeNode<T> leftChild)
 {
  this.leftChild = leftChild;
 }
 
 void setRightChild(TreeNode<T> rightChild)
 {
  this.rightChild = rightChild;
 }
 
 void preOrder(TreeNode<T> treeRoot) 
 { 
   if(treeRoot!=null)
   {
	System.out.print(treeRoot + " "); 
	preOrder(treeRoot.leftChild); 
	preOrder(treeRoot.rightChild);
   }
 }
 
 void inOrder(TreeNode<T> treeRoot)
 {
   if(treeRoot!=null)
   {
	inOrder(treeRoot.leftChild); 
    System.out.print(treeRoot + " ");
    inOrder(treeRoot.rightChild);   
   }
 }
 
 void postOrder(TreeNode<T> treeRoot)
 {
  if(treeRoot!=null)
  {
   postOrder(treeRoot.leftChild); 
   postOrder(treeRoot.rightChild); 
   System.out.print(treeRoot + " ");
  }
 }
 
 boolean hasRight() 
 {
  return rightChild!=null;
 }
 
 boolean hasLeft()
 {
  return leftChild!=null;
 }
 
 TreeNode<T> maxNode() 
 {
  if(rightChild == null) 
	return this; 
  else 
    return rightChild.maxNode();
 }
 
 TreeNode<T> minNode() 
 {
  if(leftChild == null) 
	return this; 
  else 
	return leftChild.minNode(); 
 }
 
 
 @Override
 public String toString()
 { 
   String str = "" + data; 
   return str;
 }
}