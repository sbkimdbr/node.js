package com.sync;

//
public class Account {
	
	private int balance;
	public Account() {
		this.balance = balance;
	}
    public Account(int i) {
		// TODO Auto-generated constructor stub
	}
	public int getBalance() {
    	return balance;
    	//balance의 데이터를 여러개의 쓰레드가 공유해서 사용
    }
    
	//synchronized 사용함으로 하나의 객체만 접근 가능 하도록 한다.
    public synchronized void deposit(int money) {
    	if(money>0) {
    		try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		balance += money;
    	}
    }
    	public void withdraw(int money) {
    		synchronized (this) {
    			if(balance>=money) {
    			try {
    				Thread.sleep(400);
    			} catch (InterruptedException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
    			balance -= money;
    		}
    		
    		}
    	}
    	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Account[balance="+balance+ "]"; 
	}
	
    }
	
    
	

