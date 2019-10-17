package net.obviam.bt.Target_AI.PerceptionInterface;

import java.util.Stack;

//Uses stack Data structure
public class Memory {
    private Stack<Integer> random_access_memory = new Stack<Integer>();

    public Memory() { }

    public void push(Integer event){
        random_access_memory.push(event);
        printMemory();
    }

    public Integer pop(){
        return random_access_memory.pop();
    }

    public void printMemory(){
        System.out.println(random_access_memory.toString());
    }
}
