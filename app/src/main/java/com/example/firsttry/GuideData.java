package com.example.firsttry;

public class GuideData {
    private int guideTitle;
    private Integer imgbtn;
    private Integer guideImage;

    public GuideData(int guideTitle, Integer guideImage , Integer imgbtn) {
        this.guideTitle = guideTitle;
        this.imgbtn = imgbtn;
        this.guideImage = guideImage;
    }

    public int getGuideTitle() {
        return guideTitle;
    }

    public void setGuideTitle(int guideTitle) {
        this.guideTitle = guideTitle;
    }

    public int getGuidebtn() {
        return imgbtn;
    }

    public void setGuidebtn(Integer imgbtn) {
        this.imgbtn = imgbtn;
    }



    public Integer getGuideImage() {
        return guideImage;
    }

    public void setGuideImage(Integer guideImage) {
        this.guideImage = guideImage;
    }
}