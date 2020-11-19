package com.sync;

public class DTh extends Thread {
	
	Account acc;
	public DTh(Account acc) {
		this.acc=acc;
	}
	@Override
	public void run() {
		//thread
		//계속 출금 
		while(acc.getBalance()>=0) {
			try {
				Thread.sleep(90);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		int money = (int)(Math.random()*9+1)*100;//(100에서 900사이)
				acc.deposit(money);
				System.out.println(acc);
			
		}
	}

	
}
