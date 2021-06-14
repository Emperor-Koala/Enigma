package me.koala.enigma;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Text;

import java.util.*;

@SuppressWarnings({"unused"})
public class KeyboardController {

    private final String allowedKeys = "1234567890qwertyuiopasdfghjklzxcvbnm\t ";
    private final Color litColor = new Color(1, ((double) 0xE9)/0xFF, ((double) 0x8E)/0xFF, 1);
    private final Color unlitColor = new Color(((double) 0xBB)/0xFF, ((double) 0xBB)/0xFF, ((double) 0xBB)/0xFF, 1);

    KeyCode keyDown = null;
    char litKey = '?';

    Rotor rotor1;
    Rotor rotor2;
    Rotor rotor3;
    private final End end = new End();

    public Button editPlugboardBtn;

    public Button rotorThreeName;
    public Button rotorTwoName;
    public Button rotorOneName;

    public Text rotorThreePosition;
    public Button rotorThreePosUpBtn;
    public Button rotorThreePosDownBtn;

    public Text rotorTwoPosition;
    public Button rotorTwoPosUpBtn;
    public Button rotorTwoPosDownBtn;

    public Text rotorOnePosition;
    public Button rotorOnePosUpBtn;
    public Button rotorOnePosDownBtn;

    public Circle oneCirc;
    public Circle twoCirc;
    public Circle threeCirc;
    public Circle fourCirc;
    public Circle fiveCirc;
    public Circle sixCirc;
    public Circle sevenCirc;
    public Circle eightCirc;
    public Circle nineCirc;
    public Circle zeroCirc;
    public Ellipse tabCirc;
    public Circle qCirc;
    public Circle wCirc;
    public Circle eCirc;
    public Circle rCirc;
    public Circle tCirc;
    public Circle yCirc;
    public Circle uCirc;
    public Circle iCirc;
    public Circle oCirc;
    public Circle pCirc;
    public Circle aCirc;
    public Circle sCirc;
    public Circle dCirc;
    public Circle fCirc;
    public Circle gCirc;
    public Circle hCirc;
    public Circle jCirc;
    public Circle kCirc;
    public Circle lCirc;
    public Circle zCirc;
    public Circle xCirc;
    public Circle cCirc;
    public Circle vCirc;
    public Circle bCirc;
    public Circle nCirc;
    public Circle mCirc;
    public Ellipse spaceCirc;

    public TextField output;
    public Button resetOutputButton;

    public void resetOutput(ActionEvent event) {
        output.setText("");
    }

    public void initialize() {
        randomRotors();
        randomPositions();
    }

    void randomRotors() {
        Random rand = new Random();
        int rand1 = rand.nextInt(5);
        int rand2 = rand.nextInt(5);
        while (rand1 == rand2) {
            rand2 = rand.nextInt(5);
        }

        int rand3 = rand.nextInt(5);
        while (rand1 == rand3 || rand2 == rand3) {
            rand3 = rand.nextInt(5);
        }
        setRotors(rand1, rand2, rand3);
    }


    void randomPositions() {
        Random rand = new Random();
        setRotorPositions(rand.nextInt(rotor1.wiring.length), rand.nextInt(rotor2.wiring.length), rand.nextInt(rotor3.wiring.length));
    }

    public void setRotors(int first, int second, int third) {
        if (first != second && first != third && second != third) {
            rotor1 = new Rotor(first, 1);
            rotorOnePosition.setText(rotor1.position + "");
            rotorOneName.setText(rotor1.rotorNo + "");
            rotor2 = new Rotor(second, 2);
            rotorTwoPosition.setText(rotor2.position + "");
            rotorTwoName.setText(rotor2.rotorNo + "");
            rotor3 = new Rotor(third, 3);
            rotorThreePosition.setText(rotor3.position + "");
            rotorThreeName.setText(rotor3.rotorNo + "");
        }
    }

    public void setRotorPositions(int first, int second, int third) {
        rotor1.position = first;
        rotorOnePosition.setText(rotor1.position + "");
        rotor2.position = second;
        rotorTwoPosition.setText(rotor2.position + "");
        rotor3.position = third;
        rotorThreePosition.setText(rotor3.position + "");
    }

