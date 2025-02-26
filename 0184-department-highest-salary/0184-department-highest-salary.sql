/* Write your PL/SQL query statement below */
SELECT DISTINCT d.name AS Department, e.name AS Employee, e.salary AS Salary
FROM Employee e
JOIN Department d ON e.departmentId = d.id
JOIN (SELECT e.departmentId, MAX(e.salary) AS MaxSalary
    FROM Employee e
    GROUP BY e.departmentId
) MaxSalaryTable ON e.departmentId = MaxSalaryTable.departmentId AND e.salary = MaxSalaryTable.MaxSalary;