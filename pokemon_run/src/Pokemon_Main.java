import java.io.File;
import java.util.Scanner;
import java.lang.Thread;
import java.nio.file.Path;
import java.nio.file.Files;
import java.io.IOException;

public class Pokemon_Main {
    private static Scanner input = new Scanner(System.in);
    private static int inputChecker = 1;
    private static int inputChecker2 = 1;
    private static int teamnumber;
    private static String playerName;
    private static String playerTeam;
    static String difficulty;

    static int enemyTeamFile = 3;

    //************************************
    public static FileHandling file = new FileHandling();
    public static Pokemon_Fight fight = new Pokemon_Fight();

    public static String getDifficulty(){
        return difficulty;
    }

    public static String getPlayerName(){
        return playerName;
    }

    public static int getTeamnumber(){
        return teamnumber;
    }
    //************************************

    public static void main(String[] args) {

        System.out.println(""" 
                            ⊝═════════════════════════════⊝
                            ║   PRESS ENTER TO CONTINUE   ║
                            ⊝═════════════════════════════⊝""");
        input.nextLine();

        String mainMenuChoice;
        do{
            clearConsole();
            System.out.println("""
                ⊝════════════════════⊝
                ║ [C] CONTINUE       ║
                ║ [N] NEW GAME       ║
                ║ [A] ABOUT          ║
                ║ [E] EXIT GAME      ║
                ⊝════════════════════⊝""");
            mainMenuChoice = input.nextLine();
            mainMenu(mainMenuChoice);
        }while(!mainMenuChoice.equals("E") && !mainMenuChoice.equals("e"));
    }

    public static void mainMenu(String x){
        //MAIN MENU
        switch(x){
            case "C": //CONTINUE
            case "c":
                clearConsole();
                int savedGameExists = 0;

                //**********************************
                System.out.println(""" 
                            ⊝════════════════⊝
                            ║   ENTER NAME   ║
                            ⊝════════════════⊝""");
                String findname;
                findname = input.nextLine().toUpperCase();
                //file.findplayer(findname);

                //find name sa file
                String result = FileHandling.findplayer(findname);

                if (result != null) {
                    Pokemon_Fight run = new Pokemon_Fight();
                    String[] parts = result.split("\\|");
                    if (parts.length == 4) {
                        char difficultyFile = parts[0].charAt(0);
                        String playerNameFile = parts[1];
                        int playerTeamFile = Integer.parseInt(parts[2].trim());
                        enemyTeamFile = Integer.parseInt(parts[3].trim());
                        setDifficulty(String.valueOf(difficultyFile));
                        playerName = playerNameFile;
                        teamnumber = Integer.parseInt(String.valueOf(playerTeamFile));
                        run.initializepokemonmoves(enemyTeamFile);
                        savedGameExists = 1;
                    } else {
                        System.out.println(""" 
                            ⊝════════════════════════════════⊝
                            ║   INVALID FORMAT IN THE FILE   ║
                            ⊝════════════════════════════════⊝""");
                    }
                }

                /*/******************************************
                System.out.println("This is a temporary block of code as place holder. Input 1 if save exists. Input 0 if Save does not exist.");
                int savedGameExists = input.nextInt();
                input.nextLine();
                //*****************************************************/

                if(savedGameExists == 1){
                    gameBootUp(difficulty);
                }
                else {
                    clearConsole();
                    System.out.println(""" 
                            ⊝════════════════════════════⊝
                            ║   NO SAVED GAME FOUND :(   ║
                            ⊝════════════════════════════⊝""");
                    input.nextLine();
                    sleep();
                }
                break;

            case "N": //NEW GAME
            case "n":

                do {
                    savedGameExists = 0;

                    try {
                        String userHome = System.getProperty("user.home");
                        long fileSize = Files.size(Path.of(userHome,"pokemonfile.txt"));

                        if (fileSize > 0) {
                            savedGameExists = 1;
                        }
                    } catch (IOException e) {
                        // Handle exception (e.g., file not found or access denied)
                        e.printStackTrace();
                    }

                    clearConsole();

                    if (savedGameExists == 1) {
                        System.out.println(""" 
                            ⊝══════════════════════════════════════════⊝
                            ║   DO YOU WANT TO MAKE A NEW SAVE FILE?   ║
                            ║══════════════════════════════════════════║
                            ║            PROCEED? [Y]/[N]              ║
                            ⊝══════════════════════════════════════════⊝""");
                        String saveDecision = input.nextLine();
                        newGameMenu(saveDecision);
                    }
                    else {
                        inputChecker = 0;
                        System.out.println(""" 
                            ⊝═══════════════════════⊝
                            ║   CREATING NEW SAVE   ║
                            ⊝═══════════════════════⊝""");
                        sleep();
                    }

                    //DIFFICULTY SLIDER
                    inputChecker = 1;
                    do {
                        clearConsole();
                        System.out.println(""" 
                            ⊝═════════════════════⊝
                            ║   GAME DIFFICULTY   ║
                            ║═════════════════════║
                            ║   [N] NORMAL        ║
                            ║   [H] HARD          ║
                            ⊝═════════════════════⊝""");
                        difficulty = input.nextLine();

                        file.setDifficultyfile(difficulty);

                        setDifficulty(difficulty);
                    }while(inputChecker !=0);
                    clearConsole();
                    //PLAYER CREATION
                    System.out.println(""" 
                            ⊝════════════════════════⊝
                            ║   WHAT IS YOUR NAME?   ║
                            ⊝════════════════════════⊝""");
                    playerName = input.nextLine(); //kayo na bahala pano niyo nais isave playerinfo QuQ

                    //file.setNamefile(playerName);

                    //CHOOSE TEAM
                    chooseTeam();
                    gameBootUp(difficulty);
                }while(inputChecker != 0);
                break;

            case "A": //ABOUT
            case "a":
                clearConsole();
                System.out.println(""" 
                            ⊝════════════════════════════⊝
                            ║   PL - YSRAEL SALCES       ║
                            ║   P  - MOZART MEDRANO      ║
                            ║   TA - AIVERSON ABONG      ║
                            ║   DS - JANNA JUSTINIANO    ║
                            ║   SA - JEANNINA ORDOÑEZ    ║
                            ⊝════════════════════════════⊝
                            ║   PRESS ENTER TO GO BACK   ║
                            ⊝════════════════════════════⊝""");
                input.nextLine();
                break;

            case "E": //EXIT GAME
            case "e":
                clearConsole();
                System.out.println(""" 
                            ⊝═════════════════⊝
                            ║   IT'S JOEVER   ║
                            ⊝═════════════════⊝""");
                break;
            default:
                clearConsole();
                System.out.println(""" 
                            ⊝═══════════════════⊝
                            ║   INVALID INPUT   ║
                            ⊝═══════════════════⊝""");
        }
    }

