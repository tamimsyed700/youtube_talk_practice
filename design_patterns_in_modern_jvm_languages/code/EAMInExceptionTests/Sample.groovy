public class MyTest extends GroovyTestCase {
  public void testAccessEmptyList() {
    def list = []
    
    shouldFail(IndexOutOfBoundsException) { list.get(0) }
  }
}