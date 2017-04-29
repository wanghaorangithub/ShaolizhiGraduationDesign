package shaolizhi.shaolizhigraduationdesign.bean;

import java.util.Map;

/**
 * 由邵励治于2017/4/29创造.
 */

public class BBean {
    private Integer userAvatar;
    private String userName;
    private String date;
    private String price;
    private String description;
    private Map<String, Integer> sliderLayoutImage;

    public void setUserAvatar(Integer userAvatar) {
        this.userAvatar = userAvatar;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSliderLayoutImage(Map<String, Integer> sliderLayoutImage) {
        this.sliderLayoutImage = sliderLayoutImage;
    }

    public Integer getUserAvatar() {
        return userAvatar;
    }

    public String getUserName() {
        return userName;
    }

    public String getDate() {
        return date;
    }

    public String getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Integer> getSliderLayoutImage() {
        return sliderLayoutImage;
    }
}
