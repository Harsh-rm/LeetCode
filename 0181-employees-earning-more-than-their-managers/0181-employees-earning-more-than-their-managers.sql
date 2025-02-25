/* Write your PL/SQL query statement below */
SELECT e1.name AS Employee
FROM Employee e1
WHERE EXISTS (
    SELECT 1
    FROM Employee e2
    WHERE e1.managerId = e2.id
    AND e1.salary > e2.salary
);