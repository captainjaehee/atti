import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class setDB {
	public void DeleteDB_a()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection
			("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=EUCKR", "root","apmsetup");
			Statement stmt = conn.createStatement();
			String sql = "Delete from abc";
			stmt.executeUpdate(sql);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void DeleteDB_b()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection
			("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=EUCKR", "root","apmsetup");
			Statement stmt = conn.createStatement();
			String sql = "Delete from def";
			stmt.executeUpdate(sql);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void DeleteDB_c()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection
			("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=EUCKR", "root","apmsetup");
			Statement stmt = conn.createStatement();
			String sql = "Delete from ghi";
			stmt.executeUpdate(sql);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int insertDB_name(String name, String sinema)
	{
		int num = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection
			("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=EUCKR", "root","apmsetup");
			Statement stmt = conn.createStatement();
			String sql = "Insert abc(name, sinema) values ('" +  name  + "','" + sinema + "')";
			stmt.executeUpdate(sql);
			ResultSet rs = stmt.executeQuery("select num from abc where name ='" + name + "'");
			while(rs.next()){
				System.out.println(rs.getInt("num"));
				num = rs.getInt("num");
			}
			return num;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	public void insertDB_time(String time, int num)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection
			("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=EUCKR", "root","apmsetup");
			Statement stmt = conn.createStatement();
			String sql = "Insert def(time, movie_num) values ('" +  time  + "'," + num + ")";
			stmt.executeUpdate(sql);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void insertDB_main(String name, String url, String img, String cur)
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection
			("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=EUCKR", "root","apmsetup");
			Statement stmt = conn.createStatement();
			String sql = "Insert ghi(name,url,img,cur) values ('" +  name  + "','" + url + "','" + img + "','" + cur + "')";
			stmt.executeUpdate(sql);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
