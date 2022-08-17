package view;

import constants.Constants;
import utilities.Utilities;

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
        ImageIcon imageIcon1 = Utilities.readImage(Constants.SWATTER_1_PATH);
        ImageIcon imageIcon2 = Utilities.readImage(Constants.SWATTER_1_PATH);
        ImageIcon imageIcon3 = Utilities.readImage(Constants.SWATTER_2_PATH);
        ImageIcon imageIcon4 = Utilities.readImage(Constants.SWATTER_2_PATH);
        ImageIcon imageIcon5 = Utilities.readImage(Constants.SWATTER_3_PATH);
        ImageIcon imageIcon6 = Utilities.readImage(Constants.SWATTER_3_PATH);
        ImageIcon imageIcon7 = Utilities.readImage(Constants.SWATTER_2_PATH);
        ImageIcon imageIcon8 = Utilities.readImage(Constants.SWATTER_2_PATH);
        imgsNormal.add(imageIcon1.getImage());
        imgsNormal.add(imageIcon2.getImage());
        imgsNormal.add(imageIcon3.getImage());
        imgsNormal.add(imageIcon4.getImage());
        imgsNormal.add(imageIcon5.getImage());
        imgsNormal.add(imageIcon6.getImage());
        imgsNormal.add(imageIcon7.getImage());
        imgsNormal.add(imageIcon8.getImage());
        imgsSwat = new ArrayList<>();
        imageIcon1 = Utilities.readImage(Constants.SWATTER_1_PATH);
        imageIcon2 = Utilities.readImage(Constants.SWATTER_1_PATH);
        imageIcon3 = Utilities.readImage(Constants.SWATTER_2_PATH);
        imageIcon4 = Utilities.readImage(Constants.SWATTER_2_PATH);
        imageIcon5 = Utilities.readImage(Constants.SWATTER_3_PATH);
        imageIcon6 = Utilities.readImage(Constants.SWATTER_3_PATH);
        imageIcon7 = Utilities.readImage(Constants.SWATTER_4_PATH);
        imageIcon8 = Utilities.readImage(Constants.SWATTER_4_PATH);
        ImageIcon imageIcon9 = Utilities.readImage(Constants.SWATTER_2_PATH);
        ImageIcon imageIcon10 = Utilities.readImage(Constants.SWATTER_2_PATH);
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
            imgIndex += 1;
            if (imgIndex >= imgsSwat.size()) {
                imgIndex = 1;
                swatAnimation = false;
                normalAnimation = false;
            }
            return imgsSwat.get(((int) Math.floor(imgIndex)) - 1);
            //non si schiaccia niente
        } else if (normalAnimation) {
            imgIndex += 1;
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
