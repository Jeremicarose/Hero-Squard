package models;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class squadTest {
    public void setup() throws Exception {
    }
    private  Squad setupNewSquad(){
        return new Squad ("infinite", 6, "fight for your life");
    }
    @Test
    public void SquadInstantiateWithName_true() throws Exception{
        Squad mySquad = setupNewSquad();
        assertEquals("infinite", mySquad.getName());
    }
    @Test
    public void HeroIstantiatesWithAge_true() throws Exception{
        Squad mySquad = setupNewSquad();
        assertEquals(6, mySquad.getSquadSize());
    }
    @Test
    public void HeroInstantiatesWithSpecialPowers_true() throws Exception{
        Squad mySquad= setupNewSquad();
        assertEquals("fight for your life", mySquad.getCause() );
    }


}
