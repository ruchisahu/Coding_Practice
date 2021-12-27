import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// Topological sort + BFS + directed graph
public class CourseSchedule {
    public static boolean canFinish(int numCourses, int[][] prerequisites){
        if(prerequisites == null || prerequisites.length == 0) return true;
        if(numCourses <= 0) return false;

        int count = 0;
        int[] indegree = new int[numCourses];
        for(int i = 0; i < prerequisites.length; i++){
            indegree[prerequisites[i][0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0){
                q.offer(i);
                count++;
            }
        }

        while(!q.isEmpty()){
            int start = q.poll();

            for(int i = 0; i < prerequisites.length; i++){
                if(start == prerequisites[i][1]){
                    indegree[prerequisites[i][0]]--;
                    if(indegree[prerequisites[i][0]] == 0){
                        q.add(prerequisites[i][0]);
                        count++;
                    }
                }
            }
        }
        return count == numCourses;
    }

    public static int[] finishOrder(int numCourses, int[][] prerequisites){
        if(prerequisites == null || prerequisites.length == 0) return null;
        if(numCourses <= 0) return null;

        int[] ans = new int[numCourses];
        int index = 0;
        int[] indegree = new int[numCourses];
        for(int i = 0; i < prerequisites.length; i++){
            indegree[prerequisites[i][0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0){
                q.offer(i);
                ans[index++] = i;
            }
        }

        while(!q.isEmpty()){
            int start = q.poll();

            for(int i = 0; i < prerequisites.length; i++){
                if(start == prerequisites[i][1]){
                    indegree[prerequisites[i][0]]--;
                    if(indegree[prerequisites[i][0]] == 0){
                        q.add(prerequisites[i][0]);
                        ans[index++] = prerequisites[i][0];
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String args[]){
        int num = 4;
        int[][] arr = new int[][]{{1,0},{2,0},{3,1},{3,2}};
        //System.out.println(canFinish(num,arr));
        int[] ans = finishOrder(num,arr);
        for(int i : ans){
            System.out.print(i);
        }
    }
}
