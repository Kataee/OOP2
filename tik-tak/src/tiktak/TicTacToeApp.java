//done with the help of https://youtu.be/Uj8rPV6JbCE
//próbáltam egyedül is, a Main és a Controller mind az én művem,
// de teljesen fordítva gondolkodom még
//a problémák megoldásának sorrendje szempontjából
// ami miatt káosz lett a fejemben, és nem is látom még át hogy hogyan épül
//fel egy UI kódból. Megpróbálom majd nxn -re átalakítani

package tiktak;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.util.Duration;


import java.util.ArrayList;
import java.util.List;

public class TicTacToeApp extends Application {

    private boolean playable = true; //decide if the game is won
                                    //set to false if somebody wins
    private boolean turnX = true; //to decide the player's turn
    private Tile[][] board = new Tile[3][3]; //3x3 -as tábla
    private List<Combo> combos = new ArrayList<>();

    //new Pane, új üres ablak, pane típusú
    Pane root = new Pane();

    private Parent createContent() {


        //ablak mérete (ajánlott mérete)
        root.setPrefSize(600, 600);


        //TilePane lays out its children in a grid of uniformly sized "tiles".
        // A horizontal tilepane (the default) will tile nodes in rows,
        // wrapping at the tilepane's width. ...
        // The alignment property controls how the rows and columns are aligned
        // within the bounds of the tilepane and defaults to Pos.
        for (int i=0; i<3; ++i) {
            for (int j=0; j<3; ++j) {
                Tile tile = new Tile();
                tile.setTranslateX(j*200);
                tile.setTranslateY(i*200);

                root.getChildren().add(tile);

                //populate the array, j=x i=y
                board[j][i] = tile;
            }
        }

        //horizontal -- sorok
        for (int y=0; y < 3; ++y) {
            combos.add(new Combo(board[0][y], board[1][y], board[2][y]));
        }

        //vertical -- oszlopok
        for (int x=0; x < 3; ++x) {
            combos.add(new Combo(board[x][0], board[x][1], board[x][2]));
        }

        //diagonals -- átlók
        combos.add(new Combo(board[0][0], board[1][1], board[2][2]));
        combos.add(new Combo(board[2][0], board[1][1], board[0][2]));
        return root;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //A Stage in JavaFX is a top-level container that hosts a Scene,
        // which consists of visual elements.

        //A scene represents the physical contents of a JavaFX application.
        // It contains all the contents of a scene graph.
        // The class Scene of the package javafx. scene represents the scene object.
        // At an instance, the scene object is added to only one stage.
        primaryStage.setScene(new Scene(createContent()));
        primaryStage.show();
    }


    private void checkState() { //check all possible winning scenarios
        for (Combo combo : combos) {
            if (combo.isComplete()) {
                playable = false;
                playWinAnimation(combo);
                break;
            }
        }
    }

    private void playWinAnimation(Combo combo) { //animation from point1 to point 2 to point 3
        Line line = new Line();
        line.setStartX(combo.tiles[0].getCenterX());
        line.setStartY(combo.tiles[0].getCenterY());

        line.setEndX(combo.tiles[0].getCenterX());
        line.setEndY(combo.tiles[0].getCenterY());

        root.getChildren().add(line);

        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(2),
                new KeyValue(line.endXProperty(), combo.tiles[2].getCenterX()),
                new KeyValue(line.endYProperty(), combo.tiles[2].getCenterY())));

        timeline.play();
    }

    private class Combo { //we will pass in 3 tiles, meaning 3 squares
        private Tile[] tiles;
        public Combo(Tile... tiles) { //constructor
            this.tiles = tiles;
        }

        public boolean isComplete() { //check for winning scenarios
            if (tiles[0].getValue().isEmpty()) {
                return false;
            }

            return tiles[0].getValue().equals(tiles[1].getValue()) &&
                    tiles[0].getValue().equals((tiles[2].getValue()));

        }
    }


    //StackPane lays out its children in a back-to-front stack.
    // The z-order of the children is defined by the order of the
    // children list with the 0th child being the bottom and last child on top. ...
    // The stackpane will attempt to resize each child to fill its content area.
    private class Tile extends StackPane { //StackPane for borders and text

        //The Text class defines a node that displays a text.
        // Paragraphs are separated by '\n' and the text is wrapped on
        // paragraph boundaries.
        private Text text = new Text(); //text = empty || X || O


        public Tile() {
            Rectangle border = new Rectangle(200,200);
            border.setFill(null); //black by default, if you set nothing, null for transparent
            border.setStroke(Color.BLACK);

            text.setFont(Font.font(72));

            setAlignment(Pos.CENTER); //alignment of every element whitin the stack pane
            getChildren().addAll(border, text); //get all stackpane objects??

            //instead of getting xy position of the cursor, we can set
            //a mouse click on the node
            setOnMouseClicked(event -> { //inherited from StackPane 's methods
                if (!playable)
                    return;


                if (event.getButton() == MouseButton.PRIMARY) { //leftClick
                    if (!turnX)
                        return;

                    drawX();
                    turnX=false;
                    checkState();
                } else if (event.getButton() == MouseButton.SECONDARY) { //rightCLick
                    if (turnX)
                        return;

                    drawO();
                    turnX=true;
                    checkState();
                }
            });
        }

        public double getCenterX() {
            return getTranslateX() + 100; //width/2 == 200/2
        }

        public double getCenterY() {
            return getTranslateY() + 100; //height/2 == 200/2
        }


        public String getValue() {
            return text.getText();
        }

        private void drawX(){
            text.setText("X");
        }
        private void drawO() {
            text.setText("O");
        }
    }


    public static void main(String[] args) {
        launch(args);

    }
}
