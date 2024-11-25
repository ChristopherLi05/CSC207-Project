package use_case.calculator;

import entity.calculator.HandState;
import entity.calculator.mahjong.MahjongTile;

import java.util.List;

public class CalculatorInputData {
    public final HandState hand;

    //TO DO not sure if this input type is Handstate
    public CalculatorInputData(HandState hand) {
        this.hand = hand;
    }

    public HandState getHand() {
        return hand;
    }

}
