package fr.assurance.controller.model;

/**
 * Created by Max on 09/05/2016.
 */
public class ListVehiculeModel {

    private String action;

    private Integer marque;

    private Integer modele;

    private Integer chevaux;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Integer getMarque() {
        return marque;
    }

    public void setMarque(Integer marque) {
        this.marque = marque;
    }

    public Integer getModele() {
        return modele;
    }

    public void setModele(Integer modele) {
        this.modele = modele;
    }

    public Integer getChevaux() {
        return chevaux;
    }

    public void setChevaux(Integer chevaux) {
        this.chevaux = chevaux;
    }
}
