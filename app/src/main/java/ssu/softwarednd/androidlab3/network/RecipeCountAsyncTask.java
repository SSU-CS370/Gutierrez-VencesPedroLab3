package ssu.softwarednd.androidlab3.network;

import android.os.AsyncTask;
import android.util.Log;

import ssu.softwarednd.androidlab3.utility.RecipeParser;


public class RecipeCountAsyncTask extends AsyncTask<String, Void, Integer> {

// AsyncTask is a templated class: AsyncTask<PARAMS, PROGRESS, RESULT>

// PARAMS is the datatype that we pass to execute()
//      a String representing an ingredient to search for recipes that use it
//      (from user input in MainActivity)
// PROGRESS is the datatype we use to report updates
//      not used in this lab -> Void (null)
// RESULT is the datatype that we send back on completion of this task
//      an Integer (int) that represents the number of recipes that use the ingredient

    @Override
    protected Integer doInBackground(String... params) {
        // runs on a background thread, not blocking main

        String searchTerm = params[0];  // what we're searching for
        Log.d("AsyncTask", "doInBackground: " + searchTerm);

        // get the json response from Spoonacular's Recipe API
        String responseJson = RecipeSearchApi.searchRecipes(searchTerm);

        // success? :)
        if (responseJson != null) {
            int numMatches = RecipeParser.getTotalMatches(responseJson);
            return numMatches;
        }
        // no success :(
        return 0;
    }

    @Override
    protected void onPostExecute(Integer result) {
        // happens after doInBackground, and runs on main thread
        super.onPostExecute(result);
        Log.d("AsyncTask", "onPostExecute: " + result);
    }

    public interface RecipeListener {
        void onRecipeCallback(Integer result);
    }

}
