package hm.fr.whilefeature;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WhileFeature {

    /**
     * takeWhile : retourne tous les éléments d'un stream ordonné jusqu'au premier élément qui échoue
     * si la conidition n'est pas vérifiée aucun élément n'est retourné
     */
    public List<Integer> takeWhile(Stream<Integer> stream) {
        return stream
                .takeWhile(n -> n % 2 == 0)
                .collect(Collectors.toList());
    }

    /**
     *
     * A l'inverse de takeWhile aucun flux n'est retourné si la condition est vérifiée
     * Il retournera un nouveau flux composé du premier élément ayant échoué plus tous
     * les éléments qui le suivent.
     */
    public List<Integer> dropWhile(Stream<Integer> stream) {
        return stream
                .dropWhile(n -> n % 2 == 0)
                .collect(Collectors.toList());
    }

}
