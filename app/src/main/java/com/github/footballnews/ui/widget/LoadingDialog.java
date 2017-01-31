package com.github.footballnews.ui.widget;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.WindowManager;

import com.github.footballnews.R;

/**
 * Date: 31.01.2017
 * Time: 15:29
 *
 * @author Aleks Sander
 *         Project FootballNews
 */

public class LoadingDialog extends ProgressDialog {
    private final Handler handler;

    public LoadingDialog(Context context) {
        super(context);
        handler = new Handler(Looper.getMainLooper());
        setCancelable(false);
        if (getWindow() != null) {
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE, WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getWindow() != null) {
            getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        }
        setContentView(R.layout.custom_progress_dialog);
    }

    public void setStatus(boolean status, int checkDelay) {
        handler.removeCallbacks(actionDismiss);
        if (status) {
            handler.post(actionShow);
        } else {
            handler.postDelayed(actionDismiss, checkDelay);
        }
    }

    public void setStatus(boolean status) {
        setStatus(status, 300);
    }

    private final Runnable actionShow = this::actionShow;

    private void actionShow() {
        if (!isShowing()) {
            show();
        }
    }

    private final Runnable actionDismiss = this::actionDismiss;

    private void actionDismiss() {
        if (isShowing()) {
            dismiss();
        }
    }
}
