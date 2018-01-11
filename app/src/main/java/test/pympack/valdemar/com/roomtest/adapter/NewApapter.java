package test.pympack.valdemar.com.roomtest.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import test.pympack.valdemar.com.roomtest.R;
import test.pympack.valdemar.com.roomtest.model.News;
import test.pympack.valdemar.com.roomtest.model.Users;

/**
 * Created by CORAIMA on 11/01/2018.
 */

public class NewApapter extends RecyclerView.Adapter<NewApapter.ViewHolder>   {

    //private ArrayList<News> mDataArticles;
    //private ArrayList<String> mDataArticles;
    private List<Users> mDataArticles;
    //private ArrayList<Users> mDataArticles;
    private Context context;

   /* public NewApapter(Context context) {
      mDataArticles = new ArrayList<>();
      this.context = context;
    }*/

    public NewApapter(List<Users> mDataArticles) {
        this.mDataArticles = mDataArticles;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.design_item,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mDesign_item_title.setText(mDataArticles.get(position).getFirstName());

    }

    @Override
    public int getItemCount() {
        return mDataArticles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.design_item_title)
        TextView mDesign_item_title;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }


}
