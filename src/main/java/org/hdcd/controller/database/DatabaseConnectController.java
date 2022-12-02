package org.hdcd.controller.database;

public class DatabaseConnectController {
	/*
	 * 11장 데이터베이스 연동 20221202 (p427)
	 * 
	 * 1. Oracle 11g 설치(서버, 클라이언트)
	 * 2. Oracle SQLDeveloper Tool 설치
	 * 3. 데이터소스 설정
	 *  - 애플리케이션이 데이터베이스에 접근하기 위한 추상화된 연결을 제공하는 역할을 한다.
	 *  
	 *  	스프링에서 설정할 수 있는 데이터 소스
	 *  	> JDBC 드라이버를 통해 선언된 데이터 소스
	 *  	> JNDI에 등록된 데이터 소스
	 *  	> 커넥션을 풀링하는 데이터 소스
	 *  	> DBCP2에 등록된 데이터 소스
	 *  
	 *  	*** JNDI란?
	 *  	- JNDI (Java Naming and Directory Interface)
	 *  		디렉토리 서비스에서 제공하는 데이터 및 객체를 발견(discover)하고 참고(lookup) 하기위한 자바 API이다
	 *  
	 * 	 	1) 데이터베이스 JDBC 라이브러리 설정
	 * 	 	- pom.xml에서 의존성 추가
	 * 		 > spring-jsbc
	 *  	 > ojdbc6
	 *  
	 *  	2) 데이터소스 설정
	 *  	- root-context.xml
	 * 			<bean id="dataSource" class="org.apache.commons.dbcp2.BasicDataSource" destroy-method="close">
	 * 				<property name="driverClassName" value="oracle.jdbc.driver.OracleDriver"/>
	 * 				<property name="url" value="jdbc:oracle:thin:@localhost:1521:xe"/>	
	 * 				<property name="username" value="sem"/>
	 * 				<property name="password" value="java"/>
	 * 			</bean>
	 *  
	 *  4. CRUD 게시판
	 *  - 데이터 베이스 데이터에 접근하여 처리하는 방식
	 *  	> 스프링 JDBC
	 *  	> JPA
	 *  	> 마이바티스
	 *  	
	 *  	1) 오라클 데이터베이스 계정생성
	 *  	2) 생성 SQL
	 *  		- board, member, member_auth
	 *  	
	 *  	3) 작성할 화면
	 *  		- 등록 화면
	 *  		- 등록 처리 후 화면
	 *  		- 목록 화면
	 *  		- 상세보기 화면
	 *  		- 수정 화면
	 *  		- 수정 처리 후 화면
	 *  		- 삭제 처리 후화면
	 *  	
	 *  5. 스프링 JDBC
	 *   - SQL로만 데이터 베이스를 쉽게 처리할 수 있도록 도와주는 JDBCTemplate 클래스를 제공한다.
	 *   
	 *   	1. JDBCTemplate 클래스가 제공하는 주요 메서드
	 *   	
	 *   		queryForObject
	 *   		- 하나의 결과 레코드 중에서 하나의 컬럼 값을 가져온다
	 *   		queryForMap
	 *   		- 하나의 결과 레코드 정보를 Map 형태로 매핑할 수 있다
	 *   		queryForList
	 *   		- 여러 개의 결과 레코드를 처리할 수 있다.
	 *   		query
	 *   		- ResultSetExtractor, RowCallbackHandler와 함께 조회할 때 사용한다.
	 *   		update
	 *   		- 데이터를 변경하는 SQL을 실행할 때 사용한다.
	 *   
	 *   	2. 스프링 JDBC 설정
	 *   	
	 *   	spring-jdbc 의존관계 설정
	 *   	> 위 3-1 의존관계 설정 참고 (pom.xml)
	 *   	데이터소스 설정
	 *   	> 위 3-2 데이터소스 설정 참고 (root-context.xml)
	 *   	> JDBCTemplate클래스를 빈으로 정의
	 *   
	 *   	<bean Id="JDBCTemplate" class="org.springframework.jdbc.core.JDBCTemplate">
	 *   		<property name="dataSource" ref="dataSource"/>
	 *   	</bean>
	 *   
	 *   	3. 게시판 구현 설명
	 *   	
	 *   	기본적인 CRUD를 바탕으로한 게시판 구현입니다.
	 *   
	 *   6. JPA(p478)
	 *    - JPA(Java Persistence API)는 자바 표준 ORM입니다.
	 *    
	 *   	 *** ORM이란?
	 *    	  	객체에 데이터를 읽고 쓰는 방법으로 관계형 데이터베이스에 데이터를 읽고 쓰는 기술입니다.
	 *    
	 *    	*** 기업 면접에서 ORM은 뭐 쓰셨어요? 라는 질문!
	 *    	  	- 네, 저는 ibatis를 사용했습니다. 또는 네, 저는 mybatis 를 사용했습니다 라는 대답!
	 *    
	 *    데이터베이스 설계 라인이 정확하게 설계되어 있는 상태에서 JPA가 가독성이 좋다지만 우리는 mybatis로 !
	 *    
	 *    
	 *    7. 마이바티스 (p495)
	 *     - SQL과 자바 객체를 매핑하는 아이디어로 개발된 데이터 베이스 접근용 프레임워크이다.
	 *     
	 *     		아래는 내용정도만 참고! 실제 적용은 12장에서 진행하도록 합니다
	 *     
	 *     		1) 의존관계 정의
	 *     		- pom.xml에 mybatis설정을 위한 의존 관계를 등록하도록 합니다!
	 *     		> mybatis
	 *     		> mybatis-spring
	 *     		> spring-jdbc
	 *     		> commons-dbcp2
	 *     		> log4jdbc-log4j2-jdbc4
	 *     		> ojdbc6 또는 8
	 *     
	 *   		2) 스프링과 마이바티스 연결 설정
	 *          - root context.xml
	 *          > dataSource
	 *          > sqlSessionFactory
	 *          > sqlSessionTemplate
	 *          
	 *          3) 마이바티스 설정
	 *          	- webapp/WEB-INF/mybatisAlias/mybatisAlias.xml설정
	 *           	- 사용할 자바빈즈 클래스들의 패키지명이 포함된 경로 부분을 제외하고 클래스 명과 매핑된 별칭으로 사용할 수 있게 셋팅
	 *              - '_'로 연결 되어 있는 변수명들을 카멜기법을 이용하여 'bo_no'를 'boNo'로 변환되서 사용할 수 있도록 셋팅
	 *          
	 *          4) 마이바티스 구현
	 *          	- mapper 패키지안에 Mapper 파일 구성 (.xml)       
	 *          	> mapper 패키지안에 boardMapper_SQL.xml 구성       
	 *     		
	 *    
	 *    
	 *   
	 *   
	 *   
	 * 
	 */
}
