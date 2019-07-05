package com.example.myrepositories.ViewModel;

import android.database.Observable;

import com.example.myrepositories.Model.RepositoryResponse;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("repos")
    Single<List<RepositoryResponse>> getRepos();

}
