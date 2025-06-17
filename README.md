⏰ JPA Study Project</br>
이 프로젝트는 간단한 사용자 정보를 JPA를 통해 데이터를 저장하는 프로젝트다.</br>
콘솔에서 데이터를 입력하여 DataBase에 저장할 수 있다.
</br>

🧪 테스트 방법
- Tool : IntelliJ IDEA
- DataBase : MySQL
- 접속정보 : jdbc:mysql://localhost:3306/jpabegin?characterEncoding=utf8 / root / password1234

[Main클래스 실행]
- "/"문자를 구분자로 실행할 모드와 사용자 정보를 입력한다. 
1. new : 사용자 생성
2. get : 사용자 조회
3. change name : 사용자 이름 변경
4. remove : 사용자 삭제
5. exit : 종료


ex) 사용자 생성
- new/user1@user.com/user1/인천시/한화아파트/1234
  
![image](https://github.com/user-attachments/assets/bd0c0112-117b-4648-98ed-4065be19a85b)

<결과>

![image](https://github.com/user-attachments/assets/1dda677f-81fa-42f5-a30d-e1117b363cb6)


※ 사용자 생성 외에는 모드/이메일(키값)만 입력하여 테스트할 수 있다.
