//prefix to postfix

import java.io.*;

class OurStack
{int max;
 String[] arr;
 int top;
 public OurStack()
 {}
 public OurStack(int s)
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
 {return (top==-1);
 }
 public boolean isFull()
 {return (top == max-1);
 }

 public String prtopo(String in)
 {String pr = "";
  int l = in.length();
  OurStack obj = new OurStack(l);
  for(int i = l-1; i>=0; i--)
  {char oT = in.charAt(i);
   String opThis = Character.toString(oT);
   if(Character.isLetterOrDigit(oT))
   obj.push(opThis);
   else
   {String m2 = obj.pop();
    String m1 = obj.pop();
    String m3 = m2 + m1 + opThis;
    obj.push(m3);
   }
  }
  pr = obj.pop(); 
  return pr;
 }

}

public class pretopo
{public static void main(String args[])throws IOException
 {InputStreamReader read = new InputStreamReader(System.in);
  BufferedReader buf = new BufferedReader(read);
  System.out.println("Enter a prefix expression : ");
  String in = buf.readLine();
  int l = in.length();
  OurStack obj1 = new OurStack(l);
  String pr = obj1.prtopo(in);
  System.out.println("The postfix expression is : " + pr);
 }
}