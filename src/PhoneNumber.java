public class PhoneNumber {
    private String Countrycode;
    private String Number;

    @Override
    public String toString() {
        return "PhoneNumber{" +
                "Countrycode='" + Countrycode + '\'' +
                ", Number='" + Number + '\'' +
                '}';
    }

    public String getCountrycode() {
        return Countrycode;
    }

    public void setCountrycode(String countrycode) {
        Countrycode = countrycode;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }
}