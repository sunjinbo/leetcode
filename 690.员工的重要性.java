import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=690 lang=java
 *
 * [690] 员工的重要性
 */

// @lc code=start
/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    Map<Integer, Employee> map = new HashMap<>();

    public int getImportance(List<Employee> employees, int id) {
        for (int i = 0; i < employees.size(); ++i) {
            map.put(employees.get(i).id, employees.get(i));
        }
        return dfs(id);
    }

    int dfs(int id) {
        Employee employee = map.get(id);
        int total = employee.importance;
        List<Integer> subordinates = employee.subordinates;
        for (int subId : subordinates) {
            total += dfs(subId);
        }
        return total;
    }
}
// @lc code=end

