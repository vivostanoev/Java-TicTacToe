package game;

import gfx.ImageLoader;
import gfx.SpriteSheets;

import java.awt.*;
import java.util.ArrayList;


public class Xtoe {
    private SpriteSheets spriteSheet;
    public  int x , y,wight,hight;
    public Rectangle boundingBox;
    public Xtoe(int x, int y, int hight, int wight) {
        this.x = x;
        this.y = y;
        this.hight=hight;
        this.wight=wight;
        this.boundingBox=new Rectangle(x,y,wight,hight);
        this.spriteSheet=new SpriteSheets(ImageLoader.loadImage("/spritesheet.png"));
    }
public void tick(){
//    this.boundingBox.setBounds(this.x,this.y,this.wight,this.hight);
}
    public  void drawXtoe(Graphics g, ArrayList<Square> squares){
        for (int i = 0; i <squares.size() ; i++) {
            if(squares.get(i).isEmthy==true &&squares.get(i).isXtoe==true){
                int ySide=-21321;
                int xSide=-12312;
                if (squares.get(i).getCowSquare() == 1) {
                    ySide = 345;
                }
                if (squares.get(i).getCowSquare() == 2) {
                    ySide = 230;
                }
                if (squares.get(i).getCowSquare() == 3) {
                    ySide = 115;
                }
                if (squares.get(i).getRowSquare() == 1) {
                    xSide = 155;
                }
                if (squares.get(i).getRowSquare() == 2) {
                    xSide = 290;
                }
                if (squares.get(i).getRowSquare() == 3) {
                    xSide = 425;
                }
                g.drawImage(this.spriteSheet.crop(126, 0, 130, 130), xSide, ySide, null);
            }
        }
    }

    boolean fillXtoe(ArrayList<Square> squares,int givenRow,int givenCow){
        boolean findPlace=false;
        for (int i = 0; i < squares.size(); i++) {
            if(squares.get(i).getRowSquare()==givenRow && squares.get(i).getCowSquare()==givenCow && squares.get(i).isEmthy==false){
               if(givenCow==1){
                   if(squares.get(i+1).isOtoe==false&&squares.get(i+2).isOtoe==false){
                       squares.get(i).isEmthy=true;
                       squares.get(i).isXtoe=true;
                       findPlace=true;
                   }

               }
                if(givenCow==2){
                    if(squares.get(i-1).isOtoe==false&&squares.get(i+1).isOtoe==false){
                        squares.get(i).isEmthy=true;
                        squares.get(i).isXtoe=true;
                        findPlace=true;
                    }

                }
                if(givenCow==3){
                    if(givenCow==2){
                        if(squares.get(i-1).isOtoe==false&&squares.get(i-2).isOtoe==false){
                            squares.get(i).isEmthy=true;
                            squares.get(i).isXtoe=true;
                            findPlace=true;
                        }
                    }
                }
                if(givenRow==1){
                    if(squares.get(i+3).isOtoe==false&&squares.get(i+6).isOtoe==false){
                        squares.get(i).isEmthy=true;
                        squares.get(i).isXtoe=true;
                        findPlace=true;
                    }
                }
                if(givenRow==2){
                    if(squares.get(i+3).isOtoe==false&&squares.get(i-3).isOtoe==false){
                        squares.get(i).isEmthy=true;
                        squares.get(i).isXtoe=true;
                        findPlace=true;
                    }
                }
                if(givenRow==3){
                if(squares.get(i-3).isOtoe==false&&squares.get(i-6).isOtoe==false){
                          squares.get(i).isEmthy=true;
                          squares.get(i).isXtoe=true;
                          findPlace=true;
                      }
                }
            }
        }
        return findPlace;
    }

    boolean blockLineOtoe(ArrayList<Square> squares){
        boolean isBlock = false;
            for (int i = 0; i < 9; i += 3) {
                if ((squares.get(i).isOtoe == true && squares.get(i + 1).isOtoe == true) || (squares.get(i).isOtoe == true && squares.get(i + 2).isOtoe == true)
                        || (squares.get(i + 1).isOtoe == true && squares.get(i + 2).isOtoe == true)) {

                    if (squares.get(i).isEmthy == false) {
                        squares.get(i).isEmthy = true;
                        squares.get(i).isXtoe = true;
                        isBlock = true;
                    } else if (squares.get(i + 1).isEmthy == false) {
                        squares.get(i + 1).isEmthy = true;
                        squares.get(i + 1).isXtoe = true;
                        isBlock = true;
                    } else if (squares.get(i + 2).isEmthy == false) {
                        squares.get(i + 2).isEmthy = true;
                        squares.get(i + 2).isXtoe = true;
                        isBlock = true;
                    }

                }
            }
        if(isBlock){
            return isBlock;
        }
        else if((squares.get(0).isOtoe==true&&squares.get(4).isOtoe==true) || (squares.get(0).isOtoe==true&&squares.get(8).isOtoe==true)
                ||squares.get(4).isOtoe==true&&squares.get(8).isOtoe==true){
            if(squares.get(0).isEmthy==false){
                squares.get(0).isEmthy=true;
                squares.get(0).isXtoe=true;
                isBlock=true;
            }
            else if(squares.get(4).isEmthy==false){
                squares.get(4).isEmthy=true;
                squares.get(4).isXtoe=true;
                isBlock=true;
            }
            else if(squares.get(8).isEmthy==false){
                squares.get(8).isEmthy=true;
                squares.get(8).isXtoe=true;
                isBlock=true;
            }
        }

        else if((squares.get(2).isOtoe==true&&squares.get(4).isOtoe==true) || (squares.get(2).isOtoe==true&&squares.get(6).isOtoe==true)
                ||squares.get(4).isOtoe==true&&squares.get(6).isOtoe==true){
            if(squares.get(2).isEmthy==false){
                squares.get(2).isEmthy=true;
                squares.get(2).isXtoe=true;
                isBlock=true;
            }
            else if(squares.get(4).isEmthy==false){
                squares.get(4).isEmthy=true;
                squares.get(4).isXtoe=true;
                isBlock=true;
            }

            else if(squares.get(6).isEmthy==false){
                squares.get(6).isEmthy=true;
                squares.get(6).isXtoe=true;
                isBlock=true;
            }

        }
        if(!isBlock) {
            for (int i = 0; i < 3; i++) {
                if ((squares.get(i).isOtoe == true && squares.get(i + 3).isOtoe == true) || (squares.get(i).isOtoe == true && squares.get(i + 6).isOtoe == true) ||
                        squares.get(i + 3).isOtoe == true && squares.get(i + 6).isOtoe == true) {

                    if (squares.get(i).isEmthy == false) {
                        squares.get(i).isEmthy = true;
                        squares.get(i).isXtoe = true;
                        isBlock = true;
                    }
                    else if (squares.get(i + 3).isEmthy == false) {
                        squares.get(i + 3).isEmthy = true;
                        squares.get(i + 3).isXtoe = true;
                        isBlock = true;
                    }
                    else if (squares.get(i + 6).isEmthy == false) {
                        squares.get(i + 6).isEmthy = true;
                        squares.get(i + 6).isXtoe = true;
                        isBlock = true;
                    }
                }
            }
        }
        return isBlock;
    }

