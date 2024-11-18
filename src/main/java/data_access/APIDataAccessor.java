package data_access;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import use_case.leaderboard.LeaderboardEntry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class APIDataAccessor implements IDataAccessor {
    private final String baseUrl;

    public APIDataAccessor(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Override
    public boolean signUp(String username, String password) {
        JsonObject object = new JsonObject();
        object.addProperty("username", username);
        object.addProperty("password", password);
        ParsedResult result = parseRequest(postRequest("/api/v1/signup", object));

        if (!result.success()) {
            System.out.println(result.errorMessage);
        }

        return result.success();
    }

    @Override
    public String logIn(String username, String password) {
        JsonObject object = new JsonObject();
        object.addProperty("username", username);
        object.addProperty("password", password);
        ParsedResult result = parseRequest(postRequest("/api/v1/login", object));

        if (!result.success()) {
            System.out.println(result.errorMessage);
            return null;
        } else {
            return result.obj().get("session_id").getAsString();
        }
    }

    @Override
    public List<LeaderboardEntry> getTopTenLeaderboard() {
        List<LeaderboardEntry> topTen = new ArrayList<>();
        ParsedResult result = parseRequest(getRequest("/api/v1/leaderboard"));

        if (!result.success()) {
            System.out.println(result.errorMessage);
        }

        for (JsonElement element : result.obj().getAsJsonArray("leaderboard")) {
            JsonObject obj = element.getAsJsonObject();
            topTen.add(new LeaderboardEntry(obj.get("username").getAsString(), obj.get("score").getAsInt()));
        }

        return topTen;
    }

    @Override
    public void updateScore(String sessionId, int score) {
        JsonObject object = new JsonObject();
        object.addProperty("session_id", sessionId);
        object.addProperty("score", score);
        ParsedResult result = parseRequest(postRequest("/api/v1/update_score", object));

        if (!result.success()) {
            System.out.println(result.errorMessage);
        }
    }

    @Override
    public int getBestScore(String sessionId) {
        JsonObject object = new JsonObject();
        object.addProperty("session_id", sessionId);
        ParsedResult result = parseRequest(postRequest("/api/v1/best_score", object));

        if (!result.success()) {
            System.out.println(result.errorMessage);
            return 0;
        } else {
            return result.obj().get("best_score").getAsInt();
        }

    }

    private record Result(boolean success, String message) {
    }

    private record ParsedResult(boolean success, String errorMessage, JsonObject obj) {
    }

    private Result getRequest(String url) {
        try {
            HttpURLConnection con = (HttpURLConnection) new URL(baseUrl + "/" + url).openConnection();
            con.setRequestMethod("GET");

            if (con.getResponseCode() == 200) {
                return new Result(true, new BufferedReader(new InputStreamReader(con.getInputStream())).lines().collect(Collectors.joining("\n")));
            } else {
                return new Result(false, new BufferedReader(new InputStreamReader(con.getErrorStream())).lines().collect(Collectors.joining("\n")));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Result(false, "");
    }

    private Result postRequest(String url, JsonObject body) {
        return postRequest(url, body.toString());
    }

    private Result postRequest(String url, String body) {
        try {
            HttpURLConnection con = (HttpURLConnection) new URL(baseUrl + "/" + url).openConnection();

            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json; utf-8");
            con.setRequestProperty("Accept", "application/json");

            con.setDoOutput(true);

            con.getOutputStream().write(body.getBytes(StandardCharsets.UTF_8));

            if (con.getResponseCode() == 200) {
                return new Result(true, new BufferedReader(new InputStreamReader(con.getInputStream())).lines().collect(Collectors.joining("\n")));
            } else {
                return new Result(false, new BufferedReader(new InputStreamReader(con.getErrorStream())).lines().collect(Collectors.joining("\n")));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Result(false, "");
    }

    private ParsedResult parseRequest(Result result) {
        JsonElement element = JsonParser.parseString(result.message());
        if (!element.isJsonObject()) {
            return new ParsedResult(false, "Request did not return a JsonObject", null);
        }

        JsonObject obj = element.getAsJsonObject();
        if (obj.get("success").isJsonNull() || !obj.get("success").getAsBoolean()) {
            return new ParsedResult(false, obj.get("error").getAsString(), obj);
        }

        return new ParsedResult(true, null, obj);
    }
}
