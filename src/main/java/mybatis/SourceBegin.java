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

        /**
         * 这里开始一步步打断点
         */
        //第一步，工厂初始化
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            //获取mapper
            JobMapper jobMapper = sqlSession.getMapper(JobMapper.class);
            System.out.print(jobMapper.getClass());
            //调用mapper，进行增删查改
            Job job = jobMapper.selectByPrimaryKey(1);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
