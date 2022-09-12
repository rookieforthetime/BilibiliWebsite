package com.website;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.website.dao.PlayMapper;
import com.website.dao.StudentMapper;
import com.website.dao.VideoMapper;
import com.website.domain.Student;
import com.website.domain.Video;
import com.website.domain.query.StudentQuery;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
public class MybatisPlusTest {
    @Autowired
    VideoMapper videoMapper;
    @Autowired
    PlayMapper playMapper;
    @Autowired
    StudentMapper studentMapper;

    @Test
    public void insert_mp() { // 增
        Video video = new Video();
        video.setBv("9");
        videoMapper.insert(video);
    }

    @Test
    public void delete_mp() { // 删
        videoMapper.deleteById(14); // 按id删一条
        List<Integer> lst = List.of(17, 18);
        videoMapper.deleteBatchIds(lst); // 根据id删除多条数据
        lst = List.of(1,2,3,4);
        videoMapper.selectBatchIds(lst); // 根据id查询多条数据
    }

    @Test
    public void update_mp() { // 改
        Video video = new Video();
        // 方法1：为要修改的数据添加version的值
        video.setId(2);
        video.setType("转载");
        video.setVersion(1);
        videoMapper.updateById(video); // 根据id修改数据

        // 方法2：先通过要修改的数据id获得数据对应的对象
        Video video1 = videoMapper.selectById(3);
        Video video2 = videoMapper.selectById(3);
        // 此时对象中已有version值，可以进行更新操作
        // 再去修改其中想要修改的字段值
        video1.setType("自制");
        video2.setType("转载");
        videoMapper.updateById(video1);
        videoMapper.updateById(video2);
    }

    @Test
    public void getById() { // 查询
        Video video = videoMapper.selectById(2); // 按ID查询
        System.out.println(video);
        List<Video> videos = videoMapper.selectList(null); // 查全部
        System.out.println(videos);
    }

    @Test
    public void getByPage() { // 分页查询
        // 需要配置分页拦截器
        IPage page = new Page(1, 3);
        videoMapper.selectPage(page, null);
        System.out.println("当前页码值： " + page.getCurrent());
        System.out.println("每页显示数： " + page.getSize());
        System.out.println("一共多少页： " + page.getPages());
        System.out.println("一共多少条： " + page.getTotal());
        System.out.println("数据： " + page.getRecords());
    }

    @Test
    public void get1() {
        // 方式1: 按条件查询
        QueryWrapper<Video> qw = new QueryWrapper<>();
        qw.lt("bv", "5"); // lt() 是小于的意思
        List<Video> videos = videoMapper.selectList(qw);
        System.out.println(videos);
    }

    @Test
    public void get2() {
        // 方式2: lambda格式条件查询
        QueryWrapper<Video> qw1 = new QueryWrapper<>();
        qw1.lambda().le(Video::getBv, "5");
        List<Video> videos = videoMapper.selectList(qw1);
        System.out.println(videos);

        qw1.lambda().eq(Video::getBv, "5");
        Video video = videoMapper.selectOne(qw1);
        System.out.println(video);
    }

    @Test
    public void get3() {
        // 方式3: lambda格式条件查询(常用)
        LambdaQueryWrapper<Video> qw2 = new LambdaQueryWrapper<>();
        qw2.lt(Video::getBv, "5")
                .gt(Video::getBv, "2"); // lt小于 gt大于 链式编程 表示并且 相当于and()
        List<Video> videos = videoMapper.selectList(qw2);
        System.out.println(videos);

        qw2.lt(Video::getBv, "5")
                .or()
                .gt(Video::getBv, "6");// or() 表示或者
        videos = videoMapper.selectList(qw2);
        System.out.println(videos);
    }

    @Test
    public void get4() { // null: 空值处理
        StudentQuery studentQuery = new StudentQuery();
        studentQuery.setAge(10); // 年龄下限
        studentQuery.setAge2(40); // 年龄上限

        LambdaQueryWrapper<Student> stu = new LambdaQueryWrapper<>();
        stu.lt(Student::getAge, studentQuery.getAge2()); // 根据上限和下限进行筛选
        // 先判断第一个条件参数是否为True，若为True则连接当前条件,下面判断是否有上限
        stu.lt(null != studentQuery.getAge2(), Student::getAge, studentQuery.getAge2());
        // 下面判断是否有下限
        stu.gt(null != studentQuery.getAge(), Student::getAge, studentQuery.getAge());
        List<Student> students = studentMapper.selectList(stu);
        System.out.println(students);
    }

    @Test
    public void get5() {// 查询投影： 查询的字段控制, 表示想看哪些字段
       /*
        LambdaQueryWrapper<Video> qw = new LambdaQueryWrapper<>();
        qw.select(Video::getBv, Video::getIntroduction); // 只看这两个字段,只适用与lambda格式
        List<Video> videos = videoMapper.selectList(qw);
        System.out.println(videos);
        */
        QueryWrapper<Video> qw = new QueryWrapper<>();
        // qw.select("Bv", "getIntroduction"); 这种写法适用于非lambda格式
        qw.select("count(*) as count, category");
        qw.groupBy("category");
        List<Map<String, Object>> lst = videoMapper.selectMaps(qw);
        System.out.println(lst);
    }

    @Test
    public void get6() { // 多种查询条件
        LambdaQueryWrapper<Video> qw = new LambdaQueryWrapper<>();
        LambdaQueryWrapper<Student> stu = new LambdaQueryWrapper<>();
        LambdaQueryWrapper<Student> stu1 = new LambdaQueryWrapper<>();
        // 等匹配 a.eq().eq(), 既满足条件1.又满足条件2
        qw.eq(Video::getType, "自制").eq(Video::getBv, "3");
        Video video = videoMapper.selectOne(qw);
        System.out.println(video);

        // 范围查询 lt小于 le小于等于 gt大于 ge大于等于 eq等于  between介于
        stu.between(Student::getAge, 10, 30); // 介于两个之间，前面是小的数字，后面是大的数字
        List<Student> studentList = studentMapper.selectList(stu);
        System.out.println(studentList);

        // 模糊匹配like
        stu1.like(Student::getName, "张"); // 包含了J的
        // stu.likeLeft(Student::getName, "J") 以J为开头
        // stu.likeRight(Student::getName, "J") 以J为结尾
        List<Student> studentList1 = studentMapper.selectList(stu1);
        System.out.println(studentList1);
    }
}
