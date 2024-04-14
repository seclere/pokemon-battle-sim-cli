import java.util.Random;
import java.util.Scanner;

public class Pokemon_Fight{

    pokemonattempt PlayerPokemon1;
    pokemonattempt PlayerPokemon2;
    pokemonattempt PlayerPokemon3;
    pokemonattempt EnemyPokemon1;
    pokemonattempt EnemyPokemon2;
    pokemonattempt EnemyPokemon3;
    int turncounter = 0;


    //*************
    FileHandling file = new FileHandling();

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

    public void setEnemyteamfile(int enemyteamfile) {
        this.enemyteamfile = enemyteamfile;
    }

    //***************
    //*************
    Moves[] PlayerPokemon1Moves;
    Moves[] PlayerPokemon2Moves;
    Moves[] PlayerPokemon3Moves;
    Moves[] EnemyPokemon1Moves;
    Moves[] EnemyPokemon2Moves;
    Moves[] EnemyPokemon3Moves;

    boolean playerparalyzed = false;
    boolean enemyparalyzed = false;
    boolean playerpoison = false;
    boolean enemypoison = false;
    boolean playerburn = false;
    boolean enemyburn = false;
    boolean playerconfused = false;
    boolean enemyconfused = false;



    void initializepokemonmoves(int team) {

        if (team == 0) { // Pikachu, Venusaur, Aegislash
            PlayerPokemon1 = new pokemonattempt("Pikachu", 95, 54, 31, 49, 40, 85, "ELECTRIC", null);
            PlayerPokemon2 = new pokemonattempt("Venusaur", 140, 78, 79, 94, 94, 76, "GRASS", "POISON");
            PlayerPokemon3 = new pokemonattempt("Aegislash", 60, 50, 140, 50, 140, 60, "STEEL", "GHOST");
        } else if (team == 1) { // Blastoise, Minior, Gardevoir
            PlayerPokemon1 = new pokemonattempt("Blastoise", 139, 79, 94, 81, 99, 74, "WATER", null);
            PlayerPokemon2 = new pokemonattempt("Minior", 60, 60, 100, 60, 100, 60, "ROCK", "FLYING");
            PlayerPokemon3 = new pokemonattempt("Gardevoir", 68, 65, 65, 125, 115, 80, "PSYCHIC", "FAIRY");
        } else if (team == 2) { // Charizard, Cramorant, Avalugg
            PlayerPokemon1 = new pokemonattempt("Charizard", 138, 80, 74, 102, 81, 94, "FIRE", "FLYING");
            PlayerPokemon2 = new pokemonattempt("Cramorant", 70, 85, 55, 85, 95, 85, "FLYING", "WATER");
            PlayerPokemon3 = new pokemonattempt("Avalugg", 95, 117, 184, 44, 46, 28, "ICE", null);
        } else if (team == 3) { // Golem, Gengar, Vaporeon
            EnemyPokemon1 = new pokemonattempt("Golem", 80, 110, 130, 55, 65, 45, "ROCK", "GROUND");
            EnemyPokemon2 = new pokemonattempt("Gengar", 60, 65, 60, 130, 75, 110, "GHOST", "POISON");
            EnemyPokemon3 = new pokemonattempt("Vaporeon", 130, 65, 60, 110, 95, 65, "WATER", null);
        } else if (team == 4) { // Galarian Meowth, Slaking, (Galarian) Moltres
            EnemyPokemon1 = new pokemonattempt("Galarian Meowth", 50, 65, 55, 40, 40, 85, "STEEL", null);
            EnemyPokemon2 = new pokemonattempt("Slaking", 150, 160, 100, 95, 65, 100, "NORMAL", null);
            EnemyPokemon3 = new pokemonattempt("Moltres", 90, 100, 90, 125, 85, 90, "DARK", "FLYING");
        } else if (team == 5) { // Mightyena, Calyrex, Pangoro
            EnemyPokemon1 = new pokemonattempt("Mightyena", 70, 90, 70, 60, 60, 70, "DARK", null);
            EnemyPokemon2 = new pokemonattempt("Calyrex", 100, 80, 80, 80, 80, 80, "PSYCHIC", "GRASS");
            EnemyPokemon3 = new pokemonattempt("Pangoro", 95, 124, 78, 69, 71, 58, "FIGHTING", "DARK");
        }


        // Venusaur movepool
        moveattempt VineWhip = new moveattempt("Vine Whip", 45, 100, 25, "GRASS", 0);
        moveattempt SolarBeam = new moveattempt("Solar Beam", 120, 100, 10, "GRASS", 1);
        moveattempt TakeDown = new moveattempt("Take Down", 90, 85, 20, "NORMAL", 0);
        moveattempt RazorLeaf = new moveattempt("Razor Leaf", 55, 95, 25, "GRASS", 0);

// Charizard movepool
        moveattempt Ember = new moveattempt("Ember", 40, 100, 25, "FIRE", 1);
        moveattempt FlameThrower = new moveattempt("Flamethrower", 90, 100, 15, "FIRE", 1);
        moveattempt DragonBreath = new moveattempt("Dragon Breath", 60, 100, 20, "DRAGON", 1);
        moveattempt AirSlash = new moveattempt("Air Slash", 75, 100, 15, "FLYING", 1);

// Blastoise movepool
        moveattempt HydroPump = new moveattempt("Hydro Pump", 110, 80, 5, "WATER", 1);
        moveattempt DragonTail = new moveattempt("Dragon Tail", 60, 90, 10, "DRAGON", 0);
        moveattempt HeadButt = new moveattempt("HeadButt", 70, 100, 15, "NORMAL", 0);
        moveattempt FocusPunch = new moveattempt("Focus Punch", 150, 100, 20, "FIGHTING", 0);

// Golem movepool
        moveattempt RockThrow = new moveattempt("Rock Throw", 50, 90, 15, "ROCK", 0);
        moveattempt BullDoze = new moveattempt("Bulldoze", 50, 90, 15, "GROUND", 0);
        moveattempt IronHead = new moveattempt("Iron Head", 80, 100, 15, "STEEL", 0);
        moveattempt HighHorsepower = new moveattempt("High Horsepower", 95, 95, 10, "GROUND", 0);

// Gengar movepool
        moveattempt ShadowBall = new moveattempt("Shadow Ball", 80, 100, 15, "GHOST", 1);
        moveattempt DarkPulse = new moveattempt("Dark Pulse", 80, 100, 15, "DARK", 1);
        moveattempt Earthquake = new moveattempt("Earthquake", 100, 100, 10, "GROUND", 0);
        moveattempt IceBeam = new moveattempt("Ice Beam", 90, 100, 10, "ICE", 1);

// Vaporeon movepool
        moveattempt Waterfall = new moveattempt("Waterfall", 80, 100, 15, "WATER", 0);
        // moveattempt IceBeam = new moveattempt("Ice Beam", 90, 100, 10, "ICE", 1);
        moveattempt Liquidation = new moveattempt("Liquidation", 85, 100, 10, "WATER", 0);
        moveattempt Blizzard = new moveattempt("Blizzard", 110, 70, 5, "ICE", 1);

// Pikachu Moves
        moveattempt ThunderShock = new moveattempt("Thunder Shock", 40, 100, 30, "ELECTRIC", 1);
        moveattempt QuickAttack = new moveattempt("Quick Attack", 40, 100, 30, "NORMAL", 0);
        moveattempt Thunderbolt = new moveattempt("Thunderbolt", 90, 100, 15, "ELECTRIC", 1);
        moveattempt IronTail = new moveattempt("Iron Tail", 100, 75, 10, "STEEL", 0);

// Galarian Meowth Moves
        moveattempt Scratch = new moveattempt("Scratch", 40, 100, 35, "NORMAL", 0);
        moveattempt Bite = new moveattempt("Bite", 60, 100, 25, "DARK", 0);
        moveattempt SteelClaw = new moveattempt("Steel Claw", 70, 90, 20, "STEEL", 0);
        moveattempt FakeOut = new moveattempt("Fake Out", 40, 100, 30, "NORMAL", 0);

// Moltres Moves
        moveattempt Hurricane = new moveattempt("Hurricane", 110, 70, 10, "FLYING", 1);

// Zekrom Moves
        moveattempt ThunderFang = new moveattempt("Thunder Fang", 65, 95, 20, "ELECTRIC", 0);
        moveattempt DracoMeteor = new moveattempt("Draco Meteor", 130, 75, 5, "DRAGON", 1);
        moveattempt FusionBolt = new moveattempt("Fusion Bolt", 100, 100, 10, "ELECTRIC", 0);

// Slaking Moves
        moveattempt HammerArm = new moveattempt("Hammer Arm", 100, 90, 10, "FIGHTING", 0);
        moveattempt HyperBeam = new moveattempt("Hyper Beam", 150, 90, 5, "NORMAL", 1);
        moveattempt SlackOff = new moveattempt("Slack Off", 0, 100, 10, "NORMAL", 0);

// Mightyena Moves
        moveattempt Crunch = new moveattempt("Crunch", 80, 100, 15, "DARK", 0);
        // moveattempt ThunderFang = new moveattempt("Thunder Fang", 65, 95, 15, "NORMAL", 0);
        moveattempt SuckerPunch = new moveattempt("Sucker Punch", 70, 100, 5, "DARK", 0);

// Gardevoir Moves
        moveattempt Confusion = new moveattempt("Confusion", 50, 100, 25, "PSYCHIC", 1);
        moveattempt Psychic = new moveattempt("Psychic", 90, 100, 10, "PSYCHIC", 1);
        moveattempt Moonblast = new moveattempt("Moonblast", 95, 100, 15, "FAIRY", 1);

// Pangoro Moves
        moveattempt KarateChop = new moveattempt("Karate Chop", 50, 100, 25, "FIGHTING", 0);
        moveattempt CircleThrow = new moveattempt("Circle Throw", 60, 90, 20, "FIGHTING", 0);
        moveattempt SkyUppercut = new moveattempt("Sky Uppercut", 85, 90, 10, "FIGHTING", 0);

// Meowstic Moves
        moveattempt Psybeam = new moveattempt("Psybeam", 65, 100, 20, "PSYCHIC", 1);
        moveattempt SignalBeam = new moveattempt("Signal Beam", 75, 100, 15, "BUG", 1);
        moveattempt ThunderWave = new moveattempt("Thunder Wave", 0, 90, 20, "ELECTRIC", 1);

// Aegislash Moves
        // moveattempt IronHead = new moveattempt("Iron Head", 80, 100, 15, "STEEL", 0);
        moveattempt SacredSword = new moveattempt("Sacred Sword", 90, 100, 10, "FIGHTING", 0);
        moveattempt ShadowSneak = new moveattempt("Shadow Sneak", 40, 100, 30, "GHOST", 1);
        moveattempt KingShield = new moveattempt("King's Shield", 0, 100, 10, "STEEL", 0);

// Avalugg Moves
        moveattempt IceFang = new moveattempt("Ice Fang", 65, 95, 20, "ICE", 0);
        moveattempt Avalanche = new moveattempt("Avalanche", 60, 100, 15, "ICE", 1);
        moveattempt Recover = new moveattempt("Recover", 0, 100, 10, "NORMAL", 0);

// Calyrex Moves
        moveattempt LeafBlade = new moveattempt("Leaf Blade", 90, 100, 15, "GRASS", 0);
        moveattempt GigaDrain = new moveattempt("Giga Drain", 75, 100, 10, "GRASS", 1);

// Grafaiai Moves
        moveattempt PoisonSting = new moveattempt("Poison Sting", 15, 100, 35, "POISON", 0);
        moveattempt Venoshock = new moveattempt("Venoshock", 65, 100, 20, "POISON", 1);
        moveattempt SludgeWave = new moveattempt("Sludge Wave", 95, 100, 10, "POISON", 1);

// Cramorant Moves
        moveattempt Peck = new moveattempt("Peck", 35, 100, 35, "FLYING", 0);
        moveattempt Dive = new moveattempt("Dive", 80, 100, 15, "WATER", 1);

// Minior Moves
        moveattempt Tackle = new moveattempt("Tackle", 40, 100, 35, "NORMAL", 0);
        moveattempt CosmicPower = new moveattempt("Cosmic Power", 0, 100, 20, "PSYCHIC", 1);
        moveattempt PowerGem = new moveattempt("Power Gem", 80, 100, 15, "ROCK", 1);
        moveattempt Explosion = new moveattempt("Explosion", 250, 100, 5, "NORMAL", 1);

        if (team == 0) { // Instinct: Pikachu, Venusaur, Aegislash
            PlayerPokemon1.setMove(0, ThunderShock);
            PlayerPokemon1.setMove(1, QuickAttack);
            PlayerPokemon1.setMove(2, Thunderbolt);
            PlayerPokemon1.setMove(3, IronTail);

            PlayerPokemon2.setMove(0, GigaDrain);
            PlayerPokemon2.setMove(1, SolarBeam);
            PlayerPokemon2.setMove(2, TakeDown);
            PlayerPokemon2.setMove(3, RazorLeaf);

            PlayerPokemon3.setMove(0, IronHead);
            PlayerPokemon3.setMove(1, SacredSword);
            PlayerPokemon3.setMove(2, ShadowSneak);
            PlayerPokemon3.setMove(3, KingShield);
        }

        else if (team == 1) { // Mystic: Blastoise, Minior, Gardevoir
            PlayerPokemon1.setMove(0, HydroPump);
            PlayerPokemon1.setMove(1, DragonTail);
            PlayerPokemon1.setMove(2, HeadButt);
            PlayerPokemon1.setMove(3, FocusPunch);

            PlayerPokemon2.setMove(0, Tackle);
            PlayerPokemon2.setMove(1, CosmicPower);
            PlayerPokemon2.setMove(2, PowerGem);
            PlayerPokemon2.setMove(3, Explosion);

            PlayerPokemon3.setMove(0, Confusion);
            PlayerPokemon3.setMove(1, Psychic);
            PlayerPokemon3.setMove(2, Moonblast);
            PlayerPokemon3.setMove(3, Thunderbolt);
        }

        else if (team == 2) { // Valor: Charizard, Cramorant, Avalugg
            PlayerPokemon1.setMove(0, Ember);
            PlayerPokemon1.setMove(1, FlameThrower);
            PlayerPokemon1.setMove(2, DragonBreath);
            PlayerPokemon1.setMove(3, AirSlash);

            PlayerPokemon2.setMove(0, Peck);
            PlayerPokemon2.setMove(1, Dive);
            PlayerPokemon2.setMove(2, AirSlash);
            PlayerPokemon2.setMove(3, Hurricane);

            PlayerPokemon3.setMove(0, IceFang);
            PlayerPokemon3.setMove(1, Avalanche);
            PlayerPokemon3.setMove(2, Earthquake);
            PlayerPokemon3.setMove(3, Recover);
        }

        else if (team == 3) { // Mystic: Golem, Gengar, Vaporeon
            EnemyPokemon1.setMove(0, RockThrow);
            EnemyPokemon1.setMove(1, BullDoze);
            EnemyPokemon1.setMove(2, IronHead);
            EnemyPokemon1.setMove(3, HighHorsepower);

            EnemyPokemon2.setMove(0, ShadowBall);
            EnemyPokemon2.setMove(1, DarkPulse);
            EnemyPokemon2.setMove(2, Earthquake);
            EnemyPokemon2.setMove(3, IceBeam);

            EnemyPokemon3.setMove(0, Waterfall);
            EnemyPokemon3.setMove(1, IceBeam);
            EnemyPokemon3.setMove(2, Liquidation);
            EnemyPokemon3.setMove(3, Blizzard);
        }

        else if (team == 4) { // Enemy 2: Galarian Meowth, Slaking, (Galarian) Moltres
            EnemyPokemon1.setMove(0, Scratch);
            EnemyPokemon1.setMove(1, Bite);
            EnemyPokemon1.setMove(2, SteelClaw);
            EnemyPokemon1.setMove(3, FakeOut);

            EnemyPokemon2.setMove(0, Scratch);
            EnemyPokemon2.setMove(1, HammerArm);
            EnemyPokemon2.setMove(2, HyperBeam);
            EnemyPokemon2.setMove(3, SlackOff);

            EnemyPokemon3.setMove(0, Ember);
            EnemyPokemon3.setMove(1, FlameThrower);
            EnemyPokemon3.setMove(2, DarkPulse);
            EnemyPokemon3.setMove(3, Hurricane);
        }

        else if (team == 5) { // Enemy 3: Mightyena, Pangoro, Calyrex
            EnemyPokemon1.setMove(0, Bite);
            EnemyPokemon1.setMove(1, Crunch);
            EnemyPokemon1.setMove(2, ThunderFang);
            EnemyPokemon1.setMove(3, SuckerPunch);

            EnemyPokemon2.setMove(0, KarateChop);
            EnemyPokemon2.setMove(1, CircleThrow);
            EnemyPokemon2.setMove(2, Crunch);
            EnemyPokemon2.setMove(3, SkyUppercut);

            EnemyPokemon3.setMove(0, Psychic);
            EnemyPokemon3.setMove(1, IceBeam);
            EnemyPokemon3.setMove(2, LeafBlade);
            EnemyPokemon3.setMove(3, GigaDrain);
        }

        if (team == 0 || team == 1 || team == 2 ) /*player*/{
            Moves[] PlayerPokemon1Moves = PlayerPokemon1.getMoves();
            Moves[] PlayerPokemon2Moves = PlayerPokemon2.getMoves();
            Moves[] PlayerPokemon3Moves = PlayerPokemon3.getMoves();
        }

        else {
            Moves[] EnemyPokemon1Moves = EnemyPokemon1.getMoves();
            Moves[] EnemyPokemon2Moves = EnemyPokemon2.getMoves();
            Moves[] EnemyPokemon3Moves = EnemyPokemon3.getMoves();
        }
    }

