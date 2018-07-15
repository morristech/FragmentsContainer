package com.manojbhadane.democontaineractivity.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseFragment<B extends ViewDataBinding> extends Fragment {

    private B mDataBinding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mDataBinding = DataBindingUtil.inflate(inflater, getLayoutResId(), container, false);

        return mDataBinding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        init(mDataBinding);
    }

    public abstract int getLayoutResId();

    public abstract void init(B dataBinding);

}
