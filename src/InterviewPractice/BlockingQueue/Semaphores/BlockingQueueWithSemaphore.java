package InterviewPractice.BlockingQueue.Semaphores;

public class BlockingQueueWithSemaphore<T> {
    T[] array;
    int size = 0;
    int capacity;
    int head = 0;
    int tail = 0;
    CountingSemaphore semLock = new CountingSemaphore(1, 1);
    CountingSemaphore semItems;

    @SuppressWarnings("unchecked")
    public BlockingQueueWithSemaphore(int capacity) {
        // The casting results in a warning
        array = (T[]) new Object[capacity];
        this.capacity = capacity;
        semItems = new CountingSemaphore(capacity, 0);
    }

    public T dequeue() throws InterruptedException {

        T item = null;

        semItems.acquire();
        semLock.acquire();

        if (head == capacity) {
            head = 0;
        }

        item = array[head];
        array[head] = null;
        head++;
        size--;
        semLock.release();

        return item;
    }

    public void enqueue(T item) throws InterruptedException {

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
}