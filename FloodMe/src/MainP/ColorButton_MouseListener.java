package MainP;

import static MainP.FMain.G;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

public class ColorButton_MouseListener implements MouseListener
{
    @Override
    public void mouseClicked(MouseEvent e)
      {
      }

    @Override
    public void mousePressed(MouseEvent e)
      {
        if (G.Moves == G.MaxMoves || G.GameWon())
            return;
        String s = ((ColorButton) e.getSource()).getName();
        if (s.charAt(0) == 'b')
          {
            int i = Integer.parseInt(s.substring(1));
            System.out.println("Mouse pressed, color '" + GridPanel.ColorNames[i] + "'");
            G.FillGridWithColor(GridPanel.Colors[i]);
            G.Moves++;
            FMain.titL.setText(String.format("Moves: %d / %d", G.Moves, G.MaxMoves));
            if (G.GameWon())
              {
                JOptionPane.showMessageDialog(null, "Congratulations, you won!", "Victory", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("The game has been won");
              }
            else if (G.Moves == G.MaxMoves)
              {
                JOptionPane.showMessageDialog(null, "Sorry, you're out of moves. Try again!", "Loss", JOptionPane.INFORMATION_MESSAGE);
                System.out.println("The game has been lost");
              }
          }
      }

    @Override
    public void mouseReleased(MouseEvent e
    )
      {
      }

    @Override
    public void mouseEntered(MouseEvent e
    )
      {
      }

    @Override
    public void mouseExited(MouseEvent e
    )
      {
      }
}
