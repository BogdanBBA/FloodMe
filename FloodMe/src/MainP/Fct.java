package MainP;

public final class Fct
{
    static int Random(int min, int max)
      {
        return min + (int) (Math.random() * ((max - min) + 1));
      }
}
