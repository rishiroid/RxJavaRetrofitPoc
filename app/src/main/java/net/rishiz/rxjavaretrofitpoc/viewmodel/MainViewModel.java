package net.rishiz.rxjavaretrofitpoc.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import net.rishiz.rxjavaretrofitpoc.ApiInterface;
import net.rishiz.rxjavaretrofitpoc.RetrofitClient;
import net.rishiz.rxjavaretrofitpoc.model.ResponseDTO;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.observers.DisposableObserver;
import io.reactivex.rxjava3.schedulers.Schedulers;


public class MainViewModel extends ViewModel {
    private final String TAG = MainViewModel.class.getName();
    public ApiInterface api;
    public MutableLiveData<ResponseDTO> responseData = new MutableLiveData<>();
    public MutableLiveData<String> apis = new MutableLiveData<>();
    public MutableLiveData<Boolean> isLoading = new MutableLiveData<>(true);
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();

    public MainViewModel() {
        api = RetrofitClient.getRetrofitInstance();
        fetchData();
    }

    public void fetchData() {
        Log.d(TAG, "fetchData");
        isLoading.postValue(false);
        compositeDisposable.add(
                api.getEntries()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableObserver<ResponseDTO>() {
                            @Override
                            public void onNext(@NonNull ResponseDTO responseDTO) {
                                responseData.postValue(responseDTO);
                                Log.d(TAG, "onNext" + responseDTO.getEntries());
                            }

                            @Override
                            public void onError(@NonNull Throwable e) {
                                Log.d(TAG, "Error:" + e);
                            }

                            @Override
                            public void onComplete() {
                                Log.d(TAG, "onComplete");

                            }
                        })
        );

    }

    public MutableLiveData<ResponseDTO> getData() {
        return responseData;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        //resources are cleared to prevent memory leaks
        compositeDisposable.clear();
    }
}
