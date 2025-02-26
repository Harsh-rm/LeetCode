# Write your MySQL query statement below
WITH GroupedEmails AS (
    SELECT id, email, ROW_NUMBER() OVER (PARTITION BY email ORDER BY id) AS row_num
    FROM Person
)
DELETE FROM Person p
WHERE p.id IN (
    SELECT ge.id
    FROM GroupedEmails ge
    WHERE ge.row_num > 1
    AND p.id = ge.id
);