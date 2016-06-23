package game;

import display.Display;
import gfx.ImageLoader;

import java.util.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.Random;

public class Game implements Runnable {

    private Thread thread;

    private String title;
    private int width, height;
    private boolean isRunning;
    Scanner scan ;
    private Display display;
    private BufferStrategy bufferStrategy;
    private Graphics graphics;
    private Image background;
    private Xtoe xToe;
    private Otoe oToe;
    private ArrayList<Square> squares;
    private Square sq;
    int states =0;
    Random rm;

    public Game(String title, int width, int height) {
        this.title = "TicTacToe";
        this.width = width;
        this.height = height;
    }

    public void init() {
        this.display = new Display(this.title, this.width, this.height);
        this.background=ImageLoader.loadImage("/background.jpg");
        rm=new Random();
        xToe=new Xtoe(0,0,0,0);
        oToe=new Otoe(0,0,0,0);
        sq = new Square(0,0);
        squares=new ArrayList<>();
        scan = new Scanner(System.in);
        int i = 0;
        for (int cow = 1; cow <4; cow++) {
            for (int row = 1; row < 4; row++) {
                Square sq = new Square(row,cow);
                squares.add(sq);
            }
        }
    }

    public void tick() {
        int nextRow= rm.nextInt(3)+1;
        int nextCow = rm.nextInt(3)+1;
        ArrayList<Square> countLeftSquares= sq.SquareLeft(squares);
        if(countLeftSquares.size()==0){
            System.out.println("DRAW");
            scan.nextLine();

        }
        if(sq.haveWinner(squares)){
            System.out.println("WINNER");
            System.out.println("NICE");
            scan.nextLine();
        }
        if(states%2==0){
            boolean isXtoeLineToWin  = xToe.isLineXtoe(squares);
            if(!isXtoeLineToWin){
            boolean blockOtoe = xToe.blockLineOtoe(squares);
            if(!blockOtoe) {
                boolean fillXtoe = xToe.fillXtoe(squares, nextRow, nextCow);
                if (!fillXtoe) {
                    Random random = new Random();
                    int next = random.nextInt(countLeftSquares.size());
                    int r = countLeftSquares.get(next).getRowSquare();
                    int c = countLeftSquares.get(next).getCowSquare();
                    xToe.fillSomeWhereXtoe(squares, r, c);
                }
            }
           }
        }else{
            boolean isOtoeLineToWin = oToe.isLineOtoe(squares);
            if(!isOtoeLineToWin) {
                boolean blockXtoe = oToe.blockLineXtoe(squares);
                if (!blockXtoe) {
                    boolean fillOtoe = oToe.fillOtoe(squares, nextRow, nextCow);
                    if (!fillOtoe) {
                        Random random = new Random();
                        int next = random.nextInt(countLeftSquares.size());
                        int r = countLeftSquares.get(next).getRowSquare();
                        int c = countLeftSquares.get(next).getCowSquare();
                        oToe.fillSomeWhereOte(squares, r, c);
                    }
                }
            }
        }
        states++;
    }
    public void render() {
        this.bufferStrategy = this.display.getCanvas().getBufferStrategy();

        if (this.bufferStrategy == null) {
            this.display.getCanvas().createBufferStrategy(2); //    - test 1 or 3 for best work
            this.bufferStrategy = this.display.getCanvas().getBufferStrategy();
        }

        this.graphics = this.bufferStrategy.getDrawGraphics();
        this.graphics.clearRect(0, 0, this.width, this.height);
        this.graphics.drawImage(this.background, 0, 0, this.width, this.height, null);
        xToe.drawXtoe(graphics,squares);
        oToe.drawOtoe(graphics,squares);
        this.graphics.dispose();
        this.bufferStrategy.show();
    }
    @Override   // - "implements Runnable" - Creating Threads and Loops
    public void run() {
        this.init();
        int fps = 100;
        double timePerTick = 1_000_000_000_00.0 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;

        while (isRunning) {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;

            if (delta >= 1) {
                tick();
                render();
                ticks++;
                delta--;
           }

            if (timer >= 1_000_000_000) {
             //   System.out.println("Ticks and Frames: " + ticks);
               ticks = 0;
                timer = 0;
            }
        }

        this.stop();
    }

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        this.isRunning = true;
    }

    public synchronized void stop() {
        try {
            this.isRunning = false;
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
