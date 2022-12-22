package traitement_et_BDD
import org.junit.Test
import org.junit.Assert._

class TestTraitementXML {
  
  @Test
  def Test1{
  traitementxml_object.traitement().foreach( f => println(f._1 + "_____" + f._2))
  }
}