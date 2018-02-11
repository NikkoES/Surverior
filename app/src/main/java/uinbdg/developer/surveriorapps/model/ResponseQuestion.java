package uinbdg.developer.surveriorapps.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Nikko Eka Saputra on 11/02/2018.
 */

public class ResponseQuestion {

    @SerializedName("data")
    private List<Question> questionList;

    @SerializedName("status")
    private String status;

    public void setQuestionList(List<Question> questionList){
        this.questionList = questionList;
    }

    public List<Question> getQuestionList(){
        return questionList;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public String getStatus(){
        return status;
    }

}
