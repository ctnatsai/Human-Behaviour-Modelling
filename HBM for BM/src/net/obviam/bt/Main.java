package net.obviam.bt;


import net.obviam.bt.Target_AI.Routine;
import net.obviam.bt.Target_AI.Routines;

import javax.swing.*;

public class Main {
    private JPanel panel1;
    private JPanel mainPanel;
    private JPanel canvas;

    public static void main(String[] args) {
//        JFrame frame = new JFrame("Main");
//        frame.setPreferredSize(new Dimension(800, 600));
//        frame.setResizable(false);
//        frame.setContentPane(new Main().mainPanel);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.pack();
//        frame.setVisible(true);

        World world = new World(20, 40, 60);
        Agent agent1 = new Agent("Agent_1", 2, 2, 10, 1);
        Agent agent2 = new Agent("Agent_2", 10, 10, 10, 2);

        Routine brain1 = Routines.sequence(
                Routines.work(new World(5,0,0)),
                Routines.work(new World(15,0,0)),
                Routines.work(new World(2,0,0))
        );
        agent1.setRoutine(brain1);

        Routine brain2 = Routines.sequence(
                Routines.repeat(Routines.work(world), 4)
        );
        agent2.setRoutine(brain2);

        for (int i = 0; i < 30; i++) {
            System.out.println(agent1.toString());
            System.out.println(agent2.toString());
            agent1.update();
            agent2.update();
        }
    }
}
