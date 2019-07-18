public class NoDupsPrioritizeArrayStack<T> extends ArrayStack<T>
        implements NoDupsPrioritizeStackInterface<T> {

    public NoDupsPrioritizeArrayStack() {
        super();
    }
    public NoDupsPrioritizeArrayStack(int initialCapacity) {
        super(initialCapacity);
    }

    @Override
    public void push(T newEntry) {
        // check duplicate
        for (int i = 0; i <= topIndex; i++) {
            if (stack[i].equals(newEntry)) {
                return;
            }
        }

        // push if no duplicate
        super.push(newEntry);
    }

    public void moveToTop(T entry) {
        boolean found = false;
        int index = -1;

        // push if stack is empty
        if (!isEmpty()) {
            // find location
            for (int i = 0; i <= topIndex; i++) {
                if (stack[i].equals(entry)) {
                    index = i;
                    found = true;
                    break;
                }
            }

            if (found) {
                // move other elements
                for (int j = index; j <= topIndex; j++) {
                    stack[j] = stack[j + 1];
                }
                stack[topIndex] = entry;
            } else {
                super.push(entry);
            }
        } else {
            super.push(entry);
        }
    }

    public void display() {
        System.out.print("BOTTOM ");
        for (int i = 0; i <= topIndex; i++) {
            System.out.print(stack[i] + " ");
        }
        System.out.print("TOP\n");
    }

}
