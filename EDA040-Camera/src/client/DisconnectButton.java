package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Anton, Petter, Dragan & Sven on 2016-11-21.
 */
public class DisconnectButton implements ActionListener {


    private GUI gui;

    public DisconnectButton(GUI gui) {
        this.gui = gui;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        gui.disconnect();
    }
}
