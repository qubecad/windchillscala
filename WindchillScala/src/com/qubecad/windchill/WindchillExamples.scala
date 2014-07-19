import wt.part.WTPart
import wt.method.RemoteMethodServer
import wt.fc.PersistenceHelper
import wt.query.QuerySpec
import wt.query.SearchCondition
 
object WindchillExamples {
def main(args: Array[String]) {
  println("Hello, Windchill!")
 
 
  // Get MethodServer
 
  val remotemethodserver=RemoteMethodServer.getDefault();
 
  val name="examplePart"
 
  createPart(name)
 
  countParts(name)
 
}
 
def countParts (name:String){
 
//example query
 
  var qs=new QuerySpec(classOf[WTPart])
 
  qs.appendWhere(new SearchCondition(classOf[WTPart], WTPart.NAME,SearchCondition.LIKE, name));
  val qr = PersistenceHelper.manager.find(qs)
  println("Query results count: "+qr.size())
 
  val resultantPart=qr.nextElement()
  println(resultantPart.asInstanceOf[WTPart].getNumber())
 
}
 
 
 
 
 
def createPart(name:String){
 
//example create part
 
var part=WTPart.newWTPart()
part.setName(name)
 
 
PersistenceHelper.manager.store(part)
 
}
 
}