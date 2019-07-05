package com.example.myrepositories.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.idling.CountingIdlingResource;

import android.os.Bundle;
import com.example.myrepositories.Adapter.RepoAdapter;
import com.example.myrepositories.Model.RepositoryResponse;
import com.example.myrepositories.R;
import com.example.myrepositories.ViewModel.RepoViewModel;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity {
    @BindView(R.id.repoList)
    RecyclerView recyclerView;

    RepoAdapter repoAdapter;
    List<RepositoryResponse> repoList;
    RepoViewModel repoViewModel;

    public CountingIdlingResource countingIdlingResource =  new CountingIdlingResource("DATA_LOADER");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        repoViewModel = ViewModelProviders.of(this).get(RepoViewModel.class);
        countingIdlingResource.increment();
        repoViewModel.getRepoList().observe(MainActivity.this, new Observer<List<RepositoryResponse>>() {

            @Override
            public void onChanged(List<RepositoryResponse> repoList) {
                recyclerView.setAdapter(new RepoAdapter(MainActivity.this,repoList));
                countingIdlingResource.decrement();
            }
        });

    }

}
