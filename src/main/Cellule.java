package main;

import java.util.ArrayList;

public class Cellule {

    private Coordonnee coordonnee;
    private ArrayList<Cellule> voisins; // Chaque case possède des cases voisines
    private boolean isEnFeu;

    public Cellule(Coordonnee coordonnee) {
        this.coordonnee = coordonnee;
        this.voisins = new ArrayList<>();
        this.isEnFeu = false;
    }

    /**
     * On ajoute la cellule si elle n'existe pas déja dans les cellules voisines
     */
    public void ajouterCellule(Cellule cellule) {
        if (!voisins.contains(cellule)) {
            voisins.add(cellule);
            cellule.ajouterCellule(this);
        }
    }

    public Coordonnee getCoordonnee() {
        return coordonnee;
    }

    public void setCoordonnee(Coordonnee coordonnee) {
        this.coordonnee = coordonnee;
    }

    public ArrayList<Cellule> getVoisins() {
        return voisins;
    }

    public void setVoisins(ArrayList<Cellule> voisins) {
        this.voisins = voisins;
    }

    public void allumerLefeu() {
        this.isEnFeu = true;
    }
}
