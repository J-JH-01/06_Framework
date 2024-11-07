package edu.kh.project.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.project.member.model.dto.Member;
import edu.kh.project.member.model.service.MemberService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

/*
 * @SessionAttributes({"key", "key", "key" ...})
 * - Model에 추가된 속성 중
 * 	 key값이 일치하는 속성을 session scope로 변경
 * 
 */

@SessionAttributes({"loginMember"}) // 몇개든 나열 가능하다
@Slf4j
@Controller
@RequestMapping("member")
public class MemberController {

	@Autowired	// 의존성 주입(DI)
	private MemberService service;
	
	/*
	 * [로그인]
	 * - 특정 사이트에 아이디/비밀번호 등을 입력해서
	 * 	 해당 정보가 있으면 조회/서비스 이용
	 * 
	 * - 로그인 한 회원 정보를 session에 기록하여(req에 담으면 요청받은 순간만 정보가 유지되니까 session 단으로)
	 * 	 로그아웃 또는 브라우저 종료시(탭 종료x) 까지 해당 정보를 계속 이용할 수 있게함
	 */
	
	
	
	/** 로그인
	 * @param inputMember : 커맨드 객체 (@ModelAttributes 생략)
	 * 						memberEmail,memberPw 세팅된 상태
	 * @param ra : 리다이렉트 시 request scope로 데이터 전달하는 객체
	 * 			   (request -> session -> request) 
	 * @param model : 데이터 전달용 객체 (기본 request scope /
	 * 				 @SessionAttributes 어노테이션과 함께 사용시 session scope로 이동)
	 * @param saveId
	 * @param resp
	 * @return
	 */
	@PostMapping("login")
	public String login(Member inputMember, // 아이디 비밀번호 다 들어가 있음
						RedirectAttributes ra,
						Model model,
						@RequestParam(value="saveId", required = false) String saveId,
						HttpServletResponse resp
			) {
		
		// 로그인 서비스 호출
		Member loginMember = service.login(inputMember);
		
		// 로그인 실패 시
		if(loginMember == null) {
			ra.addFlashAttribute("message", "아이디 또는 비밀번호가 일치하지 않습니다");
		} else {
			
			// Session scope에 loginMember 추가
			model.addAttribute("loginMember",loginMember);
			// 1단계 : request scope에 세팅됨
			// 2단계 : 클래스 위에 @SessionAttributes() 어노테이션 작성하여 
			//		   session scope 이동
		}
		
		return "redirect:/"; // 메인페이지 재요청
	}
	

	/** 로그아웃 : session에 저장된 로그인된 회원 정보를 없앰
	 * @param Sessionstatus : @SessionAttributes로 지정된 특정 속성을 세션에서 제거 기능 제공 객체
	 * @return 
	 */
	@GetMapping("logout")
	public String logout(SessionStatus status) {
		
		status.setComplete(); // 세션을 완료 시킴( == 세션에서 @SessionAttributes로 등록된 세션 제거)
		
		return "redirect:/";
	}
	
	
	/** 회원 가입 페이지로 이동
	 * @return
	 */
	@GetMapping("signup")
	public String signupPage() {
		return "member/signup";
	}
	
	
	/** 이메일 중복검사 (비동기 요청)
	 * @return
	 */
	@ResponseBody // 응답 본문(fetch)으로 돌려보냄
	@GetMapping("checkEmail") 	 // Get요청 /member/checkEmail
	public int checkEmail(@RequestParam("memberEmail") String memberEmail) {
		return service.checkEmail(memberEmail);
	}
	
	
	
	
	
	
}
