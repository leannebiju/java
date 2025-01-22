//Binary Search Tree 

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
 public void search(int key)
 {Node cur = root;
  while(cur!=null)
  {if(cur.data == key)
   {System.out.println("Key found.");
    return;
   }
   else if(key<cur.data)
   cur = cur.lchild;
   else
   cur = cur.rchild;
  }
  System.out.println("Key not found.");
 }
 public void inorder(Node lroot)
 {if(lroot!=null)
  {inorder(lroot.lchild);
   lroot.displayNode();
   inorder(lroot.rchild);
  }
 }
}

public class BST
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
  System.out.println("The tree inorder traversal is : ");
  t.inorder(t.root);
  System.out.println();
  System.out.println("Enter the key to search for : ");
  int key = Integer.parseInt(buf.readLine()); 
  t.search(key); 
 }
}
