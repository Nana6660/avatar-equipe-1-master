package machine
import org.junit.Test
import org.junit.Assert._

class TestMachineF3 {
  // initialisation des objets sous test
  val m: MachineDialogue = MachineImpl
  m.reinit

  // tests

  @Test
  def testGareF3 {
    assertEquals(
      List("Bonjour", "L'adresse de Gare SNCF est : 19, Place de la Gare"),
      m.test(List("Bonjour, et la are ?")))
  }
  
 @Test
  def testTheatrePailletteF3 {
    assertEquals(
      List("Bonjour", "L'adresse de Théâtre La Paillette est : 2, Rue du Pré de Bris"),
      m.test(List("Bonjour, je cherche le Théâre de la Paillette?")))
  }
  
  @Test
  def testhotelvilleavecfauteF3 {
    assertEquals(List("Bonjour", "L'adresse de Mairie de Rennes est : Place de la Mairie",
      "Bonjour", "L'adresse de Mairie de Rennes est : Place de la Mairie"), m.test(List("Bonjour, l'hôtel de ville", "Bonjour, hôtl de valle")))
  }
  
@Test
  def testhotelvilleF3 {
    assertEquals(List("Bonjour", "L'adresse de Mairie de Rennes est : Place de la Mairie",
      "Bonjour", "L'adresse de Mairie de Rennes est : Place de la Mairie"), m.test(List("BonjOur, l'hôtel de ville", "Bonjour, hôtl de valle")))
  }

  @Test
  def testMairieRennesF3 {
    assertEquals(List("Bonjour", "L'adresse de Mairie de Rennes est : Place de la Mairie"), m.test(List("Bonjour, ou se trouve la Mairie")))
  }
  
  @Test
  def testjenecomprendspasvotredemandeF3 {
    assertEquals(List("Bonjour", "Je ne comprends pas votre demande"), m.test(List("Bonjour, comment tu t'appelles")))
  }
  
  @Test
  def testSalutF3 {
    assertEquals(List("Bonjour", "Je ne comprends pas votre demande"), m.test(List("salut, comment tu t'appelles")))
  }
  
  @Test
  def testbonsoirF3 {
    assertEquals(List("Bonjour", "Je ne comprends pas votre demande"), m.test(List("bonsoir, comment tu t'appelles")))
  }
  @Test
  def testbonjoursimple {
    assertEquals(List("Bonjour"), m.test(List("bonjour")))
  }
  
  
}