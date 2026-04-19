public class BinaryMinHeap {
    static int capacity, size;
    static int[] minHeap;
    public BinaryMinHeap(int cap){
        capacity=cap;
        size=0;
        minHeap=new int[capacity];
    }

     int parent(int i){
        return (i-1)/2;
    }
     int left(int i){
        return 2*i+1;
    }
     int right(int i){
        return 2*i+2;
    }

     void insert(int val){
        if(size==capacity){
            System.out.println("Binary Heap Overflow");
            return;
        }

        minHeap[size]=val;
        int k=size;
        size++;

        while (k!=0 && minHeap[parent(k)]>minHeap[k]){
            int temp=minHeap[parent(k)];
            minHeap[parent(k)]=minHeap[k];
            minHeap[k]=temp;
            k=parent(k);
        }
    }

     void heapify(int index){
        int ri=right(index);
        int li=left(index);
        int smallest=index;

        if(li<size && minHeap[li]<minHeap[smallest])
            smallest=li;
        if (ri<size && minHeap[ri]<minHeap[smallest])
            smallest=ri;

        if(smallest!=index){
            int temp=minHeap[index];
            minHeap[index]=minHeap[smallest];
            minHeap[smallest]=temp;
            heapify(smallest);
        }
    }

     int getMin(){
        return minHeap[0];
    }

     int extractMin(){
        if(size<=0)
            return Integer.MAX_VALUE;
        if(size==1){
            size--;
            return minHeap[0];
        }
        int mini=minHeap[0];
        minHeap[0]=minHeap[size-1];
        size--;
        heapify(0);
        return mini;
    }

     void decreaseKey(int index, int val){
        minHeap[index]=val;
        while (index!=0 && minHeap[parent(index)]>minHeap[index]){
            int temp=minHeap[parent(index)];
            minHeap[parent(index)]=minHeap[index];
            minHeap[index]=temp;
            index=parent(index);
        }
    }

     void delete(int index){
        decreaseKey(index, Integer.MIN_VALUE);
        extractMin();
    }

     void print(){
        for (int i = 0; i < size; i++)
            System.out.print(minHeap[i]+" ");
        System.out.println();
    }

}
