package com.sus;

import java.util.Scanner;

//밖에 쓰레드 만들면 Test가 가지고 있는 변수를 공유할 수 없다
//근데Test안에 만들면 데이터 공유가능 
class Th extends Thread{
	
	boolean stop = false;
	boolean sus = false;
	
	public void setStop(boolean stop) {
		this.stop =stop;
		
	}
	public void setSus(boolean sus) {
		this.sus =sus;
		
	}

	@Override
	public void run() {
		while(true) {
			
			//쓰레드는 계속돌아감 
			if(stop==true) {
				System.out.println("Stop Thread...");
				break;
			}
		   try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
			if(sus != true) {
				System.out.println("Downloading...");
			}
			//sus가 아니면 다운로드 해
			System.out.println("END THREAD...");
		}
	}
	
	
	
}

public class Test {
	
	

	public static void main(String[] args) {
		Th th = new Th();
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("INPUT CMD");
			String cmd = sc.nextLine();
			
			
			if(cmd.equals("start")) {
				
				th.start();
			}else if (cmd.equals("stop")) {
				th.setStop(true);
			}else if (cmd.equals("sus")) {
				th.setSus(true);
			}else if (cmd.equals("res")){
				th.setSus(false);
			}else if (cmd.equals("q")){
				th.setStop(true);
				break;
			}
		}

		System.out.println("END App.......!");
	}

}
