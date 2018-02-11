package uinbdg.developer.surveriorapps.api;

/**
 * Created by Nikko Eka Saputra on 11/02/2018.
 */

public class UtilsApi {

    // 10.0.2.2 ini adalah localhost.
    public static final String BASE_URL_API = "http://10.0.2.2/survey/public/";

    // Mendeklarasikan Interface BaseApiService
    public static BaseApiService getAPIService(){
        return RetrofitClient.getClient(BASE_URL_API).create(BaseApiService.class);
    }

}
