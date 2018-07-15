package com.manojbhadane.democontaineractivity.fragments;

import android.databinding.ViewDataBinding;

import com.manojbhadane.democontaineractivity.R;
import com.manojbhadane.democontaineractivity.base.BaseFragment;
import com.manojbhadane.democontaineractivity.databinding.Fragment3Binding;

public class Fragment3 extends BaseFragment {

    private static Fragment3 mInstance;
    private Fragment3Binding mDataBinding;

    public static Fragment3 getFragment() {
        if (mInstance == null)
            mInstance = new Fragment3();
        return mInstance;
    }

    @Override
    public int getLayoutResId() {
        return R.layout.fragment_3;
    }

    @Override
    public void init(ViewDataBinding dataBinding) {
        mDataBinding = (Fragment3Binding) dataBinding;

        mDataBinding.txt1.setText("This is fragment 3");
    }
}
