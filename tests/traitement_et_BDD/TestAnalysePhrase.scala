package traitement_et_BDD
import org.junit.Test
import org.junit.Assert._
import Traits._

class TestAnalysePhrase {
  
  // initialisation des objets sous test
  
  //Test

  @Test
  def jenecomprendpas{
    assertEquals(List("Je ne comprends pas votre demande"),AnalysePhrase_object.reponse("Je cherche"))
  }

  @Test
  def reponse2 {
    assertEquals(List("L'adresse de Mairie de Rennes est : Place de la Mairie"), AnalysePhrase_object.reponse("Je cherche la Mairie"))
    assertEquals(List("L'adresse de Gare SNCF est : 19, Place de la Gare"), AnalysePhrase_object.reponse("et la Gare?"))
    assertEquals(List("Je ne comprends pas votre demande"), AnalysePhrase_object.reponse("je cherche"))
    assertEquals(List("Je ne comprends pas votre demande"), AnalysePhrase_object.reponse("Ou est la plage?"))
    assertEquals(List("Je ne comprends pas votre demande"), AnalysePhrase_object.reponse("L'adresse de Saint-malo"))
    assertEquals(List("L'adresse de Théâtre La Paillette est : 2, Rue du Pré de Bris"), AnalysePhrase_object.reponse("la Paillette"))
    assertEquals(List("Je ne comprends pas votre demande"), AnalysePhrase_object.reponse("l'adresse du Théâtre"))
    assertEquals(List("L'adresse de Théâtre La Paillette est : 2, Rue du Pré de Bris"), AnalysePhrase_object.reponse("Je veux connaitre ou se trouve le Théâtre La Paillette"))
    assertEquals(List("Je ne comprends pas votre demande"), AnalysePhrase_object.reponse("La banque est situé ou?"))
   }
  
  @Test
  def reponse3 {
    assertEquals(List("L'adresse de Mairie de Rennes est : Place de la Mairie"),AnalysePhrase_object.reponse("Hôtil de ville"))
    assertEquals(List("L'adresse de Mairie de Rennes est : Place de la Mairie"),AnalysePhrase_object.reponse("Je cherche la Maire"))
  }
  

  
  
}