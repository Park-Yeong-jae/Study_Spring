--* 회원 관리
-- 1) 테이블 생성
create table member (
    name varchar2(30) not null,
    id varchar2(30) primary key,  -- 기본키, unique, not null
    pwd varchar2(30) not null,
    gender varchar2(5),
    email1 varchar2(20),
    email2 varchar2(20),
    tel1 varchar2(10),
    tel2 varchar2(10),
    tel3 varchar2(10),
    addr varchar2(100),
    logtime date
);
-- 테이블 구조 확인
desc member;
-- 테이블 삭제 
drop table member purge;

-- 테이블 확인
select * from tab;

-- 2) 데이터 추가
insert into member values ('홍길동','hong31','1234','남','hong',
'naver.com','010','1234','5678','경기도 수원시', sysdate);
insert into member values ('홍길동','hong32','1234','남','hong',
'naver.com','010','1234','5678','경기도 수원시', sysdate);
insert into member values ('홍길동','hong33','1234','남','hong',
'naver.com','010','1234','5678','경기도 수원시', sysdate);
insert into member values ('홍길동','hong34','1234','남','hong',
'naver.com','010','1234','5678','경기도 수원시', sysdate);
insert into member values ('홍길동','hong35','1234','남','hong',
'naver.com','010','1234','5678','경기도 수원시', sysdate);
insert into member values ('홍길동','hong36','1234','남','hong',
'naver.com','010','1234','5678','경기도 수원시', sysdate);
insert into member values ('홍길동','hong37','1234','남','hong',
'naver.com','010','1234','5678','경기도 수원시', sysdate);
insert into member values ('홍길동','hong38','1234','남','hong',
'naver.com','010','1234','5678','경기도 수원시', sysdate);
insert into member values ('홍길동','hong39','1234','남','hong',
'naver.com','010','1234','5678','경기도 수원시', sysdate);
insert into member values ('홍길동','hong40','1234','남','hong',
'naver.com','010','1234','5678','경기도 수원시', sysdate);

-- 3) 데이터 검색
select * from member;
select * from member where name='홍길동';
select * from member where id='hong';
select * from member where id='hong' and pwd='1234';
select * from member where id='kim';
-- 4) 데이터 수정
update member set tel2='2345' where id='hong';

update member set pwd='2345', email1='hongkd', email2='naver.com',
tel1='010', tel2='1234', tel3='5678', addr='경기도 수원시'
where id='hong';

-- 5) 데이터 삭제
delete member where id='hong';

-- 6) db 저장
commit;

-- 7) 인뎃스 뷰
select * from
(select rownum rn, tt.* from
(select * from member order by name asc) tt)
where rn>=1 and rn<=5;

select * from
(select rownum rn, tt.* from
(select * from member order by name asc, id asc) tt)
where rn>=1 and rn<=5;

select * from member order by name asc;
select * from member order by name asc, id asc;
