package edu.kh.project.main.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import edu.kh.project.member.model.dto.Member;

@Mapper
public interface MainMapper {

	/** 리스트 출력용 정보 얻기
	 * @return
	 */
	List<Member> viewList();



	/** 비밀번호 리셋
	 * @param params
	 * @return
	 */
	int resetPass(Map<String, Object> params);



	/** 회원가입 여부 변경
	 * @param memberNo
	 * @return
	 */
	int restoration(String memberNo);

}
