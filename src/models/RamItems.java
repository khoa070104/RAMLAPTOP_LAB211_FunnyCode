package models;

public class RamItems {
    private String code, type, bus, brand ;
    private int  quantity,production_month_year;
    private boolean active;

    public RamItems(String code, String type, String bus, String brand, int quantity, int production_month_year) {
        this.code = code;
        this.type = type;
        this.bus = bus;
        this.brand = brand;
        this.quantity = quantity;
        this.production_month_year = production_month_year;
        this.active = true;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBus() {
        return bus;
    }

    public void setBus(String bus) {
        this.bus = bus;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getProduction_month_year() {
        return production_month_year;
    }

    public void setProduction_month_year(int production_month_year) {
        this.production_month_year = production_month_year;
    }
    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isActive() {
        return active;
    }
}
