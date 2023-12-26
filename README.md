How to play the game:
The computer will place the ten ships in the ocean in such a way that no ships are immediately adjacent to each other horizontally, vertically, or diagonally. 
To start, the human player will not know where the ships are. The initial display of the ocean will show a 10x10 array of locations, all the same. 
The human player tries to hit the ships by providing a row and column number. The computer will respond with a single message: hit, if the coordinate corresponds to a tile containing a ship, or miss if the coordinate corresponds to an empty ocean tile.
A ship is “sunk” when every tile making up the ship has been hit. It takes four hits (in the four different tiles) to sink a battleship, but only one hit to sink a submarine. 
When a ship is hit but not sunk, the program does not provide any information about what kind of a ship was hit. However, when the last tile of a ship is hit and the ship sinks, the program will print out the message: You just sunk a <SHIP_TYPE>.
When all ships have been sunk, the program should print out a message that the game has concluded, and indicate how many shots were required.
