package traitement_et_BDD
import org.junit.Test
import org.junit.Assert._

class TestTools_object {
  @Test
  def distHamming {
    assertEquals(0, Tools_object.distanceHamming("Mairie", "Mairie"))
    assertEquals(1, Tools_object.distanceHamming("Mairte", "Mairie"))
  }

  @Test
  def TestdistanceHamming {
    assertEquals(2, Tools_object.distanceHamming("Hotel", "hôtel"))
    assertEquals(1, Tools_object.distanceHamming("Mairte", "Mairie"))
    assertEquals(-1, Tools_object.distanceHamming("Marie", "Mairie"))
    assertEquals(-1, Tools_object.distanceHamming("Mair", "Mairie"))
    assertEquals(-1, Tools_object.distanceHamming("Mai", "Mairie"))
    assertEquals(2, Tools_object.distanceHamming("Mairei", "Mairie"))
    assertEquals(-1, Tools_object.distanceHamming("Maiir", "Mairie"))
  }

  @Test
  def separemotminus {
    assertEquals(List("cherche", "maire"), Tools_object.lavage_essorage("Je cherche la Maire"))
    assertEquals(List("comprends", "pas", "votre", "demande"), Tools_object.lavage_essorage("Je ne comprends pas votre demande"))
  }

  @Test
  def separemotclef {
    assertEquals(List("mairie", "rennes"), Tools_object.lavage_essorage("Mairie de Rennes"))
    assertEquals(List("theatre", "national", "bretagne"), Tools_object.lavage_essorage("Théâtre National de Bretagne"))
    assertEquals(List("hotel", "ville"), Tools_object.lavage_essorage("Hôtel de ville"))
    assertEquals(List("bonjour", "est", "theatre", "paillette"), Tools_object.lavage_essorage("bonjour, Où est le théAtre la Paillette"))
  }

  @Test
  def chainedanslaListHamming {
    assertTrue(Tools_object.dansLaListe_Hamming("theatre", List("cherche", "theatre", "national")))
    assertFalse(Tools_object.dansLaListe_Hamming("bretagne", List("cherche", "theatre", "national")))
    assertTrue(Tools_object.dansLaListe_Hamming("national", List("cherche", "theatre", "national", "bretagne")))
    assertFalse(Tools_object.dansLaListe_Hamming("paillette", List("bonjour", "theatre", "bretagne")))
    assertTrue(Tools_object.dansLaListe_Hamming("paillette", List("bonjour", "theatre", "paillette")))
    assertTrue(Tools_object.dansLaListe_Hamming("mairie", List("maire", "cherche")))
  }

  @Test
  def distanceHammingmodif {
    assertEquals(0, Tools_object.distanceHammingF2("chin", "chien"))
    assertEquals(0, Tools_object.distanceHammingF2("chat", "chats"))
    assertEquals(1, Tools_object.distanceHammingF2("chat", "chot"))
    assertEquals(-1, Tools_object.distanceHammingF2("chat", "chu"))
    assertEquals(-1, Tools_object.distanceHammingF2("Moirie", "Maire"))
    assertEquals(0, Tools_object.distanceHammingF2("mairie", "maire"))
    assertEquals(0, Tools_object.distanceHammingF2("mairie", "maire"))
  }

  @Test
  def distanceHamminglettremanquante {
    assertTrue(Tools_object.manqueUneLettre("chin", "chien"))
    assertTrue(Tools_object.manqueUneLettre("mairie", "maire"))
  }

  @Test
  def clefdansreqhotilville {
    assertTrue(Tools_object.clefDansRequete(List("hotil", "ville"), List("hotel", "ville")))
    assertTrue(Tools_object.clefDansRequete(List("cherche", "maire"), List("mairie")))
  }

  @Test
  def clefdansreqTrue {
    assertTrue(Tools_object.clefDansRequete(List("bonjour", "ou", "est", "le", "theatre", "la", "paillette"), List("theatre", "paillette")))
  }

  @Test
  def clefdansreqFalse {
    assertFalse(Tools_object.clefDansRequete(List("bonjour", "ou", "est", "le", "theatre", "de", "bretagne"), List("theatre", "paillette")))
  }

  @Test
  def testseparationlisteclefs {
    assertEquals(List("Mairie de Rennes", "Hôtel de Ville", "Mairie"), Tools_object.separationclefs("Mairie de Rennes,Hôtel de Ville,Mairie"))
    assertEquals(List("Théâtre La Paillette", "la Paillette"), Tools_object.separationclefs("Théâtre La Paillette,la Paillette"))
  }
}