import java.io.InputStream;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBUtil {

	String url = "jdbc:mysql://localhost:3306/b1?serverTimezone=UTC";
	String user = "root";
	String pass = "";
	SqlSessionFactory sqlSessionFactory;
	
	public void init() {
		try {
			String resource = "addr/mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		} catch (Exception e) {
			System.out.println("MyBatis 설정 파일 가져오는 중 문제 발생!!");
			e.printStackTrace();
		}
	}
	
	public ArrayList<Addr> getAddresses() {
		SqlSession session = sqlSessionFactory.openSession();
		AddrMapper mapper = session.getMapper(AddrMapper.class);
		ArrayList<Addr> addrList = mapper.getAddresses();
		
		return addrList;
	}
	
	public void insertAddress(String name, String address, String phone) {
		SqlSession session = sqlSessionFactory.openSession();
		AddrMapper mapper = session.getMapper(AddrMapper.class);
		Addr addr = new Addr(name, address, phone);
		mapper.insertAddress(addr);
		
		session.commit(); // update, delete, insert
	}
	
	public void updateAddress(int id, String name, String address, String phone) {
		SqlSession session = sqlSessionFactory.openSession();
		AddrMapper mapper = session.getMapper(AddrMapper.class);
		Addr addr = new Addr(id, name, address, phone);
		mapper.updateAddress(addr);
		
		session.commit(); // update, delete, insert
	}
	
	public void deleteAddress(int id) {
		SqlSession session = sqlSessionFactory.openSession();
		AddrMapper mapper = session.getMapper(AddrMapper.class);
		mapper.deleteAddress(id);
		
		session.commit(); // update, delete, insert
	}
	
}
