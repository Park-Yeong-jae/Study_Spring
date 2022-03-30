-- Book4
-- 테이블 생성
create table book4 (
    book4_code varchar(30) primary key,
    book4_name varchar(30) not null,
    book4_author varchar(30) not null,
    book4_publisher varchar(30),
    book4_price number,
    book4_date varchar(30)
);
-- 테이블 확인
select * from tab;
-- 테이블 구조 확인
select * from book4;
-- 테이블 삭제
drop table book4 purge;
-- 데이터 추가
insert into book4 values('0789', '홍길동책', '홍길동', '이젠', 15000, '2022-03-21');
-- 인덱스 뷰
select * from
(select rownum rn, tt.* from
(select * from book4 order by book4_code asc) tt)
where rn>=1 and rn<=5;
-- 정렬(코드기준)
select * from book4 order by book4_code asc;
-- 전체 데이터 개수 구하기
select count(*) as cnt from book4;
-- 데이터 저장
commit;