package uinbdg.developer.surveriorapps.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Nikko Eka Saputra on 11/02/2018.
 */

public class ResponseSurvey {

    @SerializedName("data")
    private List<Survey> surveyList;

    @SerializedName("status")
    private String status;

    public void setSurveyList(List<Survey> surveyList){
        this.surveyList = surveyList;
    }

    public List<Survey> getSurveyList(){
        return surveyList;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public String getStatus(){
        return status;
    }

}
