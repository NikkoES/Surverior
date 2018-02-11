package uinbdg.developer.surveriorapps.activity;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import uinbdg.developer.surveriorapps.R;
import uinbdg.developer.surveriorapps.model.Question;
import uinbdg.developer.surveriorapps.utils.HttpConnect;

public class TranslateActivity extends AppCompatActivity {

    String textTranslate = "I Love You";

    List<Question> listQuetion = new ArrayList<>();

    TextView hasilTranslate;
    Button btnTranslate;

    private ProgressDialog pDialog;

    String fromLang = "en";
    String toLang = "id";

    SharedPreferences sPref;

    private static final String translate_url = "https://translate.yandex.net/api/v1.5/tr.json/translate?" +
            "key=trnsl.1.1.20170328T130616Z.db8d44a9ee78ae87.f53e476dd73cc810eafbacdc09806bff840116b1" +
            "&lang=" +
            "{FROM}" +
            "-" +
            "{TO}" +
            "&text="
            + "{text}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translate);

        hasilTranslate = findViewById(R.id.hasil_translate);
        btnTranslate = findViewById(R.id.btn_translate);

        btnTranslate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new GetTask().execute();
            }
        });

    }

    private class GetTask extends AsyncTask<Void, Void, String> {
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(TranslateActivity.this);
            pDialog.setMessage("Wait...");
            pDialog.setCancelable(false);
            pDialog.show();
        }

        protected String doInBackground(Void... params) {
            HttpConnect httpConnect = new HttpConnect();
            String reqURL = translateText(textTranslate);
            String resultJson = httpConnect.makeHttpCall(reqURL);
            return resultJson;
        }

        private String translateText(String textTranslate) {
            sPref = getPreferences(MODE_PRIVATE);
            String from = getFromLang();
            String to = getToLang();

            String text = translate_url
                    .replace("{text}", textTranslate)
                    .replace("{FROM}", from)
                    .replace("{TO}", to);
            return text;
        }

        protected void onPostExecute(String str) {
            super.onPostExecute(str);
            if (pDialog.isShowing())
                pDialog.dismiss();;
            String text = null;
            try {
                JSONObject jsonObj = new JSONObject(str);
                JSONArray jsonArray = jsonObj.getJSONArray("text");
                String translate = jsonArray.toString();
                text = replaceChar(translate);

            } catch (final JSONException e) {
                e.printStackTrace();
            }

            hasilTranslate.setText(text);

        }
    }

    public void setToLang(String toLang) {
        this.toLang = toLang;
    }

    public String getToLang() {
        return toLang;
    }

    public void setFromLang(String fromLang) {

        this.fromLang = fromLang;
    }

    public String getFromLang() {
        return fromLang;
    }


    private String replaceChar(String translater) {
        String charReplacer = translater;
        charReplacer = charReplacer.replace(']', ' ').replace('[', ' ').replace('"', ' ');
        return charReplacer;
    }
}
