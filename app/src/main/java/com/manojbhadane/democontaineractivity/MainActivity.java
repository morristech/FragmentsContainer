package com.manojbhadane.democontaineractivity;

import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.view.View;

import com.manojbhadane.democontaineractivity.base.BaseActivity;
import com.manojbhadane.democontaineractivity.base.Constant;
import com.manojbhadane.democontaineractivity.container.ContainerModel;
import com.manojbhadane.democontaineractivity.databinding.ActivityMainBinding;
import com.manojbhadane.democontaineractivity.model.Test;

public class MainActivity extends BaseActivity {

    private ActivityMainBinding mDataBinding;

    @Override
    public int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    public void init(ViewDataBinding dataBinding) {

        mDataBinding = (ActivityMainBinding) dataBinding;

        /**
         *  Usage 1
         */
        mDataBinding.btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              Bundle bundle = new Bundle();
              bundle.putParcelable("key_bundle", getModel());
              bundle.putString("key_name", "ManojBhadane");

                new ContainerModel()
                        .setTitle("Fragment 1")
                        .setFragmentNumber(Constant.FRAGMENT_1)
                        .setBundle(bundle)
                        .setShowToolbar(false)
                        .setShowToolbarBackBtn(false)
                        .startActivity(MainActivity.this);
            }
        });

        /**
         *  Usage 2
         */
        mDataBinding.btn22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new ContainerModel()
                        .setFragmentNumber(Constant.FRAGMENT_2)
                        .setTitle("Fragment 2")
                        .startActivity(MainActivity.this);

            }
        });

        /**
         *  Usage 3
         */
        mDataBinding.btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new ContainerModel()
                        .setTitle("Fragment 3")
                        .setFragmentNumber(Constant.FRAGMENT_3)
                        .setBundle(new Bundle())
                        .startActivity(MainActivity.this);

            }
        });
    }


    private Test getModel() {
        Test t = new Test();
        t.setName("Manoj");
        return t;
    }
}
