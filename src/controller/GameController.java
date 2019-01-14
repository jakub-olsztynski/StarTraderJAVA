package controller;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import service.DistanceCalculator;
import service.GameInitializer;
import service.Popup;

import javax.swing.text.html.ImageView;
import java.io.IOException;
import java.security.DigestInputStream;
import java.util.Optional;

public class GameController {

    public int turn = 1;

    //location and distance
    public int curSys = 0;
    public int curLoc = 100;

    public int gagarinLoc = 0;
    public int cydoniaLoc = 300;
    public int hawkingSolLoc = 1200;

    public int armstrongLoc=400;
    public int hawkingCentauriLoc=700;

    public int duneLoc = 0;
    public int hawkingArrakisLoc= 300;

    public int lidlLoc = 0;
    public int tescoLoc = 200;
    public int hawkingAndromedaLoc = 400;

    //cash
    public int credits = 18000;

    //ship
    public String shipType = "Hauler";
    public int shipCargoCapacity = 200;
    public int shipCurCargo = 0;
    public int shipSpeed = 10;
    public int shipFuelConsuption = 1;
    public int shipFuelCapacity = 4000;
    public int shipCurFuel = 4000;
    public int shipHyperConsuption = 1;
    public int shipHyperCapacity = 5000;
    public int shipCurHyper=5000;
    public int shipValue = 10000;

    public int curFood=0;
    public int curParts=0;
    public int curSpice=0;
    public int curOre=0;


    //initial prices set, gaarin, Sol
    private int gagarinFuelBuyPrice = 9;
    private int gagarinFuelSellPrice = 10;
    private int gagarinHyperfuelBuyPrice = 90;
    private int gagarinHyperfuelSellPrice = 100;
    private int gagarinFoodBuyPrice = 13;
    private int gagarinFoodSellPrice = 15;
    private int gagarinPartsBuyPrice = 55;
    private int gagarinPartsSellPrice = 61;
    private int gagarinSpiceBuyPrice = 1400;
    private int gagarinSpiceSellPrice = 1900;
    private int gagarinOreSellPrice = 4;
    private int gagarinOreBuyPrice = 3;

    //initial prices set, Cydonia, sol
    private int cydoniaFuelBuyPrice = 10;
    private int cydoniaFuelSellPrice = 11;
    private int cydoniaHyperfuelBuyPrice = 95;
    private int cydoniaHyperfuelSellPrice = 105;
    private int cydoniaFoodBuyPrice = 20;
    private int cydoniaFoodSellPrice = 28;
    private int cydoniaPartsBuyPrice = 39;
    private int cydoniaPartsSellPrice = 48;
    private int cydoniaSpiceBuyPrice = 1350;
    private int cydoniaSpiceSellPrice = 1800;
    private int cydoniaOreSellPrice = 2;
    private int cydoniaOreBuyPrice = 1;

    //initial prices set, gaarin, Sol
    private int armstrongFuelBuyPrice = 1;
    private int armstrongFuelSellPrice = 2;
    private int armstrongHyperfuelBuyPrice = 95;
    private int armstrongHyperfuelSellPrice = 115;
    private int armstrongFoodBuyPrice = 11;
    private int armstrongFoodSellPrice = 13;
    private int armstrongPartsBuyPrice = 59;
    private int armstrongPartsSellPrice = 68;
    private int armstrongSpiceBuyPrice = 1600;
    private int armstrongSpiceSellPrice = 2100;
    private int armstrongOreSellPrice = 5;
    private int armstrongOreBuyPrice = 4;

    //initial prices set, Dune, Arrakis
    private int duneFuelBuyPrice = 18;
    private int duneFuelSellPrice = 20;
    private int duneHyperfuelBuyPrice = 110;
    private int duneHyperfuelSellPrice = 132;
    private int duneFoodBuyPrice = 92;
    private int duneFoodSellPrice = 110;
    private int dunePartsBuyPrice = 47;
    private int dunePartsSellPrice = 67;
    private int duneSpiceBuyPrice = 920;
    private int duneSpiceSellPrice = 1100;
    private int duneOreSellPrice = 5;
    private int duneOreBuyPrice = 4;

    //initial prices set, lidl, Andromeda
    private int lidlFuelBuyPrice = 1;
    private int lidlFuelSellPrice = 2;
    private int lidlHyperfuelBuyPrice = 95;
    private int lidlHyperfuelSellPrice = 115;
    private int lidlFoodBuyPrice = 11;
    private int lidlFoodSellPrice = 13;
    private int lidlPartsBuyPrice = 59;
    private int lidlPartsSellPrice = 68;
    private int lidlSpiceBuyPrice = 1600;
    private int lidlSpiceSellPrice = 2100;
    private int lidlOreSellPrice = 5;
    private int lidlOreBuyPrice = 4;

    //initial prices set, lidl, Andromeda
    private int tescoFuelBuyPrice = 1;
    private int tescoFuelSellPrice = 2;
    private int tescoHyperfuelBuyPrice = 95;
    private int tescoHyperfuelSellPrice = 115;
    private int tescoFoodBuyPrice = 11;
    private int tescoFoodSellPrice = 13;
    private int tescoPartsBuyPrice = 59;
    private int tescoPartsSellPrice = 68;
    private int tescoSpiceBuyPrice = 1600;
    private int tescoSpiceSellPrice = 2100;
    private int tescoOreSellPrice = 5;
    private int tescoOreBuyPrice = 4;

    @FXML
    private Menu Game;

    @FXML
    private MenuItem Restart;

    @FXML
    private MenuItem About;

    @FXML
    private MenuItem Exit;

    @FXML
    private Menu Ship;

    @FXML
    private TabPane tab;

    @FXML
    private Tab tab1;

    @FXML
    private Button btn_scan;

    @FXML
    private Label lbl_distance1;

    @FXML
    private Label lbl_distance2;

    @FXML
    private Label lbl_distance3;

    @FXML
    private Label lbl_object1;

    @FXML
    private Label lbl_object2;

    @FXML
    private Label lbl_object3;

    @FXML
    private Button btn_travel1;

    @FXML
    private Button btn_travel2;

    @FXML
    private Button btn_travel3;

    @FXML
    private Label lbl_distdisplay1;

    @FXML
    private Label lbl_distdisplay2;

    @FXML
    private Label lbl_distdisplay3;

    @FXML
    private Label lbl_objdisplay1;

    @FXML
    private Label lbl_objdisplay2;

    @FXML
    private Label lbl_objdisplay3;

    @FXML
    private RadioButton rb_max;

    @FXML
    private ToggleGroup speed;

    @FXML
    private RadioButton rb_med;

    @FXML
    private RadioButton rb_low;

    @FXML
    private Tab tab2;

    @FXML
    private Label lbl_hyperImpossible;

    @FXML
    private Label lbl_syst1;

    @FXML
    private Label lbl_dist1;

    @FXML
    private Label lbl_dist2;

    @FXML
    private Label lbl_dist3;

    @FXML
    private Label lbl_dist4;

    @FXML
    private Label lbl_dist5;

    @FXML
    private Label lbl_syst11;

    @FXML
    private Label lbl_syst12;

    @FXML
    private Label lbl_syst13;

    @FXML
    private Label lbl_syst14;

    @FXML
    private Label lbl_distdisp1;

    @FXML
    private Label lbl_distdisp11;

    @FXML
    private Label lbl_distdisp12;

    @FXML
    private Label lbl_distdisp13;

    @FXML
    private Label lbl_distdisp14;

    @FXML
    private Label lbl_systemdisp1;

    @FXML
    private Label lbl_systemdisp2;

    @FXML
    private Label lbl_systemdisp3;

    @FXML
    private Label lbl_systemdisp4;

    @FXML
    private Label lbl_systemdisp5;

    @FXML
    private Button btn_refreshHyper;

    @FXML
    private Button btn_course1;

    @FXML
    private Button btn_course2;

    @FXML
    private Button btn_course3;

    @FXML
    private Button btn_course4;

    @FXML
    private Button btn_course5;

    @FXML
    private Button btn_jump;

    @FXML
    private Label lbl_estimateImpossible;

    @FXML
    private Label lbl_hypertargetdisp;

    @FXML
    private Label lbl_hyperfueldisp;

    @FXML
    private Label lbl_hyperfuel;

    @FXML
    private Label lbl_hypertargetdisp1;

    @FXML
    private Label lbl_hyperfuel1;

    @FXML
    private Tab tab3;

    @FXML
    private GridPane gp_m_station;

    @FXML
    private Button btn_m_buyfood;

    @FXML
    private Button btn_m_buyparts;

    @FXML
    private Button btn_m_buyspice;

    @FXML
    private Button btn_m_buyore;

    @FXML
    private Button btn_m_sellFood;

    @FXML
    private Button btn_m_sellParts;

    @FXML
    private Button btn_m_sellSpice;

    @FXML
    private Button btn_m_sellOre;

    @FXML
    private Label lbl_m_FoodBuyPrice;

    @FXML
    private Label lbl_m_PartsBuyPrice;

    @FXML
    private Label lbl_m_SpiceBuyPrice;

    @FXML
    private Label lbl_m_OreBuyPrice;

    @FXML
    private Label lbl_m_FoodSellPrice;

    @FXML
    private Label lbl_m_PartsSellPrice;

    @FXML
    private Label lbl_m_SpiceSellPrice;

    @FXML
    private Label lbl_m_OreSellPrice;

    @FXML
    private Label lbl_m_CurFood;

    @FXML
    private Label lbl_m_CurParts;

    @FXML
    private Label lbl_m_CurSpice;

    @FXML
    private Label lbl_m_CurOre;

    @FXML
    private GridPane gp_m_fuel;

    @FXML
    private Label lbl_m_FuelBuyPrice;

    @FXML
    private Label lbl_m_HyperfuelBuyPrice;

    @FXML
    private Button btn_m_buyFuel;

    @FXML
    private Button btn_m_buyHyperfuel;

    @FXML
    private TextField tf_m_fuelAmount;

    @FXML
    private TextField tf_m_hyperFuelAmount;

    @FXML
    private Label lbl_m_tradeimpossible;

    @FXML
    private Label lbl_m_lblFuel;

    @FXML
    private Label lbl_m_lclMarket;

    @FXML
    private Tab tab4;

    @FXML
    private Label lbl_s_dispfood;

    @FXML
    private Label lbl_s_dispparts;

    @FXML
    private Label lbl_s_dispspice;

    @FXML
    private Label lbl_s_dispore;

    @FXML
    private Label lbl_s_name;

    @FXML
    private Label lbl_s_maxSpeed;

    @FXML
    private Label lbl_s_fuelRate;

    @FXML
    private Label lbl_s_maxFuel;

    @FXML
    private Label lbl_s_hyperRate;

    @FXML
    private Label lbl_s_maxHyperFuel;

    @FXML
    private Label lbl_s_value;

    @FXML
    private Label lbl_date;

    @FXML
    private Label lbl_system;

    @FXML
    private Label lbl_location;

    @FXML
    private Label lbl_credits;

