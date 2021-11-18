package com.example.bookit.manager;

import android.util.Log;
import android.widget.ListView;

import com.example.bookit.domain.Book;
import com.example.bookit.domain.Category;
import com.example.bookit.domain.Comment;
import com.example.bookit.domain.Debate;
import com.example.bookit.domain.User;
import com.example.bookit.helper.AsyncJob;
import com.example.bookit.helper.Util;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
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
    public static final String HOST = "http://10.0.2.2:9000";
    private static User user = new User(3, "https://bimage.interpark.com/partner/goods_image/7/0/6/6/266467066s.jpg", "준형", "haechilim", "password");
    
    public static void getUser(int userId, UserCallback callback) {
        request(String.format("%s/%s?userId=%d", HOST, "api/user", userId), "", (json) -> {
            try {
                JSONObject jsonObject = new JSONArray(json).getJSONObject(0);
                int id = jsonObject.getInt("id");
                String profileImage = jsonObject.getString("profileImage");
                String name = jsonObject.getString("name");

                callback.success(new User(id, profileImage, name));
            } catch (JSONException e) {
                Log.d("haechilim", e.getMessage());
            }
        });
    }

    public static void bestSeller(int count, BestSellerCallback callback) {
        request(String.format("%s/%s?count=%d", HOST, "api/bestSeller", count), "", (json) -> {
            try {
                List<Book> booksLit = new ArrayList<>();
                JSONArray jsonArray = new JSONArray(json);

                for(int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    booksLit.add(new Book(jsonObject.getString("coverLargeUrl"), jsonObject.getString("title"), jsonObject.getString("author"), jsonObject.getString("publisher"), jsonObject.getInt("categoryId"), jsonObject.getString("description")));
                }

                callback.success(booksLit);
            } catch (JSONException e) {
                Log.d("haechilim", e.getMessage());
            }
        });
    }

    public static void getDebates(DebateCallback callback) {
        request(String.format("%s/%s?userId=%d", HOST, "api/debate", user.getId()), "", (json) -> {
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
                    Calendar date = Util.getCalenderByMillis(jsonObject.getInt("date"));

                    try {
                        vIsAgree = jsonObject.getInt("vIsAgree");
                        cId = jsonObject.getInt("cId");
                        cuId = jsonObject.getInt("cuId");
                        cuProfileImage = jsonObject.getString("cuProfileImage");
                        cuName = jsonObject.getString("cuName");
                        cContents = jsonObject.getString("cContents");
                        cDate = Util.getCalenderByMillis(jsonObject.getInt("cDate"));
                    } catch (JSONException e) {
                        Log.d("haechilim", e.getMessage());
                    }

                    List<Comment> commentList = new ArrayList<>();
                    commentList.add(new Comment(cId, new User(cuId, cuProfileImage, cuName), cContents, cDate));
                    debateList.add(new Debate(id, new User(uId, uProfileImage, uName), title, category, contents, vIsAgree == 1, vIsAgree == 0, date, commentList));
                }

                callback.success(debateList);
            } catch (JSONException e) {
                Log.d("haechilim", e.getMessage());
            }
        });
    }

    public static void writeDebate(String title, int category, String contents, SuccessCallback callback) {
        request(String.format("%s/%s", HOST, "api/write/debate"), String.format("userId=%d&title=%s&category=%d&contents=%s", user.getId(), title, category, contents), (json) -> {
            try {
                callback.success(new JSONObject(json).getBoolean("success"));
            } catch (JSONException e) {
                Log.d("haechilim", e.getMessage());
            }
        });
    }

    public static void vote(int debateId, boolean isAgree, SuccessCallback callback) {
        request(String.format("%s/%s?userId=%d&debateId=%d&isAgree=%d", HOST, "api/vote", user.getId(), debateId, isAgree ? 1 : 0), "", (json) -> {
            try {
                callback.success(new JSONObject(json).getBoolean("success"));
            } catch (JSONException e) {
                Log.d("haechilim", e.getMessage());
            }
        });
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

                Log.d("haechilim", connection.getRequestProperty("Content-Type"));

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
            Log.d("haechilim", e.getMessage());
        } catch (IOException e) {
            Log.d("haechilim", e.getMessage());
        }

        return result;
    }

    private interface JsonCallback {
        void success(String json);
    }

    public interface UserCallback {
        void success(User user);
    }

    public interface BestSellerCallback {
        void success(List<Book> bookList);
    }

    public interface DebateCallback {
        void success(List<Debate> debateList);
    }

    public interface SuccessCallback {
        void success(boolean success);
    }

    /*public static void signup(String id, String password, SignupCallback callback) {
        request(String.format("%s/%s?loginId=%s&password=%s", HOST, "signup", id, password), new JsonCallback() {
            @Override
            public void success(String json) {
                try {
                    callback.success(objectMapper.readValue(json, new TypeReference<Response>() {}).isSuccess());
                } catch (JsonProcessingException e) {
                    Logger.debug(e.getMessage());
                }
            }
        });
    }

    public static void login(String loginId, String password, LoginCallback callback) {
        request(String.format("%s/%s?loginId=%s&password=%s", HOST, "login", loginId, password), new JsonCallback() {
            @Override
            public void success(String json) {
                try {
                    Response response = objectMapper.readValue(json, new TypeReference<Response>() {});
                    memberId = response.getMemberId();
                    callback.success(response.isSuccess());
                    Logger.debug("memberId: " + memberId);
                } catch (JsonProcessingException e) {
                    Logger.debug(e.getMessage());
                }
            }
        });
    }

    public static void getSchool(SchoolCallback callback) {
        request(String.format("%s/%s?memberId=%d", HOST, "school", memberId), new JsonCallback() {
            @Override
            public void success(String json) {
                try {
                    callback.success(objectMapper.readValue(json, new TypeReference<School>() {}));
                } catch (JsonProcessingException e) {
                    Logger.debug(e.getMessage());
                }
            }
        });
    }

    public static void updateSchool(School school) {
        request(String.format("%s/%s?memberId=%d&name=%s&year=%s&number=%s", HOST, "school/update", memberId,
                school.getName(), school.getYear(), school.getNumber()), new JsonCallback() {
            @Override
            public void success(String json) {}
        });
    }

    public static void getStudents(StudentListCallback callback) {
        request(String.format("%s/%s?memberId=%d", HOST, "student", memberId), new JsonCallback() {
            @Override
            public void success(String json) {
                try {
                    callback.success(objectMapper.readValue(json, new TypeReference<List<Student>>() {}));
                } catch (JsonProcessingException e) {
                    Logger.debug(e.getMessage());
                }
            }
        });
    }

    public static void addStudent(Student student, StudentCallback callback) {
        request(String.format("%s/%s?memberId=%d&name=%s&male=%s&phone=%s&avatarId=%d&score=%d&happiness=%d&message=%s",
                HOST, "student/add", memberId, student.getName(), (student.isMale() ? "true" : "false"), student.getPhone(),
                student.getAvatarId(), student.getScore(), -1, student.getStatusMessage()), new JsonCallback() {
            @Override
            public void success(String json) {
                try {
                    callback.success(objectMapper.readValue(json, new TypeReference<Student>() {}));
                } catch (JsonProcessingException e) {
                    Logger.debug(e.getMessage());
                }
            }
        });
    }

    public static void modifyStudent(Student student, StudentCallback callback) {
        request(String.format("%s/%s?id=%d&name=%s&male=%s&phone=%s&avatarId=%d&score=%d&happiness=%d&statusMessage=%s",
                HOST, "student/modify", student.getId(), student.getName(), (student.isMale() ? "true" : "false"), student.getPhone(),
                student.getAvatarId(), student.getScore(), -1, student.getStatusMessage()), new JsonCallback() {
            @Override
            public void success(String json) {
                try {
                    if(callback != null) callback.success(objectMapper.readValue(json, new TypeReference<Student>() {}));
                } catch (JsonProcessingException e) {
                    Logger.debug(e.getMessage());
                }
            }
        });
    }

    public static void deleteStudent(Student student) {
        request(String.format("%s/%s?id=%d", HOST, "student/delete", student.getId()), new JsonCallback() {
            @Override
            public void success(String json) {}
        });
    }

    public static void addMate(Student student, Student mate, int roundId) {
        request(String.format("%s/%s?memberId=%d&studentId=%d&mateId=%d&roundId=%d", HOST, "mate/add",
                memberId, student.getId(), (mate == null ? -1 : mate.getId()), roundId), new JsonCallback() {
            @Override
            public void success(String json) {
                Logger.debug(json);
            }
        });
    }

    public static void addFavoritePartner(Student student, Student mate, int rank) {
        request(String.format("%s/%s?memberId=&studentId=&mateId=&rank=", HOST, "favorite/add",
                memberId, student.getId(), mate.getId(), rank), new JsonCallback() {
            @Override
            public void success(String json) {
                Logger.debug(json);
            }
        });
    }

    public static void getRounds(RoundListCallback callback) {
        request(String.format("%s/%s?memberId=%d", HOST, "round", memberId), new JsonCallback() {
            @Override
            public void success(String json) {
                Logger.debug("round: " + json);
                try {
                    callback.success(objectMapper.readValue(json, new TypeReference<List<History>>() {}));
                } catch (JsonProcessingException e) {
                    Logger.debug(e.getMessage());
                }
            }
        });
    }

    public static void addRound(int agree, int disagree, AddRoundCallback callback) {
        request(String.format("%s/%s?memberId=%d&agree=%d&disagree=%d", HOST, "round/add", memberId, agree, disagree), new JsonCallback() {
            @Override
            public void success(String json) {
                try {
                    callback.success(objectMapper.readValue(json, new TypeReference<History>() {}));
                } catch (JsonProcessingException e) {
                    Logger.debug(e.getMessage());
                }
            }
        });
    }

    public static void poll(boolean begin, PollCallback callback) {
        request(String.format("%s/poll/%s?memberId=%d", HOST, begin ? "begin" : "end", memberId), new JsonCallback() {
            @Override
            public void success(String json) {
                try {
                    callback.success(objectMapper.readValue(json, new TypeReference<Response>() {}).isSuccess());
                } catch (JsonProcessingException e) {
                    Logger.debug(e.getMessage());
                }
            }
        });
    }

    public static void pollStatus(PollListCallback callback) {
        request(String.format("%s/%s?memberId=%d", HOST, "poll/status", memberId), new JsonCallback() {
            @Override
            public void success(String json) {
                try {
                    callback.success(objectMapper.readValue(json, new TypeReference<List<Poll>>() {}));
                } catch (JsonProcessingException e) {
                    Logger.debug(e.getMessage());
                }
            }
        });
    }

    public static int getMemberId() {
        return memberId;
    }

    public static void setMemberId(int memberId) {
        com.example.findamate.manager.ApiManager.memberId = memberId;
    }

    public interface SignupCallback {
        void success(boolean success);
    }

    public interface LoginCallback {
        void success(boolean success);
    }

    public interface SchoolCallback {
        void success(School school);
    }

    public interface StudentListCallback {
        void success(List<Student> students);
    }

    public interface StudentCallback {
        void success(Student student);
    }

    public interface RoundListCallback {
        void success(List<History> histories);
    }

    public interface AddRoundCallback {
        void success(History history);
    }

    public interface PollCallback {
        void success(boolean success);
    }

    public interface PollListCallback {
        void success(List<Poll> polls);
    }*/

    public static User getUser() {
        return user;
    }
}