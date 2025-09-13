package Clases.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaPrincipal extends JFrame {

    private JTextArea areaTextoIzq;
    private JTextArea areaTextoAbajo;
    private JLabel areaImagen;

    public VentanaPrincipal() {
        setTitle("AutómataLab - Interfaz Visual");
        setSize(1000, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initComponentes();
        setVisible(true);
    }

    private void initComponentes() {
        JPanel panelPrincipal = new JPanel(new BorderLayout());
        getContentPane().add(panelPrincipal);

        // --- Título centrado ---
        JLabel titulo = new JLabel("AFD / AP", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 26));
        titulo.setBorder(BorderFactory.createEmptyBorder(10,0,10,0));
        panelPrincipal.add(titulo, BorderLayout.NORTH);

        // --- Panel de botones superiores ---
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        panelPrincipal.add(panelBotones, BorderLayout.PAGE_START);

        // Botón Archivo (izquierda) con menú desplegable
        JButton btnArchivo = new JButton("Archivo");
        JPopupMenu menuArchivo = new JPopupMenu();

        // Nuevo
        JMenuItem itemNuevo = new JMenuItem("Nuevo");
        menuArchivo.add(itemNuevo);

        // Abrir
        JMenuItem itemAbrir = new JMenuItem("Abrir");
        itemAbrir.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            int resultado = fileChooser.showOpenDialog(this);
            if (resultado == JFileChooser.APPROVE_OPTION) {
                java.io.File archivoSeleccionado = fileChooser.getSelectedFile();
                JOptionPane.showMessageDialog(this, "Archivo seleccionado: " + archivoSeleccionado.getAbsolutePath());
            }
        });
        menuArchivo.add(itemAbrir);

        // Guardar
        JMenuItem itemGuardar = new JMenuItem("Guardar");
        menuArchivo.add(itemGuardar);

        // Mostrar el menú al presionar el botón
        btnArchivo.addActionListener(e -> menuArchivo.show(btnArchivo, 0, btnArchivo.getHeight()));
        panelBotones.add(btnArchivo);

        // Botón Reportes (medio)
        JButton btnReportes = new JButton("Reportes");
        btnReportes.addActionListener(e -> JOptionPane.showMessageDialog(this, "Botón Reportes presionado"));
        panelBotones.add(btnReportes);

        // Botón Ejecutar (derecha)
        JButton btnEjecutar = new JButton("Ejecutar");
        btnEjecutar.addActionListener(e -> JOptionPane.showMessageDialog(this, "Botón Ejecutar presionado"));
        panelBotones.add(btnEjecutar);

        // --- Panel central con recuadros ---
        JPanel panelCentro = new JPanel(new BorderLayout());
        panelPrincipal.add(panelCentro, BorderLayout.CENTER);

        // Panel superior para recuadro de texto izquierdo + imagen derecha
        JPanel panelSuperior = new JPanel(new GridLayout(1,2,10,10));
        panelCentro.add(panelSuperior, BorderLayout.CENTER);

        // Recuadro de texto izquierdo
        areaTextoIzq = new JTextArea();
        JScrollPane scrollTextoIzq = new JScrollPane(areaTextoIzq);
        scrollTextoIzq.setBorder(BorderFactory.createTitledBorder("Texto Izquierda"));
        panelSuperior.add(scrollTextoIzq);

        // Recuadro para imagen derecha
        areaImagen = new JLabel("Imagen Aquí", SwingConstants.CENTER);
        areaImagen.setBorder(BorderFactory.createTitledBorder("Imagen Derecha"));
        areaImagen.setOpaque(true);
        areaImagen.setBackground(Color.LIGHT_GRAY);
        panelSuperior.add(areaImagen);

        // Recuadro de texto inferior
        areaTextoAbajo = new JTextArea();
        JScrollPane scrollTextoAbajo = new JScrollPane(areaTextoAbajo);
        scrollTextoAbajo.setBorder(BorderFactory.createTitledBorder("Texto Inferior"));
        scrollTextoAbajo.setPreferredSize(new Dimension(0, 200));
        panelCentro.add(scrollTextoAbajo, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VentanaPrincipal());
    }
}
