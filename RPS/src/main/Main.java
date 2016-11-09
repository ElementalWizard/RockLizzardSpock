package main;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class Main extends JFrame implements ActionListener{
	

	public Main() throws IOException{
		JFrame theGUI = new JFrame();
		theGUI.setTitle("RPS");
		theGUI.setSize(700, 720);
		theGUI.setLocationRelativeTo(null);
		theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		theGUI.setVisible(true);
		JPanel panel = new JPanel();
		
		panel.setSize(700, 700);
 
		
		BufferedImage img = ImageIO.read(new File("C:/Users/alexa/Desktop/code/java code/Games/RPS/src/main/bg1.png"));
		
		theGUI.setContentPane(new JLabel(new ImageIcon(img)));
		
		theGUI.add(panel);
		panel.setOpaque(false);
		
		// Buttons
	    JButton rockbutt = new JButton(Move.ROCK.getName());
	    JButton paperbutt = new JButton(Move.PAPER.getName());
	    JButton scissorbutt = new JButton(Move.SCISSOR.getName());
	    JButton lizzbutt = new JButton(Move.LIZZARD.getName());
	    JButton spokbutt = new JButton(Move.SPOK.getName());
	    
	    
	    
	    panel.setLayout(null);
	    rockbutt.setBounds(300, 210,100, 30);
	    panel.add(rockbutt);
	    rockbutt.addActionListener(this);
	    

	    paperbutt.setBounds(512, 355,100, 30);
	    panel.add(paperbutt);
	    paperbutt.addActionListener(this);
	     

	    
	    scissorbutt.setBounds(430, 600,100, 30);
	    panel.add(scissorbutt);
	    scissorbutt.addActionListener(this);
	    
	    lizzbutt.setBounds(165,600,100, 30);
	    panel.add(lizzbutt);
	    lizzbutt.addActionListener(this);
	    
	    spokbutt.setBounds(95, 360,100, 30);
	    panel.add(spokbutt);
	    spokbutt.addActionListener(this);

	   
	    theGUI.pack();

	}
	
	public static void main(String[] args) throws IOException {
		new Main();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String temp = e.getActionCommand();
		Move m = Move.getMove(temp);
		System.out.println(m.getName());
		Open(m);
		
	}
	
	public void Open(Move s) {
		Random rand = new Random();
		rand.setSeed(System.nanoTime());
		int  c = rand.nextInt(Move.values().length);
		
		Move com = Move.values()[c];

		
		
		String winner = null;
		switch (s) {
		
		
		case SCISSOR:
			switch (com) {
			case PAPER:
			case LIZZARD:
				winner = "You Win";
				break;
		    case SCISSOR:
		    	winner = "It's a tie";
		    	break;
		    default:
		    	winner = "You loose";
			}
			break;
			
			
			
		case LIZZARD:
			switch (com) {
			case PAPER:
			case SPOK:
				winner = "You Win";
				break;
		    case LIZZARD:
		    	winner = "It's a tie";
		    	break;
		    default:
		    	winner = "You loose";
			}
			break;
			
			
			
		case PAPER:
			switch (com) {
			case ROCK:
			case SPOK:
				winner = "You Win";
				break;
		    case PAPER:
		    	winner = "It's a tie";
		    	break;
		    default:
		    	winner = "You loose";
			}
			break;
			
			
			
		case ROCK:
			switch (com) {
			case SCISSOR:
			case LIZZARD:
				winner = "You Win";
				break;
		    case ROCK:
		    	winner = "It's a tie";
		    	break;
		    default:
		    	winner = "You loose";
			}
			break;
			
			
		case SPOK:
			switch (com) {
			case ROCK:
			case SCISSOR:
				winner = "You Win";
				break;
		    case SPOK:
		    	winner = "It's a tie";
		    	break;
		    default:
		    	winner = "You loose";
			}
			break;
		}

		JFrame gui2 = new JFrame();
		gui2.setLayout(new GridBagLayout());
		gui2.setTitle("Results");

		
		JPanel panel2 = new JPanel();
		JLabel result = new JLabel(winner);
		JLabel presult = new JLabel("You played: " + s + " ; ");
		JLabel cresult = new JLabel("The computer played: " + com );
		

		panel2.add(presult);
		panel2.add(cresult);
		panel2.add(result);
		presult.setForeground(Color.MAGENTA);
		cresult.setForeground(Color.ORANGE);
		
		if (winner == "Well, its tie... Thats a first."){
			result.setForeground(Color.DARK_GRAY);
		}
		else if (winner == "You win this round."){
			result.setForeground(Color.GREEN);
		}
		else if (winner == "You lost."){
			result.setForeground(Color.RED);
		}
		
		panel2.setBorder(new LineBorder(Color.BLACK));
		gui2.add(panel2,new GridBagConstraints());
		gui2.setSize(1200, 720);
		panel2.setBackground(Color.BLUE);
		gui2.setLocationRelativeTo(null);
		gui2.setVisible(true);
	}
}
