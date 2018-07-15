package com.manojbhadane.democontaineractivity.fragments;

import android.databinding.ViewDataBinding;

import com.manojbhadane.democontaineractivity.R;
import com.manojbhadane.democontaineractivity.base.BaseFragment;
import com.manojbhadane.democontaineractivity.databinding.Fragment2Binding;

public class Fragment2 extends BaseFragment {

    private static Fragment2 mInstance;
    private Fragment2Binding mDataBinding;

    public static Fragment2 getFragment() {
        if (mInstance == null)
            mInstance = new Fragment2();
        return mInstance;
    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_2;
    }

    @Override
    public void init(ViewDataBinding dataBinding) {

        mDataBinding = (Fragment2Binding) dataBinding;

        mDataBinding.txt1.setText("This is fragment 2");

    }
}
