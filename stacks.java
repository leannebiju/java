import java.io.*;
class OurStack 
{private int max;
 private int[] arr;
 private int top;
 public OurStack(int s)
 {max = s;
  arr = new int[max];
  top = -1;
 }
 public void push(int n)
 {arr[++top] = n;
 }
 public int pop()
 {System.out.println("The element popped is : " + arr[top]);
  return (arr[top--]); 
 }
 public int peek()
 {return arr[top];
 }
 public boolean isEmpty()
 {return(top==-1);
 }
 public boolean isFull()
 {return (top==max-1);
 }
 public void display()
 {if(top==-1)
  System.out.println("The stack is empty");
  else
  {System.out.println("The elements of the stack are :");
   for(int i = top; i>=0; i--)
   System.out.println(arr[i]);
  }
 }
}
class stacks 
{public static void main(String[] args)throws IOException
 {InputStreamReader read = new InputStreamReader(System.in);
  BufferedReader buf  = new BufferedReader(read);
  int c = 0;
  OurStack obj = new OurStack(50);
  do
  {System.out.println("Press \n1.To Push element into stack \n2.Pop element from Stack \n3.To display the topmost element");
   int s = Integer.parseInt(buf.readLine());
   c = 0;
   switch(s)
   {case 1: if(!obj.isFull())
            {System.out.println("Enter element to be pushed into the stack : ");
             int m = Integer.parseInt(buf.readLine());
             obj.push(m);
            }
            else
            {System.out.println("Stack Overflow. Try Again.");
             c = 1;
            }
            break;
    case 2: if(!obj.isEmpty())
            obj.pop();
            else
            {System.out.println("Stack Underflow. Try Again.");
             c = 1;
            }
            break;
    case 3: int k = obj.peek();
            System.out.println("The topmost element is : " + k);
            break;
    default: System.out.println("Wrong Choice. \nPlease try again");
             c = 1;
   } 
   if(c!=1)
   {System.out.println("Press 1 to continue. Any other key to exit.");
    c = Integer.parseInt(buf.readLine());
   }
  }while(c==1);
  System.out.println("You have successfully exited the stack.");
  obj.display();
 }
}
