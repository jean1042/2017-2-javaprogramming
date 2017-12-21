	import java.awt.*;
	import javax.swing.*;
	import java.awt.Font;
	public class MyComponent extends JComponent 
	{

		public MyComponent(){
			Font font1;
			font1 = new Font("SERIF", Font.BOLD, 12);
			
		}
		
		public void paintComponent(Graphics g)
		{
			g.drawLine(10, 80, 100, 10);
			g.drawString("drawLine()", 10, 100);
			
			g.drawRect(110, 10, 110, 80);
			g.drawString("drawRect()", 110, 100);
			
			
			
			/*3. 3d �׸�*/
			g.draw3DRect(300, 10, 110, 80, true);
			g.drawString("draw3DRect()", 300, 100);
			
			/*4. ���� �׸�
			g.drawRoundRect(370, 10, 110, 80, true);
			g.drawString("drawRoundRect()", 260, 90);*/
			
			/*5. Ÿ��*/
			g.drawOval(480, 10, 110, 80);
			g.drawString("drawOval()", 500, 100);
			
			/*6. ȣ*/
			g.drawArc(600, 10, 110, 80, 180, -90);
			g.drawString("drawArc()", 600, 100);
			
			/*7. Polygon*/
			int xk[]={710, 820, 760, 710, 820};
			int yk[]={10, 10, 45, 90, 90};
			 g.drawPolygon(xk, yk, xk.length);
			 g.drawString("drawPolygon()", 700, 110);
			 
			/*8. fillRect*/
			g.fillRect(110, 160, 110, 80);
			g.drawString("fillRect()", 110, 150);
			g.setColor(Color.red);
			
			/*9. fill3DRect*/
			g.fill3DRect(300, 160, 110, 80, true);
			g.drawString("fill3DRect()", 300, 150);
			
			/*10. fillRoundRect*/
			g.fillRoundRect(450, 160,110,80, 30, 30);
			g.drawString("fillRoundRect()", 450, 150);
			
			/*11. fillArc*/
			g.fillArc(600, 150, 150, 80, 180, -90);
			g.drawString("fillArc()", 600, 150);
			
			/*12. fillPolygon*/
			int xa[]={710, 820, 760, 710, 820};
			int ya[]={150, 150, 200, 250, 250};
			g.fillPolygon(xa, ya, xa.length);
			g.drawString("fillPolygon", 710, 150);
			
		}
	}