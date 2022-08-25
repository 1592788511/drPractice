package org.hui.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.hui.pojo.Student;

import java.io.Reader;
import java.util.List;
import java.util.Scanner;

public class StudentDao1 {

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

    /**
     * add
     * @param student
     */
    public void add(Student student){
        SqlSession sqlSession = sqlSessionFactory.openSession();


        int insert = sqlSession.insert("org.hui.dao.StudentDao.add",student);
        sqlSession.commit();
        sqlSession.close();
    }


    /**
     * show
     */
    public List<Student> show(){

        SqlSession sqlSession = sqlSessionFactory.openSession();

        //SELECT
        List<Student> list = sqlSession.selectList("org.hui.dao.StudentDao.show");

        sqlSession.close();
        return list;
    }

    /**
     * showById
     */
    public Student showById(int id){

        SqlSession sqlSession = sqlSessionFactory.openSession();
        Student student = null;
        //SELECT
        student = sqlSession.selectOne("org.hui.dao.StudentDao.showById",id);

        sqlSession.close();
        return student;
    }

    /**
     * update
     * @param student
     */
    public void update(Student student){
        SqlSession sqlSession = sqlSessionFactory.openSession();

        int update = sqlSession.update("org.hui.dao.StudentDao.updateStudent", student);

        sqlSession.commit();
        sqlSession.close();

    }

    /**
     * delete
     * @param id
     */
    public void delete(int id){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.delete("org.hui.dao.StudentDao.deleteStudent",id);
        sqlSession.commit();
        sqlSession.close();
    }


    public static void main(String[] args) {


        StudentDao1 dao = new StudentDao1();

        while(true){
            Scanner input=new Scanner(System.in);
            String str=input.next();

            if(str.equals("1")){
                System.out.println("查询操作");
                List<Student> list = dao.show();
                for (Student student : list) {
                    System.out.println(student);
                }
            } else if(str.equals("2")){
                System.out.println("插入操作");
                Student student1 = new Student(0, "蔡徐坤", 20, "女", "鸡你太美");
                dao.add(student1);
            } else if(str.equals("3")){
                System.out.println("更新操作");
                Student student2 = new Student(3, "菜虚鲲", 20, "男", "oh baby");
                dao.update(student2);
            } else if(str.equals("4")){
                System.out.println("删除操作");
                dao.delete(5);
            } else if(str.equals("5")){
                System.out.println("根据id查询");
                Student student = dao.showById(3);
                System.out.println(student);
            } else if(str.equals("exit")){
                break;
            }


        }

    }


}
