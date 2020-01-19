package com.am.training.demo.controller;

import com.am.training.demo.dto.Output;
import com.am.training.demo.entity.DataItem;
import com.am.training.demo.processor.CsvProcessor;
import com.am.training.demo.service.DataItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressWarnings("ALL")
@RestController
@RequestMapping(value = "dataitems")
public class DataItemController {


    private static final Logger logger = LoggerFactory.getLogger(DataItemController.class);

    @Autowired
    private   DataItemService service;


    @Autowired
    public DataItemController(  )   {

    }

    /**
     * 1. Welcher Politiker hielt im Jahr 2013 die meisten Reden
     * 2. Welcher Politiker hielt die meisten Reden zum Thema ”Innere Sicherheit”
     * 3. Welcher Politiker sprach insgesamt die wenigsten Wörter
     *
     * @param question
     * @return
     */
    @GetMapping(value = "output", produces = "application/json")
    public Output getTheOutput(@RequestParam("question") String question) throws Exception {
        if (question.isEmpty()) {
            throw new Exception("Parameter question is missing");
        }

        if(question.contains("”")){
            question = question.replaceAll("\\”", "\"");
        }

        String question1 = "", question2 = "", question3 = "";
        if (question.contains("|")) {
            logger.info("has multiple questions");
            String[] questions = question.split("\\|");
            if (questions.length == 1) {
                question1 = questions[0];
            } else if (questions.length == 2) {
                question1 = questions[0];
                question2 = questions[1];
            } else if (questions.length == 3) {
                question1 = questions[0];
                question2 = questions[1];
                question3 = questions[2];
            }
            logger.info("Q1: " + question1 + "; Q2: " + question2 + "; Q3: " + question3);

        }
        Output output = new Output();
        Pattern patternWhichPolitician = Pattern.compile("Welcher Politiker hielt im Jahr [0-9]{4} die meisten Reden");

        String qWhichTopic = "Welcher Politiker hielt die meisten Reden zum Thema \"(\\w+)(\\s\\w+)*\"";
        logger.info("Which Topic: "+ qWhichTopic);
        Pattern patternWhichTopicSecurity = Pattern.compile(qWhichTopic);
        String qLeastWords = "Welcher Politiker sprach insgesamt die wenigsten Wörter";

        Pattern patternLeastWords = Pattern.compile(qLeastWords);

        Matcher matcherWhichPolitician = patternWhichPolitician.matcher(question1.isEmpty() ? question : question1);
        Matcher matcherWhichTopicSecurity = patternWhichTopicSecurity.matcher(question2.isEmpty() ? question : question2);
        Matcher matcherLeastWords = patternLeastWords.matcher(question3.isEmpty() ? question : question3);

        if (matcherWhichPolitician.matches()) {
            logger.info("Which politician.");
            String justNumber = question.replaceAll("[^\\d.]", "");
            Integer theYear = Integer.parseInt(justNumber);
    logger.info("The year: "+ theYear);
            LocalDate start = LocalDate.parse("" + theYear + "-01-01");
            LocalDate end = start.plusYears(1).minusDays(1);
            logger.info("Start: " + start + "; end: " + end);
            output.setMostSpeeches(service.getMostTalksPerYear(start, end));

        }

        if (matcherWhichTopicSecurity.matches()) {
            String topic = "";

            Pattern p = Pattern.compile("\"([^\"]*)\"");
            Matcher m = p.matcher(question2.isEmpty()?question:question2);
            String gd= "";
            if (m.find()) {
                gd = (m.group(1));

            }
            topic = gd;

            String name = service.getTheTalkerByTopic(topic);
            output.setMostSecurity(name);
        }

        if (matcherLeastWords.matches()) {
            logger.info("Least words spoken");
            String name = service.getTheMinimalWordsPerTalk();
            logger.debug("Least wordy");
            output.setLeastWordy(name);
        } else {
            logger.info("Question not understood: "+question);
        }
        return output;
    }


}
