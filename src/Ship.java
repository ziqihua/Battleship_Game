import java.util.ArrayList;

/**
 * Ship is the abstract class for all the ships and sea tiles that will make up the game of Battleship.
 * Ships of all kinds are always considered to be facing up or to the left,
 * meaning that any portion of the ship that is not the bow will be at a higher numbered row or column than the bow.
 * @author Grace
 */
public abstract class Ship {

    /**
     * The column (0 to 9) which contains the bow (front) of the ship
     */
    protected int bowColumn;

    /**
     * The row (0 to 9) which contains the bow (front) of the ship
     */
    protected int bowRow;

    /**
     * The number of tiles occupied by the ship. Empty sea locations have a length of 1.
     * <ul>
     * <li>4 for a Battleship</li>
     * <li>3 for a Cruiser</li>
     * <li>2 for a Destroyer</li>
     * <li>1 for a Submarine</li>
     * <li>1 for a emptySea</li>
     * </ul>
     */
    protected int length;

    /**
     * hit is an array of four booleans telling whether that part of the ship has been hit.
     * Only battleships will use all four locations;
     * cruisers use only the first three;
     * destroyers the first two;
     * submarines and empty sea one.
     */
    protected boolean[] hit;

    /**
     * {@literal true} if the ship occupies a single row, {@literal false} otherwise.
     */
    protected boolean horizontal; //true if the ship occupies a single row, false otherwise.

    public Ship(){}


    /**
     * @return the column of the bow (front) of the ship
     */
    public int getBowColumn(){
        return bowColumn;
    }

    /**
     * @param bowColumn   the bowColumn to set
     */
    public void setBowColumn(int bowColumn){
        this.bowColumn = bowColumn;
    }

    /**
     * @return the row of the bow (front) of the ship
     */
    public int getBowRow(){
        return bowRow;
    }

    /**
     * @param bowRow   the row of the bow (front) of the ship
     */
    public void setBowRow(int bowRow){
        this.bowRow = bowRow;
    }

    /**
     * @return the length of the ship
     */
    public int getLength(){
        return length;
    }

    /**
     * @return the String representing the type of this ship.
     */
    public abstract String getShipType(); //return the String representing the type of this ship.

    /**
     * @return {@literal true} if this boat is horizontal (facing left), and
     *         {@literal false} otherwise.
     */
    public boolean isHorizontal(){
        return horizontal;
    }

    /**
     * @param horizontal   the horizontal to set
     */
    public void setHorizontal(boolean horizontal){
        this.horizontal = horizontal;
    }

    /**
     * Determines whether or not this is represents a valid placement configuration for this Ship in this Ocean.
     * Ship objects in an Ocean must not overlap other Ship objects or touch them vertically, horizontally, or diagonally.
     * Additionally, the placement cannot be such that the Ship would extend beyond the extents of the 2D array in which it is placed.
     * Calling this method should not actually change either the Ship or the provided Ocean.
     * @param row    the candidate row to place the ship
     * @param column the candidate column to place the ship
     * @param horizontal whether or not to have the ship facing to the left
     * @param ocean the Ocean in which this ship might be placed
     * @return {@literal true} if it is valid to place this ship of this length in this location with this orientation, and
     *         {@literal false} otherwise.
     */
    public boolean okToPlaceShipAt(int row, int column, boolean horizontal, Ocean ocean){
        Ship[][] shipsArray = ocean.getShipArray();
        if (this.getShipType().equals("Battleship")) {
            if (horizontal) {
                if (column + 4 > 10) {
                    return false;
                }
                for (int r = -1; r <= 1; r++) {
                    int checkRow = row + r;
                    for (int c = -1; c <= 4; c++) {
                        int checkColumn = column + c;
                        if (0 <= checkRow && checkRow <= 9 && 0 <= checkColumn && checkColumn <= 9) {
                            if (!shipsArray[checkRow][checkColumn].getShipType().equals("empty")) {
                                return false;}
                        }
                    }
                }
            } else {
                if (row + 4 > 10) {
                    return false;
                }
                for (int r = -1; r <= 4; r++) {
                    int checkRow = row + r;
                    for (int c = -1; c <= 1; c++) {
                        int checkColumn = column + c;
                        if (0 <= checkRow && checkRow <= 9 && 0 <= checkColumn && checkColumn <= 9) {
                            if (!shipsArray[checkRow][checkColumn].getShipType().equals("empty")) {
                                return false;}
                        }
                    }
                }
            }
        } else if (this.getShipType().equals("Cruiser")) {
            if (horizontal) {
                if (column + 3 > 10) {
                    return false;
                }
                for (int r = -1; r <= 1; r++) {
                    int checkRow = row + r;
                    for (int c = -1; c <= 3; c++) {
                        int checkColumn = column + c;
                        if (0 <= checkRow && checkRow <= 9 && 0 <= checkColumn && checkColumn <= 9) {
                            if (!shipsArray[checkRow][checkColumn].getShipType().equals("empty")) {
                                return false;}
                        }
                    }
                }
            } else {
                if (row + 3 > 10) {
                    return false;
                }
                for (int r = -1; r <= 3; r++) {
                    int checkRow = row + r;
                    for (int c = -1; c <= 1; c++) {
                        int checkColumn = column + c;
                        if (0 <= checkRow && checkRow <= 9 && 0 <= checkColumn && checkColumn <= 9) {
                            if (!shipsArray[checkRow][checkColumn].getShipType().equals("empty")) {
                                return false;}
                        }
                    }
                }
            }
        } else if (this.getShipType().equals("Destroyer")) {
            if (horizontal) {
                if (column + 2 > 10) {
                    return false;
                }
                for (int r = -1; r <= 1; r++) {
                    int checkRow = row + r;
                    for (int c = -1; c <= 2; c++) {
                        int checkColumn = column + c;
                        if (0 <= checkRow && checkRow <= 9 && 0 <= checkColumn && checkColumn <= 9) {
                            if (!shipsArray[checkRow][checkColumn].getShipType().equals("empty")) {
                                return false;}
                        }
                    }
                }
            } else {
                if (row + 2 > 10) {
                    return false;
                }
                for (int r = -1; r <= 2; r++) {
                    int checkRow = row + r;
                    for (int c = -1; c <= 1; c++) {
                        int checkColumn = column + c;
                        if (0 <= checkRow && checkRow <= 9 && 0 <= checkColumn && checkColumn <= 9) {
                            if (!shipsArray[checkRow][checkColumn].getShipType().equals("empty")) {
                                return false;}
                        }
                    }
                }
            }
        } else if (this.getShipType().equals("Submarine")) {
            for (int r = -1; r <= 1; r++) {
                int checkRow = row + r;
                for (int c = -1; c <= 1; c++) {
                    int checkColumn = column + c;
                    if (0 <= checkRow && checkRow <= 9 && 0 <= checkColumn && checkColumn <= 9) {
                        if (!shipsArray[checkRow][checkColumn].getShipType().equals("empty")) {
                            return false;
                        }
                    }
                }
            }
        } else if (this.getShipType().equals("empty")){
            return true;
        }
        return true;
    }