    public static void newGameMenu(String y){
        switch(y){
            case "Y":
            case "y":
                clearConsole();
                inputChecker = 1;
                System.out.println(""" 
                            ⊝═══════════════════════════⊝
                            ║   PREVIOUS SAVE DELETED   ║
                            ║═══════════════════════════║
                            ║     LOADING NEW SAVE...   ║
                            ⊝═══════════════════════════⊝""");
                break;
            case "N":
            case "n":
                clearConsole();
                inputChecker = 0;
                break;
            default:
                clearConsole();
                inputChecker = 1;
                System.out.println(""" 
                            ⊝═══════════════════⊝
                            ║   INVALID INPUT   ║
                            ⊝═══════════════════⊝""");
        }
    }

    public static void gameBootUp(String z){
        clearConsole();
        System.out.println(""" 
                ⊝══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════⊝
                ║  █░░░░░░░░░░░░░░█░░░░░░░░░░░░░░█░░░░░░██████████░░░░░░█░░░░░░░░░░░░░░███████░░░░░░░░░░░░░░█░░░░░░░░░░░░░░█░░░░░░░░░░░░░░█░░░░░░░░░░░░░░░░███░░░░░░░░░░░░░░█  ║
                ║  █░░▄▀▄▀▄▀▄▀▄▀░░█░░▄▀▄▀▄▀▄▀▄▀░░█░░▄▀░░░░░░░░░░░░░░▄▀░░█░░▄▀▄▀▄▀▄▀▄▀░░███████░░▄▀▄▀▄▀▄▀▄▀░░█░░▄▀▄▀▄▀▄▀▄▀░░█░░▄▀▄▀▄▀▄▀▄▀░░█░░▄▀▄▀▄▀▄▀▄▀▄▀░░███░░▄▀▄▀▄▀▄▀▄▀░░█  ║
                ║  █░░▄▀░░░░░░░░░░█░░▄▀░░░░░░▄▀░░█░░▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀▄▀░░█░░▄▀░░░░░░░░░░███████░░▄▀░░░░░░░░░░█░░░░░░▄▀░░░░░░█░░▄▀░░░░░░▄▀░░█░░▄▀░░░░░░░░▄▀░░███░░░░░░▄▀░░░░░░█  ║
                ║  █░░▄▀░░█████████░░▄▀░░██░░▄▀░░█░░▄▀░░░░░░▄▀░░░░░░▄▀░░█░░▄▀░░███████████████░░▄▀░░█████████████░░▄▀░░█████░░▄▀░░██░░▄▀░░█░░▄▀░░████░░▄▀░░███████░░▄▀░░█████  ║
                ║  █░░▄▀░░█████████░░▄▀░░░░░░▄▀░░█░░▄▀░░██░░▄▀░░██░░▄▀░░█░░▄▀░░░░░░░░░░███████░░▄▀░░░░░░░░░░█████░░▄▀░░█████░░▄▀░░░░░░▄▀░░█░░▄▀░░░░░░░░▄▀░░███████░░▄▀░░█████  ║
                ║  █░░▄▀░░██░░░░░░█░░▄▀▄▀▄▀▄▀▄▀░░█░░▄▀░░██░░▄▀░░██░░▄▀░░█░░▄▀▄▀▄▀▄▀▄▀░░███████░░▄▀▄▀▄▀▄▀▄▀░░█████░░▄▀░░█████░░▄▀▄▀▄▀▄▀▄▀░░█░░▄▀▄▀▄▀▄▀▄▀▄▀░░███████░░▄▀░░█████  ║
                ║  █░░▄▀░░██░░▄▀░░█░░▄▀░░░░░░▄▀░░█░░▄▀░░██░░░░░░██░░▄▀░░█░░▄▀░░░░░░░░░░███████░░░░░░░░░░▄▀░░█████░░▄▀░░█████░░▄▀░░░░░░▄▀░░█░░▄▀░░░░░░▄▀░░░░███████░░▄▀░░█████  ║
                ║  █░░▄▀░░██░░▄▀░░█░░▄▀░░██░░▄▀░░█░░▄▀░░██████████░░▄▀░░█░░▄▀░░███████████████████████░░▄▀░░█████░░▄▀░░█████░░▄▀░░██░░▄▀░░█░░▄▀░░██░░▄▀░░█████████░░▄▀░░█████  ║
                ║  █░░▄▀░░░░░░▄▀░░█░░▄▀░░██░░▄▀░░█░░▄▀░░██████████░░▄▀░░█░░▄▀░░░░░░░░░░███████░░░░░░░░░░▄▀░░█████░░▄▀░░█████░░▄▀░░██░░▄▀░░█░░▄▀░░██░░▄▀░░░░░░█████░░▄▀░░█████  ║
                ║  █░░▄▀▄▀▄▀▄▀▄▀░░█░░▄▀░░██░░▄▀░░█░░▄▀░░██████████░░▄▀░░█░░▄▀▄▀▄▀▄▀▄▀░░███████░░▄▀▄▀▄▀▄▀▄▀░░█████░░▄▀░░█████░░▄▀░░██░░▄▀░░█░░▄▀░░██░░▄▀▄▀▄▀░░█████░░▄▀░░█████  ║
                ║  █░░░░░░░░░░░░░░█░░░░░░██░░░░░░█░░░░░░██████████░░░░░░█░░░░░░░░░░░░░░███████░░░░░░░░░░░░░░█████░░░░░░█████░░░░░░██░░░░░░█░░░░░░██░░░░░░░░░░█████░░░░░░█████  ║
                ⊝══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════⊝""");
        sleep();
        clearConsole();
        //BATTLE1 START
        System.out.println(""" 
                            ⊝══════════════════════════════════════════════════════════════⊝
                            ║   TIP: PROGRESS AUTOMATICALLY SAVES BEFORE EVERY BATTLE...   ║
                            ║══════════════════════════════════════════════════════════════║
                            ║                     CHECKPOINT SAVED...                      ║
                            ⊝══════════════════════════════════════════════════════════════⊝""");
        sleep();
        battleStart(z);
        System.exit(0);
    }

