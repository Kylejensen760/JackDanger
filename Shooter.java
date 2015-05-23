import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.applet.AudioClip;
import java.applet.Applet;
import java.awt.Image;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class Shooter extends JPanel implements ActionListener
{
	public static int score = 0;
	public static int health = 100;

	private Player player = new Player();
	private Enemy[] enemy = new Enemy[3];
   private ImageIcon background = new ImageIcon("Background.png");
   private Image image1 = background.getImage();
   private AudioClip themeSound = Applet.newAudioClip(getClass().getResource("daft_punk-get_lucky_ft_pharrell_williams.mid"));

	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Shooter");
		frame.setSize(906, 473);
		frame.setResizable(false);
		frame.add(new Shooter());
		frame.setVisible(true);
	}

	public Shooter()
	{
		setFocusable(true);
		addKeyListener(player);
		for(int i = 0; i < enemy.length; i++)
		{
			enemy[i] = new Enemy();
			player.getShot().addShotListener(enemy[i]);
			enemy[i].getShot().addShotListener(player);
		}
      themeSound.loop();
		Timer timer = new Timer(50, this);
		timer.start();
	}

	public void paintComponent(Graphics g)
	{
      g.drawImage(image1, 0, 0, this);
		player.paintUnit(g);
		for(int i = 0; i < enemy.length; i++)
		{
			enemy[i].paintUnit(g);
		}
		g.setColor(Color.green);
		g.drawString("Score: " + Shooter.score, 50, 13);
      if(health <= 50)
      {
         g.setColor(Color.yellow);
      }
      if(health <= 30)
      {
         g.setColor(Color.red);
      }
		g.drawString("Health: " + Shooter.health, 50, 253);
	}
   
	public void actionPerformed(ActionEvent e)
	{
		repaint();
      if(health <= 0)
      {
         System.out.println("You Lose");
         System.exit(0);
      }
      if(score == 100)
      {
         System.out.println("You Won");
         System.exit(0);
      }
      
      //repaint();
	}
   
   
}

