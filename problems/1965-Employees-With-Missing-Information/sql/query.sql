SELECT employee_id
FROM (
    SELECT e.employee_id,
      name,
      salary
    FROM Employees e
      LEFT JOIN Salaries s ON e.employee_id = s.employee_id
    UNION
    SELECT s.employee_id,
      name,
      salary
    FROM Employees e
      RIGHT JOIN Salaries s ON e.employee_id = s.employee_id
  ) sub
WHERE name IS null
  OR salary IS null
ORDER BY employee_id;