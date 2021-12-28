package com.example.bookit.manager;

import android.graphics.Bitmap;
import android.util.Base64;
import android.util.Log;

import com.example.bookit.domain.Book;
import com.example.bookit.domain.Category;
import com.example.bookit.domain.Comment;
import com.example.bookit.domain.Debate;
import com.example.bookit.domain.Market;
import com.example.bookit.domain.ReadingDiary;
import com.example.bookit.domain.StatusBook;
import com.example.bookit.domain.User;
import com.example.bookit.helper.AsyncJob;
import com.example.bookit.helper.Util;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ApiManager {
    public static final String HOST = "http://35.233.183.211:9000";
    private static User user;

    public static void login(String id, String password, LoginCallback callback) {
        request(String.format("%s/%s?id=%s&password=%s", HOST, "api/login", id, password), "", json -> {
            try {
                JSONArray jsonArray = new JSONArray(json);

                if(jsonArray.length() == 0) callback.success(null);

                JSONObject jsonObject = jsonArray.getJSONObject(0);

                int uId = jsonObject.getInt("id");
                String profileImage = jsonObject.getString("profileImage");
                String name = jsonObject.getString("name");
                String loginId = jsonObject.getString("loginId");
                String uPassword = jsonObject.getString("password");

                User user = new User(uId, profileImage, name, loginId, uPassword);

                setUser(user);
                callback.success(user);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        });
    }

    public static void signup(String name, String id, String password, SuccessCallback callback) {
        request(String.format("%s/%s?name=%s&id=%s&password=%s", HOST, "api/signup", name, id, password), "", json -> {
            try {
                callback.success(new JSONObject(json).getBoolean("success"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        });
    }

    public static void selectNeeds(String loginId, Category category, SuccessCallback callback) {
        request(String.format("%s/%s?loginId=%s&categoryId=%d", HOST, "api/selectNeeds", loginId, category.getId()), "", json -> {
            try {
                callback.success(new JSONObject(json).getBoolean("success"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        });
    }

    public static void bestSeller(int count, BooksCallback callback) {
        request(String.format("%s/%s?count=%d", HOST, "api/bestSeller", count), "", json -> {
            try {
                List<Book> booksLit = new ArrayList<>();
                JSONArray jsonArray = new JSONArray(json);

                for(int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    booksLit.add(new Book(jsonObject.getString("coverLargeUrl"), jsonObject.getString("title"), jsonObject.getString("author"), jsonObject.getString("publisher"), jsonObject.getInt("categoryId"), jsonObject.getString("description")));
                }

                callback.success(booksLit);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        });
    }

    public static void recommendedBooks(int count, BooksCallback callback) {
        request(String.format("%s/%s?userId=%d&count=%d", HOST, "api/recommendedBooks", user.getId(), count), "", json -> {
            try {
                List<Book> booksLit = new ArrayList<>();
                JSONArray jsonArray = new JSONArray(json);

                for(int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    booksLit.add(new Book(jsonObject.getString("coverLargeUrl"), jsonObject.getString("title"), jsonObject.getString("author"), jsonObject.getString("publisher"), jsonObject.getInt("categoryId"), jsonObject.getString("description")));
                }

                callback.success(booksLit);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        });
    }

    public static void getDebates(DebateCallback callback) {
        request(String.format("%s/%s?userId=%d", HOST, "api/debate", user.getId()), "", json -> {
            try {
                List<Debate> debateList = new ArrayList<>();
                JSONArray jsonArray = new JSONArray(json);

                for(int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);

                    int id = jsonObject.getInt("id");
                    int uId = jsonObject.getInt("uId");
                    String uProfileImage = jsonObject.getString("uProfileImage");
                    String uName = jsonObject.getString("uName");
                    String title = jsonObject.getString("title");
                    Category category = Category.getCategoryById(jsonObject.getInt("categoryId"));
                    String contents = jsonObject.getString("contents");
                    int vIsAgree = -1;
                    int cId = 0;
                    int cuId = 0;
                    String cuProfileImage = "";
                    String cuName = "";
                    String cContents = "";
                    Calendar cDate = null;
                    Calendar date = Util.getCalenderByMillis(jsonObject.getLong("date"));

                    try {
                        cId = jsonObject.getInt("cId");
                        cuId = jsonObject.getInt("cuId");
                        cuProfileImage = jsonObject.getString("cuProfileImage");
                        cuName = jsonObject.getString("cuName");
                        cContents = jsonObject.getString("cContents");
                        cDate = Util.getCalenderByMillis(jsonObject.getLong("cDate"));
                        vIsAgree = jsonObject.getInt("vIsAgree");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    Comment comment = new Comment(cId, new User(cuId, cuProfileImage, cuName), cContents, cDate);
                    User user = new User(uId, uProfileImage, uName);
                    debateList.add(new Debate(id, user, title, category, contents, vIsAgree == 1, vIsAgree == 0, date, comment));
                }

                callback.success(debateList);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        });
    }

    public static void getMarkets(MarketCallback callback) {
        request(String.format("%s/%s", HOST, "api/market"), "", json -> {
            try {
                List<Market> marketList = new ArrayList<>();
                JSONArray jsonArray = new JSONArray(json);

                for(int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    int id = jsonObject.getInt("id");
                    int uId = jsonObject.getInt("uId");
                    String uProfileImage = jsonObject.getString("uProfileImage");
                    String uName = jsonObject.getString("uName");
                    String imageUrl = jsonObject.getString("imageUrl");
                    String title = jsonObject.getString("title");
                    Category category = Category.getCategoryById(jsonObject.getInt("categoryId"));
                    StatusBook status = Market.STATUS_LIST[jsonObject.getInt("status")];
                    int price = jsonObject.getInt("price");
                    String contents = jsonObject.getString("contents");
                    Calendar date = Util.getCalenderByMillis(jsonObject.getLong("date"));

                    marketList.add(new Market(id, new User(uId, uProfileImage, uName), imageUrl, title, category, status, price, contents, date));
                }

                callback.success(marketList);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        });
    }

    public static void getComments(int debateId, CommentsCallback callback) {
        request(String.format("%s/%s?id=%d", HOST, "api/comments", debateId), "", json -> {
            try {
                List<Comment> commentsList = new ArrayList<>();
                JSONArray jsonArray = new JSONArray(json);

                for(int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);

                    int id = jsonObject.getInt("id");
                    int uId = jsonObject.getInt("uId");
                    String uProfileImage = jsonObject.getString("uProfileImage");
                    String uName = jsonObject.getString("uName");
                    String contents = jsonObject.getString("contents");
                    Calendar date = Util.getCalenderByMillis(jsonObject.getLong("date"));

                    commentsList.add(new Comment(id, new User(uId, uProfileImage, uName), contents, date));
                }

                callback.success(commentsList);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        });
    }

    public static void writeDebate(String title, int category, String contents, SuccessCallback callback) {
        title = Util.encode(title);
        contents = Util.encode(contents);

        request(String.format("%s/%s", HOST, "api/write/debate"), String.format("userId=%d&title=%s&category=%d&contents=%s", user.getId(), title, category, contents), json -> {
            try {
                callback.success(new JSONObject(json).getBoolean("success"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        });
    }

    public static void writeMarket(String imageUrl, String title, Category category, StatusBook status, int price, String contents, SuccessCallback callback) {
        title = Util.encode(title);
        contents = Util.encode(contents);

        request(String.format("%s/%s", HOST, "api/write/market"), String.format("userId=%d&imageUrl=%s&title=%s&category=%d&status=%d&price=%d&contents=%s", user.getId(), imageUrl, title, category.getId(), status.getStatus(), price, contents), json -> {
            Log.d("haechilim", json);
            try {
                callback.success(new JSONObject(json).getBoolean("success"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        });
    }

    public static void writeComment(int debateId, String contents, SuccessCallback callback) {
        contents = Util.encode(contents);

        request(String.format("%s/%s", HOST, "api/write/comment"), String.format("userId=%d&debateId=%d&contents=%s", user.getId(), debateId, contents), json -> {
            try {
                callback.success(new JSONObject(json).getBoolean("success"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        });
    }

    public static void editProfile(String imageUrl, String name, SuccessCallback callback) {
        request(String.format("%s/%s?userId=%d&imageUrl=%s&name=%s", HOST, "api/edit/profile", user.getId(), imageUrl, name), "", json -> {
            try {
                callback.success(new JSONObject(json).getBoolean("success"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        });
    }

    public static void vote(int debateId, boolean isAgree, SuccessCallback callback) {
        request(String.format("%s/%s?userId=%d&debateId=%d&isAgree=%d", HOST, "api/vote", user.getId(), debateId, isAgree ? 1 : 0), "", json -> {
            try {
                callback.success(new JSONObject(json).getBoolean("success"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        });
    }

    public static void getReadingDiary(ReadingDiaryCallback callback) {
        request(String.format("%s/%s?userId=%d", HOST, "api/readingDiary", user.getId()), "", json -> {
            try {
                List<ReadingDiary> readingDiaryList = new ArrayList<>();
                JSONArray jsonArray = new JSONArray(json);

                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    int id = jsonObject.getInt("id");
                    String title = jsonObject.getString("title");
                    String date = jsonObject.getString("date");
                    String contents = jsonObject.getString("contents");

                    readingDiaryList.add(new ReadingDiary(id, title, date, contents));
                }

                callback.success(readingDiaryList);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        });
    }

    public static void writeReadingDiary(String title, String date, String contents, SuccessCallback callback) {
        title = Util.encode(title);
        date = Util.encode(date);
        contents = Util.encode(contents);

        request(String.format("%s/%s", HOST, "api/write/readingDiary"), String.format("userId=%d&title=%s&date=%s&contents=%s", user.getId(), title, date, contents), json -> {
            try {
                callback.success(new JSONObject(json).getBoolean("success"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        });
    }

    public static void editReadingDiary(int id, String title, String date, String contents, SuccessCallback callback) {
        title = Util.encode(title);
        date = Util.encode(date);
        contents = Util.encode(contents);

        request(String.format("%s/%s", HOST, "api/edit/readingDiary"), String.format("id=%d&title=%s&date=%s&contents=%s", id, title, date, contents), json -> {
            try {
                callback.success(new JSONObject(json).getBoolean("success"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        });
    }

    public static void deleteReadingDiary(int id, SuccessCallback callback) {
        request(String.format("%s/%s?id=%d", HOST, "api/delete/readingDiary", id), "", json -> {
            Log.d("haechilim", json);
            try {
                callback.success(new JSONObject(json).getBoolean("success"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        });
    }

    public static void uploadImage(Bitmap bitmap, PathCallback callback) {
        requestBinary(String.format("%s/%s", HOST, "upload/image"), bitmap, json -> {
            Log.d("haechilim", json);
            try {
                callback.success(new JSONObject(json).getString("path"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        });
    }

    private static void requestBinary(String url, Bitmap bitmap, JsonCallback callback) {
        Log.d("haechilim", url);

        new AsyncJob<String, Void, String>() {
            @Override
            protected String doInBackground(String... strings) {
                return requestBinary(strings[0], bitmap);
            }

            @Override
            protected void onPostExecute(String result) {
                callback.success(result);
            }
        }.execute(url);
    }

    private static String requestBinary(String uri, Bitmap bitmap) {
        String result = "";

        try {
            URL url = new URL(uri);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();

            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "image/jpeg");

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream .toByteArray();
            String encoded = Base64.encodeToString(byteArray, Base64.DEFAULT);

            OutputStream outputStream = connection.getOutputStream();
            outputStream.write(encoded.getBytes("utf-8"));
            outputStream.close();

            connection.connect();

            InputStream inputStream = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));

            while(true) {
                String line = reader.readLine();
                if(line == null) break;
                result += line;
            }

            reader.close();
            connection.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }


    private static void request(String url, String body, JsonCallback callback) {
        Log.d("haechilim", url);

        new AsyncJob<String, Void, String>() {
            @Override
            protected String doInBackground(String... strings) {
                return request(strings[0], body);
            }

            @Override
            protected void onPostExecute(String result) {
                callback.success(result);
            }
        }.execute(url);
    }

    private static String request(String uri, String body) {
        String result = "";

        try {
            URL url = new URL(uri);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();

            if(!body.isEmpty()) {
                connection.setRequestMethod("POST");
                connection.setRequestProperty("Content-Type", "application/json; utf-8");

                OutputStream outputStream = connection.getOutputStream();
                Log.d("haechilim", body);
                outputStream.write(body.getBytes("utf-8"));
                outputStream.close();
            }

            connection.connect();

            InputStream inputStream = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));

            while(true) {
                String line = reader.readLine();
                if(line == null) break;
                result += line;
            }

            reader.close();
            connection.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static void setUser(User user) {
        ApiManager.user = user;
    }

    public static User getUser() {
        return user;
    }

    private interface JsonCallback {
        void success(String json);
    }

    public interface LoginCallback {
        void success(User user);
    }

    public interface BooksCallback {
        void success(List<Book> bookList);
    }

    public interface DebateCallback {
        void success(List<Debate> debateList);
    }

    public interface MarketCallback {
        void success(List<Market> marketList);
    }

    public interface CommentsCallback {
        void success(List<Comment> commentList);
    }

    public interface ReadingDiaryCallback {
        void success(List<ReadingDiary> readingDiaryList);
    }

    public interface SuccessCallback {
        void success(boolean success);
    }

    public interface PathCallback {
        void success(String path);
    }
}