package com.thread;

import java.util.Scanner;

class Thread1 implements Runnable{
	//String name;
	
	boolean flag=true;
	
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	public Thread1() {}
	@Override
	
	public void run() {
		System.out.println("start");
		while(true) {
			if(flag == false) {
			System.out.println("stop");
				break;
				//flag에 조건을 걸어주어서 멈춘다. 
			}
			System.out.println("connect");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("END");
	}
	
}
public class Test3 {
	public static void main(String[] args) throws InterruptedException {
		//runnable 사용하
		
		
		Thread1 r= new Thread1();
		Thread t1 = null;
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("input cmd");
			String cmd = sc.nextLine();
			if(cmd.equals("start")){
			    t1=new Thread(r);
				t1.start();
			}else if (cmd.equals("stop")) {
				r.setFlag(false); //flag를 사용해서 멈춘다. 가능하면 안써도 된다. 
				
			}else {
				break;
			}
			sc.close();
			System.out.println("");
		}
		
//		Thread1 t1 =new Thread1();
//		t1.start();
//		Thread.sleep(10000);
//		t1.setFlag(false);
	}
	

}
