import java.awt.Graphics;
import java.awt.Color;
import java.applet.AudioClip;
import java.applet.Applet;

public class Shot extends Unit
{
	public boolean fired = false;
	private ShotListener[] listener = new ShotListener[10];
	private int listeners = 0;
   private AudioClip gunShot = Applet.newAudioClip(getClass().getResource("gun-gunshot-01.wav"));;

	public Shot()
	{
		setBounds(900, 600);
		setSize(3, 5);
		speed = 85;
	}

	public void fire(int launchX, int launchY, boolean down)
	{
		if(!fired)
		{
         
			fired = true;
			setPosition(launchX, launchY);
			if(down)
			{
            gunShot.play();
				xVel = -speed;
			}
			else
			{
            gunShot.play();
				xVel = speed;
			}
		}
	}

	public void addShotListener(ShotListener l)
	{
		listener[listeners] = l;
		listeners++;
	}

	public void paintUnit(Graphics g)
	{
		if(fired)
		{  
         //gunShot.play();
			updatePosition(false);
			g.setColor(Color.yellow);
			g.drawLine(x-2, y, x+7, y);
         g.drawLine(x-2, y-1, x+7, y-1);
         g.drawLine(x-2, y-2, x+7, y-2);
			checkForEdge();
			callListeners();
		}
	}

	private void checkForEdge()
	{
		if(x + 5 >= rightBound || x - 5 <= leftBound)
		{
			fired = false;
		}
	}

	private void callListeners()
	{
		for(int i = 0; i < listeners; i++)
		{
			if(listener[i].shotMoved(new ShotEvent(x, y)))
			{
				fired = false;
			}
		}
	}
}