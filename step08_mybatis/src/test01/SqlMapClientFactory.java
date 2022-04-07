package test01;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

// mybatis를 사용하기 위한 클래스 정의
// => mybatis 설정 파일인 xml 파일을 읽어와서 코드에 문제가 있는지 검사를 진행하고 관련 객체를 생성함 
public class SqlMapClientFactory {	
	private static SqlSessionFactory factory = null;
	
	// static 초기화
	static {
		try {
			String resource = "mybatis-config.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			// mybatis 초기화 작업 진행
			// => mybatis 설정 파일인 xml 파일을 읽어와서 코드에 문제가 있는지 검사를 진행하고 관련 객체를 생성함 
			factory = new SqlSessionFactoryBuilder().build(reader);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	// SqlSession : db 처리 작업을 하는 클래스
	public static SqlSession getSqlMapClientInstance() {
		return factory.openSession();
	}
}
