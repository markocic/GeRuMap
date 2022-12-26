package raf.dsw.gerumap.repository.implementation;

import raf.dsw.gerumap.gui.swing.grafika.model.PojamModel;
import raf.dsw.gerumap.gui.swing.grafika.model.VezaModel;
import raf.dsw.gerumap.repository.command.CommandManager;
import raf.dsw.gerumap.gui.swing.grafika.model.ElementModel;
import raf.dsw.gerumap.gui.swing.observer.GrafikaPublisher;
import raf.dsw.gerumap.gui.swing.observer.GrafikaSubscriber;
import raf.dsw.gerumap.repository.command.CommandType;
import raf.dsw.gerumap.repository.composite.MapNode;
import raf.dsw.gerumap.repository.composite.MapNodeComposite;

import java.util.ArrayList;

public class MindMap extends MapNodeComposite implements GrafikaPublisher {

    private transient ArrayList<GrafikaSubscriber> grafikaSubscribers = new ArrayList<>();
    private ArrayList<ElementModel> models = new ArrayList<>();
    private boolean template;
    private static int counter = 0;
    private PojamModel centralniPojam;
    private transient CommandManager commandManager = new CommandManager();

    public MindMap(String name, MapNode parent) {
        super(name, parent);
    }

    @Override
    public void addChild(MapNode child) {
        if (child instanceof Element element) {
            if (!this.getChildren().contains(element)) {
                this.getChildren().add(element);
            }
        }

        this.notifySubscribers(this);
    }

    @Override
    public void deleteChild(MapNode child) {
        if (child instanceof Element element) {
            this.getChildren().remove(element);
        }

        this.notifySubscribers(this);
    }

    public MindMap() {
        super("Map " + counter, null);
        counter++;
    }


    @Override
    public void setName(String name) {
        this.notifyMindMapNameChanged(this.getName(), name);
        super.setName(name);
    }

    public boolean isTemplate() {
        return template;
    }

    public void setTemplate(boolean template) {
        this.template = template;
    }

    @Override
    public void addGrafikaSubscriber(GrafikaSubscriber sub) {
        if (sub == null) return;
        if (this.grafikaSubscribers == null) this.grafikaSubscribers = new ArrayList<>();
        if (this.grafikaSubscribers.contains(sub)) return;
        this.grafikaSubscribers.add(sub);
    }

    @Override
    public void removeGrafikaSubscriber(GrafikaSubscriber sub) {
        if(sub == null || this.grafikaSubscribers == null || !this.grafikaSubscribers.contains(sub)) return;
        this.grafikaSubscribers.remove(sub);
    }

    @Override
    public void notifyGrafikaSubscribers(CommandType commandType, Object obj) {
        if (this.grafikaSubscribers == null || this.grafikaSubscribers.isEmpty()) return;
        for (GrafikaSubscriber sub : this.grafikaSubscribers) {
            sub.update(commandType, obj);
        }
    }

    @Override
    public void notifyShape(Object obj1, Object obj2) {}

    public void addModel(ElementModel model) {
        if (model == null) return;
        models.add(model);
        if (model instanceof PojamModel) notifyGrafikaSubscribers(CommandType.DODAJ_POJAM, model);
        else if (model instanceof VezaModel)  notifyGrafikaSubscribers(CommandType.DODAJ_VEZU, model);
    }

    public void addModelAtIndex(ElementModel model, int index) {
        if (model == null) return;
        models.add(index, model);

        if (model instanceof PojamModel) notifyGrafikaSubscribers(CommandType.DODAJ_POJAM, model);
        else if (model instanceof VezaModel) {
            addVezaToPojamArrays(model);
            notifyGrafikaSubscribers(CommandType.DODAJ_VEZU, model);
        }
    }

    public void removeModel(ElementModel model) {
        if (model == null) return;
        models.remove(model);
        if (model instanceof PojamModel) notifyGrafikaSubscribers(CommandType.OBRISI_POJAM, model);
        else if (model instanceof VezaModel) {
            removeVezaFromPojamArrays(model);
            notifyGrafikaSubscribers(CommandType.OBRISI_VEZU, model);
        }
    }

    public void addVezaToPojamArrays(ElementModel model) {
        VezaModel vezaModel = (VezaModel) model;
        if (vezaModel.getDoPojma() != null) vezaModel.getDoPojma().addDolazecaVeza(vezaModel);
        if (vezaModel.getOdPojma() != null) vezaModel.getOdPojma().addOdlazecaVeza(vezaModel);

    }
    public void removeVezaFromPojamArrays(ElementModel model) {
        VezaModel vezaModel = (VezaModel) model;
        if (vezaModel.getDoPojma() != null) vezaModel.getDoPojma().removeDolazecaVeza(vezaModel);
        if (vezaModel.getOdPojma() != null) vezaModel.getOdPojma().removeOdlazecaVeza(vezaModel);
    }

    public ArrayList<ElementModel> getModels() {
        return models;
    }

    public void setModels(ArrayList<ElementModel> models) {
        this.models = models;
    }

    public CommandManager getCommandManager() {
        return commandManager;
    }

    public void setCommandManager(CommandManager commandManager) {
        this.commandManager = commandManager;
    }

    public void removeModels(ArrayList<ElementModel> models) {
        for (ElementModel model : models) {
            removeModel(model);
        }
        notifyGrafikaSubscribers(CommandType.MULTI_BRISANJE, models);
    }

    public PojamModel getCentralniPojam() {
        return centralniPojam;
    }

    public void setCentralniPojam(PojamModel centralniPojam) {
        this.centralniPojam = centralniPojam;
    }
}
