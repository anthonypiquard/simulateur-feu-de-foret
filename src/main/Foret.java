package main;

import java.util.Arrays;

public class Foret {

    public Cellule[][] cellules;

    /**
     * Construction de la foret avec nombre de cases pré-définies
     */
    public Foret(int hauteur, int largeur) {
        cellules = new Cellule[hauteur][largeur];
        for (int i=0; i<hauteur; i++) {
            for (int j=0; j<largeur; j++) {
                // Creation de la cellule
                Coordonnee coordonnee = new Coordonnee(i, j);
                cellules[i][j] = new Cellule(coordonnee);

                // Creation des cellules voisines
                if (i>0) {
                    cellules[i][j].ajouterCellule(cellules[i-1][j]);
                }
                if (j>0) {
                    cellules[i][j].ajouterCellule(cellules[i][j-1]);
                }
            }
        }
    }

    public Cellule[][] getCellules() {
        return cellules;
    }

    public void setCellules(Cellule[][] cellules) {
        this.cellules = cellules;
    }

    @Override
    public String toString() {
        return "Foret {" +
                " cellules: " + Arrays.toString(cellules) +
                "}";
    }
}
