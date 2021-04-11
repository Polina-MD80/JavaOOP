package aquarium.repositories;

import aquarium.entities.decorations.Decoration;

import java.util.ArrayList;
import java.util.Collection;

public class DecorationRepository implements Repository{
    private Collection<Decoration> decorations;

    public DecorationRepository() {
        this.decorations = new ArrayList<>();
    }

    @Override
    public void add(Decoration decoration) {
        this.decorations.add(decoration);
    }

    @Override
    public boolean remove(Decoration decoration) {
        Decoration decorationToRemove = this.findByType(decoration.getClass().getSimpleName());
        if (decorationToRemove == null){
            return false;
        }
        decorations.remove(decorationToRemove);
        return true;
    }

    @Override
    public Decoration findByType(String type) {
        return this.decorations.stream()
                .filter(d-> d.getClass().getSimpleName().equals(type)).findFirst().orElse(null);
    }
}
