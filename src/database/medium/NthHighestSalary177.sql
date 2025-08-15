CREATE OR REPLACE FUNCTION NthHighestSalary(N INT)
RETURNS INT
LANGUAGE plpgsql
AS $$
DECLARE
    OFFSET_VAL INT;
    RESULT_SALARY INT;
BEGIN

    IF N<=0 THEN
        RETURN NULL;
    END IF;

    -- Ajustar N para usar OFFSET (posición empieza en 0)
    OFFSET_VAL := N-1;
    SELECT DISTINCT SALARY
    INTO RESULT_SALARY
    FROM Employee
    ORDER BY salary DESC
    LIMIT 1 OFFSET OFFSET_VAL;

    RETURN RESULT_SALARY;
END;
$$;

-- postgresql
/*
CREATE OR REPLACE FUNCTION NthHighestSalary(N INT)
    Crea o reemplaza una función llamada NthHighestSalary.
    Recibe como parámetro un entero N (el puesto de salario que quieres obtener).

RETURNS TABLE (Salary INT)
    Indica que la función devuelve una tabla con una sola columna llamada Salary de tipo entero.

AS $$ ... $$ LANGUAGE plpgsql;
    Delimita el cuerpo de la función ($$ es un delimitador de cadenas en SQL).
    LANGUAGE plpgsql especifica que está escrita en el lenguaje procedural de PostgreSQL.

RETURN QUERY (...)
    Devuelve directamente el resultado de una consulta SQL que se coloca entre paréntesis.
    En tu caso, dentro iría la consulta que obtiene el N-ésimo salario más alto.
*/


-- En esa función, el GROUP BY E.SALARY se usa como un truco para eliminar duplicados de salarios, algo similar a usar DISTINCT.
-- Pero en PostgreSQL, GROUP BY E.salary produce el mismo efecto de quitar duplicados que DISTINCT, así que a veces la gente lo usa por costumbre o estilo.

create or replace function NthHighestSalary(n int)
returns table(Salary int) as $$
BEGIN
    IF N < 1 THEN
        RETURN QUERY(
            SELECT NULL::INT AS SALARY
        );
    END IF;
    RETURN QUERY(
        SELECT E.SALARY
        FROM EMPLOYEE E
        GROUP BY E.SALARY
        ORDER BY E.SALARY DESC
        OFFSET N-1 LIMIT 1
    );
END;
$$ LANGUAGE plpgsql;


CREATE OR REPLACE FUNCTION NthHighestSalary(n INT)
RETURNS TABLE (salary INT)
LANGUAGE sql
AS $$
SELECT CASE
         WHEN n < 1 THEN NULL::INT
         ELSE (
           SELECT s.salary
           FROM (SELECT DISTINCT salary FROM employee) AS s
           ORDER BY s.salary DESC
           OFFSET n - 1
           LIMIT 1
         )
       END AS salary;
$$;
