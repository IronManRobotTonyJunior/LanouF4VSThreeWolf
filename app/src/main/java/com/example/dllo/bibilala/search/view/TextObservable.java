package com.example.dllo.bibilala.search.view;


import android.widget.EditText;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

public class TextObservable {
    public static Observable<CharSequence> create(EditText editText, int delayTime) {
        return Observable.create(new TextOnSubscribe(editText))
                .debounce(delayTime, TimeUnit.MILLISECONDS);
    }
}
