package tokio;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Hero> heroList;
    private List<Beast> beastList;

    public Board() {
        this.heroList = new ArrayList<>();
        this.beastList = new ArrayList<>();
    }

    public void placeIn(Character character) {
        if(character instanceof Hero) heroList.add((Hero) character);
        else beastList.add((Beast) character);
    }

    public void removeDead(Character character, int position) {
        if(character instanceof Hero) heroList.remove(position);
        else beastList.remove(position);
    }

    public List<Hero> getHeroList() {
        return heroList;
    }

    public List<Beast> getBeastList() {
        return beastList;
    }
}
