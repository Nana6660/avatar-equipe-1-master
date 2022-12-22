package traitement_et_BDD
import org.junit.Test
import org.junit.Assert._
import Traits._

class TestBaseDeDonnees {
  
  // initialisation des objets sous test

  //test
  @Test
  def TestObtenirMotClef{
  assertEquals(List("Mairie","Rennes","Hotel","Ville","Théâtre","National","Bretagne","Paillette","Gare","SNCF"),BaseDeDonnees_object.obtenirMotClef)
  }
  
  @Test
  def TestrechercheAdresse{
   assertEquals (List(("Mairie de Rennes","Place de la Mairie")),BaseDeDonnees_object.rechercheAdresse ("Mairie"))
   assertEquals (List(("Mairie de Rennes","Place de la Mairie")),BaseDeDonnees_object.rechercheAdresse ("Hotel"))
   assertEquals (List(("Gare SNCF","19, Place de la Gare")),BaseDeDonnees_object.rechercheAdresse ("Gare"))
   assertEquals(List(("Théâtre National de Bretagne","1, Rue Saint-Hélier"),("Théâtre La Paillette","2, Rue du Pré de Bris")),BaseDeDonnees_object.rechercheAdresse ("Théâtre"))
  }
}