    void moveRotors() {
        rotor1.position +=1;
        if (rotor1.position == rotor1.wiring.length) {
            rotor1.position = 0;
            rotor2.position+=1;
            if (rotor2.position == rotor2.wiring.length) {
                rotor2.position = 0;
                rotor3.position+=1;
                if (rotor3.position == rotor3.wiring.length) {
                    rotor3.position = 0;
                }
            }
        }
        rotorOnePosition.setText(rotor1.position + "");
        rotorTwoPosition.setText(rotor2.position + "");
        rotorThreePosition.setText(rotor3.position + "");
    }

    public void openPlugboard(ActionEvent event) {

    }

    public void keyPressedListener(KeyEvent key) {
        if (keyDown == null && allowedKeys.contains(key.getText().toLowerCase(Locale.ROOT))) {
            char output = runMachine(key.getText().toLowerCase(Locale.ROOT).charAt(0));
            if (output == '?') return;
            setKey(output, litColor);
            keyDown = key.getCode();
            litKey = output;
            this.output.setText(this.output.getText() + (output == ' ' ? "-" : output == '\t' ? "=" : output));
        }
    }

    public void keyReleasedListener(KeyEvent key) {
        if (keyDown != null && keyDown.equals(key.getCode())) {
            setKey(litKey, unlitColor);
            keyDown = null;
        }
    }

    private void setKey(char key, Color color) {
        switch (key) {
            case 'a':
                aCirc.fillProperty().set(color);
                break;
            case 'b':
                bCirc.fillProperty().set(color);
                break;
            case 'c':
                cCirc.fillProperty().set(color);
                break;
            case 'd':
                dCirc.fillProperty().set(color);
                break;
            case 'e':
                eCirc.fillProperty().set(color);
                break;
            case 'f':
                fCirc.fillProperty().set(color);
                break;
            case 'g':
                gCirc.fillProperty().set(color);
                break;
            case 'h':
                hCirc.fillProperty().set(color);
                break;
            case 'i':
                iCirc.fillProperty().set(color);
                break;
            case 'j':
                jCirc.fillProperty().set(color);
                break;
            case 'k':
                kCirc.fillProperty().set(color);
                break;
            case 'l':
                lCirc.fillProperty().set(color);
                break;
            case 'm':
                mCirc.fillProperty().set(color);
                break;
            case 'n':
                nCirc.fillProperty().set(color);
                break;
            case 'o':
                oCirc.fillProperty().set(color);
                break;
            case 'p':
                pCirc.fillProperty().set(color);
                break;
            case 'q':
                qCirc.fillProperty().set(color);
                break;
            case 'r':
                rCirc.fillProperty().set(color);
                break;
            case 's':
                sCirc.fillProperty().set(color);
                break;
            case 't':
                tCirc.fillProperty().set(color);
                break;
            case 'u':
                uCirc.fillProperty().set(color);
                break;
            case 'v':
                vCirc.fillProperty().set(color);
                break;
            case 'w':
                wCirc.fillProperty().set(color);
                break;
            case 'x':
                xCirc.fillProperty().set(color);
                break;
            case 'y':
                yCirc.fillProperty().set(color);
                break;
            case 'z':
                zCirc.fillProperty().set(color);
                break;
            case '0':
                zeroCirc.fillProperty().set(color);
                break;
            case '1':
                oneCirc.fillProperty().set(color);
                break;
            case '2':
                twoCirc.fillProperty().set(color);
                break;
            case '3':
                threeCirc.fillProperty().set(color);
                break;
            case '4':
                fourCirc.fillProperty().set(color);
                break;
            case '5':
                fiveCirc.fillProperty().set(color);
                break;
            case '6':
                sixCirc.fillProperty().set(color);
                break;
            case '7':
                sevenCirc.fillProperty().set(color);
                break;
            case '8':
                eightCirc.fillProperty().set(color);
                break;
            case '9':
                nineCirc.fillProperty().set(color);
                break;
            case ' ':
                spaceCirc.fillProperty().set(color);
                break;
            case '\t':
                tabCirc.fillProperty().set(color);
                break;
        }
    }

