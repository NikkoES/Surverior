package uinbdg.developer.surveriorapps.fragment;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import uinbdg.developer.surveriorapps.R;
import uinbdg.developer.surveriorapps.adapter.HomeAdapter;
import uinbdg.developer.surveriorapps.api.BaseApiService;
import uinbdg.developer.surveriorapps.api.UtilsApi;
import uinbdg.developer.surveriorapps.model.ResponseSurvey;
import uinbdg.developer.surveriorapps.model.Survey;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private RecyclerView rvHome;
    private HomeAdapter adapter;
    List<Survey> listSurvey = new ArrayList<>();

    ProgressDialog loading;

    BaseApiService apiService;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        rvHome = (RecyclerView) view.findViewById(R.id.rv_home);

        adapter = new HomeAdapter(getContext(), listSurvey);

        apiService = UtilsApi.getAPIService();

        rvHome.setHasFixedSize(true);
        rvHome.setLayoutManager(new LinearLayoutManager(getContext()));
        rvHome.setAdapter(adapter);

        refresh();

        return view;
    }

    public void refresh() {
        loading = ProgressDialog.show(getContext(), null, "Harap Tunggu...", true, false);

        apiService.getListSurvey().enqueue(new Callback<ResponseSurvey>() {
            @Override
            public void onResponse(Call<ResponseSurvey> call, Response<ResponseSurvey> response) {
                if (response.isSuccessful()){
                    loading.dismiss();

                    listSurvey = response.body().getSurveyList();

                    rvHome.setAdapter(new HomeAdapter(getContext(), listSurvey));
                    adapter.notifyDataSetChanged();
                } else {
                    loading.dismiss();
                    Toast.makeText(getContext(), "Gagal mengambil data dosen", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseSurvey> call, Throwable t) {
                loading.dismiss();
                Toast.makeText(getContext(), "Koneksi Internet Bermasalah", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
