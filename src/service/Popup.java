package service;

import javafx.scene.control.Alert;

public class Popup{

    public Popup(Alert.AlertType errorType,String errorTitle,String errorHeaderText,String errorContentText)

    {

        Alert errorLog = new Alert(errorType);
        errorLog.setTitle(errorTitle);
        errorLog.setContentText(errorContentText);
        errorLog.setHeaderText(errorHeaderText);
        errorLog.showAndWait();
    }
}
