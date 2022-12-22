package machine
import org.junit.Test
import org.junit.Assert._

class TestMachineF1 {
  // initialisation des objets sous test
  val m: MachineDialogue = MachineImpl
  m.reinit

  @Test
  def testMairieRennesF1 {
    assertEquals(List("L'adresse de Mairie de Rennes est : Place de la Mairie"), m.test(List("Je cherche la Mairie")))
  }
  
  
  @Test
  def testMairieRennesSynoF1 {
    assertEquals(List(
      "L'adresse de Mairie de Rennes est : Place de la Mairie",
      "L'adresse de Mairie de Rennes est : Place de la Mairie",
      "L'adresse de Mairie de Rennes est : Place de la Mairie"), m.test(List("Je cherche la Mairie", "Et l'Hôtel de ville ?",
      "Mairie de Rennes")))
  }

  @Test
  def testTheatreNationalF1 {
    assertEquals(List("L'adresse de Théâtre National de Bretagne est : 1, Rue Saint-Hélier"), m.test(List("Je cherche le Théâtre de Bretagne")))
  }

  @Test
  def testTheatreNationalSynoF1 {
    assertEquals(List(
      "L'adresse de Théâtre National de Bretagne est : 1, Rue Saint-Hélier",
      "L'adresse de Théâtre National de Bretagne est : 1, Rue Saint-Hélier",
      "L'adresse de Théâtre National de Bretagne est : 1, Rue Saint-Hélier"), m.test(List("Je cherche le Théâtre de Bretagne", "TNB",
      "Théâtre National de Bretagne")))
  }

  @Test
  def testGareF1 {
    assertEquals(List("L'adresse de Gare SNCF est : 19, Place de la Gare"), m.test(List("et la Gare?")))
  }

  @Test
  def testGareSynoF1 {
    assertEquals(
      List("L'adresse de Gare SNCF est : 19, Place de la Gare", "L'adresse de Gare SNCF est : 19, Place de la Gare"),
      m.test(List("et la Gare ?", "Où est la Gare SNCF")))
  }

  @Test
  def testTheatrePailletteF1 {
    assertEquals(
      List("L'adresse de Théâtre La Paillette est : 2, Rue du Pré de Bris"),
      m.test(List("Je cherche le Théâtre la Paillette?")))
  }

  @Test
  def testTheatrePailletteSynoF1 {
    assertEquals(
      List(
        "L'adresse de Théâtre La Paillette est : 2, Rue du Pré de Bris",
        "L'adresse de Théâtre La Paillette est : 2, Rue du Pré de Bris"),
      m.test(List("Je cherche le Théâtre la Paillette?", "Et la Paillette ?")))
  }

  @Test
  def testjenecomprendspasvotredemandeF1 {
    assertEquals(List("Je ne comprends pas votre demande"), m.test(List("Je cherche")))
  }
}