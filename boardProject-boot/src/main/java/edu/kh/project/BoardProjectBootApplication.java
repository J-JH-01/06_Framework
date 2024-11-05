package edu.kh.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

// Spring Security에서 기본 제공하는 로그인 페이지를 이용 안하겠다 라는 속성
// 암호화 기능때문에 스프링 시큐리티에서 빼서 쓸라고 하는거지
// 자동으로 login url로 옮겨지는 기능은 필요없어서 끄는것
@SpringBootApplication (exclude= {SecurityAutoConfiguration.class})
public class BoardProjectBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoardProjectBootApplication.class, args);
	}

}
