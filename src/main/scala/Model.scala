case class Bearing(row: Int, column: Int)

abstract class Ship(bearings: Seq[Bearing]) {
  def strength: Int
  def marking: Char
  var health: Int = strength

  def isAlive: Boolean = {
    strength - health == 0
  }

  def takeDamage(): Unit = {
    health = health - 1
  }

  def getBearings: Seq[(Int, Int, Char)] = {
    bearings.map(b => Tuple3(b.row, b.column, marking))
  }
}

class Battleship(bearings: Seq[Bearing]) extends Ship(bearings) {
  override def strength: Int = 4
  override def marking = 'B'
}

class Destroyer(bearings: Seq[Bearing]) extends Ship(bearings) {
  override def strength: Int = 3
  override def marking: Char = 'D'
}

class Carrier(bearings: Seq[Bearing]) extends Ship(bearings) {
  override def strength: Int = 5
  override def marking: Char = 'C'
}

case class Board(ships: Seq[Ship], size: Int = 8) {
  def getAllShipBearings: Seq[(Int, Int, Char)] = {
    ships.flatMap(_.getBearings)
  }
}
