//Create a DLL of integers 
//Write a menu driven program to implement the following
//a)Insert a DLink in the nth position from the end of DLL
//b)Delete the nth DLink from the beginning of the DLL
//c)Display the middle element of the DLL and replace the middle element with a given number
//d)Rearrange the list by placing all the odd numbers then the even numbers

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
 public void insertendn(int d, int n)
 {DLink nl = new DLink(d);
  if(first == null)
  first = last = nl;
  else
  {DLink cur = last;
   int i;
   for(i = 1;i<n; i++)
   cur = cur.prev;
   if(cur == null && i==n)
   {first.prev = nl;
    nl.next = first;
    first = nl;
   }
   else
   {nl.next = cur.next;
    if(cur.next!=null)
    cur.next.prev = nl;
    cur.next = nl;
    nl.prev = cur;
    if(nl.next==null)
    last = null;
   }
  }
 }
 public void deletenth(int n)
 {DLink cur = first;
  if(cur == null)
  {System.out.println("List empty. No element to be deleted.");
  }
  else
  {for(int i = 1; i<n; i++)
   cur = cur.next;
   if(first == last)
   {first = null;
    last = null;
    System.out.println("List is now empty. All items are deleted."); 
   }
   else if(cur == first)
   {first = cur.next;
    first.prev = null;
   }
   else if(cur == last)
   {last = cur.prev;
    last.next = null;
   }
   else
   {cur.prev.next = cur.next;
    cur.next.prev = cur.prev;
   }
  }
 }
 public void displaymiddle(int d)
 {int count = 1, mid;
  DLink cur = first;
  while(cur!=null)
  {count++;
   cur = cur.next;
  }
  mid = count/2;
  cur = first;
  if(count%2!=0)
  {count = 1;
   while(count!=mid+1)
   {count++;
    cur = cur.next;
   }
  }
  else
  {count = 1;
   while(count!=mid)
   {count++;
    cur = cur.next;
   }
  }
  System.out.println("The old middle element is : ");
  cur.displaylink();
  cur.data = d;
 }
 public void oddeven()
 {int count = 1;
  DLink cur = first;
  while(cur!=null)
  {count++;
   cur = cur.next;
  }
  for(int i = 0; i<count; i++)
  {cur = first;
   while(cur.data%2 != 0)
   {cur = cur.next;
   }
   if(cur == first)
   {first = first.next;
    cur.next.prev = null;
    cur.prev = null;
   }
   else if(cur == last)
   {continue;
   }
   else
   {cur.prev.next = cur.next;
    cur.next.prev = cur.prev;
   }
   cur.prev = last;
   cur.next = null;
   last.next = cur;
   last = cur;
  }
 }
}
public class pro1
{public static void main(String[] args)throws IOException
 {InputStreamReader read = new InputStreamReader(System.in);
  BufferedReader buf = new BufferedReader(read);
  DLinkList s = new DLinkList();
  int c;
  System.out.println("Enter your choice : ");
  do
  {System.out.println("1.Insert element \n2.Display list \n3.Insert element at nth poition from th end \n4.Delete nth element from the beginning \n5.Find and replace the middle element of the list \n6.Sort the list with odd numbers and then even numbers.");
   int n = Integer.parseInt(buf.readLine());
   switch(n)
   {case 1:
    System.out.println("Enter element to be inserted : ");
    int d = Integer.parseInt(buf.readLine());
    s.insertLast(d);
    break;
    
    case 2:
    s.displayForward();
    break;
    
    case 3: 
    System.out.println("Enter element to be inserted and the position of the node from the end : ");
    int d1 = Integer.parseInt(buf.readLine());
    int no = Integer.parseInt(buf.readLine());
    s.insertendn(d1,no);
    System.out.println("The list after insertion : ");
    s.displayForward();
    break;
    
    case 4:
    System.out.println("Enter the position from which the element is to be deleted : ");
    int no1 = Integer.parseInt(buf.readLine());
    s.deletenth(no1);
    System.out.println("The list after deletion : ");
    s.displayForward();
    break;
    
    case 5: 
    System.out.println("Enter the element to replace the middle element with : ");
    int d2 =Integer.parseInt(buf.readLine());
    s.displaymiddle(d2);
    System.out.println("The list after replacing middle element : ");
    s.displayForward();
    break;
    
    case 6:
    s.oddeven();
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
