package org.hui.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.hui.pojo.Student;

import java.io.Reader;
import java.util.List;

public class Test {
    private static SqlSessionFactory sqlSessionFactory;
    private static Reader reader;

    static{
        try{
            reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

        }catch(Exception e){
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {

        SqlSession session = sqlSessionFactory.openSession();
        StudentDao dao = session.getMapper(StudentDao.class);

        List<Student> list = dao.show();
        for (Student student : list) {
            System.out.println(student);
        }

    }
}
