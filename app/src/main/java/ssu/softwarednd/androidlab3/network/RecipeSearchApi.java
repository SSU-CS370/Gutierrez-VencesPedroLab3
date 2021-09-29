package ssu.softwarednd.androidlab3.network;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class RecipeSearchApi {

    private static final String baseApiUrl = "https://api.spoonacular.com/recipes/findByIngredients";
    private static final String apiKey = "d4897ac2dd8e494a8815edc1c5f29538";

    /**
     * Searches the YummlyApi recipe database.
     * @param input the ingredient to search in recipes
     * @return string: json response containing matches
     */
    public static String searchRecipes(String input) {

        // piece together a valid url, starting with the base
        HttpUrl.Builder urlBuilder = HttpUrl.parse(baseApiUrl).newBuilder();

        // and adding on a few more parts
        urlBuilder.addQueryParameter("apiKey", apiKey);
        urlBuilder.addQueryParameter("ingredients", input);

        // until it's ready to assemble
        String url = urlBuilder.build().toString();

        return getResponse(url);
    }

    private static String getResponse(String url) {
        // form the Request with the url
        Request request = new Request.Builder().url(url).build();

        OkHttpClient client;
        client = new OkHttpClient();
        try {
            // ask the server for a response
            Response response = client.newCall(request).execute();
            // `response` also contains metadata: success/fail, travel time, etc.
            // only need the body of the result (as a string)
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
