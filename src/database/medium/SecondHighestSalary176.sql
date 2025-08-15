SELECT max(salary) as SecondHighestSalary
FROM Employee
WHERE salary <>(select max(salary) from Employee);


SELECT
    max(salary) as SecondHighestSalary
FROM (
    select
        salary,
        dense_rank() over(order by salary desc) as rnk
        from Employee
) Employees WHERE rnk=2;