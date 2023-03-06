package main;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;

public class Main {

    /**
     * Recuperer proprietes de application.properties pour construction de la grille
     */
    public static ArrayList<String> loadProperties() {
        ArrayList<String> properties = new ArrayList<>();

        try (InputStream input = Main.class.getClassLoader().getResourceAsStream("application.properties")) {

            Properties prop = new Properties();
            prop.load(input);

            properties.add(prop.getProperty("grille.hauteur"));
            properties.add(prop.getProperty("grille.largeur"));
            properties.add(prop.getProperty("probabilite.propagation"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return properties;
    }

    public static void main(String[] args) {
        // Recuperation des proprietes
        ArrayList<String> properties = loadProperties();
        int foretHauteur = Integer.parseInt(properties.get(0));
        int foretLargeur = Integer.parseInt(properties.get(1));

        // Initialisation de la foret
        Foret foret = new Foret(foretHauteur, foretLargeur);

        // Mise en feu d'une cellule aleatoire
        Coordonnee coordonnee = new Coordonnee(
            new Random().nextInt(foretHauteur),
            new Random().nextInt(foretLargeur)
        );
        Cellule celluleAAllumer = foret.getCellules()[coordonnee.getX()][coordonnee.getY()];
        celluleAAllumer.allumerLefeu();

        // On continue tant que la foret entiere n'est pas brulée
        int tour = 0;
        boolean foretBrulee = false;
        while(!foretBrulee) {
            // On allume les voisins de celluleAAllumer
            // TODO : creer methode pour allumer les cellules voisines de celluleAAllumer

            // TODO : creer methode pour verifier qu'au moins une Cellule n'est pas allumée (cellule.isEnFeu = false)

            tour++;

            // Si toutes les cellules sont allumés, foretBrulee = true;
            // TODO : remove foretBrulee = true
            foretBrulee = true;
        }

        System.out.println(foret.toString());
    }
}
