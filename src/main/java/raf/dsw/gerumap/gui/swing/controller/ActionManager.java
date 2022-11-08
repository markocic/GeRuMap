package raf.dsw.gerumap.gui.swing.controller;




public class ActionManager {

    private DeleteAction deleteAction;
    private ExitAction exitAction;
    private NewProjectAction newProjectAction;

    private InfoAction infoAction;

    private AuthorAction authorAction;

    public ActionManager() {
        initActions();
    }


    private void initActions(){
        deleteAction = new DeleteAction();
        exitAction = new ExitAction();
        newProjectAction = new NewProjectAction();
        infoAction = new InfoAction();
        authorAction = new AuthorAction();
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
}
