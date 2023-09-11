package otus.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Data {
    @Override
    public String toString() {
        return "Data{" +
            "id=" + id +
            ", name='" + email + '\'' +
            ", cource='" + course + '\'' +
            ", email='" + email + '\'' +
            ", age='" + age + '\'' +
            '}';
    }

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("course")
    private String course;

    @JsonProperty("email")
    private String email;

    @JsonProperty("age")
    private String age;


    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    public String getУEmail() {
        return email;
    }

    public String getAge() {
        return age;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setAge(String age) {
        this.age = age;
    }
}