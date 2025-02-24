CREATE FUNCTION getNthHighestSalary(N IN NUMBER) RETURN NUMBER IS
result NUMBER;
BEGIN
    /* Write your PL/SQL query statement below */
    SELECT MIN(salary) INTO result
    FROM (
        SELECT salary, DENSE_RANK() OVER (ORDER BY salary DESC) as rnk
        FROM Employee
    ) ranked_salaries
    WHERE rnk = N;
    RETURN result;

EXCEPTION
    WHEN NO_DATA_FOUND THEN
    RETURN NULL;
END;