package com.gk_software.entertainment.web.api;

import com.gk_software.entertainment.model.Puzzle;
import com.gk_software.entertainment.model.PuzzleSoultion;
import com.gk_software.entertainment.model.ResponseToSolution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by vgogilchyn on 06.09.16.
 */
@org.springframework.web.bind.annotation.RestController
public class RestController {

    @Autowired
    private MongoOperations mongoOperation;

    @RequestMapping(value="/{teamName}/{puzzleAlias}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Puzzle> begin(@PathVariable String teamName, @PathVariable String puzzleAlias) {
        Puzzle puzzle = mongoOperation.findOne(new Query().addCriteria(Criteria.where("alias").is(puzzleAlias)),Puzzle.class);
        return ResponseEntity.ok(puzzle);
    }

    @RequestMapping(value = "/test", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseToSolution> testIt () {
        return ResponseEntity.ok(new ResponseToSolution("Yes", true));
    }

    @RequestMapping(value = "/{teamName}/{puzzleAlias}/solve", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseToSolution> helloWorld(@PathVariable String teamName, @PathVariable String puzzleAlias, @RequestBody PuzzleSoultion soultion) {
        if (soultion.getSolution().equals("Yes")) {
            Puzzle puzzle = mongoOperation.findOne(new Query().addCriteria(Criteria.where("alias").is(puzzleAlias)),Puzzle.class);
            // if (puzzle.getSolution().equals(soultion.getSolution())) //Blah-0blah, will check it later
            return ResponseEntity.ok(new ResponseToSolution("Ok", true));
        } else {
            return ResponseEntity.ok(new ResponseToSolution("Try harder", false));
        }

    }

    @RequestMapping(value = "/init", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> initDb() {
//        Puzzle puzzle1 = new Puzzle("Task for puzzle no 1", "Solution text for puzzle 1");
//        Puzzle puzzle2 = new Puzzle("Task for puzzle no 2", "There are no solution for puzzle 2");
//        mongoOperation.save(puzzle1);
//        mongoOperation.save(puzzle2);
//        System.out.println(puzzle1.getId());
//        System.out.println(puzzle2.getId());
        ResponseEntity entity = ResponseEntity.ok(true);
        return entity;

    }

}
