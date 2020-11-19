package com.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Test2 {

	public static void main(String[] args) throws IOException {
		String file = "Macintosh HD\\Users\\subikim\\spring\\network\\src\\test.txt";
		FileReader fis = null;
		BufferedReader bis=null;
		FileWriter fos = null;
		BufferedWriter bos=null;
		
		try {
			fis = new FileReader(file);
			
			bis = new BufferedReader(fis);
			
			fos = new FileWriter("test2.rtf");
			
			bos = new BufferedWriter(fos);
			
			
			//파일 읽고 저장하는 구문 
			//bis로 읽고 저장하는것 or fis로 읽고 fos로 저장하는 방
			String data = "";
			
			while((data=bis.readLine())!= null) {
				bos.write(data); //읽어들인것을 저장하겠다.
				System.out.println(data);
			} 
//			while((data=fis.read())!=-1) {
//				fos.write(data); //읽어들인것을 저장하겠다.
//				System.out.println(data);
//			} 
			
			//System.out.println(fis.available());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(bis != null) {
				try {
					bis.close();
				} catch (IOException e) {
										e.printStackTrace();
				}
			}
			if(bos != null) {
				try {
					bos.close();
				} catch (IOException e) {
										e.printStackTrace();
				}
				
			}
		}
		

	}

}
