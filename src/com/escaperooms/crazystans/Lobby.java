package com.escaperooms.crazystans;


import com.escaperooms.music.MusicPlayer;

class Lobby {
    private MusicPlayer musicPlayer;
    private Hinter hinter;

    public Lobby() {
    }

    String start() {
        generateHints();
        System.out.println(welcomeMessage());
        playLobbyChallenge();
        return "songKey";
    }

    private void playLobbyChallenge() {
        musicPlayer = new MusicPlayer("feelitstill.wav");
        playSong();
        askQuestion();
        musicPlayer.stopMusic();
    }

    private void askQuestion() {
        String hint = CrazyStansPrompter.prompt("The answer is in the song. When something's unexpected, it is said to be what? Listen carefully. " +
                        "Type 'commands' to see what you can do. ",
                challengeAnswer() + "|hint", musicPlayer);
        if (hint.equals("hint")) {
            hintChecker();
        } else if(hint.equals("rerun")) {
            askQuestion();
        }
    }

    private void generateHints() {
        hinter = new Hinter("Think baseball terminology", "There's the right field, center field, then...",
                "Odd, strange, surprise. LISTEN TO THE LYRICS!");
    }

    private void hintChecker() {
        if (hinter.isEmpty()) {
            System.out.println("NO MORE HINTS! SOLVE IT! Coming...");
        } else {
            System.out.println("Hint: " + hinter.getHint());
        }
        askQuestion();
    }

    private String welcomeMessage() {
        return "Welcome to Crazy Stans Lobby";
    }

    private void playSong() {
        musicPlayer.start();
    }

    private String challengeAnswer() {
        return "out of left field";
    }
}
