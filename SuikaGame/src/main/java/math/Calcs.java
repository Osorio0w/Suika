
package math;

import gameObjects.Apple;
import graphics.Assets;

public class Calcs extends Vector2D{
    
        private static final int DIAMETER = 103;
    int x = 0;
    int y = 0;
    
     //   private boolean collision()
    //{
    //    return Apple.getBounds().intersects(Assets.watermelon);
    //}
    
   public double calculateDistance(double x1, double y1, double x2, double y2)
    {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));   
    }
    
}
