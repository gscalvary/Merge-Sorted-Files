package com.oliver;

public class MinimumBinaryHeap {

    private int numEntries;
    private BinaryHeapNode[] heap;

    public MinimumBinaryHeap(int size) {

        heap = new BinaryHeapNode[size];
        numEntries = 0;
    }

    public void insert(int key, int value) {

        if(numEntries == heap.length) throw new IndexOutOfBoundsException("The heap is full");
        heap[numEntries++] = new BinaryHeapNode(key, value);
        bubbleUp(numEntries - 1);
    }

    public Integer deletemin() {

        if(numEntries == 0) return null;

        BinaryHeapNode temp = heap[0];
        heap[0] = heap[numEntries - 1];
        --numEntries;
        siftDown(0);

        return temp.getValue();
    }

    private void bubbleUp(int i) {

        while(i > 0) {
            int p = getParentIndex(i);
            if(heap[i].getKey() < heap[p].getKey()) {
                BinaryHeapNode temp = heap[p];
                heap[p] = heap[i];
                heap[i] = temp;
                i = p;
            } else {
                break;
            }
        }
    }

    private void siftDown(int i) {

        while(i < heap.length - 1) {
            int c = getMinChildIndex(i);
            if(c == -1) break;
            if(heap[c].getKey() < heap[i].getKey()) {
                BinaryHeapNode temp = heap[c];
                heap[c] = heap[i];
                heap[i] = temp;
                i = c;
            } else {
                break;
            }
        }
    }

    private int getMinChildIndex(int i) {

        int c = getFirstChildIndex(i);

        if(c >= numEntries) {
            return -1;
        } else if(c + 1 >= numEntries){
            return c;
        } else if(heap[c].getKey() > heap[c + 1].getKey()){
            return c + 1;
        } else {
            return c;
        }
    }

    private int getParentIndex(int i) {

        return (i - 1)/2;
    }

    private int getFirstChildIndex(int i) {

        return 2 * i + 1;
    }

    public void print() {

        System.out.println();
        for(int i = 0; i < numEntries; i++) {
            System.out.println(i + ": " + heap[i].getKey() + heap[i].getValue());
        }
    }

    public int getNumEntries() {

        return numEntries;
    }

    public class BinaryHeapNode {

        private int key;
        private int value;

        public BinaryHeapNode(int key, int value) {

            this.key = key;
            this.value = value;
        }

        public int getKey() {

            return key;
        }

        public void setKey(int key) {

            this.key = key;
        }

        public int getValue() {

            return value;
        }

        public void setValue(int value) {

            this.value = value;
        }
    }
}