import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class UserTest {

    public void test01(){
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession session = sqlSessionFactory.openSession();
            int insert = session.insert("com.chinasoft.mapper.userMapper.addUser");
            int delete = session.delete("com.chinasoft.mapper.userMapper.deleteUser");
            int change = session.update("com.chinasoft.mapper.userMapper.updateUser");
            session.commit();
            session.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        UserTest userTest = new UserTest();
        userTest.test01();
    }
}
