package com.example.dllo.bibilala.tool.rx;


import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

public class TextOnSubscribe implements ObservableOnSubscribe<CharSequence> {
    private EditText mEditText;

    public TextOnSubscribe(EditText editText) {
        mEditText = editText;
    }


    @Override
    public void subscribe(final ObservableEmitter<CharSequence> e) throws Exception {
        TextWatcher mTextWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                e.onNext(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };
        mEditText.addTextChangedListener(mTextWatcher);
    }
}
