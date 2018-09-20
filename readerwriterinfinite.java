import java.util.Scanner;
import java.util.concurrent.Semaphore;
class ReaderWritter {
		static Semaphore rlock = new Semaphore(1);
		static Semaphore wlock=new Semaphore(1);
		static int rc=0;
		
		static class Read implements Runnable {
			public void run(){
				try{
					//Acquire Section
					rlock.acquire();
					rc++;
					if(rc==1)
					{
						wlock.acquire();
					}
					rlock.release();
					
					//reading section
					System.out.println("Thread "+Thread.currentThread().getName()+" is reading");
					Thread.sleep(1000);
					System.out.println("Thread "+Thread.currentThread().getName()+"has finished");
					rlock.acquire();
					rc--;
					if(rc==0){
						wlock.release();
					}
					rlock.release();
				}catch(InterruptedException e)
				{
					System.out.println(e.getMessage());
				}
			}
		}
		
		static class Write implements Runnable{
			public void run(){
				try{
					wlock.acquire();
					System.out.println("Thread "+Thread.currentThread().getName()+"is writing");
					Thread.sleep(1000);
					System.out.println("Thread "+Thread.currentThread().getName()+"has finished");
					wlock.release();
					
				}catch(InterruptedException e)
				{
					System.out.println(e.getMessage());
				}
			}
		}
	
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int n=0;
		Read read=new Read();
		Write write=new Write();
		while(n==0){
		Thread t1=new Thread(read);
		String str=sc.next();
		t1.setName(str);
		t1.start();
		/*Thread t2=new Thread(read);
		t2.setName("thread2");*/
		Thread t3=new Thread(write);
		String str1=sc.next();
		t3.setName(str1);
		/*Thread t4=new Thread(read);
		t4.setName("thread4");
		Thread t5=new Thread(write);
		t5.setName("thread5");*/
		//t2.start();
		t3.start();}
		//t4.start();
		//t5.start();						
		
		
	}
}