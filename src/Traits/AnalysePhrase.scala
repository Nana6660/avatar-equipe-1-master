package Traits

trait AnalysePhrase {
  
  /**
   * Reçoit une requete en parametre
   * et retourne une liste de reponse.
   * 
   * @param requete la requete entrée par l'utilisateur
   * @return retourne une liste de reponse.
   */
  def reponse(requete:String):List[String]
  
}