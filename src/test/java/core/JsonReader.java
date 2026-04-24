package core;

import org.json.JSONObject;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class JsonReader {

    private static JSONObject jsonObject;

    static {
        try {
            // Load JSON file from resources folder
            InputStream inputStream = JsonReader.class
                    .getClassLoader()
                    .getResourceAsStream("testdata/testdata.json");

            // Convert InputStream to String
            String jsonText = new Scanner(inputStream, StandardCharsets.UTF_8)
                    .useDelimiter("\\A")
                    .next();

            // Parse JSON string into JSONObject
            jsonObject = new JSONObject(jsonText);

        } catch (Exception e) {
            throw new RuntimeException("Failed to load testdata.json file", e);
        }
    }

    /**
     * Get value by key from JSON
     * Example: getData("validUser.username")
     */
    public static String getData(String key) {

        String[] keys = key.split("\\.");
        JSONObject current = jsonObject;

        // Traverse JSON hierarchy
        for (int i = 0; i < keys.length - 1; i++) {
            current = current.getJSONObject(keys[i]);
        }

        return current.getString(keys[keys.length - 1]);
    }
}