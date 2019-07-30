package models;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.time.LocalDateTime;
import static org.junit.Assert.*;

public class HeroTest {
    @Before
    public void setUp(){
    }
    @After
    public void tearDown()  {
        Hero.getInstances();
    }

    @Test
    public void Hero_instantiateCorrectly_true(){
        Hero hero = new Hero("jere",23,"flash","love");
        assertTrue( hero instanceof Hero);
    }
    @Test
    public void Hero_instantiatesWith_Name_String(){
        Hero hero = new Hero("jere",23,"flash","love");
        assertEquals("jere",hero.getName());
    }
    @Test
    public void Hero_instantiatesWith_Age_int(){
        Hero hero = new Hero("jere",23,"flash","love");
        assertEquals(23,hero.getAge());
    }
    @Test
    public void Hero_instantiatesCorrectlyWithPower() {
        Hero hero = new Hero("jere",23,"flash","love");
        assertEquals("flash", hero.getPower());
    }
    @Test
    public void Hero_instantiatesCorrectlyWithWeakness_String() {
        Hero hero = new Hero("jere",23,"flash","love");
        assertEquals("love", hero.getWeakness());
    }

    @Test
    public void AllHeroAreCorrectlyReturned_true() {
        Hero.clearAllHeroes();
        Hero hero = new Hero("jere",23,"flash","love");
        Hero otherHero = new Hero ("jere",23,"flash","love");
        assertEquals(2, Hero.getInstances().size());
    }
    @Test
    public void AllHeroReturnAllInstances_ofHero_true() {
        Hero hero = new Hero("jere",23,"flash","love");
        Hero otherHero = new Hero ("mink",23,"fire","temper");
        assertTrue(Hero.getInstances().contains(hero));
        assertTrue(Hero.getInstances().contains(otherHero));
    }
    @Test
    public void getCreatedAt_instantiatesWithCurrentTime_today() throws Exception{
        Hero myHero = setupNewPost();
        assertEquals(LocalDateTime.now().getDayOfWeek(), myHero.getCreatedAt().getDayOfWeek());
    }
    private Hero setupNewPost(){
        return new Hero("jere",23,"flash","love");
    }
    @Test
    public void findReturnsCorrectHero() throws Exception {
        Hero hero = setupNewPost();

        assertEquals(hero, Hero.findBy(hero.getId()));

    }

    @Test
    public void getId_heroesInitiateWithAnID_1(){
        Hero.clearAllHeroes();
        Hero hero = new Hero("jere",23,"flash","love");
        assertEquals(Hero.getInstances().size(),hero.getId());
    }
    @Test
    public void findReturnsCorrectHeroWhenMoreThanOneHeroExists() throws Exception {
        Hero post = setupNewPost();
        Hero otherPost = new Hero("jere",23,"flash","love");
        assertEquals(otherPost, Hero.findBy(otherPost.getId()));
    }
}
