import java.awt.Graphics;
import java.awt.Color;
import java.util.Random;
import java.applet.AudioClip;
import java.applet.Applet;
import javax.swing.ImageIcon;
import java.awt.Image;

public class Enemy extends Unit implements ShotListener 
{
	private boolean destroyed = false;
	private Shot shot = new Shot();
	private Random random = new Random();
   private ImageIcon enemy = new ImageIcon("Enemy.png");
   private Image image1 = enemy.getImage();
   
	public Enemy()
	{
		setPosition(220, 880);
		setVelocity(random.nextInt(10) - 7, -(random.nextInt(10) + 7));
		setSize(50, 70);
		setBounds(450, 900, 230, 450);
	}

	public void paintUnit(Graphics g)
	{
		if(!destroyed)
		{
			updatePosition(true);
			g.setColor(Color.red);
			g.fillRoundRect(x-width/2, y-height/2, width, height, 25, 15);
			if(random.nextInt(100) < 10)
			{  
				shot.fire(x, y, true);
			}
			shot.paintUnit(g);
		}
	}

	public Shot getShot()
	{
		return shot;
	}

	public boolean shotMoved(ShotEvent e) 
	{
		if(contains(e.getX(), e.getY()) && !destroyed)
		{
			Shooter.score++;
         if(Shooter.score >= 10)
         {
            setVelocity(random.nextInt(15) - 12, -(random.nextInt(15) + 12));
         }
         if(Shooter.score >= 20)
         {
            setVelocity(random.nextInt(20) - 17, -(random.nextInt(20) + 17));
         }
         if(Shooter.score >= 30)
         {
            setVelocity(random.nextInt(25) - 22, -(random.nextInt(25) + 22));
         }
         if(Shooter.score >= 40)
         {
            setVelocity(random.nextInt(30) - 27, -(random.nextInt(30) + 27));
         }
         if(Shooter.score >= 50)
         {
            setVelocity(random.nextInt(35) - 32, -(random.nextInt(35) + 32));
         }
         if(Shooter.score >= 60)
         {
            setVelocity(random.nextInt(40) - 37, -(random.nextInt(40) + 37));
         }
         if(Shooter.score >= 70)
         {
            setVelocity(random.nextInt(45) - 42, -(random.nextInt(45) + 42));
         }
         if(Shooter.score >= 80)
         {
            setVelocity(random.nextInt(50) - 47, -(random.nextInt(50) + 47));
         }
         if(Shooter.score >= 90)
         {
            setVelocity(random.nextInt(55) - 52, -(random.nextInt(55) + 52));
         }
         if(Shooter.score >= 100)
         {
            setVelocity(random.nextInt(60) - 57, -(random.nextInt(60) + 57));
         }

			return true;
		}
		return false;
	}
}

