package DriverPackage;


import SolvingBFS.*;
import SolvingDFS.*;
import SolvingIDAStar.IDAStar;
import SolvingIDS.IDS;
import SolvingAStar.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Driver extends Application {
	public final static int QUEEN_SIZE = 9;
	final int WIDTH =50;
	final int HEIGHT = 50;
	int[] positoin = new int[QUEEN_SIZE];
	int [] temp = new int[QUEEN_SIZE];
	@Override
	public void start(Stage stage) {
		VBox pane = new VBox(6);

		pane.setBackground(new Background(new BackgroundFill(Color.SLATEGRAY, CornerRadii.EMPTY, Insets.EMPTY)));

		GridPane plane = new GridPane();
		plane.setAlignment(Pos.CENTER);
		plane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
		plane.setHgap(5.5);
		plane.setVgap(5.5);

		drowPlane(plane);

		RecButton genarateRandom = new RecButton("Generate Random Pattern", Color.ALICEBLUE, 530, 40);

		genarateRandom.setOnMouseClicked(e -> {
			drowPlane(plane);
			generateRandomPattern(plane);
		});
		
		HBox solve = solveMethodButton(plane);

		RecButton exit = new RecButton("Exit", Color.ALICEBLUE, 530, 40);
		exit.setOnMouseClicked(e -> {
			stage.close();
		});
		pane.getChildren().addAll(plane, genarateRandom, solve, exit);
		Scene scene = new Scene(pane);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.setTitle("N-Queen");
		stage.getIcons().add(new Image("./img/queen.png"));
		stage.show();

	}

	private HBox solveMethodButton(GridPane plane) {

		HBox solvePane = new HBox(7);
		solvePane.setAlignment(Pos.CENTER);

		RecButton BFS = new RecButton("BFS", Color.ALICEBLUE, 100, 40);
		BFS.setOnMouseClicked(e -> {
			temp=positoin.clone();
			Double start = (double) System.currentTimeMillis();
			BFS pfs = new BFS(temp);
			Double finsh = (double) System.currentTimeMillis();
			drowPlane(plane);
			temp = pfs.getPositon();
			drowNewGetPositon(plane);
			

			new Alert(AlertType.INFORMATION, "Solution Found in "+(finsh - start)/1000+" Sec.").showAndWait();
		});

		RecButton DFS = new RecButton("DFS", Color.ALICEBLUE, 100, 40);
		DFS.setOnMouseClicked(e -> {
			temp=positoin.clone();
			Double start = (double) System.currentTimeMillis();
			DFS dfs = new DFS(temp);
			Double finsh = (double) System.currentTimeMillis();
			drowPlane(plane);
			temp = dfs.getPositon();
			drowNewGetPositon(plane);
			
			new Alert(AlertType.INFORMATION, "Solution Found in "+(finsh - start)/1000+" Sec.").showAndWait();

		});

		RecButton AStar = new RecButton("A*", Color.ALICEBLUE, 100, 40);
		AStar.setOnMouseClicked(e -> {
			temp=positoin.clone();
			Double start = (double) System.currentTimeMillis();
			AStar aStar = new AStar(temp);
			Double finsh = (double) System.currentTimeMillis();
			drowPlane(plane);
			temp = aStar.getPositon();
			drowNewGetPositon(plane);
			
			
			new Alert(AlertType.INFORMATION, "Solution Found in "+(finsh - start)/1000+" Sec.").showAndWait();
			
			

		});
		RecButton IDS = new RecButton("IDS", Color.ALICEBLUE, 100, 40);
		IDS.setOnMouseClicked(e -> {
			
			temp=positoin.clone();
			Double start = (double) System.currentTimeMillis();
			IDS ids = new IDS(temp);
			Double finsh = (double) System.currentTimeMillis();
			drowPlane(plane);
			temp = ids.getPositon();
			drowNewGetPositon(plane);
			new Alert(AlertType.INFORMATION, "Solution Found in "+(finsh - start)/1000+" Sec.").showAndWait();


		});
		RecButton IDAStar = new RecButton("IDA*", Color.ALICEBLUE, 100, 40);
		IDAStar.setOnMouseClicked(e -> {
			temp=positoin.clone();
			Double start = (double) System.currentTimeMillis();
			IDAStar idaStar = new IDAStar(temp);
			Double finsh = (double) System.currentTimeMillis();
			drowPlane(plane);
			temp = idaStar.getPositon();
			drowNewGetPositon(plane);
			
			new Alert(AlertType.INFORMATION, "Solution Found in "+(finsh - start)/1000+" Sec.").showAndWait();


		});

		solvePane.getChildren().addAll(BFS, DFS, AStar, IDS, IDAStar);
		return solvePane;
	}

	private void drowPlane(GridPane plane) {
		plane.getChildren().clear();
		for (int i = 0; i < QUEEN_SIZE; i++) {
			boolean isWhite = i % 2 == 1;
			for (int j = 0; j < QUEEN_SIZE; j++) {

				Rectangle rectangle = new Rectangle(WIDTH, HEIGHT);

				rectangle.setStroke(Color.BLACK);

				if (isWhite) {
					rectangle.setFill(Color.WHITE);
				} else {
					rectangle.setFill(Color.BLACK);
				}

				isWhite = !isWhite;

				plane.add(rectangle, i, j);

			}

		}

	}

	public void generateRandomPattern(GridPane plane) {
		
		int aa[]={3,5,4,4,7,6,2,5};
		
		for (int i = 0; i < QUEEN_SIZE; i++) {

			// t'3eer
			Image image = new Image("./img/queen.png", 50, 50, true, true);

			ImageView imageView = new ImageView(image);
			int randomNum = 0 + (int) (Math.random() * QUEEN_SIZE);
			positoin[i] = randomNum;
			plane.add(imageView, randomNum, i);
			//System.out.println(randomNum);
			GridPane.setHalignment(imageView, HPos.CENTER);

		}

	}

	private void drowNewGetPositon(GridPane plane) {
		for (int i = 0; i < temp.length; i++) {
			Image image = new Image("./img/queen.png", 50, 50, true, true);

			ImageView imageView = new ImageView(image);
			plane.add(imageView, temp[i], i);
			GridPane.setHalignment(imageView, HPos.CENTER);
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}