package com.thread;

class TT extends Thread{

	@Override
	public void run() {
		while(true) {
			System.out.println("Thread...");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// TODO Auto-generated method stub
		
	}
	
}

public class Test4 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		TT t = new TT();
		t.setDaemon(true);//main application이 중단되면 멈춘다.
		t.start();
	    //Thread가 완료되지 않은 상태에서 중단된다
		Thread.sleep(1000);
		System.out.println("End Application...");

	}

}
