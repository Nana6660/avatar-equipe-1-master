package machine

import scala.swing._
import java.awt.Color

/**
 * MainFrame realizing the Avatar application
 */
class InterfaceGraphique extends MainFrame {

  // Propriétés de la fenêtre
  title = "Avatar - Billy"
  preferredSize = new Dimension(850, 850)
  minimumSize = new Dimension(300, 300)

  // Quelques champs définissant les composants
  val input = new InField
  val Send = new SendButton("Envoyer", input, this)
  Send.background = new Color(97, 152, 209)
  Send.foreground = new Color(255, 255, 255)
  Send.maximumSize = new Dimension(100, 50)
  Send.preferredSize = new Dimension(100, 5)

  //b1 est un BoxPanel dont le rôle sera de contenir les différents Panel de requêtes et réponses du bot
  val b1 = new BoxPanel(Orientation.Vertical) {
    background = new Color(215, 215, 215)
  }

  /**
   * le Panel n'etant pas responsive, pour pouvoir tout afficher, on divise la/les reponses du bot en partie dont ':' etant le separateur
   * @param s une liste de String
   * @return une liste de String : pour chaque élément de s, on fait appel à la fonction sepString qui crée une liste composé de l'élément seul si il ne contient pas de ':',
   *         sinon on divise en deux parties : une ajoutée a la liste, l'autre partie rappelé ensuite par sepString
   */
  def separateurDesPartiesAdresse(s: List[String]): List[(String)] = {
    s match {
      case a :: suite => sepString(a) ::: separateurDesPartiesAdresse(suite)
      case Nil        => Nil
    }
  }

  /**
   * divise une chaine en une liste dont ':' est le séparateur
   * @param s un String
   * @return une liste de String, composé des élément de s séparés lorsqu'une occurrence de ':' est trouvée
   */
  def sepString(s: String): List[String] = {
    for (i <- 0 to s.size - 1) {
      if (s.charAt(i) == ':') {
        return s.substring(0, i + 1) :: sepString(s.substring(i + 2, s.length()))
      }
    }
    s :: Nil
  }

  /**
   * cette fonction a pour rôle d'ajouter la requête de l'utilisateur dans la discussion graphique, on créer un nouveau textUser : un label et on l'ajoute à b1 : le boxPanel de discussion
   * @param s un String : la requete de l'utilisateur
   */
  def ajouterMessageRequete(s: String) {
    val messAdd = new textUser(s)
    b1.contents += messAdd
    b1.revalidate
  }

  /**
   * cette fonction a pour rôle d'ajouter les réponses du bot dans la discussion graphique, on créer un/des nouveaux textAvatar : un label et on l'ajoute à b1 : le boxPanel de discussion
   * @param s une liste de String : la liste des réponses du bot (réponses de la requète de l'utilisateur)
   */
  def ajouterMessageList(s: List[String]) {
    for (elem <- s) {
      val messAdd = new textAvatar(elem)
      b1.contents += messAdd
      b1.revalidate
    }
  }

  /**
   * le rôle de cette fonction est purement esthétique : elle rajoute un espace entre les requetes/reponses quand elle est appelée :
   * pour cela on crée un Panel "invisible", c'est à dire de la même couleur que b1 : le boxPanel de discussion
   */
  def espaceEntrePanel() {
    val espaceEntreBouton = new Label
    espaceEntreBouton.opaque = true
    espaceEntreBouton.background = new Color(215, 215, 215)
    espaceEntreBouton.foreground = Color.BLACK
    espaceEntreBouton.minimumSize = new Dimension(300, 10)
    espaceEntreBouton.maximumSize = new Dimension(300, 10)
    espaceEntreBouton.preferredSize = new Dimension(300, 10)
    b1.contents += espaceEntreBouton
    b1.revalidate
  }

  //b2 est un boxPanel qui contient la zone de texte et le bouton d'envoi
  val b2 = new BoxPanel(Orientation.Horizontal) {
    contents += input
    contents += Send
    maximumSize = new Dimension(1920, 1080)
  }

  //Afin d'avoir un historique complet des messages, on crée un scrollPanel qui contient b1 : le boxPanel de discussion
  val scrollPanel = new ScrollPane(b1)

  // Ajout des composants à la fenêtre (le boxPanel qui contient les autres éléments)
  contents = new BoxPanel(Orientation.Vertical) {
    contents += scrollPanel
    contents += b2
  }
}