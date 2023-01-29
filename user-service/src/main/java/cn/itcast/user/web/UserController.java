package cn.itcast.user.web;

import cn.itcast.user.config.PatternProperties;
import cn.itcast.user.pojo.User;
import cn.itcast.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
//@RefreshScope
@RestController
@RequestMapping("/user")
public class UserController {


//    @Value("${pattern.dateformat}")
//    private String dateformat;

    @Autowired
    private PatternProperties pattern;
    @GetMapping("now")
    public String noe()  {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(pattern.getDateformat()));
    }

    @GetMapping("pro")
    public PatternProperties pro()  {
        return pattern;
    }

    @Autowired
    private UserService userService;

    /**
     * 路径： /user/110
     *
     * @param id 用户id
     * @return 用户
     */
    @GetMapping("/{id}")
    public User queryById(@PathVariable("id") Long id) {
        return userService.queryById(id);
    }
}
