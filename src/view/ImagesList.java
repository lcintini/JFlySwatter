package view;

import constants.Constants;
import utilities.Direction;
import utilities.Utilities;

import javax.swing.*;
import java.awt.*;

import static utilities.Direction.*;

public class ImagesList {
    private static ImageIcon FLY_1;
    private static ImageIcon FLY_2;
    private static ImageIcon FLY_3;
    private static ImageIcon BUTTERFLY_1;
    private static ImageIcon BUTTERFLY_2;
    private static ImageIcon BUTTERFLY_3;
    private static ImageIcon BUTTERFLY_4;
    private static ImageIcon COCKROACH_1;
    private static ImageIcon COCKROACH_2;
    private static ImageIcon COCKROACH_3;
    private static ImageIcon COCKROACH_4;
    private static ImageIcon COCKROACH_5;
    private static ImageIcon COCKROACH_6;
    private static ImageIcon LADYBUG_1;
    private static ImageIcon LADYBUG_2;
    private static ImageIcon LADYBUG_3;
    private static ImageIcon LADYBUG_4;
    private static ImageIcon LADYBUG_5;
    private static ImageIcon WASP_1;
    private static ImageIcon WASP_2;

    public static void preloadImages(){
        FLY_1 = Utilities.readImage(Constants.FLY_1_PATH);
        FLY_2 = Utilities.readImage(Constants.FLY_2_PATH);
        FLY_3 = Utilities.readImage(Constants.FLY_2_PATH);
        BUTTERFLY_1 = Utilities.readImage(Constants.BUTTERFLY_1_PATH);
        BUTTERFLY_2 = Utilities.readImage(Constants.BUTTERFLY_2_PATH);
        BUTTERFLY_3 = Utilities.readImage(Constants.BUTTERFLY_2_PATH);
        BUTTERFLY_4 = Utilities.readImage(Constants.BUTTERFLY_4_PATH);
        COCKROACH_1 = Utilities.readImage(Constants.COCKROACH_1_PATH);
        COCKROACH_2 = Utilities.readImage(Constants.COCKROACH_2_PATH);
        COCKROACH_3 = Utilities.readImage(Constants.COCKROACH_3_PATH);
        COCKROACH_4 = Utilities.readImage(Constants.COCKROACH_4_PATH);
        COCKROACH_5 = Utilities.readImage(Constants.COCKROACH_5_PATH);
        COCKROACH_6 = Utilities.readImage(Constants.COCKROACH_6_PATH);
        LADYBUG_1 = Utilities.readImage(Constants.LADYBUG_1_PATH);
        LADYBUG_2 = Utilities.readImage(Constants.LADYBUG_2_PATH);
        LADYBUG_3 = Utilities.readImage(Constants.LADYBUG_2_PATH);
        LADYBUG_4 = Utilities.readImage(Constants.LADYBUG_4_PATH);
        LADYBUG_5 = Utilities.readImage(Constants.LADYBUG_5_PATH);
        WASP_1 = Utilities.readImage(Constants.WASP_1_PATH);
        WASP_2 = Utilities.readImage(Constants.WASP_2_PATH);
    }

    public static Image getImage(String imagePath) {
        switch (imagePath) {
            case Constants.FLY_1_PATH -> {
                return FLY_1.getImage();
            }
            case Constants.FLY_2_PATH -> {
                return FLY_2.getImage();
            }
            case Constants.FLY_3_PATH -> {
                return FLY_3.getImage();
            }
            case Constants.BUTTERFLY_1_PATH -> {
                return BUTTERFLY_1.getImage();
            }
            case Constants.BUTTERFLY_2_PATH -> {
                return BUTTERFLY_2.getImage();
            }
            case Constants.BUTTERFLY_3_PATH -> {
                return BUTTERFLY_3.getImage();
            }
            case Constants.BUTTERFLY_4_PATH -> {
                return BUTTERFLY_4.getImage();
            }
            case Constants.COCKROACH_1_PATH -> {
                return COCKROACH_1.getImage();
            }
            case Constants.COCKROACH_2_PATH -> {
                return COCKROACH_2.getImage();
            }
            case Constants.COCKROACH_3_PATH -> {
                return COCKROACH_3.getImage();
            }
            case Constants.COCKROACH_4_PATH -> {
                return COCKROACH_4.getImage();
            }
            case Constants.COCKROACH_5_PATH -> {
                return COCKROACH_5.getImage();
            }
            case Constants.COCKROACH_6_PATH -> {
                return COCKROACH_6.getImage();
            }
            case Constants.LADYBUG_1_PATH -> {
                return LADYBUG_1.getImage();
            }
            case Constants.LADYBUG_2_PATH -> {
                return LADYBUG_2.getImage();
            }
            case Constants.LADYBUG_3_PATH -> {
                return LADYBUG_3.getImage();
            }
            case Constants.LADYBUG_4_PATH -> {
                return LADYBUG_4.getImage();
            }
            case Constants.LADYBUG_5_PATH -> {
                return LADYBUG_5.getImage();
            }
            case Constants.WASP_1_PATH -> {
                return WASP_1.getImage();
            }
            case Constants.WASP_2_PATH -> {
                return WASP_2.getImage();
            }
        }
        return null;
    }
}
