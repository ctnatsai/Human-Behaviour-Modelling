package net.obviam.bt.Personality_Generator;

public class Generate_Personality_Metrics {

    Personality_Quiz personality_quiz;

    public Generate_Personality_Metrics(Personality_Quiz personality_quiz) {
        this.personality_quiz = personality_quiz;
    }

    private int ans_reverse_mapping(int index){
        int score = personality_quiz.agent_answers.get(index);
        switch (score){
            case 1: return 7;
            case 2: return 6;
            case 3: return 5;
            case 4: return 4;
            case 5: return 3;
            case 6: return 2;
            case 7: return 1;
            default: return -1;
        }
    }

    private int get_personality_metrics(int start_index){
        final int offset = 5;
        return (this.personality_quiz.agent_answers.get(start_index)
                + ans_reverse_mapping(start_index + offset)) / 2;
    }

    public int is_extrovert_metrics(){
        int start_index = 0;
        return get_personality_metrics(start_index);
    }

    public int is_agreeable_metrics(){
        int start_index = 1;
        return get_personality_metrics(start_index);
    }

    public int is_neurotic_metrics(){
        int start_index = 2;
        return get_personality_metrics(start_index);
    }

    public int is_open_metrics(){
        int start_index = 3;
        return get_personality_metrics(start_index);
    }

    public int is_conscientious_metrics(){
        int start_index = 4;
        return get_personality_metrics(start_index);
    }
}
