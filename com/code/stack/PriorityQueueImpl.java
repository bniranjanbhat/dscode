package com.code.stack;
public class PriorityQueueImpl {
 
    @SuppressWarnings("rawtypes")
    private Comparable[] pQueue;
    private int index;
     
    public PriorityQueueImpl(int capacity){
        pQueue = new Comparable[capacity];
    }
     
    public void insert(Comparable item ){
        if(index == pQueue.length){
            System.out.println("The priority queue is full!! can not insert.");
            return;
        }
        pQueue[index] = item;
        index++;
        System.out.println("Adding element: "+item);
    }
     
    @SuppressWarnings("unchecked")
    public Comparable remove(){
        if(index == 0){
            System.out.println("The priority queue is empty!! can not remove.");
            return null;
        }
        int maxIndex = 0;
        // find the index of the item with the highest priority 
        for (int i=1; i<index; i++) { 
            if (pQueue[i].compareTo (pQueue[maxIndex]) > 0) { 
                maxIndex = i; 
            } 
        } 
        Comparable result = pQueue[maxIndex]; 
        System.out.println("removing: "+result);
        // move the last item into the empty slot 
        // Note that index was made to point to the next empty array location in the insert method. Hence we will decrement it here to get the 
        // last array index and move it to the index of the max element that was removed.
        index--; 
        pQueue[maxIndex] = pQueue[index]; 
        return result;
    }
     
    public static void main(String a[]){
        PriorityQueueImpl pqi = new PriorityQueueImpl(5);
        pqi.insert(34); //add , offer
        pqi.insert(23);
        pqi.insert(5);
        pqi.insert(87);
        pqi.insert(32);
        pqi.remove(); // poll
        pqi.remove();
        pqi.remove();
        pqi.remove();
        pqi.remove();
        
    }
}