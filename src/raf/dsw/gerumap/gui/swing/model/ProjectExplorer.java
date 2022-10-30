package raf.dsw.gerumap.gui.swing.model;

public class ProjectExplorer extends MapNodeComposite {
    public ProjectExplorer(String name) {
        super(name, null);
    }

    @Override
    public void addChild(MapNode child) {
        if (child != null && child instanceof Project) {
            Project project = (Project) child;
            if (!this.getChildren().contains(project)) {
                this.getChildren().add(project);
            }
        }
    }
}
