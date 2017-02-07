package com.hwjoo.rxandroidsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.jakewharton.rxbinding.view.RxView;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observable;
import rx.Observer;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;

import static android.R.attr.right;
import static android.R.attr.text;
import static android.R.attr.value;
import static android.R.id.empty;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.editText)
    EditText editText;
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
        A a = new A();
        a.setName("Joo, hyunwoo");
        a.setAge(29);
        Observable<A> simpleObservable = Observable.just(a);
//        Observable<String> simpleObservable = Observable.just("a");
        Observer<A> observer = new Observer<A>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(A a) {

            }
        };
        Subscriber<A> subscriber = new Subscriber<A>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(A a) {

            }
        };
        Subscription subscription = new Subscription() {
            @Override
            public void unsubscribe() {

            }

            @Override
            public boolean isUnsubscribed() {
                return false;
            }
        };

        simpleObservable.observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        o-> {
                            textView.setText("name :" + o.getName() + "\n" + "age :" + o.getAge());
                        },
                        e->textView.setText(e.getMessage())

                );





    }
    class A {
        String name;
        int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

}
