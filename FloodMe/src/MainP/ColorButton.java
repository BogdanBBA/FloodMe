package MainP;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

public class ColorButton extends JPanel
{
    private Color ButtonColor, TextColor;
    private String ButtonCaption;

    public ColorButton(Color buttColor, Color textColor, String Caption, int X, int Y, int W, int H)
      {
        super();
        this.ButtonColor = buttColor;
        this.TextColor = textColor;
        this.ButtonCaption = Caption;
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        this.setBounds(X, Y, W, H);
      }

    public void setColorsAndCaption(Color buttColor, Color textColor, String Caption)
      {
        this.ButtonColor = buttColor;
        this.TextColor = textColor;
        this.ButtonCaption = Caption;
        this.repaint();
      }

    @Override
    protected void paintComponent(Graphics g)
      {
        super.paintComponent(g);

        this.setBackground(Color.BLACK);

        g.setColor(ButtonColor);
        g.fillRect(1, 1, this.getWidth() - 2, this.getHeight() - 2);

        g.setColor(TextColor);
        g.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        g.drawString(ButtonCaption, 4, this.getHeight() - 8);
      }
}
