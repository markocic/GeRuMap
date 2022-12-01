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

    public StateManager() {
        brisanjeState = new BrisanjeState();
        dodajPojamState = new DodajPojamState();
        pomeranjeState = new PomeranjeState();
        napraviVezuState = new NapraviVezuState();
        selekcijaState = new SelekcijaState();
        zumiranjeState = new ZumiranjeState();

        currentState = selekcijaState;
    }

    public State getCurrentState() {
        return currentState;
    }

    public void setBrisanjeState() {
        System.out.println("brisanje");
        currentState = brisanjeState;
    }

    public void setDodajPojamState() {
        System.out.println("dodaj pojam");

        currentState = dodajPojamState;
    }

    public void setPomeranjeState() {
        System.out.println("pomeranje");

        currentState = pomeranjeState;
    }

    public void setSelekcijaState() {
        System.out.println("selekcija");
        currentState = selekcijaState;
    }

    public void setNapraviVezuState() {
        System.out.println("napravi vezu");
        currentState = napraviVezuState;
    }

    public void setZumiranjeState() {
        System.out.println("zumiranje");
        currentState = zumiranjeState;
    }

}
