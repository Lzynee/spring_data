/**
 * Author: Lzynee (raina2zen90@gmail.com)
 * Date: Dec 04, 2023
 * Description: 
 * 	JUnit 단위테스트를 위한
 * 	테스트 프로그램을 직접 작성
 */

package kr.co.chunjae.sample;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
// Log4j => 추후 Log4j2로 변경한다.
@Log4j
public class SampleTests {
	
	@Autowired
	private Restaurant restaurant;
	
	@Test
	public void testExist() {
		
		assertNotNull(restaurant);
		
		log.info(restaurant);
		log.info("--------------------------");
		log.info(restaurant.getChef());
				
	}

}
