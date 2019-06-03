package local.alfonso.countries;

import java.util.concurrent.atomic.AtomicLong;

public class Country {
    private static final AtomicLong counter = new AtomicLong();
    private long id;
    private String name;
    private int population;
    private int landMass;
    private int medAge;

    public Country( String name, int population, int landMass, int medAge) {
        this.id = counter.incrementAndGet();
        this.name = name;
        this.population = population;
        this.landMass = landMass;
        this.medAge = medAge;
    }

    public Country(Country toClone)
    {
        this.id = toClone.getId();
        this.name = toClone.getName();
        this.population = toClone.getPopulation();
        this.landMass = toClone.getLandMass();
        this.medAge = toClone.getMedAge();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getLandMass() {
        return landMass;
    }

    public void setLandMass(int landMass) {
        this.landMass = landMass;
    }

    public int getMedAge() {
        return medAge;
    }

    public void setMedAge(int medAge) {
        this.medAge = medAge;
    }

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", population=" + population +
                ", landMass=" + landMass +
                ", medAge=" + medAge +
                '}';
    }
}
