package step32.sax;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class Test01 {

  public static void main(String[] args) throws Exception {
    SAXParserFactory spf = SAXParserFactory.newInstance();
    System.out.println(spf.getClass().getName());
    
    spf.setNamespaceAware(true);
    SAXParser saxParser = spf.newSAXParser();

  }

}
