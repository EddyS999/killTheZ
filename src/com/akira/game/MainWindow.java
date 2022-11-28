package com.akira.game;

import com.akira.audio.Sound;
import com.akira.character.Player;
import com.akira.object.Bullet;
import javax.swing.*;
import java.awt.*;


public class MainWindow extends JPanel implements Runnable {


    private final int PAUSE = 1; //pause de 1 milliseconde pour le moteur
    public int fps; //frame per second

    int x;

    private ImageIcon icoBackground;
    private Image imgBackground;

    private ImageIcon icoPlayer;
    private Image imgPlayer;

    public Player player;
    public Bullet bullet;
    private String[] music;


    public MainWindow(){

        icoBackground = new ImageIcon(getClass().getResource("/images/background/main_background.png"));
        imgBackground = icoBackground.getImage();


        //Provisoire
        music = new String[] {"win.wav", "win2.wav", "win3.wav", "win4.wav", "win5.wav"};
        x = (int) (Math.random() * ((music.length-1) + 1));


       // Sound.playSound("/audio/"+music[x]);//Musique d'ambiance

        player = new Player(10,190);//Initialisation du joueur et de sa position par défaut

        bullet = new Bullet(0,0); //Initialisation de la balle dans le vide


        this.requestFocusInWindow();
        Thread engine = new Thread(this);
        engine.start();
        this.addKeyListener(new Keyboard());
        this.setFocusable(true);
    }



    //Le painComponent est une boucle
    public void paintComponent(Graphics g){

        super.paintComponent(g);
        Graphics g2 = (Graphics2D) g;

        g2.drawImage(this.imgBackground,00,00,null);//Dessin du fond ecran

        if(player.isAlive()){
            g2.drawImage(this.player.moving("player"),  this.player.getX(), this.player.getY(), null);
            //Tir
            if(player.isShooting()){

               g2.fillRect(this.bullet.getX(), this.bullet.getY(), this.bullet.getWidth(), this.bullet.getHeight());

                    bullet.move();
                    //provisoire
                   if(bullet.getX() > 700){
                       player.setShooting(false);
                   }

            }

        } else {
            //Mourir
        }

        System.out.println(bullet.getX());

        g2.setColor(Color.red);
        g2.setFont(new Font("Dialog", Font.BOLD,18));
        g2.drawString("fps: "+fps,5,20);

    }


    public void lose (){
        if(!this.player.isAlive()){
            //Fin de partie
        }
    }

    //Moteur
    @Override
    public void run() {
        long lastTime = System.nanoTime();
        int count = 0;
        while(true){
            try {
                Thread.sleep(PAUSE);
                this.repaint();
                count++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(System.nanoTime() - lastTime >= 1000000000L){
                fps = count;
                count = 0;
                lastTime = System.nanoTime();
            }
        }
    }
}
