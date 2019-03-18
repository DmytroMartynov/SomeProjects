package com.company;


import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

    public class Robot {

        interface Listener {
            void onMove(char direction);
        }

        private int x = 0;
        private int y = 0;

        private Listener listener;

        private Random random = new Random();

        public void startMoving() {
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    randomMove();
                }
            };

            Timer timer = new Timer();
            timer.schedule(task, 1000, 1000);


        }

        private void randomMove() {
            int move = random.nextInt(4);
            switch (move) {
                case 0:
                    x--;
                    move('L');
                    break;
                case 1:
                    x++;
                    move('R');
                    break;
                case 2:
                    y++;
                    move('D');
                    break;
                case 3:
                    y--;
                    move('U');
            }
        }

        private void move(char ch) {
            if (listener != null) {
                listener.onMove(ch);
            }
        }

        public void setOnMoveListener(Listener listener) {
            this.listener = listener;
        }


    }

