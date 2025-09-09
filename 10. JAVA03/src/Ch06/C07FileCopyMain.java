package Ch06;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

public class C07FileCopyMain {

	private static final String PATH = "c:\\iotest\\";
;
	public static void main(String[] args) throws Exception {
		// args[0] : 원본파일경로
		// args[1] : 복사대상경로
		
		InputStream fin = new FileInputStream(PATH + args[0]);
		OutputStream fout = new FileOutputStream(PATH + args[1]);
		long startTime = System.currentTimeMillis();
		byte [] buff = new byte[4096];//버퍼 만들어줘서 소요시간을 확 줄여줘야함 단위를 늘리면 늘릴수록 빨라짐
		
		while (true) {

			int data = fin.read(buff);
			if (data == -1)
				break;
			fout.write(buff,0,data);//0부터 읽어들인 data만큼!
			fout.flush();

		}
		fout.close();
		fin.close();
		long endTime = System.currentTimeMillis();
		System.out.println("소요시간 :" + (endTime - startTime)+"ms");
	}

}