    private char runMachine(char c) {
        if (rotor1.rotorNo == rotor2.rotorNo || rotor3.rotorNo == rotor2.rotorNo  || rotor1.rotorNo == rotor3.rotorNo ) {
            System.out.println("Error rotors cannot have the same number");
            return '?';
        }

        int currentNo = allowedKeys.indexOf(c);
//        currentNo = plugBoard.runThrough(currentNo);
        currentNo = rotor1.runThrough(currentNo, true);
        currentNo = rotor2.runThrough(currentNo, true);
        currentNo = rotor3.runThrough(currentNo, true);
        currentNo = end.runThrough(currentNo);
        currentNo = rotor3.runThrough(currentNo, false);
        currentNo = rotor2.runThrough(currentNo, false);
        currentNo = rotor1.runThrough(currentNo, false);
//        currentNo = plugBoard.runThrough(currentNo);
        if (currentNo == -1) {
            System.out.println(rotor1.position + ", " + rotor2.position + ", " + rotor3.position);
        }
        moveRotors();

        return allowedKeys.charAt(currentNo);
    }

    public void rotorThreePosUp(ActionEvent event) {
        setRotorPositions(rotor1.position, rotor2.position, (rotor3.position+1)%rotor3.wiring.length);
    }
    public void rotorThreePosDown(ActionEvent event) {
        int newPos = (rotor3.position-1);
        if (newPos < 0) newPos = rotor3.wiring.length-1;
        setRotorPositions(rotor1.position, rotor2.position, newPos);
    }

    public void rotorTwoPosUp(ActionEvent event) {
        setRotorPositions(rotor1.position, (rotor2.position+1)%rotor2.wiring.length, rotor3.position);
    }
    public void rotorTwoPosDown(ActionEvent event) {
        int newPos = (rotor2.position-1);
        if (newPos < 0) newPos = rotor2.wiring.length-1;
        setRotorPositions(rotor1.position, newPos, rotor3.position);
    }

    public void rotorOnePosUp(ActionEvent event) {
        setRotorPositions((rotor1.position+1)%rotor1.wiring.length, rotor2.position, rotor3.position);
    }
    public void rotorOnePosDown(ActionEvent event) {
        int newPos = (rotor1.position-1);
        if (newPos < 0) newPos = rotor1.wiring.length-1;
        setRotorPositions(newPos, rotor2.position, rotor3.position);
    }

    public void rotorThreeNext(ActionEvent event) {
        int ogNo = rotor3.rotorNo;
        rotor3.nextRotor();
        while (rotor3.rotorNo != ogNo && (rotor3.rotorNo == rotor1.rotorNo || rotor3.rotorNo == rotor2.rotorNo))
            rotor3.nextRotor();
        rotorThreeName.setText("" + rotor3.rotorNo);
    }

    public void rotorTwoNext(ActionEvent event) {
        int ogNo = rotor2.rotorNo;
        rotor2.nextRotor();
        while (rotor2.rotorNo != ogNo && (rotor2.rotorNo == rotor1.rotorNo || rotor2.rotorNo == rotor3.rotorNo))
            rotor2.nextRotor();
        rotorTwoName.setText("" + rotor2.rotorNo);
    }

    public void rotorOneNext(ActionEvent event) {
        int ogNo = rotor1.rotorNo;
        rotor1.nextRotor();
        while (rotor1.rotorNo != ogNo && (rotor1.rotorNo == rotor3.rotorNo || rotor1.rotorNo == rotor2.rotorNo))
            rotor1.nextRotor();
        rotorOneName.setText("" + rotor1.rotorNo);
    }

    private static class Rotor {
        int[][] wiring;
        int position = 0;
        int rotorNo;
        int rotorPos;

        Rotor(int rotorNumber, int rotorPosition) {
            rotorNo = rotorNumber;
            rotorPos = rotorPosition;
            updateWiring();
        }

