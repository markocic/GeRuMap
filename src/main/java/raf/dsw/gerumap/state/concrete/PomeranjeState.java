package raf.dsw.gerumap.state.concrete;

import raf.dsw.gerumap.gui.swing.view.MapView;
import raf.dsw.gerumap.repository.command.AbstractCommand;
import raf.dsw.gerumap.repository.command.concrete.MoveCommand;
import raf.dsw.gerumap.state.State;

public class PomeranjeState  extends State {

    private int startX;
    private int startY;
    private AbstractCommand moveCommand;
    @Override
    public void mousePressedState(int x, int y, MapView map) {
        startX = x;
        startY = y;

        moveCommand = new MoveCommand(startX, startY, x, y, getSelectedModels(map.getSelectedPainters()));
        map.getMapa().getCommandManager().addCommand(moveCommand);
    }

    @Override
    public void mouseReleasedState(int x, int y, MapView map) {
        ((MoveCommand) moveCommand).setEndX(x);
        ((MoveCommand) moveCommand).setEndY(y);
    }

    @Override
    public void mouseDraggedState(int x, int y, MapView map) {
        ((MoveCommand) moveCommand).updateMove(x - startX, y - startY);

        startX = x;
        startY = y;
    }


}