    public static void setDifficulty(String z){
        difficulty = z;
        switch(z){
            case "N": //NORMAL
            case "n":
                clearConsole();
                inputChecker = 0;
                System.out.println(""" 
                            ⊝════════════════════════⊝
                            ║   GAME SET TO NORMAL   ║
                            ⊝════════════════════════⊝""");
                sleep();
                break;

            case "H": //HARD
            case "h":
                clearConsole();
                inputChecker = 0;
                System.out.println(""" 
                            ⊝══════════════════════⊝
                            ║   GAME SET TO HARD   ║
                            ⊝══════════════════════⊝""");
                sleep();
                break;

            default:
                clearConsole();
                inputChecker = 1;
                System.out.println(""" 
                            ⊝═══════════════════⊝
                            ║   INVALID INPUT   ║
                            ⊝═══════════════════⊝""");
                sleep();
        }

    }
    public static void chooseTeam(){
        inputChecker = 1;
        do{
            clearConsole();
            System.out.println(""" 
                            ⊝═════════════════════════⊝
                            ║       CHOOSE TEAM       ║
                            ║═════════════════════════║
                            ║   [1] TEAM INSTINCT     ║
                            ║   [2] TEAM MYSTIC       ║
                            ║   [3] TEAM VALOR        ║
                            ⊝═════════════════════════⊝""");
            playerTeam = input.nextLine();

            file.setPlayteamfile(playerTeam);

            pokemonTeams(playerTeam);
        }while(!playerTeam.equals("1") && !playerTeam.equals("2") && !playerTeam.equals("3"));

        switch (playerTeam) {
            case "1" -> {
                clearConsole();
                System.out.print(" ⊝══════════");
                for (int chrctr = 0; chrctr < playerName.length(); chrctr++) {
                    System.out.print("═");
                }
                System.out.println("═════════════════════════⊝ ");
                System.out.println(" ║   PLAYER " + playerName.toUpperCase() + " CHOOSES TEAM INSTINCT   ║");
                System.out.print(" ⊝══════════");
                for (int chrctr = 0; chrctr < playerName.length(); chrctr++) {
                    System.out.print("═");
                }
                System.out.println("═════════════════════════⊝ ");
                teamnumber = 0;
                sleep();
            }
            case "2" -> {
                clearConsole();
                System.out.print(" ⊝══════════");
                for (int chrctr = 0; chrctr < playerName.length(); chrctr++) {
                    System.out.print("═");
                }
                System.out.println("═══════════════════════⊝ ");
                System.out.println(" ║   PLAYER " + playerName.toUpperCase() + " CHOOSES TEAM MYSTIC   ║");
                System.out.print(" ⊝══════════");
                for (int chrctr = 0; chrctr < playerName.length(); chrctr++) {
                    System.out.print("═");
                }
                System.out.println("═══════════════════════⊝ ");
                teamnumber = 1;
                sleep();
            }
            case "3" -> {
                clearConsole();
                System.out.print(" ⊝══════════");
                for (int chrctr = 0; chrctr < playerName.length(); chrctr++) {
                    System.out.print("═");
                }
                System.out.println("══════════════════════⊝ ");
                System.out.println(" ║   PLAYER " + playerName.toUpperCase() + " CHOOSES TEAM VALOR   ║");
                System.out.print(" ⊝══════════");
                for (int chrctr = 0; chrctr < playerName.length(); chrctr++) {
                    System.out.print("═");
                }
                System.out.println("══════════════════════⊝ ");
                teamnumber = 2;
                sleep();
            }
        }
    }
    public static void pokemonTeams(String a){
        String chooseDecision;
        switch(a){
            case "1":
                clearConsole();
                inputChecker = 0;
                do {
                    clearConsole();
                    System.out.println(""" 
                            ⊝═══════════════════════════════⊝
                            ║         TEAM INSTINCT         ║
                            ⊝═══════════════════════════════⊝
                            ║           PIKACHU             ║
                            ║           VENUSAUR            ║
                            ║           AEGISLASH           ║
                            ⊝═══════════════════════════════⊝
                            ║   CHOOSE THIS TEAM? [Y]/[N]   ║
                            ⊝═══════════════════════════════⊝""");
                    chooseDecision = input.nextLine();
                    confirmTeam(chooseDecision);
                }while(inputChecker2 != 0);
                break;
            case "2":
                inputChecker = 0;
                do{
                    clearConsole();
                    System.out.println(""" 
                            ⊝═══════════════════════════════⊝
                            ║          TEAM MYSTIC          ║
                            ⊝═══════════════════════════════⊝
                            ║           BLASTOISE           ║
                            ║            MINIOR             ║
                            ║           GARDEVOIR           ║
                            ⊝═══════════════════════════════⊝
                            ║   CHOOSE THIS TEAM? [Y]/[N]   ║
                            ⊝═══════════════════════════════⊝""");
                    chooseDecision = input.nextLine();
                    confirmTeam(chooseDecision);
                }while(inputChecker2 != 0);
                break;
            case "3":
                inputChecker = 0;
                do{
                    clearConsole();
                    System.out.println(""" 
                            ⊝═══════════════════════════════⊝
                            ║          TEAM  VALOR          ║
                            ⊝═══════════════════════════════⊝
                            ║           CHARIZARD           ║
                            ║           CRAMORANT           ║
                            ║            AVALUGG            ║
                            ⊝═══════════════════════════════⊝
                            ║   CHOOSE THIS TEAM? [Y]/[N]   ║
                            ⊝═══════════════════════════════⊝""");
                    chooseDecision = input.nextLine();
                    confirmTeam(chooseDecision);
                }while(inputChecker2 != 0);
                break;
            default:
                clearConsole();
                inputChecker = 1;
                System.out.println(""" 
                            ⊝═══════════════════⊝
                            ║   INVALID INPUT   ║
                            ⊝═══════════════════⊝""");
                sleep();

        }
    }
    public static void confirmTeam(String b){
        switch(b){
            case "Y":
            case "y":
                inputChecker2 = 0;
                break;
            case "N":
            case "n":
                inputChecker2 = 0;
                playerTeam = "0";
                break;
            default:
                clearConsole();
                inputChecker2 = 1;
                System.out.println(""" 
                            ⊝═══════════════════⊝
                            ║   INVALID INPUT   ║
                            ⊝═══════════════════⊝""");
                sleep();
        }
    }

