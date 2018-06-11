package Bones;

import java.awt.*;

import org.dreambot.api.methods.Calculations;

import org.dreambot.api.methods.map.Area;
import org.dreambot.api.methods.skills.Skill;
import org.dreambot.api.script.AbstractScript;
import org.dreambot.api.script.Category;
import org.dreambot.api.script.ScriptManifest;
import org.dreambot.api.utilities.Timer;
import org.dreambot.api.wrappers.interactive.GameObject;
import org.dreambot.api.wrappers.items.GroundItem;


@ScriptManifest(author = "Ray", name = "Power Bones & Prayer!", version = 0.01, description = "Hello everyone, this is my first script! This bot will allow you to collect normal bones for now and will autom bury for you! ", category = Category.PRAYER)

public class Main extends AbstractScript {


    public Timer t;
    public static int runEnergy = 0;
    private String log = "Starting up";
    private String Scriptby = "ilcanada6";
    private boolean startScript;
    private BonesGUI gui;
    private Area CowArea;
    private int Bones;

    ;
    private final Color color1 = new Color(51, 51, 51, 147);
    private final Color color2 = new Color(138, 54, 15);
    private final Color color3 = new Color(255, 255, 255);
    private final BasicStroke stroke1 = new BasicStroke(5);
    private final Font font1 =
            new Font("Arial", Font.BOLD, 13);
    private final Font font2 = new Font("Arial", Font.BOLD, 0);
    private final Font font3 = new Font("Arial", 0, 13);


    public void onStart() {
        log("Pro Bones Script Starting!");
        getSkillTracker().start(Skill.PRAYER);
        t = new Timer();
        gui = new BonesGUI(this);
        gui.setVisible(true);

    }


    private Area[] areas = {CowArea,};
    Timer t1 = new Timer(Calculations.random(50000, 70000));
    //1080000, 1560000


    private enum State {
        PICKUP, WALKTO, DROP, BURRY, WAIT,
    }

    private State getState() {
        if ((!CowArea.contains(getLocalPlayer()) && !CowArea.contains(getLocalPlayer()) && !CowArea.contains(getLocalPlayer()) && !CowArea.contains(getLocalPlayer()) && !CowArea.contains(getLocalPlayer())) || t1.finished())
            return State.WALKTO;
        if (getInventory().isFull() && getInventory().containsAll("Bones"))
            return State.BURRY;
        if (getInventory().contains("Raw beef") || getInventory().contains("Cowhide"))
            return State.DROP;
        if (!getInventory().isFull() && (CowArea.contains(getLocalPlayer()) || CowArea.contains(getLocalPlayer()) || CowArea.contains(getLocalPlayer()) || CowArea.contains(getLocalPlayer()) || CowArea.contains(getLocalPlayer())))
            return State.PICKUP;


        return State.WAIT;
    }


    public void onExit() {
        log("Thanks for Using :)");
    }


