import javax.swing.JFrame;

public class GameFrame extends JFrame{
	
	int border,contact,rGlavaBoja,gGlavaBoja,bGlavaBoja,rTijeloBoja,gTijeloBoja,bTijeloBoja;
	
	GameFrame(int border,int contact,int rGlavaBoja,int gGlavaBoja,int bGlavaBoja,int rTijeloBoja,int gTijeloBoja,int bTijeloBoja){
		this.border = border;
		this.contact = contact;
		this.rGlavaBoja = rGlavaBoja;
		this.gGlavaBoja = gGlavaBoja;
		this.bGlavaBoja = bGlavaBoja;
		this.rTijeloBoja = rTijeloBoja;
		this.gTijeloBoja = gTijeloBoja;
		this.bTijeloBoja = bTijeloBoja;
		
		this.add(new GamePanel(border,contact,rGlavaBoja,gGlavaBoja,bGlavaBoja,rTijeloBoja,gTijeloBoja,bTijeloBoja));
		this.pack();
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}
	

}
