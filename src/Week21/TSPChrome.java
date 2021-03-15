package Week21;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class TSPChrome {
    double[][] dists;
    Integer[] tour;

    TSPChrome(double[][] dists) {
        this.dists = dists;
        this.tour = RandomTour();
    }

    TSPChrome(double[][] dists, Integer[] tour) {
        this.dists = dists;
        this.tour = tour;
    }

    public Integer[] RandomTour() {
        Integer[] cities = IntStream.range(0, dists.length).boxed().toArray(Integer[]::new);
        List<Integer> citiesList = Arrays.asList(cities);
        Collections.shuffle(citiesList);
        Integer[] tour = citiesList.toArray(cities);
        return tour;
    }


}
