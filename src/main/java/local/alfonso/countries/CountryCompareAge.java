package local.alfonso.countries;

import java.util.Comparator;

public class CountryCompareAge implements Comparator<Country> {
    @Override
    public int compare(Country c1, Country c2)
    {
        return c1.getMedAge().compareTo(c2.getMedAge());
    }
}
