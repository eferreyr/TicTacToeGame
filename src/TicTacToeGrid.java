import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import java.lang.Math;

public class TicTacToeGrid extends GridPane{
	Button upLeft,upCent, upRight, midLeft, midCent, midRight, 
			botLeft, botCent, botRight;
	boolean o;
	//0=null;1=X;2=O
	int [][] filledSquares = {
							{0,0,0},
							{0,0,0},
							{0,0,0}
							};
	
	public TicTacToeGrid()
	{
		o = true;
		
		upLeft = new Button("");
		upCent = new Button("");
		upRight = new Button("");
		midLeft = new Button("");
		midCent = new Button("");
		midRight = new Button("");
		botLeft = new Button("");
		botCent = new Button("");
		botRight = new Button("");
		
		upLeft.setStyle(String.format("-fx-font-size: %dpx;", (int)(0.30 * 200)));
		upCent.setStyle(String.format("-fx-font-size: %dpx;", (int)(0.30 * 200)));
		upRight.setStyle(String.format("-fx-font-size: %dpx;", (int)(0.30 * 200)));
		midLeft.setStyle(String.format("-fx-font-size: %dpx;", (int)(0.30 * 200)));
		midCent.setStyle(String.format("-fx-font-size: %dpx;", (int)(0.30 * 200)));
		midRight.setStyle(String.format("-fx-font-size: %dpx;", (int)(0.30 * 200)));
		botLeft.setStyle(String.format("-fx-font-size: %dpx;", (int)(0.30 * 200)));
		botCent.setStyle(String.format("-fx-font-size: %dpx;", (int)(0.30 * 200)));
		botRight.setStyle(String.format("-fx-font-size: %dpx;", (int)(0.30 * 200)));
		
		upLeft.setMinSize(200, 200);
		upCent.setMinSize(200, 200);
		upRight.setMinSize(200, 200);
		midLeft.setMinSize(200, 200);
		midCent.setMinSize(200, 200);
		midRight.setMinSize(200, 200);
		botLeft.setMinSize(200, 200);
		botCent.setMinSize(200, 200);
		botRight.setMinSize(200, 200);
		
		add(upLeft, 0, 0);
		add(upCent, 1, 0);
		add(upRight, 2, 0);
		add(midLeft, 0, 1);
		add(midCent, 1, 1);
		add(midRight, 2, 1);
		add(botLeft, 0, 2);
		add(botCent, 1, 2);
		add(botRight, 2, 2);
		
		upLeft.setOnAction(new ButtonHandler());
		upCent.setOnAction(new ButtonHandler());
		upRight.setOnAction(new ButtonHandler());
		midLeft.setOnAction(new ButtonHandler());
		midCent.setOnAction(new ButtonHandler());
		midRight.setOnAction(new ButtonHandler());
		botLeft.setOnAction(new ButtonHandler());
		botCent.setOnAction(new ButtonHandler());
		botRight.setOnAction(new ButtonHandler());
	}
	
	public void winMode(boolean o)
	{
		if(o == true) 
		{
			upCent.setText("O");
		}
		else 
		{
			upCent.setText("X");
		}
		upLeft.setText("");
		upRight.setText("");
		midLeft.setText("W");
		midCent.setText("O");
		midRight.setText("N");
		botLeft.setText("!");
		botCent.setText("!");
		botRight.setText("!");
	}
	
	public void tieMode()
	{
		upLeft.setText("");
		upCent.setText("");
		upRight.setText("");
		midLeft.setText("T");
		midCent.setText("I");
		midRight.setText("E");
		botLeft.setText("!");
		botCent.setText("!");
		botRight.setText("!");
	}
	
	public boolean win(int[][] fs,int letter,int r,int c)
	{
		//check if the other values in the column or row that our current value is in are equal to our current value
		if((fs[r][0] == letter && fs[r][1] == letter && fs[r][2] == letter) ||
				(fs[0][c] == letter && fs[1][c] == letter && fs[2][c] == letter))
		{
			return true;
		}

		//if our current value is in the top-left to bottom-right diagonal,
		//check if the other values in that diagonal are equal to our current value
		if(r == c && fs[0][0] == letter && fs[1][1] == letter && fs[2][2] == letter)
		{
			return true;
		}

		//if our current value is in the top-right to bottom-left diagonal,
		//check if the other values in that diagonal are equal to our current value
		if(Math.abs(r-2) == c || (r == 1 && c == 1))
		{
			if(fs[0][2] == letter && fs[1][1] == letter && fs[2][0] == letter)
			{
				return true;
			}

		}

		//check if at least one value in fs is still equal to zero,
		//meaning that there are still spaces open to fill in the next turn
		//if a value equal to zero is found in fs, then return false (not a win)
		for(int i =0; i <= 2; i++)
		{
			for(int j= 0; j <= 2; j++)
			{
				if(fs[i][j] == 0)
				{
					return false;
				}
			}
		}

		//if we exited the nested for loop without breaking out,
		//then none of the values in fs were equal to zero and our grid is completely full
		//execute tie mode, then return false (not a win)
		tieMode();
		return false;
	}
	
