# Web Application
## 이클립스에서 톰캣 서버 실행환경 구축하기
### 톰캣 서버가 설치된 경로를 설정한다.
- window 메뉴 > Preferences 메뉴 > Server 노드 > Runtime Environments 노드 에
  톰캣 서버의 경로를 추가한다.

### 웹 애플리케이션 테스트를 위한 톰캣 실행 환경 구축
- Servers 뷰 > 새 서버 추가
- 이클립스 왼편의 "Project Explorer" 창에 "Servers" 폴더가 생성된다.
- Servers 폴더 아래에 톰캣 실행 환경 폴더가 생성된다.
  예) Servers/A고객사-config
- 톰캣 실행 환경 폴더에는 원래 톰캣 서버에 있던 설정 파일을 복사한 파일이 있다.
  => 이클립스에서 톰캣 서버를 실행할 때 마다 이 설정 파일을 사용한다.

### 이클립스에서 실행한 톰캣 서버에 웹 애플리케이션 배포
- 톰캣 서버가 설치된 원래의 폴더($톰캐서버/webapps)를 사용하지 않는다.
- 대신 워크스페이스의 특정 폴더에 별도의 배포 폴더를 구축하여 사용한다.
  C:\bitcamp\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps
- 왜 톰캣 서버가 설치된 폴더를 사용하지 않는가?
  다양한 고객사나 웹 애플리케이션을 동시에 테스트하기 위해서이다.
- 이클립스에서 실행한 톰캣 서버에 웹 애플리케이션을 배포하려면,
  이클립스 규칙에 따라 웹 애플리케이션 프로젝트를 만들어야 한다.
  예) File 메뉴 > New 메뉴 > Dynamic Web Project 메뉴를 선택하여 웹 프로젝트를 만든다.
  
## Dynamic Web Project 폴더 구조
- src : 자바 소스 파일을 두는 폴더.
- WebContent : HTML, CSS, JavaScript, 이미지 파일, JSP 파일을 두는 폴더.
               WEB-INF 폴더도 이 폴더에 생성한다. 

## 웹 애플리케이션을 톰캣 실행 환경에 배치
- 톰캣 실행환경의 배치 폴더에 프로젝트 이름으로 하위 폴더를 생성한다.
  예) ...\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\web02
- WebContent 폴더에 있던 모든 파일과 디렉토리를 배치 폴더에 복사한다.
- src 폴더에 있던 자바 파일을 컴파일하여 배치 폴더의 WEB-INF/classes 밑에 복사한다.
- 이 모든 것을 자동으로 수행한다.

## step02
- 웹 애플리케이션의 세가지 컴포넌트
- MyServlet.java : 서블릿 
  => 클라이언트의 요청을 처리하기.
  => Servlet 인터페이스를 구현해야 한다.
  
- MyFilter.java : 필터
  => 서블릿을 호출하기 전/후에 실행되는 컴포넌트.
  => Filter 인터페이스를 구현해야 한다.   

- MyServletContextListener.java : 리스너
  => 서블릿 컨테이너가 특정 상태가 되었을 때 호출되는 컴포넌트.
  => 상태 예)
     - 웹 애플리케이션이 시작되거나 종료될 때,
     - 서블릿 요청 속성이 추가되거나 제거될 때,
     - 세션 속성이 추가되거나 제거될 때,
     - 세션이 활성화되거나 비활성화될 때,
     - 세션이 생성되거나 제거될 때,
  => 각 상태 별로 정의된 인터페이스를 구현하면 된다.       

## step03
- Servlet01.java => @WebServlet 애노테이션을 이용한 서블릿 배치
- Servlet02.java => 웹 브라우저로 출력하기







