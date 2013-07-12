package me.roessing.lrdemo.controller;

import me.roessing.lrdemo.model.UserData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Rolf Roessing
 * @version $Revision: $:
 * @since 09.07.13
 */
@Controller

@RequestMapping("userdata")
public class UserDataController {

    private Map<String, UserData> demoUserData = null;

    @RequestMapping(method = RequestMethod.GET)

    public void get(Model model) {
        model.addAttribute("userDataList", getDemoUserData().values());
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public String getByName(@PathVariable String name, Model model) {
        for (UserData userData : getDemoUserData().values()) {
            if (name.equalsIgnoreCase(userData.getName())) {
                model.addAttribute("userData", userData);
                break;
            }
        }
        return "userdata";
    }

    @RequestMapping(value = "/json/{name}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public UserData getByNameAsJason(@PathVariable String name) {
        for (UserData userData : getDemoUserData().values()) {
            if (name.equalsIgnoreCase(userData.getName())) {
                return userData;
            }
        }
        return null;
    }

    @RequestMapping(value = "/json",
                    method = RequestMethod.POST,
                    consumes="application/json",
                    produces="text/html")
    @ResponseBody
    public String save(@RequestBody UserData userData) {
        getDemoUserData().put(userData.getId(), userData);
        return "cool";
    }


    protected Map<String, UserData> getDemoUserData() {
        return demoUserData != null ? demoUserData : buildDemoUserData();
    }

    /**
     * Setup some demo data.
     *
     * @return
     */
    private Map<String, UserData> buildDemoUserData() {
        demoUserData = new HashMap<String, UserData>();
        for (int i = 0; i < 20; i++) {
            UserData ud = new UserData();
            ud.setAge("" + 20 + i);
            ud.setName("name_" + i);
            ud.setMiddleInitial("middleInitial_" + i);
            ud.setSurname("surname_" + i);
            demoUserData.put(ud.getId(), ud);
        }
        return demoUserData;
    }


}
