package BootCampReview.PojoClasses;
//6      //json --> java object   deserialization    example
public class SingleSpartan {
/*   change  json to java      look POJO class
{
    "id": 50,
    "name": "Jennica",
    "gender": "Female",
    "phone": 6986436734
}
 */
    private int id;
    private String name;
    private String gender;
    private Long phone;
//1-getter and setter  //toString //
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "SingleSpartan{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", phone=" + phone +
                '}';
    }
}
