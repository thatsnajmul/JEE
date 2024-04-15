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


-----------------------------
--Chapter--6
-----------------------------
select max(salary) as maximum, 
min(salary) as minimum,
round(avg(salary)) as avarage
from employees;


select job_id, 
min(salary) as minimum,
sum(salary) as minimum,
round(avg(salary)) as avarage
from employees
group by job_id;

select job_id, count(*)
from employees
group by job_id;

select count(distinct(manager_id)) as "Number of Managers"
from employees;

select max(salary)- min(salary)
from employees;

select manager_id, min(salary)
from employees
where manager_id is not null
group by manager_id 
having min(salary)>6000
order by 2 desc;

select count(*) as "Total",
sum(case when to_char(hire_date,'YYYY')=2005 then 1 else 0 end) as "2005",
sum(case when to_char(hire_date,'YYYY')=2006 then 1 else 0 end) as "2006",
sum(case when to_char(hire_date,'YYYY')=2007 then 1 else 0 end) as "2007",
sum(case when to_char(hire_date,'YYYY')=2008 then 1 else 0 end) as "2008"
        from employees;
        
        
select job_id as "Job",
sum(decode(department_id, 20, salary)) "Dept 20",
sum(decode(department_id, 50, salary)) "Dept 50",
sum(decode(department_id, 80, salary)) "Dept 80",
sum(decode(department_id, 90, salary)) "Dept 90"
from employees
group by job_id;



--========================
--Chapter 7
--========================
select location_id, street_address, city, state_province, country_name
from locations
natural join countries;


select last_name, department_id, department_name
from employees
natural join departments;

select e.last_name, d.department_id, d.department_name
from employees e
join departments d on d.department_id=e.department_id;

select e.last_name, e.job_id,e.department_id, d.department_name
from employees e
join departments d on d.department_id=e.department_id
join locations l on d.location_id=l.location_id
where l.city='Toronto';


select e.last_name as "Employee", e.employee_id as "Emp#", m.last_name as "Manager", m.employee_id as "Mgr#"
from employees e
join employees m on m.employee_id=e.manager_id;

select e.last_name as "Employee", e.employee_id as "Emp#", m.last_name as "Manager", m.employee_id as "Mgr#"
from employees e
join employees m on m.employee_id=e.manager_id
order by 2;

select e.department_id, e.last_name, e.last_name
from employees e
join employees es on e.department_id=es.department_id
where e.employee_id <> es.employee_id
order by 1;
        
