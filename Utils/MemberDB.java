package tw.frank.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
//COPY from foodDB!
public class MemberDB {
	private static final String USER = "root";	
	private static final String PASSWD = "root";
	private static final String URL = "jdbc:mysql://127.0.0.1/cool";
	private static final String SQL_QUERY = "SELECT * FROM member";//food改member
	private static final String SQL_INSERT = 
		"INSERT INTO member (account,passwd,cname) VALUES (?,?,?)";
	private static final String SQL_LOGIN = 
			"SELECT * FROM member WHERE account = ?";
	
	private Connection conn;
	private ResultSet rs;//查詢
	String[] fieldNames;
	
	public MemberDB() throws Exception {//改MemberDB，然後再去創一個建構式Register.java，將方法帶進去
		Properties prop = new Properties();
		prop.put("user", USER);
		prop.put("password", PASSWD);
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(URL, prop);
		
	}
	
	public int addNew(String account, String passwd, String cname) 
		throws SQLException {
		PreparedStatement pstmt = conn.prepareStatement(SQL_INSERT);
//		return 0;//確認是否回傳成功
		pstmt.setString(1, account);
		pstmt.setString(2, BCrypt.hashpw(passwd, BCrypt.gensalt()));
		pstmt.setString(3, cname);
		
		return pstmt.executeUpdate();
	}
	
	public boolean login(String account, String passwd) throws SQLException{
		PreparedStatement pstmt = conn.prepareStatement(SQL_LOGIN);
		//練習時SQL_LOGIN沒改到出現如下Fail
		//Statement.executeQuery() cannot issue statements that do not produce result sets.
		
		pstmt.setString(1, account);
		ResultSet rset = pstmt.executeQuery();//區域變數，不等同於上方ResultSet rs
		//因為要convert from int to ResultSet，改成布林
		if (rset.next()) {
			String hashPasswd = rset.getString("passwd");
			if (BCrypt.checkpw(passwd, hashPasswd)) {
				return true;
			}else {
				System.out.println("PASSWD FAILURE");
				return false;
			}
		}else {
			System.out.println("ACCOUNT FAILURE");
			return false;
		}
	}
	
	public void queryDB() throws SQLException{
		queryDB(SQL_QUERY);
	}
	public void queryDB(String sql) throws SQLException{//運用String sql
		Statement stmt = conn.createStatement(
				ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_UPDATABLE);
		rs = stmt.executeQuery(sql);
		
		ResultSetMetaData rsmd = rs.getMetaData();
		fieldNames = new String[rsmd.getColumnCount()];
		for (int i=0; i<fieldNames.length; i++) {
			fieldNames[i] = rsmd.getColumnName(i+1);
			//System.out.println(fieldNames[i]);
		}
	}
	public int getRows() {
		try {
			rs.last();
			return rs.getRow();
		}catch(Exception e) {
			return 0;
		}
	}
	public int getCols() {
		return fieldNames.length;
	}
	
	// row => 1-base; col => 1-base
	public String getData(int row, int col) {
		try {
			rs.absolute(row);
			return rs.getString(fieldNames[col-1]);
		}catch(Exception e) {
			return "ERROR";
		}
	}
	
	public String[] getHeader() {return fieldNames;}
	
	public void delRow() throws Exception{
		System.out.println(rs.getRow());
		//rs.deleteRow();
	}
	
	public void updateDB(int row, int col, String value) {
		try {
			rs.absolute(row);
			rs.updateString(col, value);
			rs.updateRow();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void moveNewRow() {
		try {
			rs.moveToInsertRow();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
//彈性夠大，就可以寫成建構式一直套用! memberDB


