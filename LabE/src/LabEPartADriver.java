public class LabEPartADriver {

    public static void main(String args[]) {
        NoDupsPrioritizeStackInterface<String> testStack = new NoDupsPrioritizeArrayStack<String>();

        /* first test that it still functions like a normal stack */
        System.out.println("*****Testing basic stack behavior:");
        System.out.println("Stack empty = true: " + testStack.isEmpty());
        testStack.push("ants");
        testStack.push("baboons");
        testStack.push("cockroaches");
        testStack.push("dogs");
        testStack.push("elephants");
        System.out.println("Stack empty = false: " + testStack.isEmpty());
        System.out.println("The stack should be: \nBOTTOM ants baboons cockroaches dogs elephants TOP");
        testStack.display();

        System.out.println("Popping elephants: " + testStack.pop());
        System.out.println("Popping dogs: " + testStack.pop());
        System.out.println("Popping cockroaches: " + testStack.pop());
        System.out.println("Popping baboons: " + testStack.pop());
        System.out.println("Popping ants: " + testStack.pop());
        System.out.println("Stack empty = true: " + testStack.isEmpty());

        /* next test that it won't add duplicates */
        System.out.println("\n***Testing no duplicate functionality:");
        testStack.push("ants");
        testStack.push("baboons");
        testStack.push("cockroaches");
        testStack.push("dogs");
        testStack.push("elephants");
        System.out.println("The stack should be: \nBOTTOM ants baboons cockroaches dogs elephants TOP");
        testStack.display();
        testStack.push("dogs");
        testStack.push("ants");
        testStack.push("elephants");
        System.out.println("The stack should be: \nBOTTOM ants baboons cockroaches dogs elephants TOP");
        testStack.display();

        /* finally test the moveToTop method */
        System.out.println("\n*****Testing prioritization:");
        testStack.moveToTop("dogs"); // middle element
        System.out.println("The stack should be: \nBOTTOM ants baboons cockroaches elephants dogs TOP");
        testStack.display();
        testStack.moveToTop("ants"); // bottom element
        System.out.println("The stack should be: \nBOTTOM baboons cockroaches elephants dogs ants TOP");
        testStack.display();
        testStack.moveToTop("ants"); // top element
        System.out.println("The stack should be: \nBOTTOM baboons cockroaches elephants dogs ants TOP");
        testStack.display();
        testStack.moveToTop("frogs"); // element not currently in stack
        System.out.println("The stack should be: \nBOTTOM baboons cockroaches elephants dogs ants frogs TOP");
        testStack.display();




    }

}
