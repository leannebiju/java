//priority queue

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
 public Link dequeue()
 {if(!isEmpty())
  {System.out.println("The element deleted is " + first.data);
   first = first.next;
   return first;
  }
  else
  {System.out.println("Empty List. Cannot Delete element.");
   return null;
  }
 }
 public void enqueue(int d)
 {Link nl = new Link(d);
  if(first==null || d<=first.data)
  {nl.next = first;
   first = nl;
  }
  else
  {Link cur = first;
   while(cur.next!=null && d>cur.next.data)
   {cur = cur.next;
   }
   nl.next = cur.next;
   cur.next = nl;
  }
 }
 public void displayList()
 {Link cur = first;
  while(cur!=null)
  {cur.displaylink();
   cur = cur.next;
  }
 }
}

public class priq
{public static void main(String[] args)throws IOException
 {InputStreamReader read = new InputStreamReader(System.in);
  BufferedReader buf  = new BufferedReader(read);
  int c = 0;
  LinkList s = new LinkList();
  do
  {System.out.println("Press \n1.Enqueue \n2.Dequeue \n3.Display List");
   int b = Integer.parseInt(buf.readLine());
   c = 0;
   switch(b)
   {case 1: System.out.println("Enter the element : ");
            int d = Integer.parseInt(buf.readLine());
            s.enqueue(d);
            break;
    case 2: s.dequeue();
            break;
    case 3: System.out.println("The queue is : ");
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

