package com.bogdan.stolyarov.irregularverbs.model;

/**
 * Created by bogdan on 14.03.2016.
 */
public class Verb {
    private int id;
    private String translate;
    private String infinitive;
    private String secondForm;
    private String thirdForm;
    private boolean isTrain;

    public Verb(String translate, String infinitive, String secondForm, String thirdForm, boolean isTrain){
        setTranslate(translate);
        setInfinitive(infinitive);
        setSecondForm(secondForm);
        setThirdForm(thirdForm);
        setIsTrain(isTrain);
    }

    public Verb(){

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