    void displaypokemonstatus(int team){
        if(team == 0 || team == 1 || team == 2){
            Moves[] PlayerPokemon1Moves = PlayerPokemon1.getMoves();
            Moves[] PlayerPokemon2Moves = PlayerPokemon2.getMoves();
            Moves[] PlayerPokemon3Moves = PlayerPokemon3.getMoves();

            System.out.println(""" 
                            ⊝══════════════════⊝
                            ║   POKEMON LIST   ║
                            ⊝══════════════════⊝""");

            System.out.println();

            System.out.println("⊝══════════════════════════════════════════════════════⊝");
            System.out.println(" POKEMON 1: "+ PlayerPokemon1.getName() + " (HP: " + PlayerPokemon1.currenthp + "/" + PlayerPokemon1.maxhp + ")" + " TYPE: " + PlayerPokemon1.getType());
            if(PlayerPokemon1.getType2() != null)
                System.out.print(", " + PlayerPokemon1.getType2());
            System.out.println("⊝══════════════════════════════════════════════════════⊝" );

            System.out.println(""" 
                            ⊝══════════════════════════════════════════════════════⊝
                            ║                        MOVES:                        ║""");
            System.out.println("⊝══════════════════════════════════════════════════════⊝" );
            for (int i = 0; i < PlayerPokemon1Moves.length; i++) {
                Moves move = PlayerPokemon1Moves[i];
                System.out.println("⊝═══");for(int chrctr = 0; chrctr <= move.getName().length(); chrctr++){System.out.print("═");} System.out.print("═══⊝");
                System.out.println("║   " + move.getName().toUpperCase() + "   ║");
                System.out.println("⊝═══");for(int chrctr = 0; chrctr <= move.getName().length(); chrctr++){System.out.print("═");} System.out.print("═══⊝");
                System.out.println("POWER: " + move.getPower() + " ║ ACCURACY: " + move.getAccuracy() + " ║ PP: " + move.getPP() + " ║ TYPE: " + move.getMovetype());
            }
            System.out.println("⊝══════════════════════════════════════════════════════⊝" );

            System.out.println();

            System.out.println("⊝══════════════════════════════════════════════════════⊝");
            System.out.println(" POKEMON 2: " + PlayerPokemon2.getName() + " (HP: " + PlayerPokemon2.currenthp + "/" + PlayerPokemon2.maxhp + ")" + " TYPE: " + PlayerPokemon2.getType());
            if(PlayerPokemon2.getType2() != null)
                System.out.print(", " + PlayerPokemon1.getType2());
            System.out.println("⊝══════════════════════════════════════════════════════⊝");

            System.out.println(""" 
                            ⊝══════════════════════════════════════════════════════⊝
                            ║                        MOVES:                        ║""");
            System.out.println("⊝══════════════════════════════════════════════════════⊝" );
            for (int i = 0; i < PlayerPokemon2Moves.length; i++) {
                Moves move = PlayerPokemon2Moves[i];
                System.out.println("⊝═══");for(int chrctr = 0; chrctr <= move.getName().length(); chrctr++){System.out.print("═");} System.out.print("═══⊝");
                System.out.println("║   " + move.getName().toUpperCase() + "   ║");
                System.out.println("⊝═══");for(int chrctr = 0; chrctr <= move.getName().length(); chrctr++){System.out.print("═");} System.out.print("═══⊝");
                System.out.println("POWER: " + move.getPower() + " ║ ACCURACY: " + move.getAccuracy() + " ║ PP: " + move.getPP() + " ║ TYPE: " + move.getMovetype());
            }
            System.out.println("⊝══════════════════════════════════════════════════════⊝" );

            System.out.println();

            System.out.println("⊝══════════════════════════════════════════════════════⊝");
            System.out.println("Pokemon 3: " + PlayerPokemon3.getName() + " (HP: " + PlayerPokemon3.currenthp + "/" + PlayerPokemon3.maxhp + ")" + " Type: " + PlayerPokemon3.getType());
            if(PlayerPokemon3.getType2() != null)
                System.out.print(", " + PlayerPokemon3.getType2());
            System.out.println("⊝══════════════════════════════════════════════════════⊝");

            System.out.println(""" 
                            ⊝══════════════════════════════════════════════════════⊝
                            ║                        MOVES:                        ║""");
            System.out.println("⊝══════════════════════════════════════════════════════⊝" );
            for (int i = 0; i < PlayerPokemon3Moves.length; i++) {
                Moves move = PlayerPokemon3Moves[i];
                System.out.println("⊝═══");for(int chrctr = 0; chrctr <= move.getName().length(); chrctr++){System.out.print("═");} System.out.print("═══⊝");
                System.out.println("║   " + move.getName().toUpperCase() + "   ║");
                System.out.println("⊝═══");for(int chrctr = 0; chrctr <= move.getName().length(); chrctr++){System.out.print("═");} System.out.print("═══⊝");
                System.out.println("POWER: " + move.getPower() + " ║ ACCURACY: " + move.getAccuracy() + " ║ PP: " + move.getPP() + " ║ TYPE: " + move.getMovetype());
            }
            System.out.println("⊝══════════════════════════════════════════════════════⊝" );
        }
        else if (team == 3 || team == 4 || team == 5){
            Moves[] PlayerPokemon1Moves = EnemyPokemon1.getMoves();
            Moves[] PlayerPokemon2Moves = EnemyPokemon2.getMoves();
            Moves[] PlayerPokemon3Moves = EnemyPokemon3.getMoves();

            System.out.println(""" 
                            ⊝════════════════════════⊝
                            ║   ENEMY POKEMON LIST   ║
                            ⊝════════════════════════⊝""");

            System.out.println();

            System.out.println("⊝══════════════");for(int chrctr = 0; chrctr <= EnemyPokemon1.getName().length(); chrctr++){System.out.print("═");} System.out.print("═══⊝");
            System.out.println("║   POKEMON 1: " + EnemyPokemon1.getName().toUpperCase() + "   ║");
            System.out.println("⊝══════════════");for(int chrctr = 0; chrctr <= EnemyPokemon1.getName().length(); chrctr++){System.out.print("═");} System.out.print("═══⊝");

            System.out.println();

            System.out.println(""" 
                            ⊝══════════════════════════════════════════════════════⊝
                            ║                        MOVES:                        ║""");
            System.out.println("⊝══════════════════════════════════════════════════════⊝" );
            for (int i = 0; i < PlayerPokemon1Moves.length; i++) {
                Moves move = PlayerPokemon1Moves[i];
                System.out.println("⊝═══");for(int chrctr = 0; chrctr <= move.getName().length(); chrctr++){System.out.print("═");} System.out.print("═══⊝");
                System.out.println("║   " + move.getName().toUpperCase() + "   ║");
                System.out.println("⊝═══");for(int chrctr = 0; chrctr <= move.getName().length(); chrctr++){System.out.print("═");} System.out.print("═══⊝");
                System.out.println("POWER: " + move.getPower() + " ║ ACCURACY: " + move.getAccuracy() + " ║ PP: " + move.getPP() + " ║ TYPE: " + move.getMovetype());
            }
            System.out.println("⊝══════════════════════════════════════════════════════⊝" );

            System.out.println();

            System.out.println("⊝══════════════");for(int chrctr = 0; chrctr <= EnemyPokemon2.getName().length(); chrctr++){System.out.print("═");} System.out.print("═══⊝");
            System.out.println("║   POKEMON 2: " + EnemyPokemon2.getName().toUpperCase() + "   ║");
            System.out.println("⊝══════════════");for(int chrctr = 0; chrctr <= EnemyPokemon2.getName().length(); chrctr++){System.out.print("═");} System.out.print("═══⊝");

            System.out.println();

            System.out.println(""" 
                            ⊝══════════════════════════════════════════════════════⊝
                            ║                        MOVES:                        ║""");
            System.out.println("⊝══════════════════════════════════════════════════════⊝" );
            for (int i = 0; i < PlayerPokemon2Moves.length; i++) {
                Moves move = PlayerPokemon2Moves[i];
                System.out.println("⊝═══");for(int chrctr = 0; chrctr <= move.getName().length(); chrctr++){System.out.print("═");} System.out.print("═══⊝");
                System.out.println("║   " + move.getName().toUpperCase() + "   ║");
                System.out.println("⊝═══");for(int chrctr = 0; chrctr <= move.getName().length(); chrctr++){System.out.print("═");} System.out.print("═══⊝");
                System.out.println("POWER: " + move.getPower() + " ║ ACCURACY: " + move.getAccuracy() + " ║ PP: " + move.getPP() + " ║ TYPE: " + move.getMovetype());
            }
            System.out.println("⊝══════════════════════════════════════════════════════⊝" );

            System.out.println();

            System.out.println("⊝══════════════");for(int chrctr = 0; chrctr <= EnemyPokemon3.getName().length(); chrctr++){System.out.print("═");} System.out.print("═══⊝");
            System.out.println("║   POKEMON 3: " + EnemyPokemon3.getName().toUpperCase() + "   ║");
            System.out.println("⊝══════════════");for(int chrctr = 0; chrctr <= EnemyPokemon3.getName().length(); chrctr++){System.out.print("═");} System.out.print("═══⊝");

            System.out.println(""" 
                            ⊝══════════════════════════════════════════════════════⊝
                            ║                        MOVES:                        ║""");
            System.out.println("⊝══════════════════════════════════════════════════════⊝" );
            for (int i = 0; i < PlayerPokemon3Moves.length; i++) {
                Moves move = PlayerPokemon3Moves[i];
                System.out.println("⊝═══");for(int chrctr = 0; chrctr <= move.getName().length(); chrctr++){System.out.print("═");} System.out.print("═══⊝");
                System.out.println("║   " + move.getName().toUpperCase() + "   ║");
                System.out.println("⊝═══");for(int chrctr = 0; chrctr <= move.getName().length(); chrctr++){System.out.print("═");} System.out.print("═══⊝");
                System.out.println("POWER: " + move.getPower() + " ║ ACCURACY: " + move.getAccuracy() + " ║ PP: " + move.getPP() + " ║ TYPE: " + move.getMovetype());
            }
            System.out.println("⊝══════════════════════════════════════════════════════⊝" );
        }
    }

