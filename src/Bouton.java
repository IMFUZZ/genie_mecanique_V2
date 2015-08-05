import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

import javax.swing.ButtonModel;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComponent;


public class Bouton extends JButton {
	  private static final Color TL = new Color(1f,1f,1f,.2f);
	  private static final Color BR = new Color(0f,0f,0f,.2f);
	  private static final Color ST = new Color(1f,1f,1f,.2f);
	  private static final Color SB = new Color(1f,1f,1f,.1f);
	  private Color ssc;
	  private Color bgc;
	  private int r = 8;
	  public Bouton(String text) {
	    super(text);
	  }
	  public Bouton(String text, Icon icon) {
	    super(text, icon);
	  }
	  public Bouton(Icon component) {
		    super(component);
		  }
	  @Override public void updateUI() {
	    super.updateUI();
	    setContentAreaFilled(false);
	    setFocusPainted(false);
	    setOpaque(false);
	    setForeground(Color.black);
	  }
	  @Override protected void paintComponent(Graphics g) {
	    int x = 0;
	    int y = 0;
	    int w = getWidth();
	    int h = getHeight();
	    Graphics2D g2 = (Graphics2D)g.create();
	    g2.setRenderingHint(
	      RenderingHints.KEY_ANTIALIASING,
	      RenderingHints.VALUE_ANTIALIAS_ON);
	    Shape area = new RoundRectangle2D.Float(x, y, w-1, h-1, r, r);
	    ssc = TL;
	    bgc = BR;
	    ButtonModel m = getModel();
	    if(m.isPressed()) {
	      ssc = SB;
	      bgc = ST;
	    }else if(m.isRollover()) {
	      ssc = ST;
	      bgc = SB;
	    }
	    g2.setPaint(new GradientPaint(x, y, ssc, x, y+h, bgc, true));
	    g2.fill(area);
	    g2.setPaint(BR);
	    g2.draw(area);
	    g2.dispose();
	    super.paintComponent(g);
	  }
	}