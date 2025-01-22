import java.io.*;
class cirque
{private int max;
 private int[] arr;
 private int front;
 private int rear;
 public cirque(int s)
 {max = s+1;
  arr = new int[max];
  front = 0;
  rear = -1;
 }
 public void insert(int n)
 {rear = (rear+1) % max;
  arr[rear] = n;
 }
 public int remove()
 {int n = arr[front];
  front = (front+1) % max;
  return n;
 }
 public boolean isFull()
 {return (((rear+2)%max)==front);
 }
 public boolean isEmpty()
 {return (((rear+1)%max)==front);
 }
 public int peek()
 {return arr[front];
 }
 public int size()
 {if(rear>=front)
  return (rear-front+1);
  else
  return ((max-front)+(rear+1));
 }
 public void display()
 {if(isEmpty())
  {System.out.println("Queue is empty");
  }
  else
  {int i = front;
   while(i!=rear)
   {System.out.println(arr[i]);
    i++;
    if(i == max)
    i = 0;
   }
   System.out.println(arr[i]);
  }
 }
}
class cirq 
{public static void main(String[] args)throws IOException
 {InputStreamReader read = new InputStreamReader(System.in);
  BufferedReader buf  = new BufferedReader(read);
  int c = 0;
  System.out.println("Enter the number of elements in the queue : ");
  int p = Integer.parseInt(buf.readLine());
  cirque obj = new cirque(p);
  do
  {System.out.println("Press \n1.Enqueue \n2.dequeue \n3.Peek \n4.Display");
   int s = Integer.parseInt(buf.readLine());
   c = 0;
   switch(s)
   {case 1: if(!obj.isFull())
            {System.out.println("Enter element to be enqueued : ");
             int m = Integer.parseInt(buf.readLine());
             obj.insert(m);
            }
            else
            {System.out.println("Queue Full. Try Again.");
             c = 1;
            }
            break;
    case 2: if(!obj.isEmpty())
            {int w = obj.remove();
             System.out.println("The dequeued element is : " + w);
            }
            else
            {System.out.println("Queue Empty. Try Again.");
             c = 1;
            }
            break;
    case 3: int k = obj.peek();
            System.out.println("The front element is : " + k);
            break;
    case 4: System.out.println("The queue is : ");
            obj.display();
            break;
    default: System.out.println("Wrong Choice. \nPlease try again");
             c = 1;
   } 
   if(c!=1)
   {System.out.println("Press 1 to continue. Any other key to exit.");
    c = Integer.parseInt(buf.readLine());
   }
  }while(c==1);
  System.out.println("You have successfully exited the queue.");
  obj.display();
 }
}
