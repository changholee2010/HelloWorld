package com.yedam.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class StreamExe {
	public static void main(String[] args) {
		// original2.PNG (1.5M) -> copy3.PNG
		try {
			InputStream is = new FileInputStream("c:/temp/original2.PNG");
			OutputStream os = new FileOutputStream("c:/temp/copy3.PNG");
			// 보조스트림에 연결.
			BufferedInputStream bis = new BufferedInputStream(is);
			BufferedOutputStream bos = new BufferedOutputStream(os);

			// 읽기 - 쓰기.
			while (true) {
				int data = bis.read();
				if (data == -1) {
					break;
				}
				bos.write(data);
			}
			bos.close();bis.close();
			os.close();is.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("end of prog.");
	} // end of main.

	// 복사.
	public static void copy() {
		// 입력 -> 출력.
		try {
			// 입력스트림(original.PNG)
			// 1MB => 1000,000 바이트.
			InputStream is = new FileInputStream("c:/temp/original2.PNG");
			// 출력스트림(copy.PNG)
			OutputStream os = new FileOutputStream("c:/temp/copy2.PNG");
			// 한번에 읽기쓰기 byte[] 만큼 한번에 처리.
			byte[] buf = new byte[10];
			long start = System.currentTimeMillis(); // 시작시점.
			while (true) {
				int data = is.read(buf); // 읽기.
				if (data == -1) { // end of file.
					break;
				}
				os.write(buf); // 쓰기.
			}
			os.close();
			is.close();
			long end = System.currentTimeMillis(); // 종료시점.
			System.out.println("걸린시간: " + (end - start));

		} catch (IOException e) {
			e.printStackTrace();
		}
	} // end of copy.

	// 입력스트림.
	public static void read() {
		// 입력(파일) = 바이트 기반.
		try {
			InputStream is = new FileInputStream("c:/temp/os1.db");
			// read() 1바이트씩 읽기 -1 반환.
			while (true) {
				int data = is.read();
				if (data == -1) {
					break;
				}
				System.out.println(data);
			}
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 출력스트림.
	public static void write() {
		// 출력(파일) = 바이트 기반.
		try {
			OutputStream os = new FileOutputStream("c:/temp/os1.db");
			byte b1 = 10;
			byte b2 = 20;
			byte b3 = 30;
			os.write(b1);
			os.write(b2);
			os.write(b3);
			os.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
