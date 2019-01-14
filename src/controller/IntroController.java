package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import service.GameInitializer;

import java.io.IOException;


public class IntroController {

//    GameInitializer gameInitializer;
//

    @FXML
    private Button btn_begin;

    @FXML
    void beginAction(MouseEvent event) throws IOException {
        Stage userStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/view/gameView.fxml"));
        userStage.setTitle("Space Trader");
        userStage.setScene(new Scene(root));
        userStage.show();
        Stage primarystage = (Stage) btn_begin.getScene().getWindow();
        primarystage.close();


    }

}
