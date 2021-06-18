package me.koala.enigma;

import javafx.scene.paint.Color;

import java.util.Random;

public class Constants {

    public static final String allowedKeys = "1234567890qwertyuiopasdfghjklzxcvbnm\t ";
    public static final Color litColor = Color.web("#FFE98E");
    public static final Color unlitColor = Color.web("#BBB");

    public static final Color darkLitColor = Color.web("#BA9B31");
    public static final Color darkUnlitColor = Color.web("#333");

    public static Color randomPlugColor() {
        Random rand = new Random();
        double valMin = 0.5;
        double r = (valMin * rand.nextDouble()) + valMin;
        double g = (valMin * rand.nextDouble()) + valMin;
        double b = (valMin * rand.nextDouble()) + valMin;
        return new Color(r, g, b, 1);
    }

}
