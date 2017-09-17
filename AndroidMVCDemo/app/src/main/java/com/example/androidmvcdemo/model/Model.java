package com.example.androidmvcdemo.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.print.PageRange;

import com.example.androidmvcdemo.R;

/**
 * Created by Administrator on 17-9-17.
 */

/**
 * 1.define listener interface
 * 2.define function registering listener
 * 3.define logical of dealing with model data
 * */
public class Model {
    private final Handler handler = new Handler();
    private OnStateChangeListener listener;
    private Bitmap bitmap;
    private Context context;

    public Model(Context context) {
        this.context = context;
        bitmap = BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher);
    }

    public interface OnStateChangeListener {
        void onStateChanged(Bitmap image);
    }

    public void registerOnStateChangeListener(OnStateChangeListener listener) {
        this.listener = listener;
    }

    public void loadImage() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // 模拟耗时操作
                    Thread.sleep(2000);
                    bitmap = BitmapFactory.decodeResource(context.getResources(),
                            R.mipmap.ic_launcher);

                    // 谁创建handler，就回传给谁的线程处理
                    if (listener != null) {
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                listener.onStateChanged(bitmap);
                            }
                        });
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }

    public void clear() {
        bitmap = null;
        if (listener != null) {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    listener.onStateChanged(null);
                }
            });
        }
    }
}
