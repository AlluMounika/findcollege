package com.example.lenovo.findcollege;

public class collegepojo {
    String accrediatatedto,district,image,location,name,type,weblink;
    Double userrating;
    public collegepojo() {
    }

    public collegepojo(String accrediatatedto, String district, String image, String location, String name, String type, Double userrating, String weblink) {
        this.accrediatatedto = accrediatatedto;
        this.district = district;
        this.image = image;
        this.location = location;
        this.name = name;
        this.type = type;
        this.userrating = userrating;
        this.weblink = weblink;
    }

    public String getAccrediatatedto() {
        return accrediatatedto;
    }

    public String getDistrict() {
        return district;
    }

    public String getImage() {
        return image;
    }

    public String getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public Double getUserrating() {
        return userrating;
    }

    public String getWeblink() {
        return weblink;
    }

    public void setAccrediatatedto(String accrediatatedto) {
        this.accrediatatedto = accrediatatedto;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setUserrating(Double userrating) {
        this.userrating = userrating;
    }

    public void setWeblink(String weblink) {
        this.weblink = weblink;
    }
}
