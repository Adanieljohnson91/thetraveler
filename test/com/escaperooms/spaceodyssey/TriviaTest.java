package com.escaperooms.spaceodyssey;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class TriviaTest {
    private TriviaV2 trivia;
    private List<String> answers;
    private String correctAnswer;
    private String question;

    @Before
    public void setUp(){
        answers = List.of("white", "blue", "red", "black");
        correctAnswer = "blue";
        question = "What color is the sky?";
        trivia = new TriviaV2(question, answers, correctAnswer);
    }

}
