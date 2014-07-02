package bepid.ccerto.score.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import bepid.ccerto.guess.domain.Guess;
import bepid.ccerto.guess.repository.GuessRepository;
import bepid.ccerto.result.domain.Result;
import bepid.ccerto.score.domain.Pontuation;
import bepid.ccerto.score.domain.Score;
import bepid.ccerto.score.repository.ScoreRepository;
import bepid.ccerto.user.domain.User;
import bepid.ccerto.user.repository.UserRepository;

@Controller
@RequestMapping("/score")
public class ScoreService {
	
	@Autowired
	ScoreRepository scoreRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	GuessRepository guessRepository;
	
	@Transactional
	@RequestMapping(value = "/update/{idUser}")
	public void updateScore(@PathVariable Long idUser, HttpServletResponse response){
		User user = userRepository.findOne(idUser);	
		List<Guess> shots = user.getShots();
		
		for (Guess shot : shots) {
			if (shot.getScore() == null && shot.getMatch().getResult() != null) {
				Score score = new Score();
				score.setGuess(shot);
				score.setPoints(checkResult(shot).getValue());
				scoreRepository.save(score);
			}
		}
		try {
			response.getWriter().print(scoreRepository.getTotal(user));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private Pontuation checkResult(Guess shot) {
		Result result = shot.getMatch().getResult();
		if (result != null) {
			if (shot.getScoreHome().equals(result.getScoreHome()) 
					&& shot.getScoreAway().equals(result.getScoreAway())) {
				return Pontuation.ACERTOU_PLACAR;
			}
			String winnerShot = Integer.parseInt(shot.getScoreHome()) > Integer.parseInt(shot.getScoreAway()) ? "home" : 
				Integer.parseInt(shot.getScoreAway()) > Integer.parseInt(shot.getScoreHome()) ? "away" : "none";
			String winnerResult = Integer.parseInt(result.getScoreHome()) > Integer.parseInt(result.getScoreAway()) ? "home" : 
				Integer.parseInt(result.getScoreAway()) > Integer.parseInt(result.getScoreHome()) ? "away" : "none";
			return winnerShot.equals(winnerResult) ? Pontuation.ACERTOU_RESULTADO : Pontuation.ERROU;
		}
		return null;
	}

}
