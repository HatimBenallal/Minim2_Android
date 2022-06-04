package edu.upc.eetac.dsa.models;

public class FAQ {
    private String quest;
    private String answer;

    public FAQ(String quest, String answer) {
        this.quest=quest;
        this.answer=answer;
    }

    public String getQuest() {
        return quest;
    }

    public void setQuest(String quest) {
        this.quest = quest;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
