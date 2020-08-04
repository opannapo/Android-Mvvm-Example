package com.opannapo.mvvmexample.views.activities.main;

import androidx.lifecycle.MutableLiveData;

import com.opannapo.core.layer.application.presenter.view.BaseViewModel;
import com.opannapo.mvvmexample.entities.User;
import com.opannapo.mvvmexample.usecases.main.MainUseCase;
import com.opannapo.mvvmexample.usecases.main.MainUseCaseImpl;

/**
 * Created by napouser on 04,August,2020
 */
public class MainVM extends BaseViewModel<MainUseCaseImpl> implements MainUseCase.View {
    protected MutableLiveData<Integer> liveLoadingState = new MutableLiveData<>(); //1 loading
    protected MutableLiveData<User> liveUser = new MutableLiveData<>();//

    @Override
    protected MainUseCaseImpl initUseCase() {
        return new MainUseCaseImpl(this);
    }

    @Override
    public void getUser(String val) {
        useCase.doGetUser(val);
    }

    @Override
    public void onProcessing() {
        liveLoadingState.postValue(1);//Is Loading
    }

    @Override
    public void onUserResult(User val) {
        liveLoadingState.postValue(0);//Is Completed
        liveUser.postValue(val);
    }
}
