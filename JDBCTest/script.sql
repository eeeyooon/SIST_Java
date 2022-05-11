--JDBCTest에 저장 --05/10

--주소록 테이블

select * from tblAddress order by seq;

create table tblAddress(
        seq number primary key,
        name varchar2(10) not null,
        age number(3) not null check (age between 0 and 150),
        gender char(1) not null check(gender in ('m', 'f')),
        tel varchar2(15) not null,
        address varchar2(300) not null,
        regdate date default sysdate not null
);

create sequence seqAddress;

insert into tblAddress (seq, name, age, gender, tel, address, regdate)
    values (seqAddress.nextVal, '홍길동', 20, 'm', '010-1234-5678', '서울시 강남구 역삼동 한독빌딩', default);

update tblAddress set age = age + 1 where seq = 1;


--이제부턴 의식적으로 커밋해야해
--커밋안하면 sqlDeveloper에서 작업한 내용을 이클립스에선 사용 x (물리적으론 저장이 안된거니까)
commit;    

--Java에서 시퀀스 객체 생성하면
select seqJava.nextVal from dual;
--여기서 확인 가능

--select seqsql.nextVal from dual;

select * from tblInsa;
select * from tblBonus;



select m.name, v.name from tblVideo v inner join tblRent r on v.seq = r.video inner join tblMember m on m.seq = r.member;


--Ex06_CallableStatement.java

--m1. 인자값, 반환값
create or replace procedure procM1
is
begin
    insert into tblAddress (seq, name, age, gender, tel, address, regdate)
    values (seqAddress.nextVal, '홍길동', 20, 'm', '010-1234-5678', '서울시 강남구 역삼동 한독빌딩', default);

end;


--m1. 인자값(O), 반환값(X)

create or replace procedure procM2(
        --프로시저도 %type가능
        pname         tblAddress.name%type,
        page            tblAddress.age%type,
        pgender      tblAddress.gender%type,
        ptel              tblAddress.tel%type,
        paddress    tblAddress.address%type
)
is
begin

        insert into tblAddress (seq, name, age, gender, tel, address, regdate)
        values (seqAddress.nextVal, pname, page, pgender, ptel, paddress, default);
        
end;

--자바에서 호출하기 전에 검증해야해!! *******
begin
        procM2('이름', 20, 'm', '010-1111-1111', '주소');
end;

select * from tblAddress order by seq desc;

--여기까지 검증하면 자바로 가서 작업


--m3. 인자값(X), 반환값(O) OUT 파라미터

create or replace procedure procM3(
    pcount out number
)
is
begin

        select count(*) into pcount from tblAddress;
        
end procM3;

set serveroutput on;

declare
        vcount number;
begin
        procM3(vcount);
        dbms_output.put_line(vcount);
end;


--문제] 직원번호를 입력하면 그 직원의 이름, 부서, 직위, 지역을 반환 + 출력
-- 직접 프로시저부터 만들어라. = procM4
-- in > 직원 번호
-- out > 이름
-- out > 부서
-- out > 직위
-- out > 지역

create or replace procedure procM4(
       
        pnum in number,
        pname out varchar2,
        pbuseo out varchar2,
        pjikwi out varchar2,
        pcity out varchar2
)
is
begin
        
        select name, buseo, jikwi, city into pname, pbuseo, pjikwi, pcity from tblInsa where num = pnum;
        
end procM4;


--검증
declare
        vname tblInsa.name%type;
        vbuseo tblInsa.buseo%type;
        vjikwi tblInsa.jikwi%type;
        vcity tblInsa.city%type;
        
begin
        procM4(1001, vname, vbuseo, vjikwi, vcity);
        dbms_output.put_line(vname);
        dbms_output.put_line(vbuseo);
        dbms_output.put_line(vjikwi);
        dbms_output.put_line(vcity);

end;



--m5.
create or replace procedure procM5 (
        pbuseo in varchar2,
        pcursor out sys_refcursor
        
)
is
begin

        open pcursor
        for
                select name, jikwi, basicpay
                        from tblInsa 
                                where buseo = pbuseo;

end procM5;


--검증

declare
        pcursor         sys_refcursor;
        vname           tblInsa.name%type;
        vjikwi             tblInsa.name%type;
        vbasicpay      tblInsa.basicpay%type;
begin
        
        procM5('개발부', pcursor);
        
        loop
                fetch pcursor into vname, vjikwi, vbasicpay;
                exit when pcursor%notfound;
                
                dbms_output.put_line(vname || ',' || vjikwi || ',' || vbasicpay );
                
        end loop;
end;



--m6

select * from tblBonus;

create or replace procedure procM6(
        pbuseo in varchar2,
        pcursor out sys_refcursor
)
is

begin
        
        --1. 부서명 > 직원 번호
        --2. 직원번호 > 보너스 지급 내역
        open pcursor for --커서를 out 파라미터로 돌려주는 것
                                select name, bonus from tblInsa i
                                        left outer join tblBonus b
                                                on i.num = b.num
                                                        where buseo = pbuseo;
        
end procM6;


declare
        vname varchar2(30);
        vbonus number;
        vcursor sys_refcursor;
        
begin 
        procM6('기획부', vcursor);
        
        loop
                fetch vcursor into vname, vbonus;
                exit when vcursor%notfound;
                
                dbms_output.put_line(vname || '>' || vbonus);
        end loop;

end;




