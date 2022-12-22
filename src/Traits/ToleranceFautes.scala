package Traits

trait ToleranceFautes {
  /**
   * Reçoit deux mots clé en parametre
   * 
   * @param mot1 mot clé fourni par l'utilisateur
   * @param mot2 mot clé correct existant dans notre systeme
   * @return le nombre d'erreur entre les deux mots clés.
   */
  def distanceHamming(mot1:String, mot2:String):Int
  
  def CompareMotDeMemeTaille(mot1:String, mot2:String):Int
  
  def CompareMotTailleDifferent(mot1:String, mot2:String):Int
  
  
  /**
   * A partir d'un mot clé entré par l'utilisateur et une liste de mots clés corrects
   * retourne un mot clé correct.
   * 
   * @param motClefIncorrect mot clé fourni par l'utilisateur
   * @param listeMotsClefCorrect Liste de mots clés existant dans notre systeme
   * @return retourne un mot clé correct, existant dans la liste si le mot fourni par l'utilisateur 
   * est compris par le programme
   */
  def corrigerMotCle(motClefIncorrect:String, listeMotsClefCorrect:List[String]): String
}