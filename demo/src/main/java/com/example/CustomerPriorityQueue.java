package com.example;
import java.util.PriorityQueue;
import java.util.Iterator;

public class CustomerPriorityQueue extends PriorityQueue<Customer> implements QueueInterface<Customer>
{
    public CustomerPriorityQueue() 
    {
        super();
    }

    @Override
    public void enqueue(Customer item) 
    {
        super.add(item);
    }

    @Override
    public Customer dequeue() 
    {
        return super.poll();
    }

    @Override
    public boolean isEmpty()
    {
        return super.isEmpty();
    }

    @Override
    public int size()
    {
        return super.size();
    }

    public Iterator<Customer> iterator()
    {
        return super.iterator();
    }

}
