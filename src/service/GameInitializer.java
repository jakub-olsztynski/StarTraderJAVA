package service;

import javafx.beans.value.ObservableValue;

public class GameInitializer {

    //date set
//    private int year = 3001;
//    private int month = 03;
//    private int date = 25;
//    public Date curDate = new Date(year,month,date);
//    DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
//    String strDate = dateFormat.format(curDate);
    public int turn = 1;

    //location and distance
    public String curSys = "Sol";
    public int curLoc = 0;

    public int gagarinLoc = 0;
    public int cydoniaLoc = 300;
    public int hawkingSolLoc = 1200;

    public int arrakisLoc = 0;
    public int hawkingArrakisLoc= 2000;


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

    //initial prices set, Arrakis, Arrakis
    private int arrakisFuelBuyPrice = 18;
    private int arrakisFuelSellPrice = 20;
    private int arrakisHyperfuelBuyPrice = 110;
    private int arrakisHyperfuelSellPrice = 132;
    private int arrakisFoodBuyPrice = 92;
    private int arrakisFoodSellPrice = 110;
    private int arrakisPartsBuyPrice = 47;
    private int arrakisPartsSellPrice = 67;
    private int arrakisSpiceBuyPrice = 920;
    private int arrakisSpiceSellPrice = 1100;

    public GameInitializer(int turn, String curSys, int curLoc, int gagarinLoc, int cydoniaLoc, int hawkingSolLoc, int arrakisLoc, int hawkingArrakisLoc, int gagarinFuelBuyPrice, int gagarinFuelSellPrice, int gagarinHyperfuelBuyPrice, int gagarinHyperfuelSellPrice, int gagarinFoodBuyPrice, int gagarinFoodSellPrice, int gagarinPartsBuyPrice, int gagarinPartsSellPrice, int gagarinSpiceBuyPrice, int gagarinSpiceSellPrice, int cydoniaFuelBuyPrice, int cydoniaFuelSellPrice, int cydoniaHyperfuelBuyPrice, int cydoniaHyperfuelSellPrice, int cydoniaFoodBuyPrice, int cydoniaFoodSellPrice, int cydoniaPartsBuyPrice, int cydoniaPartsSellPrice, int cydoniaSpiceBuyPrice, int cydoniaSpiceSellPrice, int arrakisFuelBuyPrice, int arrakisFuelSellPrice, int arrakisHyperfuelBuyPrice, int arrakisHyperfuelSellPrice, int arrakisFoodBuyPrice, int arrakisFoodSellPrice, int arrakisPartsBuyPrice, int arrakisPartsSellPrice, int arrakisSpiceBuyPrice, int arrakisSpiceSellPrice) {
        this.turn = turn;
        this.curSys = curSys;
        this.curLoc = curLoc;
        this.gagarinLoc = gagarinLoc;
        this.cydoniaLoc = cydoniaLoc;
        this.hawkingSolLoc = hawkingSolLoc;
        this.arrakisLoc = arrakisLoc;
        this.hawkingArrakisLoc = hawkingArrakisLoc;
        this.gagarinFuelBuyPrice = gagarinFuelBuyPrice;
        this.gagarinFuelSellPrice = gagarinFuelSellPrice;
        this.gagarinHyperfuelBuyPrice = gagarinHyperfuelBuyPrice;
        this.gagarinHyperfuelSellPrice = gagarinHyperfuelSellPrice;
        this.gagarinFoodBuyPrice = gagarinFoodBuyPrice;
        this.gagarinFoodSellPrice = gagarinFoodSellPrice;
        this.gagarinPartsBuyPrice = gagarinPartsBuyPrice;
        this.gagarinPartsSellPrice = gagarinPartsSellPrice;
        this.gagarinSpiceBuyPrice = gagarinSpiceBuyPrice;
        this.gagarinSpiceSellPrice = gagarinSpiceSellPrice;
        this.cydoniaFuelBuyPrice = cydoniaFuelBuyPrice;
        this.cydoniaFuelSellPrice = cydoniaFuelSellPrice;
        this.cydoniaHyperfuelBuyPrice = cydoniaHyperfuelBuyPrice;
        this.cydoniaHyperfuelSellPrice = cydoniaHyperfuelSellPrice;
        this.cydoniaFoodBuyPrice = cydoniaFoodBuyPrice;
        this.cydoniaFoodSellPrice = cydoniaFoodSellPrice;
        this.cydoniaPartsBuyPrice = cydoniaPartsBuyPrice;
        this.cydoniaPartsSellPrice = cydoniaPartsSellPrice;
        this.cydoniaSpiceBuyPrice = cydoniaSpiceBuyPrice;
        this.cydoniaSpiceSellPrice = cydoniaSpiceSellPrice;
        this.arrakisFuelBuyPrice = arrakisFuelBuyPrice;
        this.arrakisFuelSellPrice = arrakisFuelSellPrice;
        this.arrakisHyperfuelBuyPrice = arrakisHyperfuelBuyPrice;
        this.arrakisHyperfuelSellPrice = arrakisHyperfuelSellPrice;
        this.arrakisFoodBuyPrice = arrakisFoodBuyPrice;
        this.arrakisFoodSellPrice = arrakisFoodSellPrice;
        this.arrakisPartsBuyPrice = arrakisPartsBuyPrice;
        this.arrakisPartsSellPrice = arrakisPartsSellPrice;
        this.arrakisSpiceBuyPrice = arrakisSpiceBuyPrice;
        this.arrakisSpiceSellPrice = arrakisSpiceSellPrice;
    }


}
