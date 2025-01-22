//implement queue using DLL

import java.io.*;

class DLink
{public int data;
 public DLink next;
 public DLink prev;
 public DLink(int d)
 {prev = null;
  next = null;
  data = d;
 }
 public void displaylink()
 {System.out.println(data);
 }
}

class QueueLink
{private DLink first;
 private DLink last;
 public QueueLink()
 {first = null;
  last = null;
 }
 public void insertLast(int d)
 {DLink nl = new DLink(d);
  if(first == null)
  {first = last = nl;
  }
  else
  {nl.prev = last;
   last.next = nl;
   last = nl;
  }
 }
 public void display()
 {DLink cur = first;
  if(isEmpty())
  System.out.println("The Queue is empty");
  else
  {System.out.println("The elements are : ");
   while (cur!=null)
   {cur.displaylink();
    cur = cur.next;
   }
  }
 }
 public void remove()
 {DLink cur = first;
  if(isEmpty())
  {System.out.println("Queue empty. No element to be deleted.");
  }
  else
  {if(first == last)
   {System.out.println("The element deleted now is " + first.data + "\nQueue is now empty. All elements are deleted.");
    first = null;
    last = null; 
   }
   else if(cur == first)
   {System.out.println("The element removed is " + first.data);
    first = cur.next;
    first.prev = null;
   }
  }
 }
 public void peek()
 {if(isEmpty())
  System.out.println("Queue is empty");
  else
  System.out.println("The element at the front is : " + first.data);
 }
 public boolean isEmpty()
 {DLink cur = first;
  return(cur==null);
 }
}
public class pro3
{public static void main(String[] args)throws IOException
 {InputStreamReader read = new InputStreamReader(System.in);
  BufferedReader buf = new BufferedReader(read);
  QueueLink s = new QueueLink();
  int c;
  System.out.println("Enter your choice : ");
  do
  {System.out.println("1.Insert element \n2.Display queue \n3.Remove element \n4.Peek \n5.Check if the queue is empty");
   int n = Integer.parseInt(buf.readLine());
   switch(n)
   {case 1:
    System.out.println("Enter element to be inserted : ");
    int d = Integer.parseInt(buf.readLine());
    s.insertLast(d);
    break;
    
    case 2:
    s.display();
    break;
    
    case 3: 
    s.remove();
    if(!s.isEmpty())
    {System.out.println("The elements in the queue now are : ");
     s.display();
    }
    break;
    
    case 4:
    s.peek();
    break;
    
    case 5: 
    if(s.isEmpty())
    System.out.println("The Queue is empty");
    else
    System.out.println("The Queue is not empty");
    break;
    
    default: 
    System.out.println("Choice does not exist.");
   }
   System.out.println("Press 1 to continue. ");
   c = Integer.parseInt(buf.readLine());
  }
  while(c==1);
 }
}
