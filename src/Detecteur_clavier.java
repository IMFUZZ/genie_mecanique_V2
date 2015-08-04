import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


class Detecteur_clavier implements KeyListener {
	
	@Override
	public void keyTyped(KeyEvent e) 
	{
		System.out.println("flag1");
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("flag2");
		if(e.getKeyCode() == KeyEvent.KEY_TYPED){
			System.out.println(e.getKeyCode());
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) 
	{
		System.out.println("flag3");
	}
}