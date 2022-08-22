package com.anhntn45.dogsapp.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.anhntn45.dogsapp.model.Dog;
import com.anhntn45.dogsapp.model.DogsApiService;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class ListViewModel extends AndroidViewModel {
    public MutableLiveData<List<Dog>> dogsList = new MutableLiveData<List<Dog>>();
    public MutableLiveData<Boolean> dogLoadError = new MutableLiveData<Boolean>();
    public MutableLiveData<Boolean> loading = new MutableLiveData<Boolean>();

    public ListViewModel(@NonNull Application application) {
        super(application);
    }

    private DogsApiService dogsApiService = new DogsApiService();
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    public void refresh() {
//        Dog corgi = new Dog("1", "corgi", "100", "fbi", "a", "kind", "");
//        Dog pitbull = new Dog("2", "pitbull", "120", "who", "b", "pretty", "");
//        List<Dog> dogs = new ArrayList<>();
//        dogs.add(corgi);
//        dogs.add(pitbull);
//
//        dogsList.setValue(dogs);
//        dogLoadError.setValue(false);
//        loading.setValue(false);

        fetchFromRemote();
    }

    private void fetchFromRemote() {
        loading.setValue(true);
        compositeDisposable.add(
                dogsApiService.getDogsApi()
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableSingleObserver<List<Dog>>() {
                            @Override
                            public void onSuccess(List<Dog> dogs) {
                                dogsList.setValue(dogs);
                                dogLoadError.setValue(false);
                                loading.setValue(false);
                                Log.d("ListViewModel", "onSuccess: ");
                            }

                            @Override
                            public void onError(Throwable e) {
                                dogLoadError.setValue(true);
                                loading.setValue(false);
                                e.printStackTrace();
                                Log.d("ListViewModel", "onError: ");
                            }
                        }));

    }

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.clear();
    }
}
