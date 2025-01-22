//to check if an entered string is palindrome or not using stack

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
 public boolean isEmpty()
 {return(top==-1);
 }
 public boolean isFull()
 {return (top==max-1);
 }
}
class rev
{public static void main(String[] args)throws IOException
 {InputStreamReader read = new InputStreamReader(System.in);
  BufferedReader buf  = new BufferedReader(read);
  String s1, s2, s3 ="";
  System.out.println("Enter the string : ");
  s1 = buf.readLine();
  s2 = s1.toLowerCase();
  int l = s2.length();
  char m = ' ';
  OurStack obj = new OurStack(l);
  int i = 0;
  while(!obj.isFull())
  {obj.push(s2.charAt(i));i++;
  }
  i = l-1;
  while(!obj.isEmpty())
  {m = obj.pop();
  s3= s3+m;
  }
  System.out.println(s2);
  if(s3.compareTo(s2)==0)
  System.out.println("The word is a palindrome");
  else
  System.out.println("The word is not a palindrome");
 }
}
