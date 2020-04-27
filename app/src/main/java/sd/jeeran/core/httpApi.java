package sd.jeeran.core;

public class httpApi {
    public class Post {
        public int type;
        public String title;
        public String content;
        public String url;

        public Post(int type) {
            this.type = type;
            this.title = "";
            this.content = "";
            this.url = "";
        }

        public Post(int type, String title, String content, String url) {
            this.type = type;
            this.title = title;
            this.content = content;
            this.url = url;
        }
    }

    public class User {
        String userName;
        String userId;
    }
}
