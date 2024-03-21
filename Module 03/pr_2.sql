SELECT * FROM employees;


--pr
select  first_name, job_id, salary as "Heighest Salary Basis", salary*12 as "Yarly Salary"
from employees where salary not in 9000 order by salary desc;

-- For String and dta we can use not in is equal <>
-- For order by table as number like 1,2,3


--fetch
Select first_name, job_id, salary, salary*12 as "Yarly Slary"
from employees where salary <> 9000
order by salary desc 
offset 5 rows fetch next 5 rows only --fetch first 5 rows only
;

-- fetch for showing smallest data only ;
-- offset 5 fetch first 10/5 rows only ;
-- for show using promt =  "&employee_name" (show all input value);
-- for show using promt <>(not equal)not in 9000 &salary (show except input value);
-- shorting smallest is automitically but we can short by largest to smallest using DESC ;
-- we can use as and string sign "" for changing table name ;

--&
select first_name, job_id
from
employees
where first_name = '&Employee_name';

--&
select first_name, job_id, salary, salary*12 as "Yarly Salary"
from
employees
where salary <> &Salary;


--Like
select first_name
from employees
where first_name like '%&first_name%'
order by first_name desc
;

 




