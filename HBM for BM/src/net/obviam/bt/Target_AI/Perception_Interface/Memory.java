package net.obviam.bt.Target_AI.Perception_Interface;

import java.util.Stack;

//Uses stack Data structure
public class Memory {
    private Stack<Integer> random_access_memory = new Stack<Integer>();

    public Memory() { }

    public int size(){
        return random_access_memory.size();
    }

    public void push(Integer event){
        random_access_memory.push(event);
        printMemory();
    }

    public Integer pop(){
        return random_access_memory.pop();
    }

    public int peek(){
        return random_access_memory.peek();
    }

    public void printMemory(){
        System.out.println(random_access_memory.toString());
    }
}
