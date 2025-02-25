/* Write your PL/SQL query statement below */
SELECT DISTINCT email AS Email
FROM Person
GROUP BY email
HAVING COUNT(*) > 1;