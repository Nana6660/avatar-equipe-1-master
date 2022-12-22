package machine
import org.junit.Test
import org.junit.Assert._

class TestMachineF5 {
  
  val m: MachineDialogue = MachineImpl
  m.reinit
  
  @Test
  def testPiscineF5 {
    assertEquals(
      List("L'adresse de Piscine Villejean est : 1, SQUARE D'ALSACE"),
      m.test(List("Je cherche la piscine de villejean")))
    assertEquals(
        List("L'adresse de Piscine Bréquigny est : 10, Boulevard Albert 1er"),
        m.test(List("Je cherche la piscone de brequigny")))
    
  }
}