import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;

public class Main {

    public static void main(String[] args) throws Exception {

        SchemaFactory factory =
                SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

        Schema schema = factory.newSchema(
                new File("src/main/resources/films.xsd")
        );

        Validator validator = schema.newValidator();

        validator.validate(
                new StreamSource(new File("src/main/resources/films.xml"))
        );

        System.out.println("Document XML valide !");
    }
}