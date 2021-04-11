package aquarium.core;

import aquarium.entities.aquariums.Aquarium;
import aquarium.entities.aquariums.FreshwaterAquarium;
import aquarium.entities.aquariums.SaltwaterAquarium;
import aquarium.entities.decorations.Decoration;
import aquarium.entities.decorations.Ornament;
import aquarium.entities.decorations.Plant;
import aquarium.entities.fish.Fish;
import aquarium.entities.fish.FreshwaterFish;
import aquarium.entities.fish.SaltwaterFish;
import aquarium.repositories.DecorationRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static aquarium.common.ConstantMessages.*;
import static aquarium.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private DecorationRepository decorations;
    private Collection<Aquarium> aquariums;

    public ControllerImpl() {
        this.aquariums = new ArrayList<>();
        decorations = new DecorationRepository();
    }

    @Override
    public String addAquarium(String aquariumType, String aquariumName) {
        Aquarium aquarium;
        switch (aquariumType){
            case "FreshwaterAquarium":
                aquarium = new FreshwaterAquarium(aquariumName);
                break;
            case "SaltwaterAquarium":
                aquarium = new SaltwaterAquarium(aquariumName);
                break;
            default: throw new NullPointerException(INVALID_AQUARIUM_TYPE);
        }
        this.aquariums.add(aquarium);
        return String.format(SUCCESSFULLY_ADDED_AQUARIUM_TYPE, aquariumType);
    }

    @Override
    public String addDecoration(String type) {
        Decoration decoration;
        switch (type){
            case "Ornament":
                decoration = new Ornament();
                break;
            case "Plant":
                decoration = new Plant();
                break;
            default: throw new IllegalArgumentException(INVALID_DECORATION_TYPE);
        }
        this.decorations.add(decoration);
        return String.format("Successfully added %s.", type);
    }


    @Override
    public String insertDecoration(String aquariumName, String decorationType) {
        Aquarium aquarium = this.aquariums.stream().filter(a-> a.getName().equals(aquariumName)).findFirst().orElse(null);
        Decoration decoration = this.decorations.findByType(decorationType);
        if (decoration==null){
            throw new IllegalArgumentException(String.format(NO_DECORATION_FOUND, decorationType));
        }
        this.decorations.remove(decoration);
        aquarium.addDecoration(decoration);

        return String.format(SUCCESSFULLY_ADDED_DECORATION_IN_AQUARIUM, decorationType, aquariumName);
    }

    @Override
    public String addFish(String aquariumName, String fishType, String fishName, String fishSpecies, double price) {
        Fish fish;
        Aquarium aquarium;
        switch (fishType){
            case "FreshwaterFish":
                fish = new FreshwaterFish(fishName,fishSpecies,price);break;
            case"SaltwaterFish":
                fish = new SaltwaterFish(fishName,fishSpecies, price);break;
            default:
                throw new IllegalArgumentException(INVALID_FISH_TYPE);
        }
        aquarium = aquariums.stream().filter(a->a.getName().equals(aquariumName)).findFirst().orElse(null);
        if (fish.getClass().getSimpleName().equals("FreshwaterFish")&&
        aquarium.getClass().getSimpleName().equals("SaltwaterAquarium") ||
                fish.getClass().getSimpleName().equals("SaltwaterFish")&&
                        aquarium.getClass().getSimpleName().equals("FreshwaterAquarium")){
            return WATER_NOT_SUITABLE;
        }
        aquarium.addFish(fish);
        return String.format(SUCCESSFULLY_ADDED_FISH_IN_AQUARIUM, fishType, aquariumName);
    }

    @Override
    public String feedFish(String aquariumName) {
        Aquarium aquarium = aquariums.stream().filter(a->a.getName().equals(aquariumName)).findFirst().orElse(null);
        aquarium.feed();
        return String.format(FISH_FED, aquarium.getFish().size());
    }

    @Override
    public String calculateValue(String aquariumName) {
        Aquarium aquarium = aquariums.stream().filter(a->a.getName().equals(aquariumName)).findFirst().orElse(null);
        double fishPrice = aquarium.getFish().stream().mapToDouble(Fish::getPrice).sum();
        double decorationPrice = aquarium.getDecorations().stream().mapToDouble(Decoration::getPrice).sum();
         double total = fishPrice+decorationPrice;
        return String.format(VALUE_AQUARIUM,aquariumName, total);
    }

    @Override
    public String report() {
       StringBuilder sb = new StringBuilder();
       this.aquariums.stream().forEach(a-> sb.append(a.getInfo()).append(System.lineSeparator()));
       return sb.toString().trim();
    }
}