    public void fillSomeWhereXtoe(ArrayList<Square> square,int row,int cow){
        for (int i = 0; i <square.size(); i++) {
            if(square.get(i).getRowSquare()==row&&square.get(i).getCowSquare()==cow){
                square.get(i).isXtoe=true;
                square.get(i).isEmthy=true;
            }
        }
    }


    public boolean isLineXtoe(ArrayList<Square> squares){
        boolean isLineXtoe = false;
        for (int i = 0; i < 9; i+=3) {
            if ((squares.get(i).isXtoe == true&&squares.get(i+1).isXtoe == true) || (squares.get(i).isXtoe == true&&squares.get(i+2).isXtoe == true)
                    ||(squares.get(i+1).isXtoe == true&&squares.get(i+2).isXtoe == true)) {
                if(squares.get(i).isEmthy==false){
                    squares.get(i).isEmthy=true;
                    squares.get(i).isXtoe=true;
                    isLineXtoe = true;
                }
                if(squares.get(i+1).isEmthy==false){
                    squares.get(i+1).isEmthy=true;
                    squares.get(i+1).isXtoe=true;
                    isLineXtoe = true;
                }
                if(squares.get(i+2).isEmthy==false){
                    squares.get(i+2).isEmthy=true;
                    squares.get(i+2).isXtoe=true;
                    isLineXtoe = true;
                }

            }
        }
        if(isLineXtoe){
            return isLineXtoe;
        }

        else if((squares.get(0).isXtoe==true&&squares.get(4).isXtoe==true)||(squares.get(0).isXtoe==true&&squares.get(8).isXtoe==true)
                ||squares.get(4).isXtoe==true&&squares.get(8).isXtoe==true){

            if(squares.get(0).isEmthy==false){
                squares.get(0).isEmthy=true;
                squares.get(0).isXtoe=true;
                isLineXtoe = true;
            }
            else if(squares.get(4).isEmthy==false){
                squares.get(4).isEmthy=true;
                squares.get(4).isXtoe=true;
                isLineXtoe = true;
            }
            else if(squares.get(8).isEmthy==false){
                squares.get(8).isEmthy=true;
                squares.get(8).isXtoe=true;
                isLineXtoe = true;
            }

        }

        else if((squares.get(2).isXtoe==true&&squares.get(4).isXtoe==true)||(squares.get(2).isXtoe==true&&squares.get(6).isXtoe==true)
                ||squares.get(4).isXtoe==true&&squares.get(6).isXtoe==true){

            if(squares.get(2).isEmthy==false){
                squares.get(2).isEmthy=true;
                squares.get(2).isXtoe=true;
                isLineXtoe = true;
            }
            else if(squares.get(4).isEmthy==false){
                squares.get(4).isEmthy=true;
                squares.get(4).isXtoe=true;
                isLineXtoe = true;
            }
            else if(squares.get(6).isEmthy==false){
                squares.get(6).isEmthy=true;
                squares.get(6).isXtoe=true;
                isLineXtoe = true;
            }

        }
        if(!isLineXtoe) {
            for (int i = 0; i < 3; i++) {
                if ((squares.get(i).isXtoe == true && squares.get(i + 3).isXtoe == true) || (squares.get(i).isXtoe == true && squares.get(i + 6).isXtoe == true)
                        || squares.get(i + 3).isXtoe == true && squares.get(i + 6).isXtoe == true) {
                    if (squares.get(i).isEmthy == false) {
                        squares.get(i).isEmthy = true;
                        squares.get(i).isXtoe = true;
                        isLineXtoe = true;
                    }
                    else if (squares.get(i + 3).isEmthy == false) {
                        squares.get(i + 3).isEmthy = true;
                        squares.get(i + 3).isXtoe = true;
                        isLineXtoe = true;
                    }
                    else if (squares.get(i + 6).isEmthy == false) {
                        squares.get(i + 6).isEmthy = true;
                        squares.get(i + 6).isXtoe = true;
                        isLineXtoe = true;
                    }
                }
            }
        }
        return isLineXtoe;
    }
}
