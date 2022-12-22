package machine

import scala.swing._
import event._
import machine._
import java.awt.Color

/**
 * A button for send the request to the rest of the program
 * @param lab the label of the button
 * @param from the Infield from which the request that the user enters
 * @param interface to create a link with the interface
 */
class SendButton(lab: String, from: InField, interface: InterfaceGraphique) extends Button {

  //texte affiché sur le bouton "Envoyer"
  text = lab

  //Ici lorsque le bouton est cliqué, ou que la touche du clavier "Entrer" est utilisée, :
  //On récupère la requête de l’utilisateur, on récupère la/les réponses du bot, puis on affiche la requête et les réponses avec ajouterMessageRequete() et ajouterMessageList()
  //Afin que la scroolBar du scrollPanel descende automatiquement après les nouveaux ajouts, on lui defini sa valeur au maximum de la scrollBar
  this.reactions += {
    case ButtonClicked(_) => {
      var requete: String = from.text
      from.text = ""
      val e = MachineImpl.ask(requete)
      interface.espaceEntrePanel()
      interface.ajouterMessageRequete(requete)
      interface.espaceEntrePanel()
      interface.ajouterMessageList(interface.separateurDesPartiesAdresse(e))
      Swing.onEDT(interface.scrollPanel.verticalScrollBar.peer.setValue(interface.scrollPanel.verticalScrollBar.peer.getMaximum))
    }
  }
  from.listenTo(from.keys)
  from.reactions += {
    case KeyPressed(_, Key.Enter, _, _) => {
      var requete: String = from.text
      from.text = ""
      val e = MachineImpl.ask(requete)
      interface.espaceEntrePanel()
      interface.ajouterMessageRequete(requete)
      interface.espaceEntrePanel()
      interface.ajouterMessageList(interface.separateurDesPartiesAdresse(e))
      Swing.onEDT(interface.scrollPanel.verticalScrollBar.peer.setValue(interface.scrollPanel.verticalScrollBar.peer.getMaximum))
    }
  }
}