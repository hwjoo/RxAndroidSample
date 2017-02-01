package com.hwjoo.rxandroidsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.jakewharton.rxbinding.view.RxView;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observable;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;

import static android.R.attr.right;
import static android.R.attr.text;
import static android.R.attr.value;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.btn)
    Button btn;
    @BindView(R.id.btn1)
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

//        Observable<String> simpleObservable = Observable.just("Hello Lambda!!");
//        simpleObservable.map(text->text.length())
//                .subscribe(length->textView.setText("length: "+length));
//
//        RxView.clicks(btn).map(event->new Random().nextInt())
//                .subscribe(value->{
//                    textView.setText("number:" + value.toString());
//                },throwable -> {
//                    Log.d("TEST","Error : "+ throwable.getMessage());
//                    throwable.printStackTrace();
//                });
        Observable<String> lefts = RxView.clicks(btn)
                .map(event->"left");
        Observable<String> rights = RxView.clicks(btn1)
                .map(event->"right");
        Observable<String> together = Observable.merge(lefts, rights);
        together.subscribe(text->textView.setText(text));
        together.map(text-> text.toUpperCase())
                .subscribe(text-> Toast.makeText(this, text, Toast.LENGTH_SHORT).show());

//        Observable<String> simpleObservable =
//                Observable.create(new Observable.OnSubscribe<String>() {
//                    @Override
//                    public void call(Subscriber<? super String> subscriber) {
//                        subscriber.onNext("Hellow RxAndroid !!");
//                        subscriber.onCompleted();
//                    }
//                });
//        simpleObservable.map(new Func1<String, Integer>() {
//            @Override
//            public Integer call(String s) {
//                return s.length();
//            }
//        }).subscribe(new Action1<Integer>() {
//            @Override
//            public void call(Integer s) {
//                textView.setText("length : " + s);
//            }
//        }, new Action1<Throwable>() {
//            @Override
//            public void call(Throwable throwable) {
//                Log.d("TEST",throwable.toString());
//            }
//        }, new Action0() {
//            @Override
//            public void call() {
//
//            }
//        });



    }
}
