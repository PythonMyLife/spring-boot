package wordladder;

import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin("*")
@RequestMapping(path="/wordladder")
/**
  @author="hzt"
 */
public class WordLadderController {
    static private boolean log = false;

    @RequestMapping("/search")
    public @ResponseBody String wordladder(
            @RequestParam(value="str1") String str1,
            @RequestParam(value="str2") String str2)
    {
        if(log) {return new WordLadder(str1,str2).getContent();}
        else {return "未登录请先登录！";}
    }

    @RequestMapping("/login")
    public @ResponseBody boolean login(
            @RequestParam(value="name") String name,
            @RequestParam(value="password") String password)
    {
        HttpHeaders headers= new HttpHeaders();
        RestTemplate restTemplate= new RestTemplate();
        Boolean result = restTemplate.getForObject("http://localhost:8083/auth?name="+name+"&&password="+password,Boolean.class);
        if(result){
            log = true;
            return true;
        } else{
            log = false;
            return false;
        }
    }

}
