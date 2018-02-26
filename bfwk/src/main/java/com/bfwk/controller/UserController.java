package com.bfwk.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bfwk.common.BindingResultUtils;
import com.bfwk.common.WkResponse;
import com.bfwk.common.validate.Update;
import com.bfwk.model.User;
import com.bfwk.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    
    @InitBinder  
    public void initBinder(WebDataBinder binder) {  
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
        dateFormat.setLenient(false);  
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));   
    }
    /***
     * 修改用户信息
     * @param user
     * @param bindResult
     * @return
     */
    @RequestMapping("/modifyUser")
    public String modifyUser(Model model,@Validated({ Update.class }) User user, BindingResult result) {
       WkResponse<User> wr=new WkResponse<User>();
       try{
    	   BindingResultUtils.cacheError(result);
    	   userService.update(user);
       }catch(Exception e){
    	   wr.setCode(e.hashCode());
    	   wr.setMsg(e.getMessage());
       }
       model.addAttribute("result",wr);
       return null;
    }
    
    /****
     * 查询用户列表
     * @param model
     * @param number
     * @return
     */
    @RequestMapping("/toRight")
    public String toRight(Model model, @RequestParam(defaultValue = "1") int number) {
        List<User> userList = userService.findAllUser(number);
        model.addAttribute("userList", userList);
        return "right";
    }
  
    
    /****
     * 充值
     * @param cardID
     * @param money
     * @param model
     * @return
     */
    @RequestMapping("/recharge")
    @ResponseBody
    public  WkResponse<User>  rechargeMoney(@Validated({ Update.class }) String cardID, Double money, Model model) {
        WkResponse<User> wr=new  WkResponse<User>();  
    	if (StringUtils.isEmpty(cardID) || money <= 0) {
            wr.setCode(400);
    		wr.setMsg("参数异常");
    		return wr;
        }
        try{
        	userService.updateBalance(cardID, money);
            new WebSocketController().sendMessage(cardID + "充值成功，成功充值" + money + "元");
        }catch(Exception e){
        	e.printStackTrace();
        	wr.setCode(e.hashCode());
        	wr.setMsg(e.getMessage());
        	
        }
        return wr;
    }
    @RequestMapping("/register")
    @ResponseBody
    public WkResponse<User> register(User user){
    	WkResponse<User> wr=new WkResponse<User>();
    	try{
    		userService.register(user);
    	}catch(Exception e){
    		e.printStackTrace();
    		wr.setCode(e.hashCode());
    		wr.setMsg(e.getMessage());
    	}
    	return wr;
    }
}
