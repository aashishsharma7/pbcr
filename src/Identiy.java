import java.io.Serializable;

public class Identiy implements Serializable {
    private String panDetails;
    private String aadharNo;

    public Identiy(String panDetails, String aadharNo) {
        this.panDetails = panDetails;
        this.aadharNo = aadharNo;
    }

    public String getPanDetails() {
        return panDetails;
    }

    public void setPanDetails(String panDetails) {
        this.panDetails = panDetails;
    }

    public String getAadharNo() {
        return aadharNo;
    }

    public void setAadharNo(String aadharNo) {
        this.aadharNo = aadharNo;
    }

}