    @Override
    public int onLoop() {
        GroundItem bones = getGroundItems().closest(b -> b != null && b.getName().equals(gui.getTreeType()) && b.distance() < 13);
        GameObject door = getGameObjects().closest(d -> d != null && d.hasAction("Open") && d.distance() < 8);

        if ((getWalking().getRunEnergy() > runEnergy) && !getWalking().isRunEnabled()) {
            getWalking().toggleRun();
            runEnergy = Calculations.random(15, 27);
        }

        switch (getState()) {
            case PICKUP:
                log = "Gathering Bones";
                if (bones != null) {
                    sleep(Calculations.random(22, 156));
                    bones.interact("Take");
                    sleep(Calculations.random(400, 480));
                    sleepUntil(() -> getLocalPlayer().isStandingStill(), Calculations.random(500, 2000));
                } else {
                    sleep(Calculations.random(100, 200));
                }
                break;


            case WALKTO:
                log = "Walking to Location";
                if (CowArea == null) {
                    CowArea = areas[Calculations.random(1, 4)];
                } else {
                    if (getWalking().walk(CowArea.getRandomTile())) {  //This will be ok assuming the area isnt massive. if its massive it may run kinda randomly.
                        sleep(233, 520);
                        sleepUntil(() -> !getLocalPlayer().isMoving()
                                || getLocalPlayer().distance(getClient().getDestination()) < Calculations.random(6, 9), Calculations.random(5321, 8392));

                    }
                }
                t1.reset();

            case DROP:

                sleep(Calculations.random(100, 200));
                getInventory().dropAllExcept(gui.getTreeType());
                break;

            case BURRY:
                log = "Time to Bury";
                sleep(Calculations.random(214, 323));
                getInventory().interact("Bones", "Bury");
                sleep(Calculations.random(853, 999));
                getInventory().interact("Bones", "Bury");
                sleep(Calculations.random(903, 933));
                getInventory().interact("Bones", "Bury");
                sleep(Calculations.random(863, 993));
                getInventory().interact("Bones", "Bury");
                sleep(Calculations.random(823, 993));
                getInventory().interact("Bones", "Bury");
                sleep(Calculations.random(853, 1030));
                getInventory().interact("Bones", "Bury");
                sleep(Calculations.random(903, 933));
                getInventory().interact("Bones", "Bury");
                sleep(Calculations.random(863, 933));
                getInventory().interact("Bones", "Bury");
                sleep(Calculations.random(803, 913));
                getInventory().interact("Bones", "Bury");
                sleep(Calculations.random(893, 933));
                getInventory().interact("Bones", "Bury");
                sleep(Calculations.random(923, 1023));
                getInventory().interact("Bones", "Bury");
                sleep(Calculations.random(843, 983));
                getInventory().interact("Bones", "Bury");
                sleep(Calculations.random(863, 993));
                getInventory().interact("Bones", "Bury");
                sleep(Calculations.random(883, 933));
                getInventory().interact("Bones", "Bury");
                sleep(Calculations.random(843, 963));
                getInventory().interact("Bones", "Bury");
                sleep(Calculations.random(843, 1083));
                getInventory().interact("Bones", "Bury");
                sleep(Calculations.random(973, 1003));
                getInventory().interact("Bones", "Bury");
                sleep(Calculations.random(853, 923));
                getInventory().interact("Bones", "Bury");
                sleep(Calculations.random(953, 1003));
                getInventory().interact("Bones", "Bury");
                sleep(Calculations.random(953, 1033));
                getInventory().interact("Bones", "Bury");
                sleep(Calculations.random(853, 943));
                getInventory().interact("Bones", "Bury");
                sleep(Calculations.random(853, 993));
                getInventory().interact("Bones", "Bury");
                sleep(Calculations.random(923, 973));
                getInventory().interact("Bones", "Bury");
                sleep(Calculations.random(853, 993));
                getInventory().interact("Bones", "Bury");
                sleep(Calculations.random(853, 913));
                getInventory().interact("Bones", "Bury");
                sleep(Calculations.random(933, 989));
                getInventory().interact("Bones", "Bury");
                sleep(Calculations.random(873, 933));
                getInventory().interact("Bones", "Bury");
                sleep(Calculations.random(883, 1063));
                getInventory().interact("Bones", "Bury");
                sleep(Calculations.random(913, 963));
                getInventory().interact("Bones", "Bury");
                sleep(Calculations.random(843, 974));
                getInventory().interact("Bones", "Bury");
                sleep(Calculations.random(853, 993));
                break;

            case WAIT:
                log("Waiting to Restarting");
                sleep(Calculations.random(50, 100));
                break;
        }
        return Calculations.random(20, 80);
    }

    /*
     * Paint
     */
    public long getGainedExperience(Skill prayer) {         //gained experience
        long fm;
        fm = getSkillTracker().getGainedExperience(Skill.PRAYER);
        return fm;
    }

    public long getGainedExperiencePerHour(Skill prayer) {  //gained experience per hour
        long fm;
        fm = getSkillTracker().getGainedExperiencePerHour(Skill.PRAYER);
        return fm;
    }

    public long getGainedLevels() {  //gained levels
        long fm;
        fm = getSkillTracker().getGainedLevels(Skill.PRAYER);
        return fm;
    }

    public long getExperienceToLevel() {  //Exp to level
        long fm;
        fm = getSkills().getExperienceToLevel(Skill.PRAYER);
        return fm;
    }

    public long getTimeToLevel() {
        long fmxp;
        long xphr;
        fmxp = getExperienceToLevel();
        xphr = getGainedExperiencePerHour(Skill.PRAYER);
        return fmxp / xphr;
    }

    public void onPaint(Graphics g) {
        Bones = (int) Math.floor(getSkillTracker().getGainedExperience(Skill.PRAYER) / 67.5); //Detects chopped logs

        if (t == null) {
            t = new Timer(0);
        }
        Graphics2D g1 = (Graphics2D) g;
        Stroke stroke = g1.getStroke();
        g.setColor(color1);
        g.fillRect(3, 4, 240, 160);
        g.setColor(color2);
        g1.setStroke(stroke1);
        g.drawRect(3, 4, 240, 160);
        g.setFont(font1);
        g.setColor(color3);
        g.drawString(getManifest().name() + "         " + "v" + getManifest().version(), 12, 29);
        g.setFont(font2);
        g.setFont(font3);

        g.drawString("Time running: " + Timer.formatTime(t.elapsed()), 12, 59);
        g.drawString("Action: " + log, 12, 42);
        g.drawString("XP gained: " + getGainedExperience(Skill.PRAYER) + "(" + getGainedExperiencePerHour(Skill.PRAYER) + ")", 12, 99);
        g.drawString("Levels gained: " + getSkills().getRealLevel(Skill.PRAYER) + "(+" + getGainedLevels() + ")", 12, 79);
        g.drawString("XP to level: " + getExperienceToLevel(), 12, 121);
        g.drawString("Bones[P/H]: " + Bones + " [" + t.getHourlyRate(Bones) + "]", 12, 141);
        g.drawString("Script by: " + Scriptby, 12, 160);
        g1.setStroke(stroke);
    }

    public void setStartScript(boolean startScript) {
        this.startScript = startScript;
    }


    public void setCowArea(Area area) {
        CowArea = area;
    }


}