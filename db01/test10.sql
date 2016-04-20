주제: JOIN

1. CROSS 조인(=CARTESIAN 조인)
=> n * m 조인. 두 결과 데이터를 1:1로 연결한다.
=> 조인 전
SELECT LNO,TITL FROM LECTS;
SELECT RNO,RNM FROM ROOMS;

=> 1:1 크로스 조인
SELECT LNO,TITL,LECTS.RNO,RNM 
FROM LECTS, ROOMS;

=> 최신 문법
SELECT LNO,TITL,LECTS.RNO,RNM 
FROM LECTS CROSS JOIN ROOMS;

=> 테이블 별명 사용
SELECT LNO,TITL,L.RNO,RNM 
FROM LECTS L CROSS JOIN ROOMS R;

2. NATUAL 조인(=EQUI 조인)
=> 공통 컬럼을 기준으로 조인한다.
SELECT LNO,TITL,LECTS.RNO,RNM 
FROM LECTS, ROOMS
WHERE LECTS.RNO=ROOMS.RNO;

=> 조건 검색 시 테이블 이름을 사용하면 불편하다. => 별명 사용하라!
SELECT LNO,TITL,L.RNO,RNM 
FROM LECTS AS L, ROOMS AS R
WHERE L.RNO=R.RNO;

=> AS 생략 가능!
SELECT LNO,TITL,L.RNO,RNM 
FROM LECTS L, ROOMS R
WHERE L.RNO=R.RNO;

=> 최신 문법 => 두 테이블에 이름이 같은 컬럼이 있으면 그 컬럼을 기준으로 조인한다.
SELECT LNO,TITL,L.RNO,RNM 
FROM LECTS L NATURAL JOIN ROOMS R;

3. JOIN ~ USING(컬럼)
=> 두 테이블에 같은 이름을 가진 컬럼이 여러 개 있을 경우,
   특정 컬럼으로 조인하고 싶을 때 사용한다.
SELECT LNO,TITL,L.RNO,RNM 
FROM LECTS L JOIN ROOMS R USING(RNO);

4. JOIN ~ ON 조건
=> 두 테이블을 조인할 때 사용할 컬럼이 이름이 같지 않을 때.
SELECT LNO,TITL,L.RNO,RNM 
FROM LECTS L JOIN ROOMS R ON L.RNO=R.RNO;

5. OUTER JOIN
=> 두 테이블의 데이터를 조인할 경우,
   한쪽 테이블의 데이터를 모두 출력하고 싶을 때 사용.
=> 두 개 테이블을 조인할 때 어느 쪽 테이블을 기준으로 할 것인지 지정한다.
=> 교육과정 기준으로 조인 
SELECT LNO,TITL,L.RNO,RNM 
FROM LECTS L LEFT OUTER JOIN ROOMS R ON L.RNO=R.RNO;

=> 강의실 기준으로 조인
SELECT LNO,TITL,L.RNO,RNM 
FROM LECTS L RIGHT OUTER JOIN ROOMS R ON L.RNO=R.RNO;

=> 교육과정-강의실-강사번호
SELECT L.LNO,L.TITL,RNM,TA.TNO 
FROM LECTS L LEFT OUTER JOIN ROOMS R ON L.RNO=R.RNO
             LEFT OUTER JOIN TEA_ASSIGN TA ON L.LNO=TA.LNO;

=> 교육과정-강의실-강사번호-강사명
SELECT L.LNO,L.TITL,RNM,T.TNM 
FROM LECTS L LEFT OUTER JOIN ROOMS R ON L.RNO=R.RNO
             LEFT OUTER JOIN TEA_ASSIGN TA ON L.LNO=TA.LNO
             LEFT OUTER JOIN TEACHS T ON TA.TNO=T.TNO;








