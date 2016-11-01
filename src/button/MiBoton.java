package button;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

// CLASE QUE EXTIENDA DE JBUTTON
public class MiBoton extends JButton {

	// Creamos la variable que representa la opacidad
	float opacity = 0.5f;

	// CONSTRUCTOR CON TEXTO
	public MiBoton(String text) {
		super(text);
		addMouseListener(new EventButton());
	}

	// CONSTRUCTOR SIN TEXTO
	public MiBoton() {
		super();
		addMouseListener(new EventButton());
	}

	// Metodo get de mi variable "opacity"
	public float getOpacity() {
		return opacity;
	}

	// Metodo set de mi variable "opacity"
	public void setOpacity(float opacity) {
		this.opacity = opacity;
		// Actualiza el control
		repaint();
	}

	// Sobreescribir el metodo del padre para que aparesca el boton, y pasarle
	// el valor de mi opacidad
	@Override
	public void paintComponent(Graphics g) {
		// Creamos un objeto de tipo Graphics2D y casteamos el valor que pasa
		// por parametro
		Graphics2D g2 = (Graphics2D) g;
		// Pasamos nuestra variable "opacity" al metodo
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity));
		// Usamos el metodo paintComponent del padre con "super"
		super.paintComponent(g2);
	}

	// Clase anidad
	public class EventButton extends MouseAdapter {
		// EL MOUSE SALE
		@Override
		public void mouseExited(MouseEvent me) {
			efectHover(1f, 0.5f, 0.03f, 10, false);
		}

		// EL MOUSE ENTRA
		@Override
		public void mouseEntered(MouseEvent me) {
			efectHover(0.5f, 1f, 0.03f, 10, true);
		}

		// HACES CLICK AL CONTROL
		@Override
		public void mousePressed(MouseEvent me) {
			efectHover(1f, 0.6f, 0.1f, 1, false);
		}

		// PROGRAMANDO EVENTO
		private void efectHover(float index, float range, float cont, int sleep, boolean event) {
			new Thread(() -> {
				for (float i = index; (event) ? i <= range : i >= range; i = (event) ? i + cont : i - cont) {
					setOpacity(i);
					try {
						Thread.sleep(sleep);
					} catch (InterruptedException e) {
					}

				}
			}).start();
		}
	}

}
