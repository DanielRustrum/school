package p5_Package;

public class IteratorMainClass {
    public static void main(String[] args)
    {
        StackClass stack = new StackClass();
        stack.push(5);
        stack.push(5);
        stack.push(5);
        stack.push(4);
        System.out.println(stack.peekTop());
        stack.clear();
        System.out.println(stack.toString());
        
    }
}
