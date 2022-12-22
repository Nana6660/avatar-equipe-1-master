package Traits

trait Tools {

  /**
   * prend en entree une une string compose de plusieurs clefs et
   * decompose en une liste des dites clefs
   */
  def separationclefs(clefs: String): List[String]

  /**
   * Separe une String en une liste de String
   * Phase de lavage.
   *  1 La chaine est passée en minsucule
   *  2 La chaine perds ses carac speciaux de type accent
   *  3 La chaine perds les autres caracs speciaux et les transforme en ' '
   * Phase d'essorage.
   *  4 Il y a une separation au niveau des espace de la chaine pour en faire une liste de mot
   *  et elimine les mots de taille 2
   */
  def lavage_essorage(requete: String): List[String]

  /**
   * Prend en entrée une clef passé dans le lavage et l'essorage
   * et prend en entrée la requete passé dans le lavage et l'essorage
   * et renvoi un booleen vrai si l'ensemble de la clef existe dans la requete
   */
  def clefDansRequete(separatedrequest: List[String], separatedkey: List[String]): Boolean
  
  /**
   * prend en parametre deux mots dont la difference de taille est de 1 caractere
   * renvoie true si les chaines sont les meme avec la lettre manquante
   * renvoi false si les chaines sont differentes avec la lettre manquante
   */
  def manqueUneLettre(mot1: String, mot2: String): Boolean
  
    /**
   * Verifie que la String est dans la liste mais en appliquant 
   * la verification du a la distance de Hamming
   */
  def dansLaListe_Hamming(s: String, separatedrequest: List[String]): Boolean
}