package YangHeeChan.demo.entity;

public class Book {
    private int id;
    private String title;
    private String author;
    private boolean Out;

    public boolean isOut() {
        return Out;
    }

    public void setOut(boolean out) {
        Out = out;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


}