    @FXML
    private Label lbl_curcargo;

    @FXML
    private Label lbl_curhyper;

    @FXML
    private Label lbl_curfuel;

    @FXML
    private Label lbl_maxfuel;

    @FXML
    private Label lbl_maxhyper;

    @FXML
    private Label lbl_maxcargo;




    GameInitializer gameInitializer;

    public void initialize(){
        System.out.println("INITIALIZING");
        lbl_date.setText(String.valueOf(turn));
        lbl_credits.setText(String.valueOf(credits));
        lbl_system.setText("Sol");
        lbl_curfuel.setText(String.valueOf(shipCurFuel));
        lbl_curcargo.setText(String.valueOf(shipCurCargo));
        lbl_curhyper.setText(String.valueOf(shipCurHyper));
        lbl_maxcargo.setText(String.valueOf(shipCargoCapacity));
        lbl_maxfuel.setText(String.valueOf(shipFuelCapacity));
        lbl_maxhyper.setText(String.valueOf(shipHyperCapacity));

    }

    int hawkingSolDist;
    int cydoniaDist;
    int gagarinDist;

    void blankHyperscreen(){
        lbl_hyperImpossible.setVisible(true);
        btn_course1.setVisible(false);
        btn_course2.setVisible(false);
        btn_course3.setVisible(false);
        btn_course4.setVisible(false);
        btn_course5.setVisible(false);
        lbl_dist1.setVisible(false);
        lbl_dist2.setVisible(false);
        lbl_dist3.setVisible(false);
        lbl_dist4.setVisible(false);
        lbl_dist5.setVisible(false);
        lbl_distdisp1.setVisible(false);
        lbl_distdisp11.setVisible(false);
        lbl_distdisp12.setVisible(false);
        lbl_distdisp13.setVisible(false);
        lbl_distdisp14.setVisible(false);
        lbl_syst1.setVisible(false);
        lbl_syst11.setVisible(false);
        lbl_syst12.setVisible(false);
        lbl_syst13.setVisible(false);
        lbl_syst14.setVisible(false);
        lbl_systemdisp1.setVisible(false);
        lbl_systemdisp2.setVisible(false);
        lbl_systemdisp3.setVisible(false);
        lbl_systemdisp4.setVisible(false);
        lbl_systemdisp5.setVisible(false);
    }

