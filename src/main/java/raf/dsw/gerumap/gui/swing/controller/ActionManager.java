package raf.dsw.gerumap.gui.swing.controller;


import raf.dsw.gerumap.gui.swing.controller.paleta.*;

public class ActionManager {

    private DeleteAction deleteAction;
    private ExitAction exitAction;
    private NewProjectAction newProjectAction;

    private InfoAction infoAction;

    private AuthorAction authorAction;
    private OpenProjectAction openProjectAction;

    private BrisanjeAction brisanjeAction;
    private DodajPojamAction dodajPojamAction;
    private NapraviVezuAction napraviVezuAction;
    private PomeranjeAction pomeranjeAction;
    private SelekcijaAction selekcijaAction;
    private ZumiranjeAction zumiranjeAction;

    public ActionManager() {
        initActions();
    }


    private void initActions(){
        deleteAction = new DeleteAction();
        exitAction = new ExitAction();
        newProjectAction = new NewProjectAction();
        infoAction = new InfoAction();
        authorAction = new AuthorAction();
        openProjectAction = new OpenProjectAction();

        brisanjeAction = new BrisanjeAction();
        dodajPojamAction = new DodajPojamAction();
        napraviVezuAction = new NapraviVezuAction();
        pomeranjeAction = new PomeranjeAction();
        selekcijaAction = new SelekcijaAction();
        zumiranjeAction = new ZumiranjeAction();
    }

    public DeleteAction getDeleteAction() {
        return deleteAction;
    }

    public void setDeleteAction(DeleteAction deleteAction) {
        this.deleteAction = deleteAction;
    }

    public InfoAction getInfoAction() {
        return infoAction;
    }

    public void setInfoAction(InfoAction infoAction) {
        this.infoAction = infoAction;
    }

    public ExitAction getExitAction() {
        return exitAction;
    }

    public void setExitAction(ExitAction exitAction) {
        this.exitAction = exitAction;
    }

    public NewProjectAction getNewProjectAction() {
        return newProjectAction;
    }

    public void setNewProjectAction(NewProjectAction newProjectAction) {
        this.newProjectAction = newProjectAction;
    }

    public AuthorAction getAuthorAction() {
        return authorAction;
    }

    public void setAuthorAction(AuthorAction authorAction) {
        this.authorAction = authorAction;
    }

    public OpenProjectAction getOpenProjectAction() {
        return openProjectAction;
    }

    public void setOpenProjectAction(OpenProjectAction openProjectAction) {
        this.openProjectAction = openProjectAction;
    }
}
