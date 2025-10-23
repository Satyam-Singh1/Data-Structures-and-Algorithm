# Write your MySQL query statement below   
UPDATE Salary
SET sex = case
WHEN sex = 'm' THEN 'f'
ELSE 'm'
END;