    void showHyperscreen(){
        lbl_hyperImpossible.setVisible(false);
        btn_course1.setVisible(true);
        btn_course2.setVisible(true);
        btn_course3.setVisible(true);
        btn_course4.setVisible(true);
        btn_course5.setVisible(true);
        lbl_dist1.setVisible(true);
        lbl_dist2.setVisible(true);
        lbl_dist3.setVisible(true);
        lbl_dist4.setVisible(true);
        lbl_dist5.setVisible(true);
        lbl_distdisp1.setVisible(true);
        lbl_distdisp11.setVisible(true);
        lbl_distdisp12.setVisible(true);
        lbl_distdisp13.setVisible(true);
        lbl_distdisp14.setVisible(true);
        lbl_syst1.setVisible(true);
        lbl_syst11.setVisible(true);
        lbl_syst12.setVisible(true);
        lbl_syst13.setVisible(true);
        lbl_syst14.setVisible(true);
        lbl_systemdisp1.setVisible(true);
        lbl_systemdisp2.setVisible(true);
        lbl_systemdisp3.setVisible(true);
        lbl_systemdisp4.setVisible(true);
        lbl_systemdisp5.setVisible(true);

    }
    @FXML
    void restartAction(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("RESTART?");
        alert.setHeaderText("ARE YOU SURE YOU WANT TO RESTART?");
        alert.setContentText("ALL CURRENT PROGRESS WILL BE LOST");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            Stage userStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("/view/introView.fxml"));
            userStage.setTitle("Space Trader");
            userStage.setScene(new Scene(root));
            userStage.show();
            Stage primarystage = (Stage) tab.getScene().getWindow();
            primarystage.close();
        } else {
            System.out.println("restart cancel");
        }


    }


    @FXML
    void refreshHyperAction(MouseEvent event) {
        if (curSys==0 && curLoc==1200) {
            showHyperscreen();
            lbl_distdisp1.setText("600");
            lbl_distdisp11.setText("1400");
            lbl_distdisp12.setText("300");
            lbl_distdisp13.setText("1500");
            lbl_distdisp14.setText("2400");
            lbl_systemdisp1.setText("ALPHA CENTAURI");
            lbl_systemdisp2.setText("ARRAKIS");
            lbl_systemdisp3.setText("ANDROMEDA");
            lbl_systemdisp4.setText("EPSILON ERIDANI");
            lbl_systemdisp5.setText("DENEB");
        }else if(curSys==1 && curLoc==700){
            btn_course1.setVisible(true);
            lbl_dist1.setVisible(true);
            lbl_distdisp1.setVisible(true);
            lbl_syst1.setVisible(true);
            lbl_systemdisp1.setVisible(true);
            lbl_distdisp1.setText("600");
            lbl_systemdisp1.setText("SOL SYSTEM");

            btn_course2.setVisible(false);
            btn_course3.setVisible(false);
            btn_course4.setVisible(false);
            btn_course5.setVisible(false);
            lbl_dist2.setVisible(false);
            lbl_dist3.setVisible(false);
            lbl_dist4.setVisible(false);
            lbl_dist5.setVisible(false);
            lbl_distdisp11.setVisible(false);
            lbl_distdisp12.setVisible(false);
            lbl_distdisp13.setVisible(false);
            lbl_distdisp14.setVisible(false);
            lbl_syst11.setVisible(false);
            lbl_syst12.setVisible(false);
            lbl_syst13.setVisible(false);
            lbl_syst14.setVisible(false);
            lbl_systemdisp2.setVisible(false);
            lbl_systemdisp3.setVisible(false);
            lbl_systemdisp4.setVisible(false);
            lbl_systemdisp5.setVisible(false);

        }else if(curSys==2 && curLoc==300) {
            btn_course1.setVisible(true);
            lbl_dist1.setVisible(true);
            lbl_distdisp1.setVisible(true);
            lbl_syst1.setVisible(true);
            lbl_systemdisp1.setVisible(true);
            lbl_distdisp1.setText("1400");
            lbl_systemdisp1.setText("SOL SYSTEM");

            btn_course2.setVisible(false);
            btn_course3.setVisible(false);
            btn_course4.setVisible(false);
            btn_course5.setVisible(false);
            lbl_dist2.setVisible(false);
            lbl_dist3.setVisible(false);
            lbl_dist4.setVisible(false);
            lbl_dist5.setVisible(false);
            lbl_distdisp11.setVisible(false);
            lbl_distdisp12.setVisible(false);
            lbl_distdisp13.setVisible(false);
            lbl_distdisp14.setVisible(false);
            lbl_syst11.setVisible(false);
            lbl_syst12.setVisible(false);
            lbl_syst13.setVisible(false);
            lbl_syst14.setVisible(false);
            lbl_systemdisp2.setVisible(false);
            lbl_systemdisp3.setVisible(false);
            lbl_systemdisp4.setVisible(false);
            lbl_systemdisp5.setVisible(false);
        }else if(curSys==3 && curLoc==400){
            btn_course1.setVisible(true);
            lbl_dist1.setVisible(true);
            lbl_distdisp1.setVisible(true);
            lbl_syst1.setVisible(true);
            lbl_systemdisp1.setVisible(true);
            lbl_distdisp1.setText("300");
            lbl_systemdisp1.setText("SOL SYSTEM");

            btn_course2.setVisible(true);
            lbl_dist2.setVisible(true);
            lbl_distdisp11.setVisible(true);
            lbl_syst11.setVisible(true);
            lbl_systemdisp2.setVisible(true);
            lbl_distdisp11.setText("2100");
            lbl_systemdisp2.setText("DENEB SYSTEM");

            btn_course3.setVisible(false);
            btn_course4.setVisible(false);
            btn_course5.setVisible(false);
            lbl_dist3.setVisible(false);
            lbl_dist4.setVisible(false);
            lbl_dist5.setVisible(false);
            lbl_distdisp12.setVisible(false);
            lbl_distdisp13.setVisible(false);
            lbl_distdisp14.setVisible(false);
            lbl_syst12.setVisible(false);
            lbl_syst13.setVisible(false);
            lbl_syst14.setVisible(false);
            lbl_systemdisp3.setVisible(false);
            lbl_systemdisp4.setVisible(false);
            lbl_systemdisp5.setVisible(false);
        }else{
            blankHyperscreen();
            Popup popup = new Popup(Alert.AlertType.WARNING, "WARNING", "GRAVITY INTERFERENCE DETECTED", "Hypermapping impossible due to gravitywell interference. Please travel to system's hyperpoint to acces hyperlanes");
        }

    }
    int duneDist;
    int hawkingArrakisDist;
    int armstrongDist;
    int hawkingCentauriDist;
    int lidlDist;
    int tescoDist;
    int hawkingAndromedaDist;

    void gameOverConditionCheck() throws IOException {
        if (credits<0 || shipCurFuel<0){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("GAME OVER");
            alert.setHeaderText("YOU HAVE GONE BANKRUPT");
            alert.setContentText("YOU HAVE SQUANDERED YOUR WEALTH AND GONE BANKRUPT. \n START A NEW GAME?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                Stage userStage = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("/view/introView.fxml"));
                userStage.setTitle("Space Trader");
                userStage.setScene(new Scene(root));
                userStage.show();
                Stage primarystage = (Stage) tab.getScene().getWindow();
                primarystage.close();
            } else {
                System.exit(0);
            }

        }
    }

    @FXML
    void scanAction(MouseEvent event) {
        if (curSys==0){
            btn_travel1.setVisible(true);
            lbl_distance1.setVisible(true);
            lbl_distdisplay1.setVisible(true);
            lbl_object1.setVisible(true);
            lbl_objdisplay1.setVisible(true);
            if(curLoc>=gagarinLoc){
                gagarinDist = curLoc - gagarinLoc;
            }else {
                gagarinDist = gagarinLoc - curLoc;
            }
            lbl_distdisplay1.textProperty().bind(new SimpleIntegerProperty(gagarinDist).asString());
            lbl_objdisplay1.setText("GAGARIN STATION");

            btn_travel2.setVisible(true);
            lbl_distance2.setVisible(true);
            lbl_distdisplay2.setVisible(true);
            lbl_object2.setVisible(true);
            lbl_objdisplay2.setVisible(true);
            if(curLoc>=cydoniaLoc){
                cydoniaDist = curLoc - cydoniaLoc;
            }else {
                cydoniaDist = cydoniaLoc - curLoc;
            }
            lbl_distdisplay2.textProperty().bind(new SimpleIntegerProperty(cydoniaDist).asString());
            lbl_objdisplay2.setText("CYDONIA STATION");

            btn_travel3.setVisible(true);
            lbl_distance3.setVisible(true);
            lbl_distdisplay3.setVisible(true);
            lbl_object3.setVisible(true);
            lbl_objdisplay3.setVisible(true);
            if(curLoc>=hawkingSolLoc){
                hawkingSolDist = curLoc - hawkingSolLoc;
            }else {
                hawkingSolDist = hawkingSolLoc - curLoc;
            }
            lbl_distdisplay3.textProperty().bind(new SimpleIntegerProperty(hawkingSolDist).asString());
            lbl_objdisplay3.setText("SOL SYSTEM HAWKING POINT");
        }else if (curSys==1){
            btn_travel1.setVisible(true);
            lbl_distance1.setVisible(true);
            lbl_distdisplay1.setVisible(true);
            lbl_object1.setVisible(true);
            lbl_objdisplay1.setVisible(true);
            if(curLoc>=armstrongLoc){
                armstrongDist = curLoc - armstrongLoc;
            }else {
                armstrongDist = armstrongLoc - curLoc;
            }
            lbl_distdisplay1.textProperty().bind(new SimpleIntegerProperty(armstrongDist).asString());
            lbl_objdisplay1.setText("ARMSTRONG STATION");

            btn_travel2.setVisible(true);
            lbl_distance2.setVisible(true);
            lbl_distdisplay2.setVisible(true);
            lbl_object2.setVisible(true);
            lbl_objdisplay2.setVisible(true);
            if(curLoc>=hawkingArrakisLoc){
                hawkingCentauriDist = curLoc - hawkingCentauriLoc;
            }else {
                hawkingCentauriDist = hawkingCentauriLoc - curLoc;
            }
            lbl_distdisplay2.textProperty().bind(new SimpleIntegerProperty(hawkingCentauriDist).asString());
            lbl_objdisplay2.setText("CENTAURI HAWKING POINT");

        }else if (curSys==2){
            btn_travel1.setVisible(true);
            lbl_distance1.setVisible(true);
            lbl_distdisplay1.setVisible(true);
            lbl_object1.setVisible(true);
            lbl_objdisplay1.setVisible(true);
            if(curLoc>=duneLoc){
                duneDist = curLoc - duneLoc;
            }else {
                duneDist = duneLoc - curLoc;
            }
            lbl_distdisplay1.textProperty().bind(new SimpleIntegerProperty(duneDist).asString());
            lbl_objdisplay1.setText("PLANET DUNE STATION");

            btn_travel2.setVisible(true);
            lbl_distance2.setVisible(true);
            lbl_distdisplay2.setVisible(true);
            lbl_object2.setVisible(true);
            lbl_objdisplay2.setVisible(true);
            if(curLoc>=hawkingArrakisLoc){
                hawkingArrakisDist = curLoc - hawkingArrakisLoc;
            }else {
                hawkingArrakisDist = hawkingArrakisLoc - curLoc;
            }
            lbl_distdisplay2.textProperty().bind(new SimpleIntegerProperty(hawkingArrakisDist).asString());
            lbl_objdisplay2.setText("ARRAKIS HAWKING POINT");

        }else if(curSys==3){
            btn_travel1.setVisible(true);
            lbl_distance1.setVisible(true);
            lbl_distdisplay1.setVisible(true);
            lbl_object1.setVisible(true);
            lbl_objdisplay1.setVisible(true);
            if(curLoc>=lidlLoc){
               lidlDist = curLoc - lidlLoc;
            }else {
                lidlDist = lidlLoc - curLoc;
            }
            lbl_distdisplay1.textProperty().bind(new SimpleIntegerProperty(lidlDist).asString());
            lbl_objdisplay1.setText("LIDL STATION");

            btn_travel2.setVisible(true);
            lbl_distance2.setVisible(true);
            lbl_distdisplay2.setVisible(true);
            lbl_object2.setVisible(true);
            lbl_objdisplay2.setVisible(true);
            if(curLoc>=tescoLoc){
                tescoDist = curLoc - tescoLoc;
            }else {
                tescoDist = tescoLoc - curLoc;
            }
            lbl_distdisplay2.textProperty().bind(new SimpleIntegerProperty(tescoDist).asString());
            lbl_objdisplay2.setText("TESCO STATION");

            btn_travel3.setVisible(true);
            lbl_distance3.setVisible(true);
            lbl_distdisplay3.setVisible(true);
            lbl_object3.setVisible(true);
            lbl_objdisplay3.setVisible(true);
            if(curLoc>=hawkingAndromedaLoc){
                hawkingAndromedaDist = curLoc - hawkingAndromedaLoc;
            }else {
                hawkingAndromedaDist = hawkingAndromedaLoc - curLoc;
            }
            lbl_distdisplay3.textProperty().bind(new SimpleIntegerProperty(hawkingAndromedaDist).asString());
            lbl_objdisplay3.setText("ANDROMEDA SYSTEM HAWKING POINT");
        }

    }

    @FXML
    void travel1Action(MouseEvent event) {
        if (curSys==0) {
            if (gagarinDist == 0) {
                Popup popup = new Popup(Alert.AlertType.WARNING, "Warning", "Distance 0", "Cannot travel, already at destination");
            } else {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("CONFIRM TRAVEL");
                alert.setHeaderText("Are you sure wish to travel to Gagarin Station?");
                alert.setContentText("Traveling will take " + (gagarinDist / shipSpeed) + " turns and use " + (gagarinDist * shipFuelConsuption) + " units of fuel. Proceed?");

                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    System.out.println("travel confirmed");
                    Popup popup = new Popup(Alert.AlertType.INFORMATION, "Journey complete", null, "Arrived at Gagarin Station");
                    turn = turn + (gagarinDist / shipSpeed);
                    shipCurFuel = shipCurFuel - (gagarinDist * shipFuelConsuption);
                    curLoc = 0;
                    lbl_location.setText("Gagarin Station");
                    System.out.println(turn);
                    lbl_date.textProperty().bind(new SimpleIntegerProperty(turn).asString());
                    lbl_curfuel.setText(String.valueOf(shipCurFuel));
                    btn_travel1.setVisible(false);
                    btn_travel2.setVisible(false);
                    btn_travel3.setVisible(false);
                } else {
                    System.out.println("travel cancel");
                }
            }
        }else if (curSys==1){
            if (armstrongDist == 0) {
                Popup popup = new Popup(Alert.AlertType.WARNING, "Warning", "Distance 0", "Cannot travel, already at destination");
            } else {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("CONFIRM TRAVEL");
                alert.setHeaderText("Are you sure wish to travel to Armstrong Station?");
                alert.setContentText("Traveling will take " + (armstrongDist / shipSpeed) + " turns and use " + (armstrongDist * shipFuelConsuption) + " units of fuel. Proceed?");

                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    System.out.println("travel confirmed");
                    Popup popup = new Popup(Alert.AlertType.INFORMATION, "Journey complete", null, "Arrived at Armstrong Station");
                    turn = turn + (armstrongDist / shipSpeed);
                    shipCurFuel = shipCurFuel - (armstrongDist * shipFuelConsuption);
                    curLoc = 400;
                    lbl_location.setText("Armstrong Station");
                    System.out.println(turn);
                    lbl_date.textProperty().bind(new SimpleIntegerProperty(turn).asString());
                    lbl_curfuel.setText(String.valueOf(shipCurFuel));
                    btn_travel1.setVisible(false);
                    btn_travel2.setVisible(false);
                    btn_travel3.setVisible(false);
                } else {
                    System.out.println("travel cancel");
                }
            }

        }else if (curSys==2){
            if (duneDist == 0) {
                Popup popup = new Popup(Alert.AlertType.WARNING, "Warning", "Distance 0", "Cannot travel, already at destination");
            } else {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("CONFIRM TRAVEL");
                alert.setHeaderText("Are you sure wish to travel to Dune Station?");
                alert.setContentText("Traveling will take " + (duneDist / shipSpeed) + " turns and use " + (duneDist * shipFuelConsuption) + " units of fuel. Proceed?");

                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    System.out.println("travel confirmed");
                    Popup popup = new Popup(Alert.AlertType.INFORMATION, "Journey complete", null, "Arrived at Dune Station");
                    turn = turn + (duneDist / shipSpeed);
                    shipCurFuel = shipCurFuel - (duneDist * shipFuelConsuption);
                    curLoc = 0;
                    lbl_location.setText("Dune Station");
                    System.out.println(turn);
                    lbl_date.textProperty().bind(new SimpleIntegerProperty(turn).asString());
                    lbl_curfuel.setText(String.valueOf(shipCurFuel));
                    btn_travel1.setVisible(false);
                    btn_travel2.setVisible(false);
                    btn_travel3.setVisible(false);
                } else {
                    System.out.println("travel cancel");
                }
            }

        }else if(curSys==3) {
            if (lidlDist == 0) {
                Popup popup = new Popup(Alert.AlertType.WARNING, "Warning", "Distance 0", "Cannot travel, already at destination");
            } else {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("CONFIRM TRAVEL");
                alert.setHeaderText("Are you sure wish to travel to Lidl Station?");
                alert.setContentText("Traveling will take " + (lidlDist / shipSpeed) + " turns and use " + (lidlDist * shipFuelConsuption) + " units of fuel. Proceed?");

                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    System.out.println("travel confirmed");
                    Popup popup = new Popup(Alert.AlertType.INFORMATION, "Journey complete", null, "Arrived at Lidl Station");
                    turn = turn + (lidlDist / shipSpeed);
                    shipCurFuel = shipCurFuel - (lidlDist * shipFuelConsuption);
                    curLoc = 0;
                    lbl_location.setText("Lidl Station");
                    System.out.println(turn);
                    lbl_date.textProperty().bind(new SimpleIntegerProperty(turn).asString());
                    lbl_curfuel.setText(String.valueOf(shipCurFuel));
                    btn_travel1.setVisible(false);
                    btn_travel2.setVisible(false);
                    btn_travel3.setVisible(false);
                } else {
                    System.out.println("travel cancel");
                }
            }
        }

    }

    @FXML
    void travel2Action(MouseEvent event) {
        if (curSys==0){
            if (cydoniaDist==0){
                Popup popup = new Popup(Alert.AlertType.WARNING, "Warning","Distance 0", "Cannot travel, already at destination");
            }else {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("CONFIRM TRAVEL");
                alert.setHeaderText("Are you sure wish to travel to Cydonia Station?");
                alert.setContentText("Traveling will take " + (cydoniaDist / shipSpeed) + " turns and use " + (cydoniaDist * shipFuelConsuption) + " units of fuel. Proceed?");

                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    System.out.println("travel confirmed");
                    Popup popup = new Popup(Alert.AlertType.INFORMATION, "Journey complete", null, "Arrived at cydonia Station");
                    turn = turn + (cydoniaDist / shipSpeed);
                    shipCurFuel = shipCurFuel - (cydoniaDist * shipFuelConsuption);
                    curLoc = 300;
                    lbl_location.setText("Cydonia Station");
                    System.out.println(turn);
                    lbl_date.textProperty().bind(new SimpleIntegerProperty(turn).asString());
                    lbl_curfuel.setText(String.valueOf(shipCurFuel));
                    btn_travel1.setVisible(false);
                    btn_travel2.setVisible(false);
                    btn_travel3.setVisible(false);
                } else {
                    System.out.println("travel cancel");
                }
            }
        }else if(curSys==2){
            if (hawkingArrakisDist == 0) {
                Popup popup = new Popup(Alert.AlertType.WARNING, "Warning", "Distance 0", "Cannot travel, already at destination");
            } else {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("CONFIRM TRAVEL");
                alert.setHeaderText("Are you sure wish to travel to Arrakis Hawking Point?");
                alert.setContentText("Traveling will take " + (hawkingArrakisDist / shipSpeed) + " turns and use " + (hawkingArrakisDist * shipFuelConsuption) + " units of fuel. Proceed?");

                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    System.out.println("travel confirmed");
                    Popup popup = new Popup(Alert.AlertType.INFORMATION, "Journey complete", null, "Arrived at Arrakis Hawing Point");
                    turn = turn + (hawkingArrakisDist / shipSpeed);
                    shipCurFuel = shipCurFuel - (hawkingArrakisDist * shipFuelConsuption);
                    curLoc = 300;
                    lbl_location.setText("Arrakis Hawking Point");
                    System.out.println(turn);
                    lbl_date.textProperty().bind(new SimpleIntegerProperty(turn).asString());
                    lbl_curfuel.setText(String.valueOf(shipCurFuel));
                    btn_travel1.setVisible(false);
                    btn_travel2.setVisible(false);
                    btn_travel3.setVisible(false);
                } else {
                    System.out.println("travel cancel");
                }
            }
        }else if(curSys==1){
            if (hawkingCentauriDist == 0) {
                Popup popup = new Popup(Alert.AlertType.WARNING, "Warning", "Distance 0", "Cannot travel, already at destination");
            } else {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("CONFIRM TRAVEL");
                alert.setHeaderText("Are you sure wish to travel to Hawking Centauri Point?");
                alert.setContentText("Traveling will take " + (hawkingCentauriDist / shipSpeed) + " turns and use " + (hawkingCentauriDist * shipFuelConsuption) + " units of fuel. Proceed?");

                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    System.out.println("travel confirmed");
                    Popup popup = new Popup(Alert.AlertType.INFORMATION, "Journey complete", null, "Arrived at Alpha Centauri Hawking Point");
                    turn = turn + (hawkingCentauriDist / shipSpeed);
                    shipCurFuel = shipCurFuel - (hawkingCentauriDist * shipFuelConsuption);
                    curLoc = 700;
                    lbl_location.setText("Centauri Hawking Point");
                    System.out.println(turn);
                    lbl_date.textProperty().bind(new SimpleIntegerProperty(turn).asString());
                    lbl_curfuel.setText(String.valueOf(shipCurFuel));
                    btn_travel1.setVisible(false);
                    btn_travel2.setVisible(false);
                    btn_travel3.setVisible(false);
                } else {
                    System.out.println("travel cancel");
                }
            }
        }else if(curSys==3){
            if (tescoDist == 0) {
                Popup popup = new Popup(Alert.AlertType.WARNING, "Warning", "Distance 0", "Cannot travel, already at destination");
            } else {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("CONFIRM TRAVEL");
                alert.setHeaderText("Are you sure wish to travel to Tesco Station?");
                alert.setContentText("Traveling will take " + (tescoDist / shipSpeed) + " turns and use " + (tescoDist * shipFuelConsuption) + " units of fuel. Proceed?");

                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    System.out.println("travel confirmed");
                    Popup popup = new Popup(Alert.AlertType.INFORMATION, "Journey complete", null, "Arrived at Tesco Station");
                    turn = turn + (tescoDist / shipSpeed);
                    shipCurFuel = shipCurFuel - (tescoDist * shipFuelConsuption);
                    curLoc = 200;
                    lbl_location.setText("Tesco Station");
                    System.out.println(turn);
                    lbl_date.textProperty().bind(new SimpleIntegerProperty(turn).asString());
                    lbl_curfuel.setText(String.valueOf(shipCurFuel));
                    btn_travel1.setVisible(false);
                    btn_travel2.setVisible(false);
                    btn_travel3.setVisible(false);
                } else {
                    System.out.println("travel cancel");
                }
            }
        }

    }

    @FXML
    void travel3Action(MouseEvent event) {
        if (curSys==0){
            if (hawkingSolDist==0){
                Popup popup = new Popup(Alert.AlertType.WARNING, "Warning","Distance 0", "Cannot travel, already at destination");
            }else {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("CONFIRM TRAVEL");
                alert.setHeaderText("Are you sure wish to travel to Solar Hawking Point?");
                alert.setContentText("Traveling will take " + (hawkingSolDist / shipSpeed) + " turns and use " + (hawkingSolDist * shipFuelConsuption) + " units of fuel. Proceed?");

                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    System.out.println("travel confirmed");
                    Popup popup = new Popup(Alert.AlertType.INFORMATION, "Journey complete", null, "Arrived at Hawking Point");
                    turn = turn + (hawkingSolDist / shipSpeed);
                    shipCurFuel = shipCurFuel - (hawkingSolDist * shipFuelConsuption);
                    curLoc = 1200;
                    lbl_location.setText("Solar Hawking Point");
                    System.out.println(turn);
                    lbl_date.textProperty().bind(new SimpleIntegerProperty(turn).asString());
                    lbl_curfuel.setText(String.valueOf(shipCurFuel));
                    btn_travel1.setVisible(false);
                    btn_travel2.setVisible(false);
                    btn_travel3.setVisible(false);
                } else {
                    System.out.println("travel cancel");
                }
            }
        }else if(curSys==3) {
            if (hawkingAndromedaDist == 0) {
                Popup popup = new Popup(Alert.AlertType.WARNING, "Warning", "Distance 0", "Cannot travel, already at destination");
            } else {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("CONFIRM TRAVEL");
                alert.setHeaderText("Are you sure wish to travel to Andromedaar Hawking Point?");
                alert.setContentText("Traveling will take " + (hawkingAndromedaDist / shipSpeed) + " turns and use " + (hawkingAndromedaDist * shipFuelConsuption) + " units of fuel. Proceed?");

                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    System.out.println("travel confirmed");
                    Popup popup = new Popup(Alert.AlertType.INFORMATION, "Journey complete", null, "Arrived at Andromeda Hawking Point");
                    turn = turn + (hawkingAndromedaDist / shipSpeed);
                    shipCurFuel = shipCurFuel - (hawkingAndromedaDist * shipFuelConsuption);
                    curLoc = 400;
                    lbl_location.setText("Andromeda Hawking Point");
                    System.out.println(turn);
                    lbl_date.textProperty().bind(new SimpleIntegerProperty(turn).asString());
                    lbl_curfuel.setText(String.valueOf(shipCurFuel));
                    btn_travel1.setVisible(false);
                    btn_travel2.setVisible(false);
                    btn_travel3.setVisible(false);
                } else {
                    System.out.println("travel cancel");
                }
            }
        }

    }

    public int courseSet;

    @FXML
    void course1Action(ActionEvent event) {
        if (curSys==0){
            courseSet=1;
            lbl_estimateImpossible.setVisible(false);
            lbl_hyperfueldisp.setVisible(true);
            lbl_hypertargetdisp.setVisible(true);
            lbl_hypertargetdisp1.setVisible(true);
            lbl_hyperfuel.setVisible(true);
            lbl_hyperfueldisp.setVisible(true);
            lbl_hyperfuel1.setVisible(true);
            lbl_hypertargetdisp.setText("ALPHA CENTAURI");
            lbl_hyperfueldisp.textProperty().bind(new SimpleIntegerProperty(shipHyperConsuption*600).asString());
            btn_jump.setDisable(false);
        }else if (curSys==2) {
            courseSet=1;
            lbl_estimateImpossible.setVisible(false);
            lbl_hyperfueldisp.setVisible(true);
            lbl_hypertargetdisp.setVisible(true);
            lbl_hypertargetdisp1.setVisible(true);
            lbl_hyperfuel.setVisible(true);
            lbl_hyperfueldisp.setVisible(true);
            lbl_hyperfuel1.setVisible(true);
            lbl_hypertargetdisp.setText("SOL SYSTEM");
            lbl_hyperfueldisp.textProperty().bind(new SimpleIntegerProperty(shipHyperConsuption*1400).asString());
            btn_jump.setDisable(false);

        }else if (curSys ==1){
            courseSet=1;
            lbl_estimateImpossible.setVisible(false);
            lbl_hyperfueldisp.setVisible(true);
            lbl_hypertargetdisp.setVisible(true);
            lbl_hypertargetdisp1.setVisible(true);
            lbl_hyperfuel.setVisible(true);
            lbl_hyperfueldisp.setVisible(true);
            lbl_hyperfuel1.setVisible(true);
            lbl_hypertargetdisp.setText("SOL SYSTEM");
            lbl_hyperfueldisp.textProperty().bind(new SimpleIntegerProperty(shipHyperConsuption*600).asString());
            btn_jump.setDisable(false);

        }else if (curSys ==3){
            courseSet=1;
            lbl_estimateImpossible.setVisible(false);
            lbl_hyperfueldisp.setVisible(true);
            lbl_hypertargetdisp.setVisible(true);
            lbl_hypertargetdisp1.setVisible(true);
            lbl_hyperfuel.setVisible(true);
            lbl_hyperfueldisp.setVisible(true);
            lbl_hyperfuel1.setVisible(true);
            lbl_hypertargetdisp.setText("SOL SYSTEM");
            lbl_hyperfueldisp.textProperty().bind(new SimpleIntegerProperty(shipHyperConsuption*300).asString());
            btn_jump.setDisable(false);

        }else if (curSys ==4){
            courseSet=1;
            lbl_estimateImpossible.setVisible(false);
            lbl_hyperfueldisp.setVisible(true);
            lbl_hypertargetdisp.setVisible(true);
            lbl_hypertargetdisp1.setVisible(true);
            lbl_hyperfuel.setVisible(true);
            lbl_hyperfueldisp.setVisible(true);
            lbl_hyperfuel1.setVisible(true);
            lbl_hypertargetdisp.setText("SOL SYSTEM");
            lbl_hyperfueldisp.textProperty().bind(new SimpleIntegerProperty(shipHyperConsuption*1500).asString());
            btn_jump.setDisable(false);

        }

    }

    @FXML
    void course2Action(ActionEvent event) {
        if (curSys==0){
            courseSet=2;
            lbl_estimateImpossible.setVisible(false);
            lbl_hyperfueldisp.setVisible(true);
            lbl_hypertargetdisp.setVisible(true);
            lbl_hypertargetdisp1.setVisible(true);
            lbl_hyperfuel.setVisible(true);
            lbl_hyperfueldisp.setVisible(true);
            lbl_hyperfuel1.setVisible(true);
            lbl_hypertargetdisp.setText("ARRAKIS");
            lbl_hyperfueldisp.textProperty().bind(new SimpleIntegerProperty(shipHyperConsuption*1400).asString());
            btn_jump.setDisable(false);
        }else if(curSys==3){
            lbl_estimateImpossible.setVisible(false);
            lbl_hyperfueldisp.setVisible(true);
            lbl_hypertargetdisp.setVisible(true);
            lbl_hypertargetdisp1.setVisible(true);
            lbl_hyperfuel.setVisible(true);
            lbl_hyperfueldisp.setVisible(true);
            lbl_hyperfuel1.setVisible(true);
            lbl_hypertargetdisp.setText("DENEB");
            lbl_hyperfueldisp.textProperty().bind(new SimpleIntegerProperty(shipHyperConsuption*2100).asString());
            btn_jump.setDisable(false);
        }
    }

    @FXML
    void course3Action(ActionEvent event) {
        if (curSys==0){
            courseSet=3;
            lbl_estimateImpossible.setVisible(false);
            lbl_hyperfueldisp.setVisible(true);
            lbl_hypertargetdisp.setVisible(true);
            lbl_hypertargetdisp1.setVisible(true);
            lbl_hyperfuel.setVisible(true);
            lbl_hyperfueldisp.setVisible(true);
            lbl_hyperfuel1.setVisible(true);
            lbl_hypertargetdisp.setText("ANDROMEDA");
            lbl_hyperfueldisp.textProperty().bind(new SimpleIntegerProperty(shipHyperConsuption*300).asString());
            btn_jump.setDisable(false);
        }
    }

    @FXML
    void course4Action(ActionEvent event) {
        if (curSys==0){
            courseSet=4;
            lbl_estimateImpossible.setVisible(false);
            lbl_hyperfueldisp.setVisible(true);
            lbl_hypertargetdisp.setVisible(true);
            lbl_hypertargetdisp1.setVisible(true);
            lbl_hyperfuel.setVisible(true);
            lbl_hyperfueldisp.setVisible(true);
            lbl_hyperfuel1.setVisible(true);
            lbl_hypertargetdisp.setText("EPSILON ERIDANI");
            lbl_hyperfueldisp.textProperty().bind(new SimpleIntegerProperty(shipHyperConsuption*1500).asString());
            btn_jump.setDisable(false);
        }
    }

    @FXML
    void course5Action(ActionEvent event) {
        if (curSys==0) {
            courseSet = 5;
            lbl_estimateImpossible.setVisible(false);
            lbl_hyperfueldisp.setVisible(true);
            lbl_hypertargetdisp.setVisible(true);
            lbl_hypertargetdisp1.setVisible(true);
            lbl_hyperfuel.setVisible(true);
            lbl_hyperfueldisp.setVisible(true);
            lbl_hyperfuel1.setVisible(true);
            lbl_hypertargetdisp.setText("DENEB");
            lbl_hyperfueldisp.textProperty().bind(new SimpleIntegerProperty(shipHyperConsuption * 2400).asString());
            btn_jump.setDisable(false);

        }
    }

    @FXML
    void jumpAction(MouseEvent event) {
        if(curSys==0){
            if (courseSet==1){
                lbl_estimateImpossible.setVisible(true);
                lbl_hyperfueldisp.setVisible(false);
                lbl_hypertargetdisp.setVisible(false);
                lbl_hypertargetdisp1.setVisible(false);
                lbl_hyperfuel.setVisible(false);
                lbl_hyperfueldisp.setVisible(false);
                lbl_hyperfuel1.setVisible(false);
                btn_jump.setDisable(true);

                curSys=1;
                lbl_system.setText("ALPHA CENTAURI");
                curLoc=100;
                shipCurHyper=shipCurHyper-(shipHyperConsuption*600);
                lbl_curhyper.setText(String.valueOf(shipCurHyper));
                Popup popup = new Popup(Alert.AlertType.INFORMATION, "JUMP COMPLETE", "JUMP COMPLETED","SUCCESFULLY ARRIVED IN ALPHA CENTAURI");
                lbl_location.setText("deep space");
                blankHyperscreen();
            }else if (courseSet==2) {
                lbl_estimateImpossible.setVisible(true);
                lbl_hyperfueldisp.setVisible(false);
                lbl_hypertargetdisp.setVisible(false);
                lbl_hypertargetdisp1.setVisible(false);
                lbl_hyperfuel.setVisible(false);
                lbl_hyperfueldisp.setVisible(false);
                lbl_hyperfuel1.setVisible(false);
                btn_jump.setDisable(true);

                curSys = 2;
                lbl_system.setText("ARRAKIS");
                curLoc = 100;
                shipCurHyper = shipCurHyper - (shipHyperConsuption * 1400);
                lbl_curhyper.setText(String.valueOf(shipCurHyper));
                Popup popup = new Popup(Alert.AlertType.INFORMATION, "JUMP COMPLETE", "JUMP COMPLETED", "SUCCESFULLY ARRIVED IN ARRAKIS SYSTEM");
                lbl_location.setText("deep space");
                blankHyperscreen();
            }else if (courseSet==3){
                lbl_estimateImpossible.setVisible(true);
                lbl_hyperfueldisp.setVisible(false);
                lbl_hypertargetdisp.setVisible(false);
                lbl_hypertargetdisp1.setVisible(false);
                lbl_hyperfuel.setVisible(false);
                lbl_hyperfueldisp.setVisible(false);
                lbl_hyperfuel1.setVisible(false);
                btn_jump.setDisable(true);

                curSys = 3;
                lbl_system.setText("ANDROMEDA");
                curLoc = 100;
                shipCurHyper = shipCurHyper - (shipHyperConsuption * 300);
                lbl_curhyper.setText(String.valueOf(shipCurHyper));
                Popup popup = new Popup(Alert.AlertType.INFORMATION, "JUMP COMPLETE", "JUMP COMPLETED", "SUCCESFULLY ARRIVED IN ANDROMEDA SYSTEM");
                lbl_location.setText("deep space");
                blankHyperscreen();

            }else if (courseSet==4){
                lbl_estimateImpossible.setVisible(true);
                lbl_hyperfueldisp.setVisible(false);
                lbl_hypertargetdisp.setVisible(false);
                lbl_hypertargetdisp1.setVisible(false);
                lbl_hyperfuel.setVisible(false);
                lbl_hyperfueldisp.setVisible(false);
                lbl_hyperfuel1.setVisible(false);
                btn_jump.setDisable(true);

                curSys = 4;
                lbl_system.setText("EPSILON ERIDANI");
                curLoc = 100;
                shipCurHyper = shipCurHyper - (shipHyperConsuption * 1500);
                lbl_curhyper.setText(String.valueOf(shipCurHyper));
                Popup popup = new Popup(Alert.AlertType.INFORMATION, "JUMP COMPLETE", "JUMP COMPLETED", "SUCCESFULLY ARRIVED IN EPSILON ERIDANI SYSTEM");
                lbl_location.setText("deep space");
                blankHyperscreen();
            }

        }else if(curSys==1){
            lbl_estimateImpossible.setVisible(true);
            lbl_hyperfueldisp.setVisible(false);
            lbl_hypertargetdisp.setVisible(false);
            lbl_hypertargetdisp1.setVisible(false);
            lbl_hyperfuel.setVisible(false);
            lbl_hyperfueldisp.setVisible(false);
            lbl_hyperfuel1.setVisible(false);
            btn_jump.setDisable(true);

            curSys=0;
            lbl_system.setText("Sol");
            curLoc=100;
            shipCurHyper=shipCurHyper-(shipHyperConsuption*600);
            lbl_curhyper.setText(String.valueOf(shipCurHyper));
            Popup popup = new Popup(Alert.AlertType.INFORMATION, "JUMP COMPLETE", "JUMP COMPLETED","SUCCESFULLY ARRIVED IN SOL SYSTEM");
            lbl_location.setText("deep space");
            blankHyperscreen();


        }else if(curSys==2){
            lbl_estimateImpossible.setVisible(true);
            lbl_hyperfueldisp.setVisible(false);
            lbl_hypertargetdisp.setVisible(false);
            lbl_hypertargetdisp1.setVisible(false);
            lbl_hyperfuel.setVisible(false);
            lbl_hyperfueldisp.setVisible(false);
            lbl_hyperfuel1.setVisible(false);
            btn_jump.setDisable(true);

            curSys=0;
            lbl_system.setText("Sol");
            curLoc=100;
            shipCurHyper=shipCurHyper-(shipHyperConsuption*1400);
            lbl_curhyper.setText(String.valueOf(shipCurHyper));
            Popup popup = new Popup(Alert.AlertType.INFORMATION, "JUMP COMPLETE", "JUMP COMPLETED","SUCCESFULLY ARRIVED IN SOL SYSTEM");
            lbl_location.setText("deep space");
            blankHyperscreen();

        }else if(curSys==3){
            if(courseSet==1){
                lbl_estimateImpossible.setVisible(true);
                lbl_hyperfueldisp.setVisible(false);
                lbl_hypertargetdisp.setVisible(false);
                lbl_hypertargetdisp1.setVisible(false);
                lbl_hyperfuel.setVisible(false);
                lbl_hyperfueldisp.setVisible(false);
                lbl_hyperfuel1.setVisible(false);
                btn_jump.setDisable(true);

                curSys = 0;
                lbl_system.setText("Sol");
                curLoc = 100;
                shipCurHyper = shipCurHyper - (shipHyperConsuption * 300);
                lbl_curhyper.setText(String.valueOf(shipCurHyper));
                Popup popup = new Popup(Alert.AlertType.INFORMATION, "JUMP COMPLETE", "JUMP COMPLETED", "SUCCESFULLY ARRIVED IN SOL SYSTEM");
                lbl_location.setText("deep space");
                blankHyperscreen();
            }else if(courseSet==2){
                lbl_estimateImpossible.setVisible(true);
                lbl_hyperfueldisp.setVisible(false);
                lbl_hypertargetdisp.setVisible(false);
                lbl_hypertargetdisp1.setVisible(false);
                lbl_hyperfuel.setVisible(false);
                lbl_hyperfueldisp.setVisible(false);
                lbl_hyperfuel1.setVisible(false);
                btn_jump.setDisable(true);

                curSys = 5;
                lbl_system.setText("Deneb");
                curLoc = 100;
                shipCurHyper = shipCurHyper - (shipHyperConsuption * 2100);
                lbl_curhyper.setText(String.valueOf(shipCurHyper));
                Popup popup = new Popup(Alert.AlertType.INFORMATION, "JUMP COMPLETE", "JUMP COMPLETED", "SUCCESFULLY ARRIVED IN DENEB SYSTEM");
                lbl_location.setText("deep space");
                blankHyperscreen();
            }

        }else if(curSys==4){

        }


    }

    public void populateShip(){
        lbl_s_dispfood.setText(String.valueOf(curFood));
        lbl_s_dispore.setText(String.valueOf(curOre));
        lbl_s_dispparts.setText(String.valueOf(curParts));
        lbl_s_dispspice.setText(String.valueOf(curSpice));

        lbl_s_name.setText(shipType);
        lbl_s_maxSpeed.setText(String.valueOf(shipSpeed));
        lbl_s_fuelRate.setText(String.valueOf(shipFuelConsuption));
        lbl_s_maxFuel.setText(String.valueOf(shipFuelCapacity));
        lbl_s_hyperRate.setText(String.valueOf(shipHyperConsuption));
        lbl_s_maxHyperFuel.setText(String.valueOf(shipHyperCapacity));
        lbl_s_value.setText(String.valueOf(shipValue*0.8));



    }

    public void populateMarket(){
        if (curSys==0){
            if(curLoc==0){
                showMarket();
                lbl_m_FoodBuyPrice.setText(String.valueOf(gagarinFoodBuyPrice));
                lbl_m_FoodSellPrice.setText(String.valueOf(gagarinFoodSellPrice));
                lbl_m_PartsBuyPrice.setText(String.valueOf(gagarinPartsBuyPrice));
                lbl_m_PartsSellPrice.setText(String.valueOf(gagarinPartsSellPrice));
                lbl_m_OreBuyPrice.setText(String.valueOf(gagarinOreBuyPrice));
                lbl_m_OreSellPrice.setText(String.valueOf(gagarinOreSellPrice));
                lbl_m_SpiceBuyPrice.setText(String.valueOf(gagarinSpiceBuyPrice));
                lbl_m_SpiceSellPrice.setText(String.valueOf(gagarinSpiceSellPrice));
                lbl_m_FuelBuyPrice.setText(String.valueOf(gagarinFuelSellPrice));
                lbl_m_HyperfuelBuyPrice.setText(String.valueOf(gagarinHyperfuelSellPrice));
                lbl_m_CurFood.setText(String.valueOf(curFood));
                lbl_m_CurOre.setText(String.valueOf(curOre));
                lbl_m_CurParts.setText(String.valueOf(curParts));
                lbl_m_CurSpice.setText(String.valueOf(curSpice));
            }else if (curLoc==300){
                showMarket();
                lbl_m_FoodBuyPrice.setText(String.valueOf(cydoniaFoodBuyPrice));
                lbl_m_FoodSellPrice.setText(String.valueOf(cydoniaFoodSellPrice));
                lbl_m_PartsBuyPrice.setText(String.valueOf(cydoniaPartsBuyPrice));
                lbl_m_PartsSellPrice.setText(String.valueOf(cydoniaPartsSellPrice));
                lbl_m_OreBuyPrice.setText(String.valueOf(cydoniaOreBuyPrice));
                lbl_m_OreSellPrice.setText(String.valueOf(cydoniaOreSellPrice));
                lbl_m_SpiceBuyPrice.setText(String.valueOf(cydoniaSpiceBuyPrice));
                lbl_m_SpiceSellPrice.setText(String.valueOf(cydoniaSpiceSellPrice));
                lbl_m_FuelBuyPrice.setText(String.valueOf(cydoniaFuelSellPrice));
                lbl_m_HyperfuelBuyPrice.setText(String.valueOf(cydoniaHyperfuelSellPrice));
                lbl_m_CurFood.setText(String.valueOf(curFood));
                lbl_m_CurOre.setText(String.valueOf(curOre));
                lbl_m_CurParts.setText(String.valueOf(curParts));
                lbl_m_CurSpice.setText(String.valueOf(curSpice));
            }else
                hideMarket();
            }else if(curSys==2 && curLoc==0) {
            showMarket();
            lbl_m_FoodBuyPrice.setText(String.valueOf(duneFoodBuyPrice));
            lbl_m_FoodSellPrice.setText(String.valueOf(duneFoodSellPrice));
            lbl_m_PartsBuyPrice.setText(String.valueOf(dunePartsBuyPrice));
            lbl_m_PartsSellPrice.setText(String.valueOf(dunePartsSellPrice));
            lbl_m_OreBuyPrice.setText(String.valueOf(duneOreBuyPrice));
            lbl_m_OreSellPrice.setText(String.valueOf(duneOreSellPrice));
            lbl_m_SpiceBuyPrice.setText(String.valueOf(duneSpiceBuyPrice));
            lbl_m_SpiceSellPrice.setText(String.valueOf(duneSpiceSellPrice));
            lbl_m_FuelBuyPrice.setText(String.valueOf(duneFuelSellPrice));
            lbl_m_HyperfuelBuyPrice.setText(String.valueOf(duneHyperfuelSellPrice));
            lbl_m_CurFood.setText(String.valueOf(curFood));
            lbl_m_CurOre.setText(String.valueOf(curOre));
            lbl_m_CurParts.setText(String.valueOf(curParts));
            lbl_m_CurSpice.setText(String.valueOf(curSpice));
            }else if(curSys==1 && curLoc==400) {
            showMarket();
            lbl_m_FoodBuyPrice.setText(String.valueOf(armstrongFoodBuyPrice));
            lbl_m_FoodSellPrice.setText(String.valueOf(armstrongFoodSellPrice));
            lbl_m_PartsBuyPrice.setText(String.valueOf(armstrongPartsBuyPrice));
            lbl_m_PartsSellPrice.setText(String.valueOf(armstrongPartsSellPrice));
            lbl_m_OreBuyPrice.setText(String.valueOf(armstrongOreBuyPrice));
            lbl_m_OreSellPrice.setText(String.valueOf(armstrongOreSellPrice));
            lbl_m_SpiceBuyPrice.setText(String.valueOf(armstrongSpiceBuyPrice));
            lbl_m_SpiceSellPrice.setText(String.valueOf(armstrongSpiceSellPrice));
            lbl_m_FuelBuyPrice.setText(String.valueOf(armstrongFuelSellPrice));
            lbl_m_HyperfuelBuyPrice.setText(String.valueOf(armstrongHyperfuelSellPrice));
            lbl_m_CurFood.setText(String.valueOf(curFood));
            lbl_m_CurOre.setText(String.valueOf(curOre));
            lbl_m_CurParts.setText(String.valueOf(curParts));
            lbl_m_CurSpice.setText(String.valueOf(curSpice));
            }else if(curSys==3){
                if(curLoc==0){
                    lbl_m_FoodBuyPrice.setText(String.valueOf(lidlFoodBuyPrice));
                    lbl_m_FoodSellPrice.setText(String.valueOf(lidlFoodSellPrice));
                    lbl_m_PartsBuyPrice.setText(String.valueOf(lidlPartsBuyPrice));
                    lbl_m_PartsSellPrice.setText(String.valueOf(lidlPartsSellPrice));
                    lbl_m_OreBuyPrice.setText(String.valueOf(lidlOreBuyPrice));
                    lbl_m_OreSellPrice.setText(String.valueOf(lidlOreSellPrice));
                    lbl_m_SpiceBuyPrice.setText(String.valueOf(lidlSpiceBuyPrice));
                    lbl_m_SpiceSellPrice.setText(String.valueOf(lidlSpiceSellPrice));
                    lbl_m_FuelBuyPrice.setText(String.valueOf(lidlFuelSellPrice));
                    lbl_m_HyperfuelBuyPrice.setText(String.valueOf(lidlHyperfuelSellPrice));
                    lbl_m_CurFood.setText(String.valueOf(curFood));
                    lbl_m_CurOre.setText(String.valueOf(curOre));
                    lbl_m_CurParts.setText(String.valueOf(curParts));
                    lbl_m_CurSpice.setText(String.valueOf(curSpice));
                }else if(curLoc==200){
                    lbl_m_FoodBuyPrice.setText(String.valueOf(tescoFoodBuyPrice));
                    lbl_m_FoodSellPrice.setText(String.valueOf(tescoFoodSellPrice));
                    lbl_m_PartsBuyPrice.setText(String.valueOf(tescoPartsBuyPrice));
                    lbl_m_PartsSellPrice.setText(String.valueOf(tescoPartsSellPrice));
                    lbl_m_OreBuyPrice.setText(String.valueOf(tescoOreBuyPrice));
                    lbl_m_OreSellPrice.setText(String.valueOf(tescoOreSellPrice));
                    lbl_m_SpiceBuyPrice.setText(String.valueOf(tescoSpiceBuyPrice));
                    lbl_m_SpiceSellPrice.setText(String.valueOf(tescoSpiceSellPrice));
                    lbl_m_FuelBuyPrice.setText(String.valueOf(tescoFuelSellPrice));
                    lbl_m_HyperfuelBuyPrice.setText(String.valueOf(tescoHyperfuelSellPrice));
                    lbl_m_CurFood.setText(String.valueOf(curFood));
                    lbl_m_CurOre.setText(String.valueOf(curOre));
                    lbl_m_CurParts.setText(String.valueOf(curParts));
                    lbl_m_CurSpice.setText(String.valueOf(curSpice));
                }

        }else{
            hideMarket();
        }

    }

    public void showMarket(){
        gp_m_fuel.setVisible(true);
        gp_m_station.setVisible(true);
        lbl_m_lblFuel.setVisible(true);
        lbl_m_lclMarket.setVisible(true);
        lbl_m_tradeimpossible.setVisible(false);



    }
    public void hideMarket(){
        gp_m_fuel.setVisible(false);
        gp_m_station.setVisible(false);
        lbl_m_lblFuel.setVisible(false);
        lbl_m_lclMarket.setVisible(false);
        lbl_m_tradeimpossible.setVisible(true);

    }

    @FXML
    void tabAction(MouseEvent event) throws IOException {
        if(tab.getSelectionModel().getSelectedIndex() == 0){
            System.out.println("i1");
            lbl_distance1.setVisible(false);
            lbl_distance2.setVisible(false);
            lbl_distance3.setVisible(false);
            lbl_object1.setVisible(false);
            lbl_object2.setVisible(false);
            lbl_object3.setVisible(false);
            lbl_distdisplay1.setVisible(false);
            lbl_distdisplay2.setVisible(false);
            lbl_distdisplay3.setVisible(false);
            lbl_objdisplay1.setVisible(false);
            lbl_objdisplay2.setVisible(false);
            lbl_objdisplay3.setVisible(false);
            btn_travel1.setVisible(false);
            btn_travel2.setVisible(false);
            btn_travel3.setVisible(false);
            gameOverConditionCheck();
        } else if (tab.getSelectionModel().getSelectedItem() == tab2){
            System.out.println("i2");
            gameOverConditionCheck();
        } else if (tab.getSelectionModel().getSelectedItem() == tab3){
            populateMarket();
            gameOverConditionCheck();
        } else if (tab.getSelectionModel().getSelectedItem() == tab4){
            populateShip();
            gameOverConditionCheck();
        }
    }
    @FXML
    void oreBuyAction(ActionEvent event) {
        if (curSys==0){
            if (curLoc==0){
                shipCurCargo++;
                curOre++;
                credits=credits-gagarinOreSellPrice;
                lbl_curcargo.setText(String.valueOf(shipCurCargo));
                lbl_credits.setText(String.valueOf(credits));
                lbl_m_CurOre.setText(String.valueOf(curOre));

            }else if(curLoc==300){
                shipCurCargo++;
                curOre++;
                credits=credits-cydoniaOreSellPrice;
                lbl_curcargo.setText(String.valueOf(shipCurCargo));
                lbl_credits.setText(String.valueOf(credits));
                lbl_m_CurOre.setText(String.valueOf(curOre));

            }
        }else if(curSys==1){
            shipCurCargo++;
            curOre++;
            credits=credits-armstrongOreSellPrice;
            lbl_curcargo.setText(String.valueOf(shipCurCargo));
            lbl_credits.setText(String.valueOf(credits));
            lbl_m_CurOre.setText(String.valueOf(curOre));

        }else if(curSys==2){
            shipCurCargo++;
            curOre++;
            credits=credits-duneOreSellPrice;
            lbl_curcargo.setText(String.valueOf(shipCurCargo));
            lbl_credits.setText(String.valueOf(credits));
            lbl_m_CurOre.setText(String.valueOf(curOre));
        }else if (curSys == 3) {
            if (curLoc == 0) {
                shipCurCargo++;
                curOre++;
                credits=credits-lidlOreSellPrice;
                lbl_curcargo.setText(String.valueOf(shipCurCargo));
                lbl_credits.setText(String.valueOf(credits));
                lbl_m_CurOre.setText(String.valueOf(curOre));

            } else if (curLoc == 200) {
                shipCurCargo++;
                curOre++;
                credits=credits-tescoOreSellPrice;
                lbl_curcargo.setText(String.valueOf(shipCurCargo));
                lbl_credits.setText(String.valueOf(credits));
                lbl_m_CurOre.setText(String.valueOf(curOre));
            }

        }else if (curSys == 4) {}

    }

    @FXML
    void oreSellAction(ActionEvent event) {
        if (curSys==0){
            if (curLoc==0){
                shipCurCargo--;
                curOre--;
                credits=credits+gagarinOreBuyPrice;
                lbl_curcargo.setText(String.valueOf(shipCurCargo));
                lbl_credits.setText(String.valueOf(credits));
                lbl_m_CurOre.setText(String.valueOf(curOre));

            }else if(curLoc==300){
                shipCurCargo--;
                curOre--;
                credits=credits+cydoniaOreBuyPrice;
                lbl_curcargo.setText(String.valueOf(shipCurCargo));
                lbl_credits.setText(String.valueOf(credits));
                lbl_m_CurOre.setText(String.valueOf(curOre));

            }
        }else if(curSys==1){
            shipCurCargo--;
            curOre--;
            credits=credits+armstrongOreBuyPrice;
            lbl_curcargo.setText(String.valueOf(shipCurCargo));
            lbl_credits.setText(String.valueOf(credits));
            lbl_m_CurOre.setText(String.valueOf(curOre));

        }else if(curSys==2){
            shipCurCargo--;
            curOre--;
            credits=credits+duneOreBuyPrice;
            lbl_curcargo.setText(String.valueOf(shipCurCargo));
            lbl_credits.setText(String.valueOf(credits));
            lbl_m_CurOre.setText(String.valueOf(curOre));
        }else if (curSys == 3) {
            if (curLoc == 0) {
                shipCurCargo--;
                curOre--;
                credits=credits+lidlOreBuyPrice;
                lbl_curcargo.setText(String.valueOf(shipCurCargo));
                lbl_credits.setText(String.valueOf(credits));
                lbl_m_CurOre.setText(String.valueOf(curOre));

            } else if (curLoc == 200) {
                shipCurCargo--;
                curOre--;
                credits=credits+tescoOreBuyPrice;
                lbl_curcargo.setText(String.valueOf(shipCurCargo));
                lbl_credits.setText(String.valueOf(credits));
                lbl_m_CurOre.setText(String.valueOf(curOre));
            }

        }else if (curSys == 4) {}

    }

    @FXML
    void partsBuyAction(ActionEvent event) {
        if (curSys==0){
            if (curLoc==0){
                shipCurCargo++;
                curParts++;
                credits=credits-gagarinPartsSellPrice;
                lbl_curcargo.setText(String.valueOf(shipCurCargo));
                lbl_credits.setText(String.valueOf(credits));
                lbl_m_CurParts.setText(String.valueOf(curParts));

            }else if(curLoc==300){
                shipCurCargo++;
                curParts++;
                credits=credits-cydoniaPartsSellPrice;
                lbl_curcargo.setText(String.valueOf(shipCurCargo));
                lbl_credits.setText(String.valueOf(credits));
                lbl_m_CurParts.setText(String.valueOf(curParts));

            }
        }else if(curSys==1){
            shipCurCargo++;
            curParts++;
            credits=credits-armstrongPartsSellPrice;
            lbl_curcargo.setText(String.valueOf(shipCurCargo));
            lbl_credits.setText(String.valueOf(credits));
            lbl_m_CurParts.setText(String.valueOf(curParts));

        }else if(curSys==2){
            shipCurCargo++;
            curParts++;
            credits=credits-dunePartsSellPrice;
            lbl_curcargo.setText(String.valueOf(shipCurCargo));
            lbl_credits.setText(String.valueOf(credits));
            lbl_m_CurParts.setText(String.valueOf(curParts));
        }else if (curSys == 3) {
            if (curLoc == 0) {
                shipCurCargo++;
                curParts++;
                credits=credits-lidlPartsSellPrice;
                lbl_curcargo.setText(String.valueOf(shipCurCargo));
                lbl_credits.setText(String.valueOf(credits));
                lbl_m_CurParts.setText(String.valueOf(curParts));
            } else if (curLoc == 200) {
                shipCurCargo++;
                curParts++;
                credits=credits-tescoPartsSellPrice;
                lbl_curcargo.setText(String.valueOf(shipCurCargo));
                lbl_credits.setText(String.valueOf(credits));
                lbl_m_CurParts.setText(String.valueOf(curParts));
            }

        }else if (curSys == 4) {}


    }

    @FXML
    void partsSellAction(ActionEvent event) {
        if (curSys==0){
            if (curLoc==0){
                shipCurCargo--;
                curParts--;
                credits=credits+gagarinPartsBuyPrice;
                lbl_curcargo.setText(String.valueOf(shipCurCargo));
                lbl_credits.setText(String.valueOf(credits));
                lbl_m_CurParts.setText(String.valueOf(curParts));

            }else if(curLoc==300){
                shipCurCargo--;
                curParts--;
                credits=credits+cydoniaPartsBuyPrice;
                lbl_curcargo.setText(String.valueOf(shipCurCargo));
                lbl_credits.setText(String.valueOf(credits));
                lbl_m_CurParts.setText(String.valueOf(curParts));

            }
        }else if(curSys==1){
            shipCurCargo--;
            curParts--;
            credits=credits+armstrongPartsBuyPrice;
            lbl_curcargo.setText(String.valueOf(shipCurCargo));
            lbl_credits.setText(String.valueOf(credits));
            lbl_m_CurParts.setText(String.valueOf(curParts));

        }else if(curSys==2){
            shipCurCargo--;
            curParts--;
            credits=credits+dunePartsBuyPrice;
            lbl_curcargo.setText(String.valueOf(shipCurCargo));
            lbl_credits.setText(String.valueOf(credits));
            lbl_m_CurParts.setText(String.valueOf(curParts));
        }else if (curSys == 3) {
            if (curLoc == 0) {
                shipCurCargo--;
                curParts--;
                credits=credits+lidlPartsBuyPrice;
                lbl_curcargo.setText(String.valueOf(shipCurCargo));
                lbl_credits.setText(String.valueOf(credits));
                lbl_m_CurParts.setText(String.valueOf(curParts));

            } else if (curLoc == 200) {
                shipCurCargo--;
                curParts--;
                credits=credits+tescoPartsBuyPrice;
                lbl_curcargo.setText(String.valueOf(shipCurCargo));
                lbl_credits.setText(String.valueOf(credits));
                lbl_m_CurParts.setText(String.valueOf(curParts));
            }

        }else if (curSys == 4) {}

    }


    @FXML
    void foodBuyAction(ActionEvent event) {
        if (curSys==0){
            if (curLoc==0){
                shipCurCargo++;
                curFood++;
                credits=credits-gagarinFoodSellPrice;
                lbl_curcargo.setText(String.valueOf(shipCurCargo));
                lbl_credits.setText(String.valueOf(credits));
                lbl_m_CurFood.setText(String.valueOf(curFood));

            }else if(curLoc==300){
                shipCurCargo++;
                curFood++;
                credits=credits-cydoniaFoodSellPrice;
                lbl_curcargo.setText(String.valueOf(shipCurCargo));
                lbl_credits.setText(String.valueOf(credits));
                lbl_m_CurFood.setText(String.valueOf(curFood));

            }
        }else if(curSys==1){
            shipCurCargo++;
            curFood++;
            credits=credits-armstrongFoodSellPrice;
            lbl_curcargo.setText(String.valueOf(shipCurCargo));
            lbl_credits.setText(String.valueOf(credits));
            lbl_m_CurFood.setText(String.valueOf(curFood));

        }else if(curSys==2){
            shipCurCargo++;
            curFood++;
            credits=credits-duneFoodSellPrice;
            lbl_curcargo.setText(String.valueOf(shipCurCargo));
            lbl_credits.setText(String.valueOf(credits));
            lbl_m_CurFood.setText(String.valueOf(curFood));
        }else if (curSys == 3) {
            if (curLoc == 0) {
                shipCurCargo++;
                curFood++;
                credits=credits-lidlFoodSellPrice;
                lbl_curcargo.setText(String.valueOf(shipCurCargo));
                lbl_credits.setText(String.valueOf(credits));
                lbl_m_CurFood.setText(String.valueOf(curFood));
            } else if (curLoc == 200) {
                shipCurCargo++;
                curFood++;
                credits=credits-tescoFoodSellPrice;
                lbl_curcargo.setText(String.valueOf(shipCurCargo));
                lbl_credits.setText(String.valueOf(credits));
                lbl_m_CurFood.setText(String.valueOf(curFood));
            }

        }else if (curSys == 4) {}

    }

    @FXML
    void foodSellAction(ActionEvent event) {
        if (curSys==0){
            if (curLoc==0){
                shipCurCargo--;
                curFood--;
                credits=credits+gagarinFoodBuyPrice;
                lbl_curcargo.setText(String.valueOf(shipCurCargo));
                lbl_credits.setText(String.valueOf(credits));
                lbl_m_CurFood.setText(String.valueOf(curFood));

            }else if(curLoc==300){
                shipCurCargo--;
                curFood--;
                credits=credits+cydoniaFoodBuyPrice;
                lbl_curcargo.setText(String.valueOf(shipCurCargo));
                lbl_credits.setText(String.valueOf(credits));
                lbl_m_CurFood.setText(String.valueOf(curFood));

            }
        }else if(curSys==1){
            shipCurCargo--;
            curFood--;
            credits=credits+armstrongFoodBuyPrice;
            lbl_curcargo.setText(String.valueOf(shipCurCargo));
            lbl_credits.setText(String.valueOf(credits));
            lbl_m_CurFood.setText(String.valueOf(curFood));

        }else if(curSys==2){
            shipCurCargo--;
            curFood--;
            credits=credits+duneFoodBuyPrice;
            lbl_curcargo.setText(String.valueOf(shipCurCargo));
            lbl_credits.setText(String.valueOf(credits));
            lbl_m_CurFood.setText(String.valueOf(curFood));
        }else if (curSys == 3) {
            if (curLoc == 0) {
                shipCurCargo--;
                curFood--;
                credits=credits+lidlFoodBuyPrice;
                lbl_curcargo.setText(String.valueOf(shipCurCargo));
                lbl_credits.setText(String.valueOf(credits));
                lbl_m_CurFood.setText(String.valueOf(curFood));
            } else if (curLoc == 200) {
                shipCurCargo--;
                curFood--;
                credits=credits+tescoFoodBuyPrice;
                lbl_curcargo.setText(String.valueOf(shipCurCargo));
                lbl_credits.setText(String.valueOf(credits));
                lbl_m_CurFood.setText(String.valueOf(curFood));
            }

        }else if (curSys == 4) {}

    }

    int fuelToBuy;
    int hyperToBuy;

    @FXML
    void fuelBuyAction(ActionEvent event) {
        fuelToBuy = Integer.valueOf(tf_m_fuelAmount.getText());
        if (curSys==0){
            if (curLoc==0){
                shipCurFuel=shipCurFuel+fuelToBuy;
                credits=credits-(gagarinFuelSellPrice*fuelToBuy);
                lbl_curcargo.setText(String.valueOf(shipCurCargo));
                lbl_credits.setText(String.valueOf(credits));
                lbl_curfuel.setText(String.valueOf(shipCurFuel));
                tf_m_fuelAmount.setText(null);

            }else if(curLoc==300){
                shipCurFuel=shipCurFuel+fuelToBuy;
                credits=credits-(cydoniaFuelSellPrice*fuelToBuy);
                lbl_curcargo.setText(String.valueOf(shipCurCargo));
                lbl_credits.setText(String.valueOf(credits));
                lbl_curfuel.setText(String.valueOf(shipCurFuel));
                tf_m_fuelAmount.setText(null);

            }
        }else if(curSys==1){
            shipCurFuel=shipCurFuel+fuelToBuy;
            credits=credits-(armstrongFuelSellPrice*fuelToBuy);
            lbl_curcargo.setText(String.valueOf(shipCurCargo));
            lbl_credits.setText(String.valueOf(credits));
            lbl_curfuel.setText(String.valueOf(shipCurFuel));
            tf_m_fuelAmount.setText(null);

        }else if(curSys==2){
            shipCurFuel=shipCurFuel+fuelToBuy;
            credits=credits-(duneFuelSellPrice*fuelToBuy);
            lbl_curcargo.setText(String.valueOf(shipCurCargo));
            lbl_credits.setText(String.valueOf(credits));
            lbl_curfuel.setText(String.valueOf(shipCurFuel));
            tf_m_fuelAmount.setText(null);

        }else if (curSys == 3) {
            if (curLoc == 0) {
                shipCurFuel=shipCurFuel+fuelToBuy;
                credits=credits-(lidlFuelSellPrice*fuelToBuy);
                lbl_curcargo.setText(String.valueOf(shipCurCargo));
                lbl_credits.setText(String.valueOf(credits));
                lbl_curfuel.setText(String.valueOf(shipCurFuel));
                tf_m_fuelAmount.setText(null);

            } else if (curLoc == 200) {
                shipCurFuel=shipCurFuel+fuelToBuy;
                credits=credits-(tescoFuelSellPrice*fuelToBuy);
                lbl_curcargo.setText(String.valueOf(shipCurCargo));
                lbl_credits.setText(String.valueOf(credits));
                lbl_curfuel.setText(String.valueOf(shipCurFuel));
                tf_m_fuelAmount.setText(null);
            }

        }else if (curSys == 4) {}


    }

    @FXML
    void hyperfuelBuyAction(ActionEvent event) {
        hyperToBuy = Integer.valueOf(tf_m_hyperFuelAmount.getText());
        if (curSys==0){
            if (curLoc==0){
                shipCurHyper=shipCurHyper+hyperToBuy;
                credits=credits-(gagarinHyperfuelSellPrice*hyperToBuy);
                lbl_curcargo.setText(String.valueOf(shipCurCargo));
                lbl_credits.setText(String.valueOf(credits));
                lbl_curhyper.setText(String.valueOf(shipCurHyper));
                tf_m_hyperFuelAmount.setText(null);

            }else if(curLoc==300){
                shipCurHyper=shipCurHyper+hyperToBuy;
                credits=credits-(cydoniaHyperfuelSellPrice*hyperToBuy);
                lbl_curcargo.setText(String.valueOf(shipCurCargo));
                lbl_credits.setText(String.valueOf(credits));
                lbl_curhyper.setText(String.valueOf(shipCurHyper));
                tf_m_hyperFuelAmount.setText(null);

            }
        }else if(curSys==1){
            shipCurHyper=shipCurHyper+hyperToBuy;
            credits=credits-(armstrongHyperfuelSellPrice*hyperToBuy);
            lbl_curcargo.setText(String.valueOf(shipCurCargo));
            lbl_credits.setText(String.valueOf(credits));
            lbl_curhyper.setText(String.valueOf(shipCurHyper));
            tf_m_hyperFuelAmount.setText(null);

        }else if(curSys==2){
            shipCurHyper=shipCurHyper+hyperToBuy;
            credits=credits-(duneHyperfuelSellPrice*hyperToBuy);
            lbl_curcargo.setText(String.valueOf(shipCurCargo));
            lbl_credits.setText(String.valueOf(credits));
            lbl_curhyper.setText(String.valueOf(shipCurHyper));
            tf_m_hyperFuelAmount.setText(null);

        }else if (curSys == 3) {
            if (curLoc == 0) {
                shipCurFuel=shipCurFuel+fuelToBuy;
                credits=credits-(lidlFuelSellPrice*fuelToBuy);
                lbl_curcargo.setText(String.valueOf(shipCurCargo));
                lbl_credits.setText(String.valueOf(credits));
                lbl_curfuel.setText(String.valueOf(shipCurFuel));
                tf_m_hyperFuelAmount.setText(null);

            } else if (curLoc == 200) {
                shipCurFuel=shipCurFuel+fuelToBuy;
                credits=credits-(tescoFuelSellPrice*fuelToBuy);
                lbl_curcargo.setText(String.valueOf(shipCurCargo));
                lbl_credits.setText(String.valueOf(credits));
                lbl_curfuel.setText(String.valueOf(shipCurFuel));
                tf_m_hyperFuelAmount.setText(null);
            }

        }else if (curSys == 4) {}

    }
    @FXML
    void spiceBuyAction(ActionEvent event) {
        if (curSys==0){
            if (curLoc==0){
                shipCurCargo++;
                curSpice++;
                credits=credits-gagarinSpiceSellPrice;
                lbl_curcargo.setText(String.valueOf(shipCurCargo));
                lbl_credits.setText(String.valueOf(credits));
                lbl_m_CurSpice.setText(String.valueOf(curSpice));

            }else if(curLoc==300){
                shipCurCargo++;
                curSpice++;
                credits=credits-cydoniaSpiceSellPrice;
                lbl_curcargo.setText(String.valueOf(shipCurCargo));
                lbl_credits.setText(String.valueOf(credits));
                lbl_m_CurSpice.setText(String.valueOf(curSpice));

            }
        }else if(curSys==1){
            shipCurCargo++;
            curSpice++;
            credits=credits-armstrongSpiceSellPrice;
            lbl_curcargo.setText(String.valueOf(shipCurCargo));
            lbl_credits.setText(String.valueOf(credits));
            lbl_m_CurSpice.setText(String.valueOf(curSpice));

        }else if(curSys==2){
            shipCurCargo++;
            curSpice++;
            credits=credits-duneSpiceSellPrice;
            lbl_curcargo.setText(String.valueOf(shipCurCargo));
            lbl_credits.setText(String.valueOf(credits));
            lbl_m_CurSpice.setText(String.valueOf(curSpice));
        }else if (curSys == 3) {
            if (curLoc == 0) {
                shipCurCargo++;
                curSpice++;
                credits=credits-lidlSpiceSellPrice;
                lbl_curcargo.setText(String.valueOf(shipCurCargo));
                lbl_credits.setText(String.valueOf(credits));
                lbl_m_CurSpice.setText(String.valueOf(curSpice));
            } else if (curLoc == 200) {
                shipCurCargo++;
                curSpice++;
                credits=credits-tescoSpiceSellPrice;
                lbl_curcargo.setText(String.valueOf(shipCurCargo));
                lbl_credits.setText(String.valueOf(credits));
                lbl_m_CurSpice.setText(String.valueOf(curSpice));
            }

        }else if (curSys == 4) {}

    }

    @FXML
    void spiceSellAction(ActionEvent event) {
        if (curSys == 0) {
            if (curLoc == 0) {
                shipCurCargo--;
                curSpice--;
                credits = credits + gagarinSpiceBuyPrice;
                lbl_curcargo.setText(String.valueOf(shipCurCargo));
                lbl_credits.setText(String.valueOf(credits));
                lbl_m_CurSpice.setText(String.valueOf(curSpice));

            } else if (curLoc == 300) {
                shipCurCargo--;
                curSpice--;
                credits = credits + cydoniaSpiceBuyPrice;
                lbl_curcargo.setText(String.valueOf(shipCurCargo));
                lbl_credits.setText(String.valueOf(credits));
                lbl_m_CurSpice.setText(String.valueOf(curSpice));

            }
        } else if (curSys == 1) {
            shipCurCargo--;
            curSpice--;
            credits = credits + armstrongSpiceBuyPrice;
            lbl_curcargo.setText(String.valueOf(shipCurCargo));
            lbl_credits.setText(String.valueOf(credits));
            lbl_m_CurSpice.setText(String.valueOf(curSpice));

        } else if (curSys == 2) {
            shipCurCargo--;
            curSpice--;
            credits = credits + duneSpiceBuyPrice;
            lbl_curcargo.setText(String.valueOf(shipCurCargo));
            lbl_credits.setText(String.valueOf(credits));
            lbl_m_CurSpice.setText(String.valueOf(curSpice));

        } else if (curSys == 3) {
            if (curLoc == 0) {
                shipCurCargo--;
                curSpice--;
                credits = credits + lidlSpiceBuyPrice;
                lbl_curcargo.setText(String.valueOf(shipCurCargo));
                lbl_credits.setText(String.valueOf(credits));
                lbl_m_CurSpice.setText(String.valueOf(curSpice));
            } else if (curLoc == 200) {
                shipCurCargo--;
                curSpice--;
                credits = credits + tescoSpiceBuyPrice;
                lbl_curcargo.setText(String.valueOf(shipCurCargo));
                lbl_credits.setText(String.valueOf(credits));
                lbl_m_CurSpice.setText(String.valueOf(curSpice));
            }

        }else if (curSys == 4) {}
    }

}
