/**
 * JDBC 연결 테스트
 */

package kr.co.chunjae.persistence;

import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class JDBCTests {

	// 1. 드라이버 연결
	static {
		try {
			
			Class.forName("org.h2.Driver");
			
		} catch (Exception e) {
			
			System.out.println("드라이버 연결 중 오류 발생");
			e.printStackTrace();
			
		}
	}  // static
	
	// 2. DB 연결 테스트
	@Test
	public void testConnection() {
		
		String url = "jdbc:h2:tcp://localhost/~/test";
			String user = "sa";
			String password = "";
		
		try (Connection con = DriverManager.getConnection(url, user, password)) {
				
				log.info(con);				
					
		} catch (Exception e) {
			
			System.out.println("DB 연결 중 오류 발생");
			fail(e.getMessage());
			
		}
		
	}  // testConnection()
	
}  // class
