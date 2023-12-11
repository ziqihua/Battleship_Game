/**
 * A ship with a length of two tiles.
 *
 * @author Grace
 */
public class Destroyer extends Ship {
    /**
     * Sets the inherited {@link #length} variable and initializes the {@link #hit} array,
     * based on the size of this ship (2 tiles).
     */
    public Destroyer(){
        this.length = 2;
        this.hit = new boolean[]{false, false};
    }

    /**
     * @return "Destroyer", indicating that this is a Battleship.
     */
    @Override
    public String getShipType() {
        return "Destroyer";
    }
}
