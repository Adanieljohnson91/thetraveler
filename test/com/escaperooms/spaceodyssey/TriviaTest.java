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

    @Test
    public void test_checkRockPaperScissorsResults_shouldReturn0_p1_rock_p2_rock() {
        assertEquals(0, trivia.checkRockPaperScissorsResults("rock","rock"));
    }

    @Test
    public void test_checkRockPaperScissorsResults_shouldReturn0_p1_Paper_p2_paper() {
        assertEquals(0, trivia.checkRockPaperScissorsResults("Paper","paper"));
    }

    @Test
    public void test_checkRockPaperScissorsResults_shouldReturn0_p1_scissors_p2_sCissors() {
        assertEquals(0, trivia.checkRockPaperScissorsResults("scissors","sCissors"));
    }

    @Test
    public void test_checkRockPaperScissorsResults_shouldReturn1_p1_rock_p2_scissors() {
        assertEquals(1, trivia.checkRockPaperScissorsResults("rock","scissors"));
    }

    @Test
    public void test_checkRockPaperScissorsResults_shouldReturn1_p1_paper_p2_rock() {
        assertEquals(1, trivia.checkRockPaperScissorsResults("paper","rock"));
    }

    @Test
    public void test_checkRockPaperScissorsResults_shouldReturn1_p1_scissors_p2_paper() {
        assertEquals(1, trivia.checkRockPaperScissorsResults("scissors","paper"));
    }

    @Test
    public void test_checkRockPaperScissorsResults_shouldReturn2_p1_scissors_p2_rock() {
        assertEquals(2, trivia.checkRockPaperScissorsResults("scissors","rock"));
    }

    @Test
    public void test_checkRockPaperScissorsResults_shouldReturn2_p1_paper_p2_scissors() {
        assertEquals(2, trivia.checkRockPaperScissorsResults("paper","scissors"));
    }

    @Test
    public void test_checkRockPaperScissorsResults_shouldReturn2_p1_rock_p2_paper() {
        assertEquals(2, trivia.checkRockPaperScissorsResults("rock","paper"));
    }

    @Test
    public void test_checkRockPaperScissorsResults_shouldReturnNeg1_p1_asdf_p2_paper() {
        assertEquals(-1, trivia.checkRockPaperScissorsResults("asdf","paper"));
    }

    @Test
    public void test_checkRockPaperScissorsResults_shouldReturnNeg1_p1_paper_p2_asdf() {
        assertEquals(-1, trivia.checkRockPaperScissorsResults("paper","asdf"));
    }
}
