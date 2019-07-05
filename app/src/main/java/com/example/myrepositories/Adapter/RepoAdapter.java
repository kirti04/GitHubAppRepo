package com.example.myrepositories.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.myrepositories.Model.RepositoryResponse;
import com.example.myrepositories.Model.Owner;
import com.example.myrepositories.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.widget.Toast.makeText;

public class RepoAdapter extends RecyclerView.Adapter<RepoAdapter.RepoViewHolder> implements View.OnClickListener {

    private List<RepositoryResponse> repoList;
    private Context context;
    private Owner owner_array;
    Toast toast;



    public RepoAdapter(Context context,List<RepositoryResponse> repoList){
        this.context = context;
        this.repoList = repoList;
    }

    @Override
    public RepoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.repo_item_list,parent,false);
        return new RepoViewHolder(view);


    }

    @Override
    public void onBindViewHolder(RepoViewHolder holder, int position) {
        holder.text_name.setText(repoList.get(position).getName());
        holder.text_description.setText(repoList.get(position).getDescription());
        owner_array = repoList.get(position).getOwner();
        Glide.with(context)
                .load(owner_array.getAvatar_url())
                .into(holder.image_avtar);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toast.makeText(holder.itemView.getContext(),repoList.get(position).getName(),Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return repoList.size();
    }

    @Override
    public void onClick(View view) {

    }

    public class RepoViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.text_name)
        TextView text_name;
        @BindView(R.id.text_description)
        TextView text_description;
        @BindView(R.id.image_avtar)
        ImageView image_avtar;

        public RepoViewHolder( View v) {
            super(v);
            ButterKnife.bind(this, v);

        }
    }
}
