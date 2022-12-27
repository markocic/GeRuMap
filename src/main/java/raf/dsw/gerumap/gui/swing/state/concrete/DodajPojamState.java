package raf.dsw.gerumap.gui.swing.state.concrete;

import raf.dsw.gerumap.AppCore;
import raf.dsw.gerumap.gui.swing.grafika.model.PojamModel;
import raf.dsw.gerumap.gui.swing.view.MapView;
import raf.dsw.gerumap.logger.TipPoruke;
import raf.dsw.gerumap.repository.command.AbstractCommand;
import raf.dsw.gerumap.repository.command.concrete.PojamCommand;
import raf.dsw.gerumap.gui.swing.state.State;

import javax.swing.*;
import java.awt.*;

public class DodajPojamState extends State {
    @Override
    public void mousePressedState(int x, int y, MapView map) {
        // ne dozvoljava korisniku da napravi "blank" pojam
        String pojamName = "";
        boolean check = true;
        do {
            pojamName = JOptionPane.showInputDialog("Unesi ime novog pojma: ","Novi pojam");
            if (pojamName == null) return; // kliknuo je na cancel dugme
            if (pojamName.isBlank()) {
                AppCore.getInstance().getMsgGenerator().generateMsg("Ime ne moze da bude prazno", TipPoruke.GRESKA);
            }
            else if (pojamNameExists(pojamName, map)) {
                AppCore.getInstance().getMsgGenerator().generateMsg("Pojam sa imenom '" + pojamName +"' vec postoji", TipPoruke.GRESKA);
            }
            else check = false;

        } while (check);

        AbstractCommand pojamCommand = new PojamCommand(map.getMapa(), new PojamModel(pojamName, new Point(x, y), new Dimension(80, 40), 2, Color.BLACK));
        map.getMapa().getCommandManager().addCommand(pojamCommand);
    }
}
