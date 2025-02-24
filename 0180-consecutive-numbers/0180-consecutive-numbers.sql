# Write your MySQL query statement below
WITH Grouped_Numbers AS (
    SELECT id, num, id - ROW_NUMBER() OVER (PARTITION BY num ORDER BY id) as group_id
    FROM Logs
)
SELECT DISTINCT num as ConsecutiveNums
FROM Grouped_Numbers
GROUP BY num, group_id
HAVING count(*) >= 3
ORDER BY num, group_id;