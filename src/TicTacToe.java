import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class TicTacToe extends Application{
	TicTacToeGrid grid;
	TabPane tabPane;
	
	public void start(Stage stage)
	{
		grid = new TicTacToeGrid();
		
		StackPane root = new StackPane();
		
		tabPane = new TabPane();

        Tab tab1 = new Tab();
        tab1.setText("Tic Tac Toe Game");
        tab1.setContent(grid);
        
        tabPane.getSelectionModel().select(0);
        tabPane.getTabs().addAll(tab1);
		
		root.getChildren().add(grid);
		
		// Create a scene and place rootPane in the stage
	      Scene scene = new Scene(root, 600, 600);
	      stage.setTitle("Tic Tac Toe"); 
	      stage.setScene(scene); // Place the scene in the stage
	      stage.show(); // Display the stage
	}
	
	public static void main (String[] args)
	{
		launch(args);
	}
	
	public boolean winTicTacToe(int[] filledSquares)
	{
		return true;
	}
}