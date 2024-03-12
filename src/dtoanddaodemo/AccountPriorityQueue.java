package dtoanddaodemo;
import java.util.PriorityQueue;
import java.util.Iterator;

public class AccountPriorityQueue extends PriorityQueue<Account> implements QueueInterface<Account>
{
    public AccountPriorityQueue() 
    {
        super();
    }

    @Override
    public void enqueue(Account item) 
    {
        super.add(item);
    }

    @Override
    public Account dequeue() 
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

    public Iterator<Account> iterator()
    {
        return super.iterator();
    }

}
