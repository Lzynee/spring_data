/**
 * hikariCP 연결 테스트
 */

package kr.co.chunjae.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class DataSourceTests {

	@Autowired
	private DataSource dataSource;
	
	@Test
	public void testConnection() {
		
		try (Connection con = dataSource.getConnection()) {
			
			log.info(con);
			
		} catch (Exception e) {
			
			System.out.println("hikariCP 연결 중 오류 발생");
			fail(e.getMessage());
			
		}  // try-catch
		
	}  // test
}  // class
