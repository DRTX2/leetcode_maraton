select name as Employee
from Employee e1
where
    managerId is not null
    and salary > (
        select salary
        from Employee e2
        where e1.managerId=e2.id
    );


--- 2

select e1.name as Employee
from Employee e1
join Employee e2 on e1.managerId=e2.id
    where e1.salary > e2.salary;