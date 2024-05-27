package tokio;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Hero> heroList;
    private List<Beast> beastList;

    // tabuleiro composto por uma lista de cada tipo de personagem
    public Board() {
        this.heroList = new ArrayList<>();
        this.beastList = new ArrayList<>();
    }

    // colocar personagens no tabuleiro
    public void placeIn(Character character) {
        if(character instanceof Hero) heroList.add((Hero) character);
        else beastList.add((Beast) character);
    }

    // remover personagens mortas do tabuleiro
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
