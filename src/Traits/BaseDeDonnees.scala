package Traits

trait BaseDeDonnees {
  
  /**
   * @return La bdd sous forme de liste clef, adresse
   */
  def bddFormatListe:List[(String, String)]
  
   /**
   * @return une liste de mot clé extrait de la base de donnée.
   */
  def obtenirMotClef:List[String]
  
  /**
   * Reçoit un mot clé en parametre
   * et retourne une liste d'adresse existant dans la base de donnée.
   * 
   * @param motClef mot clé
   * @return une liste d'adresse correspondant au mot clé.
   */
  def rechercheAdresse (motClef:String):List[(String,String)]
}