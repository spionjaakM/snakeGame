
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.Random;



public class GamePanel extends JPanel implements ActionListener{
	 
	static final int SCREEN_VISINA = 600;
	static final int SCREEN_DULJINA = 600;
	static final int UNIT_SIZE = 25;
	static final int GAME_UNIT = (SCREEN_VISINA*SCREEN_DULJINA)/UNIT_SIZE;
	static final int DELAY = 75;
	final int x[] = new int[GAME_UNIT];
	final int y[] = new int[GAME_UNIT];
	
	int jabukaX;
	int jabukaY;
	
	int tijelo = 6;
	
	int score = 0;
	
	int a,b,c;
	
	Timer timer;
	Random random;

	boolean running = false;
	
	char smjer = 'D';
	
	int border,contact,rGlavaBoja,gGlavaBoja,bGlavaBoja,rTijeloBoja,gTijeloBoja,bTijeloBoja;
	
	JLabel scoreLabel = new JLabel();
	JLabel gameOverLabel = new JLabel();
	
	
	
	GamePanel(int border,int contact,int rGlavaBoja,int gGlavaBoja,int bGlavaBoja,int rTijeloBoja,int gTijeloBoja,int bTijeloBoja){
		this.border = border;
		this.contact = contact;
		this.rGlavaBoja = rGlavaBoja;
		this.gGlavaBoja = gGlavaBoja;
		this.bGlavaBoja = bGlavaBoja;
		this.rTijeloBoja = rTijeloBoja;
		this.gTijeloBoja = gTijeloBoja;
		this.bTijeloBoja = bTijeloBoja;
		
		this.setPreferredSize(new Dimension(SCREEN_VISINA,SCREEN_DULJINA));
		
		scoreLabel.setFont(new Font(null,Font.BOLD,50));
		scoreLabel.setText(String.valueOf(score));
		scoreLabel.setForeground(Color.green);
		scoreLabel.setBounds(278, 25, 100, 50);
		
		gameOverLabel.setFont(new Font(null,Font.BOLD,50));
		gameOverLabel.setText(String.valueOf(score));
		gameOverLabel.setForeground(Color.red);
		gameOverLabel.setBounds(150, 100, 400, 50);
		gameOverLabel.setText("");
		
		this.add(scoreLabel);
		this.add(gameOverLabel);
		random = new Random();
		this.setBackground(Color.black);
		this.setFocusable(true);
		this.setLayout(null);
		this.addKeyListener(new MyKeyAdapter());
		a = random.nextInt(255);
		b = random.nextInt(255);
		c = random.nextInt(255);
		startGame();
	}
	
	
	
	
	
	
	public void  startGame() {
		
		running = true;
		timer = new Timer(DELAY, this);
		timer.start();
		novaJabuka();
	}
	
	
	public void draw(Graphics g) {
		
		g.setColor(Color.gray);
		for(int i = 0; i < (SCREEN_VISINA/UNIT_SIZE);i++) {
			g.drawLine(0, (i*UNIT_SIZE), SCREEN_DULJINA, (i*UNIT_SIZE));
			g.drawLine((i*UNIT_SIZE), 0, (i*UNIT_SIZE), SCREEN_VISINA);
			
		}
		
		
	
		for(int i = 0; i < tijelo ;i++) {
			g.setColor(new Color(rTijeloBoja,gTijeloBoja,bTijeloBoja));
				g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
			
			
		}
		
		g.setColor(new Color(rGlavaBoja,gGlavaBoja,bGlavaBoja));
		g.fillRect(x[0], y[0], UNIT_SIZE, UNIT_SIZE);
		
		g.setColor(Color.red);
		g.fillOval(jabukaX, jabukaY, UNIT_SIZE, UNIT_SIZE);
		
		
		
	}
	
	public void novaJabuka() {
		jabukaX = random.nextInt((int)(SCREEN_DULJINA/UNIT_SIZE))*UNIT_SIZE;
		jabukaY = random.nextInt((int)(SCREEN_VISINA/UNIT_SIZE))*UNIT_SIZE;
		
	}
	
public void kretanje() {
		
	for(int i = tijelo;i>0;i--) {
		x[i] = x[i-1];
		y[i] = y[i-1];
	}
		
		switch(smjer) {
		case 'U':
			y[0] = y[0] - UNIT_SIZE;
			break;
		case 'D':
			y[0] = y[0] + UNIT_SIZE;
			break;
		case 'L':
			x[0] = x[0] - UNIT_SIZE;
			break;
		case 'R':
			x[0] = x[0] + UNIT_SIZE;
			break;
		}
		
	}

public void provjeraJabuke() {
	if(jabukaX == x[0] && jabukaY == y[0]) {
		novaJabuka();
		tijelo++;
		score++;
		scoreLabel.setText(String.valueOf(score));
	}
}

public void provjeraSudar() {
	if(contact==1) {
	for(int z = 1; z < tijelo; z++) {
		if(x[0]==x[z] && y[0]==y[z]) running = false;
	}
	}
	
}

public void provjeraBordera() {
	if(border==0) {
		if(x[0] < 0) x[0] = (SCREEN_DULJINA-25);
		if(x[0] >= SCREEN_DULJINA) x[0] = 0;
		if(y[0] < 0) y[0] = (SCREEN_VISINA-25);
		if(y[0] >= SCREEN_VISINA) y[0] = 0;
		}
	if(border==1) if(x[0] < 0 || x[0] > SCREEN_DULJINA || y[0] < 0 || y[0] > SCREEN_VISINA) running = false;
	
	
}

public void gameOver() {
	
	gameOverLabel.setText("GAME OVER");
	
	
}

	@Override
	public void actionPerformed(ActionEvent e){
		
	
		
		if(running) {
			kretanje();
			
			provjeraBordera();
			provjeraJabuke();
			provjeraSudar();
			
		}
		if(running == false) gameOver();
		repaint();
		
	}
		
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}	
	
	
	public class MyKeyAdapter extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent e) {
			switch(e.getKeyCode()) {
			case KeyEvent.VK_LEFT:
				if(smjer != 'R') {
					smjer = 'L';
				}
				break;
			case KeyEvent.VK_RIGHT:
				if(smjer != 'L') {
					smjer = 'R';
				}
				break;
			case KeyEvent.VK_UP:
				if(smjer != 'D') {
					smjer = 'U';
				}
				break;
			case KeyEvent.VK_DOWN:
				if(smjer != 'U') {
					smjer = 'D';
				}
				break;
			}
		}
	}
}
