import java.util.Scanner; 

class BinarySearchTreeProgram
{
 public static void main(String[] args) 
 {
   //initializing import variables used throughout program
   BST<Integer> tree = new BST<Integer>(); 
   String str = ""; 
   String[] sequence; 
   int[] numbers; 
   Scanner kb = new Scanner(System.in);
   
   
   //recording initial sequence of numbers
   System.out.println("\nPlease enter the initial sequence of values: "); 
   str = kb.nextLine().trim();
   sequence = str.split(" ");
   numbers = new int[sequence.length];   
  
   for(int i = 0; i < sequence.length; i++) 
   {
	numbers[i] = Integer.parseInt(sequence[i]); 
   }
   
   //building tree: first creating root 
   
   tree.setTreeRoot(new TreeNode<Integer>(numbers[0])); 
   TreeNode<Integer> treeRoot = tree.getTreeRoot(); 
   
   for(int i = 1; i < numbers.length; i++) 
   {
	tree.insert(treeRoot, numbers[i]);   
   }
   
   //printing initial preOrder, postOrder, inOrder 
   System.out.println(); 
   System.out.print(" Pre-order: "); 
   treeRoot.preOrder(treeRoot); 
   System.out.println();
   System.out.print("  In-order: "); 
   treeRoot.inOrder(treeRoot);
   System.out.println();
   System.out.print("Post-order: ");
   treeRoot.postOrder(treeRoot); 
   System.out.println();
   
   //prompt 
   String userInput = "";
   System.out.println("\nCommand?" + 
				    "\nI Insert a value" + 
					"\nD Delete a value" +
					"\nP Find predecessor" + 
                    "\nS Find successor" + 
                    "\nE Exit the program" + 
					"\nH Display this message"); 
   userInput = kb.nextLine().trim(); 
   String[] command = userInput.split(" ");
   
   //loop for each letter
   while(!command[0].equalsIgnoreCase("E")) 
   {
	if(command[0].equalsIgnoreCase("I"))
    {
	  try{
       tree.insert(treeRoot, Integer.parseInt(command[1]));
	   System.out.print("\nIn-order: ");
	   treeRoot.inOrder(treeRoot);
	   System.out.println();
	  }
	  
	  catch(IllegalArgumentException E) 
	  {
	    System.out.println("\n" + command[1] + " already exists, ignore.");
	  }
    }
	if(command[0].equalsIgnoreCase("D"))
    {
     try{
      tree.removal(treeRoot, Integer.parseInt(command[1])); 
      System.out.print("\nIn-order: "); 
      treeRoot.inOrder(treeRoot); 
      System.out.println();	  
	 }
	 
	 catch(IllegalArgumentException E) 
	 {
	   System.out.println("\n" + command[1] + " doesn\'t exist!");
	 }
    }
	if(command[0].equalsIgnoreCase("P"))
    {
      System.out.println("\n" + tree.predecessor(treeRoot, null, Integer.parseInt(command[1])));       
    }
	if(command[0].equalsIgnoreCase("S"))
    {
     System.out.println("\n" + tree.successor(treeRoot, null, Integer.parseInt(command[1]))); 
    }
	if(command[0].equalsIgnoreCase("H"))
    {
     System.out.println("\nCommand?" + 
				    "\nI Insert a value" + 
					"\nD Delete a value" +
					"\nP Find predecessor" + 
                    "\nS Find successor" + 
                    "\nE Exit the program" + 
					"\nH Display this message"); 
     userInput = kb.nextLine().trim(); 
     command = userInput.split(" "); 
     continue;	 
    }
 
   System.out.print("\nCommand?"); 
   userInput = kb.nextLine().trim(); 
   command = userInput.split(" ");
   }
   //final good-bye
   System.out.println("Thank you for using my program!");
 }
}