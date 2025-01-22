//code to execute simple DLL operations - using both first and last pointer - also the forward and backward traversals

import java.io.*;

class link
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

class linklist
{link first; 
 link last;
 public linklist()
 {first = null;
  last = null;
 }
 public boolean isEmpty()
 {return (first==null && last==null);
 }
 public void insertfirst(link nl)
 {if(isEmpty())
  first = last = nl;
  else
  {nl.next = first;
   first.prev = nl;
   first = nl;
  }
 }
 public void insertlast(link nl)
 {if(isEmpty())
  first = last = nl;
  else
  {nl.prev = last;
   last.next = nl;
   last = nl;
  }
 }
 public void deletefirst()
 {if(isEmpty())
  System.out.println("No item to be deleted.");
  else if(first == last)
  {first = null;
   last = null;
  }
  else 
  {first = first.next;
   first.prev = null;
  }
 }
 public void deletelast()
 {if(isEmpty())
  System.out.println("No item to be deleted.");
  else if (first == last) 
  first = last = null;
  else 
  {last = last.prev;
   last.next = null;
  }
 }
 public void forwardtraversal()
 {link cur = first;
  if(cur == null)
  System.out.println("The list is empty");
  else
  {System.out.println("The list is : ");
   while(cur!=null)
   {cur.displaylink();
    cur = cur.next;
   }
  }
 }
 public void backwardtraversal()
 {link cur = last;
  if(cur == null)
  System.out.println("The list is empty");
  else
  {System.out.println("The list is : ");
   while(cur!=null)
   {cur.displaylink();
    cur = cur.prev;
   }
  }
 }
}



public class DLL 
{public static void main(String[] args)throws IOException
 {InputStreamReader read = new InputStreamReader(System.in);
  BufferedReader buf = new BufferedReader(read);
  int d; link nl;
  int n;
  linklist l = new linklist();
  do
  {
  System.out.println("Enter \n1. insertfirst \n2. insertlast \n3. deletefirst \n4. deletelast \n5. forward traversal \n6. backward traversal");
  int c = Integer.parseInt(buf.readLine());
  switch(c)
  {case 1: System.out.println("Enter the data to be inserted : ");
           d = Integer.parseInt(buf.readLine());
           nl = new link(d);
           l.insertfirst(nl);
           break;
   case 2: System.out.println("Enter the data to be inserted : ");
           d = Integer.parseInt(buf.readLine());
           nl = new link(d);
           l.insertlast(nl);
           break;
   case 3: l.deletefirst();
           break;
   case 4: l.deletelast();
           break;
   case 5: l.forwardtraversal();
           break;
   case 6: l.backwardtraversal();
           break;
   default: System.out.println("Wrong choice. Option does not exist.");          
  }
  System.out.println("Press 1 to continue. Any other key to exit.");
  n = Integer.parseInt(buf.readLine());
  }while(n==1);
 }   
}
