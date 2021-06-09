package com.example.pacman.classes;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.example.pacman.R;

public class PacMan extends SurfaceView implements  SurfaceHolder.Callback{
    private boolean playing = true;
    private Bitmap[] pacmanRight, pacmanDown, pacmanLeft, pacmanUp;
    private Bitmap[] arrowRight, arrowDown, arrowLeft, arrowUp;
    private Bitmap ghostBitmap;
    private Paint paint;
    private int fantasmaDirec;
    private int screenWidth;
    private int blockSize;
    private Escenario escenario;
    private boolean status = true;
    private SurfaceHolder holder;
    private long frameTick;
    private int totalFrame =4;
    private int currentPacmanFrame = 0;
    private int currentArrowFrame = 0;
    private int  dirrecion_actual = 2;
    private int xPosPacman;
    private int yPosPacman;
    private int xPosGhost;
    private int yPosGhost;
    int xDistance;
    int yDistance;

    public PacMan(Context context) {
        super(context);
        paint = new Paint();
        paint.setColor(Color.WHITE);
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        screenWidth = metrics.widthPixels;
        blockSize = screenWidth/17;
        blockSize = (blockSize / 5) * 5;
        escenario = new Escenario();
        frameTick = 1000/totalFrame;
        holder = getHolder();
        holder.addCallback(this);
        fantasmaDirec =4;
        xPosGhost = 8 * blockSize;
        yPosGhost = 4 * blockSize;
        xPosPacman = 8 * blockSize;
        yPosPacman = 13 * blockSize;
        loadBitmapImages();
        new PacManT().start();
    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder holder) {

    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder holder) {

    }

    private class PacManT extends Thread {
        int c = 0;

        @Override
        public void run() {
//            long last_update_time = 0;
//            long delay = 100;
//            int img_ids[] = {
//                    R.drawable.pacman_right,
//                    R.drawable.pacman_right1,
//                    R.drawable.pacman_right2,
//                    R.drawable.pacman_right3,
//            };

            while (status) {

                if (!holder.getSurface().isValid()) {
                    continue;
                }
                Canvas canvas = holder.lockCanvas();
                if (canvas != null) {
                    canvas.drawColor(Color.BLACK);
                    drawMap(canvas);
                    updateFrame(System.currentTimeMillis());
                    moverPacman(canvas);
                    drawPellets(canvas);
                    moverFantasma(canvas);
                    // crea tu función y mételo aca
                    holder.unlockCanvasAndPost(canvas);
                }

            }
        }
        public void moverPacman(Canvas canvas){
            dibujarPacman(canvas);
        }
        public void dibujarPacman (Canvas canvas){
            switch (dirrecion_actual) {
                case (0):
                    canvas.drawBitmap(pacmanUp[currentPacmanFrame], xPosPacman, yPosPacman, paint);
                    break;
                case (1):
                    canvas.drawBitmap(pacmanRight[currentPacmanFrame], xPosPacman, yPosPacman, paint);
                    break;
                case (3):
                    canvas.drawBitmap(pacmanLeft[currentPacmanFrame], xPosPacman, yPosPacman, paint);
                    break;
                default:
                    canvas.drawBitmap(pacmanDown[currentPacmanFrame], xPosPacman, yPosPacman, paint);
                    break;
            }
        }

