package com.manojbhadane.democontaineractivity.container;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.manojbhadane.democontaineractivity.base.Constant;
import com.manojbhadane.democontaineractivity.fragments.Fragment1;
import com.manojbhadane.democontaineractivity.fragments.Fragment2;
import com.manojbhadane.democontaineractivity.fragments.Fragment3;


public class ContainerPresenterImpl implements ContainerPresenter {

    private ContainerView mView;

    public ContainerPresenterImpl(ContainerView view) {
        mView = view;
    }

    @Override
    public void setFragment(int number, Bundle bundle) {

        Fragment fragment = null;
        switch (number) {
            case Constant.FRAGMENT_1:
                fragment = Fragment1.getFragment();
                break;

            case Constant.FRAGMENT_2:
                fragment = Fragment2.getFragment();
                break;

            case Constant.FRAGMENT_3:
                fragment = Fragment3.getFragment();
                break;
        }

        fragment.setArguments(bundle);
        mView.loadFragment(fragment);
    }
}
