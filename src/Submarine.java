/**
 * A ship with a length of one tiles.
 *
 * @author Grace
 *
 */
public class Submarine extends Ship {
    /**
     * Sets the inherited {@link #length} variable and initializes the {@link #hit} array,
     * based on the size of this ship (1 tiles).
     */
    public Submarine(){
        this.length = 1;
        this.hit = new boolean[]{false};
    }

    /**
     * @return "Submarine", indicating that this is a Battleship.
     */
    @Override
    public String getShipType() {
        return "Submarine";
    }
}
