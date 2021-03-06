package me.koala.enigma;

import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import javafx.scene.text.Text;

import java.util.*;

public class Plugboard {

    public AnchorPane rootPane;

    public StackPane oneStack;
    public StackPane twoStack;
    public StackPane threeStack;
    public StackPane fourStack;
    public StackPane fiveStack;
    public StackPane sixStack;
    public StackPane sevenStack;
    public StackPane eightStack;
    public StackPane nineStack;
    public StackPane zeroStack;
    public StackPane tabStack;
    public StackPane qStack;
    public StackPane wStack;
    public StackPane eStack;
    public StackPane rStack;
    public StackPane tStack;
    public StackPane yStack;
    public StackPane uStack;
    public StackPane iStack;
    public StackPane oStack;
    public StackPane pStack;
    public StackPane aStack;
    public StackPane sStack;
    public StackPane dStack;
    public StackPane fStack;
    public StackPane gStack;
    public StackPane hStack;
    public StackPane jStack;
    public StackPane kStack;
    public StackPane lStack;
    public StackPane zStack;
    public StackPane xStack;
    public StackPane cStack;
    public StackPane vStack;
    public StackPane bStack;
    public StackPane nStack;
    public StackPane mStack;
    public StackPane spaceStack;

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

    private List<Plug> plugs;
    private final Map<Plug, Line> plugLines = new HashMap<>();
    private final Map<Integer, Shape> indexedShapes = new HashMap<>();

    public Line currentLine;

    private Plug currentPlug;

    private boolean darkMode;

    public void initialize() {
        indexedShapes.put(0, oneCirc);
        indexedShapes.put(1, twoCirc);
        indexedShapes.put(2, threeCirc);
        indexedShapes.put(3, fourCirc);
        indexedShapes.put(4, fiveCirc);
        indexedShapes.put(5, sixCirc);
        indexedShapes.put(6, sevenCirc);
        indexedShapes.put(7, eightCirc);
        indexedShapes.put(8, nineCirc);
        indexedShapes.put(9, zeroCirc);
        indexedShapes.put(10, qCirc);
        indexedShapes.put(11, wCirc);
        indexedShapes.put(12, eCirc);
        indexedShapes.put(13, rCirc);
        indexedShapes.put(14, tCirc);
        indexedShapes.put(15, yCirc);
        indexedShapes.put(16, uCirc);
        indexedShapes.put(17, iCirc);
        indexedShapes.put(18, oCirc);
        indexedShapes.put(19, pCirc);

        indexedShapes.put(20, aCirc);
        indexedShapes.put(21, sCirc);
        indexedShapes.put(22, dCirc);
        indexedShapes.put(23, fCirc);
        indexedShapes.put(24, gCirc);
        indexedShapes.put(25, hCirc);
        indexedShapes.put(26, jCirc);
        indexedShapes.put(27, kCirc);
        indexedShapes.put(28, lCirc);

        indexedShapes.put(29, zCirc);
        indexedShapes.put(30, xCirc);
        indexedShapes.put(31, cCirc);
        indexedShapes.put(32, vCirc);
        indexedShapes.put(33, bCirc);
        indexedShapes.put(34, nCirc);
        indexedShapes.put(35, mCirc);

        indexedShapes.put(36, tabCirc);
        indexedShapes.put(37, spaceCirc);
    }

    public void setDarkMode(boolean darkMode) {
        this.darkMode = darkMode;
        if (darkMode) {
            rootPane.setBackground(new Background(new BackgroundFill(Color.web("#444"), CornerRadii.EMPTY, Insets.EMPTY)));
            indexedShapes.forEach((k, v) -> {
                v.fillProperty().setValue(Constants.darkUnlitColor);
                Text text = getTextChild((Pane) v.getParent());
                if (text != null)
                    text.fillProperty().setValue(Color.web("#eee"));
            });
        }
    }

    public void initData(List<Plug> plugs) {
        this.plugs = Objects.requireNonNullElseGet(plugs, ArrayList::new);
        Iterator<Plug> iterator = this.plugs.iterator();
        while (iterator.hasNext()) {
            Plug plug = iterator.next();
            if (plug == null || plug.getConnection1() == -1 || plug.getConnection2() == -1 || plug.getPlugColor() == null) {
                iterator.remove();
                continue;
            }
            Shape c1s = indexedShapes.get(plug.getConnection1());
            Shape c2s = indexedShapes.get(plug.getConnection2());

            Bounds c1b = c1s.localToScene(c1s.getLayoutBounds());
            Bounds c2b = c2s.localToScene(c2s.getLayoutBounds());

            Line line = new Line(c1b.getCenterX(), c1b.getCenterY(), c2b.getCenterX(), c2b.getCenterY());
            line.strokeProperty().setValue(plug.getPlugColor());
            line.strokeWidthProperty().setValue(5);

            c1s.fillProperty().setValue(plug.getPlugColor());
            c2s.fillProperty().setValue(plug.getPlugColor());

            plugLines.put(plug, line);
            rootPane.getChildren().add(line);
        }
    }

    public void updateLine(MouseEvent event) {
        if (currentLine != null) {
            currentLine.setEndX(event.getSceneX());
            currentLine.setEndY(event.getSceneY());
        }
    }

    private Shape getCircleChild(Pane pane) {
        for (Node n : pane.getChildren()) {
            if (n instanceof Circle || n instanceof Ellipse) {
                return (Shape) n;
            }
        }
        return null;
    }

