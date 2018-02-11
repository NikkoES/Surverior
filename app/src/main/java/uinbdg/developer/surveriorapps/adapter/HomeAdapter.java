package uinbdg.developer.surveriorapps.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import uinbdg.developer.surveriorapps.R;
import uinbdg.developer.surveriorapps.activity.StartSurveyActivity;
import uinbdg.developer.surveriorapps.model.Survey;

/**
 * Created by Nikko Eka Saputra on 10/02/2018.
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {

    private Context context;
    private List<Survey> listActiveSurvey;

    public HomeAdapter(Context context, List<Survey> listActiveSurvey){
        this.context = context;
        this.listActiveSurvey = listActiveSurvey;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_home, null, false);

        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        v.setLayoutParams(layoutParams);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Survey activeSurvey = listActiveSurvey.get(position);
        holder.lblNamaSurvey.setText(activeSurvey.getNamaSurvey());
        holder.lblDateCreated.setText(activeSurvey.getCreatedAt());
        holder.lblActiveSurvey.setText("available survey");
        holder.lblCreated.setText("Created At");

        holder.cvHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final CharSequence[] dialogitem = {"Bahasa Inggris", "Bahasa Indonesia"};
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Pilihan");
                builder.setItems(dialogitem, new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int item){
                        switch(item){
                            case 0 : {
                                Intent i = new Intent(context, StartSurveyActivity.class);
                                i.putExtra("idSurvey", activeSurvey.getIdSurvey().toString());
                                i.putExtra("bahasa", "en");
                                context.startActivity(i);
                                break;
                            }
                            case 1 : {
                                Intent i = new Intent(context, StartSurveyActivity.class);
                                i.putExtra("idSurvey", activeSurvey.getIdSurvey().toString());
                                i.putExtra("bahasa", "id");
                                context.startActivity(i);
                                break;
                            }
                        }
                    }
                });
                builder.create().show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listActiveSurvey.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private CardView cvHome;
        private TextView lblActiveSurvey, lblCreated;
        private TextView lblNamaSurvey, lblDateCreated;

        public ViewHolder(View itemView) {
            super(itemView);

            cvHome = (CardView) itemView.findViewById(R.id.cv_home);
            lblNamaSurvey = (TextView) itemView.findViewById(R.id.tv_nama_survey);
            lblDateCreated = (TextView) itemView.findViewById(R.id.tv_date);
            lblActiveSurvey = (TextView) itemView.findViewById(R.id.tv_active_survey);
            lblCreated = (TextView) itemView.findViewById(R.id.tv_created_at);
        }
    }
}
