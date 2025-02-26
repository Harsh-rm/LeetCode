/* Write your PL/SQL query statement below */
DELETE FROM Person
WHERE id IN (
    SELECT id FROM (
        SELECT id, ROW_NUMBER() OVER (PARTITION BY email ORDER BY id) AS row_num
        FROM Person
    ) 
    WHERE row_num > 1
);