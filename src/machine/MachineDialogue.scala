package machine

trait MachineDialogue {
  /** envoi d'une requête à la machine et récupération de sa réponse
   *  @param s la requête
   *  @result la liste de réponses
   */
  def ask(s:String):List[String]
  
  // Pour la partie test par le client
  /** réinitialisation de l'avatar */
  def reinit:Unit
  
  /** test de l'avatar
   *  @param l une liste de requête
   *  @return la liste des réponses produites par l'avatar */
	def test(l:List[String]):List[String]
  
}