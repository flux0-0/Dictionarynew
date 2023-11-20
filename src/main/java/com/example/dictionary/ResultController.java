package com.example.easyquiz;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;


public class ResultController {

    @FXML
    public Label remark, marks, markstext, correcttext, wrongtext;

    @FXML
    public ProgressIndicator correct_progress, wrong_progress;

    private int correct;
    private int wrong;
    private int sum;

    @FXML
    private void initialize() {
        correct = QuizController.correct;
        wrong = QuizController.wrong;
        sum = correct + wrong;

        //Nếu không nhập bất kì caau trả lời nào
        if (sum == 0) {
            handleZeroSum();
        }


        correcttext.setText("Correct Answers : " + correct);
        wrongtext.setText("Incorrect Answers : " + wrong);

        marks.setText(correct + "/" + sum);
        float correctf = (float) correct / sum;
        correct_progress.setProgress(correctf);

        float wrongf = (float) wrong / sum;
        wrong_progress.setProgress(wrongf);

        markstext.setText(correct + " Marks Scored");

        if (correctf <= 0.4) {
            remark.setText("Đừng nản lòng! Hãy ôn tập thêm và thử lại lần nữa! ");
        }  else if (correctf > 0.4 && correctf <= 0.8) {
            remark.setText("Làm tốt lắm! Bạn đã nắm bắt được khá nhiều kiến thức, cố gắng phát huy nhé! ");
        } else if (correctf >= 0.8 && correctf < 1) {
            remark.setText("Tuyệt vời! Bạn đã hiểu rất rõ về các chủ đề này. Tiếp tục duy trì phong độ nhé! ");
        } else if (correctf == 1) {
            remark.setText("Tuyệt vời! Chúc mừng bạn đã đạt điểm tuyệt đối! ");
        }
    }

    private void handleZeroSum() {
        System.err.println("Error: Không có câu hỏi nào được chọn. Hãy chạy lại chương trình.");
        System.exit(0);
    }


}

