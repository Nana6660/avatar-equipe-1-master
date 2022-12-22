package machine
import scala.swing._
import java.awt.Color
import java.awt.Font
/**
 * Customized label receiving one of the Bot's answers
 */

class textAvatar(s: String) extends BoxPanel(Orientation.Vertical) {
  //ici on crée un label, qui contient une réponse de l'avatar, on personnalise la position du texte, la couleur de fond, la couleur de police, la police, la taille du label et son alignement dans le BoxPanel
  val billy = new Label("  " + s)
  billy.horizontalAlignment = Alignment.Left
  billy.opaque = true
  billy.background = Color.WHITE
  billy.foreground = Color.BLACK
  billy.font = new Font("Helvetica", Font.PLAIN, 14)
  billy.minimumSize = new Dimension(400, 34)
  billy.maximumSize = new Dimension(400, 34)
  billy.preferredSize = new Dimension(400, 34)
  billy.xLayoutAlignment = (1.0)
  contents += billy
}