
-- 회원(tbl_member)
-- 아이디, 이름, 연락처, 포인트
create table tbl_member (
  member_id varchar2(30) primary key,
  member_name varchar2(50) not null,
  phone varchar2(20),
  point number default 100
);

insert into tbl_member (member_id, member_name)
values('user01', '홍길동');
insert into tbl_member (member_id, member_name)
values('happy', '김행복');
update tbl_member
set    phone = '010-1232-9871' --, point = 200
where member_id = 'user01';