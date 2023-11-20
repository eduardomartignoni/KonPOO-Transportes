package aplicacao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interface extends JFrame {
    public Interface() {
        setTitle("Aplicativo de Transportes");
        setVisible(true);
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        
        JLabel titulo = new JLabel("Empresa KONPOO");
        titulo.setFont(new Font("Arial", Font.BOLD, 25));
        titulo.setBounds(getX() / 2, 70, 400, 100);
        titulo.setVisible(true);
        add(titulo);

        JButton a = new JButton("Começar");
        a.setBounds(this.getX() / 2, 150, 90, 100);
        a.setFont(new Font("Arial", Font.ITALIC, 50));
        a.setForeground(new Color(7,7,7));
        a.setBackground(new Color(251, 250, 250));
        a.setVisible(true);
        a.addActionListener (new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                App app = new App();
                app.run();
            }
        });
        add(a);            
        }
    }