    boolean combatui(String z, int fightcounter, int enemyTeamFile){

        String difficulty = z;
        boolean endfight = false;
        int slakingcounter = 0;
        boolean debufftrigger = false;
        boolean playerdebufftrigger = false;
        turncounter = 0;

        if(z.equalsIgnoreCase("H"))
            EnemyPokemon1.currentspeed += 5;

        do {
            turncounter++;
            String movechoice = "";
            boolean poke1moved = false;
            boolean poke2moved = false;
            boolean playerchoice = true;
            boolean turnover = false;

            Scanner input = new Scanner(System.in);
            if(EnemyPokemon1.getName().equals("Slaking"))
                slakingcounter++;
            else
                slakingcounter = 0;

            if(slakingcounter%2 == 0 && slakingcounter!=0){
                System.out.println("Slaking is too lazy to move!");
                poke2moved = true;
            }

            Moves[] PlayerPokemon1Moves = PlayerPokemon1.getMoves(); // always the active pokemon
            Moves[] PlayerPokemon2Moves = PlayerPokemon2.getMoves();
            Moves[] PlayerPokemon3Moves = PlayerPokemon3.getMoves();

            Moves[] EnemyPokemon1Moves = EnemyPokemon1.getMoves(); // always the active pokemon
            Moves[] EnemyPokemon2Moves = EnemyPokemon2.getMoves();
            Moves[] EnemyPokemon3Moves = EnemyPokemon3.getMoves();

            System.out.println();
            System.out.println("Turn " + turncounter);
            System.out.print(EnemyPokemon1.getName() + " (HP: " + EnemyPokemon1.currenthp + "/" + EnemyPokemon1.maxhp + ")" + " Type: " + EnemyPokemon1.getType());
            if(EnemyPokemon1.getType2() != null)
                System.out.print(", " + EnemyPokemon1.getType2());

            System.out.print("\n" + PlayerPokemon1.getName() + " (HP: " + PlayerPokemon1.currenthp + "/" + PlayerPokemon1.maxhp + ")" + " Type: " + PlayerPokemon1.getType());
            if(PlayerPokemon1.getType2() != null)
                System.out.print(", " + PlayerPokemon1.getType2());

            while (playerchoice) {
                System.out.println();
                System.out.println("""
                ⊝════════════════════════════════════════════⊝
                ║ [P] POKEMON - CHECK/SWITCH CURRENT POKEMON ║
                ║ [F] FIGHT - FIGHT WITH CURRENT POKEMON     ║
                ║ [B] BAG - USE ITEMS                        ║
                ║ [R] RUN - SAVE PROGRESS                    ║
                ⊝════════════════════════════════════════════⊝
                ║         WHAT WOULD YOU LIKE TO DO?         ║
                ⊝════════════════════════════════════════════⊝""");

                String actionchoice = input.nextLine();

                switch (actionchoice) {
                    case "P":
                    case "p":{
                        boolean switchcheck = true;

                        while (switchcheck) {

                            System.out.print("⊝═════════════");
                            for(int chrctr = 0; chrctr <= PlayerPokemon1.getName().length(); chrctr++){System.out.print("═");}
                            System.out.println("══════════⊝");
                            System.out.print("║   " + PlayerPokemon1.getName().toUpperCase() + " - CURRENT POKEMON");
                            for(int chrctr = 0; chrctr <= (23 + PlayerPokemon1.getName().length()) - (21 + PlayerPokemon1.getName().length()) ; chrctr++){System.out.print(" ");}
                            System.out.println("║");
                            if (PlayerPokemon2.currenthp > 0) {
                                System.out.print("║   " + PlayerPokemon2.getName().toUpperCase());
                                for (int chrctr = 0; chrctr <= (23 + PlayerPokemon1.getName().length()) - (3 + PlayerPokemon2.getName().length()); chrctr++) {
                                    System.out.print(" ");
                                }
                                System.out.println("║");
                            }
                            if (PlayerPokemon3.currenthp > 0) {
                                System.out.print("║   " + PlayerPokemon3.getName().toUpperCase());
                                for(int chrctr = 0; chrctr <= (23 + PlayerPokemon1.getName().length()) - (3 + PlayerPokemon3.getName().length()) ; chrctr++){System.out.print(" ");}
                                System.out.println("║");
                            }
                            System.out.print("⊝═════════════");
                            for(int chrctr = 0; chrctr <= PlayerPokemon1.getName().length(); chrctr++){System.out.print("═");}
                            System.out.println("══════════⊝");

                            System.out.println("""
                                                ⊝════════════════════════════════════════════════⊝
                                                ║   WHICH POKEMON WOULD YOU LIKE TO SWITCH IN?   ║
                                                ⊝════════════════════════════════════════════════⊝
                                                ║   [B] BACK                                     ║
                                                ⊝════════════════════════════════════════════════⊝""");

                            Scanner switchinput = new Scanner(System.in);

                            String pokemonswitch = switchinput.next().toLowerCase();

                            if (PlayerPokemon2.getName().toLowerCase().equals(pokemonswitch)) {
                                PlayerPokemon1Moves = PlayerPokemon2.getMoves();
                                switchpokemon(PlayerPokemon2, PlayerPokemon1);
                                poke1moved = true;
                                switchcheck = false;
                            } else if (PlayerPokemon3.getName().toLowerCase().equals(pokemonswitch)) {
                                PlayerPokemon1Moves = PlayerPokemon3.getMoves();
                                switchpokemon(PlayerPokemon3, PlayerPokemon1);
                                poke1moved = true;
                                switchcheck = false;
                            } else if(pokemonswitch.equalsIgnoreCase("b")){
                                poke1moved = false;
                                switchcheck = false;
                            } else {
                                System.out.println(""" 
                                                    ⊝═══════════════════⊝
                                                    ║   INVALID INPUT   ║
                                                    ⊝═══════════════════⊝""");
                                // Add any additional handling for invalid input if needed
                                // You might want to continue the loop or take other actions.
                            }
                        }
                        break;
                    }

                    case "F":
                    case "f": {
                        System.out.println();
                        System.out.println(""" 
                            ⊝══════════════════════⊝
                            ║   DISPLAYING MOVES   ║
                            ⊝══════════════════════⊝""");
                        for (int i = 0; i < PlayerPokemon1Moves.length; i++) {
                            Moves move = PlayerPokemon1Moves[i];
                            System.out.print("⊝════════════");for(int chrctr = 0; chrctr <= move.getName().length(); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                            System.out.println("║   ["+ (i + 1) +"] NAME: " + move.getName().toUpperCase() + "   ║");
                            System.out.print("║   TYPE: " + move.getMovetype().toUpperCase()); for(int chrctr = 0; chrctr <= (15 + move.getName().length()) - (9 + move.getMovetype().length()) ; chrctr++){System.out.print(" ");} System.out.println("║");
                            System.out.print("║   POWER: " + move.getPower());
                            if (move.getPower() > 99){
                                for(int chrctr = 0; chrctr <= (15 + move.getName().length()) - (13) ; chrctr++){System.out.print(" ");}
                                System.out.println("║");
                            }
                            else if(move.getPower() > 9){
                                for(int chrctr = 0; chrctr <= (15 + move.getName().length()) - (12) ; chrctr++){System.out.print(" ");}
                                System.out.println("║");
                            }
                            else {
                                for(int chrctr = 0; chrctr <= (15 + move.getName().length()) - (11) ; chrctr++){System.out.print(" ");}
                                System.out.println("║");
                            }

                            System.out.print("║   ACCURACY: " + move.getAccuracy());
                            if (move.getAccuracy() > 99){
                                for(int chrctr = 0; chrctr <= (15 + move.getName().length()) - (16) ; chrctr++){System.out.print(" ");}
                                System.out.println("║");
                            }
                            else if(move.getAccuracy() > 9){
                                for(int chrctr = 0; chrctr <= (15 + move.getName().length()) - (15) ; chrctr++){System.out.print(" ");}
                                System.out.println("║");
                            }
                            else {
                                for(int chrctr = 0; chrctr <= (15 + move.getName().length()) - (14) ; chrctr++){System.out.print(" ");}
                                System.out.println("║");
                            }

                            System.out.print("║   PP: " + move.currentpp);
                            if (move.currentpp > 99){
                                for(int chrctr = 0; chrctr <= (15 + move.getName().length()) - (10) ; chrctr++){System.out.print(" ");}
                                System.out.println("║");
                            }
                            else if(move.currentpp > 9){
                                for(int chrctr = 0; chrctr <= (15 + move.getName().length()) - (9) ; chrctr++){System.out.print(" ");}
                                System.out.println("║");
                            }
                            else{
                                for(int chrctr = 0; chrctr <= (15 + move.getName().length()) - (8) ; chrctr++){System.out.print(" ");}
                                System.out.println("║");
                            }
                            System.out.print("⊝════════════");for(int chrctr = 0; chrctr <= move.getName().length(); chrctr++){System.out.print("═");}System.out.println("═══⊝");
                        }
                        System.out.println(""" 
                            ⊝════════════════════════════════⊝
                            ║   [1] MOVE 1                   ║
                            ║   [2] MOVE 2                   ║
                            ║   [3] MOVE 3                   ║
                            ║   [4] MOVE 4                   ║
                            ║   [B] BACK                     ║
                            ⊝════════════════════════════════⊝
                            ║   WHAT WOULD YOU LIKE TO DO?   ║
                            ⊝════════════════════════════════⊝""");
                        movechoice = input.nextLine();
                        switch (movechoice.toLowerCase()) {
                            case "b":{

                                playerchoice = true;
                                break;
                            }

                            case "1":
                            case "2":
                            case "3":
                            case "4":
                                System.out.println();
                                playerchoice = false;
                                break;

                            default: {
                                System.out.println(""" 
                            ⊝═══════════════════⊝
                            ║   INVALID INPUT   ║
                            ⊝═══════════════════⊝""");
                                break;
                            }
                        }
                        break;
                    }
                    case "R":
                    case "r": {
                        System.out.println(""" 
                            ⊝════════════════════════════════════════════════⊝
                            ║   WARNING: ALL UNSAVED PROGRESS WILL BE LOST   ║
                            ⊝════════════════════════════════════════════════⊝
                            ║         WOULD YOU LIKE TO SAVE? [Y/N]          ║
                            ⊝════════════════════════════════════════════════⊝""");
                        String saveprogress = input.nextLine().toUpperCase();
                        if(saveprogress.equals("Y")) {
                            FileHandling.initializeWriter();
                            Pokemon_Main main = new Pokemon_Main();
                            String name = Pokemon_Main.getPlayerName();
                            int team = Pokemon_Main.getTeamnumber();
                            file.setDifficultyfile(Pokemon_Main.getDifficulty());
                            file.setNamefile(name);
                            file.setPlayteamfile(String.valueOf(team));
                            file.setEnemyteamfile(enemyTeamFile);
                            file.savetofile();
                            FileHandling.closeWriter();
                            System.exit(0);
                            return false;
                        }
                        break;
                    }
                    case "B":
                    case "b": {
                        System.out.println("""
                            ⊝═══════════════════════════════════════════════════════⊝
                            ║   USING ITEMS IS PROHIBITED DURING COLOSSEUM FIGHTS!  ║
                            ⊝═══════════════════════════════════════════════════════⊝""");
                        break;
                    }
                    default: {
                        System.out.println(""" 
                            ⊝═══════════════════⊝
                            ║   INVALID INPUT   ║
                            ⊝═══════════════════⊝""");
                    }
                }
            }

            while (!turnover) {
                if ((PlayerPokemon1.currentspeed > EnemyPokemon1.currentspeed || poke2moved) && !poke1moved) {
                    int movepick = Integer.parseInt(movechoice);

                    if(playerparalyzed){
                        if(rngcheck(50)){
                            System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (PlayerPokemon1.getName().length() + 30); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                            System.out.println("║   " + PlayerPokemon1.getName().toUpperCase() + " BROKE FREE FROM ITS PARALYSIS!   ║");
                            System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (PlayerPokemon1.getName().length() + 30); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                            playerparalyzed = false;
                            break;
                        }

                        if(rngcheck(25))
                        {
                            poke1moved = true;
                            System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (PlayerPokemon1.getName().length() + 33); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                            System.out.println("║   " + PlayerPokemon1.getName().toUpperCase() + " CANNOT MOVE DUE TO ITS PARALYSIS!   ║");
                            System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (PlayerPokemon1.getName().length() + 33); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                        }
                    }

                    if(playerpoison){
                        if(rngcheck(50)){
                            System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (PlayerPokemon1.getName().length() + 25); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                            System.out.println("║   " + PlayerPokemon1.getName().toUpperCase() + " CURED ITSELF FROM POISON!   ║");
                            System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (PlayerPokemon1.getName().length() + 25); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                            playerpoison = false;
                            break;
                        }

                        if (PlayerPokemon1.maxhp/16 > 99){
                            System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (PlayerPokemon1.getName().length() + 42); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                        }
                        else if (PlayerPokemon1.maxhp/16 > 9){
                            System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (PlayerPokemon1.getName().length() + 41); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                        }
                        else {
                            System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (PlayerPokemon1.getName().length() + 40); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                        }
                        System.out.println("║   " + PlayerPokemon1.getName().toUpperCase() + "'S POISON TAKES EFFECT, DEALING " + PlayerPokemon1.maxhp/16 + " DAMAGE!   ║");
                        PlayerPokemon1.currenthp -= PlayerPokemon1.maxhp/16;
                        if (PlayerPokemon1.maxhp/16 > 99){
                            System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (PlayerPokemon1.getName().length() + 42); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                        }
                        else if (PlayerPokemon1.maxhp/16 > 9){
                            System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (PlayerPokemon1.getName().length() + 41); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                        }
                        else {
                            System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (PlayerPokemon1.getName().length() + 40); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                        }

                        System.out.println("⊝═══════════════════════════════════⊝");
                        if(PlayerPokemon2.currenthp>0){
                            System.out.print("║   " + PlayerPokemon2.getName().toUpperCase()); for(int chrctr = 0; chrctr <= (34 - (PlayerPokemon2.getName().length() + 3)); chrctr++){System.out.print(" ");} System.out.println("║");
                        }
                        if(PlayerPokemon3.currenthp>0){
                            System.out.print("║   " + PlayerPokemon3.getName().toUpperCase()); for(int chrctr = 0; chrctr <= (34 - (PlayerPokemon3.getName().length() + 3)); chrctr++){System.out.print(" ");} System.out.println("║");
                        }
                        System.out.println("⊝═══════════════════════════════════⊝");

                        boolean switchcheck = true;

                        while (switchcheck) {
                            System.out.println(""" 
                            ⊝════════════════════════════════════════════════⊝
                            ║   WHICH POKEMON WOULD YOU LIKE TO SWITCH IN?   ║
                            ⊝════════════════════════════════════════════════⊝""");
                            String pokemonswitch = input.next().toLowerCase();
                            if (PlayerPokemon2.getName().toLowerCase().equals(pokemonswitch)) {
                                switchpokemon(PlayerPokemon2, PlayerPokemon1);
                                switchcheck = false;
                            } else if (PlayerPokemon3.getName().toLowerCase().equals(pokemonswitch)) {
                                switchpokemon(PlayerPokemon3, PlayerPokemon1);
                                switchcheck = false;
                            } else
                                System.out.println(""" 
                            ⊝═══════════════════⊝
                            ║   INVALID INPUT   ║
                            ⊝═══════════════════⊝""");
                        }

                        if(!debufftrigger) {
                            EnemyPokemon1.currentattack *= 0.5;
                            debufftrigger = true;
                        }
                    }

                    if(playerburn){
                        if(rngcheck(50)){
                            System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (PlayerPokemon1.getName().length() + 23); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                            System.out.println("║   " + PlayerPokemon1.getName().toUpperCase() + " CURED ITSELF FROM BURN!   ║");
                            System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (PlayerPokemon1.getName().length() + 23); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                            playerdebufftrigger = false;
                            playerburn = false;
                            break;
                        }

                        if (PlayerPokemon1.maxhp/16 > 99){
                            System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (PlayerPokemon1.getName().length() + 40); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                        }
                        else if (PlayerPokemon1.maxhp/16 > 9){
                            System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (PlayerPokemon1.getName().length() + 39); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                        }
                        else {
                            System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (PlayerPokemon1.getName().length() + 38); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                        }
                        System.out.println("║   " + PlayerPokemon1.getName().toUpperCase() + "'S BURN TAKES EFFECT, DEALING " + PlayerPokemon1.maxhp/16 + " DAMAGE!   ║");
                        PlayerPokemon1.currenthp -= PlayerPokemon1.maxhp/16;
                        if (PlayerPokemon1.maxhp/16 > 99){
                            System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (PlayerPokemon1.getName().length() + 40); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                        }
                        else if (PlayerPokemon1.maxhp/16 > 9){
                            System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (PlayerPokemon1.getName().length() + 39); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                        }
                        else {
                            System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (PlayerPokemon1.getName().length() + 38); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                        }
                        if(PlayerPokemon1.currenthp<0) {
                            System.out.println("⊝═══════════════════════════════════⊝");
                            if (PlayerPokemon2.currenthp > 0) {
                                System.out.print("║   " + PlayerPokemon2.getName().toUpperCase());
                                for (int chrctr = 0; chrctr <= (34 - (PlayerPokemon2.getName().length() + 3)); chrctr++) {
                                    System.out.print(" ");
                                }
                                System.out.println("║");
                            }
                            if (PlayerPokemon3.currenthp > 0) {
                                System.out.print("║   " + PlayerPokemon3.getName().toUpperCase());
                                for (int chrctr = 0; chrctr <= (34 - (PlayerPokemon3.getName().length() + 3)); chrctr++) {
                                    System.out.print(" ");
                                }
                                System.out.println("║");
                            }
                            System.out.println("⊝═══════════════════════════════════⊝");

                            boolean switchcheck = true;

                            while (switchcheck) {
                                System.out.println(""" 
                                        ⊝════════════════════════════════════════════════⊝
                                        ║   WHICH POKEMON WOULD YOU LIKE TO SWITCH IN?   ║
                                        ⊝════════════════════════════════════════════════⊝""");
                                String pokemonswitch = input.next().toLowerCase();
                                if (PlayerPokemon2.getName().toLowerCase().equals(pokemonswitch)) {
                                    switchpokemon(PlayerPokemon2, PlayerPokemon1);
                                    switchcheck = false;
                                } else if (PlayerPokemon3.getName().toLowerCase().equals(pokemonswitch)) {
                                    switchpokemon(PlayerPokemon3, PlayerPokemon1);
                                    switchcheck = false;
                                } else
                                    System.out.println(""" 
                                            ⊝═══════════════════⊝
                                            ║   INVALID INPUT   ║
                                            ⊝═══════════════════⊝""");
                            }
                        }

                        if(!playerdebufftrigger) {
                            EnemyPokemon1.currentattack *= 0.5;
                            playerdebufftrigger = true;
                        }
                    }

                    if(playerconfused){
                        if(rngcheck(50)){
                            System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (PlayerPokemon1.getName().length() + 25); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                            System.out.println("║   " + PlayerPokemon1.getName().toUpperCase() + " SNAPPED OUT OF CONFUSION!   ║");
                            System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (PlayerPokemon1.getName().length() + 25); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                            playerconfused = false;
                            break;
                        }
                        System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (PlayerPokemon1.getName().length() + 15); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                        System.out.println("║   " + PlayerPokemon1.getName().toUpperCase() + " IS CONFUSED...   ║");
                        System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (PlayerPokemon1.getName().length() + 15); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                        if(rngcheck(25))
                        {
                            poke1moved = true;

                            if (PlayerPokemon1.maxhp/16 > 99){
                                System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (PlayerPokemon1.getName().length() + 53); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                            }
                            else if (PlayerPokemon1.maxhp/16 > 9){
                                System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (PlayerPokemon1.getName().length() + 52); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                            }
                            else {
                                System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (PlayerPokemon1.getName().length() + 51); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                            }
                            System.out.println("║   " + PlayerPokemon1.getName().toUpperCase() + " HURT ITSELF IT ITS OWN CONFUSION, DEALING " + PlayerPokemon1.maxhp/16 + " DAMAGE!   ║");
                            PlayerPokemon1.currenthp -= PlayerPokemon1.maxhp/16;
                            if (PlayerPokemon1.maxhp/16 > 99){
                                System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (PlayerPokemon1.getName().length() + 53); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                            }
                            else if (PlayerPokemon1.maxhp/16 > 9){
                                System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (PlayerPokemon1.getName().length() + 52); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                            }
                            else {
                                System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (PlayerPokemon1.getName().length() + 51); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                            }

                            if (EnemyPokemon1.currenthp <= 0 &&  EnemyPokemon2.currenthp >= 0  && EnemyPokemon3.currenthp >= 0) {
                                switchpokemon(EnemyPokemon2, EnemyPokemon1);
                                poke2moved = true; break;
                            }
                            else if (EnemyPokemon1.currenthp <= 0 && EnemyPokemon2.currenthp <= 0 && EnemyPokemon3.currenthp >= 0) {
                                switchpokemon(EnemyPokemon3, EnemyPokemon1); poke2moved = true; break;}

                            else if (EnemyPokemon1.currenthp <= 0 && EnemyPokemon2.currenthp <= 0 && EnemyPokemon3.currenthp <= 0) {
                                endfight = true; break;
                            }
                        }
                    }

                    for (int i = 0; i < PlayerPokemon1Moves.length; i++) {
                        Moves move = PlayerPokemon1Moves[i];
                        if (i == (movepick - 1)){
                            System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (PlayerPokemon1.getName().length() + 6 + move.getName().length()); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                            System.out.println("║   " + PlayerPokemon1.getName().toUpperCase() + " USED " + move.getName().toUpperCase() + "!   ║");
                            System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (PlayerPokemon1.getName().length() + 6 + move.getName().length()); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                            System.out.println();
                            if(EnemyPokemon1.getType2() == null) {
                                playerdamagecalculation(move.getMovetype(), EnemyPokemon1.getType(), null, move.getPower(), move.getAccuracy(), move.attacktype());
                            }
                            else
                                playerdamagecalculation(move.getMovetype(), EnemyPokemon1.getType(), EnemyPokemon1.getType2(), move.getPower(), move.getAccuracy(), move.attacktype());
                            move.currentpp--;
                            if(move.getName().equals("Explosion"))
                            {
                                poke1moved = true;
                                PlayerPokemon1.currenthp = 0;
                                System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (PlayerPokemon1.getName().length() + 36); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                                System.out.println("║   " + PlayerPokemon1.getName().toUpperCase() + " IS KNOCKED OUT BY ITS OWN EXPLOSION!   ║");
                                System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (PlayerPokemon1.getName().length() + 36); chrctr++){System.out.print("═");} System.out.println("═══⊝");

                                System.out.println("⊝═══════════════════════════════════⊝");
                                if(PlayerPokemon2.currenthp>0){
                                    System.out.print("║   " + PlayerPokemon2.getName().toUpperCase()); for(int chrctr = 0; chrctr <= (34 - (PlayerPokemon2.getName().length() + 3)); chrctr++){System.out.print(" ");} System.out.println("║");
                                }
                                if(PlayerPokemon3.currenthp>0){
                                    System.out.print("║   " + PlayerPokemon3.getName().toUpperCase()); for(int chrctr = 0; chrctr <= (34 - (PlayerPokemon3.getName().length() + 3)); chrctr++){System.out.print(" ");} System.out.println("║");
                                }
                                System.out.println("⊝═══════════════════════════════════⊝");

                                boolean switchcheck = true;

                                while (switchcheck) {
                                    System.out.println(""" 
                            ⊝════════════════════════════════════════════════⊝
                            ║   WHICH POKEMON WOULD YOU LIKE TO SWITCH IN?   ║
                            ⊝════════════════════════════════════════════════⊝""");
                                    String pokemonswitch = input.next().toLowerCase();
                                    if (PlayerPokemon2.getName().toLowerCase().equals(pokemonswitch)) {
                                        switchpokemon(PlayerPokemon2, PlayerPokemon1);
                                        switchcheck = false;
                                    } else if (PlayerPokemon3.getName().toLowerCase().equals(pokemonswitch)) {
                                        switchpokemon(PlayerPokemon3, PlayerPokemon1);
                                        switchcheck = false;
                                    } else
                                        System.out.println(""" 
                            ⊝═══════════════════⊝
                            ║   INVALID INPUT   ║
                            ⊝═══════════════════⊝""");
                                }
                            }

                            if (move.getName().equals("Recover") || move.getName().equals("Slack Off")) {
                                PlayerPokemon1.currenthp = PlayerPokemon1.maxhp;
                                System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (PlayerPokemon1.getName().length() + 15); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                                System.out.println("║   " + PlayerPokemon1.getName().toUpperCase() + " HEALED TO FULL!   ║");
                                System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (PlayerPokemon1.getName().length() + 15); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                            }

                            if (move.getName().equals("Cosmic Power")) {
                                PlayerPokemon1.currentdefense *= 1.5;
                                PlayerPokemon1.currentspdefense *= 1.5;
                                System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (PlayerPokemon1.getName().length() + 19); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                                System.out.println("║   " + PlayerPokemon1.getName().toUpperCase() + " RAISED ITS DEFENSES!   ║");
                                System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (PlayerPokemon1.getName().length() + 19); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                            }

                            if (move.getName().equals("King Protect")) {
                                EnemyPokemon1.currentattack *= 0.25;
                                System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (PlayerPokemon1.getName().length() + 27); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                                System.out.println("║   " + PlayerPokemon1.getName().toUpperCase() + " LOWERED ITS ENEMY'S ATTACK!   ║");
                                System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (PlayerPokemon1.getName().length() + 27); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                            }

                            if (move.getName().equals("Thunder Wave")) {
                                enemyparalyzed = true;
                                System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (PlayerPokemon1.getName().length() + 20); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                                System.out.println("║   " + PlayerPokemon1.getName().toUpperCase() + " PARALYZED ITS ENEMY!   ║");
                                System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (PlayerPokemon1.getName().length() + 20); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                            }

                            if (move.getName().equals("Thunderbolt")) {
                                if (rngcheck(30)) {
                                    enemyparalyzed = true;
                                    System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (PlayerPokemon1.getName().length() + 20); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                                    System.out.println("║   " + PlayerPokemon1.getName().toUpperCase() + " PARALYZED ITS ENEMY!   ║");
                                    System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (PlayerPokemon1.getName().length() + 20); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                                }
                            }

                            if (move.getName().equals("Sludge Wave")) {
                                if (rngcheck(20)) {
                                    enemypoison = true;
                                    System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (PlayerPokemon1.getName().length() + 19); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                                    System.out.println("║   " + PlayerPokemon1.getName().toUpperCase() + " POISONED ITS ENEMY!   ║");
                                    System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (PlayerPokemon1.getName().length() + 19); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                                }
                            }

                            if (move.getName().equals("Venoshock")) {
                                if (enemypoison || enemyburn || enemyparalyzed) {
                                    System.out.println(""" 
                            ⊝═══════════════════════════════════════════════════════════════⊝
                            ║   VENOSHOCK'S PROPERTIES ALLOW IT TO TRIGGER A SECOND TIME?   ║
                            ⊝═══════════════════════════════════════════════════════════════⊝
                            ║         YOU FEEL LIKE YOU'RE GOING TO HAVE A BAD TIME.        ║
                            ⊝═══════════════════════════════════════════════════════════════⊝""");
                                    playerdamagecalculation(move.getMovetype(), EnemyPokemon1.getType(), EnemyPokemon2.getType(), move.getPower(), move.getAccuracy(), move.attacktype());
                                }
                            }

                            if (move.getName().equals("Giga Drain")) {
                                System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (PlayerPokemon1.getName().length() + 32); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                                System.out.println("║   " + PlayerPokemon1.getName().toUpperCase() + " HEALS A PORTION OF DAMAGE DEALT!   ║");
                                System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (PlayerPokemon1.getName().length() + 32); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                                PlayerPokemon1.currenthp = PlayerPokemon1.maxhp;
                            }

                            if (move.getName().equals("Confusion")) {
                                enemyconfused = true;
                                System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (PlayerPokemon1.getName().length() + 19); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                                System.out.println("║   " + PlayerPokemon1.getName().toUpperCase() + " CONFUSED ITS ENEMY!   ║");
                                System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (PlayerPokemon1.getName().length() + 19); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                            }

                            if (move.getName().equals("Psychic")) {
                                if (rngcheck(30)) {
                                    enemyconfused = true;
                                    System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (PlayerPokemon1.getName().length() + 19); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                                    System.out.println("║   " + PlayerPokemon1.getName().toUpperCase() + " CONFUSED ITS ENEMY!   ║");
                                    System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (PlayerPokemon1.getName().length() + 19); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                                }
                            }

                            if (move.getName().equals("Ember") || move.getName().equals("Flamethrower")) {
                                if (rngcheck(30)) {
                                    enemyburn = true;
                                    System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (PlayerPokemon1.getName().length() + 17); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                                    System.out.println("║   " + PlayerPokemon1.getName().toUpperCase() + " BURNED ITS ENEMY!   ║");
                                    System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (PlayerPokemon1.getName().length() + 17); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                                }
                            }

                            poke1moved = true;
                        }
                    }

                    if (EnemyPokemon1.currenthp <= 0 &&  EnemyPokemon2.currenthp >= 0  && EnemyPokemon3.currenthp >= 0) {
                        System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (EnemyPokemon1.getName().length() + 16); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                        System.out.println("║   YOU KNOCKED OUT " + EnemyPokemon1.getName().toUpperCase() + "!   ║");
                        System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (EnemyPokemon1.getName().length() + 16); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                        switchpokemon(EnemyPokemon2, EnemyPokemon1);
                        poke2moved = true;
                    }
                    else if (EnemyPokemon1.currenthp <= 0 && EnemyPokemon2.currenthp <= 0 && EnemyPokemon3.currenthp >= 0) {
                        switchpokemon(EnemyPokemon3, EnemyPokemon1); poke2moved = true; }
                    else if (EnemyPokemon1.currenthp <= 0 && EnemyPokemon2.currenthp <= 0 && EnemyPokemon3.currenthp <= 0) {
                        endfight = true; break;
                    }
                } else {
                    int movepick = enemymovecheck();

                    if(enemyparalyzed){
                        if(rngcheck(50)){
                            System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (EnemyPokemon1.getName().length() + 30); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                            System.out.println("║   " + EnemyPokemon1.getName().toUpperCase() + " BROKE FREE FROM ITS PARALYSIS!   ║");
                            System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (EnemyPokemon1.getName().length() + 30); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                            enemyparalyzed = false;
                            break;
                        }

                        if(rngcheck(25))
                        {
                            poke2moved = true;
                            System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (EnemyPokemon1.getName().length() + 33); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                            System.out.println("║   " + EnemyPokemon1.getName().toUpperCase() + " CANNOT MOVE DUE TO ITS PARALYSIS!   ║");
                            System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (EnemyPokemon1.getName().length() + 33); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                        }
                    }

                    if(enemypoison){
                        if(rngcheck(50)){
                            System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (EnemyPokemon1.getName().length() + 25); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                            System.out.println("║   " + EnemyPokemon1.getName().toUpperCase() + " CURED ITSELF FROM POISON!   ║");
                            System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (EnemyPokemon1.getName().length() + 25); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                            enemypoison = false;
                            break;
                        }

                        if (EnemyPokemon1.maxhp/16 > 99){
                            System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (EnemyPokemon1.getName().length() + 42); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                        }
                        else if (EnemyPokemon1.maxhp/16 > 9){
                            System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (EnemyPokemon1.getName().length() + 41); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                        }
                        else {
                            System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (EnemyPokemon1.getName().length() + 40); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                        }
                        System.out.println("║   " +EnemyPokemon1.getName().toUpperCase() + "'S POISON TAKES EFFECT, DEALING " + EnemyPokemon1.maxhp/16 + " DAMAGE!   ║");
                        EnemyPokemon1.currenthp -= EnemyPokemon1.maxhp/16;
                        if (EnemyPokemon1.maxhp/16 > 99){
                            System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (EnemyPokemon1.getName().length() + 42); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                        }
                        else if (EnemyPokemon1.maxhp/16 > 9){
                            System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (EnemyPokemon1.getName().length() + 41); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                        }
                        else {
                            System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (EnemyPokemon1.getName().length() + 40); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                        }

                        if (EnemyPokemon1.currenthp <= 0 &&  EnemyPokemon2.currenthp >= 0  && EnemyPokemon3.currenthp >= 0) {
                            switchpokemon(EnemyPokemon2, EnemyPokemon1);
                            poke2moved = true; break;
                        }
                        else if (EnemyPokemon1.currenthp <= 0 && EnemyPokemon2.currenthp <= 0 && EnemyPokemon3.currenthp >= 0) {
                            switchpokemon(EnemyPokemon3, EnemyPokemon1); poke2moved = true; break;}

                        else if (EnemyPokemon1.currenthp <= 0 && EnemyPokemon2.currenthp <= 0 && EnemyPokemon3.currenthp <= 0) {
                            endfight = true; break;
                        }

                        if(!debufftrigger) {
                            EnemyPokemon1.currentattack *= 0.5;
                            debufftrigger = true;
                        }
                    }

                    if(enemyburn){
                        if(rngcheck(50)){
                            System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (EnemyPokemon1.getName().length() + 23); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                            System.out.println("║   " + EnemyPokemon1.getName().toUpperCase() + " CURED ITSELF FROM BURN!   ║");
                            System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (EnemyPokemon1.getName().length() + 23); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                            debufftrigger = false;
                            enemyburn = false;
                            break;
                        }

                        if (EnemyPokemon1.maxhp/16 > 99){
                            System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (EnemyPokemon1.getName().length() + 40); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                        }
                        else if (EnemyPokemon1.maxhp/16 > 9){
                            System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (EnemyPokemon1.getName().length() + 39); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                        }
                        else {
                            System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (EnemyPokemon1.getName().length() + 38); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                        }
                        System.out.println("║   " + EnemyPokemon1.getName().toUpperCase() + "'S BURN TAKES EFFECT, DEALING " + EnemyPokemon1.maxhp/16 + " DAMAGE!   ║");
                        EnemyPokemon1.currenthp -= EnemyPokemon1.maxhp/16;
                        if (EnemyPokemon1.maxhp/16 > 99){
                            System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (EnemyPokemon1.getName().length() + 40); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                        }
                        else if (EnemyPokemon1.maxhp/16 > 9){
                            System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (EnemyPokemon1.getName().length() + 39); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                        }
                        else {
                            System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (EnemyPokemon1.getName().length() + 38); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                        }

                        if (EnemyPokemon1.currenthp <= 0 &&  EnemyPokemon2.currenthp >= 0  && EnemyPokemon3.currenthp >= 0) {
                            switchpokemon(EnemyPokemon2, EnemyPokemon1);
                            poke2moved = true; break;
                        }
                        else if (EnemyPokemon1.currenthp <= 0 && EnemyPokemon2.currenthp <= 0 && EnemyPokemon3.currenthp >= 0) {
                            switchpokemon(EnemyPokemon3, EnemyPokemon1); poke2moved = true; break;}

                        else if (EnemyPokemon1.currenthp <= 0 && EnemyPokemon2.currenthp <= 0 && EnemyPokemon3.currenthp <= 0) {
                            endfight = true; break;
                        }

                        if(!debufftrigger) {
                            EnemyPokemon1.currentattack *= 0.5;
                            debufftrigger = true;
                        }
                    }

                    if(enemyconfused){
                        if(rngcheck(50)){
                            System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (EnemyPokemon1.getName().length() + 25); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                            System.out.println("║   " + EnemyPokemon1.getName().toUpperCase() + " SNAPPED OUT OF CONFUSION!   ║");
                            System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (EnemyPokemon1.getName().length() + 25); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                            enemyconfused = false;
                            break;
                        }
                        System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (EnemyPokemon1.getName().length() + 15); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                        System.out.println("║   " + EnemyPokemon1.getName().toUpperCase() + " IS CONFUSED...   ║");
                        System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (EnemyPokemon1.getName().length() + 15); chrctr++){System.out.print("═");} System.out.println("═══⊝");

                        if(rngcheck(25))
                        {
                            poke2moved = true;
                            if (EnemyPokemon1.maxhp/16 > 99){
                                System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (EnemyPokemon1.getName().length() + 53); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                            }
                            else if (EnemyPokemon1.maxhp/16 > 9){
                                System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (EnemyPokemon1.getName().length() + 52); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                            }
                            else {
                                System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (EnemyPokemon1.getName().length() + 51); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                            }
                            System.out.println("║   " + EnemyPokemon1.getName().toUpperCase() + " HURT ITSELF IT ITS OWN CONFUSION, DEALING " + EnemyPokemon1.maxhp/16 + " DAMAGE!   ║");
                            EnemyPokemon1.currenthp -= EnemyPokemon1.maxhp/16;
                            if (EnemyPokemon1.maxhp/16 > 99){
                                System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (EnemyPokemon1.getName().length() + 53); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                            }
                            else if (EnemyPokemon1.maxhp/16 > 9){
                                System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (EnemyPokemon1.getName().length() + 52); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                            }
                            else {
                                System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (EnemyPokemon1.getName().length() + 51); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                            }

                            if (EnemyPokemon1.currenthp <= 0 &&  EnemyPokemon2.currenthp >= 0  && EnemyPokemon3.currenthp >= 0) {
                                switchpokemon(EnemyPokemon2, EnemyPokemon1);
                                poke2moved = true; break;
                            }
                            else if (EnemyPokemon1.currenthp <= 0 && EnemyPokemon2.currenthp <= 0 && EnemyPokemon3.currenthp >= 0) {
                                switchpokemon(EnemyPokemon3, EnemyPokemon1); poke2moved = true; break;}

                            else if (EnemyPokemon1.currenthp <= 0 && EnemyPokemon2.currenthp <= 0 && EnemyPokemon3.currenthp <= 0) {
                                endfight = true; break;
                            }
                        }
                    }

                    for (int i = 0; i < EnemyPokemon1Moves.length; i++) {
                        Moves move = EnemyPokemon1Moves[i];
                        if (i == movepick) /* randomizing logic goes here */ {
                            System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (EnemyPokemon1.getName().length() + 6 + move.getName().length()); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                            System.out.println("║   " + EnemyPokemon1.getName().toUpperCase() + " USED " + move.getName().toUpperCase() + "!   ║");
                            System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (EnemyPokemon1.getName().length() + 6 + move.getName().length()); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                            System.out.println();
                            enemydamagecalculation(move.getMovetype(), PlayerPokemon1.getType(), PlayerPokemon1.getType2(), move.getPower(), move.getAccuracy(), move.attacktype());

                            if(move.getName().equals("Explosion"))
                            {
                                EnemyPokemon1.currenthp = 0;
                                System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (EnemyPokemon1.getName().length() + 36); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                                System.out.println("║   " + EnemyPokemon1.getName().toUpperCase() + " IS KNOCKED OUT BY ITS OWN EXPLOSION!   ║");
                                System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (EnemyPokemon1.getName().length() + 36); chrctr++){System.out.print("═");} System.out.println("═══⊝");

                                if (EnemyPokemon1.currenthp <= 0 &&  EnemyPokemon2.currenthp >= 0  && EnemyPokemon3.currenthp >= 0) {
                                    switchpokemon(EnemyPokemon2, EnemyPokemon1);
                                    poke2moved = true; break;
                                }
                                else if (EnemyPokemon1.currenthp <= 0 && EnemyPokemon2.currenthp <= 0 && EnemyPokemon3.currenthp >= 0) {
                                    switchpokemon(EnemyPokemon3, EnemyPokemon1); poke2moved = true; break;}

                                else if (EnemyPokemon1.currenthp <= 0 && EnemyPokemon2.currenthp <= 0 && EnemyPokemon3.currenthp <= 0) {
                                    endfight = true; break;
                                }
                            }

                            if(move.getName().equals("Recover") || move.getName().equals("Slack Off")){
                                EnemyPokemon1.currenthp = EnemyPokemon1.maxhp;
                                System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (EnemyPokemon1.getName().length() + 15); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                                System.out.println("║   " + EnemyPokemon1.getName().toUpperCase() + " HEALED TO FULL!   ║");
                                System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (EnemyPokemon1.getName().length() + 15); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                            }

                            if(move.getName().equals("Cosmic Power")){
                                EnemyPokemon1.currentdefense *= 1.5;
                                EnemyPokemon1.currentspdefense *= 1.5;
                                System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (EnemyPokemon1.getName().length() + 19); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                                System.out.println("║   " + EnemyPokemon1.getName().toUpperCase() + " RAISED ITS DEFENSES!   ║");
                                System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (EnemyPokemon1.getName().length() + 19); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                            }

                            if(move.getName().equals("King Protect")){
                                PlayerPokemon1.currentattack *= 0.25;
                                System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (EnemyPokemon1.getName().length() + 27); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                                System.out.println("║   " + EnemyPokemon1.getName().toUpperCase() + " LOWERED ITS ENEMY'S ATTACK!   ║");
                                System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (EnemyPokemon1.getName().length() + 27); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                            }

                            if(move.getName().equals("Thunder Wave")){
                                System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (EnemyPokemon1.getName().length() + 20); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                                System.out.println("║   " + EnemyPokemon1.getName().toUpperCase() + " PARALYZED ITS ENEMY!   ║");
                                System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (EnemyPokemon1.getName().length() + 20); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                            }

                            if(move.getName().equals("Thunderbolt")){
                                if(rngcheck(30)) {
                                    playerparalyzed = true;
                                    System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (EnemyPokemon1.getName().length() + 20); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                                    System.out.println("║   " + EnemyPokemon1.getName().toUpperCase() + " PARALYZED ITS ENEMY!   ║");
                                    System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (EnemyPokemon1.getName().length() + 20); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                                }
                            }

                            if(move.getName().equals("Sludge Wave")){
                                if(rngcheck(20)) {
                                    playerpoison = true;
                                    System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (EnemyPokemon1.getName().length() + 19); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                                    System.out.println("║   " + EnemyPokemon1.getName().toUpperCase() + " POISONED ITS ENEMY!   ║");
                                    System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (EnemyPokemon1.getName().length() + 19); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                                }
                            }

                            if(move.getName().equals("Venoshock")){
                                if(playerpoison || playerburn || playerparalyzed) {
                                    System.out.println(""" 
                            ⊝═══════════════════════════════════════════════════════════════⊝
                            ║   VENOSHOCK'S PROPERTIES ALLOW IT TO TRIGGER A SECOND TIME?   ║
                            ⊝═══════════════════════════════════════════════════════════════⊝
                            ║         YOU FEEL LIKE YOU'RE GOING TO HAVE A BAD TIME.        ║
                            ⊝═══════════════════════════════════════════════════════════════⊝""");
                                    enemydamagecalculation(move.getMovetype(), PlayerPokemon1.getType(), PlayerPokemon1.getType2(), move.getPower(), move.getAccuracy(), move.attacktype());
                                }
                            }

                            if(move.getName().equals("Giga Drain")){
                                System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (EnemyPokemon1.getName().length() + 32); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                                System.out.println("║   " + EnemyPokemon1.getName().toUpperCase() + " HEALS A PORTION OF DAMAGE DEALT!   ║");
                                System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (EnemyPokemon1.getName().length() + 32); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                                EnemyPokemon1.currenthp = EnemyPokemon1.maxhp;
                            }

                            if(move.getName().equals("Confusion")){
                                playerconfused = true;
                                System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (EnemyPokemon1.getName().length() + 19); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                                System.out.println("║   " + EnemyPokemon1.getName().toUpperCase() + " CONFUSED ITS ENEMY!   ║");
                                System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (EnemyPokemon1.getName().length() + 19); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                            }

                            if(move.getName().equals("Psychic")){
                                if(rngcheck(30)) {
                                    playerconfused = true;
                                    System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (EnemyPokemon1.getName().length() + 19); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                                    System.out.println("║   " + EnemyPokemon1.getName().toUpperCase() + " CONFUSED ITS ENEMY!   ║");
                                    System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (EnemyPokemon1.getName().length() + 19); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                                }
                            }

                            if(move.getName().equals("Ember") || move.getName().equals("Flamethrower")){
                                if(rngcheck(30)) {
                                    playerburn = true;
                                    System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (EnemyPokemon1.getName().length() + 17); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                                    System.out.println("║   " + EnemyPokemon1.getName().toUpperCase() + " BURNED ITS ENEMY!   ║");
                                    System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (EnemyPokemon1.getName().length() + 17); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                                }
                            }

                            poke2moved = true;
                        }
                    }

                    if (PlayerPokemon1.currenthp <= 0 && PlayerPokemon2.currenthp <= 0 && PlayerPokemon3.currenthp <= 0) {
                        endfight = true;
                        return false;
                    }

                    else if (PlayerPokemon1.currenthp <= 0) {
                        System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (EnemyPokemon1.getName().length() + 13 + PlayerPokemon1.getName().length()); chrctr++){System.out.print("═");} System.out.println("═══⊝");
                        System.out.println("║   " + EnemyPokemon1.getName().toUpperCase() + " KNOCKED OUT " + PlayerPokemon1.getName().toUpperCase() + "!   ║");
                        System.out.print("⊝═══");for(int chrctr = 0; chrctr <= (EnemyPokemon1.getName().length() + 13 + PlayerPokemon1.getName().length()); chrctr++){System.out.print("═");} System.out.println("═══⊝");

                        System.out.println("⊝═══════════════════════════════════⊝");
                        if(PlayerPokemon2.currenthp>0){
                            System.out.print("║   " + PlayerPokemon2.getName().toUpperCase()); for(int chrctr = 0; chrctr <= (34 - (PlayerPokemon2.getName().length() + 3)); chrctr++){System.out.print(" ");} System.out.println("║");
                        }
                        if(PlayerPokemon3.currenthp>0){
                            System.out.print("║   " + PlayerPokemon3.getName().toUpperCase()); for(int chrctr = 0; chrctr <= (34 - (PlayerPokemon3.getName().length() + 3)); chrctr++){System.out.print(" ");} System.out.println("║");
                        }



                        boolean switchcheck = true;
                        while (switchcheck) {
                            System.out.println("⊝═══════════════════════════════════⊝");
                            System.out.println("║   CHOOSE A POKEMON TO SWITCH TO   ║");
                            System.out.println("⊝═══════════════════════════════════⊝");
                            String pokemonswitch = input.next().toLowerCase();
                            if (PlayerPokemon2.getName().toLowerCase().equals(pokemonswitch)) {
                                switchpokemon(PlayerPokemon2, PlayerPokemon1);
                                switchcheck = false;
                            } else if (PlayerPokemon3.getName().toLowerCase().equals(pokemonswitch)) {
                                switchpokemon(PlayerPokemon3, PlayerPokemon1);
                                switchcheck = false;
                            } else
                                System.out.println(""" 
                            ⊝═══════════════════⊝
                            ║   INVALID INPUT   ║
                            ⊝═══════════════════⊝""");
                        }

                        poke1moved = true;
                    }
                }

