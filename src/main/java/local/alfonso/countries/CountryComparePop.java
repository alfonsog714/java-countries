package local.alfonso.countries;

import java.util.Comparator;

public class CountryComparePop implements Comparator<Country> {

    @Override
    public int compare(Country c1, Country c2)
    {
        return c1.getPopulation().compareTo(c2.getPopulation());
    }
}
