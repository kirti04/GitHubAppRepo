package com.example.myrepositories.ViewModel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myrepositories.Model.RepositoryResponse;
import com.example.myrepositories.di.ApiModule;

import java.util.List;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class RepoViewModel extends ViewModel {


    private MutableLiveData<List<RepositoryResponse>> repoList;

    public LiveData<List<RepositoryResponse>> getRepoList() {
        if(repoList ==  null){
            repoList =  new MutableLiveData<List<RepositoryResponse>>();
            loadRepo();
        }
        return repoList;
    }

    private void loadRepo() {
        ApiModule apiModule = new ApiModule();
        apiModule.getClient().getRepos()
                 .subscribeOn(Schedulers.io())
                 .observeOn(AndroidSchedulers.mainThread())
                 .subscribeWith(new SingleObserver<List<RepositoryResponse>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d("in subs", d.toString());
                    }

                    @Override
                    public void onSuccess(List<RepositoryResponse> repositoryResponses) {

                        repoList.setValue(repositoryResponses);
                        Log.d("value",repoList.getValue().toString());


                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("in error", "hi");
                    }
                });





    }
}
