import java.io.*;
class OurStack 
{private int max;
 private char[] arr;
 private int top;
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
 {return(top==-1);
 }
 public boolean isFull()
 {return (top==max-1);
 }
}
class delimiter 
{public static void main(String[] args)throws IOException
 {InputStreamReader read = new InputStreamReader(System.in);
  BufferedReader buf  = new BufferedReader(read);
  System.out.println("Enter the expression to check delimiter match : ");
  String s1 = buf.readLine();
  int l = s1.length();
  char m = ' ';
  OurStack obj = new OurStack(l);
  int c = 1;
  int k = 0;
  for(int i = 0; i<l; i++)
  {m = s1.charAt(i);
   switch(m)
   {case '(':
    case '{':
    case '[': obj.push(m);
              k++;
              break;
    case ')': if(obj.peek() == '(')
              {if(!obj.isEmpty())
               obj.pop();
              }
              else 
              c = 0;
              break;
    case '}': if(obj.peek() == '{')
              {if(!obj.isEmpty())
               obj.pop();
              }
              else 
              c = 0;
              break;
    case ']': if(obj.peek() == '[')
              {if(!obj.isEmpty())
               obj.pop();
              }
              else 
              c = 0;
              break;
   default : ;
   }
   if((i!=0) && obj.isEmpty() && (i!=(l-1)))
   c = 0;
   if(c == 0)
   break;
  } 
  if(!obj.isEmpty())
  c = 0;
  if(k==0)
  c = 1;
  if(c==0)
  System.out.println("Delimiter not matching");
  else 
  System.out.println("Delimiter matching");
 }
}
