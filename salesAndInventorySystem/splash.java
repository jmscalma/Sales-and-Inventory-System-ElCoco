/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salesAndInventorySystem;

public class splash {
    
    public static void main(String[] args){
        
        SplashScreen sc = new SplashScreen();
        sc.setVisible(true);
        
        Login l = new Login();
        
        try{
            for(int i = 0 ; i <= 100; i++){
                Thread.sleep(40);
                sc.progress.setText(Integer.toString(i) + "%");
                sc.progressBar.setValue(i);
                
                if(i == 100){
                    sc.setVisible(false);
                    l.setVisible(true);
                }
            }
        }catch(Exception e){
            
        }
    }
    
}
