package traitement_et_BDD

import Traits.traitementxml
import scala.xml._

object traitementxml_object extends traitementxml {
  
  def traitement(): List[(String,String)] = {
    var listadd: List[(String,String)] = List()
    
    val fichierXML = XML.loadFile("lib/vAr.xml")
    
    val clename = (fichierXML \ "organisation" \ "name").map(_.text)
    val addressename = (fichierXML \ "organisation" \ "addresses" \ "address" \ "street" \ "name").map(_.text)
    require(clename.length == addressename.length) //ralenti beaucoup le temps d'execution
    val addressenumber = (fichierXML \ "organisation" \ "addresses" \ "address" \ "street" \ "number").map(_.text)
    require(clename.length == addressenumber.length) //ralenti beaucoup le temps d'execution
    for ( i <- 0 to addressenumber.length){
      listadd = listadd :+ (clename(i),addressenumber(i) + ", " + addressename(i))
    }
    
    /*fichierXML.text
    (fichierXML \ "organisation" ).foreach {organisation => 
      (organisation \ "name").text // marche pas car nodeseq
    }*/
    listadd
  }
}