import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class AsteroidCollision {
    public static void main(String[] args) {
//        int[] asteroids={4,7,1,1,2,-3,-7,17,15,-16};
        int[] asteroids={-2,-2,-2,-2};
//        int[] res = asteroidCollision(asteroids);
        int[] res = asteroidCollisionApp2(asteroids);
        System.out.println(Arrays.toString(res));
    }

    private static int[] asteroidCollisionApp2(int[] asteroids) {
        Stack<Integer> st=new Stack<>();
        for (int ast:asteroids) {
            boolean alive=true;
            while (!st.isEmpty() && ast<0 && st.peek()>0){
                if(st.peek()<-ast){
                    st.pop();
                    continue;
                } else if (st.peek()==-ast) {
                    st.pop();
                }
                alive=false;
                break;
            }
            if(alive) st.push(ast);
        }

        int[] res=new int[st.size()];
        for (int i = st.size()-1; i >=0 ; i--) {
            res[i]=st.pop();
        }
        return res;
    }

    public static int[] asteroidCollision(int[] asteroids) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < asteroids.length; i++) {
            if(asteroids[i]>0)
                list.add(asteroids[i]);
            else {
                while (!list.isEmpty() && list.getLast()>0 && Math.abs(list.getLast()) < Math.abs(asteroids[i]))
                    list.removeLast();
                if (!list.isEmpty()&& list.getLast()>0&&  Math.abs(list.getLast()) == Math.abs(asteroids[i])) {
                    list.removeLast();
                    continue;
                }
                if(list.isEmpty()|| list.getLast()<0)
                    list.add(asteroids[i]);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
