package com.bfwk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bfwk.common.validate.Update;
import com.bfwk.pojo.User;
import com.bfwk.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/modifyUser")
    public String modifyUser(@Validated({ Update.class }) User user, BindingResult bindResult) {
        // userService.modifyUser(user);
        /**
         * @Validated获取的errors if (bindResult.hasErrors()) { List<FieldError> fiedErrorList =
         *                     bindResult.getFieldErrors(); for (FieldError error : fiedErrorList) {
         *                     System.out.println(error.getDefaultMessage()); } }
         */

        return null;
    }

    @RequestMapping("/toRight")
    public String toRight(Model model, @RequestParam(defaultValue = "1") int number) {
        List<User> userList = userService.findAllUser(number);
        model.addAttribute("userList", userList);
        return "right";
    }

    @RequestMapping("/testJsonp")
    @ResponseBody
    public Object test(String callback) {
        List<User> userList = userService.findAllUser(1);
        MappingJacksonValue jsonp = new MappingJacksonValue(userList);
        jsonp.setJsonpFunction("testJsonp");
        return jsonp;
    }

    @RequestMapping("/recharge")
    @ResponseBody
    public boolean rechargeMoney(@Validated({ Update.class }) String cardID, Double money, Model model) {
        if (StringUtils.isEmpty(cardID) || money <= 0) {
            model.addAttribute("erroMsg", "参数异常");
            return false;
        }
        if (userService.updateBalance(cardID, money)) {
            new WebSocketController().sendMessage(cardID + "充值成功，成功充值" + money + "元");
            return true;
        }
        model.addAttribute("erroMsg", "查无用户");
        return false;
    }
}
