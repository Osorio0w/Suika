package main;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Inicio extends JFrame 
{

    public Inicio() 
    {
        initComponents();
    }

    private void initComponents() 
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(800, 600));

        // Configuración del panel con la imagen de fondo
        JPanel backgroundPanel = new JPanel() 
        {
            @Override
            protected void paintComponent(Graphics g) 
            {
                super.paintComponent(g);
                ImageIcon background = new ImageIcon("src/main/java/images/Fondo_Inicio.png");
                g.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), null);
            }
        };
        backgroundPanel.setLayout(new BorderLayout());

        // Configuración de los botones con imágenes de fondo
        JButton btn1 = createButtonWithBackground("src/main/java/images/Jugar.png");
        JButton btn2 = createButtonWithBackground("src/main/java/images/Salir.png");

        // Configuración de los listeners para los botones
        btn1.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                // Abrir la otra clase al presionar el botón 1
                Animacion.main(new String[0]);
            }
        });

        btn2.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                // Abrir la otra clase al presionar el botón 2
               dispose();
            }
        });

        // Agregar los botones al panel
        backgroundPanel.add(btn1, BorderLayout.WEST);
        backgroundPanel.add(btn2, BorderLayout.EAST);

        // Configuración del frame
        setContentPane(backgroundPanel);
        pack();
        setLocationRelativeTo(null); // Centrar la ventana en la pantalla
        setVisible(true);
    }

    private JButton createButtonWithBackground(String imagePath) 
    {
        JButton button = new JButton();
        button.setIcon(new ImageIcon(imagePath)); // Establecer la imagen de fondo del botón
        button.setBorderPainted(false); // Eliminar el borde del botón
        button.setContentAreaFilled(false); // Eliminar el área de contenido del botón
        button.setFocusPainted(false); // Eliminar el efecto de enfoque del botón
        return button;
    }

    public static void main(String[] args) 
    {
        SwingUtilities.invokeLater(new Runnable() 
        {
            @Override
            public void run() {
                new Inicio();
            }
        });
    }
}
