package com.banglore_team.validation;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Banglore_Team_validatio {

	@Test
	public void banglore_ream() throws IOException, ParseException {

		JSONParser jsonparse = new JSONParser();

		FileReader file = new FileReader(
				"D:\\Workspace\\Rushi\\project\\src\\main\\java\\com\\banglore_team\\validation\\folder\\BangloreTeam.json");
		Object object = jsonparse.parse(file);

		JSONObject empobject = (JSONObject) object;

		Object Team_Name = empobject.get("name");

		System.out.println("Team Name is:-" + Team_Name);
		Object Location = empobject.get("name");

		System.out.println("location:-" + Location);

		JSONArray array = (JSONArray) empobject.get("player");

		System.out.println("Total Player for Match :-" + array.size());
		System.out.println();
		int conditions = 0;

		// Test 1 : validation for Team having only 4 foreign palyer
		int Forien_Player_Country_count = 0;
		for (int i = 0; i < array.size(); i++) {
			JSONObject data = (JSONObject) array.get(i);
			Object Country = data.get("country");
			String Player_Country = (String) Country;
			if (!Player_Country.equalsIgnoreCase("India")) {
				System.out.println("foreign palyer country :-" + Player_Country);
				Forien_Player_Country_count++;

			}

		}

		Assert.assertEquals(Forien_Player_Country_count, 4);

		if (Forien_Player_Country_count == 4) {
			conditions++;
			System.out.println("Banglore Team Having at Most " + Forien_Player_Country_count + " forien Player");
		} else if (Forien_Player_Country_count > 4) {
			System.out.println("Banglore Team Having more than foreign palyer");

		}

		// Test 1 : validation for Team having at least 1 Wicket-keeper

		int Wicket_keeper_count = 0;
		for (int i = 0; i < array.size(); i++) {
			JSONObject data = (JSONObject) array.get(i);
			Object Role = data.get("role");
			String Role_palyer = (String) Role;
			if (Role_palyer.equalsIgnoreCase("Wicket-keeper")) {

				Wicket_keeper_count++;

			}

		}

		Assert.assertEquals(Wicket_keeper_count, 1);

		if (Wicket_keeper_count == 1) {

			System.out.println("Banglore Team Having at Most 1 Wicket-keeper");
			conditions++;
		}

		else if (Wicket_keeper_count < 1) {
			Assert.assertTrue(true);
		}
		System.out.println();

		if (conditions == 2) {
			System.out.println("both of test validating by banglore team and ready to play a match");
		} else {
			System.out.println("test is not validating by banglore team and not ready to play a match");
		}

	}
}
