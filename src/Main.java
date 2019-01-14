import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        System.out.println("START");
        Parent root = FXMLLoader.load(getClass().getResource("view/mainView.fxml"));
        primaryStage.setTitle("Zalogowanie");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
    @Override
    public void stop(){
        System.out.println("STOP");
    }

    public static void main(String[] args) {
        launch(args);
    }
}