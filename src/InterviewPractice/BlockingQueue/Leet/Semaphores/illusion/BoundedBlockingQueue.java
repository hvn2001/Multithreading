package InterviewPractice.BlockingQueue.Leet.Semaphores.illusion;
// like as the description
// 8 ms, faster than 58.31%
public class BoundedBlockingQueue {
    int[] array;
    int size = 0;
    int capacity;
    int head = 0;
    int tail = 0;
    CountingSemaphore semLock = new CountingSemaphore(1, 1);
    CountingSemaphore semProducer;
    CountingSemaphore semConsumer;

    public BoundedBlockingQueue(int capacity) {
        array = new int[capacity];
        this.capacity = capacity;
        semProducer = new CountingSemaphore(capacity, capacity);
        semConsumer = new CountingSemaphore(capacity, 0);
    }

    public int dequeue() throws InterruptedException {

        int item;

        semConsumer.acquire();
        semLock.acquire();

        if (head == capacity) {
            head = 0;
        }

        item = array[head];
        array[head] = -1;
        head++;
        size--;
        semLock.release();
        semProducer.release();

        return item;
    }

    public void enqueue(int item) throws InterruptedException {

        semProducer.acquire();
        semLock.acquire();

        if (tail == capacity) {
            tail = 0;
        }

        array[tail] = item;
        size++;
        tail++;
        semLock.release();
        semConsumer.release();
    }

    public int size() {
        return size;
    }
}

class CountingSemaphore {

    int usedPermits = 0;
    int maxCount;

    public CountingSemaphore(int count) {
        this.maxCount = count;
    }

    public CountingSemaphore(int count, int initialPermits) {
        this.maxCount = count;
        this.usedPermits = this.maxCount - initialPermits;
    }

    public synchronized void acquire() throws InterruptedException {

        while (usedPermits == maxCount)
            wait();

        notify();
        usedPermits++;
    }

    public synchronized void release() throws InterruptedException {

        while (usedPermits == 0)
            wait();

        usedPermits--;
        notify();
    }
}