package uinbdg.developer.surveriorapps.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Nikko Eka Saputra on 10/02/2018.
 */

public class Survey {

    @SerializedName("id_survey")
    String idSurvey;
    @SerializedName("nama_survey")
    String namaSurvey;
    @SerializedName("created_at")
    String createdAt;
    @SerializedName("modified_at")
    String modifiedAt;

    public String getIdSurvey() {
        return idSurvey;
    }

    public void setIdSurvey(String idSurvey) {
        this.idSurvey = idSurvey;
    }

    public String getNamaSurvey() {
        return namaSurvey;
    }

    public void setNamaSurvey(String namaSurvey) {
        this.namaSurvey = namaSurvey;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(String modifiedAt) {
        this.modifiedAt = modifiedAt;
    }
}
