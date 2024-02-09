package org.example;

import com.sun.xml.internal.bind.v2.runtime.output.StAXExStreamWriterOutput;
import org.example.slotmachine.SYMBOL;
import org.example.slotmachine.SlotMachine;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //making the slot machine
        SlotMachine slotMachine = new SlotMachine("Test Machine", 3, 45);
        slotMachine.setupSymbols(new SYMBOL[]{SYMBOL.CHERRY, SYMBOL.BELL, SYMBOL.LEMON, SYMBOL.PLUM, SYMBOL.ORANGE});
        int timeWon = 0 ;
        //this is the tester code to see if slot machine is working or not
        for(int i = 0 ; i<125 ; ++i) {
            String result = slotMachine.spin();
            if(result.equals("WON THE JACKPOT $"+slotMachine.getJackpot())) timeWon+=1;
            System.out.println(result);
        }
        System.out.println(timeWon);
    }
}
