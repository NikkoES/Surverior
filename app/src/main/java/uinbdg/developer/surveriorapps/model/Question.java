package uinbdg.developer.surveriorapps.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Nikko Eka Saputra on 10/02/2018.
 */

public class Question {
    @SerializedName("id_question")
    String idQuestion;
    @SerializedName("tipe_question")
    String tipeQuestion;
    @SerializedName("question")
    String question;
    @SerializedName("option_1")
    String optionSatu;
    @SerializedName("option_2")
    String optionDua;
    @SerializedName("option_3")
    String optionTiga;
    @SerializedName("option_4")
    String optionEmpat;
    @SerializedName("id_survey")
    String idSurvey;

    public String getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(String idQuestion) {
        this.idQuestion = idQuestion;
    }

    public String getTipeQuestion() {
        return tipeQuestion;
    }

    public void setTipeQuestion(String tipeQuestion) {
        this.tipeQuestion = tipeQuestion;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOptionSatu() {
        return optionSatu;
    }

    public void setOptionSatu(String optionSatu) {
        this.optionSatu = optionSatu;
    }

    public String getOptionDua() {
        return optionDua;
    }

    public void setOptionDua(String optionDua) {
        this.optionDua = optionDua;
    }

    public String getOptionTiga() {
        return optionTiga;
    }

    public void setOptionTiga(String optionTiga) {
        this.optionTiga = optionTiga;
    }

    public String getOptionEmpat() {
        return optionEmpat;
    }

    public void setOptionEmpat(String optionEmpat) {
        this.optionEmpat = optionEmpat;
    }

    public String getIdSurvey() {
        return idSurvey;
    }

    public void setIdSurvey(String idSurvey) {
        this.idSurvey = idSurvey;
    }
}