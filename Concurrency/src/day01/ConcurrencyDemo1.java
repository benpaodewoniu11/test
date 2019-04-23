package day01;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ConcurrencyDemo1 {
	
	public static void main(String[] args) throws IOException {
//		concurrency();
//		System.out.println();
//		serial();
		File file = new File("D:/file");
		if(!file.exists()){
			file.mkdir();
		}
		File c = new File(file,"file.txt");
		FileWriter f=new FileWriter(c);
		
		f.close();
		System.out.println("over");
	}
	public static void concurrency(){
		long start = System.currentTimeMillis();
		Thread t =new Thread( new Runnable() {
			public void run() {
				long a=0;
				for (long i = 0; i < 500000L; i++) {
					a=a+5;
				}
			}
		});
		t.start();
		try {
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		long time=end -start;
		System.out.println(time);
	}

	public static void serial(){
		long start = System.currentTimeMillis();
				long a=0;
				for (long i = 0; i < 500000L; i++) {
					a=a+5;
				}
		long end = System.currentTimeMillis();
		long time=end -start;
		System.out.println(time);
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("1");
		}
		
	}
}
