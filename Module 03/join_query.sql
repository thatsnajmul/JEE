select first_name, last_name, salary
from employees
--Join query
where city='oxford';

---Join Query
select first_name, department_name, last_name, hire_date
from employees e
join departments d on d.department_id=e.department_id
join jobs j on e.job_id=j.job_id
join job_history h on e.employee_id=h.employee_id
where to_char(h.start_date, 'YYYY') between 2000 and 2005
order by 4;


-- left, right or full outer join
select e.last_name, e.department_id, d.department_name
from employees e 
left outer join departments d
on e.department_id = d.department_id;

--Cartesian Products