    public static void battleStart(String difficulty){
        inputChecker = 1;
        int pointscounter = 0;
        int fightcounter = 1;
        int lives = 1;

        do {
            Pokemon_Fight run = new Pokemon_Fight();

            run.initializepokemonmoves(teamnumber);
            run.initializepokemonmoves(enemyTeamFile);

            // run.displaypokemonstatus(0);
            // run.displaypokemonstatus(1);

            while(enemyTeamFile<7) {
                if (run.combatui(difficulty, fightcounter, enemyTeamFile)) { // z = difficulty
                    run.initializepokemonmoves(teamnumber);
                    run.initializepokemonmoves(++enemyTeamFile);
                    if(enemyTeamFile == 4)
                        pointscounter = 30;
                    if(enemyTeamFile == 5)
                        pointscounter = 60;
                    if (enemyTeamFile == 6) {
                        pointscounter = 100;
                        System.out.println(""" 
                                    ⊝════════════════════════════════════════════════════⊝
                                    ║               YOU BECAME THE CHAMPION!             ║
                                    ⊝════════════════════════════════════════════════════⊝""");
                        inputChecker=0;
                        break;
                    }
                }
                else if (lives > 0){
                    lives--;
                    System.out.println(""" 
                            ⊝══════════════════════⊝
                            ║    YOU HAVE LOST!    ║
                            ║     ONE TRY LEFT!    ║
                            ⊝══════════════════════⊝
                            ║   TRY AGAIN? [Y/N]   ║
                            ⊝══════════════════════⊝""");
                    String saveprogress = input.nextLine().toUpperCase();
                    if(saveprogress.equals("Y") || saveprogress.equals("y") ) {
                        run.initializepokemonmoves(teamnumber);
                        run.initializepokemonmoves(enemyTeamFile);
                    } else if (saveprogress.equals("N") || saveprogress.equals("n") ) {
                        System.out.println(""" 
                            ⊝══════════════════════════════════════════════════════⊝
                            ║                      GAME OVER!                      ║
                            ⊝══════════════════════════════════════════════════════⊝""");
                        inputChecker=0;
                        break;
                    }
                }

                else if (lives == 0){
                    System.out.println(""" 
                            ⊝══════════════════════════════════════════════════════⊝
                            ║                      GAME OVER!                      ║
                            ⊝══════════════════════════════════════════════════════⊝""");
                    inputChecker=0;
                    break;


                }
            }
        }while(inputChecker != 0);
        System.out.println("Name: " + playerName);
        System.out.println("Difficulty: " + difficulty);
        System.out.println("Your total points: " + pointscounter);
    }

    public static void clearConsole() {
        // Print enough empty lines to "clear" the console
        for (int i = 0; i < 69; ++i) {
            System.out.println();
        }
    }

    public static void sleep(){
        try {
            for (int i = 0; i < 2; i++) {
                Thread.sleep(500);
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

}