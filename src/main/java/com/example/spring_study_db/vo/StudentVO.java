package com.example.spring_study_db.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class StudentVO {
    private int stuNum;
    private String stuName;
    private int stuAge;
    private String classCode;
    private String className;
}
