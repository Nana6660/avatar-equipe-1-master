package traitement_et_BDD
import scala.io.Source
import Traits.BaseDeDonnees

object BaseDeDonnees_object extends BaseDeDonnees {
  val filename = "doc/DonneesInitiales.txt"
  def obtenirMotClef: List[String] = {

    //Liste de mot à ignorer
    val Liste: List[String] = List("le", "la", "les", "de", "des", "dans", "ou", "et", " ")

    //Liste de mot clé
    var ListeMotsClef: List[String] = List()

    //Recuperer tous les mots clés existant dans la base de donnée
    for (line <- Source.fromFile(filename).getLines) {
      var ListMot = line.split(";")(0).split(" ")
      for (mot <- ListMot) {
        if (!Liste.contains(mot.toLowerCase()) && !ListeMotsClef.contains(mot))
          if (mot.contains(",")) {
            var listmot = mot.split(",")
            for (m <- listmot) {
              ListeMotsClef = ListeMotsClef :+ m
            }
          } else {
            ListeMotsClef = ListeMotsClef :+ mot
          }

      }
    }

    return ListeMotsClef // retourne la liste de mot clés
  }

  def rechercheAdresse(motClef: String): List[(String, String)] = {
    var ListeAdresse: List[(String, String)] = List()

    //Recuperer toutes les lignes de notes base de donnée
    for (line <- Source.fromFile(filename).getLines) {

      //Recupere dans une liste toutes les adresses correspondantes au mot clé
      if (line.toLowerCase().contains(motClef.toLowerCase())) {

        ListeAdresse = ListeAdresse :+ (line.split(";")(0).split(",")(0), line.split(";")(1))
      }
    }
    return ListeAdresse
  }
  
  
  /**
   * renvoie une liste double des clés dans la première string et les adresses dans la deuxième string
   */
  def bddFormatListe: List[(String, String)] = {
    var ListeAdresse: List[(String, String)] = List()
    //Recuperer toutes les lignes de notes base de donnée
    for (line <- Source.fromFile(filename).getLines) {

      ListeAdresse = ListeAdresse :+ (line.split(";")(0), line.split(";")(1))

    }
    return ListeAdresse
  }

}