package spring.data.project.entities;

import spring.data.project.security.model.Role;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="userData")
//@SequenceGenerator(name="USERDATASQ", allocationSize = 10, sequenceName = "USERDATASQ")
public class userData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long id;

    @Column(name = "firstname", nullable = false)
    public String firstname;

    @Column(name = "lastname", nullable = false)
    public String lastname;

    @Column(name = "email", nullable = false)
    public String email;

    /*@Column(name = "password", nullable = false)
    public String password;*/

    @Column(name = "address", nullable = false)
    public String address;

    @Column(name = "state", nullable = false)
    public String state;

    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
        @JoinTable(
                name = "userdata_role",
                joinColumns = {@JoinColumn(name = "userdata_id")},
                inverseJoinColumns = {@JoinColumn(name = "role_id")}
        )
    Set<Role> roles = new HashSet<>();

    public userData(){

    }

    // getters and seters for the fields
    public Long getId(){
        return id;
    }
    public String getFirstname(){
        return firstname;
    }
    public String getLastname(){
        return lastname;
    }
    public String getEmail(){
        return email;
    }
    public String getAddress(){
        return address;
    }
    public String getState(){
        return state;
    }

    public void setId(Long id){
        this.id = id;
    }
    public void setFirstname(String firstname){
        this.firstname=firstname;
    }
    public void setLastname(String lastname){
        this.lastname=lastname;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public void setAddress(String address){
        this.address=address;
    }
    public void setState(String state){
        this.state=state;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
    // toString()

    public String toString(){
        return "firstname " + firstname
                + "lastname " + lastname
                + "email " + email
                + "address " + address
                + "state" + state;
    }

}
