package machine
import org.junit.Test
import org.junit.Assert._

class TestMachineF2 {
  // initialisation des objets sous test
  val m: MachineDialogue = MachineImpl
  m.reinit

  @Test
  def testMairieRennesF2 {
    assertEquals(List("L'adresse de Mairie de Rennes est : Place de la Mairie"), m.test(List("Je cherche la Marie")))
  }

  @Test
  def testMairieRennesSynoF2 {
    assertEquals(
      List(
        "L'adresse de Mairie de Rennes est : Place de la Mairie",
        "L'adresse de Mairie de Rennes est : Place de la Mairie",
        "L'adresse de Mairie de Rennes est : Place de la Mairie"),
      m.test(List("Je cherche la Maire", "Hôtil de ville",
        "Marie de Rennes")))
  }

  @Test
  def testTheatreNationalF2 {
    assertEquals(List("L'adresse de Théâtre National de Bretagne est : 1, Rue Saint-Hélier"), m.test(List("Je cherche le Théâte de Bretagne")))
  }

  @Test
  def testTheatreNationalSynoF2 {
    assertEquals(List(
      "L'adresse de Théâtre National de Bretagne est : 1, Rue Saint-Hélier",
      "L'adresse de Théâtre National de Bretagne est : 1, Rue Saint-Hélier",
      "L'adresse de Théâtre National de Bretagne est : 1, Rue Saint-Hélier"), m.test(List("Je cherche le Théâtre de Bretagn", "TNC",
      "Theatre National de Bretagne")))
  }

  @Test
  def testGareF2 {
    assertEquals(List("L'adresse de Gare SNCF est : 19, Place de la Gare"), m.test(List("et la Gore ?")))
  }

  @Test
  def testGareSynoF2 {
    assertEquals(
      List("L'adresse de Gare SNCF est : 19, Place de la Gare", "L'adresse de Gare SNCF est : 19, Place de la Gare"),
      m.test(List("et la Gar ?", "Gare SNF")))
  }
  @Test
  def testMairieRennesF1_1 {
    assertEquals(List("L'adresse de Mairie de Rennes est : Place de la Mairie"), m.test(List("Je cherche la Marie")))
  }
  
  @Test
  def testMairieRennesF1_2 {
    assertEquals(List("L'adresse de Mairie de Rennes est : Place de la Mairie"), m.test(List("Je cherche la Maiirie")))
  }

  @Test
  def testTheatrePailletteF2 {
    assertEquals(
      List("L'adresse de Théâtre La Paillette est : 2, Rue du Pré de Bris"),
      m.test(List("Je cherche le Théâre de la Paillette?")))
  }
  
  @Test
  def testTheatrePailletteSynoF2 {
    assertEquals(
      List(
        "L'adresse de Théâtre La Paillette est : 2, Rue du Pré de Bris",
        "L'adresse de Théâtre La Paillette est : 2, Rue du Pré de Bris"),
      m.test(List("Je cherche le Thétre de la Paillette?", "Et la Paillatte ?")))
  } 
 
  @Test
  def testhotelvilleF2 {
    assertEquals(List(
      "L'adresse de Mairie de Rennes est : Place de la Mairie",
      "L'adresse de Mairie de Rennes est : Place de la Mairie"), m.test(List("l'hôtel de vile", "hôtl de valle")))
  }
  
  @Test
  def testjenecomprendspasvotredemandeF2 {
    assertEquals(List("Je ne comprends pas votre demande", "Je ne comprends pas votre demande", "Je ne comprends pas votre demande",
      "Je ne comprends pas votre demande"), m.test(List("l'hôt de ville", "Gareee SNCF", "Théâtre National de Breitage",
      "Théâtre la Paiiiette")))
  }
}