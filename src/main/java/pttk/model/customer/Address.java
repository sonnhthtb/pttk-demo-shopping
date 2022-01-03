package pttk.model.customer;


public class Address {
    private Integer id;
    private String numberHouse;
    private String street;
    private String district;
    private String city;
    private String nation;

    public Address(String numberHouse, String street, String district, String city, String nation) {
        this.numberHouse = numberHouse;
        this.street = street;
        this.district = district;
        this.city = city;
        this.nation = nation;
    }

    public Address() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumberHouse() {
        return numberHouse;
    }

    public void setNumberHouse(String numberHouse) {
        this.numberHouse = numberHouse;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public boolean isValid() {
        return numberHouse != null && street != null && district != null && city != null && nation != null;
    }
}
