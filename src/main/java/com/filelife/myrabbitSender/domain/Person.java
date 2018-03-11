package com.filelife.myrabbitSender.domain;

import java.lang.reflect.Type;

import javax.persistence.Entity;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

@Entity
public final class Person {
	private String name;
	private String surname;
	private Integer age;
	private String email;
    public Person parent;
	
	private Person () {};
	
	public  static Person generatePerson () {
		return new Person();
	}
	
	/*public static class PersonSerializer implements JsonSerializer<Person> {
        public JsonElement serialize(final Person person, final Type type, final JsonSerializationContext context) {
            JsonObject result = new JsonObject();
            result.add("name", new JsonPrimitive(person.getName()));
            Person parent = person.getParent();
            if (parent != null) {
                result.add("parent", new JsonPrimitive(parent.getId()));
            }
            return result;
        }
    }*/
	
}
