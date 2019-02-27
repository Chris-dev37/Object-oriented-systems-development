/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newtabletennismatchsystem_;


import java.util.TimerTask;

/**
 *
 * @author chris
 */
public class printStats extends TimerTask {
    
    //////
    // this class is used to print team stats every 100 seconds.
    //////
    
    int uweMatchesPlayed, uweMatchesWon, uweSetsWon, pageMatchesPlayed, pageMatchesWon, pageSetsWon, filtonMatchesPlayed, filtonMatchesWon, filtonSetsWon, kccMatchesPlayed, kccMatchesWon, kccSetsWon;
    
    public void run(int uweMatchesPlayed,int uweMatchesWon,int uweSetsWon,int pageMatchesPlayed,int pageMatchesWon,int pageSetsWon,int filtonMatchesPlayed,int filtonMatchesWon,int filtonSetsWon,int kccMatchesPlayed,int kccMatchesWon,int kccSetsWon){
        System.out.println("UWE: Matches Played: " + uweMatchesPlayed + ", Matches Won: "+ uweMatchesWon +", Sets Won: "+ uweSetsWon +
                "\nPage: Matches Played: " + pageMatchesPlayed + ", Matches Won: "+ pageMatchesWon +", Sets Won: "+ pageSetsWon + 
                "\nFilton: Matches Played: " + filtonMatchesPlayed + ", Matches Won: "+ filtonMatchesWon +", Sets Won: "+ filtonSetsWon +
                "\nKCC: Matches Played: " + kccMatchesPlayed + ", Matches Won: "+ kccMatchesWon +", Sets Won: "+ kccSetsWon +"\n"
            ); 
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
    }
        
}
