package fhq.controller;

import fhq.pojo.User;
import fhq.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    //到管理员页面
    @GetMapping("/toIndex")
    public String toIndex(){
        return "controlHtml/index";
    }

    //查询所有用户
    @GetMapping("/findUsers")
    @ResponseBody
    public List<User> findAllUsers(){
        //调用业务层的查询方法
        List<User> users = adminService.findAllUsersInfo();
        return users;
    }
    //模糊查询
    @PostMapping("/findUsersLike")
    @ResponseBody
    public List<User> findUsersLike(Integer userId,String userName,Integer userVip,Integer loPh,Integer hiPh){

        List<User> users = adminService.findUsersLikeInfo(userId, userName, userVip, loPh,hiPh);
        return users;
    }

    //用户修改
    @PostMapping("/updateUser")
    @ResponseBody
    public Map<String,Object> updateUser(Integer userId, Integer userVip, Integer pushMoney){
        Map<String, Object> map = adminService.updateUserInfo(userId, userVip, pushMoney);

        return map;
    }
    //用户删除
    @PostMapping("/deleteUser")
    @ResponseBody
    public  Map<String,Object> deleteUser(Integer id){
        Map<String, Object> map = adminService.deleteUserInfo(id);
        return map;
    }
}