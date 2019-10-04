import java.util.*;
class DFS
{
	static Stack stack=new Stack();
	//static Scanner scan=new Scanner(System.in);
	public static void main(String...args)
	{
		int count=0;
		int N=0;
		Scanner scan=new Scanner(System.in);
		Node root=new Node();
		do
		{
			System.out.println();
			System.out.println("Enter 1 to insert a node, 2 for inorder traversal");
		    N=scan.nextInt();
			if(N==1)
			{
				count=count+1;
				Insert(root, count);
			}
			
			else if(N==2)
			{
				Inorder_Traversal(root);
			}
		}while(N!=0);
		
	}
	
	public static void Insert(Node node, int count)
	{
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the value to be inserted");
		int val=scan.nextInt();
		for(int i=0;i<count;i++)
		{
			if(node.value==null)
			{
				node.value=val;
			}
			
			else
			{
				if(node.value>val)
				{
					if(node.leftchild==null)
					{
						node.leftchild=new Node();
					}
					node=node.leftchild;
				}
				
				else if(node.value<val)
				{
					if(node.rightchild==null)
					{
						node.rightchild=new Node();
					}
					node=node.rightchild;
				}
			}
		}
	}
	
	public static void Inorder_Traversal(Node node)
	{
		Inorder_Left(node);
	}
	
	public static void Inorder_Left(Node node)
	{
		if(node.leftchild!=null)
		{
			stack.push(node);
			node=node.leftchild;
			Inorder_Left(node);
		}
		
		else
		{
			stack.push(node);
			Inorder_Right(stack.pop());
		}
	}
	
	public static void Inorder_Right(Node node)
	{
		if(node.rightchild==null)
		{
			System.out.print(node.value+" ");
			if(stack.size()>0)
			{
				Inorder_Right(stack.pop());
			}
		}
		else
		{
			System.out.print(node.value+" ");
			Inorder_Left(node.rightchild);
		}
	}
}

class Node
{
	Integer value=null;
	Node leftchild;
	Node rightchild;
}

class Stack
{
	ArrayList<Node> list=new ArrayList<Node>();
	public void push(Node node)
	{
		list.add(node);
	}
	
	public Node pop()
	{
		Node n=list.get(list.size()-1);
		list.remove(list.size()-1);
		return n;
	}
	
	public int size()
	{
		return list.size();
	}
}