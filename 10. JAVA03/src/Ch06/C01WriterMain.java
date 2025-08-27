package Ch06;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class C01WriterMain {

	public static void main(String[] args) throws IOException {
//		Writer fout = new FileWriter("c:\\iotest\\test1.txt",false);//덮어쓰기
		Writer fout = new FileWriter("c:\\iotest\\test1.txt",true);
		fout.write("test1\n");
		fout.write("test2\n");
		fout.write("test3\n");

		fout.flush();//이게 없으면 정상적인 입력이 안됨
		
		fout.close();

	}

}
