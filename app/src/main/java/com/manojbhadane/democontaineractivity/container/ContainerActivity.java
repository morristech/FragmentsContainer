package com.manojbhadane.democontaineractivity.container;

import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

import com.manojbhadane.democontaineractivity.R;
import com.manojbhadane.democontaineractivity.base.BaseActivity;
import com.manojbhadane.democontaineractivity.databinding.FlLayoutContainerBinding;

/**
 * Sample usasge
 * <p>
 * <p>
 * new ContainerModel()
 * .setTitle("Fragment 1")
 * .setFragmentNumber(Constant.FRAGMENT_1)
 * .setBundle(bundle)
 * .setShowToolbar(false)
 * .setShowToolbarBackBtn(false)
 * .startActivity(MainActivity.this);
 * <p>
 * Note : except fragmentNumber() and startActivity() method all are optionals.
 */

public class ContainerActivity extends BaseActivity implements ContainerView {

    private ContainerPresenter mPresenter;
    private FlLayoutContainerBinding mBinding;

    @Override
    public int getLayoutResId() {
        return R.layout.fl_layout_container;
    }

    @Override
    public void init(ViewDataBinding dataBinding) {

        /**
         *  Initilization
         */
        mBinding = (FlLayoutContainerBinding) dataBinding;
        mPresenter = new ContainerPresenterImpl(this);


        /**
         *  Obtain parameters
         */
        Bundle b = getIntent().getBundleExtra(ContainerModel.KEY);
        String title = b.getString(ContainerModel.KEY_TITLE);
        int fragmentNumber = b.getInt(ContainerModel.KEY_FRAGMENT_NUMBER);
        boolean shouldShowToolbar = b.getBoolean(ContainerModel.KEY_TOOLBAR_VISIBILITY);
        boolean shouldShowToolbarBackBtn = b.getBoolean(ContainerModel.KEY_TOOLBAR_BACKBTN_VISIBILITY);


        /**
         *  Toolbar
         */
        if (shouldShowToolbar) {
            mBinding.toolBar.setVisibility(View.VISIBLE);
            setSupportActionBar(mBinding.toolBar);
            getSupportActionBar().setTitle(title);
            if (shouldShowToolbarBackBtn)
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        } else {
            mBinding.toolBar.setVisibility(View.GONE);
        }

        mPresenter.setFragment(fragmentNumber, b);
    }

    @Override
    public void loadFragment(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.layContainer, fragment);
        transaction.commit();
    }
}
