//program to find GCD using stack

import java.io.*;

class OurStack
{int max;
 int[] arr;
 int top;
 public OurStack(int s)
 {max = s;
  arr = new int[max];
  top = -1;
 }
 public void push(int n)
 {arr[++top] = n;
 }
 public int pop()
 {return (arr[top--]);
 }
 public int peek()
 {return arr[top];
 }
 public boolean isEmpty()
 {return (top==-1);
 }
}

public class gcd
{public static void main(String args[])throws IOException
 {InputStreamReader read = new InputStreamReader(System.in);
  BufferedReader buf = new BufferedReader(read);
  System.out.println("Enter two numbers : ");
  int n1 = Integer.parseInt(buf.readLine());
  int n2 = Integer.parseInt(buf.readLine());
  OurStack a = new OurStack(n1);
  OurStack b = new OurStack(n2);
  for(int i = 1; i<=n1; i++)
  {if((n1%i) == 0)
   a.push(i);
  }
  for(int i = 1; i<=n1; i++)
  {if((n1%i) == 0)
   a.push(i);
  }
  for(int i = 1; i<=n2; i++)
  {if((n2%i) == 0)
   b.push(i);
  }
  int GCD = 1;
  while(true)
  {int s1 = a.peek();
   int s2 = b.peek();
   if(s1==s2)
   {GCD = s1;
    break;
   }
   else if(s1>s2)
   a.pop();
   else 
   b.pop();
  }
  System.out.println("The GCD of the 2 numbers is : " + GCD);
 }
}