package com.escaperooms.parsers;

import com.escaperooms.joninexams.JoninExams;
import com.escaperooms.joninexams.JoninGame;
import com.escaperooms.spaceodyssey.SpaceGame;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JoninGameParser {
    public JoninGame parse(File DATA) {

        final ObjectMapper objectMapper = new ObjectMapper();
        JoninGame exams = null;

        try{
            exams = objectMapper.readValue(DATA, JoninGame.class);
        }catch (IOException el){
            el.printStackTrace();
        }

        return exams;

    }
}
