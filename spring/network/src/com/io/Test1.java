package com.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Test1 {

	public static void main(String[] args) throws IOException {
		String file = "c:\\src\\test.rtf";
		FileInputStream fis = null;
		BufferedInputStream bis=null;
		FileOutputStream fos = null;
		BufferedOutputStream bos=null;
		
		try {
			fis = new FileInputStream(file);
			
			bis = new BufferedInputStream(fis);
			
			fos = new FileOutputStream("test2.rtf");
			
			bos = new BufferedOutputStream(fos);
			
			
			//파일 읽고 저장하는 구문 
			//bis로 읽고 저장하는것 or fis로 읽고 fos로 저장하는 방
			int data = 0;
			
			while((data=bis.read())!=-1) {
				bos.write(data); //읽어들인것을 저장하겠다.
				System.out.println((char)data);
			} 
//			while((data=fis.read())!=-1) {
//				fos.write(data); //읽어들인것을 저장하겠다.
//				System.out.println(data);
//			} 
			
			System.out.println(fis.available());
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
