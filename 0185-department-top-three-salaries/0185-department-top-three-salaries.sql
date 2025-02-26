/* Write your PL/SQL query statement below */
SELECT DISTINCT d.name AS Department, e.name AS Employee, e.salary AS Salary
FROM Employee e
JOIN Department d ON e.departmentId = d.id 
JOIN (
    SELECT e1.departmentId, e1.salary, DENSE_RANK() OVER (PARTITION BY e1.departmentId ORDER BY e1.salary DESC) AS rank
    FROM Employee e1
) r ON e.departmentId = r.departmentId AND e.salary = r.salary
WHERE r.rank <= 3
ORDER BY d.name, e.salary DESC;