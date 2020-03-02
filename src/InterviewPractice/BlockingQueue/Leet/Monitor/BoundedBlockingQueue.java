package InterviewPractice.BlockingQueue.Leet.Monitor;

// 17 ms, faster than 8.07%
class BoundedBlockingQueue {

    int[] array;
    Object lock = new Object();
    int size = 0;
    int capacity;
    int head = 0;
    int tail = 0;

    public BoundedBlockingQueue(int capacity) {
        array = new int[capacity];
        this.capacity = capacity;
    }

    public void enqueue(int item) throws InterruptedException {
        synchronized (lock) {
            while (size == capacity) {
                lock.wait();
            }
            if (tail == capacity) {
                tail = 0;
            }
            array[tail] = item;
            size++;
            tail++;
            lock.notifyAll();
        }
    }

    public int dequeue() throws InterruptedException {
        int item;
        synchronized (lock) {
            while (size == 0) {
                lock.wait();
            }
            if (head == capacity) {
                head = 0;
            }
            item = array[head];
            array[head] = -1;
            head++;
            size--;
            lock.notifyAll();
        }
        return item;
    }

    public int size() {
        return size;
    }
}