        private void updateWiring() {
            switch(rotorNo) {
                case 0:
                    wiring = new int[][] {{0, 5}, {1, 34}, {2, 4}, {3, 0}, {4, 3}, {5, 6}, {6, 37}, {7, 8}, {8, 22}, {9, 29}, {10, 2}, {11, 26}, {12, 25}, {13, 31}, {14, 27}, {15, 32}, {16, 7}, {17, 23}, {18, 35}, {19, 11}, {20, 18}, {21, 30}, {22, 28}, {23, 36}, {24, 16}, {25, 15}, {26, 19}, {27, 20}, {28, 24}, {29, 9}, {30, 1}, {31, 21}, {32, 17}, {33, 13}, {34, 10}, {35, 33}, {36, 14}, {37, 12}};
                    break;
                case 1:
                    wiring = new int[][] {{0, 12}, {1, 25}, {2, 32}, {3, 10}, {4, 26}, {5, 20}, {6, 9}, {7, 35}, {8, 37}, {9, 6}, {10, 19}, {11, 34}, {12, 2}, {13, 4}, {14, 7}, {15, 3}, {16, 22}, {17, 33}, {18, 29}, {19, 13}, {20, 30}, {21, 14}, {22, 8}, {23, 24}, {24, 28}, {25, 23}, {26, 18}, {27, 15}, {28, 27}, {29, 0}, {30, 21}, {31, 1}, {32, 36}, {33, 31}, {34, 5}, {35, 16}, {36, 11}, {37, 17}};
                    break;
                case 2:
                    wiring = new int[][] {{0, 27}, {1, 34}, {2, 26}, {3, 31}, {4, 11}, {5, 28}, {6, 29}, {7, 8}, {8, 5}, {9, 1}, {10, 13}, {11, 35}, {12, 37}, {13, 0}, {14, 7}, {15, 33}, {16, 19}, {17, 30}, {18, 3}, {19, 23}, {20, 10}, {21, 4}, {22, 21}, {23, 20}, {24, 18}, {25, 14}, {26, 32}, {27, 9}, {28, 17}, {29, 22}, {30, 6}, {31, 16}, {32, 24}, {33, 12}, {34, 25}, {35, 2}, {36, 15}, {37, 36}};
                    break;
                case 3:
                    wiring = new int[][] {{0, 32}, {1, 33}, {2, 22}, {3, 35}, {4, 7}, {5, 19}, {6, 30}, {7, 2}, {8, 29}, {9, 10}, {10, 9}, {11, 36}, {12, 37}, {13, 27}, {14, 11}, {15, 13}, {16, 1}, {17, 4}, {18, 5}, {19, 17}, {20, 34}, {21, 31}, {22, 0}, {23, 14}, {24, 6}, {25, 8}, {26, 21}, {27, 3}, {28, 24}, {29, 28}, {30, 26}, {31, 18}, {32, 25}, {33, 20}, {34, 12}, {35, 16}, {36, 15}, {37, 23}};
                    break;
                case 4:
                    wiring = new int[][] {{0, 2}, {1, 30}, {2, 7}, {3, 22}, {4, 6}, {5, 36}, {6, 1}, {7, 32}, {8, 27}, {9, 3}, {10, 15}, {11, 35}, {12, 34}, {13, 14}, {14, 20}, {15, 17}, {16, 31}, {17, 11}, {18, 10}, {19, 24}, {20, 28}, {21, 25}, {22, 4}, {23, 13}, {24, 8}, {25, 33}, {26, 21}, {27, 37}, {28, 0}, {29, 12}, {30, 23}, {31, 19}, {32, 16}, {33, 18}, {34, 5}, {35, 9}, {36, 26}, {37, 29}};
                    break;
            }
        }

        int runThrough(int input, boolean forward) {

            if (forward) {
                input = (input + position) % wiring.length;

                return wiring[input][1];
            } else {
                for (int[] ints : wiring) {
                    if (input == ints[1]) {
                        int output = (ints[0] - position);
                        while (output < 0) {
                            output = wiring.length + output;
                        }
                        output = output % wiring.length;

                        return output;
                    }
                }
            }
            return -1;
        }

        void nextRotor() {
            rotorNo = (rotorNo+1)%5;
            updateWiring();
        }
    }
}

class End {
    private final int[][] wiring = {{0, 7}, {1, 25}, {2, 33}, {3, 10}, {4, 23}, {5, 6}, {6, 5}, {7, 0}, {8, 17}, {9, 36}, {10, 3}, {11, 28}, {12, 32}, {13, 24}, {14, 35}, {15, 21}, {16, 34}, {17, 8}, {18, 31}, {19, 30}, {20, 29}, {21, 15}, {22, 27}, {23, 4}, {24, 13}, {25, 1}, {26, 37}, {27, 22}, {28, 11}, {29, 20}, {30, 19}, {31, 18}, {32, 12}, {33, 2}, {34, 16}, {35, 14}, {36, 9}, {37, 26}};
    int runThrough(int input) {
        return wiring[input%wiring.length][1];
    }
}