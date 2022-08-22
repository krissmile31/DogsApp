package com.anhntn45.dogsapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.anhntn45.dogsapp.model.Dog;

public class DetailViewModel extends AndroidViewModel {
    public MutableLiveData<Dog> dog = new MutableLiveData<Dog>();

    public DetailViewModel(@NonNull Application application) {
        super(application);
    }

    public void fetch() {
        Dog husky = new Dog("123", "Husky", "1000 years", "anything", "anything", "naive", "");
        dog.setValue(husky);
    }
}
