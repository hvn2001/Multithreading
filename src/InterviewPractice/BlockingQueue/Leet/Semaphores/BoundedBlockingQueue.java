package InterviewPractice.BlockingQueue.Leet.Semaphores;

// 9 / 15 test cases passed.
public class BoundedBlockingQueue {
    int[] array;
    int size = 0;
    int capacity;
    int head = 0;
    int tail = 0;
    CountingSemaphore semLock = new CountingSemaphore(1, 1);
    CountingSemaphore semItems;

    public BoundedBlockingQueue(int capacity) {
        array = new int[capacity];
        this.capacity = capacity;
        semItems = new CountingSemaphore(capacity, 0);
    }

    public int dequeue() throws InterruptedException {

        int item;

        semItems.acquire();
        semLock.acquire();

        if (head == capacity) {
            head = 0;
        }

        item = array[head];
        array[head] = -1;
        head++;
        size--;
        semLock.release();

        return item;
    }

    public void enqueue(int item) throws InterruptedException {

        semItems.release();
        semLock.acquire();

        if (tail == capacity) {
            tail = 0;
        }

        array[tail] = item;
        size++;
        tail++;
        semLock.release();
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