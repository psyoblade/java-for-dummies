package me.suhyuk;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/**
 * 
 * https://github.com/google/gson/blob/master/UserGuide.md
 * https://www.mkyong.com/java/how-do-convert-java-object-to-from-json-format-gson-api/
 * http://www.javacreed.com/gson-annotations-example/
 * 
 * @author psyoblade
 *
 */
public class GsonForDummies {

	public static void main(String[] args) {
		Staff staff = createDummyObject();
		Gson gson = new Gson();
		JsonElement json = gson.toJsonTree(staff, Staff.class);
		System.out.println(json.toString());
		JsonObject o = json.getAsJsonObject();
		for (String key : o.keySet()) {
			Object value = o.get(key);
			System.out.println(String.format("key:%s, value:%s", key, value));
		}
	}
	
	private static Staff createDummyObject() {

        Staff staff = new Staff();

        staff.setName("mkyong");
        staff.setAge(35);
        staff.setPosition("Founder");
        staff.setSalary(new BigDecimal("10000"));

        List<String> skills = new ArrayList<>();
        skills.add("java");
        skills.add("python");
        skills.add("shell");

        staff.setSkills(skills);

        return staff;

    }
}
