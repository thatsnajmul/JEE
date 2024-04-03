--Question 1
                                
        
--Question 2
select first_name, salary, salary-(salary*0.3) as BONUS
    from employees;
    
--question 3
select first_name,last_name, salary
   from employees
        where salary>2500;
   
--Question 4
select first_name||' '||last_name, salary*12 as ANUAL_SALARY
       from employees order by 2 asc;
       

