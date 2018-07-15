package com.manojbhadane.democontaineractivity.fragments;

import android.databinding.ViewDataBinding;
import android.os.Bundle;

import com.manojbhadane.democontaineractivity.R;
import com.manojbhadane.democontaineractivity.base.BaseFragment;
import com.manojbhadane.democontaineractivity.databinding.Fragment1Binding;
import com.manojbhadane.democontaineractivity.model.Test;

public class Fragment1 extends BaseFragment {

    private static Fragment1 mInstance;
    private Test mModel;
    private Fragment1Binding mDataBinding;

    public static Fragment1 getFragment() {
        if (mInstance == null)
            mInstance = new Fragment1();
        return mInstance;
    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_1;
    }

    @Override
    public void init(ViewDataBinding dataBinding) {

        mDataBinding = (Fragment1Binding) dataBinding;

        Bundle bundle = this.getArguments();

        Test model = (Test) bundle.getParcelable("key_bundle");
        String name = bundle.getString("key_name");

        mDataBinding.txt1.setText("This is fragment 1 " + model.getName());

    }
}
