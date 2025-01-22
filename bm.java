//Bracket match - modified and simpler version

import java.io.*;

class OurStack //Defining stack class
{int max;
 char[] arr;
 int top;
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
 public char peek()
 {return arr[top];
 }
 public boolean isEmpty()
 {return (top==-1);
 }
}

public class bm
{public static void main(String args[])throws IOException
 {InputStreamReader read = new InputStreamReader(System.in);
  BufferedReader buf = new BufferedReader(read);
  System.out.println("Enter an expression : ");
  String exp = buf.readLine();
  int l = exp.length();
  int v = 1;//flag variable - used to exit if the bracket is not matched
  int count = 0; //to count number of opened brackets - subtracted when corresponding closed bracket is found. If all opened brackets are closed then count = 0
  OurStack s = new OurStack(l);
  for(int i = 0; i<l; i++)
  {char m = exp.charAt(i);
   if(m == '(' || m == '{' || m == '[')
   {s.push(m);
    count++;
   }
   else if(m == ')' || m == '}' || m == ']')
   {if(!s.isEmpty())
    {char p = s.pop();//to store the topmost bracket in the stack
     switch(m)
     {case ')': if(p == '(')
                count--;
                else 
                v = 0;
                break;
      case ']': if(p == '[')
                count--;
                else 
                v = 0;
                break;
      case '}': if(p == '{')
                count--;
                else 
                v = 0;
     }
    }
    else
    v = 0;//setting v = 0 if closing bracket is found but no opening bracket
   }
   if(v==0)
   break;//exiting the loop if any of the conditions give invalidity
  }   
  if(v==0 || count!=0 || !s.isEmpty())
  System.out.println("No match");
  else
  System.out.println("Brackets matched");
 }
}