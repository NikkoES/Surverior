package uinbdg.developer.surveriorapps.api;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import uinbdg.developer.surveriorapps.model.ResponseQuestion;
import uinbdg.developer.surveriorapps.model.ResponseSurvey;

/**
 * Created by Nikko Eka Saputra on 11/02/2018.
 */

public interface BaseApiService {

    @GET("survey/")
    Call<ResponseSurvey> getListSurvey();

    @GET("question/{idsurvey}")
    Call<ResponseQuestion> getListQuestion(@Path("idsurvey") String idSurvey);

//    @FormUrlEncoded
//    @POST("survey/")
//    Call<ResponseBody> createSurvey(@Field("nama_survey") String namaSurvey);
//
//    @FormUrlEncoded
//    @POST("question/")
//    Call<ResponseBody> addQuestion(@Field("tipe_question") String tipeQuestion,
//                                   @Field("question") String question,
//                                   @Field("option_1") String optionSatu,
//                                   @Field("option_2") String optionDua,
//                                   @Field("option_3") String optionTiga,
//                                   @Field("option_4") String optionEmpat,
//                                   @Field("id_survey") String idSurvey);

//    @GET("matkul")
//    Call<ResponseMatkul> getSemuaMatkul();
//
//    @FormUrlEncoded
//    @POST("matkul")
//    Call<ResponseBody> simpanMatkulRequest(@Field("nama_dosen") String namadosen,
//                                           @Field("matkul") String namamatkul);
//
//    @DELETE("matkul/{idmatkul}")
//    Call<ResponseBody> deteleMatkul(@Path("idmatkul") String idmatkul);

}
