package com.thread;
//Join example 
//p.535
//join 의 실행이 어떤 순서로 되는지 확인할 수 있다.

//1.Thread 생성
//2.run override 생성 
class Th1 extends Thread{

	int sum;
	@Override
	public void run() {
		for(int i=0;i<=20;i++) {
			System.out.println("Th1 started...");

			sum+=i;
						try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public int getSum(){
		return sum;
	}
	
}

class Th2 extends Thread{
	
	int sum;
	@Override
	public void run() {
		for(int i=0;i<=40;i++) {
			System.out.println("TH2 started...!!");
			sum+=i;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public int getSum(){
		return sum;
	}
	
}

public class Test5 {

	public static void main(String[] args) throws InterruptedException {
		Th1 th1 = new Th1();
		Th2 th2 = new Th2();
		System.out.println("start...");
		th1.start();
		
		System.out.println("Th1...");
		
		
		th2.start();
		System.out.println("Th2...");
		th2.join();
		th1.join();
		
		System.out.println(th1.getSum()+" "+th2.getSum());
		System.out.println(th1.getSum()+th2.getSum());
		
		

	}

}
