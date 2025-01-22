//Create 2 DLL and merge a list into another list at alternate positions

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
{DLink first;
 DLink last;
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
 public void insert(int d, DLink cur)
 {DLink nl = new DLink(d);
  if(cur == null)
  {nl.prev = last;
   last.next = nl;
   last = nl;
  }
  else
  {nl.prev = cur.prev;
   cur.prev.next = nl;
   nl.next = cur;
   cur.prev = nl;
  }
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
public class pro2
{public static void main(String[] args)throws IOException
 {InputStreamReader read = new InputStreamReader(System.in);
  BufferedReader buf = new BufferedReader(read);
  DLinkList p = new DLinkList();
  DLinkList q = new DLinkList();
  int n;
  System.out.println("First List : ");
  do
  {System.out.println("Enter element to be inserted : ");
   int d = Integer.parseInt(buf.readLine());
   p.insertLast(d);
   System.out.println("Press 1 to continue.");
   n = Integer.parseInt(buf.readLine());
  }
  while(n == 1);
  System.out.println("Second List : ");
  do
  {System.out.println("Enter element to be inserted : ");
   int d = Integer.parseInt(buf.readLine());
   q.insertLast(d);
   System.out.println("Press 1 to continue.");
   n = Integer.parseInt(buf.readLine());
  }
  while(n == 1);
  System.out.println("The first list : ");
  p.displayForward();
  System.out.println("The second list : ");
  q.displayForward();
  DLink tempp = p.first;
  DLink tempq = q.first;
  while(tempp!=null || tempq!=null)
  {if(tempp!=null)
   {tempp = tempp.next;
   }
   if(tempq!=null)
   {p.insert(tempq.data, tempp);
    tempq = tempq.next;
   }
  }
  System.out.println("The merged list is : ");
  p.displayForward();
 }
}
