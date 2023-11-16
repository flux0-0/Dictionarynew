package com.example.dictionary;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import org.w3c.dom.events.Event;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class SearchController implements Initializable {
    private static final String DATA_FILE_PATH = "data/E_V.txt";
    //private static final String FXML_FILE_PATH = "./src/main/resources/com/example/dictionary/dictionary-view.fxml";
    private static final String SPLITTING_CHARACTERS = "<html>";
    private Map<String, Word> data = new HashMap<>();

    @FXML
    private ListView<String> listView;
    @FXML
    private WebView definitionView;
    @FXML
    private Button backwardButton;
    private Dictionary dictionary;

    @FXML
    public void handleBackwardButton(ActionEvent event) {
        try {
            // Load FXML file của Search Scene
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Main.fxml"));
            Parent mainRoot = loader.load();

            // Tạo scene mới với root là searchRoot
            Scene mainScene = new Scene(mainRoot);

            // Lấy stage từ nút được nhấn
            Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Thiết lập scene mới cho stage
            primaryStage.setScene(mainScene);
            primaryStage.setTitle("Dictionary");

            // Hiển thị scene mới
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Call the method to load and display HTML content in the ListView
        loadHTMLContent();
    }
    private void loadHTMLContent() {
        // Get the InputStream for the HTML file
        InputStream inputStream = getClass().getResourceAsStream("data/E_V.txt");

        if (inputStream != null) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    // Add each line of the HTML file to the ListView
                    listView.getItems().add(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.err.println("File not found: E_V.txt");
        }
    }


}
