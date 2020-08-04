package com.opannapo.mvvmexample.views.activities.splash;

import androidx.lifecycle.MutableLiveData;

import com.opannapo.core.layer.application.presenter.view.BaseViewModel;
import com.opannapo.mvvmexample.entities.User;
import com.opannapo.mvvmexample.usecases.splash.SplashUseCase;
import com.opannapo.mvvmexample.usecases.splash.SplashUseCaseImpl;

/**
 * Created by napouser on 04,August,2020
 */
public class SplashVM extends BaseViewModel<SplashUseCaseImpl> implements SplashUseCase.View {
    protected MutableLiveData<Integer> liveLoadingState = new MutableLiveData<>(); //1 loading
    protected MutableLiveData<String> liveLoadingMessage = new MutableLiveData<>(); //1 loading
    protected MutableLiveData<User> liveUser = new MutableLiveData<>();

    @Override
    protected SplashUseCaseImpl initUseCase() {
        return new SplashUseCaseImpl(this);
    }

    @Override
    public void getUser(String val) {
        useCase.doGetUser(val);
    }

    @Override
    public void onProcessing(String msg) {
        liveLoadingState.postValue(1);//Is Loading
        liveLoadingMessage.postValue(msg);
    }

    @Override
    public void onUserResult(User val) {
        liveLoadingState.postValue(0);//Is Completed
        liveUser.postValue(val);
    }
}