	private class ButtonHandler implements EventHandler<ActionEvent>
	{
		 public void handle(ActionEvent e)
		 {
			 if(e.getSource() == upLeft)
			 {
				 if(o == true)
				 {
					 filledSquares[0][0] = 2;
					 upLeft.setText("O");
					 if(win(filledSquares,2,0,0))
					 {
						 winMode(true);
					 }
					 else { o = false;}
				 }
				 else
				 {
					 filledSquares[0][0] = 1;
					 upLeft.setText("X");
					 if(win(filledSquares,1,0,0))
					 {
						 winMode(false);
					 }
					 else { o = true;}
				 }
			 }
			 
			 else if(e.getSource() == upCent)
			 {
				 if(o == true)
				 {
					 filledSquares[0][1] = 2;
					 upCent.setText("O");
					 if(win(filledSquares,2,0,1))
					 {
						 winMode(true);
					 }
					 else { o = false;}
				 }
				 else
				 {
					 filledSquares[0][1] = 1;
					 upCent.setText("X");
					 if(win(filledSquares,1,0,1))
					 {
						 winMode(false);
					 }
					 else { o = true;}
				 }
			 }
			 
			 else if(e.getSource() == upRight)
			 {
				 if(o == true)
				 {
					 filledSquares[0][2] = 2;
					 upRight.setText("O");
					 if(win(filledSquares,2,0,2))
					 {
						 winMode(true);
					 }
					 else { o = false;}
				 }
				 else
				 {
					 filledSquares[0][2] = 1;
					 upRight.setText("X");
					 if(win(filledSquares,1,0,2))
					 {
						 winMode(false);
					 }
					 else { o = true;}
				 }
			 }
			 
			 else if(e.getSource() == midLeft)
			 {
				 if(o == true)
				 {
					 filledSquares[1][0] = 2;
					 midLeft.setText("O");
					 if(win(filledSquares,2,1,0))
					 {
						 winMode(true);
					 }
					 else { o = false;}
				 }
				 else
				 {
					 filledSquares[1][0] = 1;
					 midLeft.setText("X");
					 if(win(filledSquares,1,1,0))
					 {
						 winMode(false);
					 }
					 else { o = true;}
				 }
			 }
			 
			 else if(e.getSource() == midCent)
			 {
				 if(o == true)
				 {
					 filledSquares[1][1] = 2;
					 midCent.setText("O");
					 if(win(filledSquares,2,1,1))
					 {
						 winMode(true);
					 }
					 else { o = false;}
				 }
				 else
				 {
					 filledSquares[1][1] = 1;
					 midCent.setText("X");
					 if(win(filledSquares,1,1,1))
					 {
						 winMode(false);
					 }
					 else { o = true;}
				 }
			 }
			 
			 else if(e.getSource() == midRight)
			 {
				 if(o == true)
				 {
					 filledSquares[1][2] = 2;
					 midRight.setText("O");
					 if(win(filledSquares,2,1,2))
					 {
						 winMode(true);
					 }
					 else { o = false;}
				 }
				 else
				 {
					 filledSquares[1][2] = 1;
					 midRight.setText("X");
					 if(win(filledSquares,1,1,2))
					 {
						 winMode(false);
					 }
					 else { o = true;}
				 }
			 }
			 
			 else if(e.getSource() == botLeft)
			 {
				 if(o == true)
				 {
					 filledSquares[2][0] = 2;
					 botLeft.setText("O");
					 if(win(filledSquares,2,2,0))
					 {
						 winMode(true);
					 }
					 else { o = false;}
				 }
				 else
				 {
					 filledSquares[2][0] = 1;
					 botLeft.setText("X");
					 if(win(filledSquares,1,2,0))
					 {
						 winMode(false);
					 }
					 else { o = true;}
				 }
			 }
			 
			 else if(e.getSource() == botCent)
			 {
				 if(o == true)
				 {
					 filledSquares[2][1] = 2;
					 botCent.setText("O");
					 if(win(filledSquares,2,2,1))
					 {
						 winMode(true);
					 }
					 else { o = false;}
				 }
				 else
				 {
					 filledSquares[2][1] = 1;
					 botCent.setText("X");
					 if(win(filledSquares,1,2,1))
					 {
						 winMode(false);
					 }
					 else { o = true;}
				 }
			 }
			 
			 else if(e.getSource() == botRight)
			 {
				 if(o == true)
				 {
					 filledSquares[2][2] = 2;
					 botRight.setText("O");
					 if(win(filledSquares,2,2,2))
					 {
						 winMode(true);
					 }
					 else { o = false;}
				 }
				 else
				 {
					 filledSquares[2][2] = 1;
					 botRight.setText("X");
					 if(win(filledSquares,1,2,2))
					 {
						 winMode(false);
					 }
					 else { o = true;}
				 }
			 }
		 }
	}
}