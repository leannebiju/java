//dfs traversal

import java.io.*;

class link //defining the link aka the nodes
{int data;
 link next;
 link prev;
 public link(int d)
 {data = d;
  next = null;
  prev = null;
 }
 public void displaylink()
 {System.out.println(data);
 }
}

class linklist //for adjacency list
{link first; 
 link last;
 public linklist()
 {first = null;
  last = null;
 }
 public int size() //to count the number of elements i.e. the number of nodes that are connected in a list
 {int count = 0;
  link cur = first;
  while(cur!=null)
  {count++;
   cur = cur.next;
  }
  return count;
 }
 public int get(int n) //to get the name of the node 
 {link cur = first;
  for(int i = 1; i<=n; i++)
  {cur = cur.next;
  }
  return cur.data;
 }
 public boolean isEmpty() //to check if the list is empty
 {return (first==null && last==null);
 }
 public void insertlast(int n) //to insert to the last - also used as enqueue
 {link nl = new link(n);
  if(isEmpty())
  first = last = nl;
  else
  {nl.prev = last;
   last.next = nl;
   last = nl;
  }
 }
}

class graphop //for graph operations
{int node; //to store the number of nodes 
 linklist[] arr; //to store the edges as adjacency lists 
 boolean visit[]; //to store boolean value for whether the node is visited or not
 public void dfsval(int v) //to create an array of linklist for v nodes and also a queue
 {node = v;
  arr = new linklist[node];
  visit = new boolean[node];
  for(int i = 0; i<node; i++)
  {arr[i] = new linklist();
  }
 }
 public void insertedge(int u, int v) //to insert edges into the graph
 {arr[u].insertlast(v);
  arr[v].insertlast(u); //remove this line for directed graph
 }
 public void dfs(int v) //to find and print the dfs traversal
 {visit[v] = true; //initialising the first vertex as visited 
  int x;
  System.out.print(v + " "); //displaying that edge
  for(int i = 0; i<arr[v].size();i++) //checking for adjacent edges
  {x = arr[v].get(i); //finding the nodes 
   if(!visit[x]) //if the nodes are not visited
   {visit[x] = true; //then setting them to visited
    dfs(x); 
   }
  }
 }
}

public class dfstra
{public static void main(String[] args)throws IOException
 {graphop g = new graphop(); //creating object for graphop
  g.dfsval(6); //creating a array to store the adjacency list of a graph with 6 nodes
  //inserting the edges - here the graph insertion is happening for undirected graphs - hence need to insert only once
  g.insertedge(0,2);
  g.insertedge(0,3);  
  g.insertedge(0,1);
  g.insertedge(2,4);
  //finding and displaying the DFS traversal
  System.out.println("The DFS traversal of the graph is : ");
  g.dfs(0);  
 }
}