package com.akira.object;

import javax.swing.*;
import java.awt.*;

public class Obj implements Runnable{

    public int width, height;
    public int x, y;
    protected Image imgObject;
    protected ImageIcon iconObject;


    public Obj(int x, int y, int width, int height){
        this.x=x;
        this.y=y;
        this.height=height;
        this.width = width;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Image getImgObject() {
        return imgObject;
    }

    public void setImgObject(Image imgObject) {
        this.imgObject = imgObject;
    }

    public ImageIcon getIconObject() {
        return iconObject;
    }

    public void setIconObject(ImageIcon iconObject) {
        iconObject = iconObject;
    }


    //Collision entre un objet et un personnage du jeu
    public boolean collision (Character character){
        
        return false;
    }

    @Override
    public void run() {

    }
}
