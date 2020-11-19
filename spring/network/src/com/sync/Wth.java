package com.sync;

public class Wth extends Thread{

	Account acc;
	public Wth(Account acc) {
		this.acc=acc;
	}
	@Override
	public void run() {
		//thread
		//계속 출금 
		while(acc.getBalance()>=0) {
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		int money = (int)(Math.random()*9+1)*100;//(100에서 900사이)
				acc.withdraw(money);
		}
			
		}
}
