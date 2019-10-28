package net.obviam.bt.Personality;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Personality_Quiz {
    private static List<String> personality_questions = new ArrayList<>(List.of(
            "Extroverted, enthusiastic.",
            "Critical, quarrelsome.",
            "Dependable, self-disciplined.",
            "Anxious, easily upset.",
            "Open to new experiences, complex.",
            "Reserved, quiet.",
            "Sympathetic, warm.",
            "Disorganized, careless.",
            "Calm, emotionally stable.",
            "Conventional, uncreative."
    ));

    public List<Integer> agent_answers = new ArrayList<Integer>();

    public void get_answers(){
        Scanner read_input = new Scanner(System.in);
        System.out.println("Please answer on a scale of 7 where 1 is Disagree strongly and 7 is Agree strongly " +
                "based on what the statement that best describes you :)");

        System.out.println("" +
                "-------------------------------------" +
                "\nDisagree strongly             1" +
                "\nDisagree moderately           2" +
                "\nDisagree a little             3" +
                "\nNeither agree nor disagree    4" +
                "\nAgree a little                5" +
                "\nAgree moderately              6" +
                "\nAgree strongly                7" +
                "\n-----------------------------------"
        );

        //Ask questions from personality_questions and add responses to the agent_answers list.
        for( int i = 0; i < personality_questions.size(); i++){
            System.out.println("I see myself as: " + " " + personality_questions.get(i));
            String q = read_input.nextLine();
            agent_answers.add(Integer.parseInt(q));
        }
    }
}
