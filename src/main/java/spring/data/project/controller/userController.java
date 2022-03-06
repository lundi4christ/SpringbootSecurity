package spring.data.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.data.project.entities.userData;
import spring.data.project.services.userService;
import spring.data.project.services.userServiceImpl;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController()
@RequestMapping("/users")
//@CrossOrigin("*")
//@CrossOrigin(origins = "http://localhost:4200")
public class userController {

   // @Qualifier("userService")
    @Autowired
    private userService userservice;

    @PostMapping("/saveUsers")
    public userData saveUsers(@RequestBody userData userdata )
    {
        return userservice.save(userdata);
    }

    @PutMapping("/updateUser")
    public userData updateUser(@RequestBody userData userdata){
       return userservice.save(userdata);
    }

    @GetMapping("/allUsers")
    public List<userData> allUsers(){

        return (List<userData>) userservice.findAll();
    }


    @GetMapping("/getUser/{userid}")
    public userData getUser(@PathVariable("userid") long userid) {
       // userdata.setId(userid);
        return userservice.findById(userid);

    }


    @DeleteMapping("/deleteUser")
    public void  deleteUser(@RequestBody userData deletedata){
        userservice.delete(deletedata);
    }

    @DeleteMapping("/deletebyid/{userid}")
    public ResponseEntity<?> deleteById(@PathVariable("userid") long userid){

        userservice.deleteById(userid);

        return ResponseEntity.ok().body("its been deleted");
    }

/*    @GetMapping("/resources")
    public Map<String, userData> getUsers(Principal principal){

        userData user = userservice.findByFirstname(principal.getName());

        Map<String, userData> model = new HashMap<>();
        model.put("firstname", user.getFirstname());

        return user;
    }*/
}
