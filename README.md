# 도서관리 프로그램


* 프로젝트 기간 : 2022.03.29 - 2022.04.10


* 수행 인원 : 1명


* 개발 환경

  Language : Java

  Tool : Eclipse, AmaterasUML

  User Interface : console



* 프로젝트 개요 및 목적

 관리자와 회원 계정을 분리하여 효율적인 도서 관리 프로그램을 개발한다. 관리자는 시스템을 통해 회원 관리와 도서 관리가 가능하다. 회원은 도서와 관련한 서비스를 제공받을 수 있다. 프로그램은 자바의 기본적인 문법과 IO 스트림을 활용하여 구현하는 것을 목표로 한다
 
 


* 주요 기능

   ● 관리자 기능
   
      - 관리자 계정 등록
      
      - 관리자 계정 로그인
      
      - 관리자 계정 로그아웃


   ● 회원 기능
   
      - 회원 계정 등록
      
      - 회원 로그인
      
      - 회원 로그아웃
      
      - 회원 조회
      - 
      - 도서 대여 내역 조회
      
      - 회원 탈퇴 
      
      - 회원 정보 수정
      
      - 연체 여부 조회

   ● 도서 기능
   
      - 도서 등록
       
      - 전체 도서 조회
      
      - 도서 검색
      
      - 도서 삭제
      
      - 도서 대출 여부 조회

   ● 대여 기능
   
      - 도서 대여

   ● 반납 기능
   
      - 도서 반납




* workflow

![image](https://user-images.githubusercontent.com/100884647/162617859-690fefe8-02df-4157-a471-1e45aadcff5d.png)




* Class Diagram

![image](https://user-images.githubusercontent.com/100884647/162617879-accfee80-6759-4d2a-ba03-eed2967b005e.png)




* 도서관리 프로그램 시연 영상


<iframe width="949" height="534" src="https://www.youtube.com/embed/59Jj67B8FKY" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>





* 보완점

① 객체지향에 대한 이해 부족
: 입출력 부분과 비즈니스 로직을 완전히 분리해야 하는데, 아직 객체지향에 대한 개념이 부족하여 기능 클래스 내부에서 출력을 하는 문제점이 있었다. 또한 중복되는 코드가 있어 아쉬움이 있다. 이후 디자인 패턴을 학습하여 다음에는 좀 더 객체지향적인 코드를 구현하기 위해 노력할 것이다.

② 스트림 IO 이해 부족
: 스트림에 대해서 명확한 이해가 부족하여 중복되는 데이터들을 저장하는 경우가 있었다. 추가적인 학습을 통해 스트림 활용에 대해 명확히 알고 구현할 수 있도록 할 것이다.
