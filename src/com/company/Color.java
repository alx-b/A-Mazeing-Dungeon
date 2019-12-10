package com.company;

public enum Color {
    DEFAULT("\u001B[0m"),
    BG_GREY("\u001B[47m"),
    WHITE_BG_GREEN("\033[30;42m"),
    WHITE_BG_BLUE("\033[30;44m"),
    WHITE_BG_YELLOW("\033[30;43m"),
    WHITE_BG_MAGENTA("\033[30;45m");

    public String v;
    Color(String value){
        this.v = value;
    }
}