    /**
     * Puts the Ship in the Ocean.
     * This will give values to the {@link #bowRow}, {@link #bowColumn}, and {@link #horizontal} instance variables in the Ship.
     * This should also place a reference to this Ship in each of the one or more locations (up to four)
     * in the corresponding Ocean array this Ship is being placed in.
     * Each of the references placed in the Ocean will be identical since it is not possible to refer to a "part" of a ship,
     * only the whole ship.
     * @param row    the row to place the ship
     * @param column the column to place the ship
     * @param horizontal whether or not to have the ship facing to the left
     * @param ocean the Ocean in which this ship will be placed
     */
    public void placeShipAt(int row, int column, boolean horizontal, Ocean ocean) {
        Ship[][] shipsArray = ocean.getShipArray();
        this.setBowColumn(column);
        this.setHorizontal(horizontal);
        this.setBowRow(row);
        if (getShipType().equals("Submarine")) {
            shipsArray[row][column] = this;
        } else if (getShipType().equals("Destroyer")) {
            for (int i = 0; i < 2; i++) {
                if (horizontal) {
                    shipsArray[row][column + i] = this;
                } else {
                    shipsArray[row + i][column] = this;
                }
            }
        } else if (getShipType().equals("Cruiser")) {
            for (int i = 0; i < 3; i++) {
                if (horizontal) {
                    shipsArray[row][column + i] = this;
                } else {
                    shipsArray[row + i][column] = this;
                }
            }
        } else if (getShipType().equals("Battleship")) {
            for (int i = 0; i < 4; i++) {
                if (horizontal) {
                    shipsArray[row][column + i] = this;
                } else {
                    shipsArray[row + i][column] = this;
                }
            }
        }
    }

    /**
     * If a part of this ship occupies this coordinate,
     * and if the ship hasn't been sunk, mark the part of the ship at that coordinate as "hit".
     * @param row    the row to place the ship
     * @param column the column to place the ship
     * @return {@literal true} if this ship hasn't been sunk and a part of this ship occupies the given row and column, and
     *      {@literal false} otherwise.
     */
    public boolean shootAt(int row, int column) {
        if (!this.isSunk()) {
            if (this.horizontal) {
                if (row != this.getBowRow() || column < this.getBowColumn() || column > this.getBowColumn() + this.length - 1) {
                    return false;
                }
                int index = column - this.getBowColumn();
                this.hit[index] = true;
            } else {
                if (column!= this.getBowColumn() || row < this.getBowRow() || row > this.getBowRow() + this.length - 1) {
                    return false;
                }
                int index = row - this.getBowRow();
                this.hit[index] = true;
            }
            return true;
        }
        return false;
    }

    /**
     * Returns {@literal true} if this ship has been sunk and {@literal false} otherwise.
     * @return {@literal true} if every part of the ship has been hit, and
     *      {@literal false} otherwise.
     */
    public boolean isSunk(){
        ArrayList<Boolean> hitList = new ArrayList<>();
        for (boolean isHit : this.hit) {
            hitList.add(isHit);
        }
        return !hitList.contains(false);
    }

    /**
     * Returns a single character String to use in the Ocean's print method.
     * This method should return "x" if the ship has been sunk, and "S" if it has not yet been sunk.
     * This method can only be used to print out locations in the ocean that have been shot at;
     * it should not be used to print locations that have not been the target of a shot yet.
     * @return {@literal "x"} if this ship has been sunk, and
     *      {@literal "S"} otherwise.
     */
    @Override
    public String toString(){
        return isSunk() ? "x" : "S";
    }
}
