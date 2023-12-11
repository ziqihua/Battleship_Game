/**
 * A Ship with a length of four tiles.
 *
 * @author Grace
 *
 */
public class Battleship extends Ship {

    /**
     * Sets the inherited {@link #length} variable and initializes the {@link #hit} array,
     * based on the size of this ship (4 tiles).
     */
    public Battleship(){
        this.length = 4;
        this.hit = new boolean[]{false, false, false, false};
    }

    /**
     * @return "Battleship", indicating that this is a Battleship.
     */
    @Override
    public String getShipType() {
        return "Battleship";
    }
}
