package model;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Swatter {
    private static ArrayList<Image> imgsNormal;
    private static ArrayList<Image> imgsSwat;
    private static double imgIndex;
    private static boolean normalAnimation;
    private static boolean swatAnimation;

    public static void createSwatter() {
        imgIndex=1;
        imgsNormal = new ArrayList<>();
        ImageIcon imageIcon1 = new ImageIcon("resources/images/swap1.png");
        ImageIcon imageIcon2 = new ImageIcon("resources/images/swap1.png");
        ImageIcon imageIcon3 = new ImageIcon("resources/images/swap2.png");
        ImageIcon imageIcon4 = new ImageIcon("resources/images/swap2.png");
        ImageIcon imageIcon5 = new ImageIcon("resources/images/swap3.png");
        ImageIcon imageIcon6 = new ImageIcon("resources/images/swap3.png");
        ImageIcon imageIcon7 = new ImageIcon("resources/images/swap2.png");
        ImageIcon imageIcon8 = new ImageIcon("resources/images/swap2.png");
        imgsNormal.add(imageIcon1.getImage());
        imgsNormal.add(imageIcon2.getImage());
        imgsNormal.add(imageIcon3.getImage());
        imgsNormal.add(imageIcon4.getImage());
        imgsNormal.add(imageIcon5.getImage());
        imgsNormal.add(imageIcon6.getImage());
        imgsNormal.add(imageIcon7.getImage());
        imgsNormal.add(imageIcon8.getImage());
        imgsSwat = new ArrayList<>();
        imageIcon1 = new ImageIcon("resources/images/swap1.png");
        imageIcon2 = new ImageIcon("resources/images/swap1.png");
        imageIcon3 = new ImageIcon("resources/images/swap2.png");
        imageIcon4 = new ImageIcon("resources/images/swap2.png");
        imageIcon5 = new ImageIcon("resources/images/swap3.png");
        imageIcon6 = new ImageIcon("resources/images/swap3.png");
        imageIcon7 = new ImageIcon("resources/images/swap4.png");
        imageIcon8 = new ImageIcon("resources/images/swap4.png");
        ImageIcon imageIcon9 = new ImageIcon("resources/images/swap2.png");
        ImageIcon imageIcon10 = new ImageIcon("resources/images/swap2.png");
        imgsSwat.add(imageIcon1.getImage());
        imgsSwat.add(imageIcon2.getImage());
        imgsSwat.add(imageIcon3.getImage());
        imgsSwat.add(imageIcon4.getImage());
        imgsSwat.add(imageIcon5.getImage());
        imgsSwat.add(imageIcon6.getImage());
        imgsSwat.add(imageIcon7.getImage());
        imgsSwat.add(imageIcon8.getImage());
        imgsSwat.add(imageIcon9.getImage());
        imgsSwat.add(imageIcon10.getImage());
        normalAnimation = false;
        swatAnimation = false;
    }

    public static Image getImg() {
        //un insetto viene schiacciato
        if (swatAnimation) {
            imgIndex += 0.5;
            if (imgIndex >= imgsSwat.size()) {
                imgIndex = 1;
                swatAnimation = false;
                normalAnimation = false;
            }
            return imgsSwat.get(((int) Math.floor(imgIndex)) - 1);
            //non si schiaccia niente
        } else if (normalAnimation) {
            imgIndex += 0.5;
            if (imgIndex >= imgsNormal.size()) {
                imgIndex = 1;
                normalAnimation = false;
            }
            return imgsNormal.get(((int) Math.floor(imgIndex)) - 1);
        }
        //paletta nel menu
        return imgsSwat.get(1);
    }
    public static void setNormalAnimation(boolean normalAnimation) {
        Swatter.normalAnimation = normalAnimation;
    }

    public static void setSwatAnimation(boolean swatAnimation) {
        Swatter.swatAnimation = swatAnimation;
    }
}
