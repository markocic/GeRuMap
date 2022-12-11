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

    public ZumiranjeState getZumiranjeState() {
        return zumiranjeState;
    }

    public BrisanjeState getBrisanjeState() {
        return brisanjeState;
    }

    public void setBrisanjeState(BrisanjeState brisanjeState) {
        this.brisanjeState = brisanjeState;
    }

    public DodajPojamState getDodajPojamState() {
        return dodajPojamState;
    }

    public void setDodajPojamState(DodajPojamState dodajPojamState) {
        this.dodajPojamState = dodajPojamState;
    }

    public NapraviVezuState getNapraviVezuState() {
        return napraviVezuState;
    }

    public void setNapraviVezuState(NapraviVezuState napraviVezuState) {
        this.napraviVezuState = napraviVezuState;
    }

    public PomeranjeState getPomeranjeState() {
        return pomeranjeState;
    }

    public void setPomeranjeState(PomeranjeState pomeranjeState) {
        this.pomeranjeState = pomeranjeState;
    }

    public SelekcijaState getSelekcijaState() {
        return selekcijaState;
    }

    public void setSelekcijaState(SelekcijaState selekcijaState) {
        this.selekcijaState = selekcijaState;
    }

    public PodesavanjaState getPodesavanjaState() {
        return podesavanjaState;
    }

    public void setPodesavanjaState(PodesavanjaState podesavanjaState) {
        this.podesavanjaState = podesavanjaState;
    }

    public void setZumiranjeState(ZumiranjeState zumiranjeState) {
        this.zumiranjeState = zumiranjeState;
    }
}
