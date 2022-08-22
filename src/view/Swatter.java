package view;

import constants.Constants;
import utilities.Utilities;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Swatter {
    private ArrayList<Image> imgsNormal;
    private ArrayList<Image> imgsSwat;
    private double imgIndex;
    private  boolean normalAnimation;
    private  boolean swatAnimation;

    public Swatter() {
        imgIndex=1;
        imgsNormal = new ArrayList<>();
        ImageIcon imageIcon1 = Utilities.readImage(Constants.SWATTER_1_PATH);
        ImageIcon imageIcon2 = Utilities.readImage(Constants.SWATTER_2_PATH);
        ImageIcon imageIcon3 = Utilities.readImage(Constants.SWATTER_3_PATH);
        ImageIcon imageIcon4 = Utilities.readImage(Constants.SWATTER_2_PATH);
        imgsNormal.add(imageIcon1.getImage());
        imgsNormal.add(imageIcon2.getImage());
        imgsNormal.add(imageIcon3.getImage());
        imgsNormal.add(imageIcon4.getImage());
        imgsSwat = new ArrayList<>();
        imageIcon1 = Utilities.readImage(Constants.SWATTER_1_PATH);
        imageIcon2 = Utilities.readImage(Constants.SWATTER_2_PATH);
        imageIcon3 = Utilities.readImage(Constants.SWATTER_3_PATH);
        imageIcon4 = Utilities.readImage(Constants.SWATTER_4_PATH);
        ImageIcon imageIcon5 = Utilities.readImage(Constants.SWATTER_2_PATH);
        imgsSwat.add(imageIcon1.getImage());
        imgsSwat.add(imageIcon2.getImage());
        imgsSwat.add(imageIcon3.getImage());
        imgsSwat.add(imageIcon4.getImage());
        imgsSwat.add(imageIcon5.getImage());
        normalAnimation = false;
        swatAnimation = false;
    }

    public Image getImg() {
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
        return imgsSwat.get(0);
    }
    
    public void setNormalAnimation(boolean normalAnimation) {
        this.normalAnimation = normalAnimation;
    }

    public void setSwatAnimation(boolean swatAnimation) {
        this.swatAnimation = swatAnimation;
    }
}
