package ssu.softwarednd.androidlab3.utility;

import org.json.JSONException;
import org.json.JSONObject;

public class RecipeParser {

    /**
     * Gets total number of matched recipes in a search result.
     * @param json string json representing the server's response
     * @return number of total matches
     */
    public static int getTotalMatches(String json) {
        int totalMatches = 0;

        try {
            // convert the raw string into a Java JSONObject
            JSONObject response = new JSONObject(json);

            // deserialize an integer
            totalMatches = response.getInt("totalMatchCount");

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return totalMatches;
    }
}

// http://api.yummly.com/v1/api/recipes?_app_key=ec3e34e0bb6801670dbd3dbd02ce7608&_app_id=4911b643&q=lemon

//language=JSON
/*

// beginning of JSON object (response from server)
{

  // totalMatchCount is an integer
  "totalMatchCount": 270009,

  // criteria is a (nested) JSON object
  "criteria": {
    "q": "lemon",  // q is a string
    "allowedIngredient": null,
    "excludedIngredient": null
  },

  "matches": [  // a JSON array
    // (list of recipes that matched)
  ],

  "attribution": {
    "html": "Recipe search powered by <a href='http://www.yummly.co/recipes'><img alt='Yummly' src='https://static.yummly.co/api-logo.png'/></a>",
    "url": "http://www.yummly.co/recipes/",
    "text": "Recipe search powered by Yummly",
    "logo": "https://static.yummly.co/api-logo.png"
  }

}  // end of response object
 */