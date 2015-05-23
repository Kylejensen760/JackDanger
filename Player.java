import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.applet.AudioClip;
import java.applet.Applet;

public class Player extends Unit implements KeyListener, ShotListener
{
	private Shot shot = new Shot();
   private ImageIcon jackDanger = new ImageIcon("JackDanger.png");
   private Image jack = jackDanger.getImage();
   private AudioClip playerShot = Applet.newAudioClip(getClass().getResource("gun-gunshot-01.wav"));
   public Player()
	{
		setPosition(220, 300);
      //setSize(62, 153);
      setSize(20, 30);
		speed = 20;
      ySpeed = 15;
		setBounds(0, 350, 230, 450);
	}

	public void paintUnit(Graphics g)
	{
      //g.drawImage(jack, 62, 153, this);
      jackDanger.paintIcon(Shooter.frame, g, 62, 153);
		updatePosition(false);
		//g.setColor(Color.blue);
		//g.fillOval(x - width/2, y - height/2, width, height);
		shot.paintUnit(g);
	}

	public Shot getShot()
	{
		return shot;
	}

	public boolean shotMoved(ShotEvent e)
	{
		if(contains(e.getX(), e.getY()))
		{
			Shooter.health = Shooter.health - 10;
			return true;
		}
		return false;
	}


	public void keyPressed(KeyEvent e)
	{
		if(e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			xVel = -speed;
		}
		if(e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			xVel = speed;
		}
      if(e.getKeyCode() == KeyEvent.VK_UP)
		{
			yVel = -ySpeed;
		}
      if(e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			yVel = ySpeed;
		}
		if(e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			shot.fire(x, y, false);
		}
	}

	public void keyReleased(KeyEvent e)
	{
      if(e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_RIGHT)
		{
			xVel = 0;
		}
      if(e.getKeyCode() == KeyEvent.VK_DOWN || e.getKeyCode() == KeyEvent.VK_UP)
		{
			yVel = 0;
		}
	}
   
	public void keyTyped(KeyEvent e)
	{}
}


