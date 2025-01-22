//Tree Traversal

import java.io.*;

class Node
{public int data;
 public Node lchild;
 public Node rchild;
 public Node(int d)
 {data = d;
 }
 public void displayNode()
 {System.out.print(data + " ");
 }
}

class Tree
{public Node root;
 public Tree()
 {root = null;
 }
 public void insert(int j)
 {Node newnode = new Node(j);
  if(root == null)
  root = newnode;
  else
  {Node cur = root;
   Node parent; 
   while(true)
   {parent = cur;
    if(j<cur.data)
    {cur = cur.lchild;
     if(cur == null)
     {parent.lchild = newnode;
      return;
     }
    }
    else
    {cur = cur.rchild;
     if(cur==null)
     {parent.rchild = newnode;
      return;
     }
    }
   }
  }
 }
 public void inorder(Node lroot)
 {if(lroot!=null)
  {inorder(lroot.lchild);
   lroot.displayNode();
   inorder(lroot.rchild);
  }
 }
 public void postorder(Node lroot)
 {if(lroot!=null)
  {postorder(lroot.lchild);
   postorder(lroot.rchild);
   lroot.displayNode();
  }
 }
 public void preorder(Node lroot)
 {if(lroot!=null)
  {lroot.displayNode();
   preorder(lroot.lchild);
   preorder(lroot.rchild);
  }
 }
} 

public class tt
{public static void main(String[] args)throws IOException
 {InputStreamReader read = new InputStreamReader(System.in);
  BufferedReader buf  = new BufferedReader(read);
  Tree t = new Tree();
  System.out.println("Enter value of nodes. Press character to exit. ");
  try
  {while(true)
   {int m = Integer.parseInt(buf.readLine()); 
    t.insert(m);  
   }
  }
  catch(NumberFormatException m)
  {}
  int p = 0;
  do
  {System.out.println("Press \n1. Inorder traversal \n2.Preorder Traversal \n3.Postorder Traversal");
   int c = Integer.parseInt(buf.readLine());
   switch(c)
   {case 1: t.inorder(t.root);
            break;
    case 2: t.preorder(t.root);
            break;
    case 3: t.postorder(t.root);
            break;
    default : System.out.println("Option does not exist");
   }
   System.out.println("\nPress 1 to continue.");
   p = Integer.parseInt(buf.readLine());
  }
  while(p == 1);
 }
}
