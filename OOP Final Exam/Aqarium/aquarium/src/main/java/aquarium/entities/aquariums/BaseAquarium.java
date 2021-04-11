package aquarium.entities.aquariums;

import aquarium.entities.decorations.Decoration;
import aquarium.entities.fish.Fish;

import java.util.ArrayList;
import java.util.Collection;

import static aquarium.common.ConstantMessages.NOT_ENOUGH_CAPACITY;
import static aquarium.common.ExceptionMessages.AQUARIUM_NAME_NULL_OR_EMPTY;

public abstract class BaseAquarium implements Aquarium{
    private String name;
    private int capacity;
    private Collection<Decoration> decorations;
    private Collection<Fish> fish;

    protected BaseAquarium(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.decorations = new ArrayList<>();
        this.fish = new ArrayList<>();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()){
            throw  new NullPointerException(AQUARIUM_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }


    @Override
    public int calculateComfort() {
        return decorations.stream().mapToInt(Decoration::getComfort).sum();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void addFish(Fish fish) {
      if (this.fish.size() == this.capacity){
          throw  new IllegalStateException(NOT_ENOUGH_CAPACITY);
      }
      this.fish.add(fish);
    }

    @Override
    public void removeFish(Fish fish) {
     String name = fish.getName();
     this.fish.removeIf(fish1 -> fish1.getName().equals(name));
    }

    @Override
    public void addDecoration(Decoration decoration) {
   this.decorations.add(decoration);
    }

    @Override
    public void feed() {
        for (Fish fish : this.fish) {
            fish.eat();
        }

    }

    @Override
    public String getInfo() {
        StringBuilder sb = new StringBuilder(String.format("%s (%s):", this.name, this.getClass().getSimpleName()));
        sb.append(System.lineSeparator());
        if (fish.size() == 0){
            sb.append("Fish: none");
        }else {
            sb.append("Fish:");
            fish.forEach(f-> sb.append(" ").append(f.getName()));
        }
        sb.append(System.lineSeparator());
        sb.append("Decorations: " + decorations.size()).append(System.lineSeparator());
        sb.append("Comfort: " + this.calculateComfort());
        return sb.toString();
    }

    @Override
    public Collection<Fish> getFish() {
        return this.fish;
    }

    @Override
    public Collection<Decoration> getDecorations() {
        return this.decorations;
    }
}
