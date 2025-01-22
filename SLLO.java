//code to execute simple SLL operations - only first pointer

import java.io.*;

class link
{int data;
 link next;
 public link(int d)
 {data = d;
  next = null;
 }
 public void displaylink()
 {System.out.println(data);
 }
}

class linklist
{link first; 
 public linklist()
 {first = null;
 }
 //to check if it is empty
 public boolean isEmpty()
 {return (first==null);
 }
 //to insert an element in the beginning
 public void insertfirst(link nl)
 {if(isEmpty())
  {first = nl;
  }
  else
  {nl.next = first;
   first = nl;
  }
 }
 //to insert an elment at the end
 public void insertlast(link nl)
 {if(isEmpty())
  {first = nl;
  }
  else
  {link cur = first;
   while(cur.next!=null)
   {cur = cur.next;
   }
   cur.next = nl;   
  }
 }
 //to delete the first element 
 public void deletefirst()
 {if(isEmpty())
  System.out.println("No item to be deleted.");
  else
  first = first.next;
 }
 //to delete the last element
 public void deletelast()
 {if(isEmpty())
  System.out.println("No item to be deleted.");
  else if (first.next == null) 
  first = null;
  else 
  {link cur = first;
   while(cur.next.next!=null)
   cur = cur.next;
   cur.next = null;
  }
 }
 //display the list
 public void displaylist()
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
}



public class SLLO 
{public static void main(String[] args)throws IOException
 {InputStreamReader read = new InputStreamReader(System.in);
  BufferedReader buf = new BufferedReader(read);
  int d; link nl;
  int n;
  linklist l = new linklist();
  do
  {
  System.out.println("Enter \n1. insertfirst \n2. insertlast \n3. deletefirst \n4. deletelast \n5. display");
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
   case 5: l.displaylist();
           break;
   default: System.out.println("Wrong choice. Option does not exist.");          
  }
  System.out.println("Press 1 to continue. Any other key to exit.");
  n = Integer.parseInt(buf.readLine());
  }while(n==1);
 }   
}
