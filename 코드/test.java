import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class test {
	public static void main(String[] args){
		getData abc = new getData();
		setDB def = new setDB();
		def.DeleteDB_a();
		def.DeleteDB_b();
		def.DeleteDB_c();
		abc.getInfo("http://movie.naver.com/movie/bi/ti/running.nhn?code=168", "�Ե��ó׸� ������");
		abc.getInfo("http://movie.naver.com/movie/bi/ti/running.nhn?code=167", "�Ե��ó׸� ���̰�����");
		abc.getInfo("http://movie.naver.com/movie/bi/ti/running.nhn?code=478", "�ް��ڽ� ������");
		abc.getInfo("http://movie.naver.com/movie/bi/ti/running.nhn?code=451", "�ް��ڽ� ���̰�����");
		abc.getInfo2("http://movie.interpark.com/OtherSite/Movie/Theater/Movie_TheaterInfoDetail.asp?Place=J0053000&Sitecode=00060", "CGV ������");
		abc.getInfo3("http://movie.naver.com/movie/running/current.nhn");
	}
}