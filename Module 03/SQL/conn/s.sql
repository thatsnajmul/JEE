--Create a table and name using your id preceded by emp(as emp106588), which have 5 fields as eid, ename, salary, hire_date, and address with appropriate data types and create primary key on eid

create table emp1281305(
eid int primary key not null, 
ename varchar(30),
salary number (15),
hire_date  date,
address varchar(255));
commit;

--Add two new columns named department_id,dept_name alter table command

alter table emp1281305 add(department_id int ,department_name varchar2(50));

--Insert values to the table
insert into emp1281305(eid,ename,salary,hire_date,address)
values(1,'Md Abid Hasan','30000','21-apr-2024','Dhaka Sadar');

--Create a view that which contains ename, dept_name and salary in department 80
create view emo as ename,department_name,salary
;

--Create a sequence
Create sequence emp1281305
increment by 1
min value 80
max value 100
nocache
nocycle;


--Give an appropriate example of insert data from subquries

insert into emp105579(address)
value('Dhaka Old')
where in
(insert into emp105579 where eid=1);























--1
create table emp8105(eid int primary key not null,ename varchar2(30),salary varchar2(30), hire_date date, adrress varchar2(30));

--Display the department numbers and avarage salaries for those departments with a maximum salary that is greater than 12000
select department_id, salary
from employees
where salary>12000;

--3  Display the name whose name start from S
select first_name 
from employees
where first_name  like '%S%';

--4(display the avg salary of employees of departments sales)
select avg(salary)
from employees
where commission_pct=.5;

--5(Display the name of employees joining in company in ascending order)
Select first_name||' '||last_name as Name, hire_date
from employees
order by 2;




















