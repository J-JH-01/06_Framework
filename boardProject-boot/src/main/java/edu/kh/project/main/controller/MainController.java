package edu.kh.project.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.project.main.service.MainService;
import edu.kh.project.member.model.dto.Member;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MainController {

	@Autowired	
	private BCryptPasswordEncoder bcrypt;
	
	@Autowired
	private MainService service;
	
	@RequestMapping("/")	// "/"(최상위주소) 요청 매핑
	public String mainPage() {
		
		
		// 접두사/접미사 제외
		// classpath://templates/
		// .html 
		return "common/main";
	}
	
	// LoginFilter -> loginError 리다이렉트
		// -> message 만들어서 메인페이지로 리다이렉트
		@GetMapping("loginError")
		public String loginError(RedirectAttributes ra) {
			ra.addFlashAttribute("message","로그인 후 이용해 주세요~");
			return "redirect:/";
			
		}

	@ResponseBody
	@GetMapping("viewList")
	public List<Member> viewList() {
		List<Member> viewList = service.viewList();
		
		return viewList;
	}
		
	@ResponseBody
	@PostMapping("resetPass")
	public int resetPass(@RequestBody String memberNo) {
		return service.resetPass(memberNo);
	}
	
	@ResponseBody
	@PostMapping("restoration")
	public int restoration(@RequestBody String memberNo) {
		return service.restoration(memberNo);
	}
	
	
	
}
