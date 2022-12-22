package traitement_et_BDD
import Traits.Tools
import java.text.Normalizer

object Tools_object extends Tools {

  /**
   * renvoi -1 si les mots sont de tailles differentes
   * sinon renvoi la somme des carac differents entre les deux chaines
   */
  def distanceHamming(mot1: String, mot2: String): Int = {
    var count = -1
    if (mot1.length() == mot2.length()) {
      count = 0
      for (i <- 0 to mot1.length() - 1) {
        if (mot1.charAt(i) != mot2.charAt(i)) {
          count = count + 1
        }
      }
    }
    count
  }

  /**
   * Cette version modifie de Hamming traite le cas d'une lettre manquante et renvoie 0 si malgré la lettremanquante le mot est le bon
   * exemple : hotl, hotel = 0
   * Elle repond aux attentes F2 du client
   */
  def distanceHammingF2(mot1: String, mot2: String): Int = {
    require(mot1 != "" && mot2 != "")
    if (Math.abs(mot1.length() - mot2.length()) == 1) {
      if (manqueUneLettre(mot1, mot2)){
        0
      }
      else -1
    } else {
      distanceHamming(mot1, mot2)
    }
  }
  
  
  /**
   * prend en parametre deux mots dont la difference de taille est de 1 caractere
   * renvoie true si les chaines sont les meme avec la lettre manquante
   * renvoi false si les chaines sont differentes avec la lettre manquante
   */
  def manqueUneLettre(mot1: String, mot2: String): Boolean = {
    require(Math.abs(mot1.length()-mot2.length())==1)
    var lettrintruse: Boolean = true
    var motmodif: String = ""
    for (i <- 0 to math.min(mot1.length(), mot2.length()) - 1 if lettrintruse) {
      if (mot1.charAt(i) != mot2.charAt(i)) {
        if (mot1.length() < mot2.length()) {
          motmodif = mot2.substring(0, i) + mot2.substring(i + 1)
          lettrintruse = false
        } else { //comme on sait deja qu'elle sont de meme longueur, inutile de traiter l'egalite
          motmodif = mot1.substring(0, i) + mot1.substring(i + 1)
          lettrintruse = false
        }
      }
    }
    if(lettrintruse){
      motmodif=mot1
    }
    if (mot1.compareTo(motmodif) == 0 || mot2.compareTo(motmodif) == 0) {
      true
    } else false
  }

  /**
   * Separe une String en une liste de String
   * Phase de lavage.
   *  1 La chaine est passée en minsucule
   *  2 La chaine perds ses carac speciaux de type accent
   *  3 La chaine perds les autres caracs speciaux et les transforme en ' '
   * Phase d'essorage.
   *  4 Il y a une separation au niveau des espace de la chaine pour en faire une liste de mot
   *  et elimine les mots de taille 2
   *  
   *  AKA le LAVAISSORATOR
   */
  def lavage_essorage(requete: String): List[String] = {
    var listemots: List[String] = List()
    var modifiedrequest = Normalizer.normalize(requete.toLowerCase(), Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "")
    //https://stackoverflow.com/questions/3322152/is-there-a-way-to-get-rid-of-accents-and-convert-a-whole-string-to-regular-lette
    //Pour l'explication du normalizer et la disparition des accents
    for (i <- 0 to modifiedrequest.length() - 1) {
      var charat = modifiedrequest.charAt(i) //economise quasi r en temps, mais bon, ca eco
      if (charat < 'a' || charat > 'z') {
        modifiedrequest = modifiedrequest.replace(charat, ' ')
      }
    }

    for (mot <- modifiedrequest.split(" ")) { //  .foreach(requete.replace(_, ' '))
      if (mot.length() > 2) { //degage tout ce qui est "le""la" "de" etc...(evite d'ajouter des mots inutiles a la liste)
        listemots = listemots :+ mot
      }
    }
    listemots
  }

  /**
   * Verifie que la String est dans la liste mais en appliquant 
   * la verification du a la distance de Hamming
   */
  def dansLaListe_Hamming(s: String, separatedrequest: List[String]): Boolean = {
    var Hammingpasse: Boolean = false
    for (pieceofrequest <- separatedrequest if !Hammingpasse) {
      var distHamm = distanceHammingF2(s, pieceofrequest)
      if (distHamm != -1 && distHamm <= 1) {
        Hammingpasse = true
      }
    }
    Hammingpasse
  }
  
    /**
   * Permet de separer une String de mot clefs dont le separateur est "," en liste de clefs
   */
  def separationclefs(clefs: String): List[String] = {
    var listeclefs: List[String] = List()

    for (cle <- clefs.split(",")) {
      listeclefs = listeclefs :+ cle
    }
    listeclefs
  }

  /**
   * Prend en entrée une clef passé dans le lavage et l'essorage
   * et prend en entrée la requete passé dans le lavage et l'essorage
   * et renvoi un booleen vrai si l'ensemble de la clef existe dans la requete
   */
  def clefDansRequete(separatedrequest: List[String], separatedkey: List[String]): Boolean = {
    var Hammingpasseoneverypieceofkey: Boolean = true
    for (pieceofkey <- separatedkey if Hammingpasseoneverypieceofkey) {
      Hammingpasseoneverypieceofkey = Hammingpasseoneverypieceofkey && dansLaListe_Hamming(pieceofkey, separatedrequest)
    }
    Hammingpasseoneverypieceofkey

  }
}