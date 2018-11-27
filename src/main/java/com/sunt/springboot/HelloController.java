package com.sunt.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class HelloController {

    @Autowired
    PlayerMapper playerMapper;

    @RequestMapping("/hello")
    public String hello(Model model){
        model.addAttribute("now", DateFormat.getDateTimeInstance().format(new Date()));
        return "hello";
    }

    @RequestMapping("/listPlayer")
    public String listPlayer(Model model) {
        List<Player> players = playerMapper.findAll();
        model.addAttribute("players", players);
        return "listPlayer";
    }

    @RequestMapping(value = "/api/player",method = RequestMethod.GET)
    @ResponseBody
    public List<Player> getPlayer(){
        List<Player> players = playerMapper.findAll();
        return players;
    }


    @RequestMapping(value = "/api/playerid",method = RequestMethod.POST)
    @ResponseBody
    public List<Player> getId(Integer id){//查
        List<Player> players = playerMapper.findId(id);
        return players;
    }

    @RequestMapping(value = "/api/addplayer",method = RequestMethod.GET)
    @ResponseBody
    public int addPlayer(PlayerInfo playerInfo){//增
       int code  = playerMapper.addPlayer(playerInfo);
        return code;
    }

    @RequestMapping(value = "/api/deleteplayer",method = RequestMethod.GET)
    @ResponseBody
    public int deletePlayer(int id){//删
        int code  = playerMapper.deletePlayer(id);
        return code;
    }

    @RequestMapping(value = "/api/updateplayer",method = RequestMethod.POST)
    @ResponseBody
    public int updatePlayer(PlayerInfo playerInfo){//改
        int code  = playerMapper.update(playerInfo);
        return code;
    }
}
