//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        BinaryMinHeap minHeap=new BinaryMinHeap(15);
        minHeap.insert(4);
        minHeap.insert(1);
        minHeap.insert(2);
        minHeap.insert(6);
        minHeap.insert(7);
        minHeap.insert(3);
        minHeap.insert(8);
        minHeap.insert(5);
        minHeap.insert(9);
        System.out.println("Min value is "+minHeap.getMin());
        minHeap.print();
        minHeap.insert(-1);
        minHeap.print();
        System.out.println("Min value is "+minHeap.getMin());
        minHeap.decreaseKey(3,-2);
        minHeap.print();
        System.out.println("Min value is "+minHeap.getMin());
        minHeap.delete(0);
        minHeap.print();
        System.out.println("Min value is "+minHeap.getMin());


        BinaryMaxHeap maxHeap=new BinaryMaxHeap(15);
        maxHeap.insert(4);
        maxHeap.insert(1);
        maxHeap.insert(2);
        maxHeap.insert(6);
        maxHeap.insert(7);
        maxHeap.insert(3);
        maxHeap.insert(8);
        maxHeap.insert(5);
        maxHeap.insert(9);
        System.out.println("Max value is "+maxHeap.getMax());
        maxHeap.print();
        maxHeap.insert(-1);
        maxHeap.print();
        System.out.println("Max value is "+maxHeap.getMax());
        maxHeap.increaseKey(3,22);
        maxHeap.print();
        System.out.println("Max value is "+maxHeap.getMax());
        maxHeap.delete(0);
        maxHeap.print();
        System.out.println("Max value is "+maxHeap.getMax());
    }
}