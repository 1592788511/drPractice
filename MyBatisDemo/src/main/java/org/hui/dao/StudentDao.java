package org.hui.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.hui.pojo.Student;

import java.io.Reader;
import java.util.List;
import java.util.Scanner;

public interface StudentDao {

    /**
     * 查询
     * @return
     */
    List<Student> show();

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    Student showById(int id);

    /**
     * 添加
     * @param student
     * @return
     */
    int add(Student student);

    /**
     * 更新
     * @param student
     * @return
     */
    int update(Student student);

    /**
     * 删除
     * @param id
     * @return
     */
    int delete(int id);

}




