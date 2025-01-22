import java.io.*;
class OurStack 
{private int max;
 private char[] arr;
 private int top;
 public OurStack()
 {}
 public OurStack(int s)
 {max = s;
  arr = new char[max];
  top = -1;
 }
 public void push(char n)
 {arr[++top] = n;
 }
 public char pop()
 {return (arr[top--]); 
 }
 public boolean isEmpty()
 {return(top==-1);
 }
 public int pre(char o)
 {int z = 0;
  switch(o)
  {case '^': z = 3;
             break;
   case '+': 
   case '-': z = 1;
             break;
   case '*':
   case '/': z = 2;
  }
  return z;
 }
 public boolean isOperator(char p)
 {if(p == '+' || p=='-' || p=='*' || p == '/' || p=='^')
  return true;
  return false;
 }
 public String intopo(String s1, int z)
 {String s2 = "";
  int l = s1.length();
  OurStack obj = new OurStack(l);
  for(int i = 0; i<l; i++) 
  {char m = s1.charAt(i);
   if(isOperator(m))
   {char opThis = m;
    if(obj.isEmpty())
    obj.push(opThis);
    else
    {while(!obj.isEmpty())
     {char opTop = obj.pop();
      int k = 0;
      if(opThis == '(')
      obj.push(opThis);
      else if(opThis!=0 && z==1)
      {if(obj.pre(opTop)<obj.pre(opThis))
       {k = 1;
        obj.push(opTop);
       }
       if(obj.pre(opTop)>=obj.pre(opThis))
       s2 = s2 + opTop;
      }
      else if(opThis!=0 && z==2)
      {if(obj.pre(opTop)<=obj.pre(opThis))
       {k = 1;
        obj.push(opTop);
       }
       if(obj.pre(opTop)>obj.pre(opThis))
       s2 = s2 + opTop;
      }
      if(k==1 || opThis=='(')
      break;
     }
     obj.push(opThis);
    }
   }
   else if(m=='(')
   obj.push(m);
   else if(m == ')')
   {while(!obj.isEmpty())
    {char q = obj.pop();
     if(q=='(')
     break;
     else 
     s2 = s2 + q;
    }
   }
   else 
   s2 = s2 + m; 
  }
  while(!obj.isEmpty())
  {char c = obj.pop();
   s2 =s2 + c;
  }
  return s2;
 }
 String rev(String s1)
 {String s2 = "";
  int l = s1.length();
  for(int i = 0; i<l; i++)
  {char c = s1.charAt(i);
   if(c == ')')
   c = '(';
   else if(c=='(')
   c = ')';
   s2 = c + s2;
  }
  return s2;
 }
}
class OurStack1
{private int max;
 private String[] arr;
 private int top;
 public OurStack1()
 {}
 public OurStack1(int s)
 {max = s;
  arr = new String[max];
  top = -1;
 }
 public void push(String n)
 {arr[++top] = n;
 }
 public String pop()
 {return (arr[top--]); 
 }
 public boolean isEmpty()
 {return(top==-1);
 }
 public String topo(String s1)
 {String s2 = "", s3 = "", s4 = "";
  int l = s1.length();
  OurStack1 ob = new OurStack1(l);
  for(int i = l-1; i>=0; i--)
  {char m = s1.charAt(i);
   if(m == '+' || m=='-' || m=='*' || m=='/' || m=='^')
   {s2 = ob.pop();
    s3 = ob.pop();
    s4 = s2 + s3 + m;
    ob.push(s4);
   }
   else
   ob.push(m+"");
  }
  return s4;
 }
}
public class conversions
{public static void main(String[] args)throws IOException
 {InputStreamReader read = new InputStreamReader(System.in);
  BufferedReader buf = new BufferedReader(read);
  int n = 0;
  do
  {System.out.println("Press \n1. To convert infix to postfix \n2. To convert infix to prefix \n3. To convert prefix to postfix");
   int c = Integer.parseInt(buf.readLine());
   String s1, s2 ="";
   if(c==1 || c==2 || c==3)
   {System.out.println("Enter the expression to be converted : ");
    s1 = buf.readLine();
    OurStack obj1 = new OurStack();
    OurStack1 obj2 = new OurStack1();
    switch(c)
    {case 1: s2 = obj1.intopo(s1,1);
             System.out.println("The postfix expression is : \n" + s2);
             break;
     case 2: s1 = obj1.rev(s1);
             s2 = obj1.intopo(s1,2);
             s2 = obj1.rev(s2);
             System.out.println("The prefix expression is : \n" + s2);
             break;
     case 3: s2 = obj2.topo(s1);
             System.out.println("The postfix expression is : \n" + s2);
    }  
   }
   else
   System.out.println("Invalid choice. Please try again."); 
   System.out.println("Press 1 to continue. Any other key to exit.");
   n = Integer.parseInt(buf.readLine());
  }
  while(n==1);
 }
}
