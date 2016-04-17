package com.bogdan.stolyarov.irregularverbs.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by bogdan on 14.03.2016.
 */
public class Verb implements Parcelable {
    private int id;
    private String translate;
    private String infinitive;
    private String secondForm;
    private String thirdForm;
    private boolean isTrain;

    public Verb(){

    }

    public Verb(String translate, String infinitive, String secondForm, String thirdForm, boolean isTrain){
        setTranslate(translate);
        setInfinitive(infinitive);
        setSecondForm(secondForm);
        setThirdForm(thirdForm);
        setIsTrain(isTrain);
    }

    public static final Parcelable.Creator<Verb> CREATOR
            = new Parcelable.Creator<Verb>() {
        public Verb createFromParcel(Parcel in) {
            return new Verb(in);
        }

        public Verb[] newArray(int size) {
            return new Verb[size];
        }
    };

    private Verb(Parcel in) {
        translate = in.readString();
        infinitive = in.readString();
        secondForm = in.readString();
        thirdForm = in.readString();
        isTrain = in.readByte() != 0; //isTrain == true if byte != 0
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(translate);
        parcel.writeString(infinitive);
        parcel.writeString(secondForm);
        parcel.writeString(thirdForm);
        parcel.writeByte((byte) (isTrain ? 1 : 0)); //if myBoolean == true, byte == 1
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTranslate() {
        return translate;
    }

    public void setTranslate(String translate) {
        this.translate = translate;
    }

    public String getInfinitive() {
        return infinitive;
    }

    public void setInfinitive(String infinitive) {
        this.infinitive = infinitive;
    }

    public String getSecondForm() {
        return secondForm;
    }

    public void setSecondForm(String secondForm) {
        this.secondForm = secondForm;
    }

    public String getThirdForm() {
        return thirdForm;
    }

    public void setThirdForm(String thirdForm) {
        this.thirdForm = thirdForm;
    }

    public boolean isTrain() {
        return isTrain;
    }

    public void setIsTrain(boolean isTrain) {
        this.isTrain = isTrain;
    }
}
