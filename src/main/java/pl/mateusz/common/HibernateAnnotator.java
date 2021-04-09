package pl.mateusz.common;

import com.fasterxml.jackson.databind.JsonNode;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JFieldVar;
import org.jsonschema2pojo.AbstractAnnotator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.text.Annotation;

public class HibernateAnnotator extends AbstractAnnotator {

    @Override
    public void propertyField(JFieldVar field, JDefinedClass clazz, String propertyName, JsonNode propertyNode) {
        super.propertyField(field, clazz, propertyName, propertyNode);

        // Note: does not have to be the propertyName, could be the field or propertyNode that is verified.



        if(propertyName.equals("id")) {
            clazz.annotate(Entity.class);
            clazz.annotate(Table.class).param("name", "quiz_user");
            field.annotate(Id.class);
            field.annotate(Column.class).param("name", "id");
        }


        if(propertyName.equals("login")) {
            field.annotate(Column.class).param("name", "login");
        }

        if(propertyName.equals("password")) {
            field.annotate(Column.class).param("name", "password");
        }


    }
}