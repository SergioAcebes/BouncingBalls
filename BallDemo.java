import java.awt.Color;

import java.util.Random;
/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael Kölling and David J. Barnes
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

        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);

        for(int i=1; i <= nBalls;i++){
            BouncingBall ball = new BouncingBall(50 + (i*10), 70 + (i*10), 2+(4*i), Color.BLUE, ground, myCanvas);
            ball.draw();
            balls[i] = ball;
        }
        boolean move = true;
        while(move!=true){
            myCanvas.wait(50);
            for(int j= 0;j < nBalls;j++){
                balls[j].move();
                if(balls[j].getXPosition() > 500){
                    start=true;
                }
            }
        }
        
        
    }
}