        public void updateFrame(long time_game){
            if (time_game > frameTick + (totalFrame * 30)) {
                frameTick = time_game;


                currentPacmanFrame++;

                if (currentPacmanFrame >= totalFrame) {
                    currentPacmanFrame = 0;
                }
            }
            if (time_game > frameTick + (50)) {
                currentArrowFrame++;
                if (currentArrowFrame >= 7) {
                    currentArrowFrame = 0;
                }
            }
        }
        public void drawMap(Canvas canvas) {
            paint.setColor(Color.GREEN);
            paint.setStrokeWidth(2.5f);
            int x;
            int y;
            for (int i = 0; i < 18; i++) {
                for (int j = 0; j < 17; j++) {
                    x = j * blockSize;
                    y = i * blockSize;
                    if ((esc[i][j] & 1) != 0) //  izquierda
                        canvas.drawLine(x, y, x, y + blockSize - 1, paint);

                    if ((esc[i][j] & 2) != 0) //  abajo
                        canvas.drawLine(x, y, x + blockSize - 1, y, paint);

                    if ((esc[i][j] & 4) != 0) // derecha
                        canvas.drawLine(
                                x + blockSize, y, x + blockSize, y + blockSize - 1, paint);
                    if ((esc[i][j] & 8) != 0) // arriba
                        canvas.drawLine(
                                x, y + blockSize, x + blockSize - 1, y + blockSize , paint);
                }
            }
            paint.setColor(Color.WHITE);
        }
        public void drawPellets(Canvas canvas) {
            float x;
            float y;
            for (int i = 0; i < 18; i++) {
                for (int j = 0; j < 17; j++) {
                    x = j * blockSize;
                    y = i * blockSize;
                    // Draws pellet in the middle of a block
                    if ((esc[i][j] & 16) != 0)
                        canvas.drawCircle(x + blockSize / 2, y + blockSize / 2, blockSize / 10, paint);
                }
            }
        }
        public void moverFantasma(Canvas canvas) {
            short ch;

            xDistance = xPosPacman - xPosGhost;
            yDistance = yPosPacman - yPosGhost;

            if ((xPosGhost % blockSize == 0) && (yPosGhost % blockSize == 0)) {
                ch = esc[yPosGhost / blockSize][xPosGhost / blockSize];

                if (xPosGhost >= blockSize * 17) {
                    xPosGhost = 0;
                }
                if (xPosGhost < 0) {
                    xPosGhost = blockSize * 17;
                }


                if (xDistance >= 0 && yDistance >= 0) { // Move right and down
                    if ((ch & 4) == 0 && (ch & 8) == 0) {
                        if (Math.abs(xDistance) > Math.abs(yDistance)) {
                            fantasmaDirec = 1;
                        } else {
                            fantasmaDirec = 2;
                        }
                    }
                    else if ((ch & 4) == 0) {
                        fantasmaDirec = 1;
                    }
                    else if ((ch & 8) == 0) {
                        fantasmaDirec = 2;
                    }
                    else
                        fantasmaDirec = 3;
                }
                if (xDistance >= 0 && yDistance <= 0) { // Move right and up
                    if ((ch & 4) == 0 && (ch & 2) == 0 ) {
                        if (Math.abs(xDistance) > Math.abs(yDistance)) {
                            fantasmaDirec = 1;
                        } else {
                            fantasmaDirec = 0;
                        }
                    }
                    else if ((ch & 4) == 0) {
                        fantasmaDirec = 1;
                    }
                    else if ((ch & 2) == 0) {
                        fantasmaDirec = 0;
                    }
                    else fantasmaDirec = 2;
                }
                if (xDistance <= 0 && yDistance >= 0) { // Move left and down
                    if ((ch & 1) == 0 && (ch & 8) == 0) {
                        if (Math.abs(xDistance) > Math.abs(yDistance)) {
                            fantasmaDirec = 3;
                        } else {
                            fantasmaDirec = 2;
                        }
                    }
                    else if ((ch & 1) == 0) {
                        fantasmaDirec = 3;
                    }
                    else if ((ch & 8) == 0) {
                        fantasmaDirec = 2;
                    }
                    else fantasmaDirec = 1;
                }
                if (xDistance <= 0 && yDistance <= 0) { // Move left and up
                    if ((ch & 1) == 0 && (ch & 2) == 0) {
                        if (Math.abs(xDistance) > Math.abs(yDistance)) {
                            fantasmaDirec = 3;
                        } else {
                            fantasmaDirec = 0;
                        }
                    }
                    else if ((ch & 1) == 0) {
                        fantasmaDirec = 3;
                    }
                    else if ((ch & 2) == 0) {
                        fantasmaDirec = 0;
                    }
                    else fantasmaDirec = 2;
                }
                // Handles wall collisions
                if ( (fantasmaDirec == 3 && (ch & 1) != 0) ||
                        (fantasmaDirec == 1 && (ch & 4) != 0) ||
                        (fantasmaDirec == 0 && (ch & 2) != 0) ||
                        (fantasmaDirec == 2 && (ch & 8) != 0) ) {
                    fantasmaDirec = 4;
                }
            }

            if (fantasmaDirec == 0) {
                yPosGhost += -blockSize / 20;
            } else if (fantasmaDirec == 1) {
                xPosGhost += blockSize / 20;
            } else if (fantasmaDirec == 2) {
                yPosGhost += blockSize / 20;
            } else if (fantasmaDirec == 3) {
                xPosGhost += -blockSize / 20;
            }
            canvas.drawBitmap(ghostBitmap, xPosGhost, yPosGhost, paint);
        }
        final short esc[][] = new short[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {19, 26, 26, 18, 26, 26, 26, 22, 0, 19, 26, 26, 26, 18, 26, 26, 22},
                {21, 0, 0, 21, 0, 0, 0, 21, 0, 21, 0, 0, 0, 21, 0, 0, 21},
                {17, 26, 26, 16, 26, 18, 26, 24, 26, 24, 26, 18, 26, 16, 26, 26, 20},
                {25, 26, 26, 20, 0, 25, 26, 22, 0, 19, 26, 28, 0, 17, 26, 26, 28},
                {0, 0, 0, 21, 0, 0, 0, 21, 0, 21, 0, 0, 0, 21, 0, 0, 0},
                {0, 0, 0, 21, 0, 19, 26, 24, 26, 24, 26, 22, 0, 21, 0, 0, 0},
                {26, 26, 26, 16, 26, 20, 0, 0, 0, 0, 0, 17, 26, 16, 26, 26, 26},
                {0, 0, 0, 21, 0, 17, 26, 26, 26, 26, 26, 20, 0, 21, 0, 0, 0},
                {0, 0, 0, 21, 0, 21, 0, 0, 0, 0, 0, 21, 0, 21, 0, 0, 0},
                {19, 26, 26, 16, 26, 24, 26, 22, 0, 19, 26, 24, 26, 16, 26, 26, 22},
                {21, 0, 0, 21, 0, 0, 0, 21, 0, 21, 0, 0, 0, 21, 0, 0, 21},
                {25, 22, 0, 21, 0, 0, 0, 17, 2, 20, 0, 0, 0, 21, 0, 19, 28}, // "2" in this line is for
                {0, 21, 0, 17, 26, 26, 18, 24, 24, 24, 18, 26, 26, 20, 0, 21, 0}, // pacman's spawn
                {19, 24, 26, 28, 0, 0, 25, 18, 26, 18, 28, 0, 0, 25, 26, 24, 22},
                {21, 0, 0, 0, 0, 0, 0, 21, 0, 21, 0, 0, 0, 0, 0, 0, 21},
                {25, 26, 26, 26, 26, 26, 26, 24, 26, 24, 26, 26, 26, 26, 26, 26, 28},
        };
    }
    private void loadBitmapImages() {

        int spriteSize = screenWidth/17;
        spriteSize = (spriteSize / 5) * 5;
        int arrowSize = 7*blockSize;


        arrowRight = new Bitmap[7];
        arrowRight[0] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(
                getResources(), R.drawable.right_arrow_frame1), arrowSize, arrowSize, false);
        arrowRight[1] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(
                getResources(), R.drawable.right_arrow_frame2), arrowSize, arrowSize, false);
        arrowRight[2] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(
                getResources(), R.drawable.right_arrow_frame3), arrowSize, arrowSize, false);
        arrowRight[3] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(
                getResources(), R.drawable.right_arrow_frame4), arrowSize, arrowSize, false);
        arrowRight[4] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(
                getResources(), R.drawable.right_arrow_frame5), arrowSize, arrowSize, false);
        arrowRight[5] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(
                getResources(), R.drawable.right_arrow_frame6), arrowSize, arrowSize, false);
        arrowRight[6] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(
                getResources(), R.drawable.right_arrow_frame7), arrowSize, arrowSize, false);

        arrowDown = new Bitmap[7]; // 7 images frames for down direction
        arrowDown[0] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(
                getResources(), R.drawable.down_arrow_frame1), arrowSize, arrowSize, false);
        arrowDown[1] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(
                getResources(), R.drawable.down_arrow_frame2), arrowSize, arrowSize, false);
        arrowDown[2] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(
                getResources(), R.drawable.down_arrow_frame3), arrowSize, arrowSize, false);
        arrowDown[3] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(
                getResources(), R.drawable.down_arrow_frame4), arrowSize, arrowSize, false);
        arrowDown[4] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(
                getResources(), R.drawable.down_arrow_frame5), arrowSize, arrowSize, false);
        arrowDown[5] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(
                getResources(), R.drawable.down_arrow_frame6), arrowSize, arrowSize, false);
        arrowDown[6] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(
                getResources(), R.drawable.down_arrow_frame7), arrowSize, arrowSize, false);

        arrowUp = new Bitmap[7]; // 7 frames for each direction
        arrowUp[0] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(
                getResources(), R.drawable.up_arrow_frame1), arrowSize, arrowSize, false);
        arrowUp[1] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(
                getResources(), R.drawable.up_arrow_frame2), arrowSize, arrowSize, false);
        arrowUp[2] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(
                getResources(), R.drawable.up_arrow_frame3), arrowSize, arrowSize, false);
        arrowUp[3] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(
                getResources(), R.drawable.up_arrow_frame4), arrowSize, arrowSize, false);
        arrowUp[4] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(
                getResources(), R.drawable.up_arrow_frame5), arrowSize, arrowSize, false);
        arrowUp[5] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(
                getResources(), R.drawable.up_arrow_frame6), arrowSize, arrowSize, false);
        arrowUp[6] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(
                getResources(), R.drawable.up_arrow_frame7), arrowSize, arrowSize, false);

        arrowLeft = new Bitmap[7]; // 7 images frames for left direction
        arrowLeft[0] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(
                getResources(), R.drawable.left_arrow_frame1), arrowSize, arrowSize, false);
        arrowLeft[1] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(
                getResources(), R.drawable.left_arrow_frame2), arrowSize, arrowSize, false);
        arrowLeft[2] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(
                getResources(), R.drawable.left_arrow_frame3), arrowSize, arrowSize, false);
        arrowLeft[3] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(
                getResources(), R.drawable.left_arrow_frame4), arrowSize, arrowSize, false);
        arrowLeft[4] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(
                getResources(), R.drawable.left_arrow_frame5), arrowSize, arrowSize, false);
        arrowLeft[5] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(
                getResources(), R.drawable.left_arrow_frame6), arrowSize, arrowSize, false);
        arrowLeft[6] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(
                getResources(), R.drawable.left_arrow_frame7), arrowSize, arrowSize, false);




        pacmanRight = new Bitmap[totalFrame];
        pacmanRight[0] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(
                getResources(),R.drawable.pacman_right1), spriteSize, spriteSize, false);
        pacmanRight[1] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(
                getResources(), R.drawable.pacman_right2), spriteSize, spriteSize, false);
        pacmanRight[2] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(
                getResources(), R.drawable.pacman_right3), spriteSize, spriteSize, false);
        pacmanRight[3] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(
                getResources(), R.drawable.pacman_right), spriteSize, spriteSize, false);

        pacmanDown = new Bitmap[totalFrame];
        pacmanDown[0] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(
                getResources(), R.drawable.pacman_down1), spriteSize, spriteSize, false);
        pacmanDown[1] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(
                getResources(), R.drawable.pacman_down2), spriteSize, spriteSize, false);
        pacmanDown[2] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(
                getResources(), R.drawable.pacman_down3), spriteSize, spriteSize, false);
        pacmanDown[3] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(
                getResources(), R.drawable.pacman_down), spriteSize, spriteSize, false);

        pacmanLeft = new Bitmap[totalFrame];
        pacmanLeft[0] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(
                getResources(), R.drawable.pacman_left1), spriteSize, spriteSize, false);
        pacmanLeft[1] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(
                getResources(), R.drawable.pacman_left2), spriteSize, spriteSize, false);
        pacmanLeft[2] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(
                getResources(), R.drawable.pacman_left3), spriteSize, spriteSize, false);
        pacmanLeft[3] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(
                getResources(), R.drawable.pacman_left), spriteSize, spriteSize, false);

        pacmanUp = new Bitmap[totalFrame];
        pacmanUp[0] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(
                getResources(), R.drawable.pacman_up1), spriteSize, spriteSize, false);
        pacmanUp[1] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(
                getResources(), R.drawable.pacman_up2), spriteSize, spriteSize, false);
        pacmanUp[2] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(
                getResources(), R.drawable.pacman_up3), spriteSize, spriteSize, false);
        pacmanUp[3] = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(
                getResources(), R.drawable.pacman_up), spriteSize, spriteSize, false);

        ghostBitmap = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(
                getResources(), R.drawable.ghost), spriteSize, spriteSize, false);
    }
}