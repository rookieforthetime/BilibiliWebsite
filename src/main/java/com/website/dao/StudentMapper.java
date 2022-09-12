package com.website.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.website.domain.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * mybatis的增删改查操作需要一个构建一个专门的mapper包，并在其中针对不同的表写接口
 */
@Mapper  // 该注解代表下面是一个专用于增删改查的接口
public interface StudentMapper extends BaseMapper<Student> { // 还需要一个实现类，由mybatis和spring来提供，通过@Autowired获取实现类对象
/*    //  @Select(sql查询语句)
    @Select("""
            select id, name
            from student;
            """)
    List<Student> findAll(); // 查询表里所有数据并封装成多个Student对象并存储在List集合中

    @Select("""
            select id, name
            from student where id = #{id};
            """)
        // 通过 #{变量名} 可以查找不同条件下的信息
    Student findById(int id);

    @Insert("""
            insert into student (id, name) values (#{id}, #{name})
            """)
    void insertOne(Student stu);
    // 通过@Param(字段名) 来提示输入的参数对应的是表中的哪个字段, 一个参数不用写，两个以上变成一个写类对象
    // 该注释通常可以不写，希望方法中只有一个参数，所以用实例类来表示

    @Delete("""
            DELETE FROM student WHERE id = #{id};
            """)
    void deleteById(int id);

    @Delete("""
            DELETE FROM student WHERE name = #{name};
            """)
    void deleteByName(String name);

    @Update("""
            update student SET name = #{name} WHERE id = #{id};
            """)
    void updateNameById(Student student);

    @Update("""
            update student SET id = #{id} WHERE name = #{name};
            """)
    void updateIdByName(Student student);*/
}