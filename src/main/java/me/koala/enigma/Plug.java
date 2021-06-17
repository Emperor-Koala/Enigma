package me.koala.enigma;

import javafx.scene.paint.Color;

public class Plug {
    private int connection1;
    private int connection2;

    private Color plugColor;

    public Plug() {}

    public Plug(int connection1, int connection2, Color plugColor) {
        this.connection1 = connection1;
        this.connection2 = connection2;
        this.plugColor = plugColor;
    }

    public int getConnection1() {
        return connection1;
    }

    public void setConnection1(int connection1) {
        this.connection1 = connection1;
    }

    public int getConnection2() {
        return connection2;
    }

    public void setConnection2(int connection2) {
        this.connection2 = connection2;
    }

    public void clear() {
        this.connection1 = -1;
        this.connection2 = -1;
    }

    public Color getPlugColor() {
        return plugColor;
    }

    public void setPlugColor(Color plugColor) {
        this.plugColor = plugColor;
    }
}
