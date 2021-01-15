package com.denisiuk.catan.controller;

import com.denisiuk.catan.entity.Board;
import com.denisiuk.catan.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class CatanController {

    @Autowired
    private BoardService boardService;

    @Autowired
    private Board board;

    @RequestMapping("/play")
    public String playGame(Model model){
        System.out.println("______________________");
        System.out.println("hello from playGame");
        BoardService players = new BoardService();
        model.addAttribute("number", players);
        System.out.println("goodbye from PlayGame");
        System.out.println("______________________");
        return "redirect:/check";
    }

    @RequestMapping("/start")
    public String startGame(@ModelAttribute("number") BoardService players, Model model){
        System.out.println("______________________");
        System.out.println("hello from startGame");
        players.getPlayerCount();
        System.out.println("player count= " + players.getPlayerCount());
        boardService.setDice(0);
        model.addAttribute("roll", boardService.getDice());
        model.addAttribute("boardArray", boardService.initializeBoard());
        model.addAttribute("numberArray", boardService.getNumberArray());
        model.addAttribute("endl", boardService.getEndl());
        System.out.println("goodbye from startGame");
        System.out.println("______________________");
        return "redirect:/showmap";
    }

    @RequestMapping(value = "/showmap")
    public String showMap(Model model){
        System.out.println("______________________");
        System.out.println("hello from showMap no param");
        model.addAttribute("boardArray", boardService.getResourceList());
        model.addAttribute("numberArray", boardService.getNumberArray());
        model.addAttribute("endl", boardService.getEndl());
        model.addAttribute("roll", boardService.getDice());
        System.out.println("goodbye from showMap no param");
        System.out.println("______________________");
        return "map";
    }

    @RequestMapping(value = {"/showmap/{column}/{row}"})
    public String showMapAfterClick(@PathVariable Integer column, @PathVariable Integer row, Model model){
        System.out.println("______________________");
        System.out.println("hello from showMap with param");
        model.addAttribute("boardArray", boardService.getResourceList());
        model.addAttribute("numberArray", boardService.getNumberArray());
        model.addAttribute("endl", boardService.getEndl());
        model.addAttribute("roll", boardService.getDice());
        board.freeCity(column, row);
        System.out.println("goodbye from showMap with param");
        System.out.println("______________________");
        return "map";
    }

    @RequestMapping("roll")
    public String roll(Model model){
        System.out.println("______________________");
        System.out.println("hello from roll");
        boardService.diceRoll();
        model.addAttribute("roll", boardService.getDice());
        boardService.countResources();
        System.out.println("goodbye from roll");
        System.out.println("______________________");
        return "redirect:/showmap";
    }

    @RequestMapping("check")
    public String gameLoop(){
        System.out.println("______________________");
        System.out.println("hello from check");
        boardService.checkOrder();
        System.out.println("goodbye from check");
        System.out.println("______________________");
        return "redirect:/start";
    }
}