package uinbdg.developer.surveriorapps.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import uinbdg.developer.surveriorapps.R;
import uinbdg.developer.surveriorapps.model.Question;

/**
 * Created by Nikko Eka Saputra on 11/02/2018.
 */

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.ViewHolder> {

    private Context context;
    private List<Question> listQueston;

    public QuestionAdapter(Context context, List<Question> listQueston){
        this.context = context;
        this.listQueston = listQueston;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_question, null, false);

        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        v.setLayoutParams(layoutParams);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Question question = listQueston.get(position);
        holder.lblNomor.setText("no. "+(position+1));
        holder.lblQuestion.setText(question.getQuestion());
        if(question.getTipeQuestion().equalsIgnoreCase("multiple")){
            holder.etAnswer.setVisibility(View.GONE);
            holder.rgOpsi.setVisibility(View.VISIBLE);
            holder.lblOpsiSatu.setText("Opsi 1 : "+question.getOptionSatu());
            holder.lblOpsiDua.setText("Opsi 2 : "+question.getOptionDua());
            holder.lblOpsiTiga.setText("Opsi 3 : "+question.getOptionTiga());
            holder.lblOpsiEmpat.setText("Opsi 4 : "+question.getOptionEmpat());
        }
        else{
            holder.rgOpsi.setVisibility(View.GONE);
            holder.etAnswer.setVisibility(View.VISIBLE);
        }
        holder.lblTipe.setText(question.getTipeQuestion());
    }

    @Override
    public int getItemCount() {
        return listQueston.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView lblNomor, lblQuestion, lblTipe;

        private RadioGroup rgOpsi;
        private EditText etAnswer;
        private RadioButton lblOpsiSatu, lblOpsiDua, lblOpsiTiga, lblOpsiEmpat;

        public ViewHolder(View itemView) {
            super(itemView);

            lblNomor = (TextView) itemView.findViewById(R.id.tv_nomor);
            lblQuestion = (TextView) itemView.findViewById(R.id.tv_question);
            lblTipe = (TextView) itemView.findViewById(R.id.tv_tipe_question);

            rgOpsi = (RadioGroup) itemView.findViewById(R.id.rg_option);
            etAnswer = (EditText) itemView.findViewById(R.id.et_answer);

            lblOpsiSatu = (RadioButton) itemView.findViewById(R.id.tv_opsi_1);
            lblOpsiDua = (RadioButton) itemView.findViewById(R.id.tv_opsi_2);
            lblOpsiTiga = (RadioButton) itemView.findViewById(R.id.tv_opsi_3);
            lblOpsiEmpat = (RadioButton) itemView.findViewById(R.id.tv_opsi_4);
        }
    }
}