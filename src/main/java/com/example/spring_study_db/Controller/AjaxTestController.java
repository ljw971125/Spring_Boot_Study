package com.example.spring_study_db.Controller;

import com.example.spring_study_db.vo.StudentVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/test")
public class AjaxTestController {
    @GetMapping("/test")
    public String test(){
        return "test_ajax";
    }
    @ResponseBody
    @PostMapping("/test1")
    public String test1(){
        System.out.println("test1() 메소드 실행");

        return "/result1";
    }

    @ResponseBody
    @PostMapping("/test2")
    public void test2(String name, int age){
        System.out.println("test2() 메소드 실행");
        System.out.println("name= " + name);
        System.out.println("age= " + age);
    }
    @ResponseBody
    @PostMapping("/test3")
    public String test3(String name, int age){
        System.out.println("test3() 메소드 실행");
        System.out.println("name= " + name);
        System.out.println("age= " + age);

        return "hello";
    }
    @ResponseBody
    @PostMapping("/test4")
    public StudentVO test4() {
        System.out.println("test4() 메소드 실행");

        StudentVO vo = new StudentVO();
        vo.setStuNum(1);
        vo.setStuName("홍길동");
        vo.setStuAge(30);
        System.out.println(vo);

        return vo;
    }
    @ResponseBody
    @PostMapping("/test5")
    public List<StudentVO> test5(){
        System.out.println("test5() 메소드 실행");
        List<StudentVO> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            StudentVO vo = new StudentVO();
            vo.setStuNum(i+1);
            vo.setStuName("자바_" + i+1);
            vo.setStuAge(10 * (i+1));
            vo.setClassCode("CLASS_001");
            list.add(vo);
        }
        return list;
    }
}
