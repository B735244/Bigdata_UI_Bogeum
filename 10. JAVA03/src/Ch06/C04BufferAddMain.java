package Ch06;

import java.io.Reader;
import java.io.FileReader;
import java.io.IOException;

public class C04BufferAddMain {

	public static void main(String[] args) throws IOException {
		Reader fin = new FileReader("c:\\iotest\\origin.txt");
//		while (true) {
//			int data = fin.read();
//			if(data==-1) {
//				break;
//				System.out.print((char)data);
//			}
//		}
		long startTime = System.currentTimeMillis();
		StringBuffer strBuffer = new StringBuffer();
		char[] buff = new char[4096];

		while (true) {
			int data = fin.read(buff);
			if (data == -1) {
				break;
			}
			strBuffer.append((char)data);
		}

		System.out.println("총길이 :" + strBuffer.length());
		fin.close();

		long endTime = System.currentTimeMillis();
		System.out.println("소요시간 :" + (endTime - startTime) + "ms");
	}

}
