package tree;

public class BinaryTree {
	
      Node root;
   public BinaryTree(){
    	root=null;
    }
   public BinaryTree(int key){
    	root=new Node(key);
    }
   
   public void inOrder(Node root) {
	   while(root!=null) {
		   inOrder(root.left);
		   System.out.println(root.key);
		   inOrder(root.right);
	   }
   }
   
   public void preOrder(Node root) {
	   while(root!=null) {
		   System.out.println(root.key);
		   inOrder(root.left);
		   inOrder(root.right);
	   }
   }
   
   public void postOrder(Node root) {
	   while(root!=null) {
		   inOrder(root.left);
		   inOrder(root.right);
		   System.out.println(root.key);
	   }
   }
   
   public boolean isFullTree(Node node) {
	   if(node==null) {
		   return true;
	   }
	   if(node.right==null && node.left==null) {
		   return true;
	   }
	   if((node.left!=null) && node.right!=null) {
		   return (isFullTree(node.left) && isFullTree(node.right));
	   }
	   return false;
	   
   }
   
   //can only be used by the perfect tree.
   static int depth(Node node) {
	   int d=0;
	   while(node.left!=null) {
		   d++;
		   node=node.left;
	   }
	   return d;
   }
   
   //can  be use for any tree.
   int preciseDepth(Node node) {
	   if(node==null){
		   return 0;
	   }
	   else {
		   int lDepth=preciseDepth(node.left);
		   int rDepth=preciseDepth(node.right);
	   
		   if(lDepth>rDepth) {
			   return lDepth+1;
			   
		   }
		   if(rDepth>lDepth) {
			   return rDepth+1;
		   }
			   else {
				   return rDepth+1;
			   }
	   }
   }
   
   public boolean isPerfect(Node node,int d, int level) {
	   if(node==null) {
		   return true;
	   }
	   if(node.right==null && node.left==null) {
		   return (d==level+1);
	   }
	   if(root.right==null || root.left==null) {
		   return false;
	   }
	   return isPerfect(root.left,d,level+1) && isPerfect(root.right,d,level+1);
   }
   //wrapper function
    public boolean is_Perfect(Node root) {
    	int d=depth(root);
    	return isPerfect(root,d,0);
    }
    
   public  int countNoOfNode(Node root) {
    	if(root==null) {
    		return (0);	
    	}
    	return (1+countNoOfNode(root.left)+countNoOfNode(root.right));
    }
   
   public boolean isComplete(Node node,int numberOfNode,int countNoOfNode) {
	   int index=0;  
	   if(root==null) {
		   return true;
	   }
	   if(index>=numberOfNode) {
		   return false;
	   }
//element at index 2i+1 will became the left child and the one at the 2i+2 index will became the right child
	   return(isComplete(root.left,2*index+1,numberOfNode) && isComplete(root.right,2*index+2,numberOfNode));
   }
    
  boolean isBalanced(Node node) {
	  if(root==null) {
		  return true;
	  }
	  int lh;
	  int rh;
	  lh=preciseDepth(node.left);
	  rh=preciseDepth(node.right);
	  if(Math.abs(lh-rh)<=1 && isBalanced(node.right) && isBalanced(node.left)) {
	    return true; 
  	  }
	  return false;
  }
  
  
  
}
class Node{
	int key;
	Node left,right;
	Node(int key){
		this.key=key;
		left=right=null;
	}
}
