/* Write your PL/SQL query statement below */
SELECT score, rank 
FROM (
    SELECT id, score, DENSE_RANK() OVER (ORDER BY score DESC) as rank 
    FROM Scores
) ranked_scores
ORDER BY rank;