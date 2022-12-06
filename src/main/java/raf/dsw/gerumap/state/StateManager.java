package raf.dsw.gerumap.state;

import raf.dsw.gerumap.state.concrete.*;

public class StateManager {
    private State currentState;
    private BrisanjeState brisanjeState;
    private DodajPojamState dodajPojamState;
    private NapraviVezuState napraviVezuState;
    private PomeranjeState pomeranjeState;
    private SelekcijaState selekcijaState;
    private ZumiranjeState zumiranjeState;
    private PodesavanjaState podesavanjaState;

    public StateManager() {
        brisanjeState = new BrisanjeState();
        dodajPojamState = new DodajPojamState();
        pomeranjeState = new PomeranjeState();
        napraviVezuState = new NapraviVezuState();
        selekcijaState = new SelekcijaState();
        zumiranjeState = new ZumiranjeState();
        podesavanjaState = new PodesavanjaState();

        currentState = selekcijaState;
    }

    public State getCurrentState() {
        return currentState;
    }

    public void setBrisanjeState() {
        currentState = brisanjeState;
    }

    public void setDodajPojamState() {
        currentState = dodajPojamState;
    }

    public void setPomeranjeState() {
        currentState = pomeranjeState;
    }

    public void setSelekcijaState() {
        currentState = selekcijaState;
    }

    public void setNapraviVezuState() {
        currentState = napraviVezuState;
    }

    public void setZumiranjeState() {
        currentState = zumiranjeState;
    }

    public void setPodesavanjaState() {
        currentState = podesavanjaState;
    }

}
