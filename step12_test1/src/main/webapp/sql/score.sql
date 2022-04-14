-- 1) 테이블 생성
create table score (
	studNo varchar2(30) primary key,   
	name varchar2(30) not null,
	kor number, 
	eng number, 
	mat number, 
	tot number,
	avg number(4, 1),
	logtime date
);
-- 2) 테이블 삭제
drop table score purge;
-- 3) 테이블 확인
select * from tab;

-- 3) 데이터 저장 : insert
insert into score values ('2022001', '홍길동', 90, 80, 70, 240, 80.0, sysdate);
-- 4) 데이터 검색
select * from score;
select * from score order by studNo asc;
select * from score where studNo='2022001';
-- 5) 데이터 수정
update score set kor=92,eng=82,mat=72,tot=246,avg=82.0
where studNo='2022001';
-- 6) 데이터 삭제
delete score where studNo='2022001';
-- 7) DB 저장
commit;
