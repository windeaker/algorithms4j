176. 第二高的薪水

编写一个 SQL 查询，获取 Employee 表中第二高的薪水（Salary） 。

+----+--------+
| Id | Salary |
+----+--------+
| 1  | 100    |
| 2  | 200    |
| 3  | 300    |
+----+--------+
例如上述 Employee 表，SQL查询应该返回 200 作为第二高的薪水。如果不存在第二高的薪水，那么查询应返回 null。

+---------------------+
| SecondHighestSalary |
+---------------------+
| 200                 |
+---------------------+

正解1：
select max(Salary) as SecondHighestSalary from Employee where Salary<(select max(Salary) from Employee)
正解2：
select IFNULL((select Distinct Salary from Employee order by Salary DESC limit 1,1),null) as SecondHighestSalary

我的错误解法：
select Salary as SecondHighestSalary from Employee order by Salary DESC limit 1,1;
输入：
{"headers": {"Employee": ["Id", "Salary"]}, "rows": {"Employee": [[1, 100]]}}
输出：
{"headers":["SecondHighestSalary"],"values":[]}
预期：
{"headers":["SecondHighestSalary"],"values":[[null]]}