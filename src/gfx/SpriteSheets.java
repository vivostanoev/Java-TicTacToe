package gfx;


import java.awt.image.BufferedImage;


/**
 * Created by Vivo on 22.6.2016 г..
 */
public class SpriteSheets {

    private BufferedImage spriteSheet;

    public SpriteSheets(BufferedImage img){
        this.spriteSheet=img;
    }

    public BufferedImage crop(int x,int y,int width,int height){
        return this.spriteSheet.getSubimage(x,y,width,height);
    }
}
