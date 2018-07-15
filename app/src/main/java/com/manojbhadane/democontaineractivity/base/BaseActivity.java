package com.manojbhadane.democontaineractivity.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public abstract class BaseActivity<B extends ViewDataBinding> extends AppCompatActivity {
    private B mDataBinding;
    public Toolbar mToolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDataBinding = DataBindingUtil.setContentView(this, getLayoutResId());
        init(mDataBinding);
    }

    public abstract int getLayoutResId();

    public abstract void init(B dataBinding);

    public void showToolbarBackBtn(boolean isShown) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(isShown);
            getSupportActionBar().setDisplayShowHomeEnabled(isShown);
        }
    }

    public void setToolbarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}