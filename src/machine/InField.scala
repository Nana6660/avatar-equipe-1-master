package machine

import scala.swing._
import java.awt.Color

/**
 * Customized textfield receiving the input user request (la zone dans laquelle l'utilisateur peut saisir sa requete)
 */
class InField extends TextField {
  text = ""
  columns = 80
  border = Swing.LineBorder(Color.GRAY)
} 