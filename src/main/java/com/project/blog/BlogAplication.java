package com.project.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BlogAplication {
    public static void main(String[] args) {
        SpringApplication.run(BlogAplication.class, args);
        //branch의 버전확인을 위한 주석
        //branch 생성후, 깃허브에도 branch를 올리기위한 테스트 주석
    }
}
