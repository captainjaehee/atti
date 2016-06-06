import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class getData {
	private setDB insert = new setDB();
	private URL url;
	private int pnum = 0;
	public void getInfo(String str, String sinema){
		try {
            url = new URL(str);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        String readLine = null;
        try {
            InputStreamReader isr = new InputStreamReader(url.openStream(), "EUC-KR");
            BufferedReader br = new BufferedReader(isr);
            while ((readLine = br.readLine()) != null) {
                if(readLine.contains("<th><a href=\"/movie/bi/mi/basic.nhn?code=")) {
                    String []split = readLine.split(";\">");
                    String []split2 = split[1].split("</a> <img");
                    System.out.println(split2[0]+"\n");
                    pnum = insert.insertDB_name(split2[0], sinema);
                }
                else if(readLine.contains("onClick=\"clickcr(this,'scd.time',")) {
                    String []split = readLine.split(";\">");
                    String []split1 = split[1].split("</a>");
                    System.out.println(split1[0]+"\n");
                    insert.insertDB_time(split1[0], pnum);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	public void getInfo2(String str, String sinema){
		try {
            url = new URL(str);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        String readLine = null;
        boolean name = false;
        boolean time = false;
        try {
            InputStreamReader isr = new InputStreamReader(url.openStream(), "euc-kr");
            BufferedReader br = new BufferedReader(isr);
            while ((readLine = br.readLine()) != null) {
                if(readLine.contains("<a href=\"/OtherSite/Movie/Movie_GoodsInfo.")) {
                    name = true;
                    continue;
                }
                if(name) {
                    System.out.println(readLine.trim() + "\n");
                    pnum = insert.insertDB_name(readLine.trim(), sinema);
                    name = false;
                }
                if(readLine.contains("N\" class=\"tic\">")) {
                    time = true;
                    continue;
                }
                if(time) {
                    String []split = readLine.split("</a>");
                    System.out.println(split[0].trim() + "\n");
                    insert.insertDB_time(split[0].trim(), pnum);
                    time = false;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	public void getInfo3(String str){
		try {
            url = new URL(str);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
		String readLine = null;
        boolean cur=true;
        try {
            InputStreamReader isr = new InputStreamReader(url.openStream(), "UTF-8");
            BufferedReader br = new BufferedReader(isr);

            while ((readLine = br.readLine()) != null) {
                if(readLine.contains("first_mv_list_link")) {
                    cur=true;
                }
                if(readLine.contains("data-title=")) {
                    String []split = readLine.split("\"");
                    String []split2 = readLine.split("<a href=\"");
                    String []split3 = split2[1].split("><img");
                    String []split4 = readLine.split("src=\"");
                    String []split5 = split4[1].split("\" width=");
                    if(cur)
                    	insert.insertDB_main(split[1], split5[0], "http://movie.naver.com" + split3[0], "cur");
                        //mArray.add(new MovieInfo(split[1], split5[0], "http://movie.naver.com" + split3[0]));
                    else
                    	insert.insertDB_main(split[1], split5[0], "http://movie.naver.com" + split3[0], "exp");
                        //mArray2.add(new MovieInfo(split[1], split5[0], "http://movie.naver.com" + split3[0]));
                }
                if(readLine.contains("second_mv_list_link")) {
                    cur=false;
                }
                else
                    continue;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
