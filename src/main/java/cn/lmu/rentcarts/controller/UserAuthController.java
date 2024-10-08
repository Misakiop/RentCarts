package cn.lmu.rentcarts.controller;

import cn.lmu.rentcarts.pojo.ResponseData;
import cn.lmu.rentcarts.pojo.Role;
import cn.lmu.rentcarts.pojo.Token;
import cn.lmu.rentcarts.pojo.UserInfo;
import cn.lmu.rentcarts.service.UserAuthService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("api/auth")
public class UserAuthController {
    @Value("${jwt.header}")
    private String tokenHeader;
    @Autowired
    private UserAuthService authService;


    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/login", method = { RequestMethod.POST,RequestMethod.GET})
    public ResponseData loginForToken(@RequestBody Map<String,Object> params)
            throws AuthenticationException {
        ResponseData<UserInfo> responseData = new ResponseData<UserInfo>();
        String username=params.get("username").toString();
        String password=params.get("password").toString();
        UserInfo userInfo = authService.login(username, password);
        if(userInfo!=null && userInfo.getToken().length()>0)
        {responseData.setData(userInfo);
            responseData.setMsg("login success");
            responseData.setSuccess(true);
            responseData.setCode(200);
        }else{
            responseData.setMsg("login failed");
            responseData.setSuccess(false);
            responseData.setCode(200);
        }
        return responseData;
    }


//    @CrossOrigin(origins = "*")
//    @RequestMapping(value = "/login", method = { RequestMethod.POST, RequestMethod.GET })
//    public ResponseData loginForToken(@RequestBody Map<String, Object> params)
//            throws AuthenticationException {
//        ResponseData<UserInfo> responseData = new ResponseData<>();
//
//        // 检查请求参数是否为空
//        if (params == null || params.isEmpty()) {
//            responseData.setMsg("Request body is empty or missing");
//            responseData.setSuccess(false);
//            responseData.setCode(400); // Bad Request
//            return responseData;
//        }
//
//        // 检查用户名和密码是否存在
//        if (!params.containsKey("username") || !params.containsKey("password")) {
//            responseData.setMsg("Missing required parameters: username and/or password");
//            responseData.setSuccess(false);
//            responseData.setCode(400); // Bad Request
//            return responseData;
//        }
//
//        String username = (String) params.get("username");
//        String password = (String) params.get("password");
//
//        // 验证参数是否为空
//        if (username == null || username.trim().isEmpty() || password == null || password.trim().isEmpty()) {
//            responseData.setMsg("Username and password cannot be empty or null");
//            responseData.setSuccess(false);
//            responseData.setCode(400); // Bad Request
//            return responseData;
//        }
//
//        UserInfo userInfo = authService.login(username, password);
//        if (userInfo != null && userInfo.getToken() != null && !userInfo.getToken().trim().isEmpty()) {
//            responseData.setData(userInfo);
//            responseData.setMsg("Login success");
//            responseData.setSuccess(true);
//            responseData.setCode(200); // OK
//        } else {
//            responseData.setMsg("Login failed");
//            responseData.setSuccess(false);
//            responseData.setCode(401); // Unauthorized
//        }
//        return responseData;
//    }


    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/refresh", method = RequestMethod.GET)
    public ResponseEntity<?> refreshAndGetAuthenticationToken(HttpServletRequest request)
            throws AuthenticationException {
        String token = request.getHeader(tokenHeader);
        String refreshedToken = authService.refresh(token);
        if (refreshedToken == null) {
            return ResponseEntity.badRequest().body(null);
        } else {
            return ResponseEntity.ok(new Token(refreshedToken));
        }
    }


    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/register", method = {RequestMethod.POST})
    @ResponseBody
    public ResponseData register(@RequestBody Map<String,Object> params) throws AuthenticationException {
        String username=params.get("username").toString();
        String password=params.get("password").toString();
        String code=params.get("code").toString();
        UserInfo user=new UserInfo();
        user.setUserName(username);
        user.setPassword(password);
        Role role=new Role();
        role.setId(2);
        role.setRoleName("USER");
        role.setRoleDesc("普通用户");
        List<Role> roles=new ArrayList<Role>();
        roles.add(role);
        user.setRoleList(roles);//默认普通用户角色
        ResponseData<UserInfo> responseData = new ResponseData<UserInfo>();
        UserInfo addedUser=authService.register(user);
        if (addedUser != null) {
            responseData.setSuccess(true);
            responseData.setMsg("注册用户成功！");
            responseData.setData(addedUser);
        } else {
            responseData.setSuccess(false);
            responseData.setMsg("注册用户失败！");
        }
        return responseData;
    }
}
