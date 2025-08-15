select p.project_id, round(avg(e.experience_years),2) as average_years
from Project p join Employee e on p.employee_id = e.employee_id
group by p.project_id order by p.project_id;


-- Usar ::decimal asegura que el cálculo sea con precisión decimal exacta.
Select p.project_id, round( avg(e.experience_years ) :: decimal,2 ) as average_years
from project p
join employee e on p.employee_id = e.employee_id
group by project_id