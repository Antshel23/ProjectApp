package projectapp.Models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StockModel {

@JsonProperty("ticker")
private String ticker;
@JsonProperty("price")
private String price;
@JsonProperty("change_amount")
private String change_amount;
@JsonProperty("change_percentage")
private String change_percentage;
@JsonProperty("volume")
private String volume;

public StockModel() {

}

public StockModel(String ticker, String price, String change_amount, String change_percentage, String volume) {
    this.ticker = ticker;
    this.price = price;
    this.change_amount = change_amount;
    this.change_percentage = change_percentage;
    this.volume = volume;
}

public String getTicker() {
    return ticker;
}

public void setTicker(String ticker) {
    this.ticker = ticker;
}

public String getPrice() {
    return price;
}

public void setPrice(String price) {
    this.price = price;
}

public String getChangeAmount() {
    return change_amount;
}

public void setChangeAmount(String change_amount) {
    this.change_amount = change_amount;
}

public String getChangePercentage() {
    return change_percentage;
}

public void setChangePercentage(String change_percentage) {
    this.change_percentage = change_percentage;
}

public String getVolume() {
    return volume;
}

public void setVolume(String volume) {
    this.volume = volume;
}
}
