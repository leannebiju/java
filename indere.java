//program to insert elements in a linked list at nth position, replace at nth position and display the list using SLL

import java.io.*;

class Link
{int data;
 Link next;
 public Link(int d)
 {data = d;
  next = null; 
 }
 public void displaylink()
 {System.out.println(data);
 }
}

class LinkList
{private Link first;
 public LinkList()
 {first = null;
 }
 public boolean isEmpty()
 {return (first == null);
 }
 public void insertLast(Link nl)
 {Link cur = first;
  if(!isEmpty())
  {while(cur.next!=null)
   cur = cur.next;
   cur.next = nl;
  }
  else
  first = nl;
 }
 public void displayList()
 {Link cur = first;
  while(cur!=null)
  {cur.displaylink();
   cur = cur.next;
  }
 }
 public int insertatn(int n, Link nl)
 {Link cur = first;
  if(n<=0)
  return 0;
  else if(n==1)
  {nl.next = first;
   first = nl;
   return 1;
  }
  else
  {for(int i = 0; i<n-2; i++)
   {if(cur.next!=null)
    cur = cur.next;
    else 
    return 0;
   }
   nl.next = cur.next;
   cur.next = nl;
   return 1;
  }
 }
 public int replacen(int n, Link nl)
 {Link cur = first;
  if(n<=0)
  return 0;
  else if(n==1)
  {first.data = nl.data;
   return 1;
  }
  else
  {for(int i = 0; i<n-1; i++)
   {if(cur.next!=null)
    cur = cur.next;
    else 
    return 0;
   }
   cur.data = nl.data;
   return 1;
  }
 }
 public Link DeleteFirst()
 {if(!isEmpty())
  {System.out.println("The element deleted is " + first.next);
   first = first.next;
   return first;
  }
  else
  {System.out.println("Empty List. Cannot Delete element.");
   return null;
  }
 }
}

public class indere
{public static void main(String[] args)throws IOException
 {InputStreamReader read = new InputStreamReader(System.in);
  BufferedReader buf  = new BufferedReader(read);
  int c = 0, n, val;
  LinkList s = new LinkList();
  System.out.println("Enter the number of elements in the list :");
  int no = Integer.parseInt(buf.readLine());
  System.out.println("Enter the elements :");
  for(int i = 0; i<no; i++)
  {int q = Integer.parseInt(buf.readLine());
   Link nl = new Link(q);
   s.insertLast(nl);
  }
  System.out.println("The list is : ");
  s.displayList();
  do
  {System.out.println("Press \n1.Insert at nth node \n2.Replace at nth node \n3.Display the list");
   int b = Integer.parseInt(buf.readLine());
   c = 0; int k;
   switch(b)
   {case 1: System.out.println("Enter the node to insert at and the value ");
            n = Integer.parseInt(buf.readLine());
            val = Integer.parseInt(buf.readLine());
            Link np = new Link(val);
            k = s.insertatn(n,np);
            if(k==1)
            {System.out.println("The list after inserting the value at the nth position is :");
             s.displayList();
            }
            else
            System.out.println("Cannot insert element");
            break;
    case 2: System.out.println("Enter the node to replace and the value ");
            n = Integer.parseInt(buf.readLine());
            val = Integer.parseInt(buf.readLine());
            Link npp = new Link(val);
            k = s.replacen(n,npp);
            if(k==1)
            {System.out.println("The list after replacing the value at the nth position is :");
             s.displayList();
            }
            else
            System.out.println("Cannot insert element");
            break;
    case 3: System.out.println("The list is : ");
            s.displayList();
            break;
    default: System.out.println("Wrong Choice. \nPlease try again");
             c = 1;
   } 
   if(c!=1)
   {System.out.println("Press 1 to continue. Any other key to exit.");
    c = Integer.parseInt(buf.readLine());
   }
  }while(c==1);
 }
}