                if (poke1moved && poke2moved) {
                    turnover = true;
                }
            }
        }while(!endfight);

        System.out.println(""" 
                            ⊝════════════════════════════════════════════════════⊝
                            ║                      YOU WON!                      ║
                            ⊝════════════════════════════════════════════════════⊝""");
        System.out.println(" TURNS TAKEN: " + turncounter);
        if(enemyTeamFile != 6) {
            System.out.println(" POINTS OBTAINED: 30");
            System.out.println("""
                    ⊝════════════════════════════════════════════════════⊝
                    ║   HEALING POKEMON... MOVING ONTO THE NEXT FIGHT!   ║
                    ⊝════════════════════════════════════════════════════⊝""");
            FileHandling.initializeWriter();
            Pokemon_Main main = new Pokemon_Main();
            String name = Pokemon_Main.getPlayerName();
            int team = Pokemon_Main.getTeamnumber();
            enemyTeamFile++;
            file.setDifficultyfile(Pokemon_Main.getDifficulty());
            file.setNamefile(name);
            file.setPlayteamfile(String.valueOf(team));
            file.setEnemyteamfile(enemyTeamFile);
            file.savetofile();
            FileHandling.closeWriter();

        }
        else{
            System.out.println(" POINTS OBTAINED: 40");
            FileHandling.initializeWriter();
            file.setEnemyteamfile(enemyTeamFile);
            file.savetofile();
            FileHandling.closeWriter();
        }
        return true;
    }

    public void playerdamagecalculation(String attacking, String defending, String defending2, int power, int accuracy, int type){

        Moves[] PlayerPokemon1Moves = PlayerPokemon1.getMoves();
        Moves[] EnemyPokemon1Moves = EnemyPokemon1.getMoves();

        PokemonType attack = PokemonDetermine(attacking);
        PokemonType defend = PokemonDetermine(defending);
        PokemonType defend2 = PokemonDetermine(defending);
        if(defending2 != null)
            defend2 = PokemonDetermine(defending2);

        double damage = 0;
        double effectiveness = 0;

        if(defending2 == null) {
            effectiveness = typeeffectiveness.effectivenesscalc(attack, defend);
        }
        else {
            effectiveness = typeeffectiveness.effectivenesscalc(attack, defend);
            effectiveness *= typeeffectiveness.effectivenesscalc(attack, defend2);
        }

        if(type == 0) {
            if (rngcheck(accuracy))
                damage = calculatePhysicalDamage(PlayerPokemon1.currentattack, EnemyPokemon1.currentdefense, power, effectiveness);
            else {
                System.out.print("⊝═══");
                for (int chrctr = 0; chrctr <= (PlayerPokemon1.getName().toUpperCase().length() + 18); chrctr++) {
                    System.out.print("═");
                }
                System.out.println("═══⊝");
                System.out.println("║   " + PlayerPokemon1.getName().toUpperCase() + " MISSED ITS ATTACK!   ║");
                System.out.print("⊝═══");
                for (int chrctr = 0; chrctr <= (PlayerPokemon1.getName().toUpperCase().length() + 18); chrctr++) {
                    System.out.print("═");
                }
                System.out.println("═══⊝");
            }
        }
        else if(type == 1) {
            if (rngcheck(accuracy))
                damage = calculateSpecialDamage(PlayerPokemon1.currentspattack, EnemyPokemon1.currentspdefense, power, effectiveness);
            else {
                System.out.print("⊝═══");
                for (int chrctr = 0; chrctr <= (PlayerPokemon1.getName().length() + 18); chrctr++) {
                    System.out.print("═");
                }
                System.out.println("═══⊝");
                System.out.println("║   " + PlayerPokemon1.getName().toUpperCase() + " MISSED ITS ATTACK!   ║");
                System.out.print("⊝═══");
                for (int chrctr = 0; chrctr <= (PlayerPokemon1.getName().length() + 18); chrctr++) {
                    System.out.print("═");
                }
                System.out.println("═══⊝");
            }
        }

        int finaldamage = (int)Math.floor(damage);

        EnemyPokemon1.currenthp -= finaldamage;

        if (finaldamage > 99){
            System.out.print("⊝═══"); for (int chrctr = 0; chrctr <= (EnemyPokemon1.getName().length() + 17); chrctr++) {System.out.print("═");} System.out.println("═══⊝");
        }
        else if (finaldamage > 9){
            System.out.print("⊝═══"); for (int chrctr = 0; chrctr <= (EnemyPokemon1.getName().length() + 16); chrctr++) {System.out.print("═");} System.out.println("═══⊝");
        }
        else {
            System.out.print("⊝═══"); for (int chrctr = 0; chrctr <= (EnemyPokemon1.getName().length() + 15); chrctr++) {System.out.print("═");} System.out.println("═══⊝");
        }
        System.out.println("║   YOU DEALT " + finaldamage + " TO " + EnemyPokemon1.getName().toUpperCase() +"!   ║");
        if (finaldamage > 99){
            System.out.print("⊝═══"); for (int chrctr = 0; chrctr <= (EnemyPokemon1.getName().length() + 17); chrctr++) {System.out.print("═");} System.out.println("═══⊝");
        }
        else if (finaldamage > 99){
            System.out.print("⊝═══"); for (int chrctr = 0; chrctr <= (EnemyPokemon1.getName().length() + 16); chrctr++) {System.out.print("═");} System.out.println("═══⊝");
        }
        else {
            System.out.print("⊝═══"); for (int chrctr = 0; chrctr <= (EnemyPokemon1.getName().length() + 15); chrctr++) {System.out.print("═");} System.out.println("═══⊝");
        }

        if(effectiveness > 1) {
            System.out.println(""" 
                            ⊝══════════════════════════⊝
                            ║   IT'S SUPER EFFECTIVE   ║
                            ⊝══════════════════════════⊝""");
        }
        else if(effectiveness < 1) {
            System.out.println(""" 
                            ⊝════════════════════════⊝
                            ║   IT'S NOT EFFECTIVE   ║
                            ⊝════════════════════════⊝""");
        }
        else if(effectiveness == 0.0) {
            System.out.println(""" 
                            ⊝══════════════════════⊝
                            ║   IT HAS NO EFFECT   ║
                            ⊝══════════════════════⊝""");
        }

    }

    public void enemydamagecalculation(String attacking, String defending, String defending2, int power, int accuracy, int type){

        Moves[] PlayerPokemon1Moves = PlayerPokemon1.getMoves();
        Moves[] EnemyPokemon1Moves = EnemyPokemon1.getMoves();

        PokemonType attack = PokemonDetermine(attacking);
        PokemonType defend = PokemonDetermine(defending);
        PokemonType defend2 = PokemonDetermine(defending);

        if(defending2 != null)
            defend2 = PokemonDetermine(defending2);

        double damage = 0;
        double effectiveness = 0;

        if(defending2 == null) {
            effectiveness = typeeffectiveness.effectivenesscalc(attack, defend);
        }
        else {
            effectiveness = typeeffectiveness.effectivenesscalc(attack, defend);
            effectiveness *= typeeffectiveness.effectivenesscalc(attack, defend2);
        }

        if(type == 0) {
            if (rngcheck(accuracy))
                damage = calculatePhysicalDamage(EnemyPokemon1.currentattack, PlayerPokemon1.currentdefense, power, effectiveness);
            else {
                System.out.print("⊝═══");
                for (int chrctr = 0; chrctr <= (EnemyPokemon1.getName().length() + 17); chrctr++) {
                    System.out.print("═");
                }
                System.out.println("═══⊝");
                System.out.println("║   " + EnemyPokemon1.getName().toUpperCase() + " MISSED ITS ATTACK!   ║");
                System.out.print("⊝═══");
                for (int chrctr = 0; chrctr <= (EnemyPokemon1.getName().length() + 17); chrctr++) {
                    System.out.print("═");
                }
                System.out.println("═══⊝");
            }
        }
        else if(type == 1) {
            if (rngcheck(accuracy))
                damage = calculateSpecialDamage(EnemyPokemon1.currentspattack, PlayerPokemon1.currentspdefense, power, effectiveness);
            else{
                System.out.print("⊝═══");
                for (int chrctr = 0; chrctr <= (EnemyPokemon1.getName().length() + 17); chrctr++) {
                    System.out.print("═");
                }
                System.out.println("═══⊝");
                System.out.println("║   " + EnemyPokemon1.getName().toUpperCase() + " MISSED ITS ATTACK!   ║");
                System.out.print("⊝═══");
                for (int chrctr = 0; chrctr <= (EnemyPokemon1.getName().length() + 17); chrctr++) {
                    System.out.print("═");
                }
                System.out.println("═══⊝");
            }
        }

        int finaldamage = (int)Math.floor(damage);

        PlayerPokemon1.currenthp -= finaldamage;

        if (finaldamage > 99){
            System.out.print("⊝═══"); for (int chrctr = 0; chrctr <= (EnemyPokemon1.getName().length() + 14 + PlayerPokemon1.getName().length()); chrctr++) {System.out.print("═");} System.out.println("═══⊝");
        }
        else if (finaldamage > 9){
            System.out.print("⊝═══"); for (int chrctr = 0; chrctr <= (EnemyPokemon1.getName().length() + 13 + PlayerPokemon1.getName().length()); chrctr++) {System.out.print("═");} System.out.println("═══⊝");
        }
        else {
            System.out.print("⊝═══"); for (int chrctr = 0; chrctr <= (EnemyPokemon1.getName().length() + 12 + PlayerPokemon1.getName().length()); chrctr++) {System.out.print("═");} System.out.println("═══⊝");
        }
        System.out.println("║   " + EnemyPokemon1.getName().toUpperCase() + " DEALT " + finaldamage + " TO " + PlayerPokemon1.getName().toUpperCase() +"!   ║");
        if (finaldamage > 99){
            System.out.print("⊝═══"); for (int chrctr = 0; chrctr <= (EnemyPokemon1.getName().length() + 14 + PlayerPokemon1.getName().length()); chrctr++) {System.out.print("═");} System.out.println("═══⊝");
        }
        else if (finaldamage > 9){
            System.out.print("⊝═══"); for (int chrctr = 0; chrctr <= (EnemyPokemon1.getName().length() + 13 + PlayerPokemon1.getName().length()); chrctr++) {System.out.print("═");} System.out.println("═══⊝");
        }
        else {
            System.out.print("⊝═══"); for (int chrctr = 0; chrctr <= (EnemyPokemon1.getName().length() + 12 + PlayerPokemon1.getName().length()); chrctr++) {System.out.print("═");} System.out.println("═══⊝");
        }

        if(effectiveness > 1){
            System.out.println(""" 
                            ⊝══════════════════════════⊝
                            ║   IT'S SUPER EFFECTIVE   ║
                            ⊝══════════════════════════⊝""");
        }
        else if(effectiveness < 1) {
            System.out.println(""" 
                            ⊝════════════════════════⊝
                            ║   IT'S NOT EFFECTIVE   ║
                            ⊝════════════════════════⊝""");
        }
        else if(effectiveness == 0.0) {
            System.out.println(""" 
                            ⊝══════════════════════⊝
                            ║   IT HAS NO EFFECT   ║
                            ⊝══════════════════════⊝""");
        }

    }

    private static double calculatePhysicalDamage(int attack, int defense, int basePower, double effectiveness){
        return ((2.0 *50.0 / 250.0) * ((double)attack / defense) * basePower + 2) * effectiveness;
    }

    private static double calculateSpecialDamage(int attack, int defense, int basePower, double effectiveness){
        return ((2.0 *50.0 / 250.0) * ((double)attack / defense) * basePower + 2) * effectiveness;
    }

    public void switchpokemon(pokemonattempt switchinginpoke, pokemonattempt switchingoutpoke){
        pokemonattempt tempholder = switchinginpoke;

        Moves[] PlayerPokemon1Moves = PlayerPokemon1.getMoves(); // always the active pokemon
        Moves[] PlayerPokemon2Moves = PlayerPokemon2.getMoves();
        Moves[] PlayerPokemon3Moves = PlayerPokemon3.getMoves();

        Moves[] EnemyPokemon1Moves = EnemyPokemon1.getMoves(); // always the active pokemon
        Moves[] EnemyPokemon2Moves = EnemyPokemon2.getMoves();
        Moves[] EnemyPokemon3Moves = EnemyPokemon3.getMoves();

        if (switchingoutpoke == PlayerPokemon1){
            System.out.print("⊝═══"); for (int chrctr = 0; chrctr <= (switchingoutpoke.getName().length() + 8); chrctr++) {System.out.print("═");}System.out.println("═══⊝");
            System.out.println("║   GET IN, " + switchingoutpoke.getName().toUpperCase() + "!   ║");
            System.out.print("⊝═══"); for (int chrctr = 0; chrctr <= (switchingoutpoke.getName().length() + 8); chrctr++) {System.out.print("═");}System.out.println("═══⊝");

            PlayerPokemon1 = switchinginpoke;
            PlayerPokemon1Moves = switchinginpoke.getMoves();
            if (switchinginpoke == PlayerPokemon2){
                PlayerPokemon2 = switchingoutpoke;
                PlayerPokemon2Moves = switchingoutpoke.getMoves();

                System.out.print("⊝═══"); for (int chrctr = 0; chrctr <= (switchinginpoke.getName().length() + 16); chrctr++) {System.out.print("═");}System.out.println("═══⊝");
                System.out.println("║   IT'S YOUR TURN, " + switchinginpoke.getName().toUpperCase() + "!   ║");
                System.out.print("⊝═══"); for (int chrctr = 0; chrctr <= (switchinginpoke.getName().length() + 16); chrctr++) {System.out.print("═");}System.out.println("═══⊝");
            }
            else if (switchinginpoke == PlayerPokemon3){
                PlayerPokemon3 = switchingoutpoke;
                PlayerPokemon3Moves = switchingoutpoke.getMoves();
                System.out.print("⊝═══"); for (int chrctr = 0; chrctr <= (switchinginpoke.getName().length() + 16); chrctr++) {System.out.print("═");}System.out.println("═══⊝");
                System.out.println("║   IT'S YOUR TURN, " + switchinginpoke.getName().toUpperCase() + "!   ║");
                System.out.print("⊝═══"); for (int chrctr = 0; chrctr <= (switchinginpoke.getName().length() + 16); chrctr++) {System.out.print("═");}System.out.println("═══⊝");
            }
        }
        else if (switchingoutpoke == EnemyPokemon1){

            System.out.print("⊝═══"); for (int chrctr = 0; chrctr <= (switchingoutpoke.getName().length() + 23); chrctr++) {System.out.print("═");}System.out.println("═══⊝");
            System.out.println("║   ENEMY IS SWITCHING OUT " + switchingoutpoke.getName().toUpperCase() + "!   ║");
            System.out.print("⊝═══"); for (int chrctr = 0; chrctr <= (switchingoutpoke.getName().length() + 23); chrctr++) {System.out.print("═");}System.out.println("═══⊝");

            EnemyPokemon1 = switchinginpoke;
            EnemyPokemon1Moves = switchinginpoke.getMoves();
            if (switchinginpoke == EnemyPokemon2){
                EnemyPokemon2 = switchingoutpoke;
                EnemyPokemon2Moves = switchingoutpoke.getMoves();
                System.out.print("⊝═══"); for (int chrctr = 0; chrctr <= (switchinginpoke.getName().length() + 18); chrctr++) {System.out.print("═");}System.out.println("═══⊝");
                System.out.println("║   ENEMY SWITCHED IN " + switchinginpoke.getName().toUpperCase() + "!   ║");
                System.out.print("⊝═══"); for (int chrctr = 0; chrctr <= (switchinginpoke.getName().length() + 18); chrctr++) {System.out.print("═");}System.out.println("═══⊝");
            }
            else if (switchinginpoke == EnemyPokemon3){
                EnemyPokemon3 = switchingoutpoke;
                EnemyPokemon3Moves = switchingoutpoke.getMoves();
                System.out.print("⊝═══"); for (int chrctr = 0; chrctr <= (switchinginpoke.getName().length() + 18); chrctr++) {System.out.print("═");}System.out.println("═══⊝");
                System.out.println("║   ENEMY SWITCHED IN " + switchinginpoke.getName().toUpperCase() + "!   ║");
                System.out.print("⊝═══"); for (int chrctr = 0; chrctr <= (switchinginpoke.getName().length() + 18); chrctr++) {System.out.print("═");}System.out.println("═══⊝");
            }
        }
        else {
            System.out.println(""" 
                            ⊝═════════════════════════════⊝
                            ║   SWITCHING WENT WRONG :(   ║
                            ⊝═════════════════════════════⊝""");
        }
    }

    public PokemonType PokemonDetermine (String type) {
        switch (type.toUpperCase()) {
            case "NORMAL": return PokemonType.NORMAL;
            case "FIGHTING": return PokemonType.FIGHTING;
            case "FLYING": return PokemonType.FLYING;
            case "POISON": return PokemonType.POISON;
            case "GROUND": return PokemonType.GROUND;
            case "ROCK": return PokemonType.ROCK;
            case "BUG": return PokemonType.BUG;
            case "GHOST": return PokemonType.GHOST;
            case "STEEL": return PokemonType.STEEL;
            case "FIRE": return PokemonType.FIRE;
            case "WATER": return PokemonType.WATER;
            case "GRASS": return PokemonType.GRASS;
            case "ELECTRIC": return PokemonType.ELECTRIC;
            case "PSYCHIC": return PokemonType.PSYCHIC;
            case "ICE": return PokemonType.ICE;
            case "DRAGON": return PokemonType.DRAGON;
            case "DARK": return PokemonType.DARK;
            case "FAIRY": return PokemonType.FAIRY;
            default: throw new IllegalArgumentException("Unknown type: " + type);
        }
    }

    public boolean rngcheck(int chance){
        Random rngcheck = new Random();
        int random = rngcheck.nextInt(100) + 1;
        boolean rngapply;

        rngapply = chance > random;

        return rngapply;
    }

    public int enemymovecheck(){
        Random rngcheck = new Random();
        int random = rngcheck.nextInt(4);
        return random;
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