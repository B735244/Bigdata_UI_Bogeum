package Ch06;

import java.io.BufferedInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Writer;
import java.net.URI;
import java.net.URL;

public class C08URLStreamMain {

	public static void main(String[] args) throws Exception {
	URL url = (new URI("https://n.news.naver.com/mnews/article/082/0001341915?sid=102")).toURL();
InputStream input = url.openStream();

//보조스트림추가
BufferedInputStream buffIn =  new BufferedInputStream(input);
Reader rdinput = new InputStreamReader(buffIn);//byte -> char 변환시켜줌
Writer fout = new FileWriter("c:\\iotest\\index.html");
	while(true) {
		int data = rdinput.read();
		if(data==-1) {
			break;
			
		
		
		}
//		System.out.print((char)data);	
		fout.write((char)data);
		fout.flush();
	}
	fout.close();
	rdinput.close();
	buffIn.close();
	input.close();
	}

}
