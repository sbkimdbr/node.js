package com.thread;

class T extends Thread{
	String name;
	
	public T() {}
	public T(String name) {
		this.name=name;
	}
	
	@Override
	public void run() {
		for(int i=0;i<=100;i++) {
			System.out.println(name+""+i);
			try {
				Thread.sleep(200);//0.2sec waiting 이 후 다시 돌아오게 함 
				                  //이 때에는 다른 기능이 실행됨 
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
		
	}
	
}

public class Test {

	public static void main(String[] args) {
		T t1 = new T("T1");
		t1.start();
		T t2 = new T("T2");
		t2.start();
		
	}

}
