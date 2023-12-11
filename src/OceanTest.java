import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import java.io.*;

import java.util.Scanner;

public class OceanTest {
    static Ocean o;
    static InputStream originalIn;
    static PrintStream originalOut;

    @BeforeEach
    void init() {
        o = new Ocean();
        o.ships = o.getShipArray();
        o.ships[0][0] = new Battleship();
        o.ships[0][0].placeShipAt(0,0, true, o);
        o.ships[2][0] = new Cruiser();
        o.ships[2][0].placeShipAt(2,0, true, o);
        o.ships[4][0] = new Destroyer();
        o.ships[4][0].placeShipAt(4,0, true, o);
        o.ships[6][0] = new Submarine();
        o.ships[6][0].placeShipAt(6,0, true, o);
    }

    @Test
    public void testOcean() {
        o = new Ocean();
        int shipCount = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                shipCount++;
                assertEquals("empty", o.ships[i][j].getShipType());
            }
        }
        assertEquals(100, shipCount);
    }
    
    @Test
    public void placeAllShipsRandomly() {
        o = new Ocean();
        o.placeAllShipsRandomly();
        o.ships = o.getShipArray();
        int bCount = 0;
        int cCount = 0;
        int dCount = 0;
        int sCount = 0;
        int eCount = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (o.ships[i][j].getShipType().equals("Battleship")) {
                    bCount++;
                } else if(o.ships[i][j].getShipType().equals("Cruiser")) {
                    cCount++;
                } else if(o.ships[i][j].getShipType().equals("Destroyer")) {
                    dCount++;
                } else if (o.ships[i][j].getShipType().equals("Submarine")) {
                    sCount++;
                } else {
                    eCount++;
                }
            }
        }
        assertEquals(4, bCount);
        assertEquals(6, cCount);
        assertEquals(6, dCount);
        assertEquals(4, sCount);
        assertEquals(80, eCount);
    }

    @Test
    public void isOccupied() {
        assertFalse(o.isOccupied(1,0));
        assertTrue(o.isOccupied(0,0));
        assertTrue(o.isOccupied(2,0));
        assertTrue(o.isOccupied(4,0));
        assertTrue(o.isOccupied(6,0));
    }

    @Test
    public void shootAt() {
        assertFalse(o.shootAt(1, 0)); //an emptySea
        assertTrue(o.shootAt(4, 0)); //a Destroyer
        assertTrue(o.shootAt(4, 0));
        assertTrue(o.shootAt(4, 1));
        assertFalse(o.shootAt(4, 1));
        assertFalse(o.shootAt(4, 0));
    }

    @Test
    public void getShotsFired() {
        o.shootAt(1, 0); //an emptySea
        o.shootAt(4, 0); //a Destroyer
        o.shootAt(4, 0);
        o.shootAt(4, 1);
        o.shootAt(4, 1);
        o.shootAt(4, 0);
        assertEquals(6, o.getShotsFired());
    }

    @Test
    public void getHitCount() {
        o.shootAt(1, 0); //an emptySea
        o.shootAt(4, 0); //a Destroyer
        o.shootAt(4, 0);
        o.shootAt(4, 1);
        o.shootAt(4, 1);
        o.shootAt(4, 0);
        assertEquals(3, o.getHitCount());
    }

    @Test
    public void getShipsSunk() {
        o.shootAt(4, 0);
        o.shootAt(4, 1);
        o.shootAt(6, 0);
        o.shootAt(0, 0);
        assertEquals(2, o.getShipsSunk());
    }

    @Test
    public void isGameOver() {
        o = new Ocean();
        o.placeAllShipsRandomly();
        o.ships = o.getShipArray();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                o.shootAt(i, j);
            }
        }
        assertTrue(o.isGameOver());
    }

    @Test
    public void getShipArray() {
        o.ships = o.getShipArray();
        EmptySea emptySea = new EmptySea();
        Battleship battleship = new Battleship();
        Cruiser cruiser = new Cruiser();
        Destroyer destroyer = new Destroyer();
        Submarine submarine = new Submarine();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if ((i==0 && j==0) || (i==0 && j==1) || (i==0 && j==2) || (i==0 && j==3)){
                    assertEquals(battleship.getShipType(), o.ships[i][j].getShipType());
                } else if ((i==2 && j==0) || (i==2 && j==1) || (i==2 && j==2)){
                    assertEquals(cruiser.getShipType(), o.ships[i][j].getShipType());
                } else if ((i==4 && j==0) || (i==4  && j==1) ){
                    assertEquals(destroyer.getShipType(), o.ships[i][j].getShipType());
                } else if ((i==6 && j==0)){
                    assertEquals(submarine.getShipType(), o.ships[i][j].getShipType());
                } else {
                    assertEquals(emptySea.getShipType(), o.ships[i][j].getShipType());
                }
            }
        }
    }

    @Test
    public void print() throws IOException {
        originalIn = System.in;
        originalOut = System.out;
        InputStream fileBegin = new FileInputStream("src/begin.txt");
        System.setIn(fileBegin);
        Scanner scnr = new Scanner(System.in);
        StringBuilder correctOceanBegin = new StringBuilder();
        while (scnr.hasNextLine()) {
            correctOceanBegin.append(scnr.nextLine()).append(" \n");
        }
        OutputStream startStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(startStream);
        System.setOut(printStream);
        o.print();
        String oceanBeginOutput = startStream.toString();
        assertEquals(correctOceanBegin.toString(), oceanBeginOutput);

        o.shootAt(0,0);
        o.shootAt(2,0);
        o.shootAt(4,0);
        o.shootAt(4,1);
        o.shootAt(6,0);
        o.shootAt(6,1);
        InputStream fileAfter = new FileInputStream("src/output.txt");
        System.setIn(fileAfter);
        scnr = new Scanner(System.in);
        StringBuilder correctOceanOutput = new StringBuilder();
        while (scnr.hasNextLine()) {
            correctOceanOutput.append(scnr.nextLine()).append(" \n");
        }
        OutputStream afterShotStream = new ByteArrayOutputStream();
        printStream = new PrintStream(afterShotStream);
        System.setOut(printStream);
        o.print();
        String oceanAfterShotOutput = afterShotStream.toString();
        assertEquals(correctOceanOutput.toString(), oceanAfterShotOutput);
        System.in.close();
        System.out.close();
        System.setIn(originalIn);
        System.setOut(originalOut);
    }
}