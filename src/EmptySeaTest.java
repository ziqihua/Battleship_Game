import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EmptySeaTest {
    static EmptySea EmptySeaTest;
    static Ocean ocean;

    @BeforeEach
    void init() {
        EmptySeaTest = new EmptySea();
        ocean = new Ocean();
    }

    @Test
    public void testEmptySea(){
        assertEquals(1, EmptySeaTest.length);
        assertEquals(1, EmptySeaTest.hit.length);
    }

    @Test
    public void testGetShipType() {
        assertEquals("empty", EmptySeaTest.getShipType());
    }

    @Test
    public void testGetLength() {
        assertEquals(1, EmptySeaTest.getLength());
    }

    @Test
    public void testGetBowRow() {
        EmptySeaTest.setBowRow(0);
        assertEquals(0, EmptySeaTest.getBowRow());
    }

    @Test
    public void testGetBowColumn() {
        EmptySeaTest.setBowColumn(1);
        assertEquals(1, EmptySeaTest.getBowColumn());
    }

    @Test
    public void testSetBowColumn() {
        EmptySeaTest.setBowColumn(1);
        assertEquals(1, EmptySeaTest.bowColumn);
    }

    @Test
    public void testSetBowRow() {
        EmptySeaTest.setBowRow(0);
        assertEquals(0, EmptySeaTest.bowRow);
    }

    @Test
    public void testIsHorizontal() {
        EmptySeaTest.setHorizontal(true);
        assertTrue(EmptySeaTest.isHorizontal());
    }

    @Test
    public void testSetHorizontal() {
        EmptySeaTest.setHorizontal(false);
        assertFalse(EmptySeaTest.horizontal);
    }

    @Test
    public void testPlaceShipAt() {
        EmptySeaTest.placeShipAt(9,0,true,ocean);
        assertEquals(9, EmptySeaTest.getBowRow());
        assertEquals(0, EmptySeaTest.getBowColumn());
        assertTrue(EmptySeaTest.horizontal);
    }

    @Test
    public void testOkToPlaceShipAt() {
        assertTrue(EmptySeaTest.okToPlaceShipAt(0, 0,true,ocean));
        assertTrue(EmptySeaTest.okToPlaceShipAt(0, 1,true,ocean));
        assertTrue(EmptySeaTest.okToPlaceShipAt(0, 2,true,ocean));
        assertTrue(EmptySeaTest.okToPlaceShipAt(0, 3,true,ocean));
        assertTrue(EmptySeaTest.okToPlaceShipAt(0, 4,true,ocean));
        assertTrue(EmptySeaTest.okToPlaceShipAt(0, 5,true,ocean));
        assertTrue(EmptySeaTest.okToPlaceShipAt(0, 6,true,ocean));
        assertTrue(EmptySeaTest.okToPlaceShipAt(0, 7,true,ocean));
        assertTrue(EmptySeaTest.okToPlaceShipAt(0, 8,true,ocean));
        assertTrue(EmptySeaTest.okToPlaceShipAt(0, 9,true,ocean));
        assertTrue(EmptySeaTest.okToPlaceShipAt(9, 0,false,ocean));
        assertTrue(EmptySeaTest.okToPlaceShipAt(9, 9,false,ocean));

        EmptySeaTest.placeShipAt(3, 5, false, ocean);
        assertTrue(EmptySeaTest.okToPlaceShipAt(3, 3, false, ocean));
        assertTrue(EmptySeaTest.okToPlaceShipAt(2, 4, false, ocean));
    }


    @Test
    public void testShootAt() {
        EmptySeaTest.placeShipAt(9,0,true,ocean);
        assertFalse(EmptySeaTest.shootAt(0,0));
        assertFalse(EmptySeaTest.shootAt(9,0));
    }

    @Test
    public void testIsSunk() {
        assertFalse(EmptySeaTest.isSunk());
    }

    @Test
    public void testToString(){
        assertEquals("-", EmptySeaTest.toString());
    }
}