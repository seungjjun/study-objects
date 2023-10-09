package main;

import main.java.chapter12.Lecture;
import main.java.chapter12.Professor;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        Professor professor = new Professor("다익스트라",
                new Lecture(70,"알고리즘", Arrays.asList(81, 95, 75, 50, 45)));

        String statistics = professor.compileStatistics();
    }
}
