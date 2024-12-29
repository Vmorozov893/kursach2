package com.kursach2.skypro_spring_demo;

public class Question {
    private final String question;
    private final String answer;

    public Question(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    @Override
    public String toString() {
        return "{" +
                "Question: " + question +
                ", Answer: " + answer +
                '}';
    }
}
