package mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SourceBegin {
    public static void main(String[] args) throws IOException {
        //默认的resource是 main/resources/
        String resource = "mybatis-config.xml";
        //Resources这个类，是基于当前创建类的ClassLoader去找到对应的实体类和mapper接口
        //所以对应的mapper.xml里的类路径，是从当前路径开始
        InputStream inputStream = Resources.getResourceAsStream(resource);
        if (inputStream==null){
            System.out.print("null");
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            JobMapper jobMapper = sqlSession.getMapper(JobMapper.class);
            Job job = jobMapper.selectByPrimaryKey(1);
            System.out.print(jobMapper.getClass());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
