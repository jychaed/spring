package org.hdcd.controller.database;

import org.hdcd.controller.board.service.IBoardService;

public class MybatisController {
	/*
	 * 12장 마이바티스(p514)
	 * 
	 * 1. 마이바티스란?
	 * 
	 * 		1) What?
	 * 		마이바티스는 자바 퍼시스턴스 프레임워크의 하나로 XML 서술자나 어노테이션을 사용하여 저장프로시저나 SQL문으로 객체들을 연결시킨다
	 * 		마이바티스는 Apache라이선스 2.0으로 배포되는 자유 소프트웨어다.
	 * 
	 * 		2) 마이바티스를 사용함으로 써 얻을 수 있는 이점
	 * 		- SQL의 체계적인 관리
	 * 		- 자바 객체와 SQL 입출력 값의 투명한 바인딩
	 * 		- 동적 SQL 조합
	 * 
	 * 		3) 마이바티스 설정
	 * 
	 * 			3-1) 의존 관계 정의
	 * 			- mybatis
	 * 			- mybatis-spring
	 * 			- spring-jdbc
	 * 			- commons-dbcp2
	 * 			- log4jdbc-log4j2-jdbc2
	 * 			- ojdbc6
	 * 				
	 * 				> 의존관계 정의 후 Maven > Update Project를 진행한다.
	 * 
	 * 				*** 그런데 에러가 나? ...
	 * 				- 1) Maven 라이브러리 부분에 내가 추가한 라이브러리가 잘 들어있는지 확인
	 * 				- 2) Project Clean!!!!!!!!
	 * 					> 대번 이거까지하면 해결됨
	 * 				- 3) 이클립스를 껏다 킨다
	 * 				- 4) 오타확인 (pom.xml)
	 * 				- 5) 프로젝트 Preferences열고, 빌드 패스확인
	 * 				- 6) 프로젝트 Preferences열고, Java Facet 확인
	 * 					> Java 1.8, Servlet 3.1확인
	 * 				- 7) Window > Show View > Markers 뷰 활성화하고 에러 삭제
	 * 				- 8) Project Clean
	 * 				- 에러해결 짜잔
	 * 
	 * 				
	 * 			
	 * 			3-2) 스프링과 마이바티스 연결 설정
	 * 			- root-context.xml설정
	 * 				> dataSource 
	 * 				> sqlSessionFactory
	 * 				> sqlSessionTemplate
	 * 				> basePackage
	 * 
	 * 			// 이거 아래 말 정리해서..쓰기.. 빈등록이 뭐죠? bean
	 * 			빈등록 계속 가져 쓰기위한 준비!
	 * 			우리가 컨트롤러 어노테이션 컨트롤러서비스 어노테이션 등등 서버가 로드될때 모든 어노테이션을 읽어와라
	 * 			어노테이션으로 되어있는 녀석들 객체로 만들어서 메모리에 올린다.
	 * 			컨트롤러 서비스 dao 연결각가해서 해야할 객체들 오토와이어나 인젝트로 주입!
	 * 			그때 오토와이어나 인젝트라던데 그게 하는 역할이 서버를 로드했을때 서로 연결? 주입하겠다는 것!
	 * 			서버로드하면 한번에 메모리에 올라가있는 상태로 올려놓는게 빈등록 준비상태임!
	 * 				
	 * 			3-3) 마이바티스 설정
	 * 			- WEB_INF/mybatisAlias/mybatisAlias.xml 설정
	 * 			- 마이바티스의 위치 설정은 root-context의 'sqlSessionFactory'를 설정할 때 property 요소로 적용
	 * 
	 * 		4) 테이블 설정
	 * 		
	 * 			4-1) board, member, member_auth 테이블 생성!
	 * 				> 지금!
	 * 
	 * 	2. Mapper 인터페이스
	 *  - 인터페이스의 구현을 mybatis-spring 에서 자동으로 생성할 수 있다.
	 *  
	 *  	1) 마이바티스 구현
	 *  
	 *  		1-1) Mapper 인터페이스
	 *  		- BoardMapper.java 생성
	 * 
	 *  		1-2) Mapper 인터페이스와 매핑할 Mapper
	 *  		- sqlmap/boardMapper_SQL.xml 생성
	 *  			> namespace를 설정했는데, 그 namespace는 BoardMapper 인터페이스의 경로로 지정(패키지명을 포함한 경로)
	 *  			> _SQL.xml 안에 있는 쿼리를 실행하기 위해서 namespace를 통해 위치를 찾고가 설정함!
	 *  
	 *  		1-3) 게시판 구현 설명
	 *  		- 게시판 컨트롤러 만들기 (board/CrudBoardController)
	 *  		- 게시판 등록 화면 컨트롤러 메소드 만들기 (crudRegister:get)
	 *  		- 게시판 등록 화면 만들기(crud/register.jsp)
	 *  		- 게시판 등록 기능 컨트롤러 메소드 만들기 (crudRgister:post)
	 *  		- 게시판 등록 기능 서비스 인터페이스 메소드 만들기
	 *  		- 게시판 등록 기능 서비스 클래스 메소드 만들기
	 *  		- 게시판 등록 기능 Mapper 인터페이스 메소드 만들기
	 *  		- 게시판 등록 기능 Mapper xml 쿼리 만들기
	 *  		- 게시판 등록 완료 페이지 만들기
	 *  		- 			여기서 한번 기능 및 화면을 체크
	 *  		- 게시판 목록 화면 컨트롤러 메소드 만들기(crudList:get)
	 *  		- 게시판 목록 화면 서비스 인터페이스 메소드 만들기
	 *  		- 게시판 목록 화면 서비스 클래스 메소드 만들기
	 *  		- 게시판 목록 화면 Mapper 인터페이스 메소드 만들기
	 *  		- 게시판 목록 화면 Mapper xml 쿼리 만들기
	 *  		- 게시판 목록 화면 만들기 (crud/list.jsp)
	 *  		- 			여기서 한번 기능 및 화면을 체크
	 *  		- 게시판 상세 화면 컨트롤러 메소드 만들기  ======> CrudBoardController
	 *  		- 게시판 상세 화면 서비스 인터페이스 메소드 만들기 ========> interface IBoardService
	 *  		- 게시판 상세 화면 서비스 클래스 메소드 만들기  =======> class BoardServiceImpl implements IBoardService
	 *  		- 게시판 상세 화면 Mapper 인터페이스 메소드 만들기
	 *  		- 게시판 상세 화면 Mapper xml 쿼리 만들기
	 *  		- 게시판 상세 화면 만들기 (crud/read.jsp)
	 *  		- 			여기서 한번 기능 및 화면을 체크
	 *  		- 게시판 수정 화면 컨트롤러 메소드 만들기(crunModify:get)  ======> CrudBoardController
	 *  		- 게시판 수정 화면 서비스 인터페이스 메소드 만들기
	 *  		- 게시판 수정 화면 서비스 클래스 메소드 만들기
	 *  		- 게시판 수정 화면 Mapper 인터페이스 메소드 만들기
	 *  		- 게시판 수정 화면 Mapper xml 쿼리 만들기
	 *  		- 게시판 수정 화면 만들기 (crud/register.jsp - status 'u' 전달)
	 *  		- 			
	 *  		- 게시판 수정 기능 컨트롤러 메소드 만들기(crunModify:post)  ======> CrudBoardController
	 *  		- 게시판 수정 기능 서비스 인터페이스 메소드 만들기
	 *  		- 게시판 수정 기능 서비스 클래스 메소드 만들기
	 *  		- 게시판 수정 기능 Mapper 인터페이스 메소드 만들기 =====>BoardMapper
	 *  		- 게시판 수정 기능 Mapper xml 쿼리 만들기
	 *  		- 			여기서 한번 기능 및 화면을 체크
	 *  		- 게시판 삭제 기능 컨트롤러 메소드 만들기(crunRemove:post)  ======> CrudBoardController
	 *  		- 게시판 삭제 기능 서비스 인터페이스 메소드 만들기
	 *  		- 게시판 삭제 기능 서비스 클래스 메소드 만들기
	 *  		- 게시판 삭제 기능 Mapper 인터페이스 메소드 만들기 =====>BoardMapper
	 *  		- 게시판 삭제 기능 Mapper xml 쿼리 만들기
	 *  		- 			여기서 한번 기능 및 화면을 체크
	 *  		- 
	 *  		- 기본적인 CRUD 끝!!
	 *  3. 별칭 적용
	 *  - TypeAlias로 맵핑 파일에서 반복적으로 사용될 패키지의 이름을 정의한다.
	 *  	
	 *  	1) 마이바티스 설정
	 *  
	 *   		1-1) mybatisAlias.xml 설정
	 *   		- typeAlias 설정을 한다.
	 *   
	 *   		1-2) boardMapper_SQL.xml 수정
	 *   		- 쿼리 태그레 각각 셋팅한 패키지명 대신 alias로 설정한 별칭으로 대체한다.
	 *   			
	 *  
	 *  
	 *  
	 * 
	 * 
	 * 
	 */
}
