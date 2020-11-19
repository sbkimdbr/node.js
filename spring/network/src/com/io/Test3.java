package com.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Test3 {

	public static void main(String[] args) throws IOException {
		User user = new User ("id01","subi");
		
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		ObjectOutputStream oos = null;
		
		try {
			fos = new FileOutputStream("user.serial");
			bos = new BufferedOutputStream(fos);
			oos = new ObjectOutputStream(bos);
			oos.writeObject(user);
			System.out.println("Write Complete");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(oos !=null) {
				try {
				
					oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		FileInputStream fis = null;
		BufferedInputStream bis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream ("user.serial");
		bis = new BufferedInputStream (fis);
		ois = new ObjectInputStream(bis);
		User readUser = null;
		readUser = (User)ois.readObject();
		
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(ois != null) {
				try {
					ois.close();
				}catch(IOException e) {
					e.printStackTrace();
				}
								
			}
		}
		System.out.println(fis);
	}

}
