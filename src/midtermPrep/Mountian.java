package midtermPrep;

/**
 * Mountian defined by its altitude and name.
 * @author Rianna McIntyre
 */
public class Mountian implements Comparable<Mountian>{
    private int altitude;
    private String name;

    Mountian(String name, int altitude){
        this.name = name;
        this.altitude = altitude;
    }

    public int getAltitude() {
        return altitude;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Mountain's name: " + name + ".\n"
                + "Mountain's Altitude: " + altitude + ".\n";
    }

    @Override
    public int compareTo(Mountian otherMountain) {
        //Compares mountains by altitude...
        return Integer.compare(this.altitude, otherMountain.altitude);
    }
}
