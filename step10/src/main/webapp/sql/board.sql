-- * 글관리
-- 1) 테이블 생성
create table board (
    seq number not null,            -- 글번호
    id varchar2(20) not null,       -- 아이디
    name varchar2(40) not null,     -- 이름
    subject varchar2(250) not null, -- 제목
    content varchar2(4000) not null,-- 내용
    hit number default 0,           -- 조회수
    logtime date default sysdate    -- 작성일
);

-- 2) 테이블 없애기
drop table board purge;

-- 3) 테이블 목록
select * from tab;

-- 4) 시퀀스 객체 생성
create sequence seq_board nocache nocycle;

-- 5) 시퀀스 객체 삭제
drop sequence seq_board;

-- 6) 데이터 저장하기
insert into board values (seq_board.nextval, 'num1', '홍길동', 
'내일은', '웃으리...', 0, sysdate);

-- 7) 전체 내용 확인
select * from board;

-- 8) 특정 글번호로 내용 확인
select * from board where seq=45;

-- 9) 데이터 수정
update board set subject='오늘도', content='크게 웃으리'
where seq=1;
-- 조회수 증가하기
update board set hit = hit+1 where seq=45;

-- 10) 데이터 삭제
delete board where seq=1;
delete board where id='num1';
-- 11) db 저장
commit;

-- 12) 인덱스 뷰
-- hidden column => rownum
select * from
(select rownum rn, tt.* from
(select * from board order by seq desc) tt)
where rn>=6 and rn<=10;

-- seq 기준 내림 차순 정렬
select * from board order by seq desc;

-- seq 기준 내림 차순 정렬 결과에 별명 tt를 붙이고 
-- rownum을 추가하여 결과를 구하기
-- => 5개씩 끊어서 읽어오려면 일렬번호가 필요한데, 그 기준으로 seq는 사용할 수 없음
-- => 행번호는 select를 실행하면 반드시 일렬번호로 출력을 해서 결과를 보여준다.
--    그래서 일렬번호가 필요할 경우에는 rownum을 추가해서 사용함.
select rownum rn, tt.* from
(select * from board order by seq desc) tt;


select seq, id, name, subject, content, hit, 
to_char(logtime,'YYYY.MM.DD') as logtime from
(select rownum rn, tt.* from
(select * from board order by seq desc) tt)
where rn>=1 and rn<=5;

select seq, id, name, subject, content, hit, 
to_char(logtime, 'YYYY.MM.DD')as logtime from 
(select rownum rn, tt.* from 
(select * from board order by seq desc) tt) 
where rn>=1 and rn<=5;

-- 13) 총데이터 갯수 구하기
select count(*)  from board;
select count(*) as cnt from board;
