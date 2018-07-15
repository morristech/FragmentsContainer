package com.manojbhadane.democontaineractivity.container;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Sample usasge
 * <p>
 *
 *      new ContainerModel()
 *          .setTitle("Fragment 1")
 *          .setFragmentNumber(Constant.FRAGMENT_1)
 *          .setBundle(bundle)
 *          .setShowToolbar(false)
 *          .setShowToolbarBackBtn(false)
 *          .startActivity(MainActivity.this);
 *
 *   Note : except fragmentNumber() and startActivity() method all are optionals.
 *
 */
public class ContainerModel {

    public static final String KEY = "key_container";
    public static final String KEY_TITLE = "key_title";
    public static final String KEY_FRAGMENT_NUMBER = "key_fragment_number";
    public static final String KEY_TOOLBAR_VISIBILITY = "key_toolbar_visibility";
    public static final String KEY_TOOLBAR_BACKBTN_VISIBILITY = "key_toolbar_back_btn_visibility";

    private String title;
    private Bundle bundle;
    private int fragmentNumber = -1;
    private boolean showToolbar = true;
    private boolean showToolbarBackBtn = true;

    public ContainerModel() {
    }

    public String getTitle() {
        return title;
    }

    public ContainerModel setTitle(String title) {
        this.title = title;
        return this;
    }

    public Bundle getBundle() {

        if (bundle == null)
            bundle = new Bundle();

        bundle.putString(KEY_TITLE, getTitle());
        bundle.putInt(KEY_FRAGMENT_NUMBER, getFragmentNumber());
        bundle.putBoolean(KEY_TOOLBAR_VISIBILITY, isShowToolbar());
        bundle.putBoolean(KEY_TOOLBAR_BACKBTN_VISIBILITY, isShowToolbarBackBtn());
        return bundle;
    }

    public ContainerModel setBundle(Bundle bundle) {
        this.bundle = bundle;
        return this;
    }

    public int getFragmentNumber() {
        return fragmentNumber;
    }

    public ContainerModel setFragmentNumber(int fragmentNumber) {
        this.fragmentNumber = fragmentNumber;
        return this;
    }

    public boolean isShowToolbar() {
        return showToolbar;
    }

    public ContainerModel setShowToolbar(boolean showToolbar) {
        this.showToolbar = showToolbar;
        return this;
    }

    public boolean isShowToolbarBackBtn() {
        return showToolbarBackBtn;
    }

    public ContainerModel setShowToolbarBackBtn(boolean showToolbarBackBtn) {
        this.showToolbarBackBtn = showToolbarBackBtn;
        return this;
    }

    public void startActivity(Context context) {
        if (fragmentNumber != -1) {
            Intent intent = new Intent(context, ContainerActivity.class);
            intent.putExtra(KEY, getBundle());
            context.startActivity(intent);
        } else {
            Toast.makeText(context, "invalid fragment number", Toast.LENGTH_SHORT).show();
        }
    }
}