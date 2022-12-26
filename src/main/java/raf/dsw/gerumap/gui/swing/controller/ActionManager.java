package raf.dsw.gerumap.gui.swing.controller;


import raf.dsw.gerumap.gui.swing.controller.paleta.*;

import javax.swing.*;

public class ActionManager {


    private SaveAction saveAction;
    private SaveAsAction saveAsAction;
    private SaveAsTemplateAction saveAsTemplate;

    private LoadAction loadAction;
    private LoadTemplateAction loadTemplateAction;

    private UndoAction undoAction;

    private RedoAction redoAction;

    private DeleteAction deleteAction;
    private ExitAction exitAction;
    private NewProjectAction newProjectAction;

    private InfoAction infoAction;

    private SavePictureAction savePictureAction;
    private AuthorAction authorAction;
    private OpenProjectAction openProjectAction;

    private BrisanjeAction brisanjeAction;
    private DodajPojamAction dodajPojamAction;
    private NapraviVezuAction napraviVezuAction;
    private PomeranjeAction pomeranjeAction;
    private SelekcijaAction selekcijaAction;
    private ZumiranjeAction zumiranjeAction;

    private PodesavanjaAction podesavanjaAction;
    private CentralniAction centralniAction;

    public ActionManager() {
        initActions();
    }


    private void initActions(){

        saveAction = new SaveAction();
        saveAsAction = new SaveAsAction();
        saveAsTemplate = new SaveAsTemplateAction();
        loadAction = new LoadAction();
        loadTemplateAction = new LoadTemplateAction();
        redoAction = new RedoAction();
        undoAction = new UndoAction();
        savePictureAction = new SavePictureAction();

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
        podesavanjaAction = new PodesavanjaAction();
        centralniAction = new CentralniAction();
    }

    public SavePictureAction getSavePictureAction() {
        return savePictureAction;
    }

    public void setSavePictureAction(SavePictureAction savePictureAction) {
        this.savePictureAction = savePictureAction;
    }

    public SaveAction getSaveAction() {
        return saveAction;
    }

    public void setSaveAction(SaveAction saveAction) {
        this.saveAction = saveAction;
    }

    public LoadAction getLoadAction() {
        return loadAction;
    }

    public void setLoadAction(LoadAction loadAction) {
        this.loadAction = loadAction;
    }

    public UndoAction getUndoAction() {
        return undoAction;
    }

    public void setUndoAction(UndoAction undoAction) {
        this.undoAction = undoAction;
    }

    public RedoAction getRedoAction() {
        return redoAction;
    }

    public void setRedoAction(RedoAction redoAction) {
        this.redoAction = redoAction;
    }

    public PodesavanjaAction getPodesavanjaAction() {
        return podesavanjaAction;
    }

    public void setPodesavanjaAction(PodesavanjaAction podesavanjaAction) {
        this.podesavanjaAction = podesavanjaAction;
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

    public BrisanjeAction getBrisanjeAction() {
        return brisanjeAction;
    }

    public void setBrisanjeAction(BrisanjeAction brisanjeAction) {
        this.brisanjeAction = brisanjeAction;
    }

    public DodajPojamAction getDodajPojamAction() {
        return dodajPojamAction;
    }

    public void setDodajPojamAction(DodajPojamAction dodajPojamAction) {
        this.dodajPojamAction = dodajPojamAction;
    }

    public NapraviVezuAction getNapraviVezuAction() {
        return napraviVezuAction;
    }

    public void setNapraviVezuAction(NapraviVezuAction napraviVezuAction) {
        this.napraviVezuAction = napraviVezuAction;
    }

    public PomeranjeAction getPomeranjeAction() {
        return pomeranjeAction;
    }

    public void setPomeranjeAction(PomeranjeAction pomeranjeAction) {
        this.pomeranjeAction = pomeranjeAction;
    }

    public SelekcijaAction getSelekcijaAction() {
        return selekcijaAction;
    }

    public void setSelekcijaAction(SelekcijaAction selekcijaAction) {
        this.selekcijaAction = selekcijaAction;
    }

    public ZumiranjeAction getZumiranjeAction() {
        return zumiranjeAction;
    }

    public void setZumiranjeAction(ZumiranjeAction zumiranjeAction) {
        this.zumiranjeAction = zumiranjeAction;
    }

    public SaveAsAction getSaveAsAction() {
        return saveAsAction;
    }

    public void setSaveAsAction(SaveAsAction saveAsAction) {
        this.saveAsAction = saveAsAction;
    }

    public SaveAsTemplateAction getSaveAsTemplate() {
        return saveAsTemplate;
    }

    public void setSaveAsTemplate(SaveAsTemplateAction saveAsTemplate) {
        this.saveAsTemplate = saveAsTemplate;
    }

    public LoadTemplateAction getLoadTemplateAction() {
        return loadTemplateAction;
    }

    public void setLoadTemplateAction(LoadTemplateAction loadTemplateAction) {
        this.loadTemplateAction = loadTemplateAction;
    }

    public CentralniAction getCentralniAction() {
        return centralniAction;
    }
}
