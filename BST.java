class node{
	int key;
	node left,right;
	public node(int key){
		this.key=key;
		this.left=null;
		this.right=null;

	}

}

class Btree{
	public node root;
	public Btree(node root){
		this.root=root;
	}

	public node get_parent(node n){
		return parent(root,n);
	}

	public node parent(node ptr,node n){
		if(ptr.left==n || ptr.right == n)
			return ptr;
		if(n.key<ptr.key)
			return parent(ptr.left,n);
		if(n.key >=ptr.key)
			return parent(ptr.right,n);

		return null;
	}

	public node get_root(){
		return this.root;
	}
	public void insert(node ptr,node ins){
		if(ptr.left==null || ptr.right==null)
		{
			if(ptr.left==null && ins.key< ptr.key)
				ptr.left =ins;
			if(ptr.right==null && ins.key >=ptr.key)
				ptr.right=ins;
			return;	
		}
		if(ins.key < ptr.key)
			insert(ptr.left , ins);
		else insert(ptr.right,ins);
		return ;
	}

	public void inorder(node n){
		if(n==null)
			return;
		inorder(n.left);
		System.out.println(n.key);
		inorder(n.right);
		
	}

	public node delete(node n){
		node parent=get_parent(n);
		if(parent==null)
			return null;
		if(n.left ==null && n.right==null)//leaf node deletion
		{
			
			if(parent.left==n)
				parent.left=null;
			else parent.right=null;
		}
		
		if((n.left==null && n.right!=null))//one child 
		{
			if(parent.left==n)
				parent.left=n.left;
			parent.right=n.left;
		}
		if((n.right==null && n.left!=null))// one child
		{
			if(parent.left==n)
				parent.left=n.right;
			parent.right=n.right;
		}



		

	}	

}	


class BST{
	public static void main(String[] args) {
		node n1=new  node(50);
		Btree tree=new Btree(n1);
		node n2=new node(20);
		node n3=new node(70);
		node n4=new node (15);
		tree.insert(tree.get_root(),n2);
		tree.insert(tree.get_root(),n3);
		tree.insert(tree.get_root(),n4);
		tree.inorder(tree.get_root());
		System.out.println(tree.get_parent(n1).key);
	}
}