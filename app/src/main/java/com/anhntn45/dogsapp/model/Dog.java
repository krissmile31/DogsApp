package com.anhntn45.dogsapp.model;

import com.google.gson.annotations.SerializedName;

public class Dog {
    @SerializedName("id")
    public String breedId;
    @SerializedName("name")
    public String dogBreed;
    @SerializedName("life_span")
    public String lifeSpan;
    @SerializedName("bred_for")
    public String bredFor;
    @SerializedName("bred_group")
    public String breedGroup;
//    @SerializedName("temperament")
    public String temperament;
    @SerializedName("url")
    public String imageUrl;
    public int uuid;

    public Dog(String breedId, String dogBreed, String lifeSpan, String bredFor, String breedGroup, String temperament, String imageUrl) {
        this.breedId = breedId;
        this.dogBreed = dogBreed;
        this.lifeSpan = lifeSpan;
        this.bredFor = bredFor;
        this.breedGroup = breedGroup;
        this.temperament = temperament;
        this.imageUrl = imageUrl;
    }
}
