//to find frequency of elements in a linked list and delete duplicates and display the list by user choice using SLL

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
 public int freq(int n)
 {Link cur = first;
  int f = 0;
  while(cur!=null)
  {if(cur.data==n)
   f++;
   cur = cur.next;
  }
  return f;
 }
 public void deldup()
 {Link cur = first;
  Link temp;
  while(cur!=null && cur.next!=null)
  {temp = cur;
   while(temp.next!=null)
   {if(cur.data == temp.next.data)
    temp.next = temp.next.next;
    else 
    temp = temp.next;
   }
   cur = cur.next;
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

public class fredup
{public static void main(String[] args)throws IOException
 {InputStreamReader read = new InputStreamReader(System.in);
  BufferedReader buf  = new BufferedReader(read);
  int c = 0;
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
  {System.out.println("Press \n1.Frequency of a node \n2.Delete duplicates \n3.Display List");
   int b = Integer.parseInt(buf.readLine());
   c = 0;
   switch(b)
   {case 1: System.out.println("Enter the element to find the frequency of ");
            int f1 = Integer.parseInt(buf.readLine());
            int f = s.freq(f1);
            System.out.println("The frequency of " + f1 + " is " + f);
            break;
    case 2: s.deldup();
            System.out.println("The list after removing the duplicates is : ");
            s.displayList();
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
