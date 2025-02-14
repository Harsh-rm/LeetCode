/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    private int result;
    public int getImportance(List<Employee> employees, int id) {
        result = 0;

        if (employees == null || employees.size() == 0) return result;

        HashMap<Integer, Employee> idToEmployeeMap = new HashMap<>();
        
        for (Employee e: employees) {
            idToEmployeeMap.put(e.id, e);
        }

        Queue<Integer> bfs = new LinkedList<>();

        bfs.add(id);

        while (!bfs.isEmpty()) {
            Employee curr = idToEmployeeMap.get(bfs.poll());

            result += curr.importance;

            List<Integer> temp = curr.subordinates;

            for(Integer num: temp) {
                bfs.add(num);
            }
        }

        return result;
    }
}