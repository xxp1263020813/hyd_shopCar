package cn.edu.zut.DO;

public class AuctionDO {
    private int id;
    private String title;
    private float price;
    private String description;
    public AuctionDO(int id,String title,float price,String description){
        this.id = id;
        this.title = title;
        this.price = price;
        this.description = description;
    }
    public AuctionDO(){

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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
