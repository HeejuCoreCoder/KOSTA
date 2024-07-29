package com.edu.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC4ProcessTest2 {
	public static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	public static final String URL = "jdbc:mysql://127.0.0.1:3306/kosta?serverTimezone=UTC&useUnicode=yes&characterEncoding=UTF-8";
	public static final String USER = "root";
	public static final String PASSWORD = "1234";
			
	public JDBC4ProcessTest2() {
		try {
			//2. 
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("DB Connetion Success....");
			
			//3. INSERT
//			String query = "INSERT INTO custom (id, name, address) VALUES(?,?,?)";
//			PreparedStatement ps =conn.prepareStatement(query);
//			
//			//4.
//			ps.setInt(1, 444);
//			ps.setString(2, "황선우");
//			ps.setString(3, "서울");
//			
//			System.out.println(ps.executeUpdate()+ "ROW INSERT Success....");
			
//			//DELETE...id 값이 2인 사람을 삭제
//			String query = "DELETE FROM custom WHERE id = ?";
//			PreparedStatement ps = conn.prepareStatement(query);
//			System.out.println("PreparedStatement.. 생성");
//			
//			ps.setInt(1, 222);
//			System.out.println(ps.executeUpdate()+"ROW DELETE OK");			
			
			//UPDATE.....id 값이 4인 사람의 정보를 수정..name(오상욱), address(광주)
			//PK는 수정의 대상이 아니다. 
			// WHERE절 뒤에와서 해당 id와 연결된 나머지 컬럼정보를 수정할 수 있다.
//			String query = "UPDATE custom SET name=?, address=? WHERE id=?";
//			
//			PreparedStatement ps = conn.prepareStatement(query);
//			System.out.println("PreparedStatement.. 생성");
//					
//			ps.setString(1, "오상욱");
//			ps.setString(2, "광주");
//			ps.setInt(3, 444);
//			System.out.println(ps.executeUpdate()+"ROW UPDATE OK");
			
			//SELECT...조회하기 
			String query = "SELECT id, name, address FROM custom";
			PreparedStatement ps = conn.prepareStatement(query);
							
			System.out.println("================================ ");
			ResultSet rs=ps.executeQuery();//반환타입 ResultSet: table에 있는 데이타를 이곳에 담아서 반환, table과 동일하게 생겼고 붙어있다.
			while(rs.next()) {
				System.out.println(rs.getInt("id")+","
									+rs.getString("name")+", "
									+rs.getString("address"));//숫자를 넣는 것은 지양, 컬럼명으로 넣는 것으로 하기를 
			}
			System.out.println("================================ ");
			
		}catch(SQLException e) {
			System.out.println("DB Connection Fail....");
		}
	}
	
	public static void main(String[] args) {
		new JDBC4ProcessTest2();
	}
	
	static {
		//1. 드라이버 로딩
		try {
			Class.forName(DRIVER_NAME);
			System.out.println("Driver Loading Success....");		
		}catch(ClassNotFoundException e) {
		System.out.println("Driver Loading Fail....");
		}
	}	
}
