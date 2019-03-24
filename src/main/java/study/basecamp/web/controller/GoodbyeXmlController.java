package study.basecamp.web.controller;

import study.basecamp.service.GameService;
import study.basecamp.wire.GameResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class GoodbyeXmlController {
    @Autowired
    private GameService gameService;

    @RequestMapping(value = "/game/{num}", method = RequestMethod.GET)// він призодить на dispatcher servlet
    @ResponseBody
    public ResponseEntity<String> play(@PathVariable String num) {

        gameService.isGameWon(num);

        GameResponse response = new GameResponse(gameService);

        return new ResponseEntity<>(response.getJson(), response.getResponseHeaders(), HttpStatus.OK);
    }


}