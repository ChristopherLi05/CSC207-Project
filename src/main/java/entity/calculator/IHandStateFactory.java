package entity.calculator;

public interface IHandStateFactory {
    HandState createHandState(String closed, String closedGroup, String open, String winning, String dora, String ura, String seatWind, String roundWind, int flags);

    HandState createHandState(String serialization);
}
