package Componentes;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JScrollBar;

public class BarraPersonalizada extends JScrollBar {

    public BarraPersonalizada() {
        setUI(new BarraPersonalizadaFuente());
        setPreferredSize(new Dimension(8, 8));
        setForeground(new Color(27, 57, 106));
        setBackground(new Color(128, 127, 131));
    }
}
