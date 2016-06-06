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
		abc.getInfo("http://movie.naver.com/movie/bi/ti/running.nhn?code=168", "롯데시네마 구미점");
		abc.getInfo("http://movie.naver.com/movie/bi/ti/running.nhn?code=167", "롯데시네마 구미공단점");
		abc.getInfo("http://movie.naver.com/movie/bi/ti/running.nhn?code=478", "메가박스 구미점");
		abc.getInfo("http://movie.naver.com/movie/bi/ti/running.nhn?code=451", "메가박스 구미강동점");
		abc.getInfo2("http://movie.interpark.com/OtherSite/Movie/Theater/Movie_TheaterInfoDetail.asp?Place=J0053000&Sitecode=00060", "CGV 구미점");
		abc.getInfo3("http://movie.naver.com/movie/running/current.nhn");
	}
}