package edu.kh.project.main.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.kh.project.board.model.dto.Board;
import edu.kh.project.member.model.dto.Member;
import lombok.RequiredArgsConstructor;

public interface MainService {

	/** 리스트 출력용 정보보기
	 * @return
	 */
	List<Member> viewList();

	/** 비밀번호 초기화
	 * @param memberNo
	 * @return
	 */
	int resetPass(String memberNo);

	/** 회원탈퇴 여부 변경
	 * @param memberNo
	 * @return
	 */
	int restoration(String memberNo);

	
}
