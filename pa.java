//Polynomial addition

import java.io.*;

class Link
{int coeff;
 int exp;
 Link next;
 public Link (int c, int e)
 {coeff = c;
  exp = e;
  next = null;
 }
 public void displaylink()
 {System.out.print(coeff + "x^"+ exp);
 }
}

class Linklist
{Link first;
 public Linklist()
 {first = null;
 }
 public boolean isEmpty()
 {return (first==null);
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
 public void displaylist()
 {Link cur = first;
  while(cur!=null)
  {if(cur!=first)
   System.out.print(" + ");
   cur.displaylink();
   cur = cur.next;
  }
 }
 public void insertelements(Linklist m)throws IOException
 {int n = 1;int coeff; int exp;
  while(n==1)
  {InputStreamReader read = new InputStreamReader(System.in);
   BufferedReader buf  = new BufferedReader(read);
   System.out.println("Enter the coefficient : ");
   coeff = Integer.parseInt(buf.readLine());
   System.out.println("Enter the exponent : ");
   exp = Integer.parseInt(buf.readLine());
   Link nl = new Link(coeff,exp);
   m.insertLast(nl);
   System.out.println("Press 1 to continue inserting terms. Any other key to exit.");
   n = Integer.parseInt(buf.readLine());
  }
 }
}

public class pa
{public static void main(String[] args)throws IOException
 {Linklist p = new Linklist();
  Linklist q = new Linklist();
  Linklist r = new Linklist();
  System.out.println("Enter the terms of the first polynomial : ");
  p.insertelements(p);
  System.out.println("Enter the terms of the second polynomial : ");
  q.insertelements(q);
  System.out.println("The first polynomial is : ");
  p.displaylist();
  System.out.println();
  System.out.println("The second polynomial is : ");
  q.displaylist();
  int c = 0; int e = 0;
  Link tempp = p.first;
  Link tempq = q.first;
  while(tempp!=null || tempq!=null)
  {if(tempp!=null && tempq!=null && tempp.exp == tempq.exp)
   {c = tempp.coeff + tempq.coeff;
    e = tempp.exp;
    tempp = tempp.next;
    tempq = tempq.next;
   }
   else if((tempq==null) || (tempp.exp>tempq.exp))
   {c = tempp.coeff;
    e = tempp.exp;
    tempp = tempp.next;
   }
   else if((tempp==null) || (tempq.exp>tempp.exp))
   {c = tempq.coeff;
    e = tempq.exp;
    tempq = tempq.next;
   }
   Link n1 = new Link(c,e);
   r.insertLast(n1);
  }
  System.out.println();
  System.out.println("The sum of the 2 polynomials is : ");
  r.displaylist();
 }
}
