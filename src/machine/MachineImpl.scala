package machine
import traitement_et_BDD._

object MachineImpl extends MachineDialogue {

  /**
   * envoi d'une requête à la machine et récupération de sa réponse
   *  @param s la requête
   *  @result la liste de réponses
   */
  def ask(s: String): List[String] = {
    AnalysePhrase_object.reponse(s)
  }

  // Pour la partie test par le client
  def reinit = () 

  def test(l: List[String]): List[String] = {
    var Listretour: List[String] = List()
    for (requete <- l) {
      Listretour = Listretour ++ AnalysePhrase_object.reponse(requete)
    }
    Listretour
  }
}
