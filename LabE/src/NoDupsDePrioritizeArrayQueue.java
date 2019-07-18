import java.util.Arrays;

public class NoDupsDePrioritizeArrayQueue<T> extends ArrayQueue<T>
        implements NoDupsDePrioritizeQueueInterface<T> {


    public NoDupsDePrioritizeArrayQueue() {
        super();
    }
    public NoDupsDePrioritizeArrayQueue(int initialCapacity) {
        super(initialCapacity);
    }

    @Override
    public void enqueue(T newEntry) {
        // check duplicate
        for (int i = frontIndex; i != (backIndex + 1) % queue.length; i = (i + 1) % queue.length) {
            if (queue[i].equals(newEntry)) {
                System.out.println(Arrays.binarySearch(queue,newEntry));
                return;
            }
        }

        // push if no duplicate
        super.enqueue(newEntry);
    }

    public void moveToBack(T entry) {
        boolean found = false;
        int index = -1;

        // go through array
        if (!isEmpty()) {

            // find location
            for (int i = frontIndex; i != (backIndex + 1) % queue.length; i = (i + 1) % queue.length) {
                if (queue[i].equals(entry)) {
                    index = i;
                    found = true;
                    break;
                }
            }

            // if found then deprioritize, else enqueue;
            if (found) {

                // remove element and adjust other elements if found
                for (int i = index; i != (backIndex + 1) % queue.length; i = (i + 1) % queue.length) {
                    queue[i] = queue[(i + 1) % queue.length];
                }
                queue[backIndex] = entry;

                // if not found, super enqueue
            } else {
                super.enqueue(entry);
            }
        } else {
            super.enqueue(entry);
        }
    }

    public void display() {
        System.out.print("FRONT ");
        for (int i = frontIndex; i != (backIndex + 1) % queue.length; i = (i + 1) % queue.length) {
            System.out.print(queue[i] + " ");
        }
        System.out.println("BACK");
    }

}
