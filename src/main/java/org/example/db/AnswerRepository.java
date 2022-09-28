package org.example.db;

import org.example.models.Answer;
import org.example.models.Question;
import org.example.models.Quiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class AnswerRepository {
    public List<Answer>getAnswers(Integer quizId) throws SQLException {
        Connection connection=null;
      try{
          connection=DbConnection.getConnection();
          String selectQuery="select answers.question_id ,questions.question,questions.quize_id, answers.id ,answers.answer ,answers.is_correct" +
                  " from answers  join questions  on answers.question_id=questions.id where questions.quize_id=? ";
          PreparedStatement preparedStatement=connection.prepareStatement(selectQuery);
          preparedStatement.setInt(1,quizId);
          ResultSet resultSet=preparedStatement.executeQuery();

          List<Answer> answerList=new ArrayList<Answer>();
          while (resultSet.next()){
              Answer answer=new Answer();
              answer.setAnswer(resultSet.getString("answer"));
              answer.setId(resultSet.getInt("id"));
              answer.setCorrect(resultSet.getString("is_correct").equals("true"));
              Question question=new Question();
              question.setQuestion(resultSet.getString("question"));
              question.setId(resultSet.getInt("id"));
              Quiz quiz=new Quiz();
              quiz.setId(resultSet.getInt("id"));
            //  quiz.setName(resultSet.getString("name"));
              question.setQuiz_id(quiz);
             answer.setQuestion_id(question);
             answerList.add(answer);
           //  return answerList;
          }
      return  answerList;
      } catch (SQLException  e) {
          e.printStackTrace();

      }
      finally {
          if(Objects.nonNull(connection)){
              try{
                  connection.close();
              } catch (SQLException e) {
                  e.printStackTrace();
              }

          }
      }
      throw new RuntimeException("Ne udaloc poluchit spisok otvetov s vopros quizId: "+quizId);
    }

}
