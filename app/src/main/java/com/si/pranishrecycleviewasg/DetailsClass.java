package com.si.pranishrecycleviewasg;

class DetailsClass {
    private String name;
    private String age;
    private String gender;
    private int imagenumber;

    public DetailsClass(String name, String age, String gender, int imagenumber) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.imagenumber = imagenumber;
    }

    public int getImagenumber() {
        return imagenumber;
    }

    public void setImagenumber(int imagenumber) {
        this.imagenumber = imagenumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


}