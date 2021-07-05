package pl.mateusz.common;

import com.fasterxml.jackson.databind.JsonNode;
import com.sun.codemodel.JDefinedClass;
import com.sun.codemodel.JFieldVar;
import org.jsonschema2pojo.AbstractAnnotator;

import javax.persistence.*;

public class HibernateAnnotator extends AbstractAnnotator {

    @Override
    public void propertyField(JFieldVar field, JDefinedClass clazz, String propertyName, JsonNode propertyNode) {
        super.propertyField(field, clazz, propertyName, propertyNode);

        // Note: does not have to be the propertyName, could be the field or propertyNode that is verified.

        //user
        if(propertyName.equals("user_id")) {
            clazz.annotate(Entity.class);
            clazz.annotate(Table.class).param("name", "quiz_user");
            field.annotate(Id.class);
            field.annotate(Column.class).param("name", "user_id");

            field.annotate(GeneratedValue.class).param("strategy", GenerationType.IDENTITY);
        }

        if(propertyName.equals("login")) {
            field.annotate(Column.class).param("name", "login");
        }

        if(propertyName.equals("password")) {
            field.annotate(Column.class).param("name", "password");
        }


        if(propertyName.equals("userrole")) {
            field.annotate(Enumerated.class).param("value", EnumType.STRING);
            field.annotate(Column.class).param("name", "userrole");
        }

        //question
        if(propertyName.equals("question_id")) {
            clazz.annotate(Entity.class);
            clazz.annotate(Table.class).param("name", "quiz_question");
            field.annotate(Id.class);
            field.annotate(Column.class).param("name", "question_id");

            field.annotate(GeneratedValue.class).param("strategy", GenerationType.IDENTITY);
        }

        if(propertyName.equals("question")) {
            field.annotate(Column.class).param("name", "question");
        }

        if(propertyName.equals("answers")) {
            field.annotate(Column.class).param("name", "answers");
            field.annotate(OneToMany.class)
                    .param("cascade", CascadeType.ALL)
                    .param("orphanRemoval", true);
        }

        if(propertyName.equals("trueanswers")) {
            field.annotate(Column.class).param("name", "trueanswers");
            field.annotate(OneToMany.class)
                    .param("cascade", CascadeType.ALL)
                    .param("orphanRemoval", true);
        }

        //answer
        if(propertyName.equals("answer_id")) {
            clazz.annotate(Entity.class);
            clazz.annotate(Table.class).param("name", "quiz_answer");
            field.annotate(Id.class);
            field.annotate(Column.class).param("name", "answer_id");

            field.annotate(GeneratedValue.class).param("strategy", GenerationType.IDENTITY);
        }

        if(propertyName.equals("answer")) {
            field.annotate(Column.class).param("name", "answer");
        }

        //true answer

        if(propertyName.equals("trueanswer_id")) {
            clazz.annotate(Entity.class);
            clazz.annotate(Table.class).param("name", "quiz_trueanswer");
            field.annotate(Id.class);
            field.annotate(Column.class).param("name", "trueanswer_id");

            field.annotate(GeneratedValue.class).param("strategy", GenerationType.IDENTITY);
        }

        if(propertyName.equals("trueanswer")) {
            field.annotate(Column.class).param("name", "trueanswer");
        }
    }
}