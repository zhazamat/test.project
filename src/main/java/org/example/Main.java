package org.example;

import org.example.db.AnswerRepository;
import org.example.models.Answer;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        AnswerRepository answerRepository=new AnswerRepository();
        List<Answer>answerList=answerRepository.getAnswers(3);
        System.out.println(Arrays.toString(answerList.toArray()));

    }
}
