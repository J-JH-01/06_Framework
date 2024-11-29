package edu.kh.project.common.aop;

/*
 * Aspect-Oriented Programming 의 약자로, 분산되어 있는 관심사/관점을 모듈화 시키는 기법
 * 
 * - 주요 비즈니스 로직과 관련이 없는 부가적인 기능을 추가할 때 유용
 * 
 * ex) 코드 중간 중간에 로그 찍을 때, 트랜잭션 처리하고 싶을 때 등
 * 
 * 주요 어노테이션
 * - @Aspect : Aspect를 정의하는데 사용되는 어노테이션으로, 클래스 상단에 작성함
 * - @Before(포인트컷) : 대상 메서드(포인트컷) 실행 전에 Advice를 실행함.
 * - @After(포인트컷)  : 대상 메서드 실행 후에 Advice를 실행함.
 * - @Around(포인트컷) : 대상 메서드 실행 전/후로 Advice를 실행함 (@Before + @After)
 *
 * 
 * */	
public class TestAspect {
	
}
