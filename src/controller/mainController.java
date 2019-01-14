package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class mainController {

    @FXML
    private MenuItem mi_about;

    @FXML
    private MenuItem mi_exit;

    @FXML
    private MenuItem mi_help;

    @FXML
    private Button btn_newGame;

    @FXML
    private Button btn_exit;

    @FXML
    void aboutAction(ActionEvent event) {

    }

    @FXML
    void exitAction(MouseEvent event) {

    }

    @FXML
    void helpAction(ActionEvent event) {

    }

    @FXML
    void newGameAction(MouseEvent event) throws IOException {
        Stage userStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/view/introView.fxml"));
        userStage.setTitle("Space Trader");
        userStage.setScene(new Scene(root));
        userStage.show();
        Stage primarystage = (Stage) btn_exit.getScene().getWindow();
        primarystage.close();

    }

}
