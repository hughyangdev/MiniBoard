package miniBoard;
import javax.swing.*;
import java.awt.*;

public class MyJPanel extends JPanel {
	
	int a, b, c, d;
	
	public MyJPanel() {
		this(10,10,10,10);
	}
	public MyJPanel(int a, int b, int c, int d) {
		this.a=a; this.b=b;
		this.c=c; this.d=d;
	}
	public Insets getInsets() {
		return new Insets(a,b,c,d);
	}

}
