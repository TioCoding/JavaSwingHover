package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;

import button.MiBoton;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Cursor;
import javax.swing.ImageIcon;

public class FrameExample extends JFrame {

	private JPanel contentPane;
	// CREANDO BOTONES
	private JButton btnNumero1;
	private JButton btnNumero2;
	private JButton btnNumero3;
	private JButton btnNumero4;

	public static void main(String[] args) {
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e) {
		}
		EventQueue.invokeLater(() -> {
			FrameExample frame = new FrameExample();
			frame.setVisible(true);
		});
	}

	public FrameExample() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("Ejemplo de botones");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// INSTANCIANDO BOTONES
		btnNumero1 = new MiBoton("Aceptar");
		btnNumero2 = new MiBoton();
		btnNumero3 = new MiBoton();
		btnNumero4 = new MiBoton();
		
		// añadiendo propiedades a mis botones
		añadiendoPropiedades();
		// añadiendo al panel los botones
		contentPane.add(btnNumero1);
		contentPane.add(btnNumero2);
		contentPane.add(btnNumero3);
		contentPane.add(btnNumero4);
	}

	private void añadiendoPropiedades(){
		btnNumero1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNumero1.setFont(new Font("Arial", Font.BOLD, 20));
		btnNumero1.setBounds(48, 21, 145, 57);

		btnNumero2.setIcon(new ImageIcon(FrameExample.class.getResource("/img/Inventario.png")));
		btnNumero2.setContentAreaFilled(false);
		btnNumero2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNumero2.setBounds(273, 6, 133, 106);

		btnNumero3.setContentAreaFilled(false);
		btnNumero3.setIcon(new ImageIcon(FrameExample.class.getResource("/img/acepta_nuevo1.png")));
		btnNumero3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNumero3.setBounds(67, 178, 121, 41);

		btnNumero4.setIcon(new ImageIcon(FrameExample.class.getResource("/img/campana.png")));
		btnNumero4.setContentAreaFilled(false);
		btnNumero4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNumero4.setBounds(273, 137, 169, 128);
	}
	
}
