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

class DLinkList
{private DLink first;
 private DLink last;
 public DLinkList()
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
 public void insertFirst(int d)
 {DLink nl = new DLink(d);
  if(first == null)
  {first = last = nl;
  }
  else
  {first.prev = nl;
   nl.next = first;
   first = nl;
  }
 }
 public void deleteFirst()
 {DLink cur = first;
  if(isEmpty())
  {System.out.println("List empty. No element to be deleted.");
  }
  else
  {if(first == last)
   {System.out.println("The element deleted now is " + first.data + "\nList is now empty. All elements are deleted.");
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
 public void deleteLast()
 {DLink cur = last;
  if(isEmpty())
  {System.out.println("List empty. No element to be deleted.");
  }
  else
  {if(first == last)
   {System.out.println("The element deleted now is " + first.data + "\nList is now empty. All elements are deleted.");
    first = null;
    last = null; 
   }
   else if(cur == last)
   {System.out.println("The element removed is " + last.data);
    last = cur.prev;
    last.next = null;
   }
  }
 }
 public void peek()
 {if(isEmpty())
  System.out.println("List is empty");
  else
  System.out.println("The element at the front is : " + first.data);
 }
 public boolean isEmpty()
 {DLink cur = first;
  return(cur==null);
 }
 public void displayForward()
 {DLink cur = first;
  if(first == null)
  System.out.println("The list is empty");
  else
  {System.out.println("The list is : ");
   while (cur!=null)
   {cur.displaylink();
    cur = cur.next;
   }
  }
 }
}
public class dq
{public static void main(String[] args)throws IOException
 {InputStreamReader read = new InputStreamReader(System.in);
  BufferedReader buf = new BufferedReader(read);
  DLinkList s = new DLinkList();
  int c;
  System.out.println("Enter your choice : ");
  do
  {System.out.println("1.Insert First \n2.Insert Last \n3.Delete First \n4.Delete last \n5.Display");
   int n = Integer.parseInt(buf.readLine());
   switch(n)
   {case 1:
    System.out.println("Enter element to be inserted : ");
    int d = Integer.parseInt(buf.readLine());
    s.insertFirst(d);
    break;
    
    case 2:
    System.out.println("Enter element to be inserted : ");
    int d1 = Integer.parseInt(buf.readLine());
    s.insertLast(d1);
    break;
    
    case 3: 
    s.deleteFirst();
    break;
    
    case 4:
    s.deleteLast();
    break;
    
    case 5: 
    s.displayForward();
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
