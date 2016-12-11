object Main extends App {
  new Game().Init()
}


class Game() {

  var boardPrinter = BoardPrinter()


  def Init(): Unit = {

    val board = new StartingPosition().getBoard

    boardPrinter.printBoard(board)
  }

}