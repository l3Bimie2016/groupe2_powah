package fr.assurance.controller.model;

import fr.assurance.entities.VehiculeQuote;

/**
 * Created by Max on 10/05/2016.
 */
public class VehSummaryMod {

    private String brand;
    private String model;
    private String fiscal_horse_power;
    private String type_fuel;
    private Integer bonus_malus;
    private String second_driver;
    private Boolean in_garage;
    private String garage_address;
    private String contract_type;
    private Float total_price;

    public VehSummaryMod(VehiculeQuote vq){
        this.brand = vq.getBrand();
        this.model = vq.getModel();
        this.fiscal_horse_power = vq.getFiscal_horse_power();
        this.type_fuel = vq.getType_fuel();
        this.bonus_malus = vq.getBonus_malus();
        this.second_driver = vq.getSecond_driver();
        this.in_garage = vq.getIn_garage();
        this.garage_address = vq.getGarage_address();
        this.contract_type = vq.getContract_type();
        this.total_price = vq.getTotal_price();
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getFiscal_horse_power() {
        return fiscal_horse_power;
    }

    public void setFiscal_horse_power(String fiscal_horse_power) {
        this.fiscal_horse_power = fiscal_horse_power;
    }

    public String getType_fuel() {
        return type_fuel;
    }

    public void setType_fuel(String type_fuel) {
        this.type_fuel = type_fuel;
    }

    public Integer getBonus_malus() {
        return bonus_malus;
    }

    public void setBonus_malus(Integer bonus_malus) {
        this.bonus_malus = bonus_malus;
    }

    public String getSecond_driver() {
        return second_driver;
    }

    public void setSecond_driver(String second_driver) {
        this.second_driver = second_driver;
    }

    public Boolean getIn_garage() {
        return in_garage;
    }

    public void setIn_garage(Boolean in_garage) {
        this.in_garage = in_garage;
    }

    public String getGarage_address() {
        return garage_address;
    }

    public void setGarage_address(String garage_address) {
        this.garage_address = garage_address;
    }

    public String getContract_type() {
        return contract_type;
    }

    public void setContract_type(String contract_type) {
        this.contract_type = contract_type;
    }

    public Float getTotal_price() {
        return total_price;
    }

    public void setTotal_price(Float total_price) {
        this.total_price = total_price;
    }
}
