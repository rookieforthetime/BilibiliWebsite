package com.website;

import com.website.dao.StudentMapper;
import com.website.domain.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest  // 将单元测试类与Spring联系起来，才可以使用依赖注入
public class TestStudentMapper {  // 单元测试

    /*@Autowired  // 通过@Autowired获取StudentMapper接口的实现类对象
    StudentMapper studentMapper;

    @Test  // 该注解表示下面的方法是一个测试入口，是一个测试方法，该方法必须满足 无返回值，无参数，方法名任意的条件
    // 之后测试不用写main方法， 加了@Test注解的方法就是一个测试入口，一个类中可以有多个测试入口
    public void selectAll() { // 查全部
        List<Student> lst = studentMapper.findAll();
        for (Student student : lst) {
            System.out.println("id: " + student.getId() + "\t" + "姓名: " + student.getName());
        }
    }

    @Test
    public void selectOne() { // 根据Id查一个
        Student stu = studentMapper.findById(5); // 可以输入想查询的变量ID，若没有则返回Null
        System.out.println("id: " + stu.getId() + "\t" + "姓名: " + stu.getName());
    }

    @Test // 可以独立运行测试方法， 对其他测试借口没有影响，互不干扰，
    public void insert_student() { // 增
        studentMapper.insertOne(new Student(6,"六神", 23));
        selectAll();
    }

    @Test
    public void delete() { // 删
        studentMapper.deleteById(6);
        studentMapper.deleteByName("张麻子");
        selectAll();
    }

    @Test
    public void update() { // 改
        studentMapper.updateNameById(new Student(4, "赵六"));
        studentMapper.updateIdByName(new Student(6, "赵六"));
        selectAll();
    }*/
}
