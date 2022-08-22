package utilities;

import constants.Constants;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;

public class Utilities {

    private static Clip musicClip;
    public static int readNumber(String fileName){
        BufferedReader in = null;
        try {
            // IDE
            //in= new BufferedReader(new FileReader(fileName));
            // JAR
            in= new BufferedReader(new FileReader(new File(System.getProperty("user.dir"),fileName)));
            //prende una stringa e la converte in un numero
            int number= Integer.parseInt(in.readLine());
            in.close();
            return number;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeNumber(String fileName, int number){
        PrintWriter out = null;
        //deve sovrascrivere il file
        try {
            // IDE
            // out = new PrintWriter(new FileOutputStream( fileName , false));
            // JAR
            out = new PrintWriter(new FileOutputStream(new File(System.getProperty("user.dir"),fileName), false));
            out.print(number);
            out.flush();
            out.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
    public static ImageIcon readImage(String fileName){
        // IDE
        // return (new ImageIcon(fileName));
        // JAR
        return (new ImageIcon(ClassLoader.getSystemResource(fileName)));
    }
    public static void playEffects(String sound) {
        String soundName = "resources/sounds/"+sound+".wav";
        try {
            // IDE
            //AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
            // JAR
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(ClassLoader.getSystemResource(soundName));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
            //non supporta l'audio
        } catch (UnsupportedAudioFileException | LineUnavailableException e) {
            throw new RuntimeException(e);
            //non legge il file
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void playMusic(String music) {
        musicClip = null;
        String soundName = "resources/music/"+music+".wav";
        try {
            // IDE
            // AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundName).getAbsoluteFile());
            // JAR
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(ClassLoader.getSystemResource(soundName));
            musicClip = AudioSystem.getClip();
            musicClip.open(audioInputStream);
            musicClip.start();
            //non supporta l'audio
        } catch (UnsupportedAudioFileException | LineUnavailableException e) {
            throw new RuntimeException(e);
            //non legge il file
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void registerFont(){
        Font f = null;
        try {
            // IDE
            // f = Font.createFont(Font.TRUETYPE_FONT, new File(Constants.BOMB_FONT_PATH));
            // JAR
            f = Font.createFont(Font.TRUETYPE_FONT, Thread.currentThread().getContextClassLoader().getResourceAsStream(Constants.BOMB_FONT_PATH));
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(f);
    }
    public static void stopMusic() {
        if(musicClip!=null){
            musicClip.stop();
        }
    }
}
