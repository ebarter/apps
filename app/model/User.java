package model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import mapper.annotation.Column;
import mapper.annotation.JsonField;

/**
 * @author AKBAR <akbar.attijani@gmail.com>
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "nip",
        "name",
        "password",
        "supervisor",
        "step"
})
public class User {
    @JsonProperty("id")
    @Column(name = "id", primaryKey = true)
    @JsonField(key = "id")
    private int id;

    @JsonProperty("nip")
    @Column(name = "nip")
    @JsonField(key = "nip")
    private String nip;

    @JsonProperty("name")
    @Column(name = "name")
    @JsonField(key = "name")
    private String name;

    @JsonProperty("password")
    @Column(name = "password")
    @JsonField(key = "password")
    private String password;

    @JsonProperty("supervisor")
    @Column(name = "supervisor")
    @JsonField(key = "supervisor")
    private int supervisor;

    @JsonProperty("step")
    @Column(name = "step")
    @JsonField(key = "step")
    private int step;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNip() {
        return nip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(int supervisor) {
        this.supervisor = supervisor;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }
}
