public class BinaryMaxHeap {
    static int capacity, size;
    static int[] maxHeap;
    public BinaryMaxHeap(int cap){
        capacity=cap;
        size=0;
        maxHeap=new int[capacity];
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

        maxHeap[size]=val;
        int k=size;
        size++;

        while (k!=0 && maxHeap[parent(k)]<maxHeap[k]){
            int temp=maxHeap[parent(k)];
            maxHeap[parent(k)]=maxHeap[k];
            maxHeap[k]=temp;
            k=parent(k);
        }
    }

    void heapify(int index){
        int ri=right(index);
        int li=left(index);
        int largest=index;

        if(li<size && maxHeap[li]>maxHeap[largest])
            largest=li;
        if (ri<size && maxHeap[ri]>maxHeap[largest])
            largest=ri;

        if(largest!=index){
            int temp=maxHeap[index];
            maxHeap[index]=maxHeap[largest];
            maxHeap[largest]=temp;
            heapify(largest);
        }
    }

    int getMax(){
        return maxHeap[0];
    }

    int extractMax(){
        if(size<=0)
            return Integer.MAX_VALUE;
        if(size==1){
            size--;
            return maxHeap[0];
        }
        int maxi=maxHeap[0];
        maxHeap[0]=maxHeap[size-1];
        size--;
        heapify(0);
        return maxi;
    }

    void increaseKey(int index, int val){
        maxHeap[index]=val;
        while (index!=0 && maxHeap[parent(index)]<maxHeap[index]){
            int temp=maxHeap[parent(index)];
            maxHeap[parent(index)]=maxHeap[index];
            maxHeap[index]=temp;
            index=parent(index);
        }
    }

    void delete(int index){
        increaseKey(index, Integer.MAX_VALUE);
        extractMax();
    }

    void print(){
        for (int i = 0; i < size; i++)
            System.out.print(maxHeap[i]+" ");
        System.out.println();
    }

}
