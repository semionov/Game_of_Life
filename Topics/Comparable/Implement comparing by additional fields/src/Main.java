class Article implements Comparable<Article> {
    private String title;
    private int size;

    public Article(String title, int size) {
        this.title = title;
        this.size = size;
    }

    public String getTitle() {
        return this.title;
    }

    public int getSize() {
        return this.size;
    }

    @Override
    public int compareTo(Article otherArticle) {
        if (this.size > otherArticle.getSize()) {
            return 1;
        } else if (this.size < otherArticle.getSize()) {
            return  -1;
        } else {
            return this.title.compareTo(otherArticle.getTitle());
        }
    }
}