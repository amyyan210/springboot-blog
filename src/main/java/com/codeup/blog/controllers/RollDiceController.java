package com.codeup.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RollDiceController {

        // not related to the path
        // url (in this case, in address bar)
        @GetMapping("/roll-dice")
        // not using @responsebody anymore because we want to load the template view instead of returning just text
        public String viewDice () {

            // points to the path where the view lives
            return "roll-dice";

        }

    @GetMapping("/roll-dice/{userGuess}")
    // not using @responsebody anymore because we want to load the template view instead of returning just text
    public String checkAnswer (@PathVariable int userGuess, Model model) {

        int randomNumber = (int) ((Math.random() * 6) + 1);

        model.addAttribute("userGuess", userGuess);
        model.addAttribute("randomNumber", randomNumber);
        // points to the path where the view lives
        return "check-dice";

    }



    }
