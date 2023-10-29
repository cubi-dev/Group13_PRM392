package com.example.group9.model;

public class Foods {
    private  int idFoods;
    private String nameFoods;
    private String detailsFoods;
    private int imageFoods;
    private int quantityFoods;
    private double priceFoods;

    public Foods(int idFoods, String nameFoods, String detailsFoods, int imageFoods, int quantityFoods, double priceFoods) {
        this.idFoods = idFoods;
        this.nameFoods = nameFoods;
        this.detailsFoods = detailsFoods;
        this.imageFoods = imageFoods;
        this.quantityFoods = quantityFoods;
        this.priceFoods = priceFoods;
    }

    public int getIdFoods() {
        return idFoods;
    }

    public void setIdFoods(int idFoods) {
        this.idFoods = idFoods;
    }

    public String getNameFoods() {
        return nameFoods;
    }

    public void setNameFoods(String nameFoods) {
        this.nameFoods = nameFoods;
    }

    public String getDetailsFoods() {
        return detailsFoods;
    }

    public void setDetailsFoods(String detailsFoods) {
        this.detailsFoods = detailsFoods;
    }

    public int getImageFoods() {
        return imageFoods;
    }

    public void setImageFoods(int imageFoods) {
        this.imageFoods = imageFoods;
    }

    public int getQuantityFoods() {
        return quantityFoods;
    }

    public void setQuantityFoods(int quantityFoods) {
        this.quantityFoods = quantityFoods;
    }

    public double getPriceFoods() {
        return priceFoods;
    }

    public void setPriceFoods(double priceFoods) {
        this.priceFoods = priceFoods;
    }
}
