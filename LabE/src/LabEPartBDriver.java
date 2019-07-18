public class LabEPartBDriver {

    public static void main(String args[]) {
        NoDupsDePrioritizeQueueInterface<String> testQueue = new NoDupsDePrioritizeArrayQueue<String>(5);

        /* first test that it still functions like a normal stack */
        System.out.println("*****Testing basic queue behavior (including wrap-around functionality):");
        System.out.println("Queue empty? true: " + testQueue.isEmpty());
        testQueue.enqueue("ants");
        testQueue.enqueue("baboons");
        testQueue.enqueue("cockroaches");
        testQueue.enqueue("dogs");
        testQueue.enqueue("elephants");
        System.out.println("Queue empty? false: " + testQueue.isEmpty());
        System.out.println("The queue should be: \nFRONT ants baboons cockroaches dogs elephants BACK");
        testQueue.display();

        System.out.println("Dequeuing ants: " + testQueue.dequeue());
        System.out.println("Dequeuing baboons: " + testQueue.dequeue());
        testQueue.enqueue("frogs");
        testQueue.enqueue("gorillas");
        System.out.println("The queue should be: \nFRONT cockroaches dogs elephants frogs gorillas BACK");
        testQueue.display();

        System.out.println("Dequeuing cockroaches: " + testQueue.dequeue());
        System.out.println("Dequeuing dogs: " + testQueue.dequeue());
        System.out.println("Dequeuing elephants: " + testQueue.dequeue());
        System.out.println("Dequeuing frogs: " + testQueue.dequeue());
        System.out.println("Dequeuing gorillas: " + testQueue.dequeue());
        System.out.println("Queue empty: true: " + testQueue.isEmpty());

        /* next test that it won't add duplicates */
        System.out.println("\n*****Testing no-duplicate functionality:");
        testQueue.enqueue("ants");
        testQueue.enqueue("baboons");
        testQueue.enqueue("cockroaches");
        testQueue.enqueue("dogs");
        testQueue.enqueue("elephants");
        System.out.println("The queue should be: \nFRONT ants baboons cockroaches dogs elephants BACK");
        testQueue.display();
        testQueue.enqueue("dogs");
        testQueue.enqueue("elephants");
        System.out.println("The queue should be: \nFRONT ants baboons cockroaches dogs elephants BACK");
        testQueue.display();

        /* finally test the moveToBack method */
        System.out.println("\n*****Testing de-prioritization:");
        testQueue.moveToBack("cockroaches"); // middle element
        System.out.println("The queue should be: \nFRONT ants baboons dogs elephants cockroaches BACK");
        testQueue.display();
        testQueue.moveToBack("ants"); // front element
        System.out.println("The queue should be: \nFRONT baboons dogs elephants cockroaches ants BACK");
        testQueue.display();
        testQueue.moveToBack("ants"); // back element
        System.out.println("The queue should be: \nFRONT baboons dogs elephants cockroaches ants BACK");
        testQueue.display();
        System.out.println("Dequeuing baboons: " + testQueue.dequeue());
        testQueue.moveToBack("elephants"); // testing wrap around
        testQueue.moveToBack("dogs");
        System.out.println("The queue should be: \nFRONT cockroaches ants elephants dogs BACK");
        testQueue.display();
        testQueue.moveToBack("frogs"); // elements not currently in stack
        System.out.println("The queue should be: \nFRONT cockroaches ants elephants dogs frogs BACK");
        testQueue.display();
        testQueue.moveToBack("horses");
        testQueue.moveToBack("iguanas");
        System.out.println("The queue should be: \nFRONT cockroaches ants elephants dogs frogs horses iguanas BACK");
        testQueue.display();



    }

}