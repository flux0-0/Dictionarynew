package com.example.translate_speech;

import Base.TexttoSpeech;
import Base.Translator;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.util.Objects;

public class TranslateController {

    @FXML
    private TextArea area1;

    @FXML
    private TextField area2;

    @FXML
    private Button getLangFromFirst;

    @FXML
    private Button langFromSecond;

    @FXML
    private Button langFromThird;

    @FXML
    private Button langFromFourth;

    @FXML
    private Button langToSecond;

    @FXML
    private Button langToThird;

    @FXML
    private Button langToFourth;

    @FXML
    private TextField text1;

    @FXML
    private TextField text2;

    String nameFrom;
    String speakFrom;
    String languageFrom = "";

    @FXML
    void detect() {
        languageFrom = "";
        text1.setText("");
        nameFrom = "Linda";
        speakFrom = "en-gb";
    }


    @FXML
    void vie1() {
        text1.setText("vi");
        languageFrom = "vi";
        nameFrom = "Chi";
        speakFrom = "vi-vn";
    }

    @FXML
    void vie2() {
        text2.setText("vi");
        languageFrom = "vi";
        nameFrom = "Chi";
        speakFrom = "vi-vn";
    }


    @FXML
    void en1() {
        languageFrom = "en";
        text1.setText("en");
        nameFrom = "Linda";
        speakFrom = "en-gb";
    }

    @FXML
    void en2() {
        languageFrom = "en";
        text2.setText("en");
        nameFrom = "Linda";
        speakFrom = "en-gb";
    }

    @FXML
    void korea1() {
        text1.setText("ko");
        languageFrom = "ko";
        nameFrom = "Nari";
        speakFrom = "ko-kr";
    }

    @FXML
    void korea2() {
        text2.setText("ko");
        languageFrom = "ko";
        nameFrom = "Nari";
        speakFrom = "ko-kr";
    }

    @FXML
    void translate() throws IOException {
        if (!Objects.equals(area1.getText(), "")) {
            area2.setText(Translator.translate( text1.getText(), text2.getText(), area1.getText()));
        }
    }

    @FXML
    void speak1() throws Exception {
        TexttoSpeech.Name = nameFrom;
        TexttoSpeech.language = speakFrom;
        if (!Objects.equals(area1.getText(), "")) {
            TexttoSpeech.speakWord(area1.getText());
        }
    }

    @FXML
    void speak2() throws Exception {
        TexttoSpeech.Name = nameFrom;
        TexttoSpeech.language = speakFrom;
        if (!Objects.equals(area2.getText(), "")) {
            TexttoSpeech.speakWord(area2.getText());
        }
    }



}