    private Text getTextChild(Pane pane) {
        for (Node n : pane.getChildren()) {
            if (n instanceof Text) {
                return (Text) n;
            }
        }
        return null;
    }

    public void dragStart(MouseEvent event) {
        Pane source = (Pane) event.getSource();

        if (currentLine != null) {
            rootPane.getChildren().remove(currentLine);
        }

        if (currentPlug != null) {
            if (currentPlug.getConnection1() != -1)
                indexedShapes.get(currentPlug.getConnection1()).fillProperty().setValue(darkMode ? Constants.darkUnlitColor : Constants.unlitColor);
            if (plugLines.containsKey(currentPlug) && plugLines.get(currentPlug) != null) {
                rootPane.getChildren().remove(plugLines.get(currentPlug));
                plugLines.remove(currentPlug);
            }
            currentPlug.clear();
        }

        currentLine = new Line();
        Color plugColor = Constants.randomPlugColor();
        currentLine.strokeWidthProperty().setValue(5);
        currentLine.setMouseTransparent(true);

        currentPlug = new Plug();
        currentPlug.setPlugColor(plugColor);

        Text text = getTextChild(source);
        if (text != null) {
            String t = text.getText().toLowerCase(Locale.ROOT);
            t = t.replaceAll("tab", "\t").replaceAll("space", " ");
            int i = Constants.allowedKeys.indexOf(t);
            if (i != -1) {
                currentPlug.setConnection1(i);
                handleExistingPlugs(i);
            } else {
                System.out.println("shouldn't be here");
                // TODO maybe error check, should never get here
                return;
            }
        }

        currentLine.strokeProperty().setValue(currentPlug.getPlugColor());
        Shape dragStartNode = indexedShapes.get(currentPlug.getConnection1());

        if (dragStartNode != null)
            dragStartNode.fillProperty().set(currentPlug.getPlugColor());

        plugLines.put(currentPlug, currentLine);

        Bounds bounds = source.localToScene(source.getLayoutBounds());
        double startX = bounds.getCenterX();
        double startY = bounds.getCenterY();

        currentLine.setStartX(startX);
        currentLine.setStartY(startY);

        currentLine.setEndX(event.getSceneX());
        currentLine.setEndY(event.getSceneY());

        rootPane.getChildren().add(currentLine);

        source.startFullDrag();
    }

    public void dragEnd(MouseEvent event) {
        Node eSource = (Node) event.getSource();
        Pane root = (Pane) eSource.getScene().getRoot();

        if (currentLine != null) {
            Bounds bounds = eSource.localToScene(eSource.getLayoutBounds());
            if (eSource.equals(currentLine) || bounds.getCenterX() == currentLine.getStartX() && bounds.getCenterY() == currentLine.getStartY()) {
                root.getChildren().remove(currentLine);
                if (currentPlug.getConnection1() != -1)
                    indexedShapes.get(currentPlug.getConnection1()).fillProperty().setValue(Constants.unlitColor);
                if (currentPlug.getConnection2() != -1)
                    indexedShapes.get(currentPlug.getConnection2()).fillProperty().setValue(Constants.unlitColor);
                currentPlug.clear();
                plugLines.remove(currentPlug);
                currentPlug = null;
                currentLine = null;
                return;
            }

            Pane source = (Pane) eSource;

            Text text = getTextChild(source);
            if (text != null) {
                String t = text.getText().toLowerCase(Locale.ROOT);
                t = t.replaceAll("tab", "\t").replaceAll("space", " ");
                int i = Constants.allowedKeys.indexOf(t);
                if (i != -1) {
                    currentPlug.setConnection2(i);
                    handleExistingPlugs(i);
                }
            }

            Shape endShape = getCircleChild(source);
            if (endShape != null) {
                if (currentPlug != null) {
                    if (currentPlug.getPlugColor() != null)
                        endShape.fillProperty().set(currentPlug.getPlugColor());
                    else {
                        Color plugColor = Constants.randomPlugColor();
                        currentPlug.setPlugColor(plugColor);
                    }
                }
            }

            if (currentPlug != null) {

                plugs.add(currentPlug);
                currentPlug = null;
            }

            currentLine.setEndX(bounds.getCenterX());
            currentLine.setEndY(bounds.getCenterY());

            currentLine = null;
        }
    }

    private void handleExistingPlugs(int i) {
        Iterator<Plug> iterator = plugs.iterator();
        while (iterator.hasNext()) {
            Plug plug = iterator.next();
            if (plug.getConnection1() == i || plug.getConnection2() == i) {
                if (plug.getConnection1() != -1)
                    indexedShapes.get(plug.getConnection1()).fillProperty().setValue(darkMode ? Constants.darkUnlitColor : Constants.unlitColor);
                if (plug.getConnection2() != -1)
                    indexedShapes.get(plug.getConnection2()).fillProperty().setValue(darkMode ? Constants.darkUnlitColor : Constants.unlitColor);
                if (plugLines.containsKey(plug) && plugLines.get(plug) != null) {
                    rootPane.getChildren().remove(plugLines.get(plug));
                    plugLines.remove(plug);
                }

                plug.clear();
                iterator.remove();
            }

        }
    }

    public List<Plug> getReturnData() {
        return this.plugs;
    }
}
