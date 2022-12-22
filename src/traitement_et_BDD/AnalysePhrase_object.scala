package traitement_et_BDD

import Traits.AnalysePhrase

object AnalysePhrase_object extends AnalysePhrase {

  def reponse(requete: String): List[String] = {
    // liste retour
    var listereponse: List[String] = List()

    //liste adresse de la base de donnée
    val clefsadresse = BaseDeDonnees_object.bddFormatListe
    //le normalizer  élimine les accents
    val separatedrequest = Tools_object.lavage_essorage(requete)
    
    for ((clefs, adr) <- clefsadresse) {
      var listclefs = Tools_object.separationclefs(clefs) //on sait que clefs est une string contenant des clefs
      for (key <- listclefs if listereponse.isEmpty) { //si la liste est non vide alors on a trouve le mot clef correspondant et on arrete la boucle
        var separatedkey: List[String] = Tools_object.lavage_essorage(key)

        if (Tools_object.clefDansRequete(separatedrequest, separatedkey)) {
          listereponse = listereponse :+ "L'adresse de " + listclefs(0) + " est : " + adr
        }
      }

    }

    if (listereponse.isEmpty) listereponse = List("Je ne comprends pas votre demande")
    
    val salutationKeys:List[String] = List("bonjour", "bonsoir","salut")
    for(salutation <- salutationKeys){
      if(Tools_object.dansLaListe_Hamming(salutation, separatedrequest)){
        if(separatedrequest.length == 1) listereponse = List("Bonjour")//Note : RALENTIT LE CODE TODO trouver une autre solution ASAP, Fonctionnel pour demo
        else listereponse = "Bonjour" :: listereponse
      }
    }

    listereponse

  }

}