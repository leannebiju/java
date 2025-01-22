//to create a list and then add functions to sort, display, reverse the list

import java.io.*;

class Link
{char data;
 Link next;
 public Link(char d)
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
  if(first!=null)
  {while(cur!=null)
   {cur.displaylink();
    cur = cur.next;
   }
  }
  else
  System.out.println("Empty List");
 }
 public int reverse()
 {Link prev = null;
  Link cur = first;
  Link next = null;
  if(isEmpty())
  return 2;
  while(cur!=null)
  {if(Character.isLetter(cur.data))
   {next = cur.next;
    cur.next = prev;
    prev = cur;
    cur = next;
   }
   else 
   return 0;
  }
  first = prev;
  return 1;
 }
 public int sortlist()
 {Link cur = first, p = null;
  char temp;
  if(isEmpty())
  return 2;
  else
  {while(cur!=null)
   {if(Character.isLetter(cur.data))
    {p = cur.next;
     while(p!=null)
     {if(cur.data>p.data)
      {temp = cur.data;
       cur.data = p.data;
       p.data = temp;
      }
      p = p.next;
     }
    }
    else 
    return 0;
    cur = cur.next;
   }
  }
  return 1;
 }
}

public class revsor
{public static void main(String[] args)throws IOException
 {InputStreamReader read = new InputStreamReader(System.in);
  BufferedReader buf = new BufferedReader(read);
  int c = 0;
  LinkList s = new LinkList();
  do
  {System.out.println("Press \n1.Sort \n2.Reverse \n3.Display the list \n4.To insert");
   int b = Integer.parseInt(buf.readLine());
   c = 0; int k;
   switch(b)
   {case 1: k = s.sortlist();
            if(k==1)
            {System.out.println("The sorted list is : ");
             s.displayList();
            }
            else if(k==0) 
            System.out.println("Encountered a character that is not a letter");
            else
            System.out.println("Empty List");
            break;
    case 2: k = s.reverse();
            if(k==1)
            {System.out.println("The reversed list is : ");
             s.displayList();
            }
            else if(k==0) 
            System.out.println("Encountered a character that is not a letter");
            else
            System.out.println("Empty List");
            break;
    case 3: System.out.println("The list is : ");
            s.displayList();
            break;
    case 4: int nc;
            do
            {System.out.println("Enter the element");
             char q = buf.readLine().charAt(0);
             Link nl = new Link(q);
             s.insertLast(nl);
             System.out.println("Press 1 to continue");
             nc = Integer.parseInt(buf.readLine());
            }
            while(nc==1);
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
