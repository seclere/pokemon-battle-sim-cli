import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.*;

abstract class Pokemon{
    //stats
    private String name;
    private int hp;
    private int attack;
    private int spattack;
    private int defense;
    private int spdefense;
    private int speed;
    private String type;
    private String type2;

    public Pokemon(String name, int hp, int attack, int spattack, int defense, int spdefense, int speed, String type, String type2) {
        this.name = name;
        this.hp = hp;
        this.attack = attack;
        this.spattack = spattack;
        this.defense = defense;
        this.spdefense = spdefense;
        this.speed = speed;
        this.type = type;
        this.type2 = type2;
    }

    public void pokemonGetter(String name, int hp, int attack, int spattack, int defense, int spdefense, int speed, String type, String type2){
        this.name = name;
        this.hp = hp;
        this.attack = attack;
        this.spattack = spattack;
        this.defense = defense;
        this.spdefense = spdefense;
        this.speed = speed;
        this.type = type;
    }

    public static class statuseffect {
    }
    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getType2() {
        return type2;
    }
}

abstract class Moves{
    public int currentpp;
    private String name;
    private int power;
    private int accuracy;
    private int pp;
    private String type;
    private int attacktype; // 0 = phys, 1 = special

    public Moves(String name, int power, int accuracy, int pp, String type, int attacktype){
        this.name = name;
        this.power = power;
        this.accuracy = accuracy;
        this.pp = pp;
        this.type = type;
        this.currentpp = pp;
        this.attacktype = attacktype;
    }

    public String getName() {
        return name;
    }
    public int getPower() {
        return power;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public int getPP() {
        return pp;
    }

    public String getMovetype() {
        return type;
    }

    public int attacktype() {
        return attacktype;
    }
}

interface statuseffects{
    void applystatuseffect(pokemonattempt pokemon);
    void applystatusdamage(pokemonattempt pokemon);
}

enum PokemonType{
    NORMAL, FIGHTING, FLYING, POISON, GROUND, ROCK, BUG, GHOST,
    STEEL, FIRE, WATER, GRASS, ELECTRIC, PSYCHIC, ICE, DRAGON, DARK, FAIRY
}

class typeeffectiveness {
    private static final double[][] EFFECTIVENESS_MATRIX = {
            //              NORMAL, FIGHTING, FLYING, POISON, GROUND, ROCK, BUG, GHOST, STEEL, FIRE, WATER, GRASS, ELECTRIC, PSYCHIC, ICE, DRAGON, DARK, FAIRY
            /* Normal */   {1.0,    1.0,      1.0,    1.0,    1.0,    0.5,  1.0, 0.0,   0.5,   1.0,  1.0,   1.0,   1.0,      1.0,     1.0, 1.0,    1.0,  1.0},
            /* Fighting */ {2.0,    1.0,      0.5,    0.5,    1.0,    2.0,  0.5, 0.0,   2.0,   1.0,  1.0,   1.0,   1.0,      0.5,     2.0, 1.0,    2.0,  0.5},
            /* Flying */   {1.0,    2.0,      1.0,    1.0,    1.0,    0.5,  2.0, 1.0,   0.5,   1.0,  1.0,   2.0,   0.5,      1.0,     1.0, 1.0,    1.0,  1.0},
            /* Poison */   {1.0,    1.0,      1.0,    0.5,    0.5,    0.5,  1.0, 0.5,   0.0,   1.0,  1.0,   2.0,   1.0,      1.0,     1.0, 1.0,    2.0,  2.0},
            /* Ground */   {1.0,    1.0,      0.0,    2.0,    1.0,    2.0,  0.5, 1.0,   2.0,   2.0,  1.0,   0.5,   2.0,      1.0,     1.0, 1.0,    1.0,  1.0},
            /* Rock */     {1.0,    0.5,      2.0,    1.0,    0.5,    1.0,  2.0, 1.0,   0.5,   2.0,  1.0,   1.0,   1.0,      1.0,     2.0, 1.0,    1.0,  1.0},
            /* Bug */      {1.0,    0.5,      0.5,    0.5,    1.0,    1.0,  1.0, 0.5,   0.5,   0.5,  1.0,   2.0,   1.0,      2.0,     1.0, 1.0,    2.0,  0.5},
            /* Ghost */    {0.0,    1.0,      1.0,    1.0,    1.0,    1.0,  1.0, 2.0,   1.0,   1.0,  1.0,   1.0,   1.0,      2.0,     1.0, 1.0,    1.0,  1.0},
            /* Steel */    {1.0,    1.0,      1.0,    1.0,    1.0,    2.0,  1.0, 1.0,   0.5,   0.5,  0.5,   1.0,   0.5,      1.0,     2.0, 1.0,    1.0,  1.0},
            /* Fire */     {1.0,    1.0,      1.0,    1.0,    1.0,    0.5,  2.0, 1.0,   2.0,   0.5,  0.5,   2.0,   1.0,      1.0,     2.0, 0.5,    1.0,  0.5},
            /* Water */    {1.0,    1.0,      1.0,    1.0,    2.0,    2.0,  1.0, 1.0,   1.0,   2.0,  0.5,   0.5,   1.0,      1.0,     1.0, 0.5,    1.0,  1.0},
            /* Grass */    {1.0,    1.0,      0.5,    0.5,    2.0,    2.0,  0.5, 1.0,   0.5,   0.5,  2.0,   0.5,   1.0,      1.0,     1.0, 0.5,    1.0,  1.0},
            /* Electric */ {1.0,    1.0,      2.0,    1.0,    0.0,    1.0,  1.0, 1.0,   1.0,   1.0,  2.0,   0.5,   0.5,      1.0,     1.0, 0.5,    1.0,  1.0},
            /* Psychic */  {1.0,    2.0,      1.0,    2.0,    1.0,    1.0,  1.0, 1.0,   0.5,   1.0,  1.0,   1.0,   1.0,      0.5,     1.0, 1.0,    1.0,  1.0},
            /* Ice */      {1.0,    1.0,      2.0,    1.0,    2.0,    1.0,  1.0, 1.0,   0.5,   0.5,  0.5,   2.0,   1.0,      1.0,     2.0, 0.5,    1.0,  1.0},
            /* Dragon */   {1.0,    1.0,      1.0,    1.0,    1.0,    1.0,  1.0, 1.0,   0.5,   1.0,  1.0,   1.0,   1.0,      1.0,     2.0, 1.0,    0.0,  0.0},
            /* Dark */     {1.0,    0.5,      1.0,    1.0,    1.0,    1.0,  1.0, 2.0,   1.0,   1.0,  1.0,   1.0,   1.0,      2.0,     1.0, 0.5,    0.5,  0.5},
            /* Fairy */    {1.0,    2.0,      1.0,    0.5,    1.0,    1.0,  1.0, 1.0,   0.5,   0.5,  1.0,   1.0,   1.0,      1.0,     1.0, 2.0,    2.0,  1.0},
    };

