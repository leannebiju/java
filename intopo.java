//infix to postfix

import java.io.*;

class OurStack
{int max;
 char[] arr;
 int top;
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
 {return (top==-1);
 }
 public boolean isFull()
 {return (top == max-1);
 }

 public boolean isOperator(char m)
 {switch(m)
  {case '+':
   case '-':
   case '*':
   case '/':
   case '^': return true;
  }
  return false;
 }

 public int pre(char o)
 {int z = 0;
  switch(o)
  {case '^': z = 3; break;
   case '+': case '-': z = 1; break;
   case '*': case '/': z = 2;
  }
  return z;
 }

 public String intopos(String in)
 {String po = "";
  int l = in.length();
  OurStack obj = new OurStack(l);
  for(int i = 0; i<l; i++)
  {char opThis = in.charAt(i);
   if(Character.isLetterOrDigit(opThis))
   po = po + opThis;
   if(opThis == '(')
   obj.push(opThis);
   if(opThis == ')')
   {while(!obj.isEmpty())
    {char opTop = obj.pop();
     if(opTop == '(')
     break;
     else 
     po = po + opTop;
    }
   }
   if(isOperator(opThis))
   {if(obj.isEmpty())
    obj.push(opThis);
    else
    {while(!obj.isEmpty())
     {char opTop = obj.pop();
      if(opTop == '(')
      {obj.push(opTop);
      }
      else
      {if(pre(opTop)<pre(opThis))
       obj.push(opTop);
       else 
       po = po + opTop;
      }
      if ((pre(opTop)<pre(opThis)) || opTop == '(')
      break;
     }
     obj.push(opThis);
    }
   }
  }
  while(!obj.isEmpty())
  {char o = obj.pop();
   po = po + o;
  }
  return po; 
 }

}

public class intopo
{public static void main(String args[])throws IOException
 {InputStreamReader read = new InputStreamReader(System.in);
  BufferedReader buf = new BufferedReader(read);
  System.out.println("Enter an infix expression : ");
  String in = buf.readLine();
  int l = in.length();
  OurStack obj1 = new OurStack(l);
  String po = obj1.intopos(in);
  System.out.println("The postfix expression is : " + po);
 }
}