package com.example.fragmentsproject;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void first_but_clicked(View view) {


        FirstFragment firstF = new FirstFragment();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.first_second_container,firstF);
        transaction.commit();

    }

    public void second_but_clicked(View view) {
        SecondFragment secondF = new SecondFragment();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.first_second_container,secondF);
        transaction.commit();

    }

    public void add_remove_clicked(View view) {

        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();

        ThirdFragment thirdF = (ThirdFragment)fm.findFragmentById(R.id.container);
        if (thirdF == null){

            ThirdFragment thirdFragment = new ThirdFragment();
            transaction.add(R.id.container,thirdFragment);
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        }
        else {

            transaction.remove(thirdF);
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE);

        }
        transaction.commit();


    }

    public void dialgo_fragment_clicked(View view) {

        FragmentTransaction ft = getFragmentManager().beginTransaction();

        DialogFragmentClass hdf = DialogFragmentClass.newInstance(R.string.helpResId);

        hdf.show(ft,"tag");

    }
}
