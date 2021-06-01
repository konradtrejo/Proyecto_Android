package com.example.pacman.classes;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.example.pacman.R;

public class PacMan extends SurfaceView {
    private boolean playing = true;

    public PacMan(Context context) {
        super(context);
        new PacManT().start();
    }

    private class PacManT extends Thread {
        int c = 0;

        @Override
        public void run() {
            long last_update_time = 0;
            long delay = 100;
            int img_ids[] = {
                    R.drawable.pacman_right,
                    R.drawable.pacman_right1,
                    R.drawable.pacman_right2,
                    R.drawable.pacman_right3,
            };

            System.out.println("PacManRun");
            while (true) {
                if (playing) {
                    long current_time = System.currentTimeMillis();
                    if (current_time > last_update_time + delay) {
                        if (c >= 3) {
                            c = 0;
                        }
                        draw(img_ids[c]);
                        last_update_time = current_time;
                        //System.out.println("Actualizado: " + last_update_time);
                        c++;
                    }
                }
            }
        }

        private void draw(int img_id) {
            SurfaceHolder holder = getHolder();
            Canvas canvas = holder.lockCanvas();

            if (canvas != null) {
                canvas.drawColor(Color.BLACK);
                Paint paint = new Paint();
                Bitmap bitmap = BitmapFactory.decodeResource(getContext().getResources(),
                        img_id);
                canvas.drawBitmap(bitmap, 100, 100, paint);
                holder.unlockCanvasAndPost(canvas);
            }
        }
    }
}