package MainP;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public final class GridPanel extends JPanel
{
    public static final int GridSizeVS = 4, GridSizeS = 8, GridSizeM = 16, GridSizeL = 24, GridSizeVL = 40;

    public static Color[] Colors =
      {
        Color.BLACK, Color.GRAY, Color.BLUE, Color.GREEN, Color.RED, Color.WHITE
      };
    public static Color[] TextColors =
      {
        Color.WHITE, Color.WHITE, Color.WHITE, Color.BLACK, Color.WHITE, Color.BLACK
      };
    public static String[] ColorNames =
      {
        "Black", "Gray", "Blue", "Green", "Red", "White"
      };

    public int Moves, MaxMoves;

    private int GridSize;
    private Color[][] ColorMatrix;
    private boolean[][] TestedFor;

    public GridPanel(int initialGridSize, int X, int Y, int W, int H)
      {
        super();
        this.setBounds(X, Y, W, H);
        GenerateRandomly(initialGridSize);
      }

    public void GenerateRandomly(int gridSize)
      {
        this.GridSize = gridSize;
        this.TestedFor = new boolean[gridSize][gridSize];
        ColorMatrix = new Color[gridSize][gridSize];
        for (int i = 0; i < gridSize; i++)
            for (int j = 0; j < gridSize; j++)
                ColorMatrix[i][j] = Colors[Fct.Random(0, Colors.length - 1)];
        this.repaint();
      }

    public void ChangeColorPack(Color[] Col, Color[] TextCol, String[] ColNames)
      {
        for (int k = 0; k < Colors.length; k++)
            for (int i = 0; i < GridSize; i++)
                for (int j = 0; j < GridSize; j++)
                    if (ColorMatrix[i][j] == Colors[k])
                        ColorMatrix[i][j] = Col[k];
        Colors = Col;
        TextColors = TextCol;
        ColorNames = ColNames;
      }

    private void FillRecursively(int i, int j, Color initC, Color replC)
      {
        //System.out.printf("FillRecursively([%d, %d], %s, %s)\n", i, j, initC, replC);
        ColorMatrix[i][j] = replC;
        TestedFor[i][j] = true;
        if (j - 1 >= 0 && TestedFor[i][j - 1] == false && ColorMatrix[i][j - 1] == initC)
            FillRecursively(i - 1, j, initC, replC);
        if (i - 1 >= 0 && TestedFor[i - 1][j] == false && ColorMatrix[i - 1][j] == initC)
            FillRecursively(i - 1, j, initC, replC);
        if (j + 1 < GridSize && TestedFor[i][j + 1] == false && ColorMatrix[i][j + 1] == initC)
            FillRecursively(i, j + 1, initC, replC);
        if (i + 1 < GridSize && TestedFor[i + 1][j] == false && ColorMatrix[i + 1][j] == initC)
            FillRecursively(i + 1, j, initC, replC);
      }

    public void FillGridWithColor(Color C)
      {
        for (int i = 0; i < GridSize; i++)
            for (int j = 0; j < GridSize; j++)
                TestedFor[i][j] = false;
        FillRecursively(0, 0, ColorMatrix[0][0], C);
        this.repaint();
      }

    public boolean GameWon()
      {
        Color C = ColorMatrix[0][0];
        for (Color[] i : ColorMatrix)
            for (Color ij : i)
                if (ij != C)
                    return false;
        return true;
      }

    @Override
    protected void paintComponent(Graphics g)
      {
        super.paintComponent(g);

        this.setBackground(Color.MAGENTA);

        float d = (float) this.getWidth() / this.GridSize;
        for (int i = 0; i < ColorMatrix.length; i++)
            for (int j = 0; j < ColorMatrix[i].length; j++)
              {
                g.setColor(ColorMatrix[i][j]);
                g.fillRect((int) Math.floor(d * j), (int) Math.floor(d * i), (int) Math.floor(d) + 1, (int) Math.floor(d) + 1);
              }
      }
}
