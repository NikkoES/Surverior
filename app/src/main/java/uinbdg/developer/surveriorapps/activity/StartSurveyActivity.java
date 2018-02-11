package uinbdg.developer.surveriorapps.activity;

import android.app.ProgressDialog;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import uinbdg.developer.surveriorapps.R;
import uinbdg.developer.surveriorapps.adapter.QuestionAdapter;
import uinbdg.developer.surveriorapps.api.BaseApiService;
import uinbdg.developer.surveriorapps.api.UtilsApi;
import uinbdg.developer.surveriorapps.model.Question;
import uinbdg.developer.surveriorapps.model.ResponseQuestion;

public class StartSurveyActivity extends AppCompatActivity {

    private RecyclerView rvQuestion;
    private QuestionAdapter adapter;
    List<Question> listQuetion = new ArrayList<>();

    ProgressDialog loading;

    BaseApiService apiService;

    String idSurvey, bahasa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_survey);

        idSurvey = getIntent().getStringExtra("idSurvey");
        bahasa = getIntent().getStringExtra("bahasa");

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close_black_24px);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Start Survey");

        rvQuestion = (RecyclerView) findViewById(R.id.rv_question);

        apiService = UtilsApi.getAPIService();

        adapter = new QuestionAdapter(getApplicationContext(), listQuetion);

        rvQuestion.setHasFixedSize(true);
        rvQuestion.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rvQuestion.setAdapter(adapter);

        refresh();
    }

    public void refresh() {
        loading = ProgressDialog.show(StartSurveyActivity.this, null, "Harap Tunggu...", true, false);

        apiService.getListQuestion(idSurvey).enqueue(new Callback<ResponseQuestion>() {
            @Override
            public void onResponse(Call<ResponseQuestion> call, Response<ResponseQuestion> response) {
                if (response.isSuccessful()){
                    loading.dismiss();

                    listQuetion = response.body().getQuestionList();

                    rvQuestion.setAdapter(new QuestionAdapter(getApplicationContext(), listQuetion));
                    adapter.notifyDataSetChanged();
                } else {
                    loading.dismiss();
                    Toast.makeText(getApplicationContext(), "Gagal mengambil data dosen", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseQuestion> call, Throwable t) {
                loading.dismiss();
                Toast.makeText(getApplicationContext(), "Koneksi Internet Bermasalah", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
