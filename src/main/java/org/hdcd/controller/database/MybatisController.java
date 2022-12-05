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
	 *  20221205 			
	 *  4. _로 구분된 컬럼명 자동 매핑
	 *  - 마이바티스 설정의 maxUnderscoreToCamel 프로퍼티 값을 true로 지정하면 _로 구분된 컬럼명을 소문자 낙타 표기법의 프로퍼티명으로
	 *    자동 매핑할 수 있다
	 *  	'_' 포함되어 있는 데이터베이스 컬럼명을 카멜기법 셋팅으로 bo_no가 boNo로 처리된다.
	 *  	
	 *  	1) 마이바티스 설정
	 *  		
	 *  		1-1) mybatisAlias.xml 설정
	 *  		- <settings>
	 *  		- 	<setting name="mapUnderscoreToCamelCase" value"true"/> 설정추가
	 *  		- </settings>
	 *  
	 *  		1-2) 매핑파일 수정 (boardMapper_SQL.xml)
	 *  		- read 부분에 as boardNo, as regDate 삭제
	 *  		- list 부분에 as boardNo, as regDate 삭제
	 *  
	 *  5. 기본키 취득
	 *  - 마이바티스는 useGeneratedKeys 속성을 이용하여 INSERT 할 때 데이터베이스 축에서 체변된 기본키를 취득할 수 있다.
	 *  
	 *  	1) 데이터베이스 테이블 준비
	 *  
	 *  		1-1) 위에서 회원 테이블 만들어 놓음
	 *  			- member
	 *  			- member_auth
	 *  			- 2개의 테이블을 미리 준비 해놓음
	 * 
	 *  	2) 마이바티스 설정
	 *  		
	 *  		2-1) 매핑 파일 수정(boardMapper_SQL.xml)
	 *  		- create 부분에서 속성 추가 //  하나증가증가된것을 만들어 놓고! 넥스트발 이자체로 줘도... 아 기본키 취득을 위해서 우선! 인서트 할때 지금 바로 넣게 될 게시글 번호를 취득하기 위해서 이녀석을 먼저 실행하고 증가된 값이 포함된 상태에서! 이녀석을 그냥 꺼내쓰는 느낌! 이걸 하는 이유는 이값을 얻어내려고! 얻어내려면 셀렉트키를 해야지만 기본키를 취득할 수 있음! 비포만 써요 애프터는 안써요 
	 *  			> useGeneratedKeys="true" keyProperty="boardNo"
	 *  			> <selectKey order="BEFORE" resultType="int" keyProperty="boardNo">
	 *  			>		select seq_board.nextval from dual
	 *  			> </selectKey>
	 *  			> insert into board(
	 *  			>	board_no, title, content, writer, reg_date
	 *  			> ) values (
	 *  			> 	#{boardNo}, #{title}, #{content}, #{writer}, sysdate
	 *  			> )
	 *  
	 *  			*** currval 사용시 주의사항
	 *  			- select seq_board.currval from dual   ===> 현재꺼 쓰려고 하면 에러남!
	 *  			위 select 쿼리를 사용시, currval를 사용하는데 있어서 사용 불가에 대한 에러가 발생할 수 있다.(바로 사용은 불가)
	 *  			currval를 사용할 때는 select seq_board.nextval from dual로 먼저 한 번 실행후,
	 *  			select seq_board.nextval from dual로 사용하면 에러가 없음
	 *  			
	 *  			** 대체 할 쿼리
	 *  			- select last_number from user_sequences where wequence_name = 'seq_board'
	 *  	
	 *  		2-2) 컨트롤러 메소드에서 crudRegister 부분 수정
	 *  			- 전달받은 시퀀스가 boardNo에 들어 있기 때문에, 등록 후 전달받은 boardNo로 상세보기 화면으로 접근하도록 합시다!
	 *  
	 *  6. 일대다 관계 테이블 매핑
	 *  - 마이바티스 기능을 활용하여 매핑 파일을 적절하게 정의하면 일대다 관계 테이블 매핑을 쉽게 처리할 수 있다.
	 *  	
	 *  	ex) Member 클래스 안에 Address 클래스가 있다.
	 *  		Member
	 *  			- Address
	 *  				> location
	 *  				> postCode
	 *  		Member 클래스 안에 List<Address> 컬렉션이 있다.
	 *  		Member
	 *  			- list
	 *  				- Address
	 *  				- Address
	 *  				.....
	 *  		이런 경우에 브라우저에서 입력받아 넘기는 데이터가 서버로 전송되고, 전송된 계층 데이터들이 내가 처리해야할
	 *  		데이터 매핑 공간에 하나하나씩 잘 셋팅되어야한다.
	 *  
	 *  	1) 게시판 구현 설명
	 *  
	 *  		- 회원 등록 화면 컨트롤러 만들기 (member/CrudMemberController)
	 *  		- 회원 등록 화면 컨트롤러 메소드 만들기(crudmemberRegisterForm:get)
	 *  		- 회원 등록 화면 만들기(crud/member/register.jsp)
	 *  		- 회원 등록 기능 컨트롤러 메소드 만들기(crudMemberRegister:post)
	 *  		- 회원 등록 기능 인터페이스 메소드 만들기
	 *  		- 회원 등록 기능 클래스 메소드 만들기
	 *  		- 회원 등록 기능 Mapper 인터페이스 메소드 만들기
	 *  		- 회원 등록 기능 Mapper xml 쿼리 만들기
	 *  		- 회원 등록 완료 페이지 만들기(crud/member/success.jsp
	 *  					여기까지 확인
	 *  		- 회원 등록 화면 컨트롤러 메소드 만들기(crudMemberList:get)
	 *  		- 회원 등록 화면 서비스 인터페이스 메소드 만들기
	 *  		- 회원 등록 화면 서비스 클래스 메소드 만들기
	 *  		- 회원 등록 화면 Mapper 인터페이스 메소드 만들기
	 *  		- 회원 등록 화면 Mapper xml 쿼리 만들기
	 *  		- 회원 등록 화면 페이지 만들기(crud/member/list.jsp)
	 *  					여기까지 확인
	 *  		- 회원 상세 화면 컨트롤러 메소드 만들기(crudMemberRead:get)
	 *  		- 회원 상세 화면 서비스 인터페이스 메소드 만들기
	 *  		- 회원 상세 화면 서비스 클래스 메소드 만들기
	 *  		- 회원 상세 화면 Mapper 인터페이스 메소드 만들기
	 *  		- 회원 상세 화면 Mapper xml 쿼리 만들기
	 *  		- 회원 상세 화면 페이지 만들기(crud/member/read.jsp)
	 *  					여기까지 확인
	 *  		- 회원 수정 화면 컨트롤러 메소드 만들기(crudMemberModifyForm : get)
	 *  		- 회원 수정 화면 서비스 인터페이스 메소드 만들기
	 *  		- 회원 수정 화면 서비스 클래스 메소드 만들기
	 *  		- 회원 수정 화면 Mapper 인터페이스 메소드 만들기
	 *  		- 회원 수정 화면 Mapper xml 쿼리 만들기
	 *  		- 회원 수정 화면 페이지 만들기(crud/member/modify.jsp)
	 *  					수정 화면 read를 이용
	 *  		- 회원 수정 기능 컨트롤러 메소드 만들기(crudMemberModify : post)
	 *  		- 회원 수정 기능 서비스 인터페이스 메소드 만들기
	 *  		- 회원 수정 기능 서비스 클래스 메소드 만들기
	 *  		- 회원 수정 기능 Mapper 인터페이스 메소드 만들기
	 *  		- 회원 수정 기능 Mapper xml 쿼리 만들기
	 *  		- 회원 수정 기능 페이지 만들기(이미 만들어진것으로 확인)
	 *  					여기까지 확인
	 *  		- 회원 삭제 기능 컨트롤러 메소드 만들기(crudMemberDelete : post)
	 *  		- 회원 삭제 기능 서비스 인터페이스 메소드 만들기
	 *  		- 회원 삭제 기능 서비스 클래스 메소드 만들기
	 *  		- 회원 삭제 기능 Mapper 인터페이스 메소드 만들기
	 *  		- 회원 삭제 기능 Mapper xml 쿼리 만들기
	 *  		- 회원 삭제 기능 페이지 만들기(이미 만들어진것으로 확인)
	 *  					여기까지 확인
	 *  
	 *  7. 동적 SQL
	 *  - 마이바티스는 동적 SQL을 조립하는 구조를 지원하고 있으며, SQL 조립 규칙을 매핑 파일에 정의할 수 있다.
	 *  
	 *  	1) 동적으로 SQL을 조립하기 위한 SQL 요소
	 *  	- <where>
	 *  		> WHERE절 앞 뒤에 내용을 더 추가하거나 삭제할 때 사용하는 요소
	 *  	- <choose>
	 *  		> 여러 선택 항목에서 조건에 만족할 때만 SQL을 조립할 수 있게 만드는 요소
	 *  	- <foreach>
	 *  		> 컬렉션이나 배열에 대해 반복 처리를 하기 위한 요소
	 *  	- <set>
	 *  		> SET 절 앞 뒤에 내용을 더 추가하거나 삭제할 때 사용하는 요소
	 *  
	 *  	2) 게시판 구현 설명
	 *  	
	 *  		- 게시판 목록 화면 검색 페이지 추가(crud/board/list.jsp)
	 *  					
	 *  
	 *  
	 *  
	 *  			
	 *  
	 *  
	 *  	
	 *  
	 *  
	 *  
	 *  
	 *  
	 * 
	 * 
	 * 
	 */
}
