import java.io.Serializable;

public class Transaction implements Serializable {

    private Identiy sellerId;
    private Identiy buyerId;
    private LandDescription landDescription;
    private long price;

    public Transaction(Identiy sellerId, Identiy buyerId, LandDescription landDescription, long price) {
        this.sellerId = sellerId;
        this.buyerId = buyerId;
        this.landDescription = landDescription;
        this.price = price;
    }

    public Identiy getSellerId() {
        return sellerId;
    }

    public void setSellerId(Identiy sellerId) {
        this.sellerId = sellerId;
    }

    public Identiy getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Identiy buyerId) {
        this.buyerId = buyerId;
    }

    public LandDescription getLandDescription() {
        return landDescription;
    }

    public void setLandDescription(LandDescription landDescription) {
        this.landDescription = landDescription;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

}
