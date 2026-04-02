
public class Main {
    public static void main(String[] args) {
        StackUsingQueue st = new StackUsingQueue();

        // Array of commands
//        String[] commands = {"QueueStack", "push", "push",
//                "pop", "top", "isEmpty"};
//        int[][] inputs = {{}, {4}, {8}, {}, {}, {}};
//
//        for (int i = 0; i < commands.length; ++i) {
//            switch (commands[i]) {
//                case "push":
//                    st.push(inputs[i][0]);
//                    System.out.print("null ");
//                    break;
//                case "pop":
//                    System.out.print(st.pop() + " ");
//                    break;
//                case "top":
//                    System.out.print(st.top() + " ");
//                    break;
//                case "isEmpty":
//                    System.out.print(st.empty() ? "true " : "false ");
//                    break;
//                case "QueueStack":
//                    System.out.print("null ");
//                    break;
//            }
//        }


//        StackQueue q = new StackQueue();
//
//        // List of commands
//        String[] commands = {"StackQueue", "push", "push",
//                "pop", "peek", "isEmpty"};
//        // List of inputs
//        int[][] inputs = {{}, {4}, {8}, {}, {}, {}};
//
//        for (int i = 0; i < commands.length; i++) {
//            if (commands[i].equals("push")) {
//                q.push(inputs[i][0]);
//                System.out.print("null ");
//            } else if (commands[i].equals("pop")) {
//                System.out.print(q.pop() + " ");
//            } else if (commands[i].equals("peek")) {
//                System.out.print(q.peek() + " ");
//            } else if (commands[i].equals("isEmpty")) {
//                System.out.print((q.empty() ? "true" : "false") + " ");
//            } else if (commands[i].equals("StackQueue")) {
//                System.out.print("null ");
//            }
//        }


//        MinStack q = new MinStack();
        MinStackOptimised q = new MinStackOptimised();
        // List of commands
        String[] commands = {"MinStack","push","push","push","top","pop","getMin","pop","getMin","pop","push","top","getMin","push","top","getMin","pop","getMin"};
        // List of inputs
        int[][] inputs = {{}, {2147483646}, {2147483646}, {2147483647}, {}, {},{},{},{},{},{2147483647},{},{},{-2147483648},{},{},{},{}};

        for (int i = 0; i < commands.length; i++) {
            if (commands[i].equals("push")) {
                q.push(inputs[i][0]);
                System.out.print("null ");
            } else if (commands[i].equals("pop")) {
                q.pop();
            } else if (commands[i].equals("top")) {
                System.out.print(q.top() + " ");
            } else if (commands[i].equals("getMin")) {
                System.out.print(q.getMin() + " ");
            } else if (commands[i].equals("MinStack")) {
                System.out.print("null ");
            }
        }
    }
}