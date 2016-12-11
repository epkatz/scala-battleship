case class BoardPrinter() {

  def printBoard(board: Board): Unit = {
    val bearings = board.getAllShipBearings
      .map(i => (i._1, i._2) -> i._3)
      .toMap

    for (r <- 1 to board.size) {
      for (c <- 1 to board.size) {
        print(s"${bearings.getOrElse((r, c), "*")} ")
      }
      println()
    }
  }
}

class StartingPosition {

  val battleship: Battleship = {
    new Battleship(
      List[Bearing](Bearing(1, 2),
        Bearing(1, 3),
        Bearing(1, 4),
        Bearing(1, 5)))
  }

  val carrier: Carrier = {
    new Carrier(
      List[Bearing](Bearing(5, 2),
        Bearing(5, 3),
        Bearing(5, 4),
        Bearing(5, 5),
        Bearing(5, 6)))
  }

  val destroyer: Destroyer = {
    new Destroyer(
      List[Bearing](Bearing(2, 2),
        Bearing(3, 2),
        Bearing(4, 2)))
  }

  def getBoard: Board = {
     Board(List(battleship, carrier, destroyer))
  }

}