    static double effectivenesscalc(PokemonType attacking, PokemonType defending){
        int attackingindex = attacking.ordinal();
        int defendingindex = defending.ordinal();
        return EFFECTIVENESS_MATRIX[attackingindex][defendingindex];
    }
}

class pokemonattempt extends Pokemon{
    int currenthp, currentattack, currentspattack;
    int currentdefense, currentspdefense, currentspeed;
    int maxhp;

    private Moves[] moves = new Moves[4];

    pokemonattempt(String name, int hp, int attack, int spattack, int defense, int spdefense, int speed, String type,  String type2) {
        super(name, hp, attack, spattack, defense, spdefense, speed, type, type2);
        this.currenthp = hp;
        this.currentattack = attack;
        this.currentspattack = spattack;
        this.currentdefense = defense;
        this.currentspdefense = spdefense;
        this.currentspeed = speed;
        this.maxhp = currenthp;
    }
    public void setMove(int index, Moves move) {
        if (index >= 0 && index < moves.length) {
            moves[index] = move;
        } else {
            // Handle the case where an invalid index is provided.
            System.out.println("Invalid move index.");
        }
    }

    // Getter for moves
    public Moves[] getMoves() {
        return moves;
    }
    int statuseffect;
}

class moveattempt extends Moves{
    int currentpp;
    public moveattempt(String name, int power, int accuracy, int pp, String type, int attacktype){
        super(name, power, accuracy, pp, type, attacktype);
        this.currentpp = pp;
    }
}


class FileHandling {

    private String namefile;
    private String difficultyfile;
    private String playteamfile;
    private int enemyteamfile;

    public void setNamefile(String name) {
        this.namefile = name;
    }

    public void setDifficultyfile(String difficulty) {
        this.difficultyfile = difficulty;
    }

    public void setPlayteamfile(String playteam) {
        this.playteamfile = playteam;
    }

    public void setEnemyteamfile(int enemyteam) {
        this.enemyteamfile = enemyteam;
    }

    static String userHome = System.getProperty("user.home");
    private static Path filePath = Paths.get(userHome, "pokemonfile.txt");
    public static BufferedWriter writer;

    public static void initializeWriter() {
        try {
            writer = new BufferedWriter(new FileWriter(String.valueOf(filePath), true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void savetofile() {
        try {
            if (writer == null) {
                initializeWriter();
            }

            writer.write(difficultyfile.toUpperCase() + "|" + namefile.toUpperCase() + "|" + playteamfile + "|" + enemyteamfile);
            writer.newLine(); // Add a newline character to separate entries
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readfile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(String.valueOf(filePath)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("Read from file: " + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void closeWriter() {
        try {
            if (writer != null) {
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String findplayer(String name) {
        String lastLine = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(String.valueOf(filePath)))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(name)) {
                    lastLine = line;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lastLine;
    }
}

