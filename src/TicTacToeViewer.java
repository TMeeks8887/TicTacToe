import javax.swing.*;
import java.awt.*;


public class TicTacToeViewer extends JFrame{
    // TODO: Complete this class
    private TicTacToe ref;
    private Square[][] board;
    public static final String TITLE = "Tic Tac Toe";
    public static final int
            WIDTH = 600,
            HEIGHT = 600,
            BOX_SIZE = 150,
            X_OFFSET = 75,
            Y_OFFSET = 75;
    public TicTacToeViewer(TicTacToe ref)
    {
        this.ref = ref;
        this.board = ref.getBoard();

        this.setTitle(TITLE);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WIDTH, HEIGHT);
        this.setVisible(true);
    }

    public void drawAxis(Graphics g)
    {
        g.setColor(Color.BLACK);

        g.drawString("0", X_OFFSET + 20, Y_OFFSET - 20);
        g.drawString("1", X_OFFSET + 20 + BOX_SIZE, Y_OFFSET - 20);
        g.drawString("2", X_OFFSET + 20 + BOX_SIZE * 2, Y_OFFSET - 20);

        g.drawString("0", X_OFFSET - 20, Y_OFFSET);
        g.drawString("1", X_OFFSET - 20, Y_OFFSET + 20 + BOX_SIZE);
        g.drawString("2", X_OFFSET - 20, Y_OFFSET + 20  + BOX_SIZE * 2);
    }
    public void drawWinner(Graphics g, String winner)
    {
        g.setColor(Color.BLACK);
        if (winner.equals("-"))
        {
            g.drawString("Tie Game", X_OFFSET, 550);
        }
        else if (winner.equals("O"))
        {
            g.drawString("O Wins", X_OFFSET, 550);
        }
        else
        {
            g.drawString("X Wins", X_OFFSET, 550);
        }
    }
    public void paint(Graphics g)
    {
        // Resets screen to white
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        // Draws the grid
        g.setColor(Color.white);
        g.drawRect(X_OFFSET, Y_OFFSET, BOX_SIZE * 3, BOX_SIZE * 3);

        // Draws the axis
        drawAxis(g);

        // Draws the squares
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                board[i][j].draw(g, this);
            }
        }
        if (ref.getGameOver())
        {
            drawWinner(g, ref.getWinner());
        }
    }
}
