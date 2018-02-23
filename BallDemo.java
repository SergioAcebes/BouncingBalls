import java.awt.Color;

import java.util.Random;
/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael KÃ¶lling and David J. Barnes
 * @version 2011.07.31
 */

public class BallDemo   
{
    private Canvas myCanvas;
    private BouncingBall[] balls;
    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
       
    }

    /**
     * Simulate two bouncing balls
     */
    public void bounce(int nBalls)
    {
        int ground = 400;   // position of the ground line
        balls = new BouncingBall[nBalls];
        myCanvas.setVisible(true);
        Random aleatorio = new Random();
        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);

        for(int i=1; i < nBalls;i++){
            int tamaño = aleatorio.nextInt(30) + 10*i;
            int red = aleatorio.nextInt(256);
            int green = aleatorio.nextInt(256);
            int blue = aleatorio.nextInt(256);
            Color color = new Color(red,green,blue);
            BouncingBall ball = new BouncingBall(50 + (i*10), 70 + (i*10),tamaño, color, ground, myCanvas);
            ball.draw();
            balls[i] = ball;
        }
        boolean move = false;
        while(!move){
            myCanvas.wait(50);
            for(int i= 0;i < nBalls;i++){
                balls[i].move();
                if(balls[i].getXPosition() >= 550){
                    move=true;
                }
            }
        }
        
        
    }
}
