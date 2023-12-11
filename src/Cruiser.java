/**
 * A ship with a length of three tiles.
 *
 * @author Grace
 *
 */
public class Cruiser extends Ship {
    /**
     * Sets the inherited {@link #length} variable and initializes the {@link #hit} array,
     * based on the size of this ship (3 tiles).
     */
    public Cruiser(){
        this.length = 3;
        this.hit = new boolean[]{false, false, false};
    }

    /**
     * @return "Cruiser", indicating that this is a Battleship.
     */
    @Override
    public String getShipType() {
        return "Cruiser";
    }
}
