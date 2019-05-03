package com.bobbyplunkett.springWebAppExercise.controllers;

import com.bobbyplunkett.springWebAppExercise.repositories.ClubRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * A controller class for student {@link com.bobbyplunkett.springWebAppExercise.model.Club}
 *
 * @author Bobby Plunkett
 * @version 0.0.1
 * @since 12:06 AM
 */
@Controller
public class ClubController {

    private ClubRepository clubRepository;

    public ClubController(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    @RequestMapping("/clubs")
    public String getClubs(Model model) {
        model.addAttribute("clubs", clubRepository.findAll());
        return "clubs";
    }
}
