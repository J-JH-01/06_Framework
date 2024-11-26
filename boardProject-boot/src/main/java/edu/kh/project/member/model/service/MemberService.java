package edu.kh.project.member.model.service;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.project.member.model.dto.Member;

public interface MemberService {

	/** 로그인 서비스
	 * @param inputMember
	 * @return loginMember
	 */
	Member login(Member inputMember) throws Exception;

	/** 이메일 중복검사 서비스
	 * @param memberEmail
	 * @return
	 * @author 제작자이름
	 */
	int checkEmail(String memberEmail);

	
	/** 닉네임 중복검사 서비스
	 * @param memberNickname
	 * @return
	 */
	int checkNickname(String memberNickname);

	/** 회원가입 서비스
	 * @param inputMember
	 * @param memberAddress
	 * @param ra
	 * @return
	 */
	int signup(Member inputMember, String[] memberAddress);



}
