package Proyecto.Code.src.View;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public abstract class Create {
    protected static CardLayout cardLayout;
    protected static JPanel cardPanel;
    static {
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
    }

    public Create(String panelName) throws IOException {
        JPanel panel = createPanel();
        cardPanel.add(panel, panelName);
    }
    public static JPanel getPanel(){
        return cardPanel;
    }
    protected abstract JPanel createPanel() throws IOException;

    public static void showPanel(String panelName) {
        cardLayout.show(cardPanel,panelName);
    }
}
