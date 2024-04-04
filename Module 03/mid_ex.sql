--Question 1
Select first_name ||' '||last_name as EMPLOYEE_NAME , salary
    from employees
         where first_name like '%a' order by 1 fetch first 2 row only;
                                
        
--Question 2
select first_name, salary, salary+(salary*30/100) as BONUS
    from employees;
    
--question 3
select first_name,last_name, salary
   from employees
        where salary>2500;
   
--Question 4
select first_name||' '||last_name as EMPLOYEE_NAME , salary*12 as ANUAL_SALARY
       from employees order by 2 asc;
       
       
-- 3
select last_name, salary
from employees
where salary not between 5000 and 12000;


--5
select last_name, department_id,salary
from employees
where department_id in (20,50)
--department_id=20 or department_id=50
order by 1;

--6
select last_name as "Employee", salary "Monthly Salary"
from employees
where salary between 5000 and 12000 and department_id in (20,50);

--9
select last_name, salary, commission_pct
from employees
where commission_pct is not null
order by 2 desc, 3 desc;

--15
select last_name, salary, commission_pct
from employees
where commission_pct = 0.2;

---02
select employee_id,last_name, salary, round(salary+(salary*15.5/100)) as "New Salary"
from employees 
order by 4;

--5
select last_name, length(last_name)
from employees
where last_name like 'J%' or last_name like 'A%' or last_name like 'M.%'
--substr(last_name,1)in ('J', 'A', 'M')
order by last_name;

--7
select last_name, LPAD(salary,15,'$') as salary --RPAD
from employees;

--5

Select last_name||' earns '||
to_char(salary, 'fm$999999.00')||' monthly but wants '||
to_char(salary*3, 'fm$999999.00')
from employees;


select last_name, hire_date, 
to_char(next_day(add_months(hire_date,6), 'Monday'), 'fmDay, "the" Ddspth "of" Month, YYYY')
from employees;
       

