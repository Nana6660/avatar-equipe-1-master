package machine
import scala.swing._
import java.awt.Color
import java.awt.Font
/**
 * Customized label receiving a request from the user
 */

class textUser(s: String) extends BoxPanel(Orientation.Vertical) {
  //ici on crée un label, qui contient une requête de l'utilisateur, on personnalise la position du texte, la couleur de fond, la couleur de police, la police, la taille du label et son alignement dans le BoxPanel
  val user = new Label(s + "  ")
  user.horizontalAlignment = Alignment.Right
  user.opaque = true
  user.background = new Color(117, 243, 137)
  user.foreground = Color.BLACK
  user.font = new Font("Helvetica", Font.PLAIN, 14)
  user.minimumSize = new Dimension(400, 34)
  user.maximumSize = new Dimension(400, 34)
  user.preferredSize = new Dimension(400, 34)
  user.xLayoutAlignment = (0.0)
  contents